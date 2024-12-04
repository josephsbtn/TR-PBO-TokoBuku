/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tr.toko.buku.view;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tr.toko.buku.controller.controllerAdmin;
import tr.toko.buku.model.Book;

/**
 *
 * @author villa
 */
public class editBook extends javax.swing.JFrame {

    /**
     * Creates new form editBook
     */
    public editBook() {
        initComponents();
    }
    public void refreshTable() {
        controllerAdmin ca = new controllerAdmin();
        DefaultTableModel dtm = ca.tableBuku();
        this.edittbl.setModel(dtm);
        ca.tampilanDataBuku();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        edittbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        idedit = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        titleedit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        authoredit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fiksiedit = new javax.swing.JRadioButton();
        nonfiksiedit = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        priceedit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        stockedit = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Book Editing");

        edittbl.setModel(new javax.swing.table.DefaultTableModel(
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
        edittbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edittblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(edittbl);

        jLabel2.setText("ID Buku");

        idedit.setText("id");

        jLabel4.setText("Title");

        titleedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleeditActionPerformed(evt);
            }
        });

        jLabel5.setText("Author");

        authoredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authoreditActionPerformed(evt);
            }
        });

        jLabel6.setText("Category");

        buttonGroup1.add(fiksiedit);
        fiksiedit.setText("Fiksi");

        buttonGroup1.add(nonfiksiedit);
        nonfiksiedit.setText("Non-Fiksi");

        jLabel7.setText("Price");

        jLabel8.setText("Stock");

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fiksiedit)
                                .addGap(18, 18, 18)
                                .addComponent(nonfiksiedit))
                            .addComponent(idedit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(priceedit, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(authoredit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                .addComponent(titleedit, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(stockedit, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(65, 65, 65))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idedit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(titleedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(authoredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fiksiedit)
                    .addComponent(nonfiksiedit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(priceedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(stockedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void titleeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleeditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleeditActionPerformed

    private void authoreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authoreditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authoreditActionPerformed
    
    public void editradio(String radio) {
        if ("fiksi".equalsIgnoreCase(radio)) {
            this.fiksiedit.setSelected(true);
        } 
        else if("Non-Fiksi".equalsIgnoreCase(radio)) {
            this.nonfiksiedit.setSelected(true);
        }
    }
    public String radio() {
        String cat = "";
        if (this.fiksiedit.isSelected()) {
            cat = "Fiksi";
        }
        else if (this.nonfiksiedit.isSelected()) {
            cat = "Non-Fiksi";
        }
        return cat;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        controllerAdmin ca = new controllerAdmin();
        int a = Integer.parseInt(idedit.getText());
        String b = this.titleedit.getText();
        String c = this.authoredit.getText();
        String d = radio();
        double e = Integer.parseInt(priceedit.getText());
        int f = Integer.parseInt(stockedit.getText());
        
        boolean status = ca.updateBuku(a, b, b, d, e, f);
        if (status == true) {
            JOptionPane.showMessageDialog(this, "berhasil ubah");
        } else {
            JOptionPane.showMessageDialog(this, "gagal ubah");
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void edittblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edittblMouseClicked
        // TODO add your handling code here:
        DefaultTableModel dtm2 = (DefaultTableModel) edittbl.getModel();
        
        int pilih = edittbl.getSelectedRow();
        
        this.titleedit.setText(dtm2.getValueAt(pilih, 0).toString());
        this.authoredit.setText(dtm2.getValueAt(pilih, 1).toString());
        this.priceedit.setText(dtm2.getValueAt(pilih, 3).toString());
        this.stockedit.setText(dtm2.getValueAt(pilih, 4).toString());
        
        String cat = dtm2.getValueAt(pilih, 2).toString();
        editradio(cat);
    }//GEN-LAST:event_edittblMouseClicked

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
            java.util.logging.Logger.getLogger(editBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authoredit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable edittbl;
    private javax.swing.JRadioButton fiksiedit;
    private javax.swing.JLabel idedit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton nonfiksiedit;
    private javax.swing.JTextField priceedit;
    private javax.swing.JTextField stockedit;
    private javax.swing.JTextField titleedit;
    // End of variables declaration//GEN-END:variables
}
