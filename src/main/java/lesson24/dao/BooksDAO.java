package lesson24.dao;

import lesson24.dto.Books;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BooksDAO {

    private static final Properties DB_SETTINGS = new Properties();

    static {
        try {
            DB_SETTINGS.load(ClassLoader.getSystemResourceAsStream("project.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillBooks(List<Books> books) {
        try (Connection connection = establishConnection()) {
            PreparedStatement pr = connection.prepareStatement(
                    """
                            INSERT INTO books (id, ISBN, title, link,  pages, attributes)
                            values(?,?,?,?,?,?)
                            """);
            for (int i = 0; i < books.size(); i++) {
                if (!isExist(books.get(i).getId())) {
                    pr.setInt(1, books.get(i).getId());
                    pr.setLong(2, books.get(i).getIsbn());
                    pr.setString(3, books.get(i).getTitle());
                    pr.setString(4, books.get(i).getLink());
                    pr.setInt(5, books.get(i).getPages());
                    pr.setString(6, books.get(i).getAttributes());
                    pr.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int id) {
        try (Connection connection = establishConnection()) {
            PreparedStatement pr = connection.prepareStatement(
                    """
                                DELETE FROM Books 
                                WHERE id = ?
                            """
            );
            pr.setInt(1, id);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Books> findById(int id) {
        List<Books> books = new ArrayList<>();
        try (Connection connection = establishConnection()) {
            PreparedStatement pr = connection.prepareStatement(
                    """
                            SELECT *FROM books
                            WHERE id = ?
                            """
            );
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Books book = new Books(rs.getInt("id"),
                        rs.getLong("ISBN"), rs.getString("title"),
                        rs.getString("link"), rs.getInt("pages"),
                        rs.getString("attributes"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    private boolean isExist(int id) throws SQLException {
        Connection connection = establishConnection();
        boolean result;
        PreparedStatement pr = connection.prepareStatement(
                """
                        SELECT id FROM books 
                        WHERE id = ?
                        """);
        pr.setInt(1, id);
        ResultSet rs = pr.executeQuery();
        result = rs.next();
        connection.close();
        return result;
    }

    private Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                DB_SETTINGS.getProperty("jdbc.url"),
                DB_SETTINGS.getProperty("db.login"),
                DB_SETTINGS.getProperty("db.password")
        );
        return connection;
    }

}
