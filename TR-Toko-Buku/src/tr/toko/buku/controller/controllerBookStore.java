package tr.toko.buku.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import tr.toko.buku.model.Book;
import tr.toko.buku.model.BookStoreInterface;
import tr.toko.buku.model.Keranjang;
import tr.toko.buku.model.Transaction;
import javax.swing.table.DefaultTableModel;
import com.google.gson.Gson;
@SuppressWarnings("unused")

public class controllerBookStore {



    public Statement stm;
    public ResultSet res;
    public String sql;
    private Gson gson = new Gson();
    private Koneksi koneksi;
    
    DefaultTableModel dtm = new DefaultTableModel();

    public controllerBookStore() {
        Koneksi db = new Koneksi();
        db.confiq();
        this.stm = db.stm;
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
    
}


