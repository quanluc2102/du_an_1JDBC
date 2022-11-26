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

    private String cpu;
    private String ram;
    private String rom;
    private String mauSac;
    private String heDieuhanh;
    private String manHinh;
    private String pin;
    private String sim;
    private String matTruoc;
    private String matLung;
    private String baoMat;
    private String xuatXu;
    private String camTruoc;
    private String camSau;

    public ThongSoViewModel(String cpu, String ram, String rom, String mauSac, String heDieuhanh, String manHinh, String pin, String sim, String matTruoc, String matLung, String baoMat, String xuatXu) {
        this.cpu = cpu;
        this.ram = ram;
        this.rom = rom;
        this.mauSac = mauSac;
        this.heDieuhanh = heDieuhanh;
        this.manHinh = manHinh;
        this.pin = pin;
        this.sim = sim;
        this.matTruoc = matTruoc;
        this.matLung = matLung;
        this.baoMat = baoMat;
        this.xuatXu = xuatXu;
    }
    

   

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getCamTruoc() {
        return camTruoc;
    }

    public void setCamTruoc(String camTruoc) {
        this.camTruoc = camTruoc;
    }

    public String getCamSau() {
        return camSau;
    }

    public void setCamSau(String camSau) {
        this.camSau = camSau;
    }

    public ThongSoViewModel(String cpu, String ram, String rom, String mauSac, String heDieuhanh, String manHinh, String pin, String sim, String matTruoc, String matLung, String baoMat, String xuatXu, String camTruoc, String camSau) {
        this.cpu = cpu;
        this.ram = ram;
        this.rom = rom;
        this.mauSac = mauSac;
        this.heDieuhanh = heDieuhanh;
        this.manHinh = manHinh;
        this.pin = pin;
        this.sim = sim;
        this.matTruoc = matTruoc;
        this.matLung = matLung;
        this.baoMat = baoMat;
        this.xuatXu = xuatXu;
        this.camTruoc = camTruoc;
        this.camSau = camSau;
    }

 

    @Override
    public String toString() {
        return "ThongSoViewModel{" + "cpu=" + cpu + ", ram=" + ram + ", rom=" + rom + ", mauSac=" + mauSac + ", heDieuhanh=" + heDieuhanh + ", manHinh=" + manHinh + ", pin=" + pin + ", sim=" + sim + ", matTruoc=" + matTruoc + ", matLung=" + matLung + ", baoMat=" + baoMat + '}';
    }

    public ThongSoViewModel() {
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

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getHeDieuhanh() {
        return heDieuhanh;
    }

    public void setHeDieuhanh(String heDieuhanh) {
        this.heDieuhanh = heDieuhanh;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getMatTruoc() {
        return matTruoc;
    }

    public void setMatTruoc(String matTruoc) {
        this.matTruoc = matTruoc;
    }

    public String getMatLung() {
        return matLung;
    }

    public void setMatLung(String matLung) {
        this.matLung = matLung;
    }

    public String getBaoMat() {
        return baoMat;
    }

    public void setBaoMat(String baoMat) {
        this.baoMat = baoMat;
    }

    
}
