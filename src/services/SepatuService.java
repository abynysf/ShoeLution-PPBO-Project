/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.SepatuModel;

/**
 *
 * @author Aby
 */
public interface SepatuService {
    void addData (SepatuModel sModel);
    void updateData (SepatuModel sModel);
    void deleteData (SepatuModel sModel);
    void updateStock (String id, int updateStock);
    void ReduceStokSepatu(String id, int jumlahPemesanan);
    
    SepatuModel getByid (String id);
    
    List<SepatuModel> getDataById();
    List<SepatuModel> getData();
    
    List<SepatuModel> search(String id);
    List<SepatuModel> search2(String id);
    
    String number();
    String number2();
}
