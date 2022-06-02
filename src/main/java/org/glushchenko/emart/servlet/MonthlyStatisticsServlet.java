package org.glushchenko.emart.servlet;

import org.glushchenko.emart.service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "monthlystatisticsservlet",
        urlPatterns = "/MonthlyStatistics"
)
public class MonthlyStatisticsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("manager") == null ||
                request.getSession().getAttribute("manager") == "false") {
            RequestDispatcher view = request.getRequestDispatcher("index.html");
            view.forward(request, response);
        } else {
            OrderService orderService = new OrderService();
            request.getSession().setAttribute("monthlyProductSales", orderService.getMonthlySalesPerProduct());
            request.getSession().setAttribute("monthlyCategorySales", orderService.getMonthlySalesPerCategory());
            request.getSession().setAttribute("customerMostPurchase", orderService.getCustomerWithMostPurchase());

            System.out.println("by product: " + request.getSession().getAttribute("monthlyProductSales").toString());
            System.out.println("by category: " + request.getSession().getAttribute("monthlyCategorySales").toString());
            System.out.println("customer: " + request.getSession().getAttribute("customerMostPurchase").toString());

            RequestDispatcher view = request.getRequestDispatcher("displayMonthlyStatistics.jsp");
            view.forward(request, response);
        }
    }
}