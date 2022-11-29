/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.HeDieuHanh;
import DomainModel.Pin;
import DomainModel.ThietKe;
import Repository.SanPhamRespository;
import Repository.ThongSoReponsitory;
import Service.SanPhamServices;
import ViewModel.SanPhamViewModel;
import ViewModel.ThongSoViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haha
 */
public class SanPhamServicesImpl implements SanPhamServices {

    @Override
    public List<SanPhamViewModel> getAll() {
        return new SanPhamRespository().getAll();
    }

    @Override
    public ThongSoViewModel getAllThongSo(String id) {
        return new SanPhamRespository().getAllThongSoView(id);
    }

    @Override
    public String ban(String IMEI) {
        if (new SanPhamRespository().ban(IMEI)) {
            return "ban thanh cong";
        }

        return "ban that bai";
    }

    @Override
    public List<SanPhamViewModel> timKiem(String x) {
        List<SanPhamViewModel> s = new ArrayList<>();
        for (SanPhamViewModel y : new SanPhamRespository().getAll()) {
            if (y.getTen().contains(x)) {
                s.add(y);
            }
        }
        return s;

    }

    @Override
    public List<String> getImei(String id) {
        return new SanPhamRespository().getIMEI(id);
    }

    @Override
    public List<HeDieuHanh> getHDH() {
        return new SanPhamRespository().getHDH();
    }

    @Override
    public String addHDH(HeDieuHanh hdh) {
        if (new SanPhamRespository().ThemHDH(hdh)) {
            return "them thanh cong";
        }

        return "Them khong thanh cong";
    }

    @Override
    public String suaHDH(HeDieuHanh hdh) {
        if (new SanPhamRespository().ThemHDH(hdh)) {
            return "sua thanh cong";
        }

        return "sua khong thanh cong";
    }

    @Override
    public List<Pin> getPin() {
        return new ThongSoReponsitory().getPin();
    }

    @Override
    public String addPin(Pin hdh) {
        if (new ThongSoReponsitory().ThemHDH(hdh)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaPin(Pin hdh) {
        if (new ThongSoReponsitory().SuaHDH(hdh)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public List<ThietKe> getTK() {
        return new ThongSoReponsitory().getThietKe();
    }

    @Override
    public String addTK(ThietKe tk) {
        if (new ThongSoReponsitory().ThemThietKe(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaTK(ThietKe tk) {
        if (new ThongSoReponsitory().SuaThietKe(tk)) {
            return "OK";
        }
        return "FAIL";
    }

}
