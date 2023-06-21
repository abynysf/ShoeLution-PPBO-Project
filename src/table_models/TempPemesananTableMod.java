/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import models.TempPemesananModel;


/**
 *
 * @author Aby
 */
public class TempPemesananTableMod extends AbstractTableModel{
    private final List<TempPemesananModel> list = new ArrayList<>();
    
    public void addData(TempPemesananModel tmp_smModel){
        list.add(tmp_smModel);
        fireTableRowsInserted(list.size() - 1,  list.size() -1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void updateData (int row, TempPemesananModel tmp_smModel){
        list.add(row, tmp_smModel);
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
    
    
    public void setData(List<TempPemesananModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    // Overloading
    public void setData(int index, TempPemesananModel tmp_smModel){
        list.set(index, tmp_smModel);
        fireTableRowsUpdated(index, index);
    }
    
    public TempPemesananModel getData(int index){
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
        return switch (columnIndex) {
            case 0 -> list.get(rowIndex).getsModel().getIdSepatu();
            case 1 -> list.get(rowIndex).getsModel().getNamaSepatu();
            case 2 -> list.get(rowIndex).getsModel().getHarga();
            case 3 -> list.get(rowIndex).getDpModel().getJmlPemesanan();
            case 4 -> list.get(rowIndex).getDpModel().getSubtotalPemesanan();
            default -> null;
        };
    }
    
    @Override
    public String getColumnName(int column){
        return switch (column) {
            case 0 -> "Id Sepatu";
            case 1 -> "Nama Sepatu";
            case 2 -> "Harga";
            case 3 -> "Jumlah Masuk";
            case 4 -> "Subtotal";
            default -> null;
        };
    }

    
}
