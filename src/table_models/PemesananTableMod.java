/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import models.PemesananModel;


/**
 *
 * @author Aby
 */
public class PemesananTableMod extends AbstractTableModel{
    private List<PemesananModel> list = new ArrayList<>();
    
    public void addData(PemesananModel pModel){
        list.add(pModel);
        fireTableRowsInserted(list.size() - 1,  list.size() -1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void updateData (int row, PemesananModel pModel){
        list.add(row, pModel);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data berhasil diperbarui");
    }
    
    
    public void deleteData (int index){
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
    }
    
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    
    public void setData(List<PemesananModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    // Overloading
    public void setData(int index, PemesananModel pModel){
        list.set(index, pModel);
        fireTableRowsUpdated(index, index);
    }
    
    public PemesananModel getData(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return list.get(rowIndex).getNoPemesanan();
            case 1: return list.get(rowIndex).getTanggalPemesanan();
            case 2: return list.get(rowIndex).getTotalPemesanan();
            case 3: return list.get(rowIndex).getIdPengguna().getIdPengguna();
            case 4: return list.get(rowIndex).getIdDistributor().getIdDistributor();
            
            default: return null;
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0: return "No Pemesanan";
            case 1: return "Tanggal";
            case 2: return "Total Pemesanan";
            case 3: return "Id Penggunan";
            case 4: return "Id Distributor";
            
            default: return null;
        }
    }
}
