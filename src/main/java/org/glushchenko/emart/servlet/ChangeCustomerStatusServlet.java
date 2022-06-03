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
        name = "changecustomerstatusservlet",
        urlPatterns = "/ChangeCustomerStatus"
)
public class ChangeCustomerStatusServlet extends HttpServlet {

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
            String customerID = request.getParameter("changeThisCustomer").toString();
            String newStatus = request.getParameter("changeToThisStatus").toString();
            CustomerService customerService = new CustomerService();

            Customer previousCustomer = customerService.getCustomerByID(customerID);
            System.out.println("Customer before: " + previousCustomer.toString());

            customerService.changeCustomerStatus(customerID, newStatus);

            Customer customer = customerService.getCustomerByID(customerID);
            System.out.println("Customer after: " + customer.toString());

            if (customer != null) {
                request.getSession().setAttribute("previousCustomer", previousCustomer.toString());
                request.getSession().setAttribute("customerToPrint", customer.toString());
                RequestDispatcher view = request.getRequestDispatcher("customerStatusChange.jsp");
                view.forward(request, response);
            } else {
                RequestDispatcher view = request.getRequestDispatcher("noSuchCustomer.jsp");
                view.forward(request, response);
            }
        }
    }
}
