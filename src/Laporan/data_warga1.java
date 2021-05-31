package Laporan;

import static Menu.datawarga.getTanggal;
import Menu.menuuser;
import control.koneksi;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class data_warga1 extends javax.swing.JFrame {
    private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    Statement st = null;
    
    public data_warga1() {
        initComponents();
        dataTable();
    }

    protected void kosong(){
        tcari.setText("");
    }
    
    private void cariData(String key){
            Object[] Baris = {"Nama","NIK","Tanggal Lahir","Jenis Kelamin","Pekerjaan","Umur","Kelompok Umur","Alamat","Hasil Vaksin"};
            tabmode = new DefaultTableModel(null, Baris);
            tbl_warga.setModel(tabmode);
                     
            String sql = ("SELECT * from warga WHERE nik LIKE '%"+key+"%' OR nama_warga LIKE '%"+key+"%' OR tanggal_lahir LIKE '%"+key+"%' OR jenis_kelamin LIKE '%"+key+"%' OR pekerjaan LIKE '%"+key+"%' OR umur LIKE '%"+key+"%' OR kelompok_umur LIKE '%"+key+"%' OR alamat LIKE '%"+key+"%' OR hasil_vaksin LIKE '%"+key+"%'OR alamat LIKE '%"+key+"%'");  
            try{
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    Object[] data={
                        hasil.getString("nama_warga"),
                        hasil.getString("nik"),
                        hasil.getString("tanggal_lahir"),
                        hasil.getString("jenis_kelamin"),
                        hasil.getString("pekerjaan"),
                        hasil.getString("umur"),
                        hasil.getString("kelompok_umur"),
                        hasil.getString("alamat"),
                        hasil.getString("hasil_vaksin"),   
                    };
                   tabmode.addRow(data);
                }                
            } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            }
    }
    
    protected void dataTable(){
        Object[] Baris = {"Nama","NIK","Tanggal Lahir","Jenis Kelamin","Pekerjaan","Umur","Kelompok Umur","Alamat","Hasil Vaksin"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_warga.setModel(tabmode);
        String sql = "select * from warga";       
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String a = hasil.getString("nama_warga");
                String b = hasil.getString("nik");
                String c = hasil.getString("tanggal_lahir");
                String d = hasil.getString("jenis_kelamin");
                String e = hasil.getString("pekerjaan");
                String f = hasil.getString("umur");
                String g = hasil.getString("kelompok_umur");
                String h = hasil.getString("alamat");
                String i = hasil.getString("hasil_vaksin");
            
                String[] data={a,b,c,d,e,f,g,h,i};
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
        tbl_warga = new javax.swing.JTable();
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

        tbl_warga.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_warga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_wargaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_warga);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 170, 950, 180);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DATA WARGA");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 40, 120, 30);
        jPanel1.add(tcari);
        tcari.setBounds(430, 120, 210, 30);

        bhome.setText("HOME");
        bhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhomeActionPerformed(evt);
            }
        });
        jPanel1.add(bhome);
        bhome.setBounds(890, 40, 70, 30);

        bcari1.setText("CARI");
        bcari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcari1ActionPerformed(evt);
            }
        });
        jPanel1.add(bcari1);
        bcari1.setBounds(670, 120, 57, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "NIK", "Nama", "Tanggal Lahir", "Jenis Kelamin", "Pekerjaan", "Umur", "Kelompok Umur", "Alamat", "Hasil" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(270, 120, 130, 30);

        jButton1.setText("CETAK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(890, 390, 73, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        setSize(new java.awt.Dimension(1014, 499));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhomeActionPerformed
        this.setVisible(false);
        new menuuser().setVisible(true);
    }//GEN-LAST:event_bhomeActionPerformed

    private void tbl_wargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_wargaMouseClicked
        int bar = tbl_warga.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        tcari.setText(b);
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        String i = tabmode.getValueAt(bar, 8).toString();
    }//GEN-LAST:event_tbl_wargaMouseClicked

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
        String path=".\\src\\control\\LaporanWarga.jasper";
        try {
            HashMap pm = new HashMap();
            File rpt = new File(path);
            pm.put("pnik", tcari.getText());
            JasperReport jrp = (JasperReport) JRLoader.loadObjectFromFile(rpt.getPath());
            JasperPrint jrpt = JasperFillManager.fillReport(jrp, pm, conn);
            JasperViewer.viewReport(jrpt, false);
        } catch (Exception ex) {
            Logger.getLogger(data_warga.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(data_warga1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_warga1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_warga1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_warga1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            new data_warga1().setVisible(true);
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
    private javax.swing.JTable tbl_warga;
    private javax.swing.JTextField tcari;
    // End of variables declaration//GEN-END:variables
}
