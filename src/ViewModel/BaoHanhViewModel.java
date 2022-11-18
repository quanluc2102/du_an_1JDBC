/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author admin
 */
public class BaoHanhViewModel {

    private String id;

    private String thoiGian;

    private boolean donVi;

    public BaoHanhViewModel(String id, String thoiGian, boolean donVi) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.donVi = donVi;
    }

    public BaoHanhViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public boolean isDonVi() {
        return donVi;
    }

    public void setDonVi(boolean donVi) {
        this.donVi = donVi;
    }

    public Object[] toDaTaRow() {
        return new Object[]{id, thoiGian +" "+ layDonVi(donVi)};
    }

    public String layDonVi(boolean donVi) {
        if (donVi == true) {
            return "Ngày";
        } else {
            return "Tháng";
        }
    }
}
