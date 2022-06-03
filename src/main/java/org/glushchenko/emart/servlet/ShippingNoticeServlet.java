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
        name = "ShippingNoticeServlet",
        urlPatterns = "/ShippingNotice"
)

public class ShippingNoticeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShippingService noticeService = new ShippingService();
        ArrayList<ShippingNotice> notices = noticeService.processNotice();
        if(notices.isEmpty()){
            //no current shipping notices
            request.setAttribute("emptynotices", "true");
            request.getSession().setAttribute("emptynotices", "true");
            RequestDispatcher view = request.getRequestDispatcher("shippingNotice.jsp");
            view.forward(request, response);
        } else {
            ArrayList<String> noticeStrings = new ArrayList<>();
            for(ShippingNotice notice: notices){
                noticeStrings.add(notice.toString());
            }

            request.setAttribute("emptynotices", "false");
            request.getSession().setAttribute("emptynotices", "false");
            request.setAttribute("notices", noticeStrings);
            request.getSession().setAttribute("notices", noticeStrings);

            RequestDispatcher view = request.getRequestDispatcher("shippingNotice.jsp");
            view.forward(request, response);
        }



    }
}
