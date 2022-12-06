/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.BoNho;
import DomainModel.ChiTietDienThoai;
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
import DomainModel.QuocGiaDong;
import DomainModel.ThietKe;
import DomainModel.ThongSo;
import DomainModel.TienIch;
import Repository.HangReponsitory;
import Repository.QuocGiaRepon;
import Repository.ThemSanPhamRepon;
import Service.SanPhamServices;
import Service.ThemSPServices;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haha
 */
public class TSPImpl implements ThemSPServices {

    ThemSanPhamRepon sp = new ThemSanPhamRepon();
    SanPhamServices sps = new SanPhamServicesImpl();

    @Override
    public String idBN(BoNho bn) {

        for (BoNho boNho : sps.getBN()) {
            if (boNho.equals(bn)) {
                return boNho.getId();
            }
        }
        sps.addBN(bn);
        for (BoNho boNho : sps.getBN()) {
            if (boNho.equals(bn)) {
                return boNho.getId();
            }
        }
        return null;
    }

    @Override
    public String idCPU(Cpu cpu) {
        for (Cpu boNho : sps.getCPU()) {
            if (boNho.equals(cpu)) {
                return boNho.getId();
            }
        }
        sps.addCPU(cpu);
        for (Cpu boNho : sps.getCPU()) {
            if (boNho.equals(cpu)) {
                return boNho.getId();
            }
        }
        return null;
    }

    @Override
    public String idPIN(Pin pin) {
        for (Pin boNho : sps.getPin()) {
            if (boNho.equals(pin)) {
                return boNho.getId();
            }
        }
        sps.addPin(pin);
        for (Pin boNho : sps.getPin()) {
            if (boNho.equals(pin)) {
                return boNho.getId();
            }
        }
        return null;
    }

    @Override
    public String idHDH(HeDieuHanh hdh) {
        for (HeDieuHanh boNho : sps.getHDH()) {
            if (boNho.equals(hdh)) {
                return boNho.getId();
            }
        }
        sps.addHDH(hdh);
        for (HeDieuHanh boNho : sps.getHDH()) {
            if (boNho.equals(hdh)) {
                return boNho.getId();
            }
        };
        return null;
    }

    @Override
    public String idTK(ThietKe tk) {
        for (ThietKe boNho : sps.getTK()) {
            if (boNho.equals(tk)) {
                return boNho.getId();
            }
        }
        sps.addTK(tk);
        for (ThietKe boNho : sps.getTK()) {
            if (boNho.equals(tk)) {
                return boNho.getId();
            }
        }
        return null;
    }

    @Override
    public String idMH(ManHinh mh) {
        for (ManHinh boNho : sps.getHM()) {
            if (boNho.equals(mh)) {
                return boNho.getId();
            }
        }
        sps.addHM(mh);
        for (ManHinh boNho : sps.getHM()) {
            if (boNho.equals(mh)) {
                return boNho.getId();
            }
        }
        return null;
    }

    @Override
    public String idKN(KetNoi kn) {
        for (KetNoi boNho : sps.getKN()) {
            if (boNho.equals(kn)) {
                return boNho.getId();
            }
        }
        sps.addKN(kn);
        for (KetNoi boNho : sps.getKN()) {
            if (boNho.equals(kn)) {
                return boNho.getId();
            }
        }
        return null;
    }

    @Override
    public String idMS(MauSac ms) {
        for (MauSac boNho : sps.getMauSacs()) {
            if (boNho.equals(ms)) {
                return boNho.getId();
            }
        }
        sps.addMauSac(ms);
        for (MauSac boNho : sps.getMauSacs()) {
            if (boNho.equals(ms)) {
                return boNho.getId();
            }
        }
        return null;
    }

    @Override
    public String idTI(TienIch ti) {
        for (TienIch boNho : sps.getTI()) {
            if (boNho.equals(ti)) {
                return boNho.getId();
            }
        }
        sps.addTI(ti);
        for (TienIch boNho : sps.getTI()) {
            if (boNho.equals(ti)) {
                return boNho.getId();
            }
        }
        return null;
    }

    @Override
    public String themSP(ThongSo ts) {
        if (sp.ThemSP(ts)) {
            return "Thêm thành công";
        }
        return "Thêm không thành công";
    }
    QuocGiaRepon qgq = new QuocGiaRepon();

    @Override
    public List<QuocGia> getQG(int i) {
        return qgq.getAll(i);
    }

    @Override
    public String themQG(QuocGia qg) {
        for (QuocGia x : qgq.getAll(1)) {
            if (x.getMa().equalsIgnoreCase(qg.getMa())) {
                return "Thêm Không thành công";
            }
        }
        for (QuocGia x : qgq.getAll(0)) {
            if (x.getMa().equalsIgnoreCase(qg.getMa())) {
                return "Thêm Không thành công";
            }
        }
        if (new QuocGiaRepon().add(qg)) {
            return "Thêm thành công";
        }
        return "Thêm Không thành công";

    }

    @Override
    public List<QuocGia> getTimKiem(String i) {
        List<QuocGia> ls = new ArrayList<>();
        for (QuocGia quocGia : qgq.getAll(1)) {
            if (quocGia.getTen().contains(i) || quocGia.getMa().contains(i)) {
                ls.add(quocGia);
            }
        }
        return ls;
    }

    @Override
    public String suaQG(QuocGia qg) {
        if (new QuocGiaRepon().sua(qg)) {
            return "Sửa thành công";
        }
        return "Sửa Không thành công";
    }

    HangReponsitory hangls = new HangReponsitory();

    @Override
    public String themHang(Hang ha) {
        for (Hang x : hangls.getAll(1)) {
            if (x.getMa().equalsIgnoreCase(ha.getMa())) {
                return "Thêm Không thành công";
            }
        }
        for (Hang x : hangls.getAll(0)) {
            if (x.getMa().equalsIgnoreCase(ha.getMa())) {
                return "Thêm Không thành công";
            }
        }
        if (hangls.add(ha)) {
            return "Thêm thành công";
        }
        return "Thêm Không thành công";
    }

    @Override
    public String suaHang(Hang ha) {
        if (hangls.sua(ha)) {
            return "Sửa thành công";
        }
        return "Sửa Không thành công";
    }

    @Override
    public List<Hang> getHang(int i) {
        return hangls.getAll(i);
    }

    @Override
    public List<Hang> getTimKiemHa(String i) {
        List<Hang> ls = new ArrayList<>();
        for (Hang quocGia : hangls.getAll(1)) {
            if (quocGia.getTen().contains(i) || quocGia.getMa().contains(i)) {
                ls.add(quocGia);
            }
        }
        return ls;
    }

    @Override
    public String themDT(DienThoai ha) {
        if (new ThemSanPhamRepon().ThemDT(ha)) {
            return "nhập thành công";
        }
        return "không nhập được";
    }

    @Override
    public String suaDT(DienThoai ha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DienThoai> getDT(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DienThoai> getTimKiemDT(String i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override

    public String themQGD(QuocGiaDong ha) {
        if (new ThemSanPhamRepon().ThemQGD(ha)) {
            return "nhập thành công";
        }
        return "không nhập được";
    }

    @Override
    public String themCTDT(ChiTietDienThoai ha) {
        if (new ThemSanPhamRepon().ThemCTDT(ha)) {
            return "nhập thành công";
        }
        return "không nhập được";
    }

    @Override
    public String themDong(Dong ha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String timKiem(QuocGiaDong ha) {
        for (QuocGia quocGia :   new QuocGiaRepon().getAll(1)) {
            if (quocGia.equals(ha)) {
            return quocGia.getId();
            }
        }
        return null;
    }

}
