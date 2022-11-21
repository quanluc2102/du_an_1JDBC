/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.ChiTietDienThoai;
import DomainModel.HoaDonChiTiet;
import ViewModel.ChiTietDienThoaiViewModel;
import ViewModel.HoaDonChiTietViewModel;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public interface BanHangService {
    void getAll(List<ChiTietDienThoaiViewModel> list);
    void showData(DefaultTableModel dtm,List<ChiTietDienThoaiViewModel> list);
    void getMaHD(List<String> list);
    void getHDCT(List<HoaDonChiTietViewModel> list,String idHD);
    void showDataHoaDon(DefaultTableModel dtm,List<HoaDonChiTietViewModel> list);
    void getTenKH(List<String> list);
    void getMaNV(List<String> list);
    void getMaGG(List<String> list);
    String addVaoHDCT(String imei,String maHD);
    String deleteHDCT(String imei,String maHD);
    String addHD();
    BigDecimal layGiaHD(String maHD);
    String thanhToan(String tenKH, String maNV, String maKM, String maHD);
}
