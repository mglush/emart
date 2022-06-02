package org.glushchenko.emart.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "managestoreservlet",
        urlPatterns = "/ManageStore"
)
public class ManageStoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("SUCCESS REACHING /MANAGE STORE ENDPOINT");

        RequestDispatcher view = request.getRequestDispatcher("manager.html");
        view.forward(request, response);

        System.out.println("SUCCESS FORWARDING REQUEST TO manager.html WEBPAGE");
    }
}
