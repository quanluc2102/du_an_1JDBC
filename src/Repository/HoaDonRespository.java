/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import ViewModel.ViewModelHoaDon;
import java.util.List;
import Ultilities.SQLServerConnection;
import ViewModel.VIewModelSanPhamHoaDon;
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

    public List<ViewModelHoaDon> getAllHoaDon() {

        String query = "select distinct HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam,\n"
                + "(sum(QuocGiaDong.gia_ban - KhuyenMai.gia_giam)) as 'Tong Tien', count(ChiTietDienThoai.IMEI) as 'Tong so San pham'\n"
                + "from HoaDon left join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + "left join KhachHang on HoaDon.id_khach_hang = KhachHang.id \n"
                + "full join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "full join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "full join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "left join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id\n"
                + "group by HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam";
        List<ViewModelHoaDon> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewModelHoaDon view = new ViewModelHoaDon(rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ngay_tao"),
                        rs.getString("ma_khuyen_mai"), rs.getInt("trang_thai"),
                        rs.getInt("Tong so San pham"), rs.getFloat("gia_giam"), rs.getFloat("Tong Tien"));
                list.add(view);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public List<ViewModelHoaDon> getAllHoaDon5Rows(int rowOfSet) {

        String query = "select HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam,\n"
                + "(sum(QuocGiaDong.gia_ban - KhuyenMai.gia_giam)) as 'Tong Tien', count(ChiTietDienThoai.IMEI) as 'Tong so San pham'\n"
                + "from HoaDon left join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + "left join KhachHang on HoaDon.id_khach_hang = KhachHang.id \n"
                + "full join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "full join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "full join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "left join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id \n"
                + "group by HoaDon.id,HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam\n"
                + "order by HoaDon.id\n"
                + "offset ? rows fetch next 5 rows only";
        List<ViewModelHoaDon> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareCall(query);) {
            ps.setObject(1, rowOfSet);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewModelHoaDon view = new ViewModelHoaDon(rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ngay_tao"),
                        rs.getString("ma_khuyen_mai"), rs.getInt("trang_thai"),
                        rs.getInt("Tong so San pham"), rs.getFloat("gia_giam"), rs.getFloat("Tong Tien"));
                list.add(view);
            }
            return list;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<VIewModelSanPhamHoaDon> getAllSanPham(String mahd) {
        String query = "select DienThoai.ma_dien_thoai,HoaDon.ma_hoa_don,\n"
                + "DienThoai.ten_dien_thoai,Hang.ten_hang,Dong.ten_dong,\n"
                + "QuocGiaDong.gia_ban,ChiTietDienThoai.moi,ChiTietDienThoai.mo_ta\n"
                + "from HoaDon join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "full join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "full join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "full join Dong on QuocGiaDong.id_dong = Dong.id\n"
                + "full join DienThoai on Dong.id_dien_thoai = DienThoai.id\n"
                + "full join Hang on DienThoai.id_hang = Hang.id where HoaDon.ma_hoa_don like ?";

        List<VIewModelSanPhamHoaDon> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareCall(query);) {
            ps.setObject(1, mahd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                VIewModelSanPhamHoaDon view = new VIewModelSanPhamHoaDon(rs.getString("ma_dien_thoai"),
                        rs.getString("ma_hoa_don"), rs.getString("ten_dien_thoai"),
                        rs.getString("ten_hang"), rs.getString("ten_dong"),
                        rs.getFloat("gia_ban"), rs.getInt("moi"), rs.getString("mo_ta"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<ViewModelHoaDon> giaCaoXuongThap(int rowOfset) {
        String query = "select HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam,\n"
                + "(sum(QuocGiaDong.gia_ban - KhuyenMai.gia_giam)) as 'Tong Tien', count(ChiTietDienThoai.IMEI) as 'Tong so San pham'\n"
                + "from HoaDon left join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + "left join KhachHang on HoaDon.id_khach_hang = KhachHang.id \n"
                + "full join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "full join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "full join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "left join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id \n"
                + "group by HoaDon.id,HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam\n"
                + "order by HoaDon.id,(sum(QuocGiaDong.gia_ban - KhuyenMai.gia_giam)) desc\n"
                + "offset ? rows fetch next 5 rows only";

        List<ViewModelHoaDon> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, rowOfset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewModelHoaDon hd = new ViewModelHoaDon(rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ngay_tao"),
                        rs.getString("ma_khuyen_mai"), rs.getInt("trang_thai"),
                        rs.getInt("Tong so San pham"), rs.getFloat("gia_giam"), rs.getFloat("Tong Tien"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public List<ViewModelHoaDon> giaThapLenCao(int rowOfSet) {
        String query = "select HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam,\n"
                + "(sum(QuocGiaDong.gia_ban - KhuyenMai.gia_giam)) as 'Tong Tien', count(ChiTietDienThoai.IMEI) as 'Tong so San pham'\n"
                + "from HoaDon left join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + "left join KhachHang on HoaDon.id_khach_hang = KhachHang.id \n"
                + "full join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "full join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "full join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "left join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id \n"
                + "group by HoaDon.id,HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam\n"
                + "order by HoaDon.id,(sum(QuocGiaDong.gia_ban - KhuyenMai.gia_giam)) asc\n"
                + "offset ? rows fetch next 5 rows only ";
        List<ViewModelHoaDon> list = new ArrayList<>();

        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, rowOfSet);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewModelHoaDon hd = new ViewModelHoaDon(rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ngay_tao"),
                        rs.getString("ma_khuyen_mai"), rs.getInt("trang_thai"),
                        rs.getInt("Tong so San pham"), rs.getFloat("gia_giam"), rs.getFloat("Tong Tien"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<ViewModelHoaDon> searchHoaDon(String mahd, int rowOfSet) {

        String query = "select HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam,\n"
                + "(sum(QuocGiaDong.gia_ban - KhuyenMai.gia_giam)) as 'Tong Tien', count(ChiTietDienThoai.IMEI) as 'Tong so San pham'\n"
                + "from HoaDon left join NhanVien on HoaDon.id_nhan_vien = NhanVien.id\n"
                + "left join KhachHang on HoaDon.id_khach_hang = KhachHang.id \n"
                + "full join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "full join ChiTietDienThoai on HoaDonChiTiet.IMEI = ChiTietDienThoai.IMEI\n"
                + "full join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_dong = QuocGiaDong.id\n"
                + "left join KhuyenMai on HoaDon.id_khuyen_mai = KhuyenMai.id \n"
                + "where HoaDon.ma_hoa_don like ?\n"
                + "group by HoaDon.id,HoaDon.ma_hoa_don,NhanVien.ten_nhan_vien,KhachHang.ten_khach_hang,\n"
                + "HoaDon.ngay_tao,KhuyenMai.ma_khuyen_mai,HoaDon.trang_thai,KhuyenMai.gia_giam\n"
                + "order by HoaDon.id\n"
                + "offset ? rows fetch next 5 rows only";

        List<ViewModelHoaDon> listSearch = new ArrayList<>();
        String a = "%" + mahd + "%";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareCall(query);) {
            ps.setObject(1, a);
            ps.setObject(2, rowOfSet);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ViewModelHoaDon hd = new ViewModelHoaDon(rs.getString("ma_hoa_don"), rs.getString("ten_nhan_vien"),
                        rs.getString("ten_khach_hang"), rs.getString("ngay_tao"),
                        rs.getString("ma_khuyen_mai"), rs.getInt("trang_thai"),
                        rs.getInt("Tong so San pham"), rs.getFloat("gia_giam"), rs.getFloat("Tong Tien"));
                listSearch.add(hd);
            }
            return listSearch;
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
