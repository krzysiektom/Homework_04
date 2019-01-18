package pl.coderslab;

import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static UserDao instance;
    private final String dbName = "user";
    private final String URL = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8";
    private final String USER = "root";
    private final String PASSWORD = "coderslab";

    private UserDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public void save(User user) {
        //zapis do bazy danych
        //1. stworzenie polaczenia
        //2. z polaczenia pobieramy preparedStatement
        //3. zapytanie (INSERT) + setInt(index,value)/setString(index,value)...
        //4. executeUpdate()<- TYLKO TA FUNKCJA MA UPRAWNIENIA DO insertów/updatetów/delete
        //5. zamykamy połączenie


        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (user.getId() == 0) {
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO users(email,name) VALUES(?,?)");
                stmt.setString(1, user.getEmail());
                stmt.setString(2, user.getName());
                stmt.executeUpdate();
            } else {
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE users SET email=?, name=? where id = ?");
                stmt.setString(1, user.getEmail());
                stmt.setString(2, user.getName());
                stmt.setInt(3, user.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(int id) {
        try (Connection conn = DriverManager.getConnection(URL,
                USER, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM users WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL,
                USER, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM users");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String name = rs.getString("name");
                User b = new User(id, email, name);
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
