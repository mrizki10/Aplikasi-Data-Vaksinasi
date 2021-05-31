/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.sql.*;
        
        
        
        
public class koneksi {

    public static Connection getKoneksi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Connection koneksi;
    public Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil koneksi");
        } catch (ClassNotFoundException e) {
            System.out.println("Gagal Koneksi "+e);
        }
        
        String url = "jdbc:mysql://localhost/datavaksinasi";
        try {
            koneksi = DriverManager.getConnection(url, "root", "");
            System.out.println("Berhasil koneksi Database");
        } catch (SQLException e) {
            System.out.println("Gagal koneksi database "+e);
        }
        return koneksi;
    }
    
}
