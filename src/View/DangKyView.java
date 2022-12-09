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
                txtMaNV.setBackground(new java.awt.Color(0,0,1,0));
        txtPass.setBackground(new java.awt.Color(0,0,1,0));
         txtDiaChiNV.setBackground(new java.awt.Color(0,0,1,0));
        txtEmail.setBackground(new java.awt.Color(0,0,1,0));
         txtTenNV.setBackground(new java.awt.Color(0,0,1,0));
        txtSDT.setBackground(new java.awt.Color(0,0,1,0));
          txtNgaySinhNV.setBackground(new java.awt.Color(0,0,1,0));
          

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
//            txtMaNV.setBackground(Color.yellow);
        } else if (txtMaNV.getText().matches("/^[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$/")) {
            txtRPMa.setText("Mã không được chứa kí tự đặc biệt");
            txtRPMa.setForeground(Color.red);
//            txtMaNV.setBackground(Color.yellow);
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
//            txtTenNV.setBackground(Color.yellow);
       } else if (!txtTenNV.getText().matches("^[A-Z a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]{1,150}+$")) {
            txtRPTen.setText("Tên không được số hoặc kí tự");
            txtRPTen.setForeground(Color.red);
//            txtTenNV.setBackground(Color.yellow);
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
//            txtNgaySinhNV.setBackground(Color.yellow);
        } else if (!txtNgaySinhNV.getText().matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")) {
            txtRPNgaySinh.setText("Sai định dạng [Năm-Tháng-Ngày(yyyy-mm-dd)]");
            txtRPNgaySinh.setForeground(Color.red);
//            txtNgaySinhNV.setBackground(Color.yellow);
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
//            txtDiaChiNV.setBackground(Color.yellow);
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
//            txtEmail.setBackground(Color.yellow);
        } else if (!validateEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            txtRPEmail.setText("Sai định dạng email (example@gmail.com)");
            txtRPEmail.setForeground(Color.red);
//            txtEmail.setBackground(Color.yellow);
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
//            txtSDT.setBackground(Color.yellow);
        } else if (!vadidateSDT.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")) {
            txtRPSDT.setText("Sai định dạng số điện thoại");
            txtRPSDT.setForeground(Color.red);
//            txtSDT.setBackground(Color.yellow);
        } else {
            txtRPSDT.setText("*");
            txtRPSDT.setForeground(Color.GREEN);
            txtSDT.setBackground(Color.white);
            nv.setSdt(txtSDT.getText());
            conf6 = true;
        }
        if(txtPass.getText().isEmpty()){
            txtRPMatKhau.setText("Mật khậu đang trống");
            txtRPMatKhau.setForeground(Color.red);
//            txtPass.setBackground(Color.yellow);
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
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtRPNgaySinh = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtRPEmail = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtPass1 = new javax.swing.JTextField();
        txtRPMatKhau = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        txtNgaySinhNV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng ký");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Địa chỉ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 37, -1));

        txtMaNV.setBorder(null);
        getContentPane().add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 210, 30));

        txtDiaChiNV.setBackground(new java.awt.Color(204, 204, 204));
        txtDiaChiNV.setBorder(null);
        getContentPane().add(txtDiaChiNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 210, 30));

        btnDangKy.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnDangKy.setText("Đăng kí");
        btnDangKy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 204, 0)));
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 640, 210, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Mã nhân viên");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 74, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Số điện thoại");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 74, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Thoát chức năng đăng kí");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 710, 312, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sign in");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 370, 60));

        txtSDT.setBackground(new java.awt.Color(204, 204, 204));
        txtSDT.setBorder(null);
        getContentPane().add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 210, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tên nhân viên");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        txtTenNV.setBackground(new java.awt.Color(153, 153, 153));
        txtTenNV.setBorder(null);
        getContentPane().add(txtTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 210, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Số CMND");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, 63, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Ngày sinh");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 74, -1));

        txtEmail.setBackground(new java.awt.Color(204, 204, 204));
        txtEmail.setBorder(null);
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 210, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));
        getContentPane().add(txtRPMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 210, 14));
        getContentPane().add(txtRPTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 210, 14));
        getContentPane().add(txtRPDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 210, 14));
        getContentPane().add(txtRPSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 210, 14));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Mật khẩu");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 63, -1));

        jLabel13.setText("________________________________________");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 210, -1));

        jLabel14.setText("________________________________________");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 210, -1));
        getContentPane().add(txtRPNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 210, 16));

        jLabel17.setText("________________________________________");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 210, -1));

        jLabel16.setText("________________________________________");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 210, -1));

        jLabel18.setText("________________________________________");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 210, -1));
        getContentPane().add(txtRPEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 210, 14));

        jLabel20.setText("________________________________________");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 210, -1));

        jLabel19.setText("________________________________________");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 210, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("________________________________________");

        txtPass1.setBackground(new java.awt.Color(102, 102, 102));
        txtPass1.setBorder(null);

        txtPass.setBackground(new java.awt.Color(204, 204, 204));
        txtPass.setBorder(null);

        txtNgaySinhNV.setBackground(new java.awt.Color(204, 204, 204));
        txtNgaySinhNV.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgaySinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRPMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabel9)
                .addGap(26, 26, 26)
                .addComponent(txtNgaySinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRPMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 520, 770));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login1.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, 570, 880));

        jLabel15.setText("________________________________________");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 240, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        DangKi();   // TODO add your handling code here:
    }//GEN-LAST:event_btnDangKyActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        JOptionPane.showMessageDialog(this, "đã hủy đăng kí, cảm ơn bạn đã sử dụng dịch vụ");
        LOGINview bhv = new LOGINview();
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinhNV;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtPass1;
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
