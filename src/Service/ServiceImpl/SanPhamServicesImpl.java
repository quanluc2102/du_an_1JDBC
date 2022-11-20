/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import Repository.SanPhamRespository;
import Service.SanPhamServices;
import ViewModel.SanPhamViewModel;
import java.util.List;

/**
 *
 * @author haha
 */
public class SanPhamServicesImpl implements SanPhamServices{

    @Override
    public List<SanPhamViewModel> getAll() {
        return new SanPhamRespository().getAll();
    }
    
}
