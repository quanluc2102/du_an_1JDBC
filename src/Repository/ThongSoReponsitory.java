/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Pin;
import DomainModel.ThietKe;
import Ultilities.SQLServerConnection;
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
public class ThongSoReponsitory {

    public boolean ThemHDH(Pin hdh) {
        String query = "INSERT INTO [dbo].[PIN]\n"
                + "           ([dung_luong]\n"
                + "           ,[loai_pin]\n"
                + "           ,[sac]\n"
                + "           ,[dac_biet]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getDungLuong());
            ps.setObject(2, hdh.getLoaiPin());
            ps.setObject(3, hdh.getSac());
            ps.setObject(4, hdh.getDacBiet());
            ps.setObject(5, hdh.getTrangThai());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean SuaHDH(Pin hdh) {
        String query = "UPDATE [dbo].[PIN]\n"
                + "   SET \n"
                + "      [dung_luong] = ?\n"
                + "      ,[loai_pin] = ?\n"
                + "      ,[sac] = ?\n"
                + "      ,[dac_biet] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getDungLuong());
            ps.setObject(2, hdh.getLoaiPin());
            ps.setObject(3, hdh.getSac());
            ps.setObject(4, hdh.getDacBiet());
            ps.setObject(5, hdh.getTrangThai());
            ps.setObject(6, hdh.getId());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public List<Pin> getPin() {
        String query = "select * from Pin where trang_thai != 0";
        List<Pin> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Pin sp = new Pin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                ls.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }

    public boolean ThemThietKe(ThietKe hdh) {
        String query = "INSERT INTO [dbo].[ThietKe]\n"
                + "           ([mat_truoc]\n"
                + "           ,[mat_lung]\n"
                + "           ,[vien]\n"
                + "           ,[trong_luong]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "         (?,?,?,?,?)";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getMatTruoc());
            ps.setObject(2, hdh.getMatLung());
            ps.setObject(3, hdh.getVien());
            ps.setObject(4, hdh.getTrongLuong());
            ps.setObject(5, hdh.getTrangThai());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public boolean SuaThietKe(ThietKe hdh) {
        String query = "UPDATE [dbo].[ThietKe]\n"
                + "   SET [mat_truoc] = ?\n"
                + "      ,[mat_lung] = ?\n"
                + "      ,[vien] = ?\n"
                + "      ,[trong_luong] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id =?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdh.getMatTruoc());
            ps.setObject(2, hdh.getMatLung());
            ps.setObject(3, hdh.getVien());
            ps.setObject(4, hdh.getTrongLuong());
            ps.setObject(5, hdh.getTrangThai());
            ps.setObject(6, hdh.getId());
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }

    public List<ThietKe> getThietKe() {
        String query = "select * from ThietKe where trang_thai != 0";
        List<ThietKe> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ThietKe sp = new ThietKe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                ls.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }

    public static void main(String[] args) {

    }
}
