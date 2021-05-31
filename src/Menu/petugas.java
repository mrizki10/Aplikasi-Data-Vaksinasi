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

public class petugas extends javax.swing.JFrame {
    private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    Statement st = null;
	
    public petugas(){
        initComponents();
        dataTable();
    }

    protected void kosong(){
        tkode.setText("");
        tnama.setText("");
        tcari.setText("");
    }
    
    private void cariData(String key){
            Object[] Baris = {"ID Petugas","Nama Petugas"};
            tabmode = new DefaultTableModel(null, Baris);
            tbl_petugas.setModel(tabmode);                    
            String sql = ("SELECT * from petugas WHERE id_petugas LIKE '%"+key+"%' OR nama_petugas LIKE '%"+key+"%'");  
            try{
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    Object[] data={
                        hasil.getString("id_petugas"),
                        hasil.getString("nama_petugas"),
                    };
                   tabmode.addRow(data);
                }                
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
    }
    
    protected void dataTable(){
        Object[] Baris = {"Kode Petugas","Nama Petugas"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_petugas.setModel(tabmode);
        String sql = "select * from petugas";       
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String a = hasil.getString("id_petugas");
                String b = hasil.getString("nama_petugas");
            
                String[] data={a,b};
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
        tcari = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bclear = new javax.swing.JButton();
        tkode = new javax.swing.JTextField();
        bhome = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_petugas = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Data Vaksinasi");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("DATA PETUGAS");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(300, 20, 200, 60);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NAMA  PETUGAS     ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(190, 140, 120, 14);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("KODE PETUGAS       ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(190, 90, 120, 14);
        jPanel2.add(tcari);
        tcari.setBounds(270, 330, 210, 30);

        tnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaActionPerformed(evt);
            }
        });
        jPanel2.add(tnama);
        tnama.setBounds(340, 130, 240, 30);

        bcari.setText("CARI");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });
        jPanel2.add(bcari);
        bcari.setBounds(190, 330, 60, 30);

        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/simpan.png"))); // NOI18N
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(bsimpan);
        bsimpan.setBounds(190, 190, 90, 90);

        bedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit.png"))); // NOI18N
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        jPanel2.add(bedit);
        bedit.setBounds(290, 190, 90, 90);

        bclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        bclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bclearActionPerformed(evt);
            }
        });
        jPanel2.add(bclear);
        bclear.setBounds(390, 190, 90, 90);

        tkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkodeActionPerformed(evt);
            }
        });
        tkode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkodeKeyPressed(evt);
            }
        });
        jPanel2.add(tkode);
        tkode.setBounds(340, 80, 240, 30);

        bhome.setText("HOME");
        bhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhomeActionPerformed(evt);
            }
        });
        jPanel2.add(bhome);
        bhome.setBounds(510, 330, 70, 30);

        bdelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancel.png"))); // NOI18N
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });
        jPanel2.add(bdelete);
        bdelete.setBounds(490, 190, 90, 90);

        tbl_petugas.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_petugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_petugasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_petugas);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(90, 370, 590, 140);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("DELETE");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(500, 290, 60, 17);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("SIMPAN");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(200, 290, 60, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("EDIT");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(310, 290, 50, 17);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("CLEAR");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(410, 290, 50, 17);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 778, 652);

        setSize(new java.awt.Dimension(739, 691));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        String key=tcari.getText();
        System.out.println(key);         
        if(!"".equals(key)){
            cariData(key);
        }else{
            dataTable();
        }
    }//GEN-LAST:event_bcariActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String sql = "insert into petugas values (?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tkode.getText());
            stat.setString(2, tnama.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasi disimpan");
            kosong();
            tkode.requestFocus();  
            dataTable(); 
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan "+e);
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        try {
            String sql = "update petugas set nama_petugas=? where id_petugas =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tnama.getText());           
            stat.setString(2, tkode.getText());
            if(stat.executeUpdate()>0){
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasi diubah");                
            }else{
                JOptionPane.showMessageDialog(this, "ID Tidak bisa Dirubah", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            }
            kosong();
            tkode.requestFocus();
            dataTable();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal diubah "+e);           
        }   
    }//GEN-LAST:event_beditActionPerformed

    private void bclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bclearActionPerformed
        kosong();
    }//GEN-LAST:event_bclearActionPerformed

    private void bhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhomeActionPerformed
        this.setVisible(false);
        new menuadmin().setVisible(true);
    }//GEN-LAST:event_bhomeActionPerformed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Hapus","Konfirmasi dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql = "delete from petugas where id_petugas ='"+tkode.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                kosong();
                tkode.requestFocus();
                dataTable();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus "+e);                        
            }
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void tnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaActionPerformed
    }//GEN-LAST:event_tnamaActionPerformed

    private void tbl_petugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_petugasMouseClicked
        int bar = tbl_petugas.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();

        tkode.setText(a);
        tnama.setText(b);  
    }//GEN-LAST:event_tbl_petugasMouseClicked

    private void tkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkodeActionPerformed
    }//GEN-LAST:event_tkodeActionPerformed

    private void tkodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkodeKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            tnama.requestFocus();
    }//GEN-LAST:event_tkodeKeyPressed

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
            java.util.logging.Logger.getLogger(petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new petugas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari;
    private javax.swing.JButton bclear;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bhome;
    private javax.swing.JButton bsimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_petugas;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tkode;
    private javax.swing.JTextField tnama;
    // End of variables declaration//GEN-END:variables
}
