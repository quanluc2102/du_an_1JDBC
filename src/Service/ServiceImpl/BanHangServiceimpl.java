/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.ChiTietDienThoai;
import DomainModel.HoaDon;
import Repository.BanHangReponsitory;
import Service.BanHangService;
import ViewModel.ChiTietDienThoaiViewModel;
import ViewModel.DienThoaiViewModel;
import ViewModel.HoaDonChiTietViewModel;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BanHangServiceimpl implements BanHangService {

    BanHangReponsitory bhr = new BanHangReponsitory();

    @Override
    public void getAll(List<DienThoaiViewModel> list) {
        list.addAll(bhr.getAll());
    }

    @Override
    public void showData(DefaultTableModel dtm, List<DienThoaiViewModel> list) {
        dtm.setRowCount(0);
        for (DienThoaiViewModel a : list) {
            dtm.addRow(a.toDataRow());
        }
    }

    @Override
    public void getMaHD(List<String> list) {
        list.addAll(bhr.getAllMaHoaDon());
    }

    @Override
    public void getHDCT(List<HoaDonChiTietViewModel> list, String idHD) {
        list.addAll(bhr.getAllHoaDon(idHD));
    }

    @Override
    public void showDataHoaDon(DefaultTableModel dtm, List<HoaDonChiTietViewModel> list) {
        dtm.setRowCount(0);
        for(HoaDonChiTietViewModel a:list){
            dtm.addRow(a.toDataRowBanHang());
        }
    }

    @Override
    public void getTenKH(List<String> list) {
        list.addAll(bhr.getAllKH());
    }

    @Override
    public void getMaNV(List<String> list) {
        list.addAll(bhr.getAllMaNV());
    }

    @Override
    public void getMaGG(List<String> list) {
        list.addAll(bhr.getAllMaGG());
    }

    @Override
    public String addVaoHDCT(String imei, String maHD) {
        boolean add=bhr.addVaoHoaDonCT(imei, maHD);
        if(add==true){
            return "Thêm thanh công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String deleteHDCT(String imei, String maHD) {
        boolean delete=bhr.deleteHoaDonCT(imei, maHD);
        if(delete==true){
            return "Xóa thanh công";
        }else{
            return "Xóa thất bại";
        }
    }

    @Override
    public String addHD() {
        String maHDThem=bhr.maHD();
        boolean add=bhr.addHoaDon();
        if(add==true){
            return "Thêm thành công " + maHDThem;
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public BigDecimal layGiaHD(String maHD) {
        return bhr.layGiaTien(maHD);
    }

    @Override
    public String thanhToan(String tenKH, String maNV, String maKM, String maHD) {
        boolean update=bhr.thanhToan(tenKH, maNV, maKM, maHD);
        if(update==true){
            return "Thanh toán thành công";
        }else{
            return "Thanh toán thất bại";
        }
    }

    @Override
    public BigDecimal layGiaGiamGiaPhanTram(String maHD) {
        return bhr.layGiaGiamGiaPhantram(maHD);
    }

    @Override
    public BigDecimal layGiaGiamGiaK(String maKM) {
        return bhr.layGiaGiamGiaK(maKM);
    }

    @Override
    public boolean layDonVi(String maKM) {
        return bhr.layDonVi(maKM);
    }

    @Override
    public BigDecimal layGiaThanhTien(BigDecimal tongTien, BigDecimal giamGia) {
        return bhr.layThanhTien(tongTien, giamGia);
    }

    @Override
    public void getAllHoaDonChuaThanhToan(List<HoaDon> list) {
        list.addAll(bhr.getAllHoaDonChuaThanhToan());
    }

    @Override
    public void showDataHoaDonChuaThanhToan(DefaultTableModel dtm, List<HoaDon> list) {
        dtm.setRowCount(0);
        for(HoaDon a:list){
            dtm.addRow(a.toDataRowBanHang());
        }
    }
}
