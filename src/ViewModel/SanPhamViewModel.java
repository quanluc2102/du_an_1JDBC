/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author haha
 */
public class SanPhamViewModel {

    private String id;
    private String srcAnh;
    private String ten;
    private int soLuongCon;
    private String loai;
    private double giaBan;
    private double giaNhap;
    private String moTa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public SanPhamViewModel(String id, String srcAnh, String ten, int soLuongCon, String loai, double giaBan, double giaNhap, String moTa) {
        this.id = id;
        this.srcAnh = srcAnh;
        this.ten = ten;
        this.soLuongCon = soLuongCon;
        this.loai = loai;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.moTa = moTa;
    }



    public SanPhamViewModel() {
    }

    @Override
    public String toString() {
        return "SanPhamViewModel{" + "srcAnh=" + srcAnh + ", ten=" + ten + ", soLuongCon=" + soLuongCon + ", loai=" + loai + '}';
    }

    public String getSrcAnh() {
        return srcAnh;
    }

    public void setSrcAnh(String srcAnh) {
        this.srcAnh = srcAnh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuongCon() {
        return soLuongCon;
    }

    public void setSoLuongCon(int soLuongCon) {
        this.soLuongCon = soLuongCon;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

}
