    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.NhanVien;
import ViewModel.NhanVienView;
import ViewModel.ThongTinNguoiDungView;
import ViewModel.checkTrungManv;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author buiti
 */
public interface NhanVienService {

    List<NhanVienView> getAll();

    List<NhanVien> getAlls();

    void showData(DefaultTableModel dtm, List<NhanVienView> list);

    List<String> ChucVuCBB();

    List<String> IDChucVu();

    String dangKi(NhanVien nv);

    String update(NhanVien nv,String id);

    String chuyenTTNV(String id);
    
    List<NhanVienView> getAllNhanVienSearch(int rowOffset);
    
    List<NhanVienView> searchNhanVien(String tenNhanVien);
     
    List<ThongTinNguoiDungView> layThongTin(String ma);
    
    void checkTrungIMEI(String maHD,List<checkTrungManv> list);
}
