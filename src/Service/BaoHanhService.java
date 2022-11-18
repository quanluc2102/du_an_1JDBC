/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.BaoHanh;
import ViewModel.BaoHanhViewModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public interface BaoHanhService {

    List<BaoHanhViewModel> getAll();

    void showDaTa(List<BaoHanhViewModel> listBaoHanh, DefaultTableModel dtm);

    String delete(String idBH);

    String add(BaoHanh baoHanh);

    String update(BaoHanh baoHanh, String id);
}
