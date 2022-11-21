/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietDienThoai;
import DomainModel.HoaDon;
import DomainModel.HoaDonChiTiet;
import Ultilities.SQLServerConnection;
import ViewModel.ChiTietDienThoaiViewModel;
import ViewModel.HoaDonChiTietViewModel;
import java.math.BigDecimal;
import java.math.BigInteger;
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

    public String layTenSP(String imei) {
        String query = "SELECT [ten_hien_thi]\n"
                + "  FROM [dbo].[QuocGiaDong]\n"
                + "  join ChiTietDienThoai on ChiTietDienThoai.id_quoc_gia_Dong=QuocGiaDong.id\n"
                + "  where IMEI = ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei);
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

    public int layGiaHoaDon(String imei) {
        String query = "SELECT [gia_ban]\n"
                + "  FROM [dbo].[QuocGiaDong]\n"
                + "  join ChiTietDienThoai on ChiTietDienThoai.id_quoc_gia_Dong=QuocGiaDong.id\n"
                + "  where ChiTietDienThoai.IMEI = ?";
        int a = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei);
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

    public List<String> getAllMaHoaDon() {
        String query = "SELECT [ma_hoa_don]\n"
                + "  FROM [dbo].[HoaDon]";
        List<String> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("ma_hoa_don"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDonChiTietViewModel> getAllHoaDon(String maHD) {
        String query = "SELECT HoaDonChiTiet.[id]\n"
                + "      ,[IMEI]\n"
                + "      ,[id_hoa_don]\n"
                + "      ,[id_bao_hanh]\n"
                + "  FROM [dbo].[HoaDonChiTiet]\n"
                + "  join HoaDon on HoaDon.id = HoaDonChiTiet.id_hoa_don\n"
                + "  where ma_hoa_don = ?";
        List<HoaDonChiTietViewModel> list = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTietViewModel a = new HoaDonChiTietViewModel(rs.getString("id"), rs.getString("IMEI"), rs.getString("id_hoa_don"), rs.getString("id_bao_hanh"));
                list.add(a);
            }
            return list;
        } catch (SQLException s) {
            s.printStackTrace(System.out);
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

    public String getIdHD(String maHD) {
        String query = "SELECT [id]\n"
                + "  FROM [dbo].[HoaDon]\n"
                + "  where ma_hoa_don = ?";
        String a = "";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
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

    public boolean addVaoHoaDonCT(String imei, String maHD) {
        String query = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([IMEI]\n"
                + "           ,[id_hoa_don])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei);
            ps.setObject(2, getIdHD(maHD));
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteHoaDonCT(String imei, String maHD) {
        String query = "DELETE FROM [dbo].[HoaDonChiTiet]\n"
                + "      WHERE IMEI = ? and id_hoa_don = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei);
            ps.setObject(2, getIdHD(maHD));
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean addHoaDon() {
        String query = "INSERT INTO [dbo].[HoaDon]\n"
                + "           ([ma_hoa_don]\n"
                + "           ,[ngay_tao]\n"
                + "		   ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,GETDATE(),0)";
        int check = 0;
        String maHD = maHD();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public String maHD() {
        HoaDon hd = new HoaDon();
        List<String> hdl = getAllMaHoaDon();
        List<Integer> hds = new ArrayList<>();
        for (String hoaDon : hdl) {
            int soHD = Integer.valueOf(hoaDon.substring(2)) + 1;
            hds.add(soHD);
        }
        int j = 0;
        for (Integer integer : hds) {
            int i = integer;
            if (j < i) {
                j = i;
            }
        }
        return "HD" + j;
    }

    public BigDecimal layGiaTien(String maHD) {
        String query = "SELECT	Sum(gia_ban)\n"
                + "  FROM [dbo].[HoaDonChiTiet]\n"
                + "  join ChiTietDienThoai on ChiTietDienThoai.IMEI=HoaDonChiTiet.IMEI\n"
                + "  join QuocGiaDong on ChiTietDienThoai.id_quoc_gia_Dong=QuocGiaDong.id\n"
                + "  join HoaDon on HoaDon.id=HoaDonChiTiet.id_hoa_don\n"
                + "  where ma_hoa_don = ?";
        BigDecimal a = null ;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a=rs.getBigDecimal(1);
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
        
    }
}
