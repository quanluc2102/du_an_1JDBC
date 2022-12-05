/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Service.ServiceImpl.HoaDonImpl;
import ViewModel.VIewModelSanPhamHoaDon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import ViewModel.ViewModelHoaDon;

/**
 *
 * @author PC
 */
public class ViewHoaDon extends javax.swing.JFrame {

    private DefaultTableModel tableHoaDon = new DefaultTableModel();
    private DefaultTableModel tableSanPhamHD = new DefaultTableModel();
    private DefaultComboBoxModel ccbTim = new DefaultComboBoxModel();
    private DefaultComboBoxModel ccbSapXep = new DefaultComboBoxModel();
    private List<ViewModelHoaDon> listGetAll = new ArrayList<>();
    private List<ViewModelHoaDon> listSearch = new ArrayList<>();
    private List<ViewModelHoaDon> listSort = new ArrayList<>();
    private List<String> ccbFind = new ArrayList<>();
    private List<VIewModelSanPhamHoaDon> listGetSP = new ArrayList<>();
    private List<String> ccb = new ArrayList<>();
    private HoaDonImpl sv = new HoaDonImpl();
    String name = "";
    int TrangThai = 0;

    public ViewHoaDon() {
        initComponents();
        tlbHoaDon.setModel(tableHoaDon);
        tlbSanPham.setModel(tableSanPhamHD);
        ccbLoc.setModel(ccbSapXep);
        ccb.add("Theo giá từ thấp lên cao");
        ccb.add("Theo giá từ cao xuống thấp");

        for (String string : ccb) {
            ccbSapXep.addElement(string);
        }
        for (String string : ccbFind) {
            ccbTim.addElement(string);
        }

        String[] heaaderHoaDon = {"Mã HD", "Tên NV", "Tên KH", "Ngày Tạo", "Mã Khuyến Mại", "Tổng Tiền", "Trạng Thái", "Tổng số SP"};
        tableHoaDon.setColumnIdentifiers(heaaderHoaDon);
        String[] headerSanPham = {"Mã DT", "Mã HD ", "Tên SP", "Hãng", "Dòng", "Độ Mới", "Mô tả"};
        tableSanPhamHD.setColumnIdentifiers(headerSanPham);

        listSearch = sv.getAll(listGetAll);
        sv.showData(listSearch, tableHoaDon);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ccbLoc = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        radioChuaThanhToan = new javax.swing.JRadioButton();
        radioDaThanhToan = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlbHoaDon = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tlbSanPham = new javax.swing.JTable();
        btnLoc = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        radioTatCa = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setText("Hóa Đơn");

        jLabel2.setText("Tìm Kiếm:");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel3.setText("Sắp Xếp Theo:");

        ccbLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Trạng Thái:");

        buttonGroup1.add(radioChuaThanhToan);
        radioChuaThanhToan.setText("Chưa thanh toán");
        radioChuaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioChuaThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioDaThanhToan);
        radioDaThanhToan.setText("Đã thanh toán");
        radioDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDaThanhToanActionPerformed(evt);
            }
        });

        tlbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HĐ", "Tên NV", "Tên KH", "Ngày Tạo", "Mã Khuyến Mại", "Tổng Tiền", "Trạng Thái", "Title 8"
            }
        ));
        tlbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tlbHoaDon);

        tlbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã ĐT", "Mã HĐ", "Tên SP", "Hãng", "Dòng", "Giá Bán", "Độ Mới", "Mô Tả"
            }
        ));
        jScrollPane2.setViewportView(tlbSanPham);

        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioTatCa);
        radioTatCa.setText("Tất cả");
        radioTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(517, 517, 517))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(ccbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoc)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioChuaThanhToan)
                        .addGap(35, 35, 35)
                        .addComponent(radioDaThanhToan)
                        .addGap(47, 47, 47)
                        .addComponent(radioTatCa)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ccbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(radioChuaThanhToan)
                    .addComponent(radioDaThanhToan)
                    .addComponent(radioTatCa))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDong)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tlbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlbHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tlbHoaDon.getSelectedRow();
        String mahd = listGetAll.get(row).getMaHD();
        listGetSP = sv.getAllSp(mahd);
        sv.showData1(listGetSP, tableHoaDon);

    }//GEN-LAST:event_tlbHoaDonMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        name = txtTimKiem.getText();
        sv.showData(sv.searchHoaDon(name), tableHoaDon);
        listSearch = sv.searchHoaDon(name);
        TrangThai = 1;
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ViewHoaDon view = new ViewHoaDon();
        view.setVisible(true);
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        if (ccbLoc.getSelectedIndex() == 0) {
            sv.giaCaoXuongThap(listSearch);
            sv.showData(listSearch, tableHoaDon);
        }

        if (ccbLoc.getSelectedIndex() == 1) {
            sv.giaThapLenCao(listSearch);
            sv.showData(listSearch, tableHoaDon);
        }
        TrangThai = 2;
    }//GEN-LAST:event_btnLocActionPerformed

    private void radioChuaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioChuaThanhToanActionPerformed
        // TODO add your handling code here:
        listSort.removeAll(listSort);
        for (ViewModelHoaDon viewModelHoaDon : listSearch) {
            if (viewModelHoaDon.getTrangThai() == 0) {
                listSort.add(viewModelHoaDon);
            }
        }
        TrangThai = 3;
        sv.showData(listSort, tableHoaDon);
    }//GEN-LAST:event_radioChuaThanhToanActionPerformed

    private void radioDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDaThanhToanActionPerformed
        // TODO add your handling code here:
        listSort.removeAll(listSort);
        for (ViewModelHoaDon viewModelHoaDon : listSearch) {
            if (viewModelHoaDon.getTrangThai() == 1) {
                listSort.add(viewModelHoaDon);
            }
        }
        TrangThai = 3;
        sv.showData(listSort, tableHoaDon);
    }//GEN-LAST:event_radioDaThanhToanActionPerformed

    private void radioTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTatCaActionPerformed
        // TODO add your handling code here:
        sv.showData(listSearch, tableHoaDon);
    }//GEN-LAST:event_radioTatCaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnLoc;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> ccbLoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radioChuaThanhToan;
    private javax.swing.JRadioButton radioDaThanhToan;
    private javax.swing.JRadioButton radioTatCa;
    private javax.swing.JTable tlbHoaDon;
    private javax.swing.JTable tlbSanPham;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
