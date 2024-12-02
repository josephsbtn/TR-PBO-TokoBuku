/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tr.toko.buku.model;

public class Book {
  private int id;
  private String title;
  private String author;
  private String Category;
  private double price;
  private int stok;

    public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    public void setReStok(int stok){
        this.stok += stok;
    }
    
    public void setSellStok(int stok){
        this.stok -= stok;
    }
  
  
}
