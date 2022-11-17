/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author quanl
 */
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_hoa_don", nullable = false)
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "IMEI", nullable = false)
    private ChiTietDienThoai chiTietDienThoai;

    @ManyToOne
    @JoinColumn(name = "id_bao_hanh", nullable = false)
    private BaoHanh baoHanh;

    public HoaDonChiTiet(String id, HoaDon hoaDon, ChiTietDienThoai chiTietDienThoai, BaoHanh baoHanh) {
        this.id = id;
        this.hoaDon = hoaDon;
        this.chiTietDienThoai = chiTietDienThoai;
        this.baoHanh = baoHanh;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "id=" + id + ", hoaDon=" + hoaDon + ", chiTietDienThoai=" + chiTietDienThoai + ", baoHanh=" + baoHanh + '}';
    }

    public HoaDonChiTiet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public ChiTietDienThoai getChiTietDienThoai() {
        return chiTietDienThoai;
    }

    public void setChiTietDienThoai(ChiTietDienThoai chiTietDienThoai) {
        this.chiTietDienThoai = chiTietDienThoai;
    }

    public BaoHanh getBaoHanh() {
        return baoHanh;
    }

    public void setBaoHanh(BaoHanh baoHanh) {
        this.baoHanh = baoHanh;
    }

}
