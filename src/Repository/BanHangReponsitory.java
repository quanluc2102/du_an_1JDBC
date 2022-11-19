/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietDienThoai;
import Ultilities.SQLServerConnection;
import ViewModel.ChiTietDienThoaiViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class BanHangReponsitory {

    public List<ChiTietDienThoaiViewModel> getAll() {
        String query = "SELECT [IMEI]\n"
                + "      ,[id_mau_Dong]\n"
                + "      ,[id_quoc_gia_Dong]\n"
                + "      ,[trang_thai]\n"
                + "      ,[moi]\n"
                + "      ,[mo_ta]\n"
                + "  FROM [dbo].[ChiTietDienThoai]";
        List<ChiTietDienThoaiViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietDienThoaiViewModel a = new ChiTietDienThoaiViewModel(rs.getString("IMEI"), rs.getString("id_mau_Dong"), rs.getString("id_quoc_gia_Dong"), rs.getBoolean("trang_thai"), rs.getInt("moi"), rs.getString("mo_ta"));
                list.add(a);
            }
            return list;
        } catch (SQLException s) {
            s.printStackTrace(System.out);
        }
        return null;
    }

    public String layTenSP(String idMauDong) {
        String query = "Select DienThoai.ten_dien_thoai from DienThoai\n"
                + "join Dong on Dong.id_dien_thoai=DienThoai.id\n"
                + "join MauSacDong on MauSacDong.id_dong=Dong.id\n"
                + "Where MauSacDong.id = ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idMauDong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString(1);
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public int layGia(String idQuocGiaDong) {
        String query = "Select QuocGiaDong.gia_ban from QuocGiaDong \n"
                + "join ChiTietDienThoai on ChiTietDienThoai.id_quoc_gia_Dong=QuocGiaDong.id\n"
                + "where ChiTietDienThoai.id_quoc_gia_Dong = ?";
        int a = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idQuocGiaDong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public String layTenDong(String idMauDong) {
        String query = "Select Dong.ten_dong\n"
                + "from Dong join MauSacDong on MauSacDong.id_dong=Dong.id\n"
                + "join ChiTietDienThoai on ChiTietDienThoai.id_mau_Dong = MauSacDong.id\n"
                + "where ChiTietDienThoai.id_mau_Dong= ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idMauDong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString(1);
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String layTenMauSac(String idMauDong) {
        String query = "Select MauSac.ten_mau\n"
                + "from MauSac\n"
                + "join MauSacDong on MauSacDong.id_mau_sac=MauSac.id\n"
                + "join ChiTietDienThoai on MauSacDong.id=ChiTietDienThoai.id_mau_Dong\n"
                + "where ChiTietDienThoai.id_mau_Dong = ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idMauDong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString(1);
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
