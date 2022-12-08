/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.BoNho;
import DomainModel.Cpu;
import DomainModel.DienThoai;
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
import Repository.CameraRepon;
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
    public List<HeDieuHanh> getHDH(int x) {
        return new SanPhamRespository().getHDH(x);
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
    public List<Pin> getPin(int x) {
        return new ThongSoReponsitory().getPin(x);
    }

    @Override
    public String addPin(Pin hdh) {
        if (hdh == null) {
            return "Không được để trống thông tin";
        }
        if (new ThongSoReponsitory().ThemHDH(hdh)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaPin(Pin hdh) {
        if (hdh == null) {
            return "Không được để trống thông tin";
        }
        if (new ThongSoReponsitory().SuaHDH(hdh)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public List<ThietKe> getTK(int x) {
        return new ThongSoReponsitory().getThietKe(x);
    }

    @Override
    public String addTK(ThietKe tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        }
        if (new ThongSoReponsitory().ThemThietKe(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaTK(ThietKe tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        }
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
    public String xoaBN(BoNho tk, int tt) {
        if (tk == null) {
            return "Không được để trống thông tin";
        } else if (new ThongSoReponsitory().xoaBN(tk, tt)) {
            return "sửa thành cônng";
        }
        return "Sửa thất bại";
    }

    @Override
    public List<Cpu> getCPU(int x) {
        return new ThongSoReponsitory().getCpu(x);
    }

    @Override
    public String addCPU(Cpu tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        }
        if (new ThongSoReponsitory().ThemCPU(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaCPU(Cpu tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        }
        if (new ThongSoReponsitory().SuaCPU(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public List<MauSac> getMauSacs(int x) {
        return new ThongSoReponsitory().getMau(x);
    }

    @Override
    public String addMauSac(MauSac tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        }
        if (new ThongSoReponsitory().ThemMau(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaMauSac(MauSac tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        }
        if (new ThongSoReponsitory().SuaMau(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public List<TienIch> getTI(int x) {
        return new ThongSoReponsitory().getTi(x);
    }

    @Override
    public String addTI(TienIch tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        }
        if (new ThongSoReponsitory().ThemTi(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaTI(TienIch tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        }
        if (new ThongSoReponsitory().SuaTi(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public List<ManHinh> getHM(int x) {
        return new ThongSoReponsitory().getMH(x);
    }

    @Override
    public String addHM(ManHinh tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        }
        if (new ThongSoReponsitory().ThemMH(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaHM(ManHinh tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        }
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
    public List<KetNoi> getKN(int x) {
        return new ThongSoReponsitory().getKN(x);
    }

    @Override
    public String addKN(KetNoi tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        }
        if (new ThongSoReponsitory().ThemKN(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String suaKN(KetNoi tk) {
        if (tk == null) {
            return "Không được để trống thông tin";
        }
        if (new ThongSoReponsitory().SuaKN(tk)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public String addDT(ThongSo ts) {
        if (ts == null) {
            return "Không được để trống thông tin";
        }
        if (new SanPhamRespository().ThemDienThoai(ts)) {
            return "OK";
        }
        return "FAIL";
    }

    @Override
    public List<QuocGia> getQG() {
        return new SanPhamRespository().getQuocGia();
    }

    @Override
    public String xoaKN(KetNoi tk, int tt) {
        if (tk == null) {
            return "Không được để trống thông tin";
        } else if (new ThongSoReponsitory().xoaKN(tk, tt)) {
            return "sửa thành cônng";
        }
        return "Sửa thất bại";
    }

    @Override
    public String xoaHDH(HeDieuHanh hdh, int tt) {
        if (hdh == null) {
            return "Không được để trống thông tin";
        } else if (new SanPhamRespository().xoaHDH(hdh, tt)) {
            return "sửa thành cônng";
        }
        return "Sửa thất bại";
    }

    @Override
    public String xoaPin(Pin hdh, int tt) {
        if (hdh == null) {
            return "Không được để trống thông tin";
        } else if (new ThongSoReponsitory().xoaPin(hdh, tt)) {
            return "sửa thành cônng";
        }
        return "Sửa thất bại";
    }

    @Override
    public String xoaTK(ThietKe tk, int tt) {
     if (tk == null) {
            return "Không được để trống thông tin";
        } else if (new ThongSoReponsitory().xoaThietKe(tk, tt)) {
            return "sửa thành cônng";
        }
        return "Sửa thất bại";    }

    @Override
    public String xoaCPU(Cpu tk, int tt) {
        if (tk == null) {
            return "Không được để trống thông tin";
        } else if (new ThongSoReponsitory().xoaCPU(tk, tt)) {
            return "sửa thành cônng";
        }
        return "Sửa thất bại";
    }

    @Override
    public String xoaTI(TienIch tk, int tt) {
        if (tk == null) {
            return "Không được để trống thông tin";
        } else if (new ThongSoReponsitory().xoaTi(tk, tt)) {
            return "sửa thành cônng";
        }
        return "Sửa thất bại";
    }

    @Override
    public String xoaHM(ManHinh tk, int tt) {
        if (tk == null) {
            return "Không được để trống thông tin";
        } else if (new ThongSoReponsitory().xoaMH(tk, tt)) {
            return "sửa thành cônng";
        }
        return "Sửa thất bại";
    }

    @Override
    public String xoaMauSac(MauSac tk, int tt) {
        if (tk == null) {
            return "Không được để trống thông tin";
        } else if (new ThongSoReponsitory().xoaMau(tk, tt)) {
            return "sửa thành cônng";
        }
        return "Sửa thất bại";
    }

    @Override
    public List<DienThoai> getDT() {
return new CameraRepon().getDTLisst();    }

}
