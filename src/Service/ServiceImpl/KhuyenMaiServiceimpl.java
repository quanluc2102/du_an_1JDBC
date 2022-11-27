/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.KhuyenMai;
import Repository.KhuyenMaiResponsitory;
import Service.KhuyenMaiService;
import ViewModel.KhuyenMaiVeiwModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author togia
 */
public class KhuyenMaiServiceimpl implements KhuyenMaiService {

    private KhuyenMaiResponsitory rs = new KhuyenMaiResponsitory();

    @Override
    public String add(KhuyenMaiVeiwModel km) {
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
    public void getAll(List<KhuyenMaiVeiwModel> list) {
        list.addAll(rs.getAll());

    }

    @Override
    public String update(String idKM, KhuyenMaiVeiwModel km) {
        boolean update = rs.update(km, idKM);
        if (update == true) {
            return "Sửa thành công";
        } else {
            return "Sủa thất bại";
        }
    }

    @Override
    public List<KhuyenMaiVeiwModel> timTheoMa(List<KhuyenMaiVeiwModel> listKMs, String ma) {
        List<KhuyenMaiVeiwModel> listSearch = new ArrayList<>();
        for (KhuyenMaiVeiwModel km : listKMs) {
            if (km.getMa().contains(ma)) {
                listSearch.add(km);
            }
        }
        return listSearch;
    }

    @Override
    public List<KhuyenMaiVeiwModel> listShowDangDienRa(List<KhuyenMaiVeiwModel> listKhuyenMais) {
        List<KhuyenMaiVeiwModel> listShowDangDienRa = new ArrayList<>();
        for (KhuyenMaiVeiwModel KM : listKhuyenMais) {
            if (KM.getTrangThai() == 0) {
                listShowDangDienRa.add(KM);
            }
        }
        return listShowDangDienRa;
    }

    @Override
    public List<KhuyenMaiVeiwModel> listShowSapDienRa(List<KhuyenMaiVeiwModel> listKhuyenMais) {
        List<KhuyenMaiVeiwModel> listShowSapDienRa = new ArrayList<>();
        for (KhuyenMaiVeiwModel KM : listKhuyenMais) {
            if (KM.getTrangThai() == 1) {
                listShowSapDienRa.add(KM);
            }
        }
        return listShowSapDienRa;
    }

    @Override
    public List<KhuyenMaiVeiwModel> listShowDaKT(List<KhuyenMaiVeiwModel> listKhuyenMais) {
        List<KhuyenMaiVeiwModel> listShowDaKT = new ArrayList<>();
        for (KhuyenMaiVeiwModel KM : listKhuyenMais) {
            if (KM.getTrangThai() == 2) {
                listShowDaKT.add(KM);
            }
        }
        return listShowDaKT;
    }

    @Override
    public List<KhuyenMaiVeiwModel> sget() {
        return rs.getAll();
    }

}
