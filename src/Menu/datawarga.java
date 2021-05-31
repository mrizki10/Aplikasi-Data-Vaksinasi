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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class datawarga extends javax.swing.JFrame {
    private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private String tanggal;
    
    protected void kosong(){
        tnama_warga.setText("");
        tnik.setText("");
        ttanggal_lahir.setDate(null);
        rjk1.setSelected(true);
        tpekerjaan.setText("");
        tumur.setText("");
        tkelompok_umur.setSelectedIndex(0);
        talamat.setText("");
        thasil.setSelectedIndex(0);
        tcari.setText("");
    }
    
    protected void dataTable(){
        Object[] Baris = {"Nama","NIK","Tanggal Lahir","Jenis Kelamin","Pekerjaan","Umur","Kelompok Umur","Alamat","Hasil Vaksin"};
        tabmode = new DefaultTableModel(null, Baris);
        tabeldatawarga.setModel(tabmode);
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
    
    public datawarga(){
        initComponents();
        dataTable();
    }
    
    private void cariData(String key){
            Object[] Baris = {"Nama","NIK","Tanggal Lahir","Jenis Kelamin","Pekerjaan","Umur","Kelompok Umur","Alamat","Hasil Vaksin"};
            tabmode = new DefaultTableModel(null, Baris);
            tabeldatawarga.setModel(tabmode);            
            String sql = ("SELECT * from warga WHERE nik LIKE '%"+key+"%' OR nama_warga LIKE '%"+key+"%' OR alamat LIKE '%"+key+"%'");  
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        tnik = new javax.swing.JTextField();
        tpekerjaan = new javax.swing.JTextField();
        tumur = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bclear = new javax.swing.JButton();
        tnama_warga = new javax.swing.JTextField();
        bexit = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeldatawarga = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        thasil = new javax.swing.JComboBox<>();
        ttanggal_lahir = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        talamat = new javax.swing.JTextArea();
        rjk2 = new javax.swing.JRadioButton();
        rjk1 = new javax.swing.JRadioButton();
        tkelompok_umur = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Data Vaksinasi");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DATA WARGA");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(420, 10, 200, 60);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NAMA                      ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(120, 80, 120, 14);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NIK                          ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(120, 120, 130, 14);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TANGGAL LAHIR     ");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(120, 160, 130, 14);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("JENIS KELAMIN       ");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(120, 200, 130, 14);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PEKERJAAN             ");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(120, 240, 120, 20);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("UMUR                      ");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(120, 280, 100, 14);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("KELOMPOK UMUR   ");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(120, 320, 140, 14);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("HASIL");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(120, 420, 110, 14);

        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tcariKeyPressed(evt);
            }
        });
        jPanel2.add(tcari);
        tcari.setBounds(550, 70, 210, 30);

        tnik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnikKeyPressed(evt);
            }
        });
        jPanel2.add(tnik);
        tnik.setBounds(290, 110, 240, 30);

        tpekerjaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpekerjaanActionPerformed(evt);
            }
        });
        tpekerjaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tpekerjaanKeyPressed(evt);
            }
        });
        jPanel2.add(tpekerjaan);
        tpekerjaan.setBounds(290, 230, 240, 30);

        tumur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tumurActionPerformed(evt);
            }
        });
        tumur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tumurKeyPressed(evt);
            }
        });
        jPanel2.add(tumur);
        tumur.setBounds(290, 270, 240, 30);

        bcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cari.png"))); // NOI18N
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });
        jPanel2.add(bcari);
        bcari.setBounds(790, 70, 80, 70);

        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/simpan.png"))); // NOI18N
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(bsimpan);
        bsimpan.setBounds(550, 180, 90, 80);

        bedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit.png"))); // NOI18N
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        jPanel2.add(bedit);
        bedit.setBounds(680, 180, 90, 80);

        bclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        bclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bclearActionPerformed(evt);
            }
        });
        jPanel2.add(bclear);
        bclear.setBounds(550, 300, 90, 85);

        tnama_warga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnama_wargaActionPerformed(evt);
            }
        });
        tnama_warga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnama_wargaKeyPressed(evt);
            }
        });
        jPanel2.add(tnama_warga);
        tnama_warga.setBounds(290, 70, 240, 30);

        bexit.setText("HOME");
        bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitActionPerformed(evt);
            }
        });
        jPanel2.add(bexit);
        bexit.setBounds(290, 470, 240, 23);

        bdelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancel.png"))); // NOI18N
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });
        jPanel2.add(bdelete);
        bdelete.setBounds(680, 300, 90, 85);

        tabeldatawarga.setModel(new javax.swing.table.DefaultTableModel(
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
        tabeldatawarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeldatawargaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeldatawarga);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 500, 950, 150);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("DELETE");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(700, 390, 60, 17);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("SIMPAN");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(570, 270, 60, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("EDIT");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(710, 270, 40, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("CLEAR");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(570, 390, 50, 17);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("CARI");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(810, 140, 40, 14);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ALAMAT                  ");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(120, 360, 110, 14);

        thasil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "SUDAH", "BELUM" }));
        jPanel2.add(thasil);
        thasil.setBounds(290, 410, 110, 30);

        ttanggal_lahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ttanggal_lahirKeyPressed(evt);
            }
        });
        jPanel2.add(ttanggal_lahir);
        ttanggal_lahir.setBounds(290, 150, 240, 30);

        talamat.setColumns(20);
        talamat.setRows(5);
        talamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                talamatKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(talamat);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(290, 350, 240, 50);

        rjk2.setText("PEREMPUAN");
        jPanel2.add(rjk2);
        rjk2.setBounds(420, 190, 110, 30);

        rjk1.setText("LAKI-LAKI");
        jPanel2.add(rjk1);
        rjk1.setBounds(290, 190, 110, 30);

        tkelompok_umur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "Remaja", "Dewasa", "Lansia" }));
        tkelompok_umur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkelompok_umurKeyPressed(evt);
            }
        });
        jPanel2.add(tkelompok_umur);
        tkelompok_umur.setBounds(290, 310, 110, 30);

        jButton1.setText("CETAK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(550, 470, 90, 23);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 990, 680);

        setSize(new java.awt.Dimension(1002, 691));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tpekerjaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpekerjaanActionPerformed
    }//GEN-LAST:event_tpekerjaanActionPerformed

    private void tumurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tumurActionPerformed
    }//GEN-LAST:event_tumurActionPerformed

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
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd"); 
        tanggal = fm.format(ttanggal_lahir.getDate());
        try {
            if(tnama_warga.getText().equals("") || tnik.getText().equals("") || ttanggal_lahir.getDate() == null
                    || rjk1.getText().equals("")  || tpekerjaan.getText().equals("")
                    || tumur.getText().equals("")  || tkelompok_umur.getSelectedIndex()==(0)
                    || talamat.getText().equals("")  || thasil.getSelectedIndex()==(0))
            {
                JOptionPane.showMessageDialog(this, "Data tidak boleh kosong !.", "Pesan", JOptionPane.ERROR_MESSAGE);
                kosong();
            }else{               
                String sql = "insert into warga values (?,?,?,?,?,?,?,?,?)";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, tnama_warga.getText());
                stat.setString(2, tnik.getText());
                stat.setString(3, tanggal);
                String jkel ="";
                if (rjk1.isSelected()) jkel="LAKI-LAKI";
                else jkel ="PEREMPUAN";
                stat.setString(4, jkel);
                stat.setString(5, tpekerjaan.getText());
                stat.setString(6, tumur.getText());
                stat.setString(7, tkelompok_umur.getSelectedItem().toString());
                stat.setString(8, talamat.getText());
                stat.setString(9, thasil.getSelectedItem().toString());

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasi disimpan");
                kosong();
                tnama_warga.requestFocus();
                dataTable();               
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan "+e);
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd"); 
        tanggal = fm.format(ttanggal_lahir.getDate());
        try {
            String sql = "update warga set nama_warga=?, tanggal_lahir=?, jenis_kelamin=?, pekerjaan=?, umur=?, kelompok_umur=?, alamat=?, hasil_vaksin=? where nik =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tnama_warga.getText());
            stat.setString(2, tanggal);           
            String jkel ="";
            if (rjk1.isSelected()) jkel="LAKI-LAKI";
            else jkel ="PEREMPUAN";
            stat.setString(3, jkel);           
            stat.setString(4, tpekerjaan.getText());
            stat.setString(5, tumur.getText());
            stat.setString(6, tkelompok_umur.getSelectedItem().toString());
            stat.setString(7, talamat.getText());
            stat.setString(8, thasil.getSelectedItem().toString());
            stat.setString(9, tnik.getText());
         
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasi dirubah");
            kosong();
            tnama_warga.requestFocus();
            dataTable();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal diubah "+e);           
        }
    }//GEN-LAST:event_beditActionPerformed

    private void bclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bclearActionPerformed
        kosong();
        dataTable();
    }//GEN-LAST:event_bclearActionPerformed

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitActionPerformed
        this.setVisible(false);
        new menuadmin().setVisible(true);
    }//GEN-LAST:event_bexitActionPerformed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Hapus","Konfirmasi dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql = "delete from warga where nik ='"+tnik.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                tnama_warga.requestFocus();
                dataTable();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus "+e);                        
            }
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void tnama_wargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnama_wargaActionPerformed
    }//GEN-LAST:event_tnama_wargaActionPerformed

    private void tabeldatawargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeldatawargaMouseClicked
        int bar = tabeldatawarga.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        tnama_warga.setText(a);
        String b = tabmode.getValueAt(bar, 1).toString();
        tnik.setText(b);
        ttanggal_lahir.setDate(getTanggal(tabeldatawarga, 2));
        String d = tabmode.getValueAt(bar, 3).toString();
        if (d.equals("LAKI-LAKI")){
            rjk1.setSelected(true);
            rjk2.setSelected(false);
        }else{
            rjk1.setSelected(false);
            rjk2.setSelected(true);
        }
        String e = tabmode.getValueAt(bar, 4).toString();
        tpekerjaan.setText(e);
        String f = tabmode.getValueAt(bar, 5).toString();
        tumur.setText(f);
        String g = tabmode.getValueAt(bar, 6).toString();
        tkelompok_umur.setSelectedItem(g);
        String h = tabmode.getValueAt(bar, 7).toString();
        talamat.setText(h);
        String i = tabmode.getValueAt(bar, 8).toString();
        thasil.setSelectedItem(i);         
    }//GEN-LAST:event_tabeldatawargaMouseClicked

    private void tnama_wargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnama_wargaKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            tnik.requestFocus();
    }//GEN-LAST:event_tnama_wargaKeyPressed

    private void tnikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnikKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            ttanggal_lahir.requestFocus();    
    }//GEN-LAST:event_tnikKeyPressed

    private void ttanggal_lahirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttanggal_lahirKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            rjk1.requestFocus();
    }//GEN-LAST:event_ttanggal_lahirKeyPressed

    private void tpekerjaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpekerjaanKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            tumur.requestFocus();
    }//GEN-LAST:event_tpekerjaanKeyPressed

    private void tumurKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tumurKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            tkelompok_umur.requestFocus();
    }//GEN-LAST:event_tumurKeyPressed

    private void tkelompok_umurKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkelompok_umurKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            talamat.requestFocus();
    }//GEN-LAST:event_tkelompok_umurKeyPressed

    private void talamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_talamatKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            thasil.requestFocus();
    }//GEN-LAST:event_talamatKeyPressed

    private void tcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyPressed
        int kode=evt.getKeyCode();
        if (kode==KeyEvent.VK_ENTER)
            bcari.requestFocus();
    }//GEN-LAST:event_tcariKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              
        String path=".\\src\\control\\LaporanWarga.jasper";
        try {
            HashMap pm = new HashMap();
            File rpt = new File(path);
            pm.put("pnik", tnik.getText());
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new datawarga().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari;
    private javax.swing.JButton bclear;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bexit;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rjk1;
    private javax.swing.JRadioButton rjk2;
    private javax.swing.JTable tabeldatawarga;
    private javax.swing.JTextArea talamat;
    private javax.swing.JTextField tcari;
    private javax.swing.JComboBox<String> thasil;
    private javax.swing.JComboBox<String> tkelompok_umur;
    private javax.swing.JTextField tnama_warga;
    private javax.swing.JTextField tnik;
    private javax.swing.JTextField tpekerjaan;
    private com.toedter.calendar.JDateChooser ttanggal_lahir;
    private javax.swing.JTextField tumur;
    // End of variables declaration//GEN-END:variables

}
