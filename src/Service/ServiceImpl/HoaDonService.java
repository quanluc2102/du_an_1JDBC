/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import Service.HoaDonIpml;
import Repository.HoaDonRespository;
import ViewModel.VIewModelSanPhamHoaDon;
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
    public List<ViewModelHoaDon> getAll(List<ViewModelHoaDon> list) {
        return new HoaDonRespository().getAllHoaDon();
    }

    @Override
    public void showData(List<ViewModelHoaDon> list, DefaultTableModel dtm) {
        dtm.setRowCount(0);
        for (ViewModelHoaDon viewModelHoaDon : list) {
            dtm.addRow(viewModelHoaDon.dataRow());
        }
    }

    @Override
    public List<ViewModelHoaDon> getAll5Rows(int rowOfSet) {

        return new HoaDonRespository().getAllHoaDon5Rows(rowOfSet);
    }

    @Override
    public List<ViewModelHoaDon> searchHoaDon(String mahd) {

        List<ViewModelHoaDon> listSearch = new ArrayList<>();
        listSearch = new HoaDonRespository().searchHoaDon(mahd);
        return listSearch;
    }

    @Override
    public List<ViewModelHoaDon> giaCaoXuongThap() {
        return new HoaDonRespository().giaCaoXuongThap();
    }

    @Override
    public List<ViewModelHoaDon> giaThapLenCao() {
        return new HoaDonRespository().giaThapLenCao();

    }

    @Override
    public List<VIewModelSanPhamHoaDon> getAllSp(String mahd) {
        return new HoaDonRespository().getAllSanPham(mahd);
    }

    @Override
    public void showData1(List<VIewModelSanPhamHoaDon> list, DefaultTableModel dtm) {
        dtm.setRowCount(0);
        for (VIewModelSanPhamHoaDon vIewModelSanPhamHoaDon : list) {
            dtm.addRow(vIewModelSanPhamHoaDon.dataRowSPHoaDon());
        }
    }

    @Override
    public List<ViewModelHoaDon> searchTenNV(String name) {
        List<ViewModelHoaDon> list = new ArrayList<>();
        list = new HoaDonRespository().searchHoaDonTheoTenNV(name);
        return list;
    }

    @Override
    public List<ViewModelHoaDon> searchTenKH(String name) {
        List<ViewModelHoaDon> list = new ArrayList<>();
        list = new HoaDonRespository().searchHoaDonTheoTenKH(name);
        return list;
    }

}
