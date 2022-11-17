package DomainModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quanl
 */

public class MauSacDong {
  private String id;
  private String idDong;
  private String idMauSac;

    public MauSacDong(String id, String idDong, String idMauSac) {
        this.id = id;
        this.idDong = idDong;
        this.idMauSac = idMauSac;
    }

    public MauSacDong() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDong() {
        return idDong;
    }

    public void setIdDong(String idDong) {
        this.idDong = idDong;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }
  

}
