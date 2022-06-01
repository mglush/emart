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
        String stockNumber = request.getParameter("stockNumber");
        String categoryName = request.getParameter("category");
        String modelNumber = request.getParameter("modelNumber");
        String manufacturer = request.getParameter("manufacturer");
        String description = request.getParameter("description");
        String descriptionValue = request.getParameter("descriptionValue");
        String compatibleStockNumber = request.getParameter("compatibleStockNumber");

        // format the inputs for query entries
        if (stockNumber != null && stockNumber.length() > 0) {
            stockNumber = stockNumber.toUpperCase();
        }
        if (manufacturer != null && manufacturer.length() > 0) {
            manufacturer = manufacturer.substring(0, 1).toUpperCase() + manufacturer.substring(1).toLowerCase();
        }
        if (description != null && description.length() > 0) {
            description = description.substring(0, 1).toUpperCase() + description.substring(1).toLowerCase();
        }

        System.out.println("customer cookie: " + request.getSession().getAttribute("customer"));
        System.out.println("manager cookie: " + request.getSession().getAttribute("manager"));

        if (request.getSession().getAttribute("customer") == null) {
            RequestDispatcher view = request.getRequestDispatcher("index.html");
            view.forward(request, response);
        } else {
            ProductService productService = new ProductService();

            // set session attributes of current products to false.
            List<String> productIDs = productService.getAllProductIDs();
            for (String productID : productIDs) {
                request.getSession().setAttribute(productID, "false");
            }

            // this will hold the result of the search query.
            List<Product> products;

            if (compatibleStockNumber != null) {
                products = productService.getCompatibleProducts(compatibleStockNumber);
            } else {
                if (manufacturer.isEmpty() && stockNumber.isEmpty() && modelNumber.isEmpty() && description.isEmpty()) {
                    products = productService.getProductsByCategory(categoryName);
                } else {
                    products = productService.getProducts(stockNumber, categoryName, modelNumber, manufacturer, description, descriptionValue);
                }
            }

            if (products.isEmpty()) {
                RequestDispatcher view = request.getRequestDispatcher("emptySearch.jsp");
                view.forward(request, response);
            } else {
                List<String> productStrings = new ArrayList<>();

                for (Product product : products) {
                    request.getSession().setAttribute(product.getId(), "true");
                    productStrings.add(product.toString());
                }

                request.setAttribute("products", productStrings);
                request.getSession().setAttribute("products", productStrings);

                RequestDispatcher view = request.getRequestDispatcher("products.jsp");
                view.forward(request, response);
            }
        }
    }
}