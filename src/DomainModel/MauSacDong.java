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
        this.dong = dong;
        this.mauSac = mauSac;
    }

    @Override
    public String toString() {
        return "MauSacDong{" + "id=" + id + ", dong=" + dong + ", mauSac=" + mauSac + '}';
    }

    public MauSacDong() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dong getDong() {
        return dong;
    }

    public void setDong(Dong dong) {
        this.dong = dong;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

}
