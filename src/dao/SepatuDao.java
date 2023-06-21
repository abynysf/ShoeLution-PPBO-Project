/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.Connections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.SepatuModel;
import services.SepatuService;

/**
 *
 * @author Aby
 */
public class SepatuDao implements SepatuService{
    
    private Connection connection;
    
    public SepatuDao(){
        connection = Connections.getConnection();
    }

    @Override
    public void addData(SepatuModel sModel) {
        PreparedStatement st = null;
        String sql = "INSERT INTO sepatu (id_sepatu, nama_merk, nama_sepatu, jenis_sepatu, warna, ukuran, harga, jumlah_stok) VALUES (?,?,?,?,?,?,?,?)";
        try{
            st = connection.prepareStatement(sql);
            
            st.setString(1, sModel.getIdSepatu());
            st.setString(2, sModel.getNameMerk());
            st.setString(3, sModel.getNamaSepatu());
            st.setString(4, sModel.getJenisSepatu());
            st.setString(5, sModel.getWarna());
            st.setInt(6, sModel.getUkuran());
            st.setDouble(7, sModel.getHarga());
            st.setInt(8, sModel.getJumlahStok());
            
            st.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(SepatuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(st!=null){
                try{
                    st.close();
                }
                catch(SQLException ex){
                    Logger.getLogger(SepatuDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void updateData(SepatuModel sModel) {
        PreparedStatement st = null;
        String sql = "UPDATE sepatu SET nama_merk=?, nama_sepatu=?, jenis_sepatu=?, warna=?, ukuran=?, harga=?, jumlah_stok=? WHERE id_sepatu=?";
        try{
            st = connection.prepareStatement(sql);
            
            st.setString(1, sModel.getNameMerk());
            st.setString(2, sModel.getNamaSepatu());
            st.setString(3, sModel.getJenisSepatu());
            st.setString(4, sModel.getWarna());
            st.setInt(5, sModel.getUkuran());
            st.setDouble(6, sModel.getHarga());
            st.setInt(7, sModel.getJumlahStok());
            st.setString(8, sModel.getIdSepatu());
            
            st.executeUpdate();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Perbarui data gagal");
            Logger.getLogger(SepatuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(st!=null){
                try{
                    st.close();
                }
                catch(SQLException ex){
                    Logger.getLogger(SepatuDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deleteData(SepatuModel sModel) {
        PreparedStatement st = null;
        String sql = "DELETE FROM sepatu WHERE id_sepatu=?";
        try{
            st = connection.prepareStatement(sql);
            
            st.setString(1, sModel.getIdSepatu());
            
            st.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(SepatuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(st!=null){
                try{
                    st.close();
                }
                catch(SQLException ex){
                    Logger.getLogger(SepatuDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public SepatuModel getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SepatuModel> getDataById() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SepatuModel> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM sepatu";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                SepatuModel sModel = new SepatuModel();
                
                sModel.setIdSepatu(rs.getString("id_sepatu"));
                sModel.setNameMerk(rs.getString("nama_merk"));
                sModel.setNamaSepatu(rs.getString("nama_sepatu")); 
                sModel.setJenisSepatu(rs.getString("jenis_sepatu"));
                sModel.setWarna(rs.getString("warna"));
                sModel.setUkuran(rs.getInt("ukuran"));
                sModel.setHarga(rs.getDouble("harga"));
                sModel.setJumlahStok(rs.getInt("jumlah_stok"));
                
                list.add(sModel);
            }
            return list;
        }
        catch(SQLException ex){
            Logger.getLogger(SepatuDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally{
            if(rs!=null){
                try{
                    rs.close();
                }
                catch(SQLException ex){
                    Logger.getLogger(SepatuDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<SepatuModel> search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SepatuModel> search2(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String number() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String order = null;
        
        Date now = new Date();
        SimpleDateFormat noFormat = new SimpleDateFormat("yyMM");
        String no = noFormat.format(now);
        
        String sql = "SELECT RIGHT (id_sepatu, 3) AS Nomor "
                + "FROM sepatu "
                + "WHERE id_sepatu LIKE 'S" + no + "%' "
                + "ORDER BY id_sepatu DESC "
                + "LIMIT 1";

        
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()){
                int number = Integer.parseInt(rs.getString("Nomor"));
                number++;
                order = "S" + no + String.format("%03d", number);
            }
            else {
                order = "S" + no + "001";
            }
        }
        catch(SQLException ex){
            Logger.getLogger(SepatuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(st!=null){
                try{
                    st.close();
                }
                catch(SQLException ex){
                    Logger.getLogger(SepatuDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return order;
    }

    @Override
    public String number2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public void updateStock(String id, int updateStock) {
//        try {
//            // Membuat pernyataan SQL untuk mengubah jumlah stok sepatu
//            String sql = "UPDATE Sepatu SET jumlah_stok = jumlah_stok = ? WHERE id_sepatu = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, updateStock);
//            statement.setString(2, id);
//            
//            // Menjalankan pernyataan SQL
//            int rowsUpdated = statement.executeUpdate();
//
//            if (rowsUpdated > 0) {
//                System.out.println("Jumlah stok sepatu berhasil diperbarui.");
//            } else {
//                System.out.println("Gagal mengubah jumlah stok sepatu. Sepatu dengan ID " + id + " tidak ditemukan.");
//            }
//
//            // Menutup pernyataan
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    
    @Override
    public void updateStock(String id, int jumlah) {
        try {
            // Memeriksa apakah sepatu dengan ID yang diberikan ada dalam database
            String checkSql = "SELECT jumlah_stok FROM Sepatu WHERE id_sepatu = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkSql);
            checkStatement.setString(1, id);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                int stokSebelumnya = resultSet.getInt("jumlah_stok");

                if (stokSebelumnya >= jumlah) {
                    int stokBaru = stokSebelumnya + jumlah;

                    // Mengubah jumlah stok sepatu
                    String updateSql = "UPDATE Sepatu SET jumlah_stok = ? WHERE id_sepatu = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateSql);
                    updateStatement.setInt(1, stokBaru);
                    updateStatement.setString(2, id);
                    updateStatement.executeUpdate();

                    System.out.println("Jumlah stok sepatu berhasil diperbarui.");
                } else {
                    System.out.println("Gagal mengurangi jumlah stok sepatu. Jumlah pemesanan melebihi stok yang tersedia.");
                }
            } else {
                System.out.println("Gagal mengurangi jumlah stok sepatu. Sepatu dengan ID " + id + " tidak ditemukan.");
            }

            // Menutup ResultSet dan pernyataan
            resultSet.close();
            checkStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    @Override
    public void ReduceStokSepatu(String id, int jumlahPemesanan) {
        try {
            // Memeriksa apakah sepatu dengan ID yang diberikan ada dalam database
            String checkSql = "SELECT jumlah_stok FROM Sepatu WHERE id_sepatu = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkSql);
            checkStatement.setString(1, id);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                int stokSebelumnya = resultSet.getInt("jumlah_stok");

                if (stokSebelumnya >= jumlahPemesanan) {
                    int stokBaru = stokSebelumnya - jumlahPemesanan;

                    // Mengubah jumlah stok sepatu
                    String updateSql = "UPDATE Sepatu SET jumlah_stok = ? WHERE id_sepatu = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateSql);
                    updateStatement.setInt(1, stokBaru);
                    updateStatement.setString(2, id);
                    updateStatement.executeUpdate();

                    System.out.println("Jumlah stok sepatu berhasil diperbarui.");
                } else {
                    System.out.println("Gagal mengurangi jumlah stok sepatu. Jumlah pemesanan melebihi stok yang tersedia.");
                }
            } else {
                System.out.println("Gagal mengurangi jumlah stok sepatu. Sepatu dengan ID " + id + " tidak ditemukan.");
            }

            // Menutup ResultSet dan pernyataan
            resultSet.close();
            checkStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    
    

