package org.glushchenko.emart.servlet;

import org.glushchenko.emart.dto.Order;
import org.glushchenko.emart.dto.Product;
import org.glushchenko.emart.service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "rerunorderservlet",
        urlPatterns = "/RerunOrder"
)
public class RerunOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("customer") == null) {
            RequestDispatcher view = request.getRequestDispatcher("index.html");
            view.forward(request, response);
        } else {
            String customerID = request.getSession().getAttribute("customer").toString();
            String orderID = request.getParameter("orderToRun");

            // make sure order exists and was confirmed before rerunning it.
            OrderService orderService = new OrderService();
            Boolean flag = orderService.checkOrderConfirmation(orderID);
            if (flag) {
                // rerun order
                Order order = orderService.createNewOrder(customerID);
                List<Product> products = orderService.displayOrderLinesContents(orderID);
                int count;

                for (Product product : products) {
                    count = orderService.getProductCountInOrder(orderID, product.getId());
                    orderService.addProductToOrder(order.getId(), product.getId(), Integer.toString(count));
                }

                Order final_order = orderService.confirmOrder(order.getId(), customerID);

                if (final_order.getChecked_out_at() != null) {
                    products = orderService.displayOrderLinesContents(final_order.getId());

                    List<String> productStrings = new ArrayList<>();
                    for (Product product : products) {
                        productStrings.add(product.partialToString());
                    }

                    request.getSession().setAttribute("order", final_order.getId());
                    request.getSession().setAttribute("cart", productStrings);
                    request.getSession().setAttribute("subtotal", orderService.getOrderSubtotal(final_order.getId()).toString());
                    request.getSession().setAttribute("discount", final_order.getDiscount().toString());
                    request.getSession().setAttribute("shipping", final_order.getShipping_and_handling().toString());
                    request.getSession().setAttribute("total", final_order.getTotal().toString());

                    if (Float.valueOf(final_order.getTotal()) > 0) {
                        RequestDispatcher view = request.getRequestDispatcher("orderConfirmation.jsp");
                        view.forward(request, response);
                    } else {
                        RequestDispatcher view = request.getRequestDispatcher("orderFailed.jsp");
                        view.forward(request, response);
                    }
                } else {
                    RequestDispatcher view = request.getRequestDispatcher("orderFailed.jsp");
                    view.forward(request, response);
                }
            } else {
                RequestDispatcher view = request.getRequestDispatcher("noSuchOrder.jsp");
                view.forward(request, response);
            }
        }
    }
}