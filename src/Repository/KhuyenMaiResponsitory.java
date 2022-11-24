/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.KhuyenMai;
import Ultilities.SQLServerConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author togia
 */
public class KhuyenMaiResponsitory {

    public List<KhuyenMai> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[ma_khuyen_mai]\n"
                + "      ,[ngay_bat_dau]\n"
                + "      ,[ngay_ket_thuc]\n"
                + "      ,[gia_giam]\n"
                + "      ,[don_vi]\n"
                + "      ,[mo_ta]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[KhuyenMai]";
        List<KhuyenMai> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai chiTietSP = new KhuyenMai(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDouble(5), rs.getBoolean(6), rs.getString(7), rs.getString(8));
                list.add(chiTietSP);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(KhuyenMai km) {
        String query = "INSERT INTO [dbo].[KhuyenMai]\n"
                + "           ([id]\n"
                + "           ,[ma_khuyen_mai]\n"
                + "           ,[ngay_bat_dau]\n"
                + "           ,[ngay_ket_thuc]\n"
                + "           ,[gia_giam]\n"
                + "           ,[don_vi]\n"
                + "           ,[mo_ta]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, km.getId());
            ps.setObject(2, km.getMa());
            ps.setObject(3, km.getNgayBatDau());
            ps.setObject(4, km.getNgayKetThuc());
            ps.setObject(5, km.getGiaGiam());
            ps.setObject(6, km.isDonVi());
            ps.setObject(7, km.getMoTa());
            ps.setObject(8, km.getTrangThai());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String idKM) {
        String query = "DELETE FROM [dbo].[KhuyenMai]\n"
                + "      WHERE id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idKM);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(KhuyenMai km, String idKM) {
        String query = "UPDATE [dbo].[KhuyenMai]\n"
                + "   SET [id] = ?\n"
                + "      ,[ma_khuyen_mai] =?\n"
                + "      ,[ngay_bat_dau] = ?\n"
                + "      ,[ngay_ket_thuc] = ?\n"
                + "      ,[gia_giam] = ?\n"
                + "      ,[don_vi] = ?\n"
                + "      ,[mo_ta] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, km.getId());
            ps.setObject(2, km.getMa());
            ps.setObject(3, km.getNgayBatDau());
            ps.setObject(4, km.getNgayKetThuc());
            ps.setObject(5, km.getGiaGiam());
            ps.setObject(6, km.isDonVi());
            ps.setObject(7, km.getMoTa());
            ps.setObject(8, km.getTrangThai());
            ps.setObject(9, idKM);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
