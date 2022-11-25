/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author haha
 */
public class ThongSoViewModel {

    private String ten;
    private String cpu;
    private String ram;
    private String rom;
    private String sim;
    private String manHinh;
    private String trongLuong;
    private String camera;
    private String heDieuhanh;
    private String pin;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public ThongSoViewModel(String hang, String dong, String quocGia, String ten, String cpu, String ram, String rom, String sim, String manHinh, String trongLuong, String camera, String heDieuhanh, String pin) {
        this.hang = hang;
        this.dong = dong;
        this.quocGia = quocGia;
        this.ten = ten;
        this.cpu = cpu;
        this.ram = ram;
        this.rom = rom;
        this.sim = sim;
        this.manHinh = manHinh;
        this.trongLuong = trongLuong;
        this.camera = camera;
        this.heDieuhanh = heDieuhanh;
        this.pin = pin;
    }
    
  
    public ThongSoViewModel() {
    }

    @Override
    public String toString() {
        return "ThongSoViewModel{" + "hang=" + hang + ", dong=" + dong + ", quocGia=" + quocGia + ", ten=" + ten + ", cpu=" + cpu + ", ram=" + ram + ", rom=" + rom + ", sim=" + sim + ", manHinh=" + manHinh + ", trongLuong=" + trongLuong + ", camera=" + camera + ", heDieuhanh=" + heDieuhanh + '}';
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(String trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getHeDieuhanh() {
        return heDieuhanh;
    }

    public void setHeDieuhanh(String heDieuhanh) {
        this.heDieuhanh = heDieuhanh;
    }

}
