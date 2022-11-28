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

                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getDouble(6), rs.getDouble(7));
                listSanPhamViewModelView.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listSanPhamViewModelView;
    }

    public ThongSoViewModel getAllThongSoView(String id) {
        String query = "select ten_CPU ,so_luong_ram  , so_Luong_rom , ten_mau,ten_he_dieu_hanh+' '+phien_ban,loai_man_hinh+' '+kich_thuoc ,\n"
                + "dung_luong+' '+loai_pin ,  sim+' '+ho_tro_mang,mat_truoc,mat_lung,bao_mat,ten_quoc_gia\n"
                + "									from ThongSo join PIN on PIN.id = ThongSo.id_pin\n"
                + "									join CPU on CPU.id = ThongSo.id_CPU\n"
                + "									join BoNho on BoNho.id = ThongSo.id_bo_nho\n"
                + "									join MauSac on MauSac.id = ThongSo.id_mau\n"
                + "									join HeDieuHanh on HeDieuHanh.id = ThongSo.id_he_dieu_hanh\n"
                + "									join ManHinh on ManHinh.id = ThongSo.id_man_hinh\n"
                + "									join KetNoi on KetNoi.id = ThongSo.id_ket_noi\n"
                + "									join ThietKe on ThietKe.id = ThongSo.id_thiet_ke\n"
                + "									join TienIch on TienIch.id = ThongSo.id_tien_ich\n"
                + "									join QuocGiaDong on QuocGiaDong.id = ThongSo.id_dong\n"
                + "									join QuocGia on QuocGia.id = QuocGiaDong.id_quoc_gia\n"
                + "\n"
                + "									where thongso.id_dong = ?";
        ThongSoViewModel sp = new ThongSoViewModel();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp = new ThongSoViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
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

    public boolean ThemHDH(HeDieuHanh hdh) {
        String query = "insert into HeDieuHanh(ten_he_dieu_hanh,phien_ban,trang_thai)\n"
                + "values(?,?,?)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getTenHDH());
            ps.setObject(2, hdh.getPhienBan());
            ps.setObject(3, hdh.getTrangThai());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean SuaHDH(HeDieuHanh hdh) {
        String query = "UPDATE [dbo].[HeDieuHanh]\n"
                + "   SET [ten_he_dieu_hanh] =?\n"
                + "      ,[phien_ban] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id = ?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getTenHDH());
            ps.setObject(2, hdh.getPhienBan());
            ps.setObject(3, hdh.getTrangThai());
            ps.setObject(4, hdh.getId());
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
