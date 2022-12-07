/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Service.ServiceImpl.ThongKeKhachHangServiceImpl;
import Service.ThongKeKhachHangService;
import ViewModel.SanPhamDaMuaViewModel;
import ViewModel.SoLanMuaViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author quanl
 */
public class ThongKeKhachHangView extends javax.swing.JFrame {

    /**
     * Creates new form ThongKeKhachHangView
     */
    private DefaultTableModel dtmSoLan = new DefaultTableModel();
    private DefaultTableModel dtmDaMua = new DefaultTableModel();
    private List<SoLanMuaViewModel> listSoLanMua = new ArrayList<>();
    private List<SoLanMuaViewModel> listSearch = new ArrayList<>();
    private List<SoLanMuaViewModel> listSearchTen = new ArrayList<>();
    private List<SanPhamDaMuaViewModel> listSPDM = new ArrayList<>();
    private List<SoLanMuaViewModel> listSearchSoLuong = new ArrayList<>();
    private ThongKeKhachHangService thongKeKhachHangService = new ThongKeKhachHangServiceImpl();
    int rowoffset = 0;
    int index = 0;
    
    public ThongKeKhachHangView() {
        initComponents();
//        tbHoaDonDaMua.setModel(dtmDaMua);
        tbSoLanMua.setModel(dtmSoLan);
        tbSoLanMua1.setModel(dtmDaMua);
        String daMua[] = {"IMEI", "Ten san pham", "Ten Dong", "Gia ban"};
        String soLanMua[] = {"ID", "Ten Khach Hang", "So lan mua"};
        dtmDaMua.setColumnIdentifiers(daMua);
        dtmSoLan.setColumnIdentifiers(soLanMua);
        listSoLanMua = thongKeKhachHangService.getAllSoLanMua(rowoffset);
        thongKeKhachHangService.showDataTableSoLan(dtmSoLan, listSoLanMua);
        sapXep();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSoLanMua = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbSoLanMua1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Thong ke khach hang");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("So lan mua"));

        tbSoLanMua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSoLanMua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSoLanMuaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbSoLanMua);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("jButton1");

        jButton3.setText("jButton1");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton1");

        jLabel2.setText("Tìm kiem theo ten: ");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("San Pham Da Mua"));

        tbSoLanMua1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSoLanMua1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSoLanMua1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbSoLanMua1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel2)
                        .addGap(148, 148, 148)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbSoLanMuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSoLanMuaMouseClicked
        // TODO add your handling code here:
        int row = 0;
        row = tbSoLanMua.getSelectedRow();
        String id = listSoLanMua.get(row).getID();
        listSPDM = thongKeKhachHangService.getAllSPDM(id);
        thongKeKhachHangService.showDataTableSPDM(dtmDaMua, listSPDM);
    }//GEN-LAST:event_tbSoLanMuaMouseClicked
    String name = "";
    int soLan;
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        if (!txtSearch.getText().isEmpty() || !txtSearch.getText().isBlank()) {
            name = txtSearch.getText();
            listSearch = thongKeKhachHangService.searchTen(name, rowoffset);
            listSearchTen = thongKeKhachHangService.searchTen(name, rowoffset);
            try {
                thongKeKhachHangService.showDataTableSoLan(dtmSoLan, listSearch);
            } catch (Exception e) {
                thongKeKhachHangService.showDataTableSoLan(dtmSoLan, listSearch);
            }
        }
        
        if (txtSearch.getText().isEmpty() || txtSearch.getText().isBlank()) {
            listSoLanMua = thongKeKhachHangService.getAllSoLanMua(rowoffset);
            thongKeKhachHangService.showDataTableSoLan(dtmSoLan, thongKeKhachHangService.getAllSoLanMua(rowoffset));
        }
    }//GEN-LAST:event_txtSearchKeyReleased
    private void sapXep() {// gọi trong hàm khởi tạo
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(dtmSoLan); // tbla là defautablemodel của bảng mình muốn sắp xếp
        tbSoLanMua.setRowSorter(sorter);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (txtSearch.getText().isEmpty()) {
            index++;
            rowoffset += 5;
            if (rowoffset > thongKeKhachHangService.getAllSoLanMuaKPT().size() - 1) {
                rowoffset = 0;
                index = 0;
            }
            listSoLanMua = thongKeKhachHangService.getAllSoLanMuaKPT();
            thongKeKhachHangService.showDataTableSoLan(dtmSoLan, thongKeKhachHangService.getAllSoLanMua(rowoffset));
            
        } else {
            
            if (!txtSearch.getText().isEmpty()) {
                index++;
                rowoffset += 5;
                if (rowoffset > listSearchTen.size()) {
                    
                    rowoffset = 0;
                    index = 0;
                    
                }
                
                thongKeKhachHangService.showDataTableSoLan(dtmSoLan, thongKeKhachHangService.searchTen(name, rowoffset));
                
            } else {
                index++;
                rowoffset += 5;
                
                if (rowoffset > listSoLanMua.size()) {
                    rowoffset = 0;
                    index = 0;
                    
                }
                
                thongKeKhachHangService.showDataTableSoLan(dtmSoLan, thongKeKhachHangService.searchSoLanMua(soLan, rowoffset));
                
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed
    int fetch = 5;
    int o = 0;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (txtSearch.getText().isEmpty()) {
            index--;
            rowoffset -= 5;
            if (rowoffset < 0) {
                int c = thongKeKhachHangService.getAllSoLanMuaKPT().size() % fetch;
                rowoffset = thongKeKhachHangService.getAllSoLanMuaKPT().size() - c;
                index = o;
            }
            listSoLanMua = thongKeKhachHangService.getAllSoLanMua(rowoffset);
            thongKeKhachHangService.showDataTableSoLan(dtmSoLan, listSoLanMua);
            
        } else {
            
            if (!txtSearch.getText().isEmpty()) {
                index--;
                rowoffset -= 5;
                if (rowoffset < 0) {
                    int c = listSearch.size() % fetch;
                    rowoffset = listSearch.size() - c;
                    index = o;
                    
                }
                
                thongKeKhachHangService.showDataTableSoLan(dtmSoLan, thongKeKhachHangService.searchTen(name, rowoffset));
                
            } else {
                index--;
                rowoffset -= 5;
                
                if (rowoffset < 0) {
                    int c = listSearch.size() % fetch;
                    rowoffset = listSearch.size() - c;
                    index = o;
                    
                }
                
                thongKeKhachHangService.showDataTableSoLan(dtmSoLan, thongKeKhachHangService.searchSoLanMua(soLan, rowoffset));
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbSoLanMua1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSoLanMua1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbSoLanMua1MouseClicked

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
            java.util.logging.Logger.getLogger(ThongKeKhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeKhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeKhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeKhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeKhachHangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbSoLanMua;
    private javax.swing.JTable tbSoLanMua1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
