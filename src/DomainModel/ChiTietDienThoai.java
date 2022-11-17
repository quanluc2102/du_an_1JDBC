/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static org.hibernate.criterion.Projections.id;

/**
 *
 * @author quanl
 */
@Entity
@Table(name = "ChiTietDienThoai")
public class ChiTietDienThoai {

    @Id
    @Column(name = "IMEI")
    private String IMEI;

    @Column(name = "moi")
    private int moi;
    @Column(name = "mo_ta")
    private String mo_ta;

    @ManyToOne
    @JoinColumn(name = "id_mau_dong", nullable = false)
    private MauSacDong mauSacDong;

    @ManyToOne
    @JoinColumn(name = "id_quoc_gia_dong", nullable = false)
    private QuocGiaDong quocGiaDong;
    
    @OneToMany(mappedBy = "chiTietDienThoai", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHoaDonChiTiets;

    public ChiTietDienThoai(String IMEI, int moi, String mo_ta, MauSacDong mauSacDong, QuocGiaDong quocGiaDong) {
        this.IMEI = IMEI;
        this.moi = moi;
        this.mo_ta = mo_ta;
        this.mauSacDong = mauSacDong;
        this.quocGiaDong = quocGiaDong;
    }

    @Override
    public String toString() {
        return "ChiTietDienThoai{" + "IMEI=" + IMEI + ", moi=" + moi + ", mo_ta=" + mo_ta + ", mauSacDong=" + mauSacDong + ", quocGiaDong=" + quocGiaDong + '}';
    }
    

    public ChiTietDienThoai() {
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public int getMoi() {
        return moi;
    }

    public void setMoi(int moi) {
        this.moi = moi;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public MauSacDong getMauSacDong() {
        return mauSacDong;
    }

    public void setMauSacDong(MauSacDong mauSacDong) {
        this.mauSacDong = mauSacDong;
    }

    public QuocGiaDong getQuocGiaDong() {
        return quocGiaDong;
    }

    public void setQuocGiaDong(QuocGiaDong quocGiaDong) {
        this.quocGiaDong = quocGiaDong;
    }

    
}
