/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.SanPham;

import Service.ExcelServices;
import Service.ServiceImpl.ExcelServicesImpl;
import View.ScanCode;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haha
 */
public class ViewIMEIexcel extends javax.swing.JDialog {

    ExcelServices exs = new ExcelServicesImpl();
    boolean check = false;
    List<String> ix = new ArrayList<>();
    List<Integer> place = new ArrayList<>();
    int index = 0;
    String link = "";
    DefaultTableModel model;

    /**
     * Creates new form NewJDialog
     */
    public ViewIMEIexcel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = (DefaultTableModel) tblIMEI.getModel();
    }

    private void filltable(List<String> x) {
        model.setRowCount(0);
        for (String string : x) {
            Object[] row = new Object[]{string};
            model.addRow(row);
        }
    }

    private boolean check(String x) {
        for (String string : ix) {
            if (string.equals(x)) {
                return false;
            }
        }
        return true;
    }

    public List<String> allIMEI() {
        List<String> p = new ArrayList<>();
        if (check) {
            return ix;
        }
        return p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIMEI = new javax.swing.JTable();
        btnChon = new javax.swing.JButton();
        btnU = new javax.swing.JButton();
        btnA = new javax.swing.JButton();
        btnX = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtIMEIHT = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        txtSearch.setForeground(new java.awt.Color(153, 153, 153));
        txtSearch.setText("Tìm kiếm");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        tblIMEI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "IMEI"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIMEI.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblIMEI.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblIMEI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIMEIMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIMEI);

        btnChon.setText("chọn File");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        btnU.setText("Sửa");
        btnU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUActionPerformed(evt);
            }
        });

        btnA.setText("Thêm");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        btnX.setText("Xóa");
        btnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXActionPerformed(evt);
            }
        });

        txtIMEIHT.setColumns(20);
        txtIMEIHT.setRows(5);
        txtIMEIHT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIMEIHTFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(txtIMEIHT);
        txtIMEIHT.setLineWrap(true);
        txtIMEIHT.getAccessibleContext().setAccessibleName("các IMEI cách nhau bởi dấu (,) ");
        txtIMEIHT.getAccessibleContext().setAccessibleDescription("các IMEI cách nhau bởi dấu (,) ");

        jLabel1.setText("IMEI");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("(khi nhập nhiều IMEI, ngăn cách nhau bởi dấu phẩy)");

        jButton1.setText("Chọn hết");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Chọn ít");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Scan");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearch)
                    .addComponent(btnChon, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(btnU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChon))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnU))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        if (txtSearch.getText().equalsIgnoreCase("Tìm kiếm")) {

            txtSearch.setText("");
            txtSearch.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtSearchMouseClicked

    private void tblIMEIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIMEIMouseClicked
        txtIMEIHT.setEditable(true);
        if (ix.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "IMEI trống");
        } else {
            index = tblIMEI.getSelectedRow();
            String note = txtIMEIHT.getText();
            txtIMEIHT.setText(ix.get(index) + "," + note);
            System.out.println(index);
        }
        if (btnU.getText() == "Lưu") {
            place.add(index);

        }

    }//GEN-LAST:event_tblIMEIMouseClicked

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        txtSearch.setText("");
        try {
            JFileChooser jfc = new JFileChooser("C:\\Users\\haha\\Desktop\\ds\\source");
            this.setVisible(false);
            FileNameExtensionFilter fnf = new FileNameExtensionFilter("Excel", "xlsx");
            jfc.setFileFilter(fnf);
            jfc.setMultiSelectionEnabled(false);
            jfc.showOpenDialog(null);

            File file = jfc.getSelectedFile();
            link = file.getPath();
            System.out.println(link);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        ix = exs.getFile(link);
        filltable(exs.getFile(link));
        this.setVisible(true);
        
    }//GEN-LAST:event_btnChonActionPerformed

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        txtSearch.setText("");
        String imei = txtIMEIHT.getText().trim();
        if (imei.isBlank() == false) {
            String[] id = imei.split(",");
            int checks = 0;
            for (int i = 0; i < id.length; i++) {
                if (check(id[i]) && id[i].isBlank() == false) {
                    ix.add(id[i].trim());
                } else {
                    checks++;
                }
            }
            if (checks != 0) {
                JOptionPane.showMessageDialog(rootPane, "Có " + checks + " IMEI Đã tồn tại");
            }
            filltable(ix);
        } else {
            JOptionPane.showMessageDialog(rootPane, "IMEI trống");
        }
       
    }//GEN-LAST:event_btnAActionPerformed

    private void txtIMEIHTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIMEIHTFocusGained

    }//GEN-LAST:event_txtIMEIHTFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().isBlank()) {
            txtSearch.setText("Tìm kiếm");
            txtSearch.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void btnUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUActionPerformed
        txtSearch.setText("");
        if (btnU.getText() == "Lưu") {
            btnU.setText("Sửa");
            String imei = txtIMEIHT.getText().trim();
            if (imei.isBlank() == false) {
                String[] id = imei.split(",");
                for (Integer i : place) {
                    for (int j = 0; j < id.length; j++) {
                        if (check(id[j])) {
                            ix.set(i, id[j]);
                        };
                    }
                }
            }

        } else {

            txtIMEIHT.setEditable(false);
            btnU.setText("Lưu");
            place.removeAll(place);
        }
        txtIMEIHT.setText("");
        filltable(ix);


    }//GEN-LAST:event_btnUActionPerformed

    private void btnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXActionPerformed
        txtSearch.setText("");
        String imei = txtIMEIHT.getText().trim();
        String[] id = imei.split(",");
        for (int i = 0; i < ix.size(); i++) {
            for (int j = 0; j < id.length; j++) {
                if (ix.get(i).equals(id[j])) {
                    ix.remove(i);
                }
            }
        }
        txtIMEIHT.setText("");
        filltable(ix);

    }//GEN-LAST:event_btnXActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String s = txtSearch.getText();
        txtIMEIHT.setText("");
        List<String> search = new ArrayList<>();
        for (String string : ix) {
            if (string.contains(s)) {
                search.add(string);
            }
        }
        filltable(search);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (check) {
            check = false;
        } else {
            check = true;
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String imei = txtIMEIHT.getText().trim();
        ix.removeAll(ix);
        if (imei.isBlank() == false) {
            String[] id = imei.split(",");
            int checks = 0;
            for (int i = 0; i < id.length; i++) {
                if (check(id[i]) && id[i].isBlank() == false) {
                    ix.add(id[i].trim());
                } else {
                    checks++;
                }
            }
            if (checks != 0) {
                JOptionPane.showMessageDialog(rootPane, "không tòn tại");
            }
            filltable(ix);
        } else {
            JOptionPane.showMessageDialog(rootPane, "IMEI trống");
        }
        if (check) {
            check = false;
        } else {
            check = true;
        }
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String scanImei = "";

        ScanCode sc = new ScanCode(new java.awt.Frame(), true, 0);
        sc.setVisible(true);
        scanImei = sc.getScanResutlx();
        txtIMEIHT.setText(scanImei);

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
            java.util.logging.Logger.getLogger(ViewIMEIexcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewIMEIexcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewIMEIexcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewIMEIexcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewIMEIexcel dialog = new ViewIMEIexcel(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnU;
    private javax.swing.JButton btnX;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblIMEI;
    private javax.swing.JTextArea txtIMEIHT;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
