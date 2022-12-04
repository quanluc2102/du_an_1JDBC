/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.ChucVu;
import Repository.ChucVuRepository;
import Service.ChucVuService;
import ViewModel.ChucVuViewModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class ChucVuServiceImpl implements ChucVuService {

    private ChucVuRepository cvRespository = new ChucVuRepository();

    @Override
    public List<ChucVuViewModel> getAll() {
        return cvRespository.getAllCV();
    }

    @Override
    public void showDaTa(List<ChucVuViewModel> listChucVu, DefaultTableModel dtm) {
        dtm.setRowCount(0);
        for (ChucVuViewModel x : listChucVu) {
            dtm.addRow(x.toDaTaRow());
        }
    }

    @Override
    public String add(ChucVuViewModel chucVu) {
        if (chucVu.getMa().isEmpty()) {
            return "Mã chức vụ không được để trống";
        }
        if (chucVu.getTen().isEmpty()) {
            return "Tên chức vụ không được để trống";
        }
        boolean add = cvRespository.add(chucVu);
        if (add == true) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

}
