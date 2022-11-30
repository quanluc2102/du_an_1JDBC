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

    String MaHD;
    String TenNV;
    String TenKH;
    String NgayTao;
    String MaKhuyenMai;
    int TrangThai;
    int TongSoSP;
    float GiaGiam;
    float tongTien;

    public ViewModelHoaDon() {
    }

    public ViewModelHoaDon(String MaHD, String TenNV, String TenKH, String NgayTao, String MaKhuyenMai, int TrangThai, int TongSoSP, float GiaGiam, float tongTien) {
        this.MaHD = MaHD;
        this.TenNV = TenNV;
        this.TenKH = TenKH;
        this.NgayTao = NgayTao;
        this.MaKhuyenMai = MaKhuyenMai;
        this.TrangThai = TrangThai;
        this.TongSoSP = TongSoSP;
        this.GiaGiam = GiaGiam;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getMaKhuyenMai() {
        return MaKhuyenMai;
    }

    public void setMaKhuyenMai(String MaKhuyenMai) {
        this.MaKhuyenMai = MaKhuyenMai;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getTongSoSP() {
        return TongSoSP;
    }

    public void setTongSoSP(int TongSoSP) {
        this.TongSoSP = TongSoSP;
    }

    public float getGiaGiam() {
        return GiaGiam;
    }

    public void setGiaGiam(float GiaGiam) {
        this.GiaGiam = GiaGiam;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String trangthai(int TrangThai) {
        String st = "";
        st = (TrangThai == 0) ? "Chưa Thanh Toán" : "Đã Thanh Toán";
        return st;
    }

    public Object[] dataRow() {
        return new Object[]{MaHD, TenNV, TenKH, NgayTao, MaKhuyenMai, tongTien, trangthai(TrangThai),TongSoSP};
    }
}
