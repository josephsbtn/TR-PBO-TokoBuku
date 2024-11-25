
package tr.toko.buku;

import tr.toko.buku.controller.Koneksi;
import tr.toko.buku.controller.UserController;
import tr.toko.buku.model.User;
import java.util.Scanner;


public class TRTokoBuku {

    public static void main(String[] args) {

        //Inisialisasi
        Koneksi koneksi = new Koneksi();
        koneksi.confiq();
        UserController userController = new UserController();
        User user = new User();
        // String nama;
        // String pw;
        // Boolean isAdmin = false;

        //Scanner
        // try (Scanner scanner = new Scanner(System.in)) {
        //     System.out.println("Masukkan nama : ");
        //     nama = scanner.nextLine();
        //     System.out.println("Masukkan password : ");
        //     pw = scanner.nextLine();
        // }

        // //output and input data
        // System.out.println("Creating a new user");
        // user.setUsername(nama);
        // user.setPassword(pw);
        // user.setIsAdmin(isAdmin);
        // if (userController.createUser(user)) {
        //     System.out.println("User successfully created!\n");
        // } else {
        //     System.out.println("Failed to create user.\n");
        // }
        

        //READ 
        System.out.println("\n\n\n\nRetrieving all users from the database:");
        var users = userController.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found in the database.");
        } else {
            for (User pengguna : users) { // Type element : collection
                System.out.println(
                    "ID: " + pengguna.getId() +
                    ", Username: " + pengguna.getUsername() +
                    ", Password: " + pengguna.getPassword() +
                    ", Is Admin: " + pengguna.isIsAdmin()
                +"\n");
            }}
        for (int i = 0; i < users.size(); i++) {
            System.out.println(
                "ID: " + users.get(i).getId() +
                ", Username: " + users.get(i).getUsername() +
                ", Password: " + users.get(i).getPassword() +
                ", Is Admin: " + users.get(i).isIsAdmin()
            );
        }
        }   
    }
