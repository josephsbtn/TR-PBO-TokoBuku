package tr.toko.buku.model;
import java.util.ArrayList;

public interface BookStoreInterface {
    // CRUD Buku
    void addBook(String title, String author, String category, double price, int stock);
    void updateBook(int bookId, String title, String author, String category, double price, int stock);
    void deleteBook(int bookId);
    Book getBookById(int bookId);
    ArrayList<Book> getAllBooks();

    // Otorisasi
    boolean login(String username, String password); // Untuk user dan admin
    void logout();
    boolean isAdmin(); // Cek apakah user adalah admin

    // Pencarian Buku Berdasarkan Kategori
    ArrayList<Book> searchBooksByCategory(String category);

    // Riwayat Pembelian dan Transaksi
    void recordTransaction(int userId, int bookId, int quantity);
    ArrayList<Transaction> getTransactionHistory(int userId);
    ArrayList<Transaction> getAllTransactions(); // Hanya untuk admin

}
