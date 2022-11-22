/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author PC
 */
public class ViewModelHoaDon {

    String idHD;
    String maHD;
    String tenNV;
    String tenKH;
    String maKM;
    String IMEI;
    Date ngayTao;
    Float tongTien;
    int trangThai;
    int thoiGianBH;
    int donViBH;

    String BHHoanChinh;

    public ViewModelHoaDon(String idHD, String maHD, String tenNV, String tenKH, String maKM, String IMEI, Date ngayTao, Float tongTien, int trangThai, int thoiGianBH, int donViBH, String BHHoanChinh) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.maKM = maKM;
        this.IMEI = IMEI;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.thoiGianBH = thoiGianBH;
        this.donViBH = donViBH;
        this.BHHoanChinh = BHHoanChinh;
    }

    public ViewModelHoaDon(String idHD, String maHD, String tenNV, String tenKH, String maKM, String IMEI, Date ngayTao, Float tongTien, int trangThai, int thoiGianBH, int donViBH) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.maKM = maKM;
        this.IMEI = IMEI;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.thoiGianBH = thoiGianBH;
        this.donViBH = donViBH;
    }

    public ViewModelHoaDon(String maHD, String tenNV, String tenKH, String maKM, String IMEI, Date ngayTao, Float tongTien, int trangThai, int thoiGianBH, int donViBH, String BHHoanChinh) {
        this.maHD = maHD;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.maKM = maKM;
        this.IMEI = IMEI;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.thoiGianBH = thoiGianBH;
        this.donViBH = donViBH;
        this.BHHoanChinh = BHHoanChinh;
    }

    public ViewModelHoaDon(String maHD, String tenNV, String tenKH, String maKM, String IMEI, Date ngayTao, Float tongTien, int trangThai, int thoiGianBH, int donViBH) {
        this.maHD = maHD;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.maKM = maKM;
        this.IMEI = IMEI;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.thoiGianBH = thoiGianBH;
        this.donViBH = donViBH;
    }

    public ViewModelHoaDon() {
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTienKM() {
        return maKM;
    }

    public void setTienKM(String maKM) {
        this.maKM = maKM;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(int thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public int getDonViBH() {
        return donViBH;
    }

    public void setDonViBH(int donViBH) {
        this.donViBH = donViBH;
    }

    public String getBHHoanChinh() {
        return BHHoanChinh;
    }

    public void setBHHoanChinh(String BHHoanChinh) {
        this.BHHoanChinh = BHHoanChinh;
    }

    public String trangThaiHoaDon(int trangThai) {
        return trangThai == 0 ? "Chua thanh toan" : "Da thanh toan";
    }

    public String DonViThoiGianBaoHanh(int donViBH) {
        return donViBH == 0 ? "Ngày" : "Tháng";
    }
    

    public Object[] dataRow() {
        return new Object[]{maHD, tenNV, tenKH, maKM, IMEI, ngayTao, tongTien, trangThaiHoaDon(trangThai), thoiGianBH + " " + DonViThoiGianBaoHanh(donViBH)};
    }

}
