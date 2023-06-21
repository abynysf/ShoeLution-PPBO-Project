/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Aby
 */
public class PemesananModel {
    private String noPemesanan;
    private String tanggalPemesanan;
    private double totalPemesanan;
    private PenggunaModel idPengguna;
    private DistributorModel idDistributor;

    public String getNoPemesanan() {
        return noPemesanan;
    }

    public void setNoPemesanan(String noPemesanan) {
        this.noPemesanan = noPemesanan;
    }

    public String getTanggalPemesanan() {
        return tanggalPemesanan;
    }

    public void setTanggalPemesanan(String tanggalPemesanan) {
        this.tanggalPemesanan = tanggalPemesanan;
    }

    public double getTotalPemesanan() {
        return totalPemesanan;
    }

    public void setTotalPemesanan(double totalPemesanan) {
        this.totalPemesanan = totalPemesanan;
    }

    public PenggunaModel getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(PenggunaModel idPengguna) {
        this.idPengguna = idPengguna;
    }

    public DistributorModel getIdDistributor() {
        return idDistributor;
    }

    public void setIdDistributor(DistributorModel idDistributor) {
        this.idDistributor = idDistributor;
    }
}
