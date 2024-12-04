package tr.toko.buku.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import tr.toko.buku.model.Book;

public class controllerAdmin {

    public Statement stm;
    public ResultSet res;
    public String sql;
    DefaultTableModel dtm = new DefaultTableModel();

    public controllerAdmin() {
        Koneksi db = new Koneksi();
        db.confiq();
        this.stm = db.stm;
    }

public DefaultTableModel Transaction() {
        DefaultTableModel tbTransaksi = new DefaultTableModel();
        tbTransaksi.addColumn("ID");
        tbTransaksi.addColumn("ID Pembeli");
        tbTransaksi.addColumn("Buku Dibeli");
        tbTransaksi.addColumn("Total Pembelian");

        try {
            this.sql = "SELECT * FROM transaksi";
            res = stm.executeQuery(sql);

            while (res.next()) {
                Object[] obj = new Object[4];
                obj[0] = res.getInt("id");
                obj[1] = res.getInt("idUser");
                obj[2] = res.getString("BukuDibeli"); 
                obj[3] = res.getDouble("total");
                tbTransaksi.addRow(obj);
            }
        } catch (Exception e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }

        return tbTransaksi;
    }

    public DefaultTableModel tableBuku() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Judul Buku");
        dtm.addColumn("Penulis");
        dtm.addColumn("Genre");
        dtm.addColumn("Harga");
        dtm.addColumn("Stok");

        try {
            this.sql = "SELECT * FROM buku";
            res = stm.executeQuery(sql);

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

    public boolean addBuku(Book book) {
        try {
            this.sql = "INSERT INTO buku (judul, author, category, price, stok) "
                    + "VALUE ('" + book.getTitle() + "' , '" + book.getAuthor() + "','" + book.getCategory() + "','" + book.getPrice() + "', '" + book.getStok() + "' )";

            this.stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    

    
public boolean updateBuku(int id,String title, String author,String Category,Double price,int stok) {
 Book bk = new Book();
 bk.setId(id);
 bk.setTitle(title);
 bk.setAuthor(author);
 bk.setCategory(Category);
 bk.setPrice(price);
 bk.setStok(stok);

 try {
     this.sql = "UPDATE buku SET " +
                "judul = '" + bk.getTitle() + "', " +
                "author = '" + bk.getAuthor() + "', " +
                "stok = " + bk.getStok() + " " +
                "WHERE id = " + bk.getId();

     this.stm.executeUpdate(sql);
     return true;
 } catch (Exception e) {
     e.printStackTrace(); // Added for debugging
     return false;
 }
}

    
 public boolean deleteBuku(int a){
        Book bk = new Book();
        bk.setId(a);
        try {
            this.sql="DELETE FROM buku WHERE id="+bk.getId()+"";
            this.stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;}
}

}
