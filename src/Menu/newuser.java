package Menu;

import control.koneksi;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class newuser extends javax.swing.JFrame {
    private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    Statement st = null;
    
    public newuser() {
        initComponents();
        dataTable();
    }

    protected void kosong(){
        tnik.setText("");
        tnama.setText("");
        tusername.setText("");
        tpass.setText("");
        tcari.setText("");
    }
    
    private void cariData(String key){
            Object[] Baris = {"NIK","Nama","Username","Password"};
            tabmode = new DefaultTableModel(null, Baris);
            tbl_user.setModel(tabmode);
                     
            String sql = ("SELECT * from user_rt WHERE nik_user LIKE '%"+key+"%' OR nama LIKE '%"+key+"%' OR username LIKE '%"+key+"%'");  
            try{
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    Object[] data={
                        hasil.getString("nik_user"),
                        hasil.getString("nama"),
                        hasil.getString("username"),
                        hasil.getString("password"),
                    };
                   tabmode.addRow(data);
                }                
            } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            }
    }
    
    protected void dataTable(){
        Object[] Baris = {"NIK","Nama","Username"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_user.setModel(tabmode);
        String sql = "select * from user_rt";      
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String a = hasil.getString("nik_user");
                String b = hasil.getString("nama");
                String c = hasil.getString("username");                
                String d = hasil.getString("password");
                
                String[] data={a,b,c};
                tabmode.addRow(data);
            }
        } catch (SQLException e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        tusername = new javax.swing.JTextField();
        bexit = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bkosongkan = new javax.swing.JButton();
        tnik = new javax.swing.JTextField();
        bhapus = new javax.swing.JButton();
        bcari = new javax.swing.JButton();
        tpass = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_user = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Data Vaksinasi");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("BUAT USER BARU");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 250, 60));

        jLabel1.setText("NIK                           ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jLabel3.setText("NAMA                     ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jLabel4.setText("USERNAME            ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jLabel6.setText("PASSWORD           ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));
        jPanel2.add(tcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 150, 30));

        tnama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnamaKeyPressed(evt);
            }
        });
        jPanel2.add(tnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 240, 30));

        tusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tusernameActionPerformed(evt);
            }
        });
        tusername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tusernameKeyPressed(evt);
            }
        });
        jPanel2.add(tusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 240, 30));

        bexit.setText("HOME");
        bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitActionPerformed(evt);
            }
        });
        jPanel2.add(bexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 80, -1));

        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 80, -1));

        bedit.setText("EDIT");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        jPanel2.add(bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 80, -1));

        bkosongkan.setText("KOSONGKAN");
        bkosongkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkosongkanActionPerformed(evt);
            }
        });
        jPanel2.add(bkosongkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 100, -1));

        tnik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnikKeyPressed(evt);
            }
        });
        jPanel2.add(tnik, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 240, 30));

        bhapus.setText("HAPUS");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        jPanel2.add(bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 80, -1));

        bcari.setText("CARI");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });
        jPanel2.add(bcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, -1, -1));

        tpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpassActionPerformed(evt);
            }
        });
        jPanel2.add(tpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 240, 30));

        tbl_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbl_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_userMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_user);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 660, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(794, 564));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tusernameActionPerformed
    }//GEN-LAST:event_tusernameActionPerformed

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitActionPerformed
        this.setVisible(false);
        new menuadmin().setVisible(true);
    }//GEN-LAST:event_bexitActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String sql = "insert into user_rt values (?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tnik.getText());
            stat.setString(2, tnama.getText());
            stat.setString(3, tusername.getText());
            stat.setString(4, tpass.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasi disimpan");
            kosong();
            tnik.requestFocus();
            dataTable();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan "+e);
        }       
    }//GEN-LAST:event_bsimpanActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        try {
            String sql = "update user_rt set nama=?, username=?, password=? where nik_user =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tnama.getText());
            stat.setString(2, tusername.getText());
            stat.setString(3, tpass.getText());
            stat.setString(4, tnik.getText());
            if(stat.executeUpdate()>0){
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasi diubah");                
            }else{
                JOptionPane.showMessageDialog(this, "ID Tidak bisa Dirubah", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            }
            kosong();
            tnik.requestFocus();
            dataTable();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal diubah "+e);           
        }
    }//GEN-LAST:event_beditActionPerformed

    private void bkosongkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkosongkanActionPerformed
        kosong();
    }//GEN-LAST:event_bkosongkanActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Hapus","Konfirmasi dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql = "delete from user_rt where nik_user ='"+tnik.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                kosong();
                tnik.requestFocus();
                dataTable();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus "+e);                        
            }
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        String key=tcari.getText();
        System.out.println(key);         
        if(!"".equals(key)){
            cariData(key);
        }else{
            dataTable();
        }
    }//GEN-LAST:event_bcariActionPerformed

    private void tpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpassActionPerformed
    }//GEN-LAST:event_tpassActionPerformed

    private void tnikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnikKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            tnama.requestFocus();
    }//GEN-LAST:event_tnikKeyPressed

    private void tnamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnamaKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            tusername.requestFocus();
    }//GEN-LAST:event_tnamaKeyPressed

    private void tusernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tusernameKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            tpass.requestFocus();
    }//GEN-LAST:event_tusernameKeyPressed

    private void tbl_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_userMouseClicked
        int bar = tbl_user.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();

        tnik.setText(a);
        tnama.setText(b);
        tusername.setText(c);
    }//GEN-LAST:event_tbl_userMouseClicked

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
            java.util.logging.Logger.getLogger(datawarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datawarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datawarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datawarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new newuser().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bexit;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkosongkan;
    private javax.swing.JButton bsimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_user;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tnik;
    private javax.swing.JPasswordField tpass;
    private javax.swing.JTextField tusername;
    // End of variables declaration//GEN-END:variables
}
