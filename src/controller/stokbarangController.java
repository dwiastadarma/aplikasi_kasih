package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import model.stokbarangMODEL;

public class stokbarangController 
{
    koneksi conn = new koneksi();
    
    public void simpan(stokbarangMODEL sbM)
    {
        conn.koneksiDataBase();
        String sql ="insert into tbl_barang(KodeBarang,NamaBarang,HargaBarang,StokBarang)"
                   + "values ('"+sbM.getKodeBarang()+"',"
                   + "'"+sbM.getNamaBarang()+"',"
                   + "'"+sbM.getHargaBarang()+"',"
                   + "'"+sbM.getStokBarang()+"')";
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
    
    public void update (stokbarangMODEL sbM)
    {
        conn.koneksiDataBase();
        
        try 
        {
            int id = sbM.getIdBarang();
            String kodebarang = sbM.getKodeBarang();
            String NamaBarang = sbM.getNamaBarang();
            int HargaBarang = sbM.getHargaBarang();
            int StokBarang = sbM.getStokBarang();
            
            String sql = "update tbl_barang "
                    + "set KodeBarang =('" + kodebarang + "'),"
                    + "NamaBarang=('" + NamaBarang + "'),"
                    + "HargaBarang=('" + HargaBarang + "'),"
                    + "StokBarang=('"+ StokBarang +"')"
                    + "where idBarang=('" + id + "')";
            
            conn.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate..");
        } 
        catch (SQLException e) 
        {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data tidak terupdate");
        }
    }
    
    public void hapus(stokbarangMODEL sbM)
    {
        conn.koneksiDataBase();
        
        try 
        {
           String sql = "delete from tbl_barang where idBarang=('"+sbM.getIdBarang()+"')"; 
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
