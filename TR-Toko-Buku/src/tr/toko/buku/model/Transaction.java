package tr.toko.buku.model;

import java.util.ArrayList;

public class Transaction {

    private int idTransaksi;
    private int idUser;
    private String BukuDibeli;
    private int Jumlah;
    private double subtotal;
    private double hargaSatuan;

    public double getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(double hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }
    private int payment;

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getBukuDibeli() {
        return BukuDibeli;
    }

    public void setBukuDibeli(String BukuDibeli) {
        this.BukuDibeli = BukuDibeli;
    }

    public int getJumlah() {
        return Jumlah;
    }

    public void setJumlah(int Jumlah) {
        this.Jumlah = Jumlah;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
     

    

}
