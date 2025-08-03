package dao;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // ✅ Updated JDBC credentials
    private String jdbcURL = "jdbc:mysql://localhost:3306/bookdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Mohan@8077";

    // ✅ SQL queries
    private static final String INSERT_BOOK = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";
    private static final String UPDATE_BOOK = "UPDATE books SET title = ?, author = ?, price = ? WHERE id = ?";
    private static final String DELETE_BOOK = "DELETE FROM books WHERE id = ?";

    // ✅ Get DB connection
    protected Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // ✅ Create - insert a new book
    public void insertBook(Book book) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_BOOK)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setDouble(3, book.getPrice());
            stmt.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // ✅ Read - select book by ID
    public Book selectBook(int id) {
        Book book = null;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BOOK_BY_ID)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                book = new Book(id, title, author, price);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return book;
    }

    // ✅ Read - select all books
    public List<Book> selectAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_BOOKS);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");

                books.add(new Book(id, title, author, price));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return books;
    }

    // ✅ Update - update a book
    public boolean updateBook(Book book) {
        boolean rowUpdated = false;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_BOOK)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setDouble(3, book.getPrice());
            stmt.setInt(4, book.getId());

            rowUpdated = stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    // ✅ Delete - delete a book
    public boolean deleteBook(int id) {
        boolean rowDeleted = false;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_BOOK)) {

            stmt.setInt(1, id);
            rowDeleted = stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    // ✅ Optional: print SQL exception
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace();
                System.err.println("SQLState: " + ((SQLException)e).getSQLState());
                System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
            }
        }
    }
}
