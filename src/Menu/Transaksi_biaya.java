package Menu;

import Laporan.data_warga;
import control.koneksi;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Transaksi_biaya extends javax.swing.JFrame {
    Connection conn = new koneksi().connect();
    Statement st = null;   
    
    public Transaksi_biaya() {
        initComponents();
        tampilkan();
        dana_awal();
    }
    
    protected void hitung(){ 
        String sql1 = "select count(hasil_vaksin) from warga where hasil_vaksin='SUDAH'"; 
        String sql = "select dana_awal from dana_awal";  

        try {
            java.sql.Statement stat = conn.createStatement();
            java.sql.Statement stut = conn.createStatement();            
            ResultSet hasil = stut.executeQuery(sql);
            ResultSet hasil1 = stat.executeQuery(sql1);
            


            hasil1.next();
            Integer a = hasil1.getInt(1);

            long harga = 321660;
            long tagihan = harga * a;
            String d = String.valueOf(tagihan);
            ttotaltagihan.setText("Rp. "+d);
            
            hasil.next();
            Integer b = hasil.getInt(1);
            
            long total = b - tagihan;
            tsisa.setText("Rp. "+total);
            
            
                      
        } catch (SQLException e) {
        }   
    }
    
    protected void dana_awal(){
        String sql = "select dana_awal from dana_awal";  
        try {
            java.sql.Statement stat = conn.createStatement();            
            ResultSet hasil1 = stat.executeQuery(sql);

            hasil1.next();
            Integer a = hasil1.getInt(1);
            String jumlah=String.valueOf(a);
            ttotalanggaran.setText("Rp. "+jumlah);
        } catch (SQLException e) {
        }
    }
    

    protected void tampilkan(){
        String sql1 = "select count(hasil_vaksin) from warga where hasil_vaksin='SUDAH'";
        
        try {
            java.sql.Statement stat = conn.createStatement(); 
            ResultSet hasil1 = stat.executeQuery(sql1);

            hasil1.next();
            Integer a = hasil1.getInt(1);
            String jumlah=String.valueOf(a);
            tjumlah.setText(jumlah);   
        } catch (SQLException e) {
        }
    }
    
    protected void cetak(){
       JasperReport report;
        
        String path=".\\src\\control\\transaksi.jasper";
        try {
            report = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, conn);
            JasperViewer jviewer = new JasperViewer(jprint, true);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(data_warga.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tsisa = new javax.swing.JTextField();
        tharga = new javax.swing.JTextField();
        ttotaltagihan = new javax.swing.JTextField();
        ttotalanggaran = new javax.swing.JTextField();
        tjumlah = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Data Vaksinasi");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RINCIAN TAGIHAN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 29, 240, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("HARGA PER VAKSIN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 130, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SISA ANGGARAN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 130, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("JUMLAH VAKSINASI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 150, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TOTAL TAGIHAN");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 130, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TOTAL ANGGARAN");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 140, 20));
        jPanel1.add(tsisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 190, 30));

        tharga.setEditable(false);
        tharga.setText("Rp. 321.660");
        tharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thargaActionPerformed(evt);
            }
        });
        jPanel1.add(tharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 190, 30));
        jPanel1.add(ttotaltagihan, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 190, 30));

        ttotalanggaran.setEditable(false);
        ttotalanggaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttotalanggaranActionPerformed(evt);
            }
        });
        jPanel1.add(ttotalanggaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 190, 30));

        tjumlah.setEditable(false);
        jPanel1.add(tjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 190, 30));

        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 353, 80, 30));

        jButton2.setText("HITUNG");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 353, 80, 30));

        jButton3.setText("CETAK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 353, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(712, 503));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void thargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thargaActionPerformed
    }//GEN-LAST:event_thargaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ok = 0;
        if (ok==0){
            String sql = "delete from anggaran where jumlah_vaksin ='"+tjumlah.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
            } catch (HeadlessException | SQLException e) {
            }
        }
        this.setVisible(false);
        new menuadmin().setVisible(true);      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        hitung();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ttotalanggaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttotalanggaranActionPerformed
    }//GEN-LAST:event_ttotalanggaranActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
                String sql = "insert into anggaran values (?,?,?,?,?)";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, tjumlah.getText());
                stat.setString(2, tharga.getText());
                stat.setString(3, ttotalanggaran.getText());
                stat.setString(4, ttotaltagihan.getText());
                stat.setString(5, tsisa.getText());
               
                stat.executeUpdate();
                tjumlah.requestFocus();
        } catch (HeadlessException | SQLException e) {
        }        
        cetak();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi_biaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Transaksi_biaya().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tharga;
    private javax.swing.JTextField tjumlah;
    private javax.swing.JTextField tsisa;
    private javax.swing.JTextField ttotalanggaran;
    private javax.swing.JTextField ttotaltagihan;
    // End of variables declaration//GEN-END:variables
}
