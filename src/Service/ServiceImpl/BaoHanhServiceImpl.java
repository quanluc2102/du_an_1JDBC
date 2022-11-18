/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.BaoHanh;
import Repository.BaoHanhRespository;
import Service.BaoHanhService;
import ViewModel.BaoHanhViewModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class BaoHanhServiceImpl implements BaoHanhService {

    private BaoHanhRespository baoHanhRespository = new BaoHanhRespository();

    @Override
    public void showDaTa(List<BaoHanhViewModel> listBaoHanh, DefaultTableModel dtm) {
        dtm.setRowCount(0);
        for (BaoHanhViewModel x : listBaoHanh) {
            dtm.addRow(x.toDaTaRow());
        }

    }

    @Override
    public String delete(String idBH) {
        boolean delete = baoHanhRespository.delete(idBH);
        if (delete == true) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String add(BaoHanh baoHanh) {
        boolean add = baoHanhRespository.add(baoHanh);
        if (add == true) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(BaoHanh baoHanh, String id) {
        boolean update = baoHanhRespository.Update(baoHanh, id);
        if (update == true) {
            return "cập nhật  thành công";
        } else {
            return "Cập nhật thất bại";
        }
    }

    @Override
    public List<BaoHanhViewModel> getAll() {
        return baoHanhRespository.getAll();
    }

}
