/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.KhuyenMai;
import ViewModel.KhuyenMaiVeiwModel;
import java.util.List;

/**
 *
 * @author togia
 */
public interface KhuyenMaiService {

    void getAll(List<KhuyenMaiVeiwModel> list);

    String add(KhuyenMaiVeiwModel km);

    String delete(String idKM);

    String update(String idKM, KhuyenMaiVeiwModel km);

    List<KhuyenMaiVeiwModel> timTheoMa(List<KhuyenMaiVeiwModel> listKMs, String name);

    List<KhuyenMaiVeiwModel> listShowDangDienRa(List<KhuyenMaiVeiwModel> listKhuyenMais);

    List<KhuyenMaiVeiwModel> listShowSapDienRa(List<KhuyenMaiVeiwModel> listKhuyenMais);

    List<KhuyenMaiVeiwModel> listShowDaKT(List<KhuyenMaiVeiwModel> listKhuyenMais);
}
