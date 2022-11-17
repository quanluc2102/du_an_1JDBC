package DomainModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author quanl
 */
@Entity
@Table(name = "MauSacDong")
public class MauSacDong implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_dong", nullable = false)
    private Dong dong;

    @ManyToOne
    @JoinColumn(name = "id_mau_sac", nullable = false)
    private MauSac mauSac;

    @OneToMany(mappedBy = "mauSacDong", fetch = FetchType.LAZY)
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
