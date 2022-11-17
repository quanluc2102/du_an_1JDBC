package DomainModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author quanl
 */

public class BaoHanh implements Serializable {


    private String id;


    private String thoiGian;


    private boolean donVi;



    private List<HoaDonChiTiet> listHoaDonChiTiets;

    public BaoHanh(String id, String thoiGian, boolean donVi) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.donVi = donVi;
    }

    public BaoHanh() {
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

    public List<HoaDonChiTiet> getListHoaDonChiTiets() {
        return listHoaDonChiTiets;
    }

    public void setListHoaDonChiTiets(List<HoaDonChiTiet> listHoaDonChiTiets) {
        this.listHoaDonChiTiets = listHoaDonChiTiets;
    }

   
    
}
