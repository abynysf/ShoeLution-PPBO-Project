/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import models.SepatuModel;

/**
 *
 * @author Aby
 */
public class SepatuTableMod extends AbstractTableModel {
    
    private final List<SepatuModel> list = new ArrayList<>();
    
    public void addData(SepatuModel sModel){
        list.add(sModel);
        fireTableRowsInserted(list.size() - 1,  list.size() -1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void updateData (int row, SepatuModel sModel){
        list.add(row, sModel);
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
    
    public void setData(List<SepatuModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    // Overloading
    public void setData(int index, SepatuModel sModel){
        list.set(index, sModel);
        fireTableRowsUpdated(index, index);
    }
    
    public SepatuModel getData(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    private final String[] columnNames = {"No", "Id Sepatu", "Name Merk", "Nama Sepatu", "Jenis Sepatu", "Warna","ukuran","Harga", "Stok"};

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0){
            return (rowIndex + 1);
        }
        else{
            switch (columnIndex - 1){
                case 0: return list.get(rowIndex).getIdSepatu();
                case 1: return list.get(rowIndex).getNameMerk();
                case 2: return list.get(rowIndex).getNamaSepatu();
                case 3: return list.get(rowIndex).getJenisSepatu();
                case 4: return list.get(rowIndex).getWarna();
                case 5: return list.get(rowIndex).getUkuran();
                case 6: return list.get(rowIndex).getHarga();
                case 7: return list.get(rowIndex).getJumlahStok();
                default: return null;
            }
        }
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0){
            return columnNames[column];
        }
        else{
            return columnNames[column];
        }
    }
}
