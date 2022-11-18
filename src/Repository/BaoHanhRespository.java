/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.BaoHanh;
import Ultilities.SQLServerConnection;
import ViewModel.BaoHanhViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class BaoHanhRespository {

    public List<BaoHanhViewModel> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[thoi_gian]\n"
                + "      ,[don_vi]\n"
                + "  FROM [dbo].[BaoHanh]";
        List<BaoHanhViewModel> listBaoHanhView = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaoHanhViewModel baoHanh = new BaoHanhViewModel(rs.getString(1), rs.getString(2), rs.getBoolean(3));
                listBaoHanhView.add(baoHanh);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listBaoHanhView;
    }

    public boolean add(BaoHanh baoHanh) {
        String query = "INSERT INTO [dbo].[BaoHanh]\n"
                + "           ([thoi_gian]\n"
                + "           ,[don_vi])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, baoHanh.getThoiGian());
            ps.setObject(2, baoHanh.isDonVi());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String idBH) {
        String query = "DELETE FROM HoaDonChiTiet WHERE id_bao_hanh =?\n"
                + "DELETE FROM [dbo].[BaoHanh]\n"
                + "      WHERE id=?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idBH);
            ps.setObject(2, idBH);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean Update(BaoHanh baoHanh, String id) {
        String query = "UPDATE [dbo].[BaoHanh]\n"
                + "   SET \n"
                + "      [thoi_gian] = ?\n"
                + "      ,[don_vi] = ?\n"
                + " WHERE id =?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, baoHanh.getThoiGian());
            ps.setObject(2, baoHanh.isDonVi());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
