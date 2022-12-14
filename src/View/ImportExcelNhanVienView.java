/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Ultilities.SQLServerConnection;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.PreparedStatement;
import java.sql.Connection;

/**
 *
 * @author quanl
 */
public class ImportExcelNhanVienView extends javax.swing.JFrame {

    /**
     * Creates new form ImportExcelKhachHangView
     */
    public ImportExcelNhanVienView() {
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
        tbExcel = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        tbExcel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma NV", "Ten", "Ngay sinh", "So dien thoai", "Email", "Dia chi", "Mat khau", "Trang thai", "CMND"
            }
        ));
        jScrollPane1.setViewportView(tbExcel);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/excel.png"))); // NOI18N
        jButton1.setText("Import Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save-regular-24.png"))); // NOI18N
        jButton2.setText("Save data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Quay lai");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jButton1)
                .addGap(5, 5, 5)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
DefaultTableModel dtm;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dtm = (DefaultTableModel) tbExcel.getModel();
        dtm.setRowCount(0);
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportWorkBook = null;
        String currentDirectoryPath = "E:\\FPOLY_K17\\FPOLY_K17";
        JFileChooser ejfc = new JFileChooser(currentDirectoryPath);
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Excel file", "xls", "xlsx", "xslm");
        ejfc.setFileFilter(extensionFilter);
        int excelchooser = ejfc.showOpenDialog(null);
        if (excelchooser == JFileChooser.APPROVE_OPTION) {
            try {
                File excelFile = ejfc.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImportWorkBook = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImportWorkBook.getSheetAt(0);
                for (int i = 1; i < excelSheet.getLastRowNum(); i++) {
                    XSSFRow excelRow = excelSheet.getRow(i);
                    XSSFCell maNV = excelRow.getCell(0);
                    XSSFCell ten = excelRow.getCell(1);
                    XSSFCell ngaySinh = excelRow.getCell(2);
                    XSSFCell SDT = excelRow.getCell(3);
                    XSSFCell email = excelRow.getCell(4);
                    XSSFCell diaChi = excelRow.getCell(5);
                    XSSFCell matKhau = excelRow.getCell(6);
                    XSSFCell trangThai = excelRow.getCell(7);
                    XSSFCell CMND = excelRow.getCell(8);

                    System.out.println();
                    dtm.addRow(new Object[]{maNV, ten, ngaySinh, SDT, email, diaChi, matKhau, trangThai, CMND});
                }
                JOptionPane.showMessageDialog(rootPane, "Import Excel thanh cong");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(ImportExcelNhanVienView.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int insertedRows = 0;
        int row = tbExcel.getRowCount();
        String query = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([ma_nhan_vien]\n"
                + "           ,[ten_nhan_vien]\n"
                + "           ,[ngay_sinh]\n"
                + "           ,[sdt]\n"
                + "           ,[email]\n"
                + "           ,[dia_chi]\n"
                + "           ,[mat_khau]\n"
                + "           ,[trang_thai]\n"
                + "           ,[cmnd])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        Connection con = SQLServerConnection.getConnection();
        for (int i = 0; i < row; i++) {
            String maNV = dtm.getValueAt(i, 0).toString();
            String ten = dtm.getValueAt(i, 1).toString();
            String ngaySinh = dtm.getValueAt(i, 2).toString();
            String SDT = dtm.getValueAt(i, 3).toString();
            String email = dtm.getValueAt(i, 4).toString();
            String diaChi = dtm.getValueAt(i, 5).toString();
            String matKhau = dtm.getValueAt(i, 6).toString();
            String trangThai = dtm.getValueAt(i, 7).toString();
            String CMND = dtm.getValueAt(i, 8).toString();
            try {
                ps = con.prepareStatement(query);
                ps.setString(1, maNV);
                ps.setString(2, ten);
                ps.setString(3, ngaySinh);
                ps.setString(4, SDT);
                ps.setString(5, email);
                ps.setString(6, diaChi);
                ps.setString(7, matKhau);
                ps.setInt(8, Integer.valueOf(trangThai));
                ps.setString(9, CMND);
                int result = ps.executeUpdate();
                if (result > 0) {
                    insertedRows++;

                }

            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        JOptionPane.showMessageDialog(null, " Du lieu da duoc them");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ImportExcelNhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportExcelNhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportExcelNhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportExcelNhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportExcelNhanVienView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbExcel;
    // End of variables declaration//GEN-END:variables
}
