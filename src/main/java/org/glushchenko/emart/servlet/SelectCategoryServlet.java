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
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "selectcategoryservlet",
        urlPatterns = "/SelectCategory"
)
public class SelectCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String categoryName = request.getParameter("Name");

        ProductService productService = new ProductService();

        List<Product> products = productService.getProducts(categoryName);
        List<String> productStrings = new ArrayList<>();
        for (Product product : products) {
            productStrings.add(product.toString());
        }

        request.setAttribute("products", productStrings);
        RequestDispatcher view = request.getRequestDispatcher("products.jsp");

        view.forward(request, response);
    }
}
