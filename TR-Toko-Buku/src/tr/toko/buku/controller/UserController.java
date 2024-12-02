package tr.toko.buku.controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import tr.toko.buku.model.User;
import tr.toko.buku.model.Book;
import tr.toko.buku.model.Keranjang;
import tr.toko.buku.model.Transaction;
import com.google.gson.Gson;
import tr.toko.buku.model.User;


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
            statement.executeUpdate();
            return true;
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
    
    
    //LOGIN
    public boolean login(String username, String password){
        
         User user = new User();
         user.setUsername(username);
         user.setPassword(password);
         String sql = "SELECT * FROM user WHERE username = ? AND password = ? ";
        try(PreparedStatement statement = koneksi.con.prepareStatement(sql)) { 
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                   return true;
                }
                else{
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return false;
        }
    }
    
    //ADD BOOK TO CART
    public boolean addToCart(int idUser, Book buku, int quantity) {
    String selectQuery = "SELECT BukuDibeli FROM transaksi WHERE idUser = ? AND payment = 0";
    String insertQuery = "INSERT INTO transaksi (idUser, BukuDibeli) VALUES (?, ?)";
    String updateQuery = "UPDATE transaksi SET BukuDibeli = ? WHERE idUser = ? AND payment = 0";

    try (PreparedStatement selectStmt = koneksi.con.prepareStatement(selectQuery)) {
        selectStmt.setInt(1, idUser);
        try (ResultSet result = selectStmt.executeQuery()) {
            ArrayList<Keranjang> keranjangList;
            if (result.next()) {
                String ygDibeli = result.getString("BukuDibeli");
                keranjangList = gson.fromJson(ygDibeli, ArrayList.class);
            } else {
                keranjangList = new ArrayList<>();
            }
            
            Keranjang newItem = new Keranjang(buku, quantity);
            keranjangList.add(newItem);
            String updatedCart = gson.toJson(keranjangList);

            if (result.next()) {   
                try (PreparedStatement updateStmt = koneksi.con.prepareStatement(updateQuery)) {
                    updateStmt.setString(1, updatedCart);
                    updateStmt.setInt(2, idUser);
                    updateStmt.executeUpdate();
                }
            } else {
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

 // UPDATE: Update a user by ID
public boolean updateUser(User user) {
    String sql = "UPDATE user SET username = ?, password = ?, isAdmin = ? WHERE id = ?";
    try (PreparedStatement statement = koneksi.con.prepareStatement(sql)) {
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setBoolean(3, user.isIsAdmin());
        statement.setInt(4, user.getId());
        statement.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println("Error during user update: " + e.getMessage());
        return false;
    }
}

public boolean deleteUser(int id) {
    String sql = "DELETE FROM user WHERE id = ?";
    try (PreparedStatement statement = koneksi.con.prepareStatement(sql)) {
        statement.setInt(1, id);
        statement.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println("Error during user deletion: " + e.getMessage());
        return false;
    }
}




}
