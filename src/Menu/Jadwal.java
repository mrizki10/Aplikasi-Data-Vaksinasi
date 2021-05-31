package Menu;

import Laporan.data_warga;
import control.koneksi;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Jadwal extends javax.swing.JFrame {
    Connection conn = new koneksi().connect();
    Statement st = null;   
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmodel;

    public Jadwal() {
        initComponents();
        dataFromDataBaseToComboBox();   
        dataTable();
        TableTanggal();
    }

    public void dataFromDataBaseToComboBox(){
        String sql = "select id_petugas from petugas order by id_petugas asc";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);            
            while (res.next()) {                
            Object[] ob = new Object[2];
            ob[0] = res.getString(1);           
            cmbpetugas.addItem((String) ob[0]);  
            }       
        } catch (SQLException e) {
        }
    }
    
    public void tampil()
        {
            try {
                String sql = "select nama_petugas from petugas where id_petugas='"+cmbpetugas.getSelectedItem()+"'";
                java.sql.Statement stat = conn.createStatement();
                ResultSet res = stat.executeQuery(sql);
                while(res.next()){
                    Object[] ob = new Object[1];
                    ob[0]=  res.getString(1);

                    tnamapetugas.setText((String) ob[0]);
                }
                    res.close(); stat.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }              
        }

    protected void kosong(){
        tkode_vaksin.setText("");
        cmbpetugas.setSelectedIndex(0);
        tanggal.setDate(null);
        tnamapetugas.setText("");
        tnamawarga.setText("");
        tcari.setText("");
        ttempat.setText("");
        tnik.setText("");
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tnamapetugas = new javax.swing.JTextField();
        tnik = new javax.swing.JTextField();
        tnamawarga = new javax.swing.JTextField();
        ttempat = new javax.swing.JTextField();
        bsimpan = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bclear = new javax.swing.JButton();
        tkode_vaksin = new javax.swing.JTextField();
        bhome = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_jadwal = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        bcariwarga = new javax.swing.JButton();
        cmbpetugas = new javax.swing.JComboBox<>();
        tanggal = new com.toedter.calendar.JDateChooser();
        tcari = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_warga = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Data Vaksinasi");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DATA VAKSINASI");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(600, 10, 270, 60);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KODE VAKSIN         ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 120, 120, 14);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("KODE PETUGAS      ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 160, 120, 14);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NAMA PETUGAS      ");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 200, 110, 14);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NIK                         ");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 240, 120, 14);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NAMA WARGA        ");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 280, 120, 14);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TEMPAT                  ");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 320, 120, 14);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TANGGAL                ");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(30, 360, 120, 14);

        tnamapetugas.setEditable(false);
        tnamapetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamapetugasActionPerformed(evt);
            }
        });
        jPanel2.add(tnamapetugas);
        tnamapetugas.setBounds(120, 190, 240, 30);

        tnik.setEditable(false);
        tnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnikActionPerformed(evt);
            }
        });
        jPanel2.add(tnik);
        tnik.setBounds(120, 230, 240, 30);

        tnamawarga.setEditable(false);
        tnamawarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamawargaActionPerformed(evt);
            }
        });
        jPanel2.add(tnamawarga);
        tnamawarga.setBounds(120, 270, 240, 30);

        ttempat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttempatActionPerformed(evt);
            }
        });
        ttempat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ttempatKeyPressed(evt);
            }
        });
        jPanel2.add(ttempat);
        ttempat.setBounds(120, 310, 240, 30);

        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/simpan.png"))); // NOI18N
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(bsimpan);
        bsimpan.setBounds(380, 110, 90, 80);

        bedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit.png"))); // NOI18N
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        jPanel2.add(bedit);
        bedit.setBounds(380, 230, 90, 81);

        bclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        bclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bclearActionPerformed(evt);
            }
        });
        jPanel2.add(bclear);
        bclear.setBounds(480, 110, 90, 80);

        tkode_vaksin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkode_vaksinKeyPressed(evt);
            }
        });
        jPanel2.add(tkode_vaksin);
        tkode_vaksin.setBounds(120, 110, 240, 30);

        bhome.setText("HOME");
        bhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhomeActionPerformed(evt);
            }
        });
        jPanel2.add(bhome);
        bhome.setBounds(480, 350, 90, 30);

        bdelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancel.png"))); // NOI18N
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });
        jPanel2.add(bdelete);
        bdelete.setBounds(480, 230, 90, 80);

        tbl_jadwal.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_jadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_jadwalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_jadwal);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(30, 410, 600, 180);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("DELETE");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(500, 320, 60, 17);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("SIMPAN");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(400, 200, 60, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("EDIT");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(410, 320, 40, 17);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("CLEAR");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(510, 200, 50, 17);

        bcariwarga.setText("Cari Warga");
        bcariwarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariwargaActionPerformed(evt);
            }
        });
        jPanel2.add(bcariwarga);
        bcariwarga.setBounds(650, 110, 110, 30);

        cmbpetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Petugas" }));
        cmbpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbpetugasActionPerformed(evt);
            }
        });
        cmbpetugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbpetugasKeyPressed(evt);
            }
        });
        jPanel2.add(cmbpetugas);
        cmbpetugas.setBounds(120, 150, 240, 30);
        jPanel2.add(tanggal);
        tanggal.setBounds(120, 350, 240, 30);
        jPanel2.add(tcari);
        tcari.setBounds(780, 110, 190, 30);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "NIK", "Nama", "Tanggal Lahir", "Jenis Kelamin", "Pekerjaan", "Umur", "Kelompok Umur", "Alamat", "Hasil" }));
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(990, 110, 130, 30);

        tbl_warga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tbl_warga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_wargaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_warga);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(650, 150, 700, 440);

        jButton1.setText("CETAK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(380, 350, 90, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1380, 700);

        setSize(new java.awt.Dimension(1394, 739));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnikActionPerformed
    }//GEN-LAST:event_tnikActionPerformed

    private void tnamawargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamawargaActionPerformed
    }//GEN-LAST:event_tnamawargaActionPerformed

    private void tnamapetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamapetugasActionPerformed
    }//GEN-LAST:event_tnamapetugasActionPerformed

    private void ttempatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttempatActionPerformed
    }//GEN-LAST:event_ttempatActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String tampilan ="yyyy-MM-dd" ; 
        SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
        String tgl = fm.format(tanggal.getDate());

        try {
            if(tkode_vaksin.getText().equals("") || ttempat.getText().equals("") || tanggal.getDate() == null)
            {
                JOptionPane.showMessageDialog(this, "Data tidak boleh kosong !.", "Pesan", JOptionPane.ERROR_MESSAGE);
            }else{
                
                String sql = "insert into penjadwalan values (?,?,?,?,?,?,?)";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, tkode_vaksin.getText());
                stat.setString(2, cmbpetugas.getSelectedItem().toString());
                stat.setString(3, tnamapetugas.getText());
                stat.setString(4, tnamawarga.getText());
                stat.setString(5, tnik.getText());
                stat.setString(6, ttempat.getText());
                stat.setString(7, tgl);

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasi disimpan");
                kosong();
                tkode_vaksin.requestFocus();
                TableTanggal();               
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan "+e);
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        String tampilan ="yyyy-MM-dd"; 
        SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
        String tgl = fm.format(tanggal.getDate());
        try {
            String sql = "update penjadwalan set id_petugas=?, nama_petugas=?, nama_warga=?, nik=?, tempat=?, tanggal=? where kode_vaksin =?";
            PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, cmbpetugas.getSelectedItem().toString());
                stat.setString(2, tnamapetugas.getText());
                stat.setString(3, tnamawarga.getText());
                stat.setString(4, tnik.getText());
                stat.setString(5, ttempat.getText());
                stat.setString(6, tgl);
                stat.setString(7, tkode_vaksin.getText());

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasi dirubah");
                kosong();
                tkode_vaksin.requestFocus();
                TableTanggal();
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
            String sql = "delete from penjadwalan where kode_vaksin ='"+tkode_vaksin.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                tkode_vaksin.requestFocus();
                TableTanggal();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus "+e);                        
            }
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void bcariwargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariwargaActionPerformed
        String key=tcari.getText();
        System.out.println(key);  
        if(!"".equals(key)){
            cariData(key);
        }else{
            dataTable();
        }    }//GEN-LAST:event_bcariwargaActionPerformed

    private void cmbpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbpetugasActionPerformed
        tampil();
    }//GEN-LAST:event_cmbpetugasActionPerformed

    private void tbl_wargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_wargaMouseClicked
        int bar = tbl_warga.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();

        tnamawarga.setText(a);
        tnik.setText(b);
    }//GEN-LAST:event_tbl_wargaMouseClicked

    private void tbl_jadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_jadwalMouseClicked
        int bar = tbl_jadwal.getSelectedRow();
        String a = tabmodel.getValueAt(bar, 0).toString();
        String b = tabmodel.getValueAt(bar, 1).toString();
        String c = tabmodel.getValueAt(bar, 2).toString();
        String d = tabmodel.getValueAt(bar, 3).toString();
        String e = tabmodel.getValueAt(bar, 4).toString();
        String f = tabmodel.getValueAt(bar, 5).toString();

        tkode_vaksin.setText(a);
        cmbpetugas.setSelectedItem(b);
        tnamapetugas.setText(c);
        tnamawarga.setText(d);
        tnik.setText(e);
        ttempat.setText(f);
        tanggal.setDate(getTanggal(tbl_jadwal, 6));     
    }//GEN-LAST:event_tbl_jadwalMouseClicked

    private void tkode_vaksinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkode_vaksinKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            cmbpetugas.requestFocus();
    }//GEN-LAST:event_tkode_vaksinKeyPressed

    private void cmbpetugasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbpetugasKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            tnik.requestFocus();
    }//GEN-LAST:event_cmbpetugasKeyPressed

    private void ttempatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttempatKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            tanggal.requestFocus();
    }//GEN-LAST:event_ttempatKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String path=".\\src\\control\\Penjadwalan.jasper";
        try {
            HashMap pm = new HashMap();
            File rpt = new File(path);
            pm.put("pkode", tkode_vaksin.getText());
            JasperReport jrp = (JasperReport) JRLoader.loadObjectFromFile(rpt.getPath());
            JasperPrint jrpt = JasperFillManager.fillReport(jrp, pm, conn);
            JasperViewer.viewReport(jrpt, false);
        } catch (Exception ex) {
            Logger.getLogger(data_warga.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_jButton1ActionPerformed

    public static Date getTanggal(JTable table, int kolom){
        JTable tabel = table;
        String tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        Date s = null;
        try {
            s = new SimpleDateFormat("yyyy-MM-dd").parse(tgl);
        } catch (ParseException ex) {
            Logger.getLogger(datawarga.class.getName()).log(Level.SEVERE, null, ex);
        }
            return s;
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
            new Jadwal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcariwarga;
    private javax.swing.JButton bclear;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bhome;
    private javax.swing.JButton bsimpan;
    private javax.swing.JComboBox<String> cmbpetugas;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTable tbl_jadwal;
    private javax.swing.JTable tbl_warga;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tkode_vaksin;
    private javax.swing.JTextField tnamapetugas;
    private javax.swing.JTextField tnamawarga;
    private javax.swing.JTextField tnik;
    private javax.swing.JTextField ttempat;
    // End of variables declaration//GEN-END:variables

    protected void TableTanggal(){
        Object[] Baris = {"Kode Vaksin","Kode Petugas","Nama Petugas","Nama Warga","NIK","Tempat","Tanggal"};
        tabmodel = new DefaultTableModel(null, Baris);
        tbl_jadwal.setModel(tabmodel);
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
              
                String[] data={a,b,c,d,e,f,g,};
                tabmodel.addRow(data);
            }
        } catch (SQLException e) {
        }
    }
    
    protected void dataTable(){
        Object[] Baris = {"Nama","NIK","Tanggal Lahir","Jenis Kelamin","Pekerjaan","Umur","Kelompok Umur","Alamat","Hasil Vaksin"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_warga.setModel(tabmode);
        String sql = "select * from warga where hasil_vaksin='BELUM'";
        
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

}
