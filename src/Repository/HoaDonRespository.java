/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import ViewModel.ViewModelHoaDon;
import java.util.List;
import Ultilities.SQLServerConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class HoaDonRespository {

    public List<ViewModelHoaDon> getAll() {

        String query = "select HoaDon.id,ma_hoa_don,ten_nhan_vien,ten_khach_hang,ma_khuyen_mai,HoaDonChiTiet.IMEI,ngay_tao,(gia_ban - gia_giam) as 'TongTien',HoaDon.trang_thai, thoi_gian,BaoHanh.don_vi\n"
                + "from HoaDon inner join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + "inner join KhachHang on HoaDon.id_khach_hang = KhachHang.id\n"
                + "inner join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id\n"
                + "inner join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "inner join BaoHanh on HoaDonChiTiet.id_bao_hanh = BaoHanh.id\n"
                + "inner join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "inner join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_Dong = QuocGiaDong.id";
        List<ViewModelHoaDon> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewModelHoaDon hd = new ViewModelHoaDon(rs.getString("id"),
                        rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ma_khuyen_mai"),
                        rs.getString("IMEI"), rs.getDate("ngay_tao"),
                        rs.getFloat("TongTien"), rs.getInt("trang_thai"),
                        rs.getInt("thoi_gian"), rs.getInt("don_vi"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public ViewModelHoaDon layMotHD(String id) {

        String query = "select HoaDon.id,ma_hoa_don,ten_nhan_vien,ten_khach_hang,ma_khuyen_mai,HoaDonChiTiet.IMEI,ngay_tao,(gia_ban - gia_giam) as 'TongTien',HoaDon.trang_thai, thoi_gian,BaoHanh.don_vi\n"
                + "from HoaDon inner join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + "inner join KhachHang on HoaDon.id_khach_hang = KhachHang.id\n"
                + "inner join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id\n"
                + "inner join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "inner join BaoHanh on HoaDonChiTiet.id_bao_hanh = BaoHanh.id\n"
                + "inner join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "inner join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_Dong = QuocGiaDong.id where HoaDon.id = ?";

        ViewModelHoaDon hd;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hd = new ViewModelHoaDon(rs.getString("id"),
                        rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ma_khuyen_mai"),
                        rs.getString("IMEI"), rs.getDate("ngay_tao"),
                        rs.getFloat("TongTien"), rs.getInt("trang_thai"),
                        rs.getInt("thoi_gian"), rs.getInt("don_vi"));
                return hd;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<ViewModelHoaDon> searchHoaDon(String maHD) {

        String query = "select HoaDon.id,ma_hoa_don,ten_nhan_vien,ten_khach_hang,ma_khuyen_mai,HoaDonChiTiet.IMEI,ngay_tao,(gia_ban - gia_giam) as 'TongTien',HoaDon.trang_thai, thoi_gian,BaoHanh.don_vi\n"
                + "from HoaDon inner join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + "inner join KhachHang on HoaDon.id_khach_hang = KhachHang.id\n"
                + "inner join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id\n"
                + "inner join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "inner join BaoHanh on HoaDonChiTiet.id_bao_hanh = BaoHanh.id\n"
                + "inner join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "inner join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_Dong = QuocGiaDong.id where HoaDon.ma_hoa_don like ?";

        List<ViewModelHoaDon> listSearch = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewModelHoaDon view = new ViewModelHoaDon(rs.getString("id"),
                        rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ma_khuyen_mai"),
                        rs.getString("IMEI"), rs.getDate("ngay_tao"),
                        rs.getFloat("TongTien"), rs.getInt("trang_thai"),
                        rs.getInt("thoi_gian"), rs.getInt("don_vi"));
                listSearch.add(view);
            }
            return listSearch;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<ViewModelHoaDon> giaCaoXuongThap() {
        String query = "select HoaDon.id,ma_hoa_don,ten_nhan_vien,ten_khach_hang,ma_khuyen_mai,HoaDonChiTiet.IMEI,ngay_tao,(gia_ban - gia_giam) as 'TongTien',HoaDon.trang_thai, thoi_gian,BaoHanh.don_vi\n"
                + "from HoaDon inner join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + "inner join KhachHang on HoaDon.id_khach_hang = KhachHang.id\n"
                + "inner join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id\n"
                + "inner join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "inner join BaoHanh on HoaDonChiTiet.id_bao_hanh = BaoHanh.id\n"
                + "inner join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "inner join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_Dong = QuocGiaDong.id\n"
                + "order by TongTien desc";

        List<ViewModelHoaDon> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewModelHoaDon hd = new ViewModelHoaDon(rs.getString("id"),
                        rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ma_khuyen_mai"),
                        rs.getString("IMEI"), rs.getDate("ngay_tao"),
                        rs.getFloat("TongTien"), rs.getInt("trang_thai"),
                        rs.getInt("thoi_gian"), rs.getInt("don_vi"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public List<ViewModelHoaDon> giaThapLenCao() {
        String query = "select HoaDon.id,ma_hoa_don,ten_nhan_vien,ten_khach_hang,ma_khuyen_mai,HoaDonChiTiet.IMEI,ngay_tao,(sum(QuocGiaDong.gia_ban) - KhuyenMai.gia_giam) as 'TongTien',HoaDon.trang_thai, thoi_gian,BaoHanh.don_vi\n"
                + "from HoaDon  join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + " join KhachHang on HoaDon.id_khach_hang = KhachHang.id\n"
                + " join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id\n"
                + " join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + " join BaoHanh on HoaDonChiTiet.id_bao_hanh = BaoHanh.id\n"
                + " join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + " join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_Dong = QuocGiaDong.id\n"
                + "group by HoaDon.id,ma_hoa_don,ten_nhan_vien,ten_khach_hang,ma_khuyen_mai,HoaDonChiTiet.IMEI,ngay_tao,HoaDon.trang_thai, thoi_gian,BaoHanh.don_vi order by TongTien asc ";
        List<ViewModelHoaDon> list = new ArrayList<>();

        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewModelHoaDon hd = new ViewModelHoaDon(rs.getString("id"),
                        rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ma_khuyen_mai"),
                        rs.getString("IMEI"), rs.getDate("ngay_tao"),
                        rs.getFloat("TongTien"), rs.getInt("trang_thai"),
                        rs.getInt("thoi_gian"), rs.getInt("don_vi"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String layIDKH(String tenKH) {
        String query = "SELECT [id]\n"
                + "  FROM [dbo].[KhachHang]\n"
                + "  where ten_khach_hang = ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, tenKH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString("id");
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String layIDNV(String maNV) {
        String query = "SELECT [id]\n"
                + "  FROM [dbo].[NhanVien]\n"
                + "  where ma_nhan_vien = ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString("id");
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String layIDKM(String maKM) {
        String query = "SELECT [id]\n"
                + "  FROM [dbo].[KhuyenMai]\n"
                + "  where ma_khuyen_mai = ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maKM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString("id");
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean thanhToan(String tenKH, String maNV, String maKM, String maHD) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [id_nhan_vien] = ?\n"
                + "      ,[id_khach_hang] = ?\n"
                + "      ,[id_khuyen_mai] = ?\n"
                + "      ,[trang_thai] = 1\n"
                + " WHERE ma_hoa_don = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, layIDNV(maNV));
            ps.setObject(2, layIDKH(tenKH));
            ps.setObject(3, layIDKM(maKM));
            ps.setObject(4, maHD);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<String> getAllMaGG() {
        String query = "SELECT [ma_khuyen_mai]\n"
                + "  FROM [dbo].[KhuyenMai]";
        List<String> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("ma_khuyen_mai"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<String> getAllMaNV() {
        String query = "SELECT [ma_nhan_vien]\n"
                + "  FROM [dbo].[NhanVien]";
        List<String> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("ma_nhan_vien"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<String> getAllKH() {
        String query = "SELECT [ten_khach_hang]\n"
                + "  FROM [dbo].[KhachHang]";
        List<String> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("ten_khach_hang"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
