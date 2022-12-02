/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.HoaDon;
import ViewModel.KhachHangViewModel;
import ViewModel.ThongKeViewModel;
import ViewModel.ThongSoViewModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public interface ThongKeService {

    List<KhachHangViewModel> getAllKhachHang(int rowOffset);

    void showDaTaTable(DefaultTableModel dtm, List<KhachHangViewModel> list);

    List<HoaDon> searchTheoNgay(String ngay);

    void showDaTa(DefaultTableModel dtm, List<ThongKeViewModel> listHD);

    List<ThongKeViewModel> getLisst();

    List<ThongKeViewModel> searchNgay(String Ngay, List<ThongKeViewModel> listTK);

    List<ThongKeViewModel> searchThang(String Thang, List<ThongKeViewModel> listTKK);

//    List<String> Day();

}