/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.ChiTietDienThoai;
import ViewModel.ChiTietDienThoaiViewModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public interface BanHangService {
    void getAll(List<ChiTietDienThoaiViewModel> list);
    void showData(DefaultTableModel dtm,List<ChiTietDienThoaiViewModel> list);
}
