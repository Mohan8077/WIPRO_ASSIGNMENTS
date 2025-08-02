package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String selected = request.getParameter("product"); // Format: "Pen-10"
        String[] parts = selected.split("-");
        String name = parts[0];
        String price = parts[1];

        out.println("<html><body>");
        out.println("<h2>Enter Quantity for: " + name + "</h2>");
        out.println("<form action='orderServlet' method='post'>");
        out.println("Quantity: <input type='number' name='quantity'><br><br>");
        out.println("<input type='hidden' name='product' value='" + name + "'>");
        out.println("<input type='hidden' name='price' value='" + price + "'>");
        out.println("<input type='submit' value='Place Order'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
