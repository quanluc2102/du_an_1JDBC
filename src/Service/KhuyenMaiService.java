/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.KhuyenMai;
import java.util.List;

/**
 *
 * @author togia
 */
public interface KhuyenMaiService {

    void getAll(List<KhuyenMai> list);

    String add(KhuyenMai km);

    String delete(String idKM);

    String update(String idKM, KhuyenMai km);

    List<KhuyenMai> timTheoTen(List<KhuyenMai> listKMs, String name);

    List<KhuyenMai> listShowDangDienRa(List<KhuyenMai> listKhuyenMais);

    List<KhuyenMai> listShowSapDienRa(List<KhuyenMai> listKhuyenMais);

    List<KhuyenMai> listShowDaKT(List<KhuyenMai> listKhuyenMais);
}
