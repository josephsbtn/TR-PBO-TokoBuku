package tr.toko.buku.controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;


public class Koneksi {
    public Connection con;
    public Statement stm;
    
    public void confiq(){
        try {
            String url = "jdbc:mysql://localhost:3307/db_tokobuku";
            String user = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //String Connection
            con = DriverManager.getConnection(url, user, password);
            
            //prepare variable for SQL statement
            stm = (Statement) con.createStatement();
            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("Koneksi gagal" + e);
        }
    }
}
