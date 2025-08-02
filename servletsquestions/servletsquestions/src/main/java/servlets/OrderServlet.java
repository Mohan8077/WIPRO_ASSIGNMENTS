package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String product = request.getParameter("product");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int total = price * quantity;

        out.println("<html><body>");
        out.println("<h2>Order Receipt</h2>");
        out.println("<p><b>Product:</b> " + product + "</p>");
        out.println("<p><b>Price:</b> ₹" + price + "</p>");
        out.println("<p><b>Quantity:</b> " + quantity + "</p>");
        out.println("<p><b>Total:</b> ₹" + total + "</p>");
        out.println("</body></html>");
    }
}
