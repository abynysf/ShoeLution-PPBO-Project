/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Aby
 */
public class DetailPemesananModel {
    private PemesananModel noPemesanan;
    private SepatuModel idSepatu;
    private int jmlPemesanan;
    private double subtotalPemesanan;
    private String status;

    public PemesananModel getNoPemesanan() {
        return noPemesanan;
    }

    public void setNoPemesanan(PemesananModel noPemesanan) {
        this.noPemesanan = noPemesanan;
    }

    public SepatuModel getIdSepatu() {
        return idSepatu;
    }

    public void setIdSepatu(SepatuModel idSepatu) {
        this.idSepatu = idSepatu;
    }

    public int getJmlPemesanan() {
        return jmlPemesanan;
    }

    public void setJmlPemesanan(int jmlPemesanan) {
        this.jmlPemesanan = jmlPemesanan;
    }

  
    public double getSubtotalPemesanan() {
        return subtotalPemesanan;
    }

    public void setSubtotalPemesanan(double subtotalPemesanan) {
        this.subtotalPemesanan = subtotalPemesanan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    
}
