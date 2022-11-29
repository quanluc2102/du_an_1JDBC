/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.NhanVien;
import ViewModel.NhanVienView;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author buiti
 */
public interface NhanVienService {

    List<NhanVienView> getAll();

    void showData(DefaultTableModel dtm, List<NhanVienView> list);

    List<String> ChucVuCBB();

    List<String> IDChucVu();

    String dangKi(NhanVien nv);

    String update(NhanVien nv, String id);

    String chuyenTTNV(String id);
}
