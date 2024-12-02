package tr.toko.buku.controller;

import java.sql.ResultSet;
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
    
    DefaultTableModel dtm = new DefaultTableModel();

    public controllerBookStore() {
        Koneksi db = new Koneksi();
        db.confiq();
        this.stm = db.stm;
    }



    
    public DefaultTableModel buatTable(){
        dtm.addColumn("Title");
        dtm.addColumn("Author");
        dtm.addColumn("Category");
        dtm.addColumn("Price");
        dtm.addColumn("Stock");
        
        return dtm;
       }
       
       public void tammpilBuku(){
           try {
               //persiapan tabel - clear are dtm
               dtm.getDataVector().removeAllElements();
               dtm.fireTableDataChanged();
               
               //QUERY
               this.sql = "SELECT * FROM buku";
               
               //jalankan query
               res = stm.executeQuery(sql);
               
               //unbox data to object
               while(res.next()){
                  Object[] obj = new Object [4];
                  obj[0] = res.getString("title");
                  obj[1] = res.getString("author");
                  obj[2] = res.getString("Category");
                  obj[3] = res.getDouble("price");
                  obj[4] = res.getInt("stok");
                  
                  //masukan ke dtm
                  dtm.addRow(obj);
               }
               
           } catch (Exception e) {
               System.out.println("GAGAL " + e);
           }
       }
       
   public boolean tambahBuku(String title,String author,String Category,double price,int stok){
           //Hubungkan dengan model
           Book bk = new Book();
           bk.setTitle(title);
           bk.setAuthor(author);
           bk.setCategory(Category);
           bk.setPrice(price);
           bk.setStok(stok);
           
           try {
               this.sql = "INSERT INTO buku (title, author, category, price, stok) " +
                   "VALUES ('" + bk.getTitle() + "', '" + bk.getAuthor() + "', '" +
                   bk.getCategory() + "', " + bk.getPrice() + ", " + bk.getStok() + ")";
               
               //jalankan query
               //utk INSERT, UPDATE, DELETE menggunakan 
               //executeUpdate
               this.stm.executeUpdate(sql);
               return true;
           } catch (Exception e) {
               return false;}
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
                   "title = '" + bk.getTitle() + "', " +
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
               this.sql="DELETE FROM tb_pasien WHERE id="+bk.getId()+"";
               this.stm.executeUpdate(sql);
               return true;
           } catch (Exception e) {
               return false;}
   }
   
}


