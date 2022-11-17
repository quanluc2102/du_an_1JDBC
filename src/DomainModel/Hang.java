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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author quanl
 */
 @Entity
@Table(name = "Hang")
public class Hang implements Serializable {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "ma_hang")
    private String ma;

   @Column(name = "ten_hang")
    private String ten;   
   
   @OneToMany(mappedBy = "hang", fetch = FetchType.LAZY)
    private List<DienThoai> listDienThoais ;

    public Hang(String id, String ma, String ten, List<DienThoai> listDienThoais) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.listDienThoais = listDienThoais;
    }

    public List<DienThoai> getListDienThoais() {
        return listDienThoais;
    }

    public void setListDienThoais(List<DienThoai> listDienThoais) {
        this.listDienThoais = listDienThoais;
    }
   
    

    public Hang() {
    }

    @Override
    public String toString() {
        return "Hang{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + '}';
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


