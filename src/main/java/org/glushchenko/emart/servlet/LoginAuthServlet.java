package org.glushchenko.emart.servlet;

import org.glushchenko.emart.dto.Customer;
import org.glushchenko.emart.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "loginauthservlet",
        urlPatterns = "/LoginAuth"
)
public class LoginAuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("uemail");
        String password = request.getParameter("psw");

        System.out.println("email: " + email + "password: " + password);

        CustomerService customerService = new CustomerService();
        Customer customer = customerService.authenticateLogin(email, password);

        System.out.println(customer.toString());
        if (customer.getId() == null) {
            RequestDispatcher view = request.getRequestDispatcher("register.html");
            view.forward(request, response);
        }
        else {
            String customerString = customer.toString();
            request.setAttribute("customer", customerString);
            request.setAttribute("manager", "false");
            RequestDispatcher view = request.getRequestDispatcher("index.html");
            view.forward(request, response);
        }
    }
}
