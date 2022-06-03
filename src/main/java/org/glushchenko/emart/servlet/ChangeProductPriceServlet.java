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

@WebServlet(
        name = "changeproductpriceservlet",
        urlPatterns = "/ChangeProductPrice"
)
public class ChangeProductPriceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("manager").toString().equals("false")) {
            RequestDispatcher view = request.getRequestDispatcher("home.jsp");
            view.forward(request, response);
        } else {
            String productID = request.getParameter("changeThisProduct").toString();
            String newPrice = request.getParameter("changeToThisPrice").toString();

            ProductService productService = new ProductService();
            Product previousProduct = productService.getProducts(productID, "All", "", "", "", "").get(0);
            System.out.println("Product before: " + previousProduct.toString());

            productService.changeProductPrice(productID, newPrice);

            Product product = productService.getProducts(productID, "All", "", "", "", "").get(0);
            System.out.println("Product after: " + product.toString());

            if (product != null) {
                request.getSession().setAttribute("previousProduct", previousProduct.toString());
                request.getSession().setAttribute("productToPrint", product.toString());
                RequestDispatcher view = request.getRequestDispatcher("productPriceChange.jsp");
                view.forward(request, response);
            } else {
                RequestDispatcher view = request.getRequestDispatcher("noSuchProduct.jsp");
                view.forward(request, response);
            }
        }
    }
}
