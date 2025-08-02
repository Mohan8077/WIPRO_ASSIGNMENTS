package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String accno = request.getParameter("accno");
        String password = request.getParameter("password");

        // Dummy credentials check
        if(accno.equals("12345") && password.equals("pass123")) {
            HttpSession session = request.getSession();
            session.setAttribute("name", "Manikumar");
            session.setAttribute("balance", 5000);

            response.sendRedirect("balance");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Invalid account number or password!</h3>");
            out.println("<a href='login.html'>Try again</a>");
            out.println("</body></html>");
        }
    }
}
