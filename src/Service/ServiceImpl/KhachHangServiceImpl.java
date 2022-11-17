/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.KhachHang;
import Repository.KhachHangRepository;
import Service.KhachHangService;
import ViewModel.KhachHangViewModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quanl
 */
public class KhachHangServiceImpl implements KhachHangService {

    KhachHangRepository repo = new KhachHangRepository();

    @Override
    public List<KhachHangViewModel> getAllKhachHang() {
        return repo.getAllKhachHang();
    }

    @Override
    public void showDataTable(DefaultTableModel dtm, List<KhachHangViewModel> list) {
        dtm.setRowCount(0);
        for (KhachHangViewModel khachHangViewModel : list) {
            dtm.addRow(khachHangViewModel.toDataRow());
        }
    }

    @Override
    public String addKhachHang(KhachHang kh) {
        if (repo.addKhachHang(kh)) {
            return "Them khach hang thanh cong";
        } else {
            return "Them khach hang that bai";
        }
    }

    @Override
    public String editKhachHang(KhachHang kh, String id) {
        if (repo.editKhachHang(kh, id)) {
            return "Sua khach hang thanh cong";
        } else {
            return "Sua khach hang that bai";
        }
    }

    @Override
    public String deleteKhachHang(String id) {
        if (repo.deleteKhachHang(id)) {
            return "Xoa khach hang thanh cong";
        } else {
            return "Xoa khach hang that bai";
        }
    }

}
