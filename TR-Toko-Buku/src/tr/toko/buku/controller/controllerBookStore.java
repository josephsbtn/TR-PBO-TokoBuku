package tr.toko.buku.controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import tr.toko.buku.model.Book;
import tr.toko.buku.model.BookStoreInterface;
import tr.toko.buku.model.Transaction;
import javax.swing.table.DefaultTableModel;
@SuppressWarnings("unused")

public class controllerBookStore {



    public Statement stm;
    public ResultSet res;
    public String sql;
    private Koneksi koneksi;
    
    DefaultTableModel dtm = new DefaultTableModel();

    public controllerBookStore() {
        Koneksi db = new Koneksi();
        db.confiq();
        this.stm = db.stm;
    }
    


    
public boolean addToCart(int idUser, String BukuDibeli, int Jumlah, double hargaSatuan, Book buku) {
    Transaction ts = new Transaction();


    // Set the Transaction object
    ts.setIdUser(idUser);
    ts.setBukuDibeli(BukuDibeli);
    ts.setJumlah(Jumlah);
    ts.setHargaSatuan(hargaSatuan);
    ts.setSubtotal(hargaSatuan * Jumlah);

    System.out.println("ID BUKU :" + buku.getId());

    try {
        // Check if the book is already in the cart
        String cek = "SELECT * FROM transaksi WHERE idUser = " + ts.getIdUser() +
                     " AND payment = 0 AND BukuDibeli = '" + ts.getBukuDibeli() + "'";
        res = this.stm.executeQuery(cek);

        if (res.next()) {
            int newQuantity = res.getInt("Jumlah") + ts.getJumlah();
            double newSubtotal = newQuantity * ts.getHargaSatuan();
            this.sql = "UPDATE transaksi SET Jumlah = " + newQuantity + 
                       ", subtotal = " + newSubtotal +
                       " WHERE idUser = " + ts.getIdUser() +
                       " AND BukuDibeli = '" + ts.getBukuDibeli() + "'";
            this.stm.executeUpdate(sql);
        } else {
            this.sql = "INSERT INTO transaksi (idUser, BukuDibeli, Jumlah, hargaSatuan, subtotal, payment) VALUES (" +
                       ts.getIdUser() + ", '" + ts.getBukuDibeli() + "', " + ts.getJumlah() + ", " +
                       ts.getHargaSatuan() + ", " + ts.getSubtotal() + ", 0)";
            this.stm.executeUpdate(sql);
        }

        String setStok = "UPDATE buku SET stok = " + (buku.getStok() - Jumlah) +
                         " WHERE id = " + buku.getId();
        this.stm.executeUpdate(setStok);

        return true;
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        return false;
    }
}

    
    public DefaultTableModel searchBook(String search) {
    DefaultTableModel dtm = new DefaultTableModel();
    dtm.addColumn("ID");
    dtm.addColumn("Judul Buku");
    dtm.addColumn("Penulis");
    dtm.addColumn("Genre");
    dtm.addColumn("Harga");
    dtm.addColumn("Stok");

    try {
        // Menggunakan LIKE untuk pencarian fleksibel pada judul, author, atau kategori
        this.sql = "SELECT * FROM buku WHERE " +
                   "author LIKE '%" + search + "%' " +
                   "OR Category LIKE '%" + search + "%'";

        // Eksekusi query
        res = stm.executeQuery(sql);

        // Ambil hasil dan masukkan ke dalam DefaultTableModel
        while (res.next()) {
            Object[] obj = new Object[6];
            obj[0] = res.getInt("id");
            obj[1] = res.getString("judul");
            obj[2] = res.getString("Author");
            obj[3] = res.getString("Category");
            obj[4] = res.getDouble("price");
            obj[5] = res.getInt("stok");
            dtm.addRow(obj);
        }
    } catch (Exception e) {
        System.out.println("Error loading books: " + e.getMessage());
    }

    return dtm;
}

    
    
    public DefaultTableModel dataTransaksiByUser(int idUser){
        
        this.dtm.addColumn("Book");
        this.dtm.addColumn("Price");
        this.dtm.addColumn("Quantity");
        this.dtm.addColumn("Subtotal");
        
        try{
         //persiapan tabel - clear are dtm
            dtm.getDataVector().removeAllElements();
            dtm.fireTableDataChanged();
            
             //QUERY
            this.sql = "SELECT * FROM transaksi WHERE idUser = "+idUser+" AND payment = 0";
            
            //jalankan query
            res = stm.executeQuery(sql);
            
            //unbox data to object
            while(res.next()){
               Object[] obj = new Object [4];
               obj[0] = res.getString("BukuDibeli");
               obj[1] = res.getString("hargaSatuan");
               obj[2] = res.getString("Jumlah");
               obj[3] = res.getString("subtotal");
           
               //masukan ke dtm
               dtm.addRow(obj);
            }
        }catch (Exception e) {
            System.out.println("GAGAL " + e);
        }
        return dtm;
    }
    
    public boolean bayar(int idUser){
        try {
            this.sql = "UPDATE transaksi SET payment = 1 WHERE idUser = "+idUser+" AND payment = 0";
            int result = stm.executeUpdate(sql);
            if(result <= 0){
                System.out.println("No transaction found");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("GAGALL : " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteItem(Transaction ts, int idUser){
        try {
            System.out.println(ts.getBukuDibeli());
            System.out.println(ts.getIdUser());
            System.out.println(ts.getPayment());
            this.sql = "DELETE FROM transaksi WHERE BukuDibeli = '"+ts.getBukuDibeli()+"' AND idUser = "+idUser+" AND payment = 0 ";
            this.stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
}


