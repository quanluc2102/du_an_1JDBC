/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author quanl
 */
public class ChiTietDienThoai {

    private String IMEI;
    private Boolean trangThai;
    private int moi;
    private String moTa;
    private String idQuocGiaDong;

    public ChiTietDienThoai() {
    }

    public ChiTietDienThoai(String IMEI, Boolean trangThai, int moi, String moTa, String idQuocGiaDong) {
        this.IMEI = IMEI;
        this.trangThai = trangThai;
        this.moi = moi;
        this.moTa = moTa;
        this.idQuocGiaDong = idQuocGiaDong;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getMoi() {
        return moi;
    }

    public void setMoi(int moi) {
        this.moi = moi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getIdQuocGiaDong() {
        return idQuocGiaDong;
    }

    public void setIdQuocGiaDong(String idQuocGiaDong) {
        this.idQuocGiaDong = idQuocGiaDong;
    }
    
    
    
}
