/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModel.VIewModelSanPhamHoaDon;
import ViewModel.ViewModelHoaDon;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public interface HoaDonIpml {

    List<ViewModelHoaDon> getAll(List<ViewModelHoaDon> list);

    List<ViewModelHoaDon> getAll5Rows(int rowOfSet);

    List<ViewModelHoaDon> searchHoaDon(String mahd, int rowOfSet);

    List<ViewModelHoaDon> giaCaoXuongThap(int rowOfSet);

    List<ViewModelHoaDon> giaThapLenCao(int rowOfSet);

    List<VIewModelSanPhamHoaDon> getAllSp(String mahd);

    void showData(List<ViewModelHoaDon> list, DefaultTableModel dtm);
    
    void showData1(List<VIewModelSanPhamHoaDon> list, DefaultTableModel dtm);

}
