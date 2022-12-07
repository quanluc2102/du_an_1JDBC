/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.NhanVien;
import java.util.List;

/**
 *
 * @author buiti
 */
public interface LoginService {

    String login(String username, String pass);

    List<String> ChucVuCBB();

    List<String> IDChucVu();

    String dangKi(NhanVien nv);
 
    String loginWebCam(String cmnd);
}
