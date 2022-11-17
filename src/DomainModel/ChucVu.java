/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

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
 * @author ADMIN
 */
@Entity
@Table(name = "ChucVu")
public class ChucVu implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "ma_chuc_vu")
    private String ma;

    @Column(name = "ten_chuc_vu")
    private String ten;

    @OneToMany(mappedBy = "chucVu", fetch = FetchType.LAZY)
    private List<NhanVien> listNhanVien;

    public ChucVu(String id, String ma, String ten, List<NhanVien> listNhanVien) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.listNhanVien = listNhanVien;
    }

    public List<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public void setListNhanVien(List<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    @Override
    public String toString() {
        return "ChucVu{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + '}';
    }

    public ChucVu() {
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
