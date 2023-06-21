/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import models.DistributorModel;


/**
 *
 * @author Aby
 */
public class DistributorTableMod extends AbstractTableModel{
    private final List<DistributorModel> list = new ArrayList<>();
    
    public void addData(DistributorModel disModel){
        list.add(disModel);
        fireTableRowsInserted(list.size() - 1,  list.size() -1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void updateData (int row, DistributorModel disModel){
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
    
    public void setData(List<DistributorModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    // Overloading
    public void setData(int index, DistributorModel disModel){
        list.set(index, disModel);
        fireTableRowsUpdated(index, index);
    }
    
    public DistributorModel getData(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    private final String[] columnNames = {"No", "Id Distributor", "Nama Distributor", "Telp Distributor", "Alamat Distributor"};

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
            switch (columnIndex - 1) {
                case 0: return list.get(rowIndex).getIdDistributor();
                case 1: return list.get(rowIndex).getNamaDistributor();
                case 2: return list.get(rowIndex).getTelpDistributor();
                case 3: return list.get(rowIndex).getAlamatDistributor();
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
