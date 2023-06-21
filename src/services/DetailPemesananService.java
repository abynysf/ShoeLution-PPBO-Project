/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.DetailPemesananModel;

/**
 *
 * @author Aby
 */
public interface DetailPemesananService {
    void addData (DetailPemesananModel dpModel);
    void sumTotal (DetailPemesananModel dpModel);
    void tempDelete (DetailPemesananModel dpModel);    
    
    DetailPemesananModel getByid (String id);
    
    List<DetailPemesananModel> getData(String id);
    
    List<DetailPemesananModel> search(String id);
}
