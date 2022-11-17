package DomainModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "DienThoai")
public class DienThoai {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "ma_dien_thoai")
    private String ma;

    @Column(name = "ten_dien_thoai")
    private String ten;

    @ManyToOne
    @JoinColumn(name = "id_hang", nullable = false)
    private Hang hang;
    
     @OneToMany(mappedBy = "dienThoai", fetch = FetchType.LAZY)
    private List<Dong> listDongs ;

    @Override
    public String toString() {
        return "DienThoai{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", hang=" + hang + '}';
    }

    public DienThoai(String id, String ma, String ten, Hang hang) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.hang = hang;
    }

    public DienThoai() {
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

    public Hang getHang() {
        return hang;
    }

    public void setHang(Hang hang) {
        this.hang = hang;
    }

}
