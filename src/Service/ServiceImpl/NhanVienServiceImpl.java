/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import Repository.NhanVienRepository;
import Service.NhanVienService;
import ViewModel.NhanVienView;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author buiti
 */
public class NhanVienServiceImpl implements NhanVienService {

    @Override
    public List<NhanVienView> getAll() {
        return new NhanVienRepository().getAll();
    }

    @Override
    public void showData(DefaultTableModel dtm, List<NhanVienView> list) {
         dtm.setRowCount(0);
         for (NhanVienView nhanVienView : list) {
             dtm.addRow(nhanVienView.toData());
            
        }
    }

  

}
