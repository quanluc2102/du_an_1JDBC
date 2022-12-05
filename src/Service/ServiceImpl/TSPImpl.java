/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.BoNho;
import DomainModel.Cpu;
import DomainModel.HeDieuHanh;
import DomainModel.KetNoi;
import DomainModel.ManHinh;
import DomainModel.MauSac;
import DomainModel.Pin;
import DomainModel.ThietKe;
import DomainModel.TienIch;
import Service.SanPhamServices;
import Service.ThemSPServices;

/**
 *
 * @author haha
 */
public class TSPImpl implements ThemSPServices {

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
        return "";
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
        return "";
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
        return "";
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
        return "";
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
        return "";
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
        return "";
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
        return "";
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
        return "";
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
        return "";
    }

}
