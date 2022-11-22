/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.ThongSo;
import Repository.SanPhamRespository;
import Service.SanPhamServices;
import ViewModel.SanPhamViewModel;
import ViewModel.ThongSoViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haha
 */
public class SanPhamServicesImpl implements SanPhamServices {

    @Override
    public List<SanPhamViewModel> getAll() {
        return new SanPhamRespository().getAll();
    }

    @Override
    public ThongSoViewModel getAllThongSo(String id) {
        return new SanPhamRespository().getAllThongSoView(id);
    }

    @Override
    public String ban(String IMEI) {
        if (new SanPhamRespository().ban(IMEI)) {
            return "ban thanh cong";
        }

        return "ban that bai";
    }

    @Override
    public List<SanPhamViewModel> timKiem(String x) {
        List<SanPhamViewModel> s = new ArrayList<>();
        for (SanPhamViewModel y : new SanPhamRespository().getAll()) {
            if (y.getTen().contains(x)) {
                s.add(y);
            }
        }
        return s;

    }

}
