/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.io.Serializable;

/**
 *
 * @author quanl
 */

public class NhanVien implements Serializable {
    private String id;
    private String ma;
    private String ten;
    private String ngaySinh;
    private String sdt;
    private String diaChi;
    private ChucVu chucVu;
    private String matKhau;
    private String email;

    public NhanVien() {
    }

    public NhanVien(String id, String ma, String ten, String ngaySinh, String sdt, String diaChi, ChucVu chucVu, String matKhau, String email) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.matKhau = matKhau;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + ", diaChi=" + diaChi + ", idchucVu=" + chucVu + ", matKhau=" + matKhau + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    
    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public ChucVu getchucVu() {
        return chucVu;
    }

    public void setchucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
 public Object[] toDataRow(){
     return new Object[]{id,ma,ten,ngaySinh,sdt,diaChi,chucVu.getTen(),matKhau};
 }
} 
