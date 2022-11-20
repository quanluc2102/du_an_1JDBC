/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Ultilities.SQLServerConnection;
import ViewModel.SanPhamViewModel;
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

    public List<SanPhamViewModel> getAll() {
        String query = "select anh ,ten_hien_thi,COUNT(IMEI),moi from QuocGiaDong join ChiTietDienThoai on QuocGiaDong.id = ChiTietDienThoai.id_quoc_gia_Dong\n"
                + "where trang_thai ='true'\n"
                + "group by anh ,ten_hien_thi,moi";
        List<SanPhamViewModel> listSanPhamViewModelView = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               
                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(1), rs.getString(2), rs.getInt(3),  rs.getInt(4)==100?"Mới":"Cũ");
                listSanPhamViewModelView.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listSanPhamViewModelView;
    }

    public boolean add(SanPhamViewModel baoHanh) {
        String query = "INSERT INTO [dbo].[SanPhamViewModel]\n"
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
                + "DELETE FROM [dbo].[SanPhamViewModel]\n"
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

    public boolean Update(SanPhamViewModel baoHanh, String id) {
        String query = "UPDATE [dbo].[SanPhamViewModel]\n"
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
    public static void main(String[] args) {
        for (SanPhamViewModel sanPhamViewModel : new SanPhamRespository().getAll()) {
            System.out.println(sanPhamViewModel.toString());
        }
    }
}
