package tr.toko.buku.controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import tr.toko.buku.model.User;

public class UserController {

    private Koneksi koneksi;

    // Constructor to initialize Koneksi
    public UserController() {
        koneksi = new Koneksi();
        koneksi.confiq(); // Establish connection
    }

    // CREATE: Add a new user
    public boolean createUser(User user) {
        String sql = "INSERT INTO user (username, password, isAdmin) VALUES (?, ?, ?)";
        try (PreparedStatement statement = koneksi.con.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setBoolean(3, user.isIsAdmin());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error during user creation: " + e.getMessage());
            return false;
        }
    }
    // READ: Get all users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (PreparedStatement statement = koneksi.con.prepareStatement(sql);ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getBoolean("isAdmin"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching users: " + e.getMessage());
        }
        return users;
    }
    // READ: Get a user by ID
    public User getUserById(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        try (PreparedStatement statement = koneksi.con.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("nama"));
                    user.setPassword(resultSet.getString("password"));
                    user.setIsAdmin(resultSet.getBoolean("isAdmin"));
                    return user;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching user by ID: " + e.getMessage());
        }
        return null;
    }

    // UPDATE: Update a user
    //G PERLU

    // DELETE: Delete a user by ID
    // G PERLU
}
