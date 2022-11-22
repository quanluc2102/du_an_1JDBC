/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietDienThoai;
import DomainModel.Hang;
import DomainModel.ThongSo;
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

    public List<Hang> getHang() {
        String query = "select * from hang ";
        List<Hang> hangList = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hang h = new Hang(rs.getString(1), rs.getString(2), rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return hangList;
    }
     public List<String> getIMEI(String id) {
        String query = " select IMEI from chitietdienthoai where id_quoc_gia_dong = ? and trang_thai= 1";
        List<String> hangList = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
             ps.setObject(1,id );
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
        String query = "select QuocGiaDong.id ,anh ,ten_hien_thi,COUNT(IMEI),moi,gia_ban,gia_nhap from QuocGiaDong join ChiTietDienThoai on QuocGiaDong.id = ChiTietDienThoai.id_quoc_gia_Dong\n"
                + "                where trang_thai ='true'\n"
                + "                group by anh ,ten_hien_thi,moi, QuocGiaDong.id,gia_ban,gia_nhap ";
        List<SanPhamViewModel> listSanPhamViewModelView = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getInt(5) == 100 ? "Mới" : "Cũ", rs.getDouble(6), rs.getDouble(7), "");
                listSanPhamViewModelView.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listSanPhamViewModelView;
    }

    public ThongSoViewModel getAllThongSoView(String id) {
        String query = "select ten_hang, ten_dong,ten_quoc_gia, ten_dien_thoai, cpu,ram,rom,sim,man_hinh,trong_luong,camera,he_dieu_hanh,pin from Hang \n"
                + "											join DienThoai on DienThoai.id_hang = Hang.id\n"
                + "											join Dong on Dong.id_dien_thoai  = DienThoai.id\n"
                + "											join QuocGiaDong on dong.id = QuocGiaDong.id_dong\n"
                + "											join QuocGia on QuocGia.id = QuocGiaDong.id_quoc_gia\n"
                + "											join ThongSo on ThongSo.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "where QuocGiaDong.id = ?";
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

    public static void main(String[] args) {
        for (SanPhamViewModel thongSoViewModel : new SanPhamRespository().getAll()) {
            System.out.println(thongSoViewModel.toString());
        }
    }
}
