/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModel.KhachHang;
import Service.KhachHangService;
import Service.ServiceImpl.KhachHangServiceImpl;
import ViewModel.KhachHangViewModel;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quan l
 */
public class KhachHangView extends javax.swing.JFrame {

    /**
     * Creates new form KhachHangView
     */
    private DefaultTableModel dtm = new DefaultTableModel();
    private List<KhachHang> listKhachHang = new ArrayList<>();
    private List<KhachHangViewModel> listKhachHangView = new ArrayList<>();
    private List<KhachHangViewModel> listSearch = new ArrayList<>();
    private KhachHangService service = new KhachHangServiceImpl();

    public KhachHangView() {
        initComponents();
        tbQuanLyKhachHang.setModel(dtm);
        String header[] = {"Ten", "Ngay sinh", "So dien thoai", "Dia chi", "Email"};
        dtm.setColumnIdentifiers(header);
        listKhachHangView = service.getAllKhachHang();
        service.showDataTable(dtm, listKhachHangView);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgGender = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbQuanLyKhachHang = new javax.swing.JTable();
        btAdd = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        txtValidateName = new javax.swing.JLabel();
        txtValidate2 = new javax.swing.JLabel();
        txtValidate4 = new javax.swing.JLabel();
        txtValidate3 = new javax.swing.JLabel();
        txtValidate5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("QUAN LY KHACH HANG");

        jLabel2.setText("Ngay sinh");

        jLabel3.setText("Tên");

        jLabel6.setText("So dien thoai");

        jLabel7.setText("Email");

        tbQuanLyKhachHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbQuanLyKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbQuanLyKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbQuanLyKhachHang);

        btAdd.setText("Them");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btEdit.setText("Sua");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btDelete.setText("Xoa");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        jLabel5.setText("Dia chi");

        jLabel4.setText("ID:");

        id.setText("jLabel8");

        txtValidate4.setText(" ");

        txtValidate3.setText(" ");

        txtValidate5.setText(" ");

        jLabel8.setText("Tim theo ten");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btAdd)
                        .addGap(49, 49, 49)
                        .addComponent(btEdit)
                        .addGap(52, 52, 52)
                        .addComponent(btDelete)
                        .addGap(162, 162, 162))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValidate5, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(134, 134, 134))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtValidateName, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtValidate2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValidate3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValidate4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(id))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(txtValidateName, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtValidate2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValidate3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(txtValidate4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValidate5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd)
                    .addComponent(btEdit)
                    .addComponent(btDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        KhachHang kh = new KhachHang();
        Boolean conf1 = false;
        Boolean conf2 = false;
        Boolean conf3 = false;
        Boolean conf4 = false;
        Boolean conf5 = false;
        if (txtTen.getText().isEmpty()) {
            txtValidateName.setText("Khong duoc bo trong ten");
            txtValidateName.setForeground(Color.red);
            txtTen.setBackground(Color.red);
        } else {
            txtValidateName.setText("OK");
            txtValidateName.setForeground(Color.GREEN);
            txtTen.setBackground(Color.GREEN);
            kh.setTen(txtTen.getText());
            conf1 = true;
        }
        if (txtDiaChi.getText().isEmpty()) {
            txtValidate4.setText("Khong duoc bo trong Dia chi");
            txtValidate4.setForeground(Color.red);
            txtDiaChi.setBackground(Color.RED);
        } else {
            txtValidate4.setText("OK");
            txtValidate4.setForeground(Color.GREEN);
            kh.setDiaChi(txtDiaChi.getText());
            txtDiaChi.setBackground(Color.GREEN);
            conf2 = true;
        }
        String validateEmail = txtEmail.getText();
        if (txtEmail.getText().isEmpty()) {
            txtValidate5.setText("Khong duoc bo trong email");
            txtValidate5.setForeground(Color.red);
            txtEmail.setBackground(Color.RED);
        } else if (!validateEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            txtValidate5.setText("Sai dinh dang email (example@gmail.com)");
            txtValidate5.setForeground(Color.red);
            txtEmail.setBackground(Color.RED);
        } else {
            txtValidate5.setText("OK");
            txtValidate5.setForeground(Color.GREEN);
            kh.setEmail(txtEmail.getText());
            txtEmail.setBackground(Color.GREEN);
            conf3 = true;
        }
        String validateNgay = txtNgaySinh.getText();
        if (txtNgaySinh.getText().isEmpty()) {
            txtValidate2.setText("Khong duoc bo trong ngay sinh");
            txtValidate2.setForeground(Color.red);
            txtNgaySinh.setBackground(Color.RED);
        } else if (!validateNgay.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")) {
            txtValidate2.setText("Sai dinh dang ngay(Nam-Thang-Ngay)");
            txtValidate2.setForeground(Color.red);
            txtNgaySinh.setBackground(Color.RED);
        } else {
            txtValidate2.setText("OK");
            txtValidate2.setForeground(Color.GREEN);
            String ngaySinhs = txtNgaySinh.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(ngaySinhs, formatter);
            java.sql.Date ngaySinh = java.sql.Date.valueOf(localDate);
            kh.setNgaySinh(ngaySinh);
            txtNgaySinh.setBackground(Color.GREEN);
            conf4 = true;

        }
        String vadidateSDT = txtSDT.getText();
        if (txtSDT.getText().isEmpty()) {
            txtValidate3.setText("Khong duoc bo trong So dien thoai");
            txtValidate3.setForeground(Color.red);
            txtSDT.setBackground(Color.RED);
        } else if (!vadidateSDT.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")) {
            txtValidate3.setText("Sai dinh dang so dien thoai");
            txtValidate3.setForeground(Color.red);
            txtSDT.setBackground(Color.RED);
        } else {
            txtValidate3.setText("OK");
            txtValidate3.setForeground(Color.GREEN);
            kh.setSdt(txtSDT.getText());
            txtSDT.setBackground(Color.GREEN);
            conf5 = true;
        }

        if (conf1 == true && conf2 == true && conf3 == true && conf4 == true && conf5 == true) {
            JOptionPane.showMessageDialog(rootPane, service.addKhachHang(kh));
            listKhachHangView = service.getAllKhachHang();
            service.showDataTable(dtm, listKhachHangView);
        }

    }//GEN-LAST:event_btAddActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        String ID = id.getText();
        JOptionPane.showMessageDialog(rootPane, service.deleteKhachHang(ID));
        listKhachHangView = service.getAllKhachHang();
        service.showDataTable(dtm, listKhachHangView);
    }//GEN-LAST:event_btDeleteActionPerformed


    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
        KhachHang kh = new KhachHang();
        String ID = id.getText();
        kh.setTen(txtTen.getText());
        kh.setDiaChi(txtDiaChi.getText());
        kh.setEmail(txtEmail.getText());
        String ngaySinhs = txtNgaySinh.getText();
        java.sql.Date date = java.sql.Date.valueOf(ngaySinhs);
        kh.setNgaySinh((date));
        kh.setSdt(txtSDT.getText());
        JOptionPane.showMessageDialog(rootPane, service.editKhachHang(kh, ID));
        listKhachHangView = service.getAllKhachHang();
        service.showDataTable(dtm, listKhachHangView);
    }//GEN-LAST:event_btEditActionPerformed

    private void tbQuanLyKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbQuanLyKhachHangMouseClicked
        // TODO add your handling code here:
        int row = tbQuanLyKhachHang.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_tbQuanLyKhachHangMouseClicked

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
//        String name = txtSearch.getText();
//
//        listSearch = service.searchKhachHang(name, listKhachHangView);
//        for (KhachHangViewModel khachHangViewModel : listSearch) {
//            System.out.println(khachHangViewModel.toString());
//
//        }
//        service.showDataTable(dtm, listSearch);
    }//GEN-LAST:event_txtSearchKeyTyped

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
//        String name = txtSearch.getText();
//
//        listSearch = service.searchKhachHang(name, listKhachHangView);
//        for (KhachHangViewModel khachHangViewModel : listSearch) {
//            System.out.println(khachHangViewModel.toString());
//
//        }
//        service.showDataTable(dtm, listSearch);
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
         String name = txtSearch.getText();

        listSearch = service.searchKhachHang(name, listKhachHangView);
        for (KhachHangViewModel khachHangViewModel : listSearch) {
            System.out.println(khachHangViewModel.toString());

        }
        service.showDataTable(dtm, listSearch);
    }//GEN-LAST:event_txtSearchKeyReleased

    /**
     * @param args the command line arguments
     */
    public void fillData(int index) {
        KhachHangViewModel kh = listKhachHangView.get(index);
        id.setText(kh.getId());
        txtDiaChi.setText(kh.getDiaChi());
        txtEmail.setText(kh.getEmail());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(kh.getNgaySinh());
        txtNgaySinh.setText(strDate);
        txtSDT.setText(kh.getSdt());
        txtTen.setText(kh.getTen());
    }

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
            java.util.logging.Logger.getLogger(KhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.ButtonGroup btgGender;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbQuanLyKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    private javax.swing.JLabel txtValidate2;
    private javax.swing.JLabel txtValidate3;
    private javax.swing.JLabel txtValidate4;
    private javax.swing.JLabel txtValidate5;
    private javax.swing.JLabel txtValidateName;
    // End of variables declaration//GEN-END:variables
}
