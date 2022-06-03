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
        name = "changepricingpolicyservlet",
        urlPatterns = "/ChangePricingPolicy"
)
public class ChangePricingPolicyServlet extends HttpServlet {

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
            String policyName = request.getParameter("changeThisPolicy").toString();
            String newValue = request.getParameter("changeToThisValue").toString();

            OrderService orderService = new OrderService();
            String previousPolicy = orderService.getPricingPolicyByName(policyName);
            System.out.println("Policy before: " + previousPolicy);

            orderService.changePricingPolicy(policyName, newValue);

            String policy = orderService.getPricingPolicyByName(policyName);
            System.out.println("Policy after: " + policy);

            if (!policy.isEmpty()) {
                request.getSession().setAttribute("previousPolicy", previousPolicy);
                request.getSession().setAttribute("policyToPrint", policy);
                RequestDispatcher view = request.getRequestDispatcher("policyValueChange.jsp");
                view.forward(request, response);
            } else {
                RequestDispatcher view = request.getRequestDispatcher("noSuchPolicy.jsp");
                view.forward(request, response);
            }
        }
    }
}
