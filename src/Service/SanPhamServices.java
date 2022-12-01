/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.BoNho;
import DomainModel.Cpu;
import DomainModel.HeDieuHanh;
import DomainModel.Pin;
import DomainModel.ThietKe;
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

}
