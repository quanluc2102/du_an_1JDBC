/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.ChucVu;
import DomainModel.NhanVien;
import Repository.ChucVuRepository;
import Repository.LoginRepository;
import Service.LoginService;
import ViewModel.LoginViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buiti
 */
public class LoginImpl implements LoginService {

    @Override
    public String login(String username, String pass) {
        List<LoginViewModel> lg = new LoginRepository().getAll();
        for (LoginViewModel loginViewModel : lg) {
            if (loginViewModel.getMa().equalsIgnoreCase(username) && loginViewModel.getMatKhau().equalsIgnoreCase(pass) && loginViewModel.getTenCV().equalsIgnoreCase("Nhân viên")) {
                return "NV";
            }
            if (loginViewModel.getMa().equalsIgnoreCase(username) && loginViewModel.getMatKhau().equalsIgnoreCase(pass) && loginViewModel.getTenCV().equalsIgnoreCase("Quản lý")) {
                return "QL";
            }
        }
        return "NOT";
    }

    @Override
    public List<String> ChucVuCBB() {
        List<String> cbb = new ArrayList<>();
        ChucVuRepository cv = new ChucVuRepository();
        List<ChucVu> fullCH = cv.getAll();
        for (ChucVu chucVu : fullCH) {
            cbb.add(chucVu.getTen());
        }
        return cbb;
    }

    @Override
    public List<String> IDChucVu() {
        List<String> cbb = new ArrayList<>();
        ChucVuRepository cv = new ChucVuRepository();
        List<ChucVu> fullCH = cv.getAll();
        for (ChucVu chucVu : fullCH) {
            cbb.add(chucVu.getId());
        }
        return cbb;
    }

    @Override
    public String dangKi(NhanVien nv) {
        LoginRepository nva = new LoginRepository();
        if (nva.addNV(nv)) {
            return "them thanh cong";
        }

        return "them that bai";
    }

    @Override
    public String loginWebCam(String cmnd) {

        List<LoginViewModel> lg = new LoginRepository().getAll();

        for (LoginViewModel x : lg) {

            if (x.getCmnd().equalsIgnoreCase(cmnd)) {
                return "chúng mày tuổi";
            }

        }
        return "Không chính xác";
    }
}
