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
    

    
    public boolean addToCart(int idUser, String BukuDibeli, int Jumlah, double hargaSatuan, Book buku ){
        Transaction ts = new Transaction();
        buku.setSellStok(Jumlah);
        ts.setIdUser(idUser);
        ts.setBukuDibeli(BukuDibeli);
        ts.setJumlah(Jumlah);
        ts.setHargaSatuan(hargaSatuan);
        ts.setSubtotal(hargaSatuan * Jumlah);
        System.out.println("ID BUKU :" + buku.getId());
          try {
            this.sql = "INSERT INTO transaksi (idUser, BukuDibeli, Jumlah, hargaSatuan, subtotal) VALUES ('"+ts.getIdUser() +"','"+ts.getBukuDibeli()+"',"+ts.getJumlah()+", "+ts.getHargaSatuan()+", "+ts.getSubtotal()+" )" ;
            String setStok = "UPDATE buku SET stok = "+buku.getStok()+" WHERE id = "+buku.getId()+" ";
            this.stm.executeUpdate(setStok);
            this.stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
              System.out.println(e.getMessage());
            return false;
        }
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
            dtm.getDataVector().removeAllElements();
            dtm.fireTableDataChanged();
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
    
    
}


