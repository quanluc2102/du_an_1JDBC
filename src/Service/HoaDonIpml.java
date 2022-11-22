/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModel.ViewModelHoaDon;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public interface HoaDonIpml {

    void getAll(List<ViewModelHoaDon> list);

    void showData(List<ViewModelHoaDon> list, DefaultTableModel dtm);

    List<ViewModelHoaDon> search(String maHD);

    void giaCaoxuongThap(List<ViewModelHoaDon> list);

    void giaThapLenCao(List<ViewModelHoaDon> list);

    String thanhToan(String tenKH, String maNV, String maKM, String maHD);

    void getTenKH(List<String> list);

    void getMaNV(List<String> list);

    void getMaGG(List<String> list);
}
