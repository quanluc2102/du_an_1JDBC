/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author quanl
 */
public class HoaDonChiTiet {

    private String id;
    private HoaDon hoaDon;
    private ChiTietDienThoai chiTietDienThoai;
    private BaoHanh baoHanh;

    public HoaDonChiTiet(String id, HoaDon hoaDon, ChiTietDienThoai chiTietDienThoai, BaoHanh baoHanh) {
        this.id = id;
        this.hoaDon = hoaDon;
        this.chiTietDienThoai = chiTietDienThoai;
        this.baoHanh = baoHanh;
    }

    public HoaDonChiTiet() {
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "id=" + id + ", hoaDon=" + hoaDon + ", chiTietDienThoai=" + chiTietDienThoai + ", baoHanh=" + baoHanh + '}';
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
