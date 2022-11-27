/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.ChiTietDienThoai;
import DomainModel.HoaDon;
import DomainModel.HoaDonChiTiet;
import ViewModel.ChiTietDienThoaiViewModel;
import ViewModel.DienThoaiViewModel;
import ViewModel.HoaDonChiTietViewModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public interface BanHangService {

    void getAll(List<DienThoaiViewModel> list);

    void showData(DefaultTableModel dtm, List<DienThoaiViewModel> list);

    void getMaHD(List<String> list);

    void getHDCT(List<HoaDonChiTietViewModel> list, String maHD);

    void showDataHoaDon(DefaultTableModel dtm, List<HoaDonChiTietViewModel> list);

    void getTenKH(List<String> list);

    void getMaNV(List<String> list);

    void getMaGG(List<String> list);

    void getAllHoaDonChuaThanhToan(List<HoaDon> list);

    void showDataHoaDonChuaThanhToan(DefaultTableModel dtm, List<HoaDon> list);

    void addVaoHDCT(String imei, String maHD);

    void deleteHDCT(String imei, String maHD);

    String addHD();

    int layGiaHD(String maHD);

    int layGiaGiamGiaPhanTram(String maHD);

    int layGiaGiamGiaK(String maKM);

    int layGiaThanhTien(int tongTien, int giamGia);

    String thanhToan(String tenKH, String maNV, String maKM, String maHD);

    boolean layDonVi(String maKM);

    void sapXepHoaDon(List<HoaDon> list);

    void getIMEI(List<String> list, String maDT);
}
