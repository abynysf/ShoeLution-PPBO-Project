/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import models.PenggunaModel;


/**
 *
 * @author Aby
 */
public class PenggunaTableMod extends AbstractTableModel{
    private final List<PenggunaModel> list = new ArrayList<>();
    
    public void addData(PenggunaModel disModel){
        list.add(disModel);
        fireTableRowsInserted(list.size() - 1,  list.size() -1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void updateData (int row, PenggunaModel disModel){
        list.add(row, disModel);
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
    
    public void setData(List<PenggunaModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    // Overloading
    public void setData(int index, PenggunaModel disModel){
        list.set(index, disModel);
        fireTableRowsUpdated(index, index);
    }
    
    public PenggunaModel getData(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    private final String[] columnNames = {"No", "Id Pengguna", "Nama Pengguna", "Username", "Password", "Telp", "Alamat", "level"};
    
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
            case 0: return list.get(rowIndex).getIdPengguna();
            case 1: return list.get(rowIndex).getNamaPengguna();
            case 2: return list.get(rowIndex).getUsername();
            case 3: return list.get(rowIndex).getPassword();
            case 4: return list.get(rowIndex).getTelpPengguna();
            case 5: return list.get(rowIndex).getAlamatPengguna();
            case 6: return list.get(rowIndex).getLevel();
            
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
