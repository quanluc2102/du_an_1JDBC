/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.SanPham;

import DomainModel.Dong;
import Service.ServiceImpl.TSPImpl;
import Service.ThemSPServices;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haha
 */
public class DongView extends javax.swing.JDialog {

    ThemSPServices tsp = new TSPImpl();
    DefaultTableModel modelTBL;
    DefaultTableModel modelTBL1;
    int index = -1;
    int trangThai = 0;
    List<Dong> ls = new ArrayList<>();
    String idxc = "";
    Dong dong = new Dong();

    /**
     * Creates new form CameraView
     */
    public DongView(java.awt.Frame parent, boolean modal, String id) {
        super(parent, modal);
        initComponents();
        idxc = id;
        modelTBL = (DefaultTableModel) tbl1.getModel();
        modelTBL1 = (DefaultTableModel) tbl2.getModel();
        fillTable(tsp.getDong(1, idxc), modelTBL);
        ls = tsp.getDong(1, idxc);
        fillTable(tsp.getDong(0, idxc), modelTBL1);
    }

    private void fillTable(List<Dong> qg, DefaultTableModel md) {
        md.setRowCount(0);
        for (Dong quocGia : qg) {
            Object[] row = new Object[]{quocGia.getMa(), quocGia.getTen()};
            md.addRow(row);
        }

    }

    public Dong returnDong() {
        return dong;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaDong = new javax.swing.JTextField();
        txtTenDong = new javax.swing.JTextField();
        cbbDong = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnChon = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dòng");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Tên Dòng");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 57, 69, -1));

        jLabel1.setText("Mã dòng");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 28, -1, -1));

        txtMaDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDongActionPerformed(evt);
            }
        });
        jPanel1.add(txtMaDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 25, 171, -1));
        jPanel1.add(txtTenDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 54, 173, -1));

        cbbDong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không có", "Đang có" }));
        jPanel1.add(cbbDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 83, 173, -1));

        jLabel3.setText("Trạng thái");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 86, -1, -1));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 40));

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 76, 40));

        btnChon.setText("Chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });
        jPanel1.add(btnChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 75, 40));

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã dòng", "Tên dòng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Đang có", jPanel2);

        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã dòng", "Tên dòng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Đã xóa", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDongActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked

        index = tbl1.getSelectedRow();
        Dong qg = ls.get(index);
        txtMaDong.setText(qg.getTen());
        txtTenDong.setText(qg.getMa());
        cbbDong.setSelectedIndex(qg.getTrangThai());
        dong = qg;

    }//GEN-LAST:event_tbl1MouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String ten = txtMaDong.getText();
        String ma = txtTenDong.getText();
        if (ten.isBlank() || ma.isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống thông tin");
        }
        Dong quocGia = new Dong("", ma, ten, idxc, cbbDong.getSelectedIndex());
        JOptionPane.showMessageDialog(rootPane, tsp.themDong(quocGia));
        fillTable(tsp.getDong(1, idxc), modelTBL);
        fillTable(tsp.getDong(0, idxc), modelTBL1);
    }//GEN-LAST:event_btnThemActionPerformed

    private void tbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl2MouseClicked
        index = tbl2.getSelectedRow();
        Dong qg = tsp.getDong(0, idxc).get(index);
        txtMaDong.setText(qg.getTen());
        txtTenDong.setText(qg.getMa());
        dong = qg;
        cbbDong.setSelectedIndex(qg.getTrangThai());
    }//GEN-LAST:event_tbl2MouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if (trangThai == 1) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }

    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        String ten = txtMaDong.getText();
        String ma = txtTenDong.getText();
        String id = "";
        if (trangThai == 1) {
            id = tsp.getDong(1, idxc).get(index).getId();
        } else {
            id = tsp.getDong(0, idxc).get(index).getId();
        }
        if (ten.isBlank() || ma.isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống thông tin");
        }
        Dong quocGia = new Dong(id, ma, ten, idxc, cbbDong.getSelectedIndex());
        JOptionPane.showMessageDialog(rootPane, tsp.suaDong(quocGia));
        fillTable(tsp.getDong(1, idxc), modelTBL);
        fillTable(tsp.getDong(0, idxc), modelTBL1);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        idxc = txtMaDong.getText();
        this.dispose();
    }//GEN-LAST:event_btnChonActionPerformed

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
            java.util.logging.Logger.getLogger(DongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DongView dialog = new DongView(new javax.swing.JFrame(), true, "16af3df1-548f-4ef4-8c0a-8a76f77aed4d");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbbDong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl1;
    private javax.swing.JTable tbl2;
    private javax.swing.JTextField txtMaDong;
    private javax.swing.JTextField txtTenDong;
    // End of variables declaration//GEN-END:variables
}
