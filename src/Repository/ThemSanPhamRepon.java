/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ThongSo;
import DomainModel.TienIch;
import Ultilities.SQLServerConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author haha
 */
public class ThemSanPhamRepon {
     public boolean ThemSP(ThongSo ts) {
        String query = "INSERT INTO [dbo].[ThongSo]\n" +
"           ([id_dong]\n" +
"           ,[id_tien_ich]\n" +
"           ,[id_mau]\n" +
"           ,[id_bo_nho]\n" +
"           ,[id_he_dieu_hanh]\n" +
"           ,[id_man_hinh]\n" +
"           ,[id_CPU]\n" +
"           ,[id_ket_noi]\n" +
"           ,[id_thiet_ke]\n" +
"           ,[trang_thai]\n" +
"           ,[id_pin])\n" +
"     VALUES\n" +
"           (?,? ,?,? ,? ,? ,? ,?,?,?,?";
        int sp = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ts.getIdQuocGiaDong());
            ps.setObject(2, ts.getTienIch());
            ps.setObject(3, ts.getMauSac());
            ps.setObject(4, ts.getBoNho());
            ps.setObject(5, ts.getHeDieuhanh());
            ps.setObject(6, ts.getManHinh());
            ps.setObject(7, ts.getCpu());
            ps.setObject(8, ts.getKetNoi());
            ps.setObject(9, ts.getThietKe());
            ps.setObject(10,1);
            ps.setObject(11, ts.getPin());
          
            sp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return sp > 0;
    }
}
