/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author quanl
 */

public class KhachHang implements Serializable {

    private String id;
    private String ten;
    private Date ngaySinh;
    private String sdt;
    private String email;
 
    public KhachHang() {
    }

    public KhachHang(String id, String ten, Date ngaySinh, String sdt, String email) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", ten=" + ten + ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + ", email=" + email + '}';
    }

        
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
