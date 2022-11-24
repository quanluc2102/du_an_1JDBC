/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.KhuyenMai;
import Repository.KhuyenMaiResponsitory;
import Service.KhuyenMaiService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author togia
 */
public class KhuyenMaiServiceimpl implements KhuyenMaiService {

    private KhuyenMaiResponsitory rs = new KhuyenMaiResponsitory();

    @Override
    public String add(KhuyenMai km) {
        boolean add = rs.add(km);
        if (add == true) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }

    }

    @Override
    public String delete(String idKM) {
        boolean delete = rs.delete(idKM);
        if (delete == true) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public void getAll(List<KhuyenMai> list) {
        list.addAll(rs.getAll());

    }

    @Override
    public String update(String idKM, KhuyenMai km) {
        boolean update = rs.update(km, idKM);
        if (update == true) {
            return "Sửa thành công";
        } else {
            return "Sủa thất bại";
        }
    }

    @Override
    public List<KhuyenMai> timTheoTen(List<KhuyenMai> listKMs, String ma) {
        List<KhuyenMai> listSearch = new ArrayList<>();
        for (KhuyenMai km : listKMs) {
            if (km.getMa().contains(ma)) {
                listSearch.add(km);
            }
        }
        return listSearch;
    }

    @Override
    public List<KhuyenMai> listShowDangDienRa(List<KhuyenMai> listKhuyenMais) {
        List<KhuyenMai> listShowDangDienRa = new ArrayList<>();
        for (KhuyenMai KM :listKhuyenMais) {
            if (KM.getTrangThai().equals("Dang dien ra")) {
                listShowDangDienRa.add(KM);
            }
        }
        return listShowDangDienRa;
    }

    @Override
    public List<KhuyenMai> listShowSapDienRa(List<KhuyenMai> listKhuyenMais) {
        List<KhuyenMai> listShowSapDienRa = new ArrayList<>();
        for (KhuyenMai KM :listKhuyenMais) {
            if (KM.getTrangThai().equals("Sap dien ra")) {
                listShowSapDienRa .add(KM);
            }
        }
        return listShowSapDienRa ;
    }

    @Override
    public List<KhuyenMai> listShowDaKT(List<KhuyenMai> listKhuyenMais) {
       List<KhuyenMai> listShowDaKT = new ArrayList<>();
        for (KhuyenMai KM :listKhuyenMais) {
            if (KM.getTrangThai().equals("Da ket thuc")) {
                listShowDaKT.add(KM);
            }
        }
        return listShowDaKT ;
    }

}
