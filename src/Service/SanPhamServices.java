/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.BoNho;
import DomainModel.Cpu;
import DomainModel.HeDieuHanh;
import DomainModel.ManHinh;
import DomainModel.MauSac;
import DomainModel.Pin;
import DomainModel.ThietKe;
import DomainModel.TienIch;
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

    List<Pin> getPin();

    String addPin(Pin hdh);

    String suaPin(Pin hdh);

    List<ThietKe> getTK();

    String addTK(ThietKe tk);

    String suaTK(ThietKe tk);

    List<BoNho> getBN();

    String addBN(BoNho tk);

    String suaBN(BoNho tk);

    List<Cpu> getCPU();

    String addCPU(Cpu tk);

    String suaCPU(Cpu tk);
    
    List<MauSac> getMauSacs();

    String addMauSac(MauSac tk);

    String suaMauSac(MauSac tk);
    
    List<TienIch> getTI();

    String addTI(TienIch tk);

    String suaTI(TienIch tk);
    
    List<ManHinh> getHM();

    String addHM(ManHinh tk);

    String suaHM(ManHinh tk);
    
    List<String> getHang();
    List<String> getDong();
    int moi(String imei);

}
