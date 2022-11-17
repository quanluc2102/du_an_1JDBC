package DomainModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author buiti
 */
@Entity
@Table(name = "ThongSo")
public class ThongSo {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "id_quoc_gia_dong")
    private String idQuocGiaDong;

    @Column(name = "cpu")
    private String cpu;

    @Column(name = "ram")
    private String ram;

    @Column(name = "rom")
    private String rom;

    @Column(name = "sim")
    private String sim;

    @Column(name = "man_hinh")
    private String manHinh;

    @Column(name = "trong_luong")
    private String trongLuong;

    @Column(name = "camera")
    private String camera;

    
    
}
