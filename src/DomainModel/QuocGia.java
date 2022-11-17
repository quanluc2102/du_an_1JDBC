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
@Table(name = "QuocGia")
public class QuocGia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;

    @Column(name = "ma_quoc_gia")
    private String ma;

    @Column(name = "ten_quoc_gia")
    private String ten;

    @OneToMany(mappedBy = "quocGia", fetch = FetchType.LAZY)
    private List<QuocGiaDong> listQuocGiaDongs;

    public QuocGia(String id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        
    }

    @Override
    public String toString() {
        return "QuocGia{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + '}';
    }

    public QuocGia() {
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

   
}
