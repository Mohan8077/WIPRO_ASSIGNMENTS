package controller;

import model.Book;
import dao.BookDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BookServlet extends HttpServlet {
    private BookDAO bookDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        bookDAO = new BookDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("save".equals(action)) {
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            double price = 0.0;
            try {
                price = Double.parseDouble(request.getParameter("price"));
            } catch (NumberFormatException e) {
                price = 0.0;
            }

            Book newBook = new Book();
            newBook.setTitle(title);
            newBook.setAuthor(author);
            newBook.setPrice(price);

            bookDAO.insertBook(newBook);

            // 🔁 Redirect back to "Add New Book" page after saving
            response.sendRedirect("book?action=new");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("new".equals(action)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("add-book.jsp");
            dispatcher.forward(request, response);

        } else if ("list".equals(action)) {
            List<Book> listBooks = bookDAO.selectAllBooks();
            request.setAttribute("listBooks", listBooks);
            RequestDispatcher dispatcher = request.getRequestDispatcher("list-books.jsp");
            dispatcher.forward(request, response);

        } else {
            response.sendRedirect("BookServlet?action=list");
        }
    }
}
