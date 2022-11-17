package DomainModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quanl
 */
public class MauSacDong{

    private String id;
    private String iddong;
    private String idMauSac;

    public MauSacDong() {
    }

    public MauSacDong(String id, String iddong, String idMauSac) {
        this.id = id;
        this.iddong = iddong;
        this.idMauSac = idMauSac;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIddong() {
        return iddong;
    }

    public void setIddong(String iddong) {
        this.iddong = iddong;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }
    
    


}
