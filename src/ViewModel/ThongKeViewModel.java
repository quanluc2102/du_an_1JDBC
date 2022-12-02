/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class ThongKeViewModel {

    private String Imei;
    private String maHD;
    private Date ngayTao;
    private Double giaBan;
    private double giaGiam;
    private Double giaNhap;
//    private Boolean trangThai;

    public ThongKeViewModel() {
    }

    public ThongKeViewModel(String Imei, String maHD, Date ngayTao, Double giaBan, double giaGiam, Double giaNhap) {
        this.Imei = Imei;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.giaBan = giaBan;
        this.giaGiam = giaGiam;
        this.giaNhap = giaNhap;
    }

    public String getImei() {
        return Imei;
    }

    public void setImei(String Imei) {
        this.Imei = Imei;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(double giaGiam) {
        this.giaGiam = giaGiam;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

//    public String trangThai() {
//
//        if (trangThai == true) {
//            return "Còn hàng ";
//        } else {
//            return "Hết hàng";
//        }
//    }
    public Double ThanhTien() {
        Double tt;

        return tt = giaBan - giaGiam;

    }

    public Double giaGiam() {
        if (giaGiam <= 100) {
            return (giaGiam / 100) * giaBan;
        } else {
            return giaGiam;
        }
    }

    public Double lai() {
        Double lai;

        return lai = giaBan - giaNhap-giaGiam();
    }

    public Object[] toDaTaRow() {
        DecimalFormat df = new DecimalFormat("###,###,###,###");

        return new Object[]{Imei, maHD, df.format(giaBan), ngayTao, df.format(giaGiam()), df.format(giaNhap), df.format(ThanhTien()), df.format(lai())};
    }

}
