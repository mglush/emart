package org.glushchenko.emart.servlet;

import org.glushchenko.emart.dto.Product;
import org.glushchenko.emart.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "displayproductservlet",
        urlPatterns = "/DisplayProduct"
)
public class DisplayProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // can't use store unless you're logged in!
        if (request.getSession().getAttribute("customer") == null) {
            RequestDispatcher view = request.getRequestDispatcher("index.html");
            view.forward(request, response);
        } else {
            String currStockNumber = request.getParameter("checkDetailsButton").toString();

            ProductService productService = new ProductService();
            List<Product> products = productService.getProducts(currStockNumber, "All", "", "", "", "");
            Product product = products.get(0);

            request.getSession().setAttribute("displayID", product.getId());
            request.getSession().setAttribute("displayCategory", product.getCategoryName());
            request.getSession().setAttribute("displayModelNumber", product.getModelNumber());
            request.getSession().setAttribute("displayWarranty", product.getWarranty());
            request.getSession().setAttribute("displayPrice", product.getPrice());
            request.getSession().setAttribute("product", product.toString());

            System.out.println("current product cookie: " + currStockNumber);

            RequestDispatcher view = request.getRequestDispatcher("product.jsp");
            view.forward(request, response);
        }
    }
}