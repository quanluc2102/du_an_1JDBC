package Service;

import DomainModel.ThongSo;
import ViewModel.ThongSoViewModel;
import ViewModel.vts;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author haha
 */
public interface AddElementServices {
    List<vts> view (ThongSoViewModel t);
    List<vts> dataToView (ThongSo t);
    String themThongSo (ThongSo t);
    
}
