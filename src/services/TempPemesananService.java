/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.TempPemesananModel;


/**
 *
 * @author Aby
 */
public interface TempPemesananService {
    void addData (TempPemesananModel tmp_pModel);
    void updateData (TempPemesananModel tmp_pModel);
    void deleteData (TempPemesananModel tmp_pModel);
    
    TempPemesananModel getByid (String id);
    
    List<TempPemesananModel> getData();
}
