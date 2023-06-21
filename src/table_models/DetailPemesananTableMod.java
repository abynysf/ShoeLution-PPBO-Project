/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import models.DetailPemesananModel;


/**
 *
 * @author Aby
 */
public class DetailPemesananTableMod extends AbstractTableModel{
    private List<DetailPemesananModel> list = new ArrayList<>();
    
    public void addData(DetailPemesananModel dpModel){
        list.add(dpModel);
        fireTableRowsInserted(list.size() - 1,  list.size() -1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void updateData (int row, DetailPemesananModel dpModel){
        list.add(row, dpModel);
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
    
    public void setData(List<DetailPemesananModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    // Overloading
    public void setData(int index, DetailPemesananModel dpModel){
        list.set(index, dpModel);
        fireTableRowsUpdated(index, index);
    }
    
    public DetailPemesananModel getData(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return list.get(rowIndex).getNoPemesanan().getNoPemesanan();
            case 1: return list.get(rowIndex).getIdSepatu().getIdSepatu();
            case 2: return list.get(rowIndex).getIdSepatu().getNamaSepatu();
            case 3: return list.get(rowIndex).getIdSepatu().getHarga();
            case 4: return list.get(rowIndex).getJmlPemesanan();
            case 5: return list.get(rowIndex).getSubtotalPemesanan();
            case 6: return list.get(rowIndex).getStatus();
            
            default: return null;
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0: return "No Pemesanan";
            case 1: return "Id Sepatu";
            case 2: return "Nama Sepatu";
            case 3: return "Harga";
            case 4: return "Jumlah Pemesanan";
            case 5: return "Subtotal";
            case 6: return "Keterangan";
            
            default: return null;
        }
    }
}
