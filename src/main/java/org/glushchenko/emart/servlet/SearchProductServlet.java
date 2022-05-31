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
        name = "searchproductservlet",
        urlPatterns = "/SearchProduct"
)
public class SearchProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stockNumber = request.getParameter("StockNumber");
        String categoryName = request.getParameter("Category");
        String modelNumber = request.getParameter("ModelNumber");

        ProductService productService = new ProductService();
        List<Product> products;
        if (stockNumber != null) {
            products = productService.getProductsByStock(categoryName, stockNumber);
        } else {
            products = productService.getProductsByModel(categoryName, modelNumber);
        }

        if (products.isEmpty()) {
            RequestDispatcher view = request.getRequestDispatcher("emptySearch.jsp");
            view.forward(request, response);
        }
        else {
            List<String> productStrings = new ArrayList<>();
            for (Product product : products) {
                productStrings.add(product.toString());
            }

            request.setAttribute("products", productStrings);
            RequestDispatcher view = request.getRequestDispatcher("products.jsp");

            view.forward(request, response);
        }
    }
}
