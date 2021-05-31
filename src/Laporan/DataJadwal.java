package Laporan;

import Menu.menuLaporan;
import control.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class DataJadwal extends javax.swing.JFrame {
    private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    Statement st = null;
    
    public DataJadwal() {
        initComponents();
        dataTable();
    }

    protected void kosong(){
        tcari.setText("");
    }
    
    private void cariData(String key){
            Object[] Baris = {"Kode Vaksin","Kode Petugas","Nama Petugas","Nama Warga","NIK","Tempat","Tanggal"};
            tabmode = new DefaultTableModel(null, Baris);
            tbl_jadwal.setModel(tabmode);                    
            String sql = ("SELECT * from penjadwalan WHERE kode_vaksin LIKE '%"+key+"%' OR id_petugas LIKE '%"+key+"%' OR nama_petugas LIKE '%"+key+"%' OR nama_warga LIKE '%"+key+"%' OR tempat LIKE '%"+key+"%' OR tanggal LIKE '%"+key+"%'");  
            try{
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    Object[] data={
                        hasil.getString("kode_vaksin"),
                        hasil.getString("id_petugas"),
                        hasil.getString("nama_petugas"),
                        hasil.getString("nama_warga"),
                        hasil.getString("nik"),
                        hasil.getString("tempat"),
                        hasil.getString("tanggal"),
                    };
                   tabmode.addRow(data);
                }                
            } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            }
    }
    
    protected void dataTable(){
        Object[] Baris = {"Kode Vaksin","Kode Petugas","Nama Petugas","Nama Warga","NIK","Tempat","Tanggal"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_jadwal.setModel(tabmode);
        String sql = "select * from penjadwalan";      
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String a = hasil.getString("kode_vaksin");
                String b = hasil.getString("id_petugas");
                String c = hasil.getString("nama_petugas");
                String d = hasil.getString("nama_warga");
                String e = hasil.getString("nik");
                String f = hasil.getString("tempat");
                String g = hasil.getString("tanggal");
                
                String[] data={a,b,c,d,e,f,g};
                tabmode.addRow(data);
            }
        } catch (SQLException e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_jadwal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        bhome = new javax.swing.JButton();
        bcari1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Data Vaksinasi");

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(null);

        tbl_jadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tbl_jadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_jadwalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_jadwal);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 170, 1000, 180);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("JADWAL VAKSIN");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel1FocusGained(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 40, 120, 30);
        jPanel1.add(tcari);
        tcari.setBounds(450, 120, 210, 30);

        bhome.setText("HOME");
        bhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhomeActionPerformed(evt);
            }
        });
        jPanel1.add(bhome);
        bhome.setBounds(930, 40, 70, 30);

        bcari1.setText("CARI");
        bcari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcari1ActionPerformed(evt);
            }
        });
        jPanel1.add(bcari1);
        bcari1.setBounds(690, 120, 57, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "NIK", "Nama", "Tanggal Lahir", "Jenis Kelamin", "Pekerjaan", "Umur", "Kelompok Umur", "Alamat", "Hasil" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(290, 120, 130, 30);

        jButton1.setText("Cetak");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(940, 390, 73, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(1056, 499));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhomeActionPerformed
        this.setVisible(false);
        new menuLaporan().setVisible(true);
    }//GEN-LAST:event_bhomeActionPerformed

    private void tbl_jadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_jadwalMouseClicked

    }//GEN-LAST:event_tbl_jadwalMouseClicked

    private void bcari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcari1ActionPerformed
        String key=tcari.getText();
        System.out.println(key);        
        if(!"".equals(key)){
            cariData(key);
        }else{
            dataTable();
        }
    }//GEN-LAST:event_bcari1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       JasperReport report;
        
        String path=".\\src\\control\\dataPenjadwalan.jasper";
        try {
            report = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, conn);
            JasperViewer jviewer = new JasperViewer(jprint, true);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
            System.out.println("Masuk Try");
        } catch (JRException ex) {
            Logger.getLogger(data_warga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel1FocusGained
    }//GEN-LAST:event_jLabel1FocusGained

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
            java.util.logging.Logger.getLogger(DataJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DataJadwal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari1;
    private javax.swing.JButton bhome;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_jadwal;
    private javax.swing.JTextField tcari;
    // End of variables declaration//GEN-END:variables
}
