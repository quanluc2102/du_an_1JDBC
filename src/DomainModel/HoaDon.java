/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author quanl
 */
@Entity
@Table(name = "HoaDon")
public class HoaDon {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "ma_hoa_don")
    private String maHoaDon;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "trang_thai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang", nullable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien", nullable = false)
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "id_khuyen_mai", nullable = false)
    private KhuyenMai khuyenMai;
    
    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHoaDonChiTiets;

    public HoaDon() {
    }

    public HoaDon(String id, String maHoaDon, Date ngayTao, String moTa, int trangThai, KhachHang khachHang, NhanVien nhanVien, KhuyenMai khuyenMai) {
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.khuyenMai = khuyenMai;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", maHoaDon=" + maHoaDon + ", ngayTao=" + ngayTao + ", moTa=" + moTa + ", trangThai=" + trangThai + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", khuyenMai=" + khuyenMai + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

}
