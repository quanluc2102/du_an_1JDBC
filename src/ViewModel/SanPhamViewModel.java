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
    private String srcAnh;
    private String ten;
    private int soLuongCon;
    private String loai;

    public SanPhamViewModel(String srcAnh, String ten, int soLuongCon, String loai) {
        this.srcAnh = srcAnh;
        this.ten = ten;
        this.soLuongCon = soLuongCon;
        this.loai = loai;
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
