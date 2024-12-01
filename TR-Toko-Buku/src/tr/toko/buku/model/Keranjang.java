package tr.toko.buku.model;

public class Keranjang {

    private Book buku;
    private int quantity;
    private double subTotal;

    public Keranjang(Book buku, int quantity) {
        this.buku = buku;
        this.quantity = quantity;
    }

    public Book getBuku() {
        return buku;
    }

    public void setBuku(Book buku) {
        this.buku = buku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    
}
