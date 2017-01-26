package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import model.transaksiMODEL;

public class transaksiController 
{
    koneksi conn = new koneksi();
    
    public void simpan(transaksiMODEL tM)
    {
        conn.koneksiDataBase();
        String sql ="insert into tbl_transaksi"
                   + "(KodeTransaksi,KodeBarang,NamaPembeli,"
                   + "NamaBarang,Harga,JumlahBeli,TotalHarga)"
                   + "values ('"+tM.getKodeTransaksi()+"',"
                   + "'"+tM.getKodeBarang()+"',"
                   + "'"+tM.getNamaPembeli()+"',"
                   + "'"+tM.getNamaBarang()+"',"
                   + "'"+tM.getHarga()+"',"
                   + "'"+tM.getJumlahBeli()+"',"
                   + "'"+tM.getTotal()+"')";
        try 
        {
            conn.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Tidak berhasil disimpan");
            System.err.println(""+e);
        }
    }
    
    public void update (transaksiMODEL tM)
    {
        conn.koneksiDataBase();
        
        try 
        {
            int idTransaksi = tM.getIdTransaksi();
            String KodeTransaksi = tM.getKodeTransaksi();
            String KodeBarang = tM.getKodeBarang();
            String NamaPembeli = tM.getNamaPembeli();
            String NamaBarang = tM.getNamaBarang();
            int Harga = tM.getHarga();
            int JumlahBeli = tM.getJumlahBeli();
            int TotalHarga = tM.getTotal();
            
            String sql = "update tbl_transaksi "
                    + "set KodeTransaksi =('" + KodeTransaksi + "'),"
                    + "KodeBarang=('" + KodeBarang + "'),"
                    + "NamaPembeli=('" + NamaPembeli + "'),"
                    + "NamaBarang=('" + NamaBarang + "'),"
                    + "Harga=('" + Harga + "'),"
                    + "JumlahBeli=('" + JumlahBeli + "'),"
                    + "TotalHarga=('"+ TotalHarga +"')"
                    + "where idTransaksi=('" + idTransaksi + "')";
            
            conn.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate..");
        } 
        catch (SQLException e) 
        {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data tidak terupdate");
        }
    }
    
    public void hapus(transaksiMODEL tM)
    {
        conn.koneksiDataBase();
        
        try 
        {
           String sql = "delete from tbl_transaksi where idTransaksi=('"+tM.getIdTransaksi()+"')"; 
           conn.st.executeUpdate(sql);
           JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
        } 
        catch (SQLException e) 
        {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data tidak terhapus");
        }
    }
}
