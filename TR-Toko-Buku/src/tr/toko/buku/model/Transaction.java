package tr.toko.buku.model;

import java.util.ArrayList;

public class Transaction {

    private int idTransaksi;
    private int idPembeli;
    private ArrayList bukuDibeList = new ArrayList();

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public ArrayList getBukuDibeList() {
        return bukuDibeList;
    }

    public void setBukuDibeList(ArrayList bukuDibeList) {
        this.bukuDibeList = bukuDibeList;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdPembeli() {
        return idPembeli;
    }

    public void setIdPembeli(int idPembeli) {
        this.idPembeli = idPembeli;
    }
    
    public void addCart(Keranjang krj ){
        bukuDibeList.add(krj);
    }
    
    public ArrayList getKeranjang(){
        return bukuDibeList;
    }
    
    

}
