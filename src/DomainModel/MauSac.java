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
public class MauSac implements Serializable {
    private String id;
    private String ma;
    private String ten;
    private List<MauSacDong> listMauSacDongs;

    public MauSac(String id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        
    }

    @Override
    public String toString() {
        return "MauSac{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + '}';
    }

    public MauSac() {
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
