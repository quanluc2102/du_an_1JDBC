/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.HeDieuHanh;
import Ultilities.SQLServerConnection;
import ViewModel.SanPhamViewModel;
import ViewModel.ThongSoViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haha
 */
public class SanPhamRespository {

    public List<String> getIMEI(String id) {
        String query = " select IMEI from chitietdienthoai where id_quoc_gia_dong = ? and trang_thai= 1";
        List<String> hangList = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                hangList.add(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return hangList;
    }

    public List<SanPhamViewModel> getAll() {
        String query = "select QuocGiaDong.id ,anh,ten_dien_thoai+' '+ ten_dong as tenmay,ten_hang,COUNT(ChiTietDienThoai.IMEI)as soluong,gia_ban,gia_nhap from QuocGiaDong\n"
                + "               						join ChiTietDienThoai on QuocGiaDong.id = ChiTietDienThoai.id_quoc_gia_Dong\n"
                + "               						join Dong on dong.id = QuocGiaDong.id_dong \n"
                + "               						join DienThoai on DienThoai.id = Dong.id_dien_thoai \n"
                + "									join Hang on Hang.id = DienThoai.id_hang\n"
                + "                                    where ChiTietDienThoai.trang_thai =1 \n"
                + "                                     group by anh, QuocGiaDong.id,gia_ban,gia_nhap,ten_dien_thoai+' '+ ten_dong,ten_hang";
        List<SanPhamViewModel> listSanPhamViewModelView = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getDouble(6), rs.getDouble(7));
                listSanPhamViewModelView.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listSanPhamViewModelView;
    }

    public ThongSoViewModel getAllThongSoView(String id) {
        String query = "SELECT dbo.BoNho.so_luong_ram, dbo.BoNho.so_Luong_rom, dbo.ManHinh.loai_man_hinh, dbo.ManHinh.kich_thuoc, dbo.PIN.dung_luong, dbo.CPU.ten_CPU, dbo.HeDieuHanh.ten_he_dieu_hanh\n"
                + "FROM     dbo.BoNho INNER JOIN\n"
                + "                  dbo.CamBien ON dbo.BoNho.id = dbo.CamBien.id INNER JOIN\n"
                + "                  dbo.Camera ON dbo.CamBien.id_camera = dbo.Camera.id INNER JOIN\n"
                + "                  dbo.CPU ON dbo.BoNho.id = dbo.CPU.id INNER JOIN\n"
                + "                  dbo.HeDieuHanh ON dbo.BoNho.id = dbo.HeDieuHanh.id INNER JOIN\n"
                + "                  dbo.KetNoi ON dbo.BoNho.id = dbo.KetNoi.id INNER JOIN\n"
                + "                  dbo.ManHinh ON dbo.BoNho.id = dbo.ManHinh.id INNER JOIN\n"
                + "                  dbo.MauSac ON dbo.BoNho.id = dbo.MauSac.id INNER JOIN\n"
                + "                  dbo.ThietKe ON dbo.BoNho.id = dbo.ThietKe.id INNER JOIN\n"
                + "                  dbo.ThongSo ON dbo.BoNho.id = dbo.ThongSo.id_bo_nho AND dbo.Camera.id = dbo.ThongSo.id_camera_truoc AND dbo.Camera.id = dbo.ThongSo.id_camera_sau AND dbo.CPU.id = dbo.ThongSo.id_CPU AND \n"
                + "                  dbo.HeDieuHanh.id = dbo.ThongSo.id_he_dieu_hanh AND dbo.KetNoi.id = dbo.ThongSo.id_ket_noi AND dbo.ManHinh.id = dbo.ThongSo.id_man_hinh AND dbo.MauSac.id = dbo.ThongSo.id_mau AND \n"
                + "                  dbo.ThietKe.id = dbo.ThongSo.id_thiet_ke INNER JOIN\n"
                + "                  dbo.TienIch ON dbo.ThongSo.id_tien_ich = dbo.TienIch.id INNER JOIN\n"
                + "                  dbo.PIN ON dbo.BoNho.id = dbo.PIN.id";
        ThongSoViewModel sp = new ThongSoViewModel();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp = new ThongSoViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));

            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp;
    }

    public boolean ban(String IMEI) {
        String query = "update ChiTietDienThoai\n"
                + "set trang_thai = 0\n"
                + "where IMEI =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, IMEI);
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean ThemSanPham(String IMEI) {
        String query = "update ChiTietDienThoai\n"
                + "set trang_thai = 0\n"
                + "where IMEI =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, IMEI);
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public List<HeDieuHanh> getHDH() {
        String query = "select * from HeDieuHanh ";
        List<HeDieuHanh> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                HeDieuHanh sp = new HeDieuHanh(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                ls.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }

    public static void main(String[] args) {
        for (SanPhamViewModel x : new SanPhamRespository().getAll()) {
            System.out.println(x.toString());
        }
    }
}
