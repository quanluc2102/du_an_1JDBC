/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.BoNho;
import DomainModel.Cpu;
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
import java.util.List;

/**
 *
 * @author haha
 */
public interface ThemSPServices {

    String idBN(BoNho bn);

    String idCPU(Cpu cpu);

    String idPIN(Pin pin);

    String idHDH(HeDieuHanh hdh);

    String idTK(ThietKe tk);

    String idMH(ManHinh mh);

    String idKN(KetNoi kn);

    String idMS(MauSac ms);

    String idTI(TienIch ti);

    String themSP(ThongSo ts);

    String themQG(QuocGia qg);

    String suaQG(QuocGia qg);

    List<QuocGia> getQG(int i);

    List<QuocGia> getTimKiem(String i);

    String themHang(Hang ha);

    String suaHang(Hang ha);

    List<Hang> getHang(int i);

    List<Hang> getTimKiemHa(String i);
}
