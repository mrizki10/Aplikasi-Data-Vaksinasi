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

public class Feedback extends javax.swing.JFrame {
    Connection conn = new koneksi().connect();
    Statement st = null;   
    private DefaultTableModel tabmode;

    public Feedback() {
        initComponents();
    }
    
    protected void kosong(){
        tnik.setText("");
        tnama.setText("");
        tkritik.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tnik = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tkritik = new javax.swing.JTextArea();
        bback = new javax.swing.JButton();
        bcari = new javax.swing.JButton();
        bsubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Data Vaksinasi");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FEEDBACK");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 220, 70));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("KRITIK DAN SARAN  :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 120, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NAMA                          :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NIK                               :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        tnik.setText("Ketik disini...");
        tnik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnikKeyPressed(evt);
            }
        });
        jPanel1.add(tnik, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 260, 30));

        tnama.setEditable(false);
        jPanel1.add(tnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 260, 30));

        tkritik.setColumns(20);
        tkritik.setRows(5);
        tkritik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkritikKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tkritik);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 260, -1));

        bback.setText("HOME");
        bback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbackActionPerformed(evt);
            }
        });
        jPanel1.add(bback, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 70, -1));

        bcari.setText("CARI");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });
        bcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bcariKeyPressed(evt);
            }
        });
        jPanel1.add(bcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, 30));

        bsubmit.setText("SUBMIT");
        bsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsubmitActionPerformed(evt);
            }
        });
        jPanel1.add(bsubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(716, 509));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsubmitActionPerformed
        try {
            if(tnik.getText().equals("") || tnama.getText().equals("") || tkritik.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Data tidak boleh kosong !.", "Pesan", JOptionPane.ERROR_MESSAGE);
            }else{
                String sql = "insert into feedback values (?,?,?)";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, tnik.getText());
                stat.setString(2, tnama.getText());
                stat.setString(3, tkritik.getText());

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasi disimpan");
                kosong();
                tnik.requestFocus();
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan "+e);
        }       
    }//GEN-LAST:event_bsubmitActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        String sql = ("SELECT * from warga WHERE nik LIKE '%"+tnik.getText()+"'");
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if(hasil.next()){
                tnik.setText(hasil.getString("nik"));
                tnama.setText(hasil.getString("nama_warga"));
            }else{
                JOptionPane.showMessageDialog(this, "Data Tidak Ditemukan","Informasi", JOptionPane.INFORMATION_MESSAGE);

                tnik.setText("");
                tnama.setText("");
                tnik.requestFocus();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    
    }//GEN-LAST:event_bcariActionPerformed

    private void bbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbackActionPerformed
        this.setVisible(false);
        new menuuser().setVisible(true);     
    }//GEN-LAST:event_bbackActionPerformed

    private void tnikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnikKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            bcari.requestFocus();
    }//GEN-LAST:event_tnikKeyPressed

    private void bcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bcariKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            tkritik.requestFocus();
    }//GEN-LAST:event_bcariKeyPressed

    private void tkritikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkritikKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            bsubmit.requestFocus();
    }//GEN-LAST:event_tkritikKeyPressed

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
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Feedback().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bback;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bsubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tkritik;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tnik;
    // End of variables declaration//GEN-END:variables
}
