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
public class MauSacDong implements Serializable {

    private String id;
    private Dong dong;
    private MauSac mauSac;
    private List<ChiTietDienThoai> listChiTietDienThoais;

    public MauSacDong(String id, Dong dong, MauSac mauSac) {
        this.id = id;
        this.idDong = idDong;
        this.idMauSac = idMauSac;
    }

    public MauSacDong() {
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

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }
  

}
