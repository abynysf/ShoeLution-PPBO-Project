/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.DistributorModel;

/**
 *
 * @author Aby
 */
public interface DistributorService {
    void addData (DistributorModel disModel);
    void updateData (DistributorModel disModel);
    void deleteData (DistributorModel disModel);
    
    DistributorModel getByid (String id);
    
    List<DistributorModel> getData();
    
    List<DistributorModel> search(String id);
    
    String number();
}
