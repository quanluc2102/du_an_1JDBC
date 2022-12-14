/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.ChucVu;
import java.util.List;

/**
 *
 * @author haha
 */
public interface ExcelServices {

    List<String> getFile(String link);

    String exFileexcel(String link, List<ChucVu> vc);

    String barCode(String nhap, String link);

    String barCodeIMEI(String link);
}
