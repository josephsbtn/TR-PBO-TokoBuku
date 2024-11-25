package tr.toko.buku.controller;

import java.sql.ResultSet;
import java.sql.Statement;

public class controllerAdmin {

    public Statement stm;
    public ResultSet rs;
    public String sql;

    public controllerAdmin() {
        Koneksi db = new Koneksi();
        db.confiq();
        this.stm = db.stm; 
    }

    






}
