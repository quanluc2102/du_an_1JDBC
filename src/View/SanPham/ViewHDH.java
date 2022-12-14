/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.SanPham;

import DomainModel.HeDieuHanh;
import Service.SanPhamServices;
import Service.ServiceImpl.SanPhamServicesImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author haha
 */
public class ViewHDH extends javax.swing.JDialog {

    DefaultTableModel tbla;
    DefaultTableModel tblb;
    int index = 0;
    HeDieuHanh heDieuHanh = null;
    SanPhamServices sps = new SanPhamServicesImpl();
    DefaultComboBoxModel modelcbb;
    List<String> lsTrangThai = new ArrayList<>();
    int trang = 1;

    /**
     * Creates new form HeDieuHanh
     */
    public ViewHDH(java.awt.Frame parent, boolean modal, String id) {
        super(parent, modal);
        initComponents();
        ImageIcon icon = new ImageIcon("src\\image\\hdh_icon.png");
        this.setIconImage(icon.getImage());

        loadx();
        loadDataToTable(sps.getHDH(1), tbla);
        loadDataToTable(sps.getHDH(0), tblb);
        cbbTrangThai.setSelectedIndex(0);
        sapXep();

    }

    private void sapXep() {// gọi trong hàm khởi tạo
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tbla); // tbla là defautablemodel của bảng mình muốn sắp xếp
        tbl1.setRowSorter(sorter);
        TableRowSorter<DefaultTableModel> sorter2 = new TableRowSorter<>(tblb); // tbla là defautablemodel của bảng mình muốn sắp xếp
        tbl2.setRowSorter(sorter2);
    }

    public HeDieuHanh returnHeDieuHanh() {
        return heDieuHanh;
    }

    private void loadx() {

        tblb = (DefaultTableModel) tbl2.getModel();
        tbla = (DefaultTableModel) tbl1.getModel();
        String[] title = {"Tên hệ điều hành", "phiên bản"};
        tbla.setColumnIdentifiers(title);
        tblb.setColumnIdentifiers(title);

        modelcbb = (DefaultComboBoxModel) cbbTrangThai.getModel();
        modelcbb.removeAllElements();
        lsTrangThai.add("Đã xóa");
        lsTrangThai.add("Còn");
        modelcbb.addAll(lsTrangThai);

    }

    private void loadDataToTable(List<HeDieuHanh> h, DefaultTableModel tbl) {
        tbl.setRowCount(0);
        for (HeDieuHanh x : h) {
            Object[] row = new Object[]{x.getTenHDH(), x.getPhienBan()};
            tbl.addRow(row);
        }
    }

    private HeDieuHanh add(String id) {

        String ram = txtRAM.getText();
        String rom = txtROM.getText();
        if (ram.isBlank() || rom.isBlank()) {
            return null;
        }

        int trangThai = cbbTrangThai.getSelectedIndex();
        HeDieuHanh nbn = new HeDieuHanh(id, ram, rom, trangThai);
        return nbn;
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
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtRAM = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtROM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        btnChon = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hệ điều hành");
        setIconImages(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save-regular-24.png"))); // NOI18N
        btnThem.setOpaque(false);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit-alt-regular-24.png"))); // NOI18N
        btnSua.setOpaque(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel1.setText("Hệ điều hành");

        jLabel2.setText("phiên bản");

        jLabel3.setText("Trạng thái");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTrangThai.setOpaque(false);

        btnChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit-regular-24.png"))); // NOI18N
        btnChon.setOpaque(false);
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash-regular-24.png"))); // NOI18N
        btnXoa.setOpaque(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtROM, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRAM)
                            .addComponent(cbbTrangThai, 0, 175, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtROM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChon))
                .addContainerGap())
        );

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        tbl1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Đang có", jPanel2);

        tbl2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Đã xóa", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        int index = tbl1.getSelectedRow();
        HeDieuHanh bn = sps.getHDH(1).get(index);
        txtROM.setText(bn.getPhienBan());
        txtRAM.setText(bn.getTenHDH());
        heDieuHanh = bn;
        cbbTrangThai.setSelectedIndex(bn.getTrangThai());


    }//GEN-LAST:event_tbl1MouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        JOptionPane.showMessageDialog(rootPane, sps.addHDH(add("")));
        loadDataToTable(sps.getHDH(1), tbla);
        loadDataToTable(sps.getHDH(0), tblb);

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        index = tbl1.getSelectedRow();
        String id = sps.getHDH(1).get(index).getId();
        JOptionPane.showMessageDialog(rootPane, sps.suaHDH(add(id)));
        loadDataToTable(sps.getHDH(1), tbla);
        loadDataToTable(sps.getHDH(0), tblb);


    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl2MouseClicked
         index = tbl2.getSelectedRow();
        HeDieuHanh bn = sps.getHDH(0).get(index);
        txtROM.setText(bn.getPhienBan());
        txtRAM.setText(bn.getTenHDH());
        heDieuHanh = bn;
        cbbTrangThai.setSelectedIndex(bn.getTrangThai());
        System.out.println(bn.getId());
    }//GEN-LAST:event_tbl2MouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String idx = "";
        if (trang == 0) {
            idx = sps.getHDH(1).get(index).getId();
        } else {
            idx = sps.getHDH(0).get(index).getId();
        }
        JOptionPane.showMessageDialog(rootPane, sps.xoaHDH(add(idx), trang));
        loadDataToTable(sps.getHDH(1), tbla);
        loadDataToTable(sps.getHDH(0), tblb);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if (trang == 0) {
            trang = 1;
            ImageIcon icon = new ImageIcon("source\\image\\repost-regular-24.png");
            btnXoa.setIcon(icon);
            btnChon.setEnabled(false);
            btnThem.setEnabled(false);
            btnSua.setEnabled(false);
        } else {
            trang = 0;
            ImageIcon icon = new ImageIcon("source\\image\\trash-regular-24.png");
            btnXoa.setIcon(icon);
            btnChon.setEnabled(true);
            btnThem.setEnabled(true);
            btnSua.setEnabled(true);
        }
        System.out.println("so trang " + trang);
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed

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
            java.util.logging.Logger.getLogger(ViewHDH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHDH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHDH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHDH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                ViewHDH dialog = new ViewHDH(new javax.swing.JFrame(), true, "");
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
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbTrangThai;
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
    private javax.swing.JTextField txtRAM;
    private javax.swing.JTextField txtROM;
    // End of variables declaration//GEN-END:variables
}
