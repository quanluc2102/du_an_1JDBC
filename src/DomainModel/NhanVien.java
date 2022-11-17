/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author quanl
 */
@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;

    @Column(name = "ma_nhan_vien")
    private String ma;

    @Column(name = "ten_nhan_vien")
    private String ten;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "dia_chi")
    private String diaChi;

    @ManyToOne
    @JoinColumn(name = "id_chuc_vu", nullable = false)
    private ChucVu chucVu;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "email")
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
