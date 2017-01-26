package view;

import controller.transaksiController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.koneksi;
import model.transaksiMODEL;

public class transaksi extends javax.swing.JFrame {

    koneksi conn = new koneksi();
    transaksiMODEL tM = new transaksiMODEL();
    transaksiController tC = new transaksiController();
    
    public transaksi() {
        initComponents();
        setLocationRelativeTo(null);
        showtable(); 
        lebarKolom();
    }
    
    private void kliktable()
    {
        try 
        {
           int baris = table_show.getSelectedRow();
           txtIdTransaksi.setText(table_show.getValueAt(baris, 0).toString());
           txtKodeTransaksi.setText(table_show.getValueAt(baris, 1).toString());
           txtKodeBarang.setText(table_show.getValueAt(baris, 2).toString());
           txtNamaPembeli.setText(table_show.getValueAt(baris, 3).toString());
           txtNamaBarang.setText(table_show.getValueAt(baris, 4).toString());
           txtHargaBeli.setText(table_show.getValueAt(baris, 5).toString());
           txtJumlahBeli.setText(table_show.getValueAt(baris, 6).toString());
           txtTotalHarga.setText(table_show.getValueAt(baris, 7).toString());
        } 
        catch (Exception e) 
        {
            System.err.println("Error : " + e);
        }
    }
    
    private void showtable()
    {
        conn.koneksiDataBase();
        DefaultTableModel tabel = new DefaultTableModel();
        
        tabel.addColumn("ID");
        tabel.addColumn("Kode Transaksi");
        tabel.addColumn("Kode Barang");
        tabel.addColumn("Nama Pembeli");
        tabel.addColumn("Nama Barang");
        tabel.addColumn("Harga Beli");
        tabel.addColumn("Jumlah Beli");
        tabel.addColumn("Total Harga");
        
        table_show.setModel(tabel);
        
        try 
        {
            String sql = "select * from tbl_transaksi";

            ResultSet rs = conn.st.executeQuery(sql);
            while (rs.next()) 
            {
                tabel.addRow(new Object[]
                {
                rs.getString("idTransaksi"),
                rs.getString("KodeTransaksi"),
                rs.getString("KodeBarang"),
                rs.getString("NamaPembeli"),
                rs.getString("NamaBarang"),
                rs.getString("Harga"),
                rs.getString("JumlahBeli"),
                rs.getString("TotalHarga")
                });
                table_show.setModel(tabel);
            } 
        }
        catch (SQLException e) 
        {
            System.err.println("Pembeli View Showtable Error" + e);
        }
    }
    
    public void lebarKolom()
    { 
        TableColumn column;
        table_show.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = table_show.getColumnModel().getColumn(0); 
        column.setPreferredWidth(35);
        column = table_show.getColumnModel().getColumn(1); 
        column.setPreferredWidth(100); 
        column = table_show.getColumnModel().getColumn(2); 
        column.setPreferredWidth(85); 
        column = table_show.getColumnModel().getColumn(3); 
        column.setPreferredWidth(150);
        column = table_show.getColumnModel().getColumn(4); 
        column.setPreferredWidth(100);
        column = table_show.getColumnModel().getColumn(5); 
        column.setPreferredWidth(100); 
        column = table_show.getColumnModel().getColumn(6); 
        column.setPreferredWidth(75); 
        column = table_show.getColumnModel().getColumn(7); 
        column.setPreferredWidth(110); 
    }

    
    private void simpan()
    {
        try 
        {
            String KodeTransaksi = txtKodeTransaksi.getText();
            String KodeBarang = txtKodeBarang.getText();
            String NamaPembeli = txtNamaPembeli.getText();
            String NamaBarang = txtNamaBarang.getText();
            int HargaBarang = Integer.parseInt(txtHargaBeli.getText());
            int JumlahBeli = Integer.parseInt(txtJumlahBeli.getText());
            int TotalHarga = Integer.parseInt(txtTotalHarga.getText());
            
            tM.setKodeTransaksi(KodeTransaksi);
            tM.setKodeBarang(KodeBarang);
            tM.setNamaPembeli(NamaPembeli);
            tM.setNamaBarang(NamaBarang);
            tM.setHarga(HargaBarang);
            tM.setJumlahBeli(JumlahBeli);
            tM.setTotal(TotalHarga);
            tC.simpan(tM);
            showtable();
        } 
        catch (Exception e) 
        {
  
        }
    }
    
    private void update()
    {
       try 
        {
            int idTransaksi = Integer.parseInt(txtIdTransaksi.getText());
            String KodeTransaksi = txtKodeTransaksi.getText();
            String KodeBarang = txtKodeBarang.getText();
            String NamaPembeli = txtNamaPembeli.getText();
            String NamaBarang = txtNamaBarang.getText();
            int HargaBarang = Integer.parseInt(txtHargaBeli.getText());
            int JumlahBeli = Integer.parseInt(txtJumlahBeli.getText());
            int TotalHarga = Integer.parseInt(txtTotalHarga.getText());
            
            tM.setIdTransaksi(idTransaksi);
            tM.setKodeTransaksi(KodeTransaksi);
            tM.setKodeBarang(KodeBarang);
            tM.setNamaPembeli(NamaPembeli);
            tM.setNamaBarang(NamaBarang);
            tM.setHarga(HargaBarang);
            tM.setJumlahBeli(JumlahBeli);
            tM.setTotal(TotalHarga);
            tC.update(tM);
            showtable();
        } 
        catch (Exception e) 
        {
  
        }
    }
    
    private void hapus()
    {
        try 
        {
            int id = Integer.parseInt(txtIdTransaksi.getText());
            tM.setIdTransaksi(id);
            tC.hapus(tM);
            showtable();
        } 
        catch (Exception e) 
        {
            
        }
    
    }
    
    private void buka_save_dan_update()
    {
        try 
        {
            btnSave.setEnabled(true);
            btnUpdate.setEnabled(true);
            
            btnAdd.setEnabled(false);
            btnEdit.setEnabled(false);
            btnDelete.setEnabled(false);
        } 
        catch (Exception e) 
        {
            
        }
    }
    
    private void tutup_save_dan_update()
    {
        try 
        {
            btnSave.setEnabled(false);
            btnUpdate.setEnabled(false);
            
            btnAdd.setEnabled(true);
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
        } 
        catch (Exception e) 
        {
            
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKodeBarang = new javax.swing.JTextField();
        txtNamaPembeli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtJumlahBeli = new javax.swing.JTextField();
        txtHargaBeli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTotalHarga = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_show = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtKodeTransaksi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIdTransaksi = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        txtNamaBarang = new javax.swing.JTextField();

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel1.setText("DATA TRANSAKSI");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        jLabel2.setText("KODE BARANG");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 116, 151, -1));

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        jLabel3.setText("NAMA PEMBELI");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 142, 151, -1));

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        jLabel4.setText("NAMA BARANG");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 168, 151, -1));

        txtKodeBarang.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        txtKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeBarangActionPerformed(evt);
            }
        });
        txtKodeBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKodeBarangKeyReleased(evt);
            }
        });
        getContentPane().add(txtKodeBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 113, 60, -1));

        txtNamaPembeli.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        txtNamaPembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPembeliActionPerformed(evt);
            }
        });
        getContentPane().add(txtNamaPembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 139, 180, -1));

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        jLabel5.setText("HARGA");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 194, 151, -1));

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        jLabel6.setText("JUMLAH BELI");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 220, 151, -1));

        txtJumlahBeli.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        txtJumlahBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJumlahBeliKeyReleased(evt);
            }
        });
        getContentPane().add(txtJumlahBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 217, 35, -1));

        txtHargaBeli.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        txtHargaBeli.setEnabled(false);
        getContentPane().add(txtHargaBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 191, 90, -1));

        jLabel7.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        jLabel7.setText("TOTAL");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 249, 151, -1));

        txtTotalHarga.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        txtTotalHarga.setEnabled(false);
        txtTotalHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalHargaActionPerformed(evt);
            }
        });
        getContentPane().add(txtTotalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 243, 90, -1));

        btnSave.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 90, -1));

        btnAdd.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 100, -1));

        btnDelete.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 90, -1));

        btnEdit.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        btnEdit.setText("EDIT");
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 100, -1));

        table_show.setBackground(new java.awt.Color(255, 204, 204));
        table_show.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        table_show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_showMouseClicked(evt);
            }
        });
        table_show.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table_showKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table_show);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 303, 760, 202));

        btnUpdate.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 90, -1));

        jLabel8.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        jLabel8.setText("KODE TRANSAKSI");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 90, 151, -1));

        txtKodeTransaksi.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        txtKodeTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeTransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(txtKodeTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 87, 60, -1));

        jLabel9.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        jLabel9.setText("ID TRANSAKSI");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 64, 151, -1));

        txtIdTransaksi.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        txtIdTransaksi.setEnabled(false);
        txtIdTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 61, 60, -1));

        btnBack.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 90, -1));

        txtNamaBarang.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        txtNamaBarang.setEnabled(false);
        txtNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBarangActionPerformed(evt);
            }
        });
        getContentPane().add(txtNamaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 165, 180, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeBarangActionPerformed

    private void txtTotalHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalHargaActionPerformed
        String Kosong = txtJumlahBeli.getText();
        if (Kosong.equals(""))
        {
          txtTotalHarga.setText("");
        }
    }//GEN-LAST:event_txtTotalHargaActionPerformed

    private void txtNamaPembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPembeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPembeliActionPerformed

    private void txtKodeTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeTransaksiActionPerformed

    private void txtIdTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTransaksiActionPerformed

    private void txtKodeBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeBarangKeyReleased
        String carikode = txtKodeBarang.getText().trim();
        
        if (carikode.equals("")) 
        {
            txtNamaBarang.setText(null);
            txtHargaBeli.setText("");
        } 
        else 
        {
            System.out.println(carikode);
            //cbxNamaBarang.removeAllItems();
            
            try {
                conn.koneksiDataBase();
                String query = "select * from tbl_barang where KodeBarang like '%" + carikode + "%'";
                ResultSet rs = conn.st.executeQuery(query);
                
                while (rs.next()) 
                {
                    txtNamaBarang.setText(rs.getString("NamaBarang"));
                    txtHargaBeli.setText(rs.getString("HargaBarang"));
                }
                rs.last();
                int jumlahdata = rs.getRow();
                rs.first();
            } 
            catch (SQLException e) 
            {
                System.err.println("" + e);
            }
        }
    }//GEN-LAST:event_txtKodeBarangKeyReleased

    private void txtJumlahBeliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahBeliKeyReleased
        int nilai1,nilai2,nilai3;
        String Hasil,Oke;
        
        Oke = txtJumlahBeli.getText();
        
        try 
        {
            nilai1 = Integer.valueOf(txtHargaBeli.getText());
            nilai2 = Integer.valueOf(txtJumlahBeli.getText());
            nilai3 = nilai1 * nilai2;
            
            Hasil = String.valueOf(nilai3);
            txtTotalHarga.setText(Hasil);
            
            if(Oke.equals(""))
            {
            txtTotalHarga.setText("");
            }
        } 
        catch (Exception e) 
        {
            
        }
    }//GEN-LAST:event_txtJumlahBeliKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        simpan();
        tutup_save_dan_update();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        hapus();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void table_showKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_showKeyReleased
        
    }//GEN-LAST:event_table_showKeyReleased

    private void table_showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_showMouseClicked
        kliktable();
    }//GEN-LAST:event_table_showMouseClicked

    private void txtNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new menuutama().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        buka_save_dan_update();
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_show;
    private javax.swing.JTextField txtHargaBeli;
    private javax.swing.JTextField txtIdTransaksi;
    private javax.swing.JTextField txtJumlahBeli;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtKodeTransaksi;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNamaPembeli;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
