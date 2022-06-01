package org.glushchenko.emart.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "displayorderlineservlet",
        urlPatterns = "/OrderLine"
)
public class DisplayOrderLineServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Successfully reached the order line servlet ayo.");
        if (request.getSession().getAttribute("customer") == null) {
            RequestDispatcher view = request.getRequestDispatcher("index.html");
            view.forward(request, response);
        }
    }
}