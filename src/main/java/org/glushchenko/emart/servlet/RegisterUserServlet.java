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
        name = "registeruserservlet",
        urlPatterns = "/RegisterUser"
)
public class RegisterUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("psw");
        String name = request.getParameter("uname");
        String email = request.getParameter("uemail");
        String address = request.getParameter("uaddress");

        CustomerService customerService = new CustomerService();
        Customer customer = customerService.createCustomer(password, password, name, email, address);

        System.out.println("Successfully created a customer in the database:");
        String customerString = customer.toString();
        System.out.println(customerString);

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