package com.micronautbook.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private final Connection connection;
    public BookRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Book> findAll() throws SQLException {
        String sql = "SELECT * FROM book";
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            books.add(new Book(resultSet.getLong("id"), resultSet.getString("title")));
        }
        return books;
    }
}
