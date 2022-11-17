/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author quanl
 */
@Entity
@Table(name = "KhuyenMai")
public class KhuyenMai implements Serializable {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "ma_khuyen_mai")
    private String ma;

    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private Date ngayKetThuc;

    @Column(name = "gia_giam")
    private double giaGiam;

    @Column(name = "don_vi")
    private boolean donVi;

    @Column(name = "mo_ta")
    private String moTa;

    @OneToMany(mappedBy = "khuyenMai", fetch = FetchType.LAZY)
    private List<HoaDon> listhHoaDons;

    public KhuyenMai() {
    }

    public KhuyenMai(String id, String ma, Date ngayBatDau, Date ngayKetThuc, double giaGiam, boolean donVi, String moTa, List<HoaDon> listhHoaDons) {
        this.id = id;
        this.ma = ma;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giaGiam = giaGiam;
        this.donVi = donVi;
        this.moTa = moTa;
        this.listhHoaDons = listhHoaDons;
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

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(double giaGiam) {
        this.giaGiam = giaGiam;
    }

    public boolean isDonVi() {
        return donVi;
    }

    public void setDonVi(boolean donVi) {
        this.donVi = donVi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public List<HoaDon> getListhHoaDons() {
        return listhHoaDons;
    }

    public void setListhHoaDons(List<HoaDon> listhHoaDons) {
        this.listhHoaDons = listhHoaDons;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "id=" + id + ", ma=" + ma + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", giaGiam=" + giaGiam + ", donVi=" + donVi + ", moTa=" + moTa + '}';
    }

   
}
