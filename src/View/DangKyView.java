/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModel.NhanVien;
import Service.LoginService;
import Service.ServiceImpl.LoginImpl;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author buiti
 */
public class DangKyView extends javax.swing.JFrame {
//    DefaultComboBoxModel modelccbCV;

    LoginService impl = new LoginImpl();
//    List<String> idCV = impl.IDChucVu();

    /**
     * Creates new form DangKyView
     */
    public DangKyView() {
        initComponents();
//           addCbb();
    }
//   public void addCbb(){
//       modelccbCV = (DefaultComboBoxModel) cbbCV.getModel();
//       modelccbCV.addAll(impl.ChucVuCBB());
//    
//   }

    public void DangKi() {
        NhanVien nv = new NhanVien();
        Boolean conf1 = false;
        Boolean conf2 = false;
        Boolean conf3 = false;
        Boolean conf4 = false;
        Boolean conf5 = false;
        Boolean conf6 = false;
        Boolean conf7 = false;
        if (txtMaNV.getText().isEmpty()) {
            txtRPMa.setText("Mã không được để Trống");
            txtRPMa.setForeground(Color.red);
            txtMaNV.setBackground(Color.yellow);
        } else if (txtMaNV.getText().matches("/^[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$/")) {
            txtRPMa.setText("Mã không được chứa kí tự đặc biệt");
            txtRPMa.setForeground(Color.red);
            txtMaNV.setBackground(Color.yellow);
        } else {
            txtRPMa.setText("*");
            txtMaNV.setBackground(Color.white);
            txtRPMa.setForeground(Color.green);
            nv.setMa(txtMaNV.getText());
            conf1 = true;
        }
        if (txtTenNV.getText().isEmpty()) {
            txtRPTen.setText("Tên không được để Trống");
            txtRPTen.setForeground(Color.red);
            txtTenNV.setBackground(Color.yellow);
       } else if (!txtTenNV.getText().matches("^[A-Z a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]{1,150}+$")) {
            txtRPTen.setText("Tên không được số hoặc kí tự");
            txtRPTen.setForeground(Color.red);
            txtTenNV.setBackground(Color.yellow);
        } else {
            txtRPTen.setText("*");
            txtTenNV.setBackground(Color.white);
            txtRPTen.setForeground(Color.green);
            nv.setTen(txtTenNV.getText());
            conf2 = true;
        }
        if (txtNgaySinhNV.getText().isEmpty()) {
            txtRPNgaySinh.setText("Ngày Sinh đang trống");
            txtRPNgaySinh.setForeground(Color.red);
            txtNgaySinhNV.setBackground(Color.yellow);
        } else if (!txtNgaySinhNV.getText().matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")) {
            txtRPNgaySinh.setText("Sai định dạng [Năm-Tháng-Ngày(yyyy-mm-dd)]");
            txtRPNgaySinh.setForeground(Color.red);
            txtNgaySinhNV.setBackground(Color.yellow);
        } else {
            txtRPNgaySinh.setText("*");
            txtNgaySinhNV.setBackground(Color.white);
            txtRPNgaySinh.setForeground(Color.green);
            nv.setNgaySinh(txtNgaySinhNV.getText());
            conf3 = true;

        }
if (txtDiaChiNV.getText().isEmpty()) {
            txtRPDiaChi.setText("Ngày sinh đang trống");
            txtRPDiaChi.setForeground(Color.red);
            txtDiaChiNV.setBackground(Color.yellow);
        } else {
            txtRPDiaChi.setText("*");
            txtRPDiaChi.setForeground(Color.GREEN);
            nv.setDiaChi(txtDiaChiNV.getText());
            conf4 = true;
        }

        String validateEmail = txtEmail.getText();
        if (txtEmail.getText().isEmpty()) {
            txtRPEmail.setText("Email đang trống");
            txtRPEmail.setForeground(Color.red);
            txtEmail.setBackground(Color.yellow);
        } else if (!validateEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            txtRPEmail.setText("Sai định dạng email (example@gmail.com)");
            txtRPEmail.setForeground(Color.red);
            txtEmail.setBackground(Color.yellow);
        } else {
            txtRPEmail.setText("*");
            txtEmail.setBackground(Color.white);
            txtRPEmail.setForeground(Color.GREEN);
            nv.setEmail(txtEmail.getText());
            conf5 = true;
        }
           String vadidateSDT = txtSDT.getText();
        if (txtSDT.getText().isEmpty()) {
            txtRPSDT.setText("Số điện thoại đang trống");
            txtRPSDT.setForeground(Color.red);
            txtSDT.setBackground(Color.yellow);
        } else if (!vadidateSDT.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")) {
            txtRPSDT.setText("Sai định dạng số điện thoại");
            txtRPSDT.setForeground(Color.red);
            txtSDT.setBackground(Color.yellow);
        } else {
            txtRPSDT.setText("*");
            txtRPSDT.setForeground(Color.GREEN);
            txtSDT.setBackground(Color.white);
            nv.setSdt(txtSDT.getText());
            conf6 = true;
        }
        if(txtPass.getText().isEmpty()){
            txtRPMatKhau.setText("Mật khậu đang trống");
            txtRPMatKhau.setForeground(Color.yellow);
            txtPass.setBackground(Color.yellow);
        }else {
            txtRPMatKhau.setText("*");
            txtRPMatKhau.setForeground(Color.GREEN);
            nv.setSdt(txtSDT.getText());
            txtPass.setBackground(Color.white);
            conf7 = true;
        }
//        nv.setEmail(txtEmail.getText());
//        nv.setDiaChi(txtDiaChiNV.getText());
//        nv.setSdt(txtSDT.getText());
//        nv.setIdChucVu(idCV.get(cbbCV.getSelectedIndex()));
//        nv.setMatKhau(txtPass.getText());

if (conf1 == true && conf2 == true && conf3 == true && conf4 == true && conf5 == true && conf6 == true && conf7 == true) {
            JOptionPane.showMessageDialog(rootPane, impl.dangKi(nv));
                    System.out.println(nv.toString());
        System.out.println(impl.dangKi(nv));
        }
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
        txtNgaySinhNV = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtDiaChiNV = new javax.swing.JTextField();
        btnDangKy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRPMa = new javax.swing.JLabel();
        txtRPTen = new javax.swing.JLabel();
        txtRPDiaChi = new javax.swing.JLabel();
        txtRPSDT = new javax.swing.JLabel();
        txtRPNgaySinh = new javax.swing.JLabel();
        txtRPEmail = new javax.swing.JLabel();
        txtRPMatKhau = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng ký");

        txtNgaySinhNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 255, 51), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 204, 0)));

        txtPass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 204, 0)));

        jLabel6.setText("Địa chỉ");

        txtMaNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 51, 0), new java.awt.Color(255, 204, 0), new java.awt.Color(255, 204, 0)));

        txtDiaChiNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 204, 0)));

        btnDangKy.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnDangKy.setText("Đăng kí");
        btnDangKy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 204, 0)));
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã nhân viên");

        jLabel7.setText("Số điện thoại");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Thoát chức năng đăng kí");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        jLabel2.setText("Đăng ký Nhân viên");

        txtSDT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 0, 0), null));

        jLabel3.setText("Tên nhân viên");

        txtTenNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 102, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 204, 0)));

        jLabel10.setText("Mật khẩu");

        jLabel5.setText("Ngày sinh");

        txtEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 153, 0)));

        jLabel4.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 96, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnDangKy, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtNgaySinhNV, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtDiaChiNV, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtRPMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRPTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRPDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRPSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRPEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRPMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtRPNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRPMa, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRPTen, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgaySinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRPNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(7, 7, 7)
                .addComponent(txtRPDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRPSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addComponent(txtRPEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRPMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel12)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        DangKi();   // TODO add your handling code here:
    }//GEN-LAST:event_btnDangKyActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        JOptionPane.showMessageDialog(this, "đã hủy đăng kí, cảm ơn bạn đã sử dụng dịch vụ");
        login bhv = new login();
        this.dispose();
        bhv.setVisible(true);

    }//GEN-LAST:event_jLabel12MouseClicked

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
            java.util.logging.Logger.getLogger(DangKyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKyView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinhNV;
    private javax.swing.JTextField txtPass;
    private javax.swing.JLabel txtRPDiaChi;
    private javax.swing.JLabel txtRPEmail;
    private javax.swing.JLabel txtRPMa;
    private javax.swing.JLabel txtRPMatKhau;
    private javax.swing.JLabel txtRPNgaySinh;
    private javax.swing.JLabel txtRPSDT;
    private javax.swing.JLabel txtRPTen;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
