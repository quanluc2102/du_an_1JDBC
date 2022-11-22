/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import Service.HoaDonIpml;
import Repository.HoaDonRespository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import ViewModel.ViewModelHoaDon;

/**
 *
 * @author PC
 */
public class HoaDonService implements HoaDonIpml {

    @Override
    public void getAll(List<ViewModelHoaDon> list) {
        list.addAll(new HoaDonRespository().getAll());
    }

    @Override
    public void showData(List<ViewModelHoaDon> list, DefaultTableModel dtm) {
        dtm.setRowCount(0);
        for (ViewModelHoaDon viewModelHoaDon : list) {
            dtm.addRow(viewModelHoaDon.dataRow());
        }
    }

    @Override
    public List<ViewModelHoaDon> search(String maHD) {
        List<ViewModelHoaDon> list = new HoaDonRespository().searchHoaDon(maHD);
        return list;
    }

    @Override
    public void giaCaoxuongThap(List<ViewModelHoaDon> list) {
        list.addAll(new HoaDonRespository().giaCaoXuongThap());

    }

    @Override
    public void giaThapLenCao(List<ViewModelHoaDon> list) {
        list.addAll(new HoaDonRespository().giaThapLenCao());

    }

    @Override
    public String thanhToan(String tenKH, String maNV, String maKM, String maHD) {
        boolean update = new HoaDonRespository().thanhToan(tenKH, maNV, maKM, maHD);
        if (update == true) {
            return "Thanh toán thành công";
        } else {
            return "Thanh toán thất bại";
        }
    }

    @Override
    public void getTenKH(List<String> list) {
        list.addAll(new HoaDonRespository().getAllKH());
    }

    @Override
    public void getMaNV(List<String> list) {
        list.addAll(new HoaDonRespository().getAllMaNV());
    }

    @Override
    public void getMaGG(List<String> list) {
        list.addAll(new HoaDonRespository().getAllMaGG());
    }
    
}
