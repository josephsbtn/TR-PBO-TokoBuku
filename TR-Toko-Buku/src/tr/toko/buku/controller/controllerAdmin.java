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
    
    public DefaultTableModel tableBuku(){
        dtm.addColumn("id");
        dtm.addColumn("Judul Buku");
        dtm.addColumn("Penulis");
        dtm.addColumn("Tahun Terbit");
        dtm.addColumn("Harga");
        return dtm;
    }
    
    
    public boolean addBuku(Book book ){
         try {
            this.sql = "INSERT INTO buku (Judul, Author, TahunTerbit, Harga, stok)" + 
                    "VALUE ('" + book.getTitle() + "' , '" + book.getAuthor()+ "','" + book.getCategory()+ "','" + book.getPrice() + "', '" + book.getStok() + "' )" ;
            
            res = stm.executeUpdate(sql);
        } catch (Exception e) {
        }
        
        return true;
    }
    
    public void tampilanDataBuku(){
        dtm.getDataVector().removeAllElements();
        dtm.fireTableDataChanged();
            
        try {
             this.sql = "SELECT * FROM buku";
             res = stm.executeQuery(sql);
                        
            while(res.next()){
               Object[] obj = new Object [5];
               obj[0] = res.getString("id");
               obj[1] = res.getString("Judul");
               obj[2] = res.getString("Author");
               obj[3] = res.getString("TahunTerbit");
               obj[4] = res.getString("Harga");
               
               //masukan ke dtm
               dtm.addRow(obj);
            }
                     
            
        } catch (Exception e) {
        }
    
    }
    
    
    
    
    
    
    
    
    

    






}
