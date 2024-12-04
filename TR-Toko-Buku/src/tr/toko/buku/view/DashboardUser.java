/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tr.toko.buku.view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tr.toko.buku.controller.controllerAdmin;
import tr.toko.buku.controller.UserController;
import tr.toko.buku.controller.controllerBookStore;
import tr.toko.buku.model.User;
import tr.toko.buku.model.Book;
import tr.toko.buku.model.Transaction;
import tr.toko.buku.view.Cart;
import tr.toko.buku.view.Login;

public class DashboardUser extends javax.swing.JFrame {

    private int stokBuku = 0;
    private Book buku = new Book();
    private User currentUser;
    private Transaction ts;
    private String search = "";
    private controllerBookStore bs = new controllerBookStore();

public DashboardUser() {
    initComponents(); 
    refreshTable();
}

public DashboardUser(User user) {
    initComponents();  
    currentUser = user;

    if (lblHaiUser != null) {
        lblHaiUser.setText(currentUser.getUsername());
    } else {
        System.out.println("lblHaiUser is not initialized.");
    }
     refreshTable();
}


public void refreshTable() {
    controllerAdmin ca = new controllerAdmin(); 
    DefaultTableModel tableBuku = ca.tableBuku(); 
    DefaultTableModel searchBook = null;

    if (search != null && !search.trim().isEmpty()) {
        searchBook = bs.searchBook(search); 
    }

    if (tableBuku != null) {
        if (search == null || search.trim().isEmpty()) {
            this.tblKoleksiBuku.setModel(tableBuku); 
        } else if (searchBook != null && searchBook.getRowCount() > 0) {
            this.tblKoleksiBuku.setModel(searchBook); 
        } else {
            System.out.println("No books found for the search term: " + search);
            JOptionPane.showMessageDialog(this, "No books match your search.", "Search Results", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        System.out.println("Book table is empty.");
        JOptionPane.showMessageDialog(this, "The book collection is empty.", "No Data", JOptionPane.WARNING_MESSAGE);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        lblWelcome = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblKoleksiBuku = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblJudulBuku = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblJudulBuku1 = new javax.swing.JLabel();
        lblHargaSatuan = new javax.swing.JLabel();
        lblHaiUser = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblHaiUser1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane2.addTab("tab1", jScrollPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setFont(new java.awt.Font("Javanese Text", 1, 20)); // NOI18N
        lblWelcome.setText("Literary Labyrinth");
        getContentPane().add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 31, -1, 40));

        jButton1.setBackground(new java.awt.Color(102, 51, 0));
        jButton1.setText("CART");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(739, 33, 120, -1));

        tblKoleksiBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKoleksiBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKoleksiBukuMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblKoleksiBuku);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 111, 420, 190));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Choiced Book");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 175, 40));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Title");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 113, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantity");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 113, -1));

        lblJudulBuku.setBackground(new java.awt.Color(255, 255, 255));
        lblJudulBuku.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblJudulBuku.setText("-");
        getContentPane().add(lblJudulBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 113, -1));

        jLabel4.setFont(new java.awt.Font("Javanese Text", 0, 12)); // NOI18N
        jLabel4.setText("Book Colllection");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 76, 175, 21));

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        getContentPane().add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 100, 25));

        jButton2.setBackground(new java.awt.Color(153, 51, 0));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("+ BOOK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(849, 230, 90, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Price");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 113, -1));

        lblJudulBuku1.setBackground(new java.awt.Color(255, 255, 255));
        lblJudulBuku1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblJudulBuku1.setForeground(new java.awt.Color(255, 255, 255));
        lblJudulBuku1.setText("Rp");
        getContentPane().add(lblJudulBuku1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, -1, -1));

        lblHargaSatuan.setBackground(new java.awt.Color(255, 255, 255));
        lblHargaSatuan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblHargaSatuan.setForeground(new java.awt.Color(255, 255, 255));
        lblHargaSatuan.setText("0");
        getContentPane().add(lblHargaSatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 171, -1));

        lblHaiUser.setFont(new java.awt.Font("Javanese Text", 0, 14)); // NOI18N
        lblHaiUser.setText("-");
        getContentPane().add(lblHaiUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 100, 28));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 74, 156, 25));

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 74, 73, -1));

        jButton4.setBackground(new java.awt.Color(102, 0, 51));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("LOGOUT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 33, 120, -1));

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 380, 170));

        lblHaiUser1.setFont(new java.awt.Font("Javanese Text", 0, 14)); // NOI18N
        lblHaiUser1.setText("user : ");
        getContentPane().add(lblHaiUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 40, 28));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKoleksiBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKoleksiBukuMouseClicked
        DefaultTableModel dtm2 = (DefaultTableModel) tblKoleksiBuku.getModel();
        int pilih = tblKoleksiBuku.getSelectedRow();
        buku.setId(Integer.parseInt(dtm2.getValueAt(pilih, 0).toString()));
        buku.setTitle(dtm2.getValueAt(pilih, 1).toString());
        buku.setAuthor(dtm2.getValueAt(pilih, 2).toString());
        buku.setCategory(dtm2.getValueAt(pilih, 3).toString());
        buku.setPrice(Double.parseDouble(dtm2.getValueAt(pilih, 4).toString()));
        buku.setStok(Integer.parseInt(dtm2.getValueAt(pilih, 5).toString()));

        this.lblHargaSatuan.setText(String.format("%.2f", buku.getPrice()));
        this.lblJudulBuku.setText(buku.getTitle());

        System.out.println("BUKU = " + buku.getAuthor() + buku.getCategory() + buku.getTitle() + buku.getStok());
    }//GEN-LAST:event_tblKoleksiBukuMouseClicked

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Cart cart = new Cart(currentUser);
        this.setVisible(false);
        cart.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    search = txtSearch.getText(); 
    refreshTable(); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          Login lgn = new Login();
          this.setVisible(false);
          lgn.setVisible(true);           
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        int quantity = 0;
        try {
            quantity = Integer.parseInt(this.txtQuantity.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Jumlah tidak valid. Masukkan angka.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (quantity > buku.getStok()) {
            JOptionPane.showMessageDialog(this, "Stok Buku Tidak Mencukupi", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (quantity <= 0) {
            JOptionPane.showMessageDialog(this, "Jumlah tidak bisa kurang dari 1", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String bukuDibeli = buku.getTitle();
        double hargaSatuan = buku.getPrice();
        double subtotal = quantity * hargaSatuan;
        System.out.println("user : " + currentUser.getId());

        boolean status = bs.addToCart(currentUser.getId(), bukuDibeli, quantity, subtotal, buku);
        if (status) {
            refreshTable();
            JOptionPane.showMessageDialog(this, "Berhasil Menambah ke Keranjang", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Gagal Menambah ke Keranjang", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblHaiUser;
    private javax.swing.JLabel lblHaiUser1;
    private javax.swing.JLabel lblHargaSatuan;
    private javax.swing.JLabel lblJudulBuku;
    private javax.swing.JLabel lblJudulBuku1;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblKoleksiBuku;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
