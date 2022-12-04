/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Ultilities.SQLServerConnection;
import ViewModel.CameraModelView;
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
public class CameraRepon {
    public List<CameraModelView> get1CMD(String id) {
        String query = "select cam_bien,khau_do, chuc_nang,max_zoom,quay_video from Camera join CamBien on CamBien.id = Camera.id_cam_bien\n"
                + "where id_thong_so = ?";
        List<CameraModelView> ls = new ArrayList<>();
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                CameraModelView sp = new CameraModelView(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

                ls.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ls;
    }
    
    
//    select COUNT(Camera.id_cam_bien)
//from 
//	ThongSo full outer join Camera on Camera.id_thong_so = ThongSo.id
//	join CamBien on cambien.id = Camera.id_cam_bien
//where   truoc_sau = 0 and id_dong = ?
}
