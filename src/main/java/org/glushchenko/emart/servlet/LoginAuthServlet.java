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

        CustomerService customerService = new CustomerService();
        Customer customer = customerService.authenticateLogin(email, password);

        System.out.println("Login Authentication:" + customer.toString());

        if (customer.getId() == null) {
            RequestDispatcher view = request.getRequestDispatcher("register.html");
            view.forward(request, response);
        } else {
            request.getSession().setAttribute("customer", customer.getId());
            if (customer.getCustomerType() == 2) {
                request.getSession().setAttribute("manager", "true");
            } else {
                request.getSession().setAttribute("manager", "false");
            }
            RequestDispatcher view = request.getRequestDispatcher("home.jsp");
            view.forward(request, response);
        }
    }
}
