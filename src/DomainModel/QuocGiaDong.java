package DomainModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quanl
 */

public class QuocGiaDong{

    private String id;
 
    private String idDong;
    
    private String idQuocGia;
   
    private String tenHienThi;

   
    private Double giaBan;

    
    private Double giaNhap;

  
    public QuocGiaDong() {
    }

    public QuocGiaDong(String id, String idDong, String idQuocGia, String tenHienThi, Double giaBan, Double giaNhap) {
        this.id = id;
        this.idDong = idDong;
        this.idQuocGia = idQuocGia;
        this.tenHienThi = tenHienThi;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDong() {
        return idDong;
    }

    public void setIdDong(String idDong) {
        this.idDong = idDong;
    }

    public String getIdQuocGia() {
        return idQuocGia;
    }

    public void setIdQuocGia(String idQuocGia) {
        this.idQuocGia = idQuocGia;
    }

    public String getTenHienThi() {
        return tenHienThi;
    }

    public void setTenHienThi(String tenHienThi) {
        this.tenHienThi = tenHienThi;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

}
