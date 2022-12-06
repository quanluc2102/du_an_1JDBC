/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModel.HoaDon;
import Service.ServiceImpl.ThongKeServiceImpl;
import ViewModel.ThongKeViewModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class ThongKeView extends javax.swing.JFrame {

    /**
     * Creates new form ThongKeViewModel
     */
    private DefaultTableModel dtm = new DefaultTableModel();
    private List<ThongKeViewModel> listhongKe = new ArrayList<>();
    private ThongKeServiceImpl thongKeImpl = new ThongKeServiceImpl();
    private List<HoaDon> listHoaDon = new ArrayList<>();
//    private DefaultComboBoxModel dcdc;

    public ThongKeView() {
        initComponents();
        this.setLocationRelativeTo(null);

        TableThongKe.setModel(dtm);
        String[] heards = {"IMEI", "Mã HD", "Giá Bán", "Ngày tạo", "Giảm giá", "Giá nhập", "Thành tiền ", "Lãi"};
        dtm.setColumnIdentifiers(heards);
        listhongKe = thongKeImpl.getLisst();
        thongKeImpl.showDaTa(dtm, listhongKe);
        DecimalFormat df = new DecimalFormat("###,###,###,###");
        ThanhTien(listhongKe);
        txtDoanhThu.setText(df.format(ThanhTien(listhongKe)) + " " + "VNĐ");

        cbbNgay.removeAllItems();

        for (int i = 1; i <= 31; i++) {
            cbbNgay.addItem(i + "");

        }
        cbbThang.removeAllItems();
        for (int i = 1; i <= 12; i++) {
            cbbThang.addItem(i + "");
        }
        Calendar instance = Calendar.getInstance();
        cbbNam.removeAllItems();
        int year = instance.get(Calendar.YEAR);
        for (int i = 2000; i <= year; i++) {
            cbbNam.addItem(i + "");
        }


    }

    private double ThanhTien(List<ThongKeViewModel> x) {
        double tien = 0;
        for (ThongKeViewModel object : x) {// chạy list thống kê 
            tien += object.getGiaBan() - object.getGiaGiam() - object.getGiaNhap();
        }
        return tien;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableThongKe = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabelTong = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtDaonhThu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLaiThang = new javax.swing.JLabel();
        txtDoanhThu = new javax.swing.JLabel();
        cbbNgay = new javax.swing.JComboBox<>();
        cbbThang = new javax.swing.JComboBox<>();
        cbbNam = new javax.swing.JComboBox<>();
        cbbNTN = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNTNam = new javax.swing.JLabel();
        txtThang = new javax.swing.JLabel();
        btnDong = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jRadioButton2.setText("jRadioButton2");

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel15.setText("Tìm kiếm ");

        TableThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        TableThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableThongKeMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TableThongKe);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("THỐNG KÊ DOANH THU");

        jLabelTong.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelTong.setText("Tổng doanh thu:");
        jLabelTong.setToolTipText("");

        txtDaonhThu.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        txtDaonhThu.setText("Doanh Thu Theo ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText(":");

        txtLaiThang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtLaiThang.setForeground(new java.awt.Color(255, 0, 0));

        txtDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDoanhThu.setForeground(new java.awt.Color(255, 0, 0));

        cbbNgay.setBackground(new java.awt.Color(255, 153, 0));
        cbbNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày" }));
        cbbNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNgayActionPerformed(evt);
            }
        });

        cbbThang.setBackground(new java.awt.Color(255, 153, 0));
        cbbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng" }));

        cbbNam.setBackground(new java.awt.Color(255, 153, 0));
        cbbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Năm" }));
        cbbNam.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbbNam.setDoubleBuffered(true);

        cbbNTN.setBackground(new java.awt.Color(255, 153, 0));
        cbbNTN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng", "Năm" }));
        cbbNTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNTNActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tìm kiếm theo");

        txtNTNam.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N

        txtThang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        btnDong.setText("Đóng ");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        jLabel2.setText("Theo ngày ");

        jLabel3.setText("Theo tháng ");

        jLabel6.setText("Theo năm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabelTong, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2)
                                .addGap(117, 117, 117))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(292, 292, 292)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbNTN, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(187, 187, 187))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(523, 523, 523))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(82, 82, 82)
                                                .addComponent(jLabel6)))
                                        .addGap(140, 140, 140)
                                        .addComponent(jLabel5)
                                        .addGap(187, 187, 187)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(txtDaonhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNTNam, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLaiThang, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDong)
                .addGap(200, 200, 200))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbNTN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtNTNam, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDaonhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtLaiThang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTong)
                    .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(btnDong)
                .addGap(22, 22, 22))
        );

        jTabbedPane2.addTab("Doanh Thu", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 787, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void cbbNTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNTNActionPerformed
        // TODO add your handling code here:
        List<ThongKeViewModel> thongKe = new ArrayList<>();
        String ngay = cbbNgay.getSelectedItem() + "";
        String thang = cbbThang.getSelectedItem() + "";
        String nam = cbbNam.getSelectedItem() + "";
        String ntn = ngay + "-" + thang + "-" + nam;
        thongKe = thongKeImpl.searchNgayThangNam(ntn, listhongKe);
        if (cbbNTN.getSelectedItem().equals("Tháng")) {
            thongKe = thongKeImpl.searchThang(cbbThang.getSelectedItem() + "", listhongKe);
            txtNTNam.setText("Tháng");
            txtThang.setText(thang);
        } else if (cbbNTN.getSelectedItem().equals("Năm")) {

            thongKe = thongKeImpl.searchNam(cbbNam.getSelectedItem() + "", listhongKe);

            txtNTNam.setText("Năm");
            txtThang.setText(nam);
        } else if (cbbNTN.getSelectedItem().equals("Ngày")) {
            thongKe = thongKeImpl.searchNgay(cbbNgay.getSelectedItem() + "", listhongKe);
            txtNTNam.setText("Ngày");
            txtThang.setText(ngay);

            thongKeImpl.showDaTa(dtm, thongKe);
        } else ;

        DecimalFormat df = new DecimalFormat("###,###,###,###");

        txtLaiThang.setText(df.format(ThanhTien(thongKe)) + " " + "VNĐ");

        thongKeImpl.showDaTa(dtm, thongKe);
    }//GEN-LAST:event_cbbNTNActionPerformed

    private void cbbNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNgayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNgayActionPerformed

    private void TableThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableThongKeMouseClicked
       
    }//GEN-LAST:event_TableThongKeMouseClicked

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
            java.util.logging.Logger.getLogger(ThongKeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableThongKe;
    private javax.swing.JButton btnDong;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbNTN;
    private javax.swing.JComboBox<String> cbbNam;
    private javax.swing.JComboBox<String> cbbNgay;
    private javax.swing.JComboBox<String> cbbThang;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelTong;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel txtDaonhThu;
    private javax.swing.JLabel txtDoanhThu;
    private javax.swing.JLabel txtLaiThang;
    private javax.swing.JLabel txtNTNam;
    private javax.swing.JLabel txtThang;
    // End of variables declaration//GEN-END:variables

//    private void tong() {
//        DecimalFormat x = new DecimalFormat("###,###,###");
//        double Tong = 0;
//        for (int i = 0; i < TableThongKe.getRowCount(); i++) {
//            Tong += Double.parseDouble(TableThongKe.getValueAt(i, 2).toString());
////              Tong+= Integer.parseInt(TableThongKe.getValueAt(i,2).toString());
//
//        }
//        jLabelTong.setText("Tổng doanh thu: " + x.format(Tong) + " " + "VND");
//    }
}
