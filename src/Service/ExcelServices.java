/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.List;

/**
 *
 * @author haha
 */
public interface ExcelServices {
        List<String> getFile(String link);
        
        String barCode(String nhap,String link);
        
        String barCodeIMEI(String link);
}
