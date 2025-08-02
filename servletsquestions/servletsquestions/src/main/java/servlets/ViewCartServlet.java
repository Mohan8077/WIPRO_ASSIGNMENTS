package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        out.println("<html><body>");
        out.println("<h2>Your Shopping Cart:</h2>");

        if (cookies != null) {
            boolean found = false;
            for (Cookie cookie : cookies) {
                if (cookie.getName().startsWith("item_")) {
                    out.println("<li>" + cookie.getValue() + "</li>");
                    found = true;
                }
            }
            if (!found) {
                out.println("<p>Cart is empty.</p>");
            }
        } else {
            out.println("<p>No items in cart.</p>");
        }

        out.println("<br><a href='cart.html'>Back to Cart</a>");
        out.println("</body></html>");
    }
}
