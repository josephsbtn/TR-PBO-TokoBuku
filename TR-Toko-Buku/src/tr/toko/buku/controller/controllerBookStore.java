package tr.toko.buku.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import tr.toko.buku.model.Book;
import tr.toko.buku.model.BookStoreInterface;
import tr.toko.buku.model.Transaction;

public class controllerBookStore {

    public Statement stm;
    public ResultSet res;
    public String sql;

    public controllerBookStore() {
        Koneksi db = new Koneksi();
        db.confiq();
        this.stm = db.stm;
    }

}
