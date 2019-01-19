package pl.coderslab;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestBookDao {
    private static GuestBookDao instance;
    private final String dbName = "guestbook";
    private final String URL = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8";
    private final String USER = "root";
    private final String PASSWORD = "coderslab";

    private GuestBookDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static GuestBookDao getInstance() {
        if (instance == null) {
            instance = new GuestBookDao();
        }
        return instance;
    }

    public void save(GuestBook guestBook) {
        //zapis do bazy danych
        //1. stworzenie polaczenia
        //2. z polaczenia pobieramy preparedStatement
        //3. zapytanie (INSERT) + setInt(index,value)/setString(index,value)...
        //4. executeUpdate()<- TYLKO TA FUNKCJA MA UPRAWNIENIA DO insertów/updatetów/delete
        //5. zamykamy połączenie


        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (guestBook.getId() == 0) {
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO Guestbooks(name,text) VALUES(?,?)");
                stmt.setString(1, guestBook.getName());
                stmt.setString(2, guestBook.getText());
                stmt.executeUpdate();
            } else {
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE Guestbooks SET name=?, text=? where id = ?");
                stmt.setString(1, guestBook.getName());
                stmt.setString(2, guestBook.getText());
                stmt.setInt(3, guestBook.getId());
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
                    "DELETE FROM Guestbooks WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<GuestBook> findAll() {
        List<GuestBook> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL,
                USER, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM Guestbooks");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String text = rs.getString("text");
                GuestBook guestBook = new GuestBook(id, name,text);
                list.add(guestBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
