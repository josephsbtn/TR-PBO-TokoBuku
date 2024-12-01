package tr.toko.buku.controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import tr.toko.buku.model.User;
import tr.toko.buku.model.Book;
import tr.toko.buku.model.Keranjang;
import tr.toko.buku.model.Transaction;
import com.google.gson.Gson;

public class UserController {

    private Koneksi koneksi;
    private Transaction transaction = new Transaction();
    private Gson gson = new Gson();

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
    
    public boolean addToCart(int idUser, Book buku, int quantity) {
    String selectQuery = "SELECT BukuDibeli FROM transaksi WHERE idUser = ? AND payment = 0";
    String insertQuery = "INSERT INTO transaksi (idUser, BukuDibeli) VALUES (?, ?)";
    String updateQuery = "UPDATE transaksi SET BukuDibeli = ? WHERE idUser = ? AND payment = 0";

    try (PreparedStatement selectStmt = koneksi.con.prepareStatement(selectQuery)) {
        // Check if a transaction exists for the user
        selectStmt.setInt(1, idUser);
        try (ResultSet result = selectStmt.executeQuery()) {
            ArrayList<Keranjang> keranjangList;

            if (result.next()) {
                // Existing transaction: Get current cart and update it
                String ygDibeli = result.getString("BukuDibeli");
                keranjangList = gson.fromJson(ygDibeli, ArrayList.class);
            } else {
                // New transaction: Initialize cart
                keranjangList = new ArrayList<>();
            }

            // Add the new item to the cart
            Keranjang newItem = new Keranjang(buku, quantity);
            keranjangList.add(newItem);
            String updatedCart = gson.toJson(keranjangList);

            if (result.next()) {
                // Update existing transaction
                try (PreparedStatement updateStmt = koneksi.con.prepareStatement(updateQuery)) {
                    updateStmt.setString(1, updatedCart);
                    updateStmt.setInt(2, idUser);
                    updateStmt.executeUpdate();
                }
            } else {
                // Insert new transaction
                try (PreparedStatement insertStmt = koneksi.con.prepareStatement(insertQuery)) {
                    insertStmt.setInt(1, idUser);
                    insertStmt.setString(2, updatedCart);
                    insertStmt.executeUpdate();
                }
            }
        }
        return true;

    } catch (SQLException e) {
        System.out.println("Something went wrong: " + e.getMessage());
        return false;
    }
}


    // UPDATE: Update a user
    //G PERLU

    // DELETE: Delete a user by ID
    // G PERLU
}
