/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.NhanVien;
import Ultilities.SQLServerConnection;
import ViewModel.LoginViewModel;
import ViewModel.NhanVienView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buiti
 */
public class NhanVienRepository {

    public List<NhanVienView> getAll() {
        List<NhanVienView> ls = new ArrayList<>();
        try ( Connection conn = new SQLServerConnection().getConnection()) {
            String query = "SELECT        dbo.NhanVien.id, dbo.NhanVien.ma_nhan_vien, dbo.NhanVien.ten_nhan_vien, dbo.NhanVien.id_chuc_vu, dbo.ChucVu.ten_chuc_vu, dbo.NhanVien.ngay_sinh, dbo.NhanVien.sdt, dbo.NhanVien.email, dbo.NhanVien.dia_chi, \n"
                    + "                         dbo.NhanVien.mat_khau, dbo.NhanVien.trang_thai\n"
                    + "FROM            dbo.NhanVien left JOIN\n"
                    + "                         dbo.ChucVu ON dbo.NhanVien.id_chuc_vu = dbo.ChucVu.id";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ls.add(new NhanVienView(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11)));
            }
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        List<NhanVienView> l = new NhanVienRepository().getAll();
        for (NhanVienView nhanVien : l) {
            System.out.println(nhanVien.toString());
        }
    }
      public boolean chuyenTTNV(String id) {
        String query = "UPDATE [dbo].[NhanVien]\n"
                + "   SET[id_chuc_vu] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, null);
            ps.setObject(2, "0");
            ps.setObject(3, id);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateSVDiem(NhanVien sv, String ma) {
        String query = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [ma_nhan_vien] = ?\n"
                + "      ,[ten_nhan_vien] = ?\n"
                + "      ,[id_chuc_vu] = ?\n"
                + "      ,[ngay_sinh] = ?\n"
                + "      ,[sdt] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[dia_chi] = ?\n"
                + "      ,[mat_khau] = ?\n"
                + ",[trang_thai] = ?"
                + " WHERE  id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, sv.getMa());
            ps.setObject(2, sv.getTen());
            ps.setObject(3, sv.getIdChucVu());
            ps.setObject(4, sv.getNgaySinh());
            ps.setObject(5, sv.getSdt());
            ps.setObject(6, sv.getEmail());
            ps.setObject(7, sv.getDiaChi());
            ps.setObject(8, sv.getMatKhau());
            ps.setObject(9, sv.getTrangThai());
            ps.setObject(10, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}