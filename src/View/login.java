/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModel.NhanVien;
import Service.LoginService;
import Service.ServiceImpl.LoginImpl;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author haha
 */
public class login extends javax.swing.JFrame {

//    LoginAndSinginImpl loginx = new LoginAndSinginImpl();
    /**
     * Creates new form login
     */
    LoginService impl = new LoginImpl();

    public login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRPID1 = new javax.swing.JLabel();
        txtRPPAss = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));
        setLocation(new java.awt.Point(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("           Đăng ký");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 210, -1));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("Login");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 77));

        txtID.setBackground(null);
        txtID.setFont(txtID.getFont());
        txtID.setForeground(new java.awt.Color(204, 204, 204));
        txtID.setToolTipText("Use name");
        txtID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 204), new java.awt.Color(153, 0, 255), new java.awt.Color(255, 204, 0), null));
        txtID.setOpaque(true);
        txtID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDFocusLost(evt);
            }
        });
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 119, 248, 35));

        txtPass.setToolTipText("Nhập PassWord");
        txtPass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 0), new java.awt.Color(51, 51, 255), null, null));
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassFocusLost(evt);
            }
        });
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        jPanel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 211, 248, 35));
        txtPass.getAccessibleContext().setAccessibleName("");
        txtPass.getAccessibleContext().setAccessibleDescription("Nhập Password");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User name");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 97, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 183, -1, -1));
        jPanel2.add(txtRPID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 160, 120, 17));
        jPanel2.add(txtRPPAss, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 252, 86, 17));

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel3.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("           Đăng Nhập");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 320, 480));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login1.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 360, 510));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("BEEPHONE");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 651, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login1.jpg"))); // NOI18N
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusLost
        // TODO add your handling code here:
//        if (txtID.getText().isBlank()) {
//            txtID.setText("User name");
//            txtID.setForeground(Color.gray);
//        }


    }//GEN-LAST:event_txtIDFocusLost

    private void txtPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusLost
        // TODO add your handling code here:
//        if (txtPass.getText().isBlank()) {
//            txtPass.setText("Password");
//            txtPass.setForeground(Color.gray);
//        }
    }//GEN-LAST:event_txtPassFocusLost

    private void txtIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusGained
        txtID.setText("");
        txtID.setForeground(Color.black);

    }//GEN-LAST:event_txtIDFocusGained

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
        txtPass.setText("");
        txtPass.setForeground(Color.black);    }//GEN-LAST:event_txtPassFocusGained

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
      DangKyView bhv = new DangKyView();
        this.dispose();
        bhv.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked
//    DangKyView bhv = new DangKyView();
//        this.dispose();
//        bhv.setVisible(true);
// NhanVien nv = new NhanVien();
//        String userID = txtID.getText();
//        String userPass = txtPass.getText();
//        String thongBao = impl.login(userID, userPass);
//        Boolean conf1 = false;
//        Boolean conf2 = false;
//        if (txtID.getText().isEmpty()) {
//            txtRPID1.setText("Đang trống");
//            txtRPID1.setForeground(Color.red);
//
//        } else {
//            conf1 = true;
//        }
//        if (txtPass.getText().isEmpty()) {
//            txtRPPAss.setText("Đang trống");
//            txtRPPAss.setForeground(Color.red);
//
//        } else {
//            conf2 = true;
//        }
//        if (conf2 == true && conf1 == true) {
//               System.out.println(thongBao);
//        if (thongBao.contains("NOT")) {
//            JOptionPane.showMessageDialog(this, "tai khoan hoac mat khau khong dung");
//        } else {
//            if (thongBao.contains("NV")) {
//                TrangChuNhanVienView nvv = new TrangChuNhanVienView(this, true);
//                nvv.setVisible(true);
//            }
//            if (thongBao.contains("QL")) {
//                TrangChuQuanLyView ql = new TrangChuQuanLyView(txtID.getText());
//                ql.setVisible(true);
//            }
//            this.dispose();
//        } 
//        }
//        
    
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
         NhanVien nv = new NhanVien();
        String userID = txtID.getText();
        String userPass = txtPass.getText();
        String thongBao = impl.login(userID, userPass);
        Boolean conf1 = false;
        Boolean conf2 = false;
        if (txtID.getText().isEmpty()) {
            txtRPID1.setText("Đang trống");
            txtRPID1.setForeground(Color.red);

        } else {
            conf1 = true;
        }
        if (txtPass.getText().isEmpty()) {
            txtRPPAss.setText("Đang trống");
            txtRPPAss.setForeground(Color.red);

        } else {
            conf2 = true;
        }
        if (conf2 == true && conf1 == true) {
               System.out.println(thongBao);
        if (thongBao.contains("NOT")) {
            JOptionPane.showMessageDialog(this, "tai khoan hoac mat khau khong dung");
        } else {
            if (thongBao.contains("NV")) {
//                TrangChuNhanVienView nvv = new TrangChuNhanVienView(this, true);
TrangChuNhanVienView nvv = new TrangChuNhanVienView();
                nvv.setVisible(true);
            }
            if (thongBao.contains("QL")) {
                TrangChuQuanLyView ql = new TrangChuQuanLyView(txtID.getText());
                ql.setVisible(true);
            }
            this.dispose();
        } 
        }
        
    
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ScanCode sc = new ScanCode(new javax.swing.JFrame(), true, 1);
            sc.setVisible(true);
           String x = sc.login().substring(0,12);
           if ( impl.loginWebCam(x)) {
             TrangChuQuanLyView ql = new TrangChuQuanLyView(txtID.getText());
                ql.setVisible(true);
        } else {
               JOptionPane.showConfirmDialog(rootPane,"Sai");
        }
         
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField txtID;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JLabel txtRPID1;
    private javax.swing.JLabel txtRPPAss;
    // End of variables declaration//GEN-END:variables
}
