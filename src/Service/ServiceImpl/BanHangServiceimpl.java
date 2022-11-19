/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.ChiTietDienThoai;
import Repository.BanHangReponsitory;
import Service.BanHangService;
import ViewModel.ChiTietDienThoaiViewModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BanHangServiceimpl implements BanHangService {

    BanHangReponsitory bhr = new BanHangReponsitory();

    @Override
    public void getAll(List<ChiTietDienThoaiViewModel> list) {
        list.addAll(bhr.getAll());
    }

    @Override
    public void showData(DefaultTableModel dtm, List<ChiTietDienThoaiViewModel> list) {
        dtm.setRowCount(0);
        for (ChiTietDienThoaiViewModel a : list) {
            dtm.addRow(a.toDataRowBanHangView());
        }
    }

}
