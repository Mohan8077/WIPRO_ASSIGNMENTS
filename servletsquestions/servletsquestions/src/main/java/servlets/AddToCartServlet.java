package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String item = request.getParameter("item");

        // Store item in a cookie
        Cookie cookie = new Cookie("item_" + System.currentTimeMillis(), item);
        cookie.setMaxAge(60 * 60); // 1 hour
        response.addCookie(cookie);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h3>Item '" + item + "' added to cart.</h3>");
        out.println("<a href='cart.html'>Back to Cart</a><br>");
        out.println("<a href='viewCart'>View Cart</a>");
        out.println("</body></html>");
    }
}
