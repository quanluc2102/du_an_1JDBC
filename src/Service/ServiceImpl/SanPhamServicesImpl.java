/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.BoNho;
import DomainModel.Cpu;
import DomainModel.Dong;
import DomainModel.Hang;
import DomainModel.HeDieuHanh;
import DomainModel.KetNoi;
import DomainModel.ManHinh;
import DomainModel.MauSac;
import DomainModel.Pin;
import DomainModel.QuocGia;
import DomainModel.ThietKe;
import DomainModel.ThongSo;
import DomainModel.TienIch;
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

    @Override
    public List<BoNho> getBN(int i) {
        return new ThongSoReponsitory().getBN(i);
    }

    @Override
    public String addBN(BoNho tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        } else if (new ThongSoReponsitory().ThemBN(tk)) {
            return "Thêm thành cônng";
        }
        return "Thêm thất bại";
    }

    @Override
    public String suaBN(BoNho tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        } else if (new ThongSoReponsitory().SuaBN(tk)) {
            return "sửa thành cônng";
        }
        return "Sửa thất bại";
    }

    @Override
    public String xoaBN(BoNho tk,int tt) {
        if (tk == null) {
            return "Không được để trống thông tin";
        } else if (new ThongSoReponsitory().xoaBN(tk,tt)) {
            return "sửa thành cônng";
        }
        return "Sửa thất bại";
    }

    @Override
    public List<Cpu> getCPU() {
        return new ThongSoReponsitory().getCpu();
    }

    @Override
    public String addCPU(Cpu tk) {
        if (new ThongSoReponsitory().ThemCPU(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaCPU(Cpu tk) {
        if (new ThongSoReponsitory().SuaCPU(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public List<MauSac> getMauSacs() {
        return new ThongSoReponsitory().getMau();
    }

    @Override
    public String addMauSac(MauSac tk) {
        if (new ThongSoReponsitory().ThemMau(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaMauSac(MauSac tk) {
        if (new ThongSoReponsitory().SuaMau(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public List<TienIch> getTI() {
        return new ThongSoReponsitory().getTi();
    }

    @Override
    public String addTI(TienIch tk) {
        if (new ThongSoReponsitory().ThemTi(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaTI(TienIch tk) {
        if (new ThongSoReponsitory().SuaTi(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public List<ManHinh> getHM() {
        return new ThongSoReponsitory().getMH();
    }

    @Override
    public String addHM(ManHinh tk) {
        if (new ThongSoReponsitory().ThemMH(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaHM(ManHinh tk) {
        if (new ThongSoReponsitory().SuaMH(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public List<Hang> getHang() {
        return new SanPhamRespository().getHang();
    }

    @Override
    public List<Dong> getDong() {
        return new SanPhamRespository().getDong();
    }

    @Override
    public int moi(String imei) {
        return new SanPhamRespository().getMoi(imei);
    }

    @Override
    public List<SanPhamViewModel> getTimKiemSanPham(String tk) {
        List<SanPhamViewModel> s = new ArrayList<>();
        for (SanPhamViewModel c : new SanPhamRespository().getAll()) {
            if (c.getTen().contains(tk) || c.getTenDong().contains(tk) || c.getTenHang().contains(tk)) {
                s.add(c);
            }
        }

        return s;

    }

    @Override
    public List<KetNoi> getKN() {
        return new ThongSoReponsitory().getKN();
    }

    @Override
    public String addKN(KetNoi tk) {
        if (new ThongSoReponsitory().ThemKN(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaKN(KetNoi tk) {
        if (new ThongSoReponsitory().SuaKN(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String addDT(ThongSo ts) {
        if (new SanPhamRespository().ThemDienThoai(ts)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public List<QuocGia> getQG() {
        return new SanPhamRespository().getQuocGia();
    }

}
