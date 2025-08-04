package com.student;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/studentResult")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET request
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to the form page (e.g., studentForm.jsp)
        response.sendRedirect("studentform.jsp");
    }

    // Handle POST request
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("studentName");
        int marks = Integer.parseInt(request.getParameter("studentMarks"));

        request.setAttribute("name", name);
        request.setAttribute("marks", marks);

        if (marks >= 40) {
            RequestDispatcher rd = request.getRequestDispatcher("studentpass.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("studentfail.jsp");
            rd.forward(request, response);
        }
    }
}
