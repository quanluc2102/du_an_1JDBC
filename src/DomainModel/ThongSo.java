package DomainModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author buiti
 */
public class ThongSo {

    private String id;

    private String idQuocGiaDong;

    private String cpu;

    private String ram;

    private String rom;

    private String sim;

    private String manHinh;
    private String trongLuong;
    private String camera;
    private String heDieuhanh ;

    public ThongSo() {
    }

    @Override
    public String toString() {
        return "ThongSo{" + "id=" + id + ", idQuocGiaDong=" + idQuocGiaDong + ", cpu=" + cpu + ", ram=" + ram + ", rom=" + rom + ", sim=" + sim + ", manHinh=" + manHinh + ", trongLuong=" + trongLuong + ", camera=" + camera + ", heDieuhanh=" + heDieuhanh + '}';
    }

    public ThongSo(String id, String idQuocGiaDong, String cpu, String ram, String rom, String sim, String manHinh, String trongLuong, String camera, String heDieuhanh) {
        this.id = id;
        this.idQuocGiaDong = idQuocGiaDong;
        this.cpu = cpu;
        this.ram = ram;
        this.rom = rom;
        this.sim = sim;
        this.manHinh = manHinh;
        this.trongLuong = trongLuong;
        this.camera = camera;
        this.heDieuhanh = heDieuhanh;
    }

    

    public String getHeDieuhanh() {
        return heDieuhanh;
    }

    public void setHeDieuhanh(String heDieuhanh) {
        this.heDieuhanh = heDieuhanh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdQuocGiaDong() {
        return idQuocGiaDong;
    }

    public void setIdQuocGiaDong(String idQuocGiaDong) {
        this.idQuocGiaDong = idQuocGiaDong;
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
    

}
