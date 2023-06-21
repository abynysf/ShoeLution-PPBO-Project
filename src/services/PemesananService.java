/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.PemesananModel;

/**
 *
 * @author Aby
 */
public interface PemesananService {
    void addData (PemesananModel pModel);
    
    
    PemesananModel getByid (String id);
    
    List<PemesananModel> getData();
    
    List<PemesananModel> search(String id);
    
    String number(); 
}
