package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class koneksi 
{
    private Connection conn;
    public Connection getKoneksi()
    {
        return conn;
    }
    
    public Statement st;
    public ResultSet rs;
    String namaDataBase = "jdbc:mysql://localhost:3306/db_kasihdwiyusma";
    
    public void koneksiDataBase()
    {
        try 
        {
           conn = DriverManager.getConnection(namaDataBase,"root","");
           System.out.println("Terkoneksi ke database( Packages Koneksi )");
           st = conn.createStatement();
        } 
        catch (Exception e) 
        {
            System.err.println("Cek url, username host dan password host");
            System.err.println("SQLException:"+e.getMessage());
        }
    }
}
