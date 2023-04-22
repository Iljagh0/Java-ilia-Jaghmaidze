package com.exam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post")
public class PostServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String INSERT_POST_SQL = "INSERT INTO posts (title, content, author, created_at) VALUES (?, ?, ?, ?)";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String author = request.getParameter("author");
        LocalDateTime createdAt = LocalDateTime.now();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "username", "password");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_POST_SQL)) {

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, content);
            preparedStatement.setString(3, author);
            preparedStatement.setObject(4, createdAt);
            preparedStatement.executeUpdate();

            response.sendRedirect("index.jsp"); // redirect to home page after successful submission

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
