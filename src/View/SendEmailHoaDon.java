/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Service.ServiceImpl.Email;
import java.awt.Color;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class SendEmailHoaDon extends javax.swing.JFrame {

    String file = "";
    String userName = "";
    String passWord = "";
    String nguoiNhan = "";
    String message = "";

    public SendEmailHoaDon() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNoiDung = new javax.swing.JTextArea();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtNguoiNhan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnChonFile = new javax.swing.JButton();
        btnGuiEmail = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        tbTaiKhoan = new javax.swing.JLabel();
        tbMatKhau = new javax.swing.JLabel();
        tbEmailNguoiNhan = new javax.swing.JLabel();
        txtFile = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tài khoản:");

        jLabel2.setText("Mật khẩu:");

        jLabel3.setText("Nội dung:");

        txtNoiDung.setColumns(20);
        txtNoiDung.setRows(5);
        jScrollPane1.setViewportView(txtNoiDung);

        jLabel4.setText("Email người nhận:");

        jLabel5.setText("Chọn File:");

        btnChonFile.setText("Chọn File");
        btnChonFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonFileActionPerformed(evt);
            }
        });

        btnGuiEmail.setText("Gửi Email");
        btnGuiEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiEmailActionPerformed(evt);
            }
        });

        btnQuayLai.setText("Quay Lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(128, 128, 128)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                    .addGap(12, 12, 12))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(13, 13, 13)))
                            .addGap(51, 51, 51)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                    .addComponent(txtMatKhau))
                                .addComponent(txtNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbTaiKhoan)
                                .addComponent(tbMatKhau)
                                .addComponent(tbEmailNguoiNhan)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(128, 128, 128)
                            .addComponent(btnChonFile)
                            .addGap(18, 18, 18)
                            .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnGuiEmail)
                        .addGap(172, 172, 172)
                        .addComponent(btnQuayLai)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbTaiKhoan)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbMatKhau)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbEmailNguoiNhan)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChonFile)
                    .addComponent(jLabel5)
                    .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuiEmail)
                    .addComponent(btnQuayLai))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
        ViewHoaDon view = new ViewHoaDon();
        this.dispose();
        view.setVisible(true);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btnChonFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonFileActionPerformed
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select File");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }

        txtFile.setText(chooser.getSelectedFile() + "");

        file = chooser.getSelectedFile() + "";

    }//GEN-LAST:event_btnChonFileActionPerformed

    private void btnGuiEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiEmailActionPerformed
        // TODO add your handling code here:

        boolean a1 = false;
        boolean a2 = false;
        boolean a3 = false;

        userName = txtTaiKhoan.getText();
        if (txtTaiKhoan.getText().isEmpty()) {
            tbTaiKhoan.setText("Email nguoi gui dang trong");
            tbTaiKhoan.setForeground(Color.red);
        } else if (!userName.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            tbTaiKhoan.setText("Sai dinh dang email");
            tbTaiKhoan.setForeground(Color.red);
        } else {
            tbTaiKhoan.setText("*");
            tbTaiKhoan.setForeground(Color.green);
            a1 = true;
        }

        passWord = txtMatKhau.getText();
        if (txtMatKhau.getText().isEmpty()) {
            tbMatKhau.setText("Mat khau nguoi gui dang trong");
            tbMatKhau.setForeground(Color.red);
        } else if (passWord.matches("/^[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$/")) {
            tbMatKhau.setText("Mat khau khong duoc chua ki tu dac biet");
            tbMatKhau.setForeground(Color.red);
        } else {
            tbMatKhau.setText("*");
            tbMatKhau.setForeground(Color.green);
            a2 = true;
        }

        nguoiNhan = txtNguoiNhan.getText();
        if (txtNguoiNhan.getText().isEmpty()) {
            tbEmailNguoiNhan.setText("Email nguoi nhan dang trong");
            tbEmailNguoiNhan.setForeground(Color.red);
        } else if (!nguoiNhan.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            tbEmailNguoiNhan.setText("Sai dinh dang email");
            tbEmailNguoiNhan.setForeground(Color.red);
        } else {
            tbEmailNguoiNhan.setText("*");
            tbEmailNguoiNhan.setForeground(Color.green);
            a3 = true;
        }

        message = txtNoiDung.getText();

        if (a1 == true && a2 == true && a3 == true) {
            File filePatch = new File(file);
            new Email().sendEmail(userName, passWord, nguoiNhan, "Hóa Đơn Điện Tử", message, filePatch);
        }

    }//GEN-LAST:event_btnGuiEmailActionPerformed

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
            java.util.logging.Logger.getLogger(SendEmailHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendEmailHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendEmailHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendEmailHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendEmailHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonFile;
    private javax.swing.JButton btnGuiEmail;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tbEmailNguoiNhan;
    private javax.swing.JLabel tbMatKhau;
    private javax.swing.JLabel tbTaiKhoan;
    private javax.swing.JTextField txtFile;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtNguoiNhan;
    private javax.swing.JTextArea txtNoiDung;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
