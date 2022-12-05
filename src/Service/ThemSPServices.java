/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.BoNho;
import DomainModel.Cpu;
import DomainModel.HeDieuHanh;
import DomainModel.KetNoi;
import DomainModel.ManHinh;
import DomainModel.MauSac;
import DomainModel.Pin;
import DomainModel.ThietKe;
import DomainModel.TienIch;

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
}
