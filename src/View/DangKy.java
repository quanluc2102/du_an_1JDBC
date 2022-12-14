/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModel.NhanVien;
import Service.LoginService;
import Service.NhanVienService;
import Service.ServiceImpl.LoginImpl;
import Service.ServiceImpl.NhanVienServiceImpl;
import ViewModel.checkTrungManv;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;

/**
 *
 * @author buiti
 */
public class DangKy extends javax.swing.JFrame {

    LoginService impl = new LoginImpl();
    NhanVienService implNV = new NhanVienServiceImpl();

    /**
     * Creates new form DangKy
     */
    public DangKy() {
        initComponents();
        txtMaNV.setBackground(new java.awt.Color(0, 0, 1, 0));
        txtDiaChiNV.setBackground(new java.awt.Color(0, 0, 1, 0));
        txtTenNV.setBackground(new java.awt.Color(0, 0, 1, 0));
        txtSDT.setBackground(new java.awt.Color(0, 0, 1, 0));
        txtPass.setBackground(new java.awt.Color(0, 0, 1, 0));
        txtEmail.setBackground(new java.awt.Color(0, 0, 1, 0));
        txtNgaySinhNV.setBackground(new java.awt.Color(0, 0, 1, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtNgaySinhNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDiaChiNV = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        txtRPMa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtRPNgaySinh = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtRPTen = new javax.swing.JLabel();
        txtRPEmail = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtRPSDT = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        hh = new javax.swing.JLabel();
        RPPass = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtRPDiaChi = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtAllCMND = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        txtRPCMND = new javax.swing.JLabel();
        Anh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign in");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 560, 80));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã nhân viên");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        txtMaNV.setForeground(new java.awt.Color(255, 255, 255));
        txtMaNV.setBorder(null);
        jPanel2.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 170, 30));

        txtNgaySinhNV.setForeground(new java.awt.Color(255, 255, 255));
        txtNgaySinhNV.setBorder(null);
        jPanel2.add(txtNgaySinhNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 140, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ngày sinh");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên Nhân Viên");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        txtTenNV.setForeground(new java.awt.Color(255, 255, 255));
        txtTenNV.setBorder(null);
        jPanel2.add(txtTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 170, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Địa chỉ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));

        txtDiaChiNV.setForeground(new java.awt.Color(255, 255, 255));
        txtDiaChiNV.setBorder(null);
        txtDiaChiNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiNVActionPerformed(evt);
            }
        });
        jPanel2.add(txtDiaChiNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 380, 30));

        Email.setForeground(new java.awt.Color(255, 255, 255));
        Email.setText("Email");
        jPanel2.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        txtRPMa.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtRPMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 170, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("_________________________________");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 170, 20));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("______________________________");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 140, -1));

        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(null);
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 140, 30));

        txtRPNgaySinh.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtRPNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 190, 20));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("__________________________");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 130, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("__________________________________");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 170, -1));

        txtRPTen.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtRPTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 170, 20));

        txtRPEmail.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtRPEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 140, 20));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SDT");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        txtSDT.setForeground(new java.awt.Color(255, 255, 255));
        txtSDT.setBorder(null);
        jPanel2.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 170, 30));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("__________________________________");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 170, -1));

        txtRPSDT.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtRPSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 170, 20));

        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setBorder(null);
        jPanel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 140, 30));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Mật khẩu");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 60, -1));

        hh.setForeground(new java.awt.Color(255, 255, 255));
        hh.setText("___________________________");
        jPanel2.add(hh, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 140, -1));

        RPPass.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(RPPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 140, 20));

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("____________________________________________________________________________");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 390, -1));

        txtRPDiaChi.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtRPDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 260, 20));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Thoát chức năng đăng kí");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 700, 312, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Thông tin căn cước");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 130, 30));
        jPanel1.add(txtAllCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 360, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 520, 50));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/z3946860666735_30f52c7f5e3d1a6b5fd11409bdce2492.jpg"))); // NOI18N
        jLabel22.setText("Get information QR");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 650, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Sign in");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 60));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 200, 60));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số CMND");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("________________________________________");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 200, -1));
        jPanel2.add(txtCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 200, -1));

        txtRPCMND.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtRPCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 100, 20));

        Anh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login1.jpg"))); // NOI18N
        jPanel2.add(Anh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 558, 760));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDiaChiNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiNVActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        JOptionPane.showMessageDialog(this, "đã hủy đăng kí, cảm ơn bạn đã sử dụng dịch vụ");
        LOGINview bhv = new LOGINview();
        this.dispose();
        bhv.setVisible(true);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        DangKi();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
            String cmnd = "";
//        int camera = cbbWebCam.getSelectedIndex();
        ScanCode sc = new ScanCode(new java.awt.Frame(), true, 0);
        sc.setVisible(true);
        cmnd = sc.getScanResutlx();
        txtAllCMND.setText(cmnd);
        String soCC = cmnd.substring(0,12);
        txtCMND.setText(soCC);
        String withouTen = cmnd.substring(14, cmnd.length());
        System.out.println(withouTen);
                     String[] splits = withouTen.split("[|]");
                     txtTenNV.setText(splits[0]);
                     txtDiaChiNV.setText(splits[3]);
//                     System.out.println(splits[1]);
                     String nam = splits[1].substring(4,8);
                     String ngay =splits[1].substring(0,2);
                     String thang =splits[1].substring(2,4);
                    String NS= (nam+"-"+thang+"-"+ngay);
                     txtNgaySinhNV.setText(NS);
                     txtPass.setText(UUID.randomUUID().toString().substring(0, 8));
                                 
    }//GEN-LAST:event_jLabel22MouseClicked
    public void DangKi() {
        NhanVien nv = new NhanVien();
        Boolean conf1 = false;
        Boolean conf2 = false;
        Boolean conf3 = false;
        Boolean conf4 = false;
        Boolean conf5 = false;
        Boolean conf6 = false;
        Boolean conf7 = false;
        Boolean conf8 = false;
           List<checkTrungManv> list = new ArrayList<>();
        implNV.checkTrungIMEI(txtMaNV.getText(), list);
        if (txtMaNV.getText().isEmpty()) {
            txtRPMa.setText("Mã không được để Trống");
            txtRPMa.setForeground(Color.red);
//            txtMaNV.setBackground(Color.yellow);
        } else if (txtMaNV.getText().matches("/^[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$/")) {
            txtRPMa.setText("Mã không được chứa kí tự đặc biệt");
            txtRPMa.setForeground(Color.red);
//            txtMaNV.setBackground(Color.yellow);
        } if(list.size()>0){
             JOptionPane.showMessageDialog(rootPane, "Mã nhân viên đã tồn tại");
        }else {
            txtRPMa.setText("*");
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

        } else {
            txtRPTen.setText("*");

            txtRPTen.setForeground(Color.green);
            nv.setTen(txtTenNV.getText());
            conf2 = true;
        }
        if (txtNgaySinhNV.getText().isEmpty()) {
            txtRPNgaySinh.setText("Ngày Sinh đang trống");
            txtRPNgaySinh.setForeground(Color.red);

        } else if (!txtNgaySinhNV.getText().matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")) {
            txtRPNgaySinh.setText("Sai định dạng [Năm-Tháng-Ngày(yyyy-mm-dd)]");
            txtRPNgaySinh.setForeground(Color.red);

        } else {
            txtRPNgaySinh.setText("*");
 
            txtRPNgaySinh.setForeground(Color.green);
            nv.setNgaySinh(txtNgaySinhNV.getText());
            conf3 = true;

        }
        if (txtDiaChiNV.getText().isEmpty()) {
            txtRPDiaChi.setText("Ngày sinh đang trống");
            txtRPDiaChi.setForeground(Color.red);

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

            nv.setSdt(txtSDT.getText());
            conf6 = true;
        }
        if (txtPass.getText().isEmpty()) {
            RPPass.setText("Mật khậu đang trống");
            RPPass.setForeground(Color.red);
//            txtPass.setBackground(Color.yellow);
        } else {
            RPPass.setText("*");
            RPPass.setForeground(Color.GREEN);
            nv.setMatKhau(txtPass.getText());

            conf7 = true;
        }
        if (txtCMND.getText().isEmpty()) {
            txtRPCMND.setText("CMND đang trống");
            txtRPCMND.setForeground(Color.red);
//            txtPass.setBackground(Color.yellow);
        } else {
            txtRPCMND.setText("*");
            txtRPCMND.setForeground(Color.GREEN);
            nv.setCmnd(txtCMND.getText());

            conf8 = true;
        }
//        nv.setEmail(txtEmail.getText());
//        nv.setDiaChi(txtDiaChiNV.getText());
//        nv.setSdt(txtSDT.getText());
//        nv.setIdChucVu(idCV.get(cbbCV.getSelectedIndex()));
//        nv.setMatKhau(txtPass.getText());

        if (conf1 == true && conf2 == true && conf3 == true && conf4 == true && conf5 == true && conf6 == true && conf7 == true && conf8) {
            JOptionPane.showMessageDialog(rootPane, impl.dangKi(nv));
            System.out.println(nv.toString());
        }
    }

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
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Anh;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel RPPass;
    private javax.swing.JLabel hh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtAllCMND;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinhNV;
    private javax.swing.JTextField txtPass;
    private javax.swing.JLabel txtRPCMND;
    private javax.swing.JLabel txtRPDiaChi;
    private javax.swing.JLabel txtRPEmail;
    private javax.swing.JLabel txtRPMa;
    private javax.swing.JLabel txtRPNgaySinh;
    private javax.swing.JLabel txtRPSDT;
    private javax.swing.JLabel txtRPTen;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
