/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Repository.BanHangReponsitory;

/**
 *
 * @author ADMIN
 */
public class ChiTietDienThoaiViewModel {
    private String IMEI;
    private String idMauDong;
    private String idQuocGiaDong;
    private Boolean trangThai;
    private int moi;
    private String moTa;
    private BanHangReponsitory bhr=new BanHangReponsitory();

    public ChiTietDienThoaiViewModel() {
    }

    public ChiTietDienThoaiViewModel(String IMEI, String idMauDong, String idQuocGiaDong, Boolean trangThai, int moi, String moTa) {
        this.IMEI = IMEI;
        this.idMauDong = idMauDong;
        this.idQuocGiaDong = idQuocGiaDong;
        this.trangThai = trangThai;
        this.moi = moi;
        this.moTa = moTa;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getIdMauDong() {
        return idMauDong;
    }

    public void setIdMauDong(String idMauDong) {
        this.idMauDong = idMauDong;
    }

    public String getIdQuocGiaDong() {
        return idQuocGiaDong;
    }

    public void setIdQuocGiaDong(String idQuocGiaDong) {
        this.idQuocGiaDong = idQuocGiaDong;
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

    public BanHangReponsitory getBhr() {
        return bhr;
    }

    public void setBhr(BanHangReponsitory bhr) {
        this.bhr = bhr;
    }
    public String layTenSP(){
        return bhr.layTenSP(IMEI);
    }
    public int layGia(){
        return bhr.layGia(idQuocGiaDong);
    }
    public Object[] toDataRowBanHangView(){
        return new Object[]{IMEI,layTenSP(),layGia()};
    }
}
