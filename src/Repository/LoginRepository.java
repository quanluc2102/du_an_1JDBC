/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.NhanVien;
import Ultilities.SQLServerConnection;
import ViewModel.LoginViewModel;
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
public class LoginRepository {

    public List<LoginViewModel> getAll() {
        List<LoginViewModel> ls = new ArrayList<>();
        try ( Connection conn = new SQLServerConnection().getConnection()) {
            String query = "Select ma_nhan_vien,mat_khau,ten_chuc_vu from NhanVien join ChucVu on NhanVien.id_chuc_vu = ChucVu.id";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ls.add(new LoginViewModel(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
        public static void main(String[] args) {
        List<LoginViewModel> l = new LoginRepository().getAll();
        for (LoginViewModel nhanVien : l) {
            System.out.println(nhanVien.toString());
        }
    }
}
