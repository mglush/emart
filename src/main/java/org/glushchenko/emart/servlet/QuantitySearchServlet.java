package org.glushchenko.emart.servlet;

import org.glushchenko.emart.dto.ShippingNotice;
import org.glushchenko.emart.service.ShippingService;
import org.glushchenko.emart.dto.Inventory;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "QuantitySearchServlet",
        urlPatterns = "/QuantitySearch"
)

public class QuantitySearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("testing servlet");


        String stockNumber = request.getParameter("stockNumber");
//        //System.out.println("accessed");
        if (stockNumber != null && stockNumber.length() > 0) {
            stockNumber = stockNumber.toUpperCase();
        }

        ShippingService shippingService = new ShippingService();
        int inventoryqty = -1;
        inventoryqty = shippingService.checkInventory(stockNumber);
        // System.out.println("item quantity is: " + inventoryqty);
        request.setAttribute("itemquantity", inventoryqty);
        request.getSession().setAttribute("itemquantity", inventoryqty);

        RequestDispatcher view = request.getRequestDispatcher("quantity.jsp");
        view.forward(request, response);
////        if(stockNumber!=null){
////            inventoryqty = shippingService.checkInventory(stockNumber);
////        }
//
//

//        if (request.getSession().getAttribute("itemquantity") == null) {
//            RequestDispatcher view = request.getRequestDispatcher("index.html");
//            view.forward(request, response);
//        }
//       // if(inventoryqty == -1){
//            RequestDispatcher view = request.getRequestDispatcher("emart/quantity.jsp");
//            view.forward(request, response);
//
//       // }
////        else{
////            RequestDispatchew view = request.getRequestDispatcher("quantity.jsp");
////        }

    }
}
