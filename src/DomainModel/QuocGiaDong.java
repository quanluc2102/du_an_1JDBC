package DomainModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "QuocGiaDong")
public class QuocGiaDong implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;

    @Column(name = "ten_hien_thi")
    private String tenHienThi;

    @Column(name = "gia_ban")
    private BigDecimal giaBan;

    @Column(name = "gia_Nhap")
    private BigDecimal giaNhap;

    @ManyToOne
    @JoinColumn(name = "id_dong", nullable = false)
    private Dong dong;

    @ManyToOne
    @JoinColumn(name = "id_quoc_gia", nullable = false)
    private QuocGia quocGia;

    @OneToMany(mappedBy = "quocGiaDong", fetch = FetchType.LAZY)
    private List<ChiTietDienThoai> listChiTietDienThoais;

    public QuocGiaDong() {
    }

    @Override
    public String toString() {
        return "QuocGiaDong{" + "id=" + id + ", tenHienThi=" + tenHienThi + ", giaBan=" + giaBan + ", giaNhap=" + giaNhap + ", dong=" + dong + ", quocGia=" + quocGia + '}';
    }

    public QuocGiaDong(String id, String tenHienThi, BigDecimal giaBan, BigDecimal giaNhap, Dong dong, QuocGia quocGia) {
        this.id = id;
        this.tenHienThi = tenHienThi;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.dong = dong;
        this.quocGia = quocGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenHienThi() {
        return tenHienThi;
    }

    public void setTenHienThi(String tenHienThi) {
        this.tenHienThi = tenHienThi;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Dong getDong() {
        return dong;
    }

    public void setDong(Dong dong) {
        this.dong = dong;
    }

    public QuocGia getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(QuocGia quocGia) {
        this.quocGia = quocGia;
    }

}
