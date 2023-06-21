/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.PenggunaModel;

/**
 *
 * @author Aby
 */
public interface PenggunaService {
    void addData (PenggunaModel penggunaModel);
    void deleteData (PenggunaModel penggunaModel);
    void updateData (PenggunaModel penggunaModel);    
    
    PenggunaModel getByid (String id);
    
    List<PenggunaModel> getData();
    
    List<PenggunaModel> search(String id);
    
    String number();
    
    boolean changePassword(String username, String passLama, String passBaru);
    boolean validateOldPassword(String username, String passLama);
}
