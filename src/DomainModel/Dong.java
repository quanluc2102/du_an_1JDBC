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
@Table(name = "Dong")
public class Dong implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;

    @Column(name = "ma_dong")
    private String ma;

    @Column(name = "ten_dong")
    private String ten;

    @ManyToOne
    @JoinColumn(name = "id_dien_thoai", nullable = false)
    private DienThoai dienThoai;
    
    @OneToMany(mappedBy = "dong", fetch = FetchType.LAZY)
    private List<MauSacDong> listMauSacDongs;

    public Dong(String id, String ma, String ten, DienThoai dienThoai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.dienThoai = dienThoai;
    }

    @Override
    public String toString() {
        return "Dong{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", dienThoai=" + dienThoai + '}';
    }

    
    
    public Dong() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public DienThoai getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(DienThoai dienThoai) {
        this.dienThoai = dienThoai;
    }
    
    
}
