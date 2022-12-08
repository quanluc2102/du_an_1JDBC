/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.BoNho;
import DomainModel.Camera;
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
import java.util.List;

/**
 *
 * @author haha
 */
public interface ThemSPServices {


    String themQG(QuocGia qg);

    String suaQG(QuocGia qg);

    List<QuocGia> getQG(int i);

    List<QuocGia> getTimKiem(String i);

    String themHang(Hang ha);

    String suaHang(Hang ha);

    List<Hang> getHang(int i);

    List<Hang> getTimKiemHa(String i);

    String themQGD(QuocGiaDong ha);

    String timKiem(QuocGiaDong ha);

    String themDT(DienThoai ha);

    String themCTDT(ChiTietDienThoai ha);

    String themDong(Dong ha);

    String suaDT(DienThoai ha);

    List<DienThoai> getDT(int i);

    List<DienThoai> getTimKiemDT(String i);
    
    List<Camera> getCamera(int x);
    String themCamera(Camera tk);
    String suaCamera(Camera tk);
    String xoaCamera(Camera tk,int x);

}
