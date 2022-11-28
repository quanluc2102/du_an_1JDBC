/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.ChiTietDienThoai;
import DomainModel.Hang;
import DomainModel.HeDieuHanh;
import DomainModel.ThongSo;
import ViewModel.SanPhamViewModel;
import ViewModel.ThongSoViewModel;
import java.util.List;

/**
 *
 * @author haha
 */
public interface SanPhamServices {

    List<SanPhamViewModel> getAll();

    ThongSoViewModel getAllThongSo(String id);

    String ban(String IMEI);

    List<SanPhamViewModel> timKiem(String x);
 
    List<String> getImei(String id);
    
    List<HeDieuHanh> getHDH();

    String addHDH(HeDieuHanh hdh);
    String suaHDH(HeDieuHanh hdh);
}
