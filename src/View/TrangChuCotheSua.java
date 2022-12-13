/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import DomainModel.NhanVien;
import Service.LoginService;
import Service.NhanVienService;
import Service.ServiceImpl.LoginImpl;
import Service.ServiceImpl.NhanVienServiceImpl;
import ViewModel.ClockThread;
//import Service.LoginService;
//import Service.NhanVienService;
//import Service.ServiceImpl.LoginImpl;
//import Service.ServiceImpl.NhanVienImpl;
import ViewModel.NhanVienView;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import table.TableCustom;

/**
 *
 * @author buiti
 */
public class TrangChuCotheSua extends javax.swing.JDialog {

    /**
     * Creates new form TrangChuQuanLyView
     */
    private DefaultTableModel dtm = new DefaultTableModel();
    private List<NhanVienView> listNV = new ArrayList<>();
    private NhanVienService impl = new NhanVienServiceImpl();
    private LoginService implDX = new LoginImpl();
    private DefaultComboBoxModel modelccbCV;
    List<String> idCV = impl.IDChucVu();
    int index = 1;
    String name = "";
    String a2 = "";
    int width =260; int height = 950;

    public TrangChuCotheSua(String a) {
        initComponents();
        String header[] = {"id", "Mã Nhân viên", "Tên Nhân viên", "id Chức vụ", "Chức vụ", "Ngày sinh", "SDT", "Email", "Địa chỉ", "Mật khẩu", "Trạng thái", "CMND"};
        jTable1.setModel(dtm);
        dtm.setColumnIdentifiers(header);
        listNV = impl.getAll();
        txtLayMa.setText(a);
        impl.showData(dtm, listNV);
        addCbb();
        a2 = a;
        ClockThread clockThread = new ClockThread(lblTime);
        Thread t1 = new Thread(clockThread);
        textNgay.setText(java.time.LocalDate.now() + "");
        t1.start();
        //chỉnh table
         getContentPane().setBackground(Color.WHITE);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
//        testData();
    }

    public void addCbb() {
        modelccbCV = (DefaultComboBoxModel) cbbCV.getModel();
        modelccbCV.addAll(impl.ChucVuCBB());

    }
     void openMenuBar(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    pnMenu.setSize(i, height);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TrangChuCotheSua.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
          void closeMenuBar(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i >0; i--) {
                    pnMenu.setSize(i, height);
                                        try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TrangChuCotheSua.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

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
            txtDiaChiNV.setBackground(Color.white);
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
        if (txtPass.getText().isEmpty()) {
            txtRPMatKhau.setText("Mật khậu đang trống");
            txtRPMatKhau.setForeground(Color.red);
            txtPass.setBackground(Color.yellow);
        } else {
            txtRPMatKhau.setText("*");
            txtRPMatKhau.setForeground(Color.GREEN);
            nv.setSdt(txtSDT.getText());
            txtPass.setBackground(Color.white);
            conf7 = true;
        }
        if (cbbCV.getSelectedIndex() == -1) {
            cbbRPCV.setForeground(Color.red);
            cbbRPCV.setText("Hãy chọn chức vụ");
        } else {
            nv.setIdChucVu(idCV.get(cbbCV.getSelectedIndex()));
            conf8 = true;
        }
//        nv.setMa(txtMaNV.getText());
//        nv.setTen(txtTenNV.getText());
//        nv.setNgaySinh(txtNgaySinhNV.getText());
//        nv.setEmail(txtEmail.getText());
//        nv.setDiaChi(txtDiaChiNV.getText());
//        nv.setSdt(txtSDT.getText());

//        System.out.println(nv.toString());
//        JOptionPane.showMessageDialog(rootPane, impl.dangKi(nv));
        if (conf1 == true && conf2 == true && conf3 == true && conf4 == true && conf5 == true && conf6 == true && conf7 == true && conf8 == true) {
            nv.setMatKhau(txtPass.getText());
            JOptionPane.showMessageDialog(rootPane, impl.dangKi(nv));
            System.out.println(nv.toString());
            System.out.println(impl.dangKi(nv));
            listNV = impl.getAll();
            impl.showData(dtm, listNV);
        }
//        
    }

    public String takemaNV() {
        return a2;
    }

    public void fillData(int index) {
        NhanVienView nv = listNV.get(index);
        id.setText(nv.getId());
        txtMaNV.setText(nv.getMa());
        txtTenNV.setText(nv.getTen());
        txtNgaySinhNV.setText(nv.getNgaySinh());
        txtDiaChiNV.setText(nv.getDiaChi());
        txtEmail.setText(nv.getEmail());
        txtPass.setText(nv.getMatKhau());
        txtSDT.setText(nv.getSdt());
        cbbCV.setSelectedItem(nv.getTenChucVu());
        if (nv.getTrangThai() == 0) {
            radioNghi.setSelected(true);

        } else {
            radioDangLam.setSelected(true);
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
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        textNgay = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtRPMa = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        txtRPTen = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNgaySinhNV = new javax.swing.JTextField();
        txtRPNgaySinh = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChiNV = new javax.swing.JTextField();
        txtRPDiaChi = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtRPSDT = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbbCV = new javax.swing.JComboBox<>();
        cbbRPCV = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtRPEmail = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        txtRPMatKhau = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        radioNghi = new javax.swing.JRadioButton();
        radioDangLam = new javax.swing.JRadioButton();
        btnDangKy = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtCanCuoc = new javax.swing.JTextField();
        pnMenu = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtLayMa = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        panel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        panel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        panel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        panel8 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(204, 0, 51), new java.awt.Color(204, 51, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách người dùng"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 508, 1374, 422));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 153, 0));
        jLabel20.setText("  |<");
        jLabel20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 51, 0), new java.awt.Color(255, 102, 0)));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 964, 60, 47));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 153, 0));
        jLabel21.setText(" <<");
        jLabel21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 51, 0), new java.awt.Color(255, 102, 0)));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 964, 57, 47));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 153, 0));
        jLabel22.setText(" >>");
        jLabel22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 204, 0)));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 964, 53, 47));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 153, 0));
        jLabel23.setText("  >|");
        jLabel23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 0), new java.awt.Color(255, 51, 0), new java.awt.Color(255, 204, 0), new java.awt.Color(255, 204, 0)));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(802, 964, 57, 47));

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTime.setText("00:00 AM");
        jPanel4.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1239, 936, -1, 22));

        textNgay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textNgay.setText("Date");
        jPanel4.add(textNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(1239, 980, 112, 22));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin"));

        txtSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 0, 51), new java.awt.Color(255, 51, 0)));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 0));
        jLabel13.setText("arch");

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Se");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 130, -1, 410));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/z3946860666735_30f52c7f5e3d1a6b5fd11409bdce2492.jpg"))); // NOI18N
        jButton1.setText("ADD QR");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 130, 50));

        jLabel15.setText("ID");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        id.setForeground(new java.awt.Color(255, 51, 0));
        id.setText(" ");
        jPanel4.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 275, 25));

        jLabel25.setText("CMND");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        txtCMND.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel4.add(txtCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 275, 26));

        jLabel4.setText("Mã nhân viên");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 74, -1));

        txtMaNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 51, 0), new java.awt.Color(255, 204, 0), new java.awt.Color(255, 204, 0)));
        jPanel4.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 275, 30));
        jPanel4.add(txtRPMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 210, 16));

        jLabel5.setText("Tên nhân viên");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txtTenNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 102, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 204, 0)));
        jPanel4.add(txtTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 262, 30));
        jPanel4.add(txtRPTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 210, 16));

        jLabel6.setText("Ngày sinh");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 74, -1));

        txtNgaySinhNV.setText("dd-mm-yyyy");
        txtNgaySinhNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 255, 51), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 204, 0)));
        jPanel4.add(txtNgaySinhNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 262, 30));
        jPanel4.add(txtRPNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 228, 22));

        jLabel7.setText("Địa chỉ");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 37, -1));

        txtDiaChiNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 204, 0)));
        jPanel4.add(txtDiaChiNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 660, 30));
        jPanel4.add(txtRPDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 641, 16));

        jLabel8.setText("Số điện thoại");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 74, -1));

        txtSDT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 0, 0), null));
        jPanel4.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 221, 30));
        jPanel4.add(txtRPSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 220, 18));

        jLabel9.setText("Chức vụ");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 74, 20));

        cbbCV.setEditable(true);
        cbbCV.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        cbbCV.setAutoscrolls(true);
        cbbCV.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 51), new java.awt.Color(255, 255, 0)));
        jPanel4.add(cbbCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 221, 30));
        jPanel4.add(cbbRPCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 220, 16));

        jLabel10.setText("Email");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        txtEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 153, 0)));
        jPanel4.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 221, 30));
        jPanel4.add(txtRPEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 220, 22));

        jLabel11.setText("Mật khẩu");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 63, -1));

        txtPass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 204, 0)));
        jPanel4.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 220, 30));
        jPanel4.add(txtRPMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 221, 22));

        jLabel14.setText("Trạng thái");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        buttonGroup1.add(radioNghi);
        radioNghi.setSelected(true);
        radioNghi.setText("Nghỉ");
        jPanel4.add(radioNghi, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        buttonGroup1.add(radioDangLam);
        radioDangLam.setText("Đang làm");
        jPanel4.add(radioDangLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, -1));

        btnDangKy.setBackground(new java.awt.Color(51, 51, 51));
        btnDangKy.setForeground(new java.awt.Color(255, 255, 255));
        btnDangKy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/use.png"))); // NOI18N
        btnDangKy.setText("Thêm");
        btnDangKy.setBorder(null);
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });
        jPanel4.add(btnDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 130, 50));

        btnUpdate.setBackground(new java.awt.Color(51, 51, 51));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Sửa");
        btnUpdate.setBorder(null);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel4.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 130, 50));

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Chuyển trạng thái");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 130, 50));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Thông tin nhận được từ căn cước");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 466, 298, 22));

        txtCanCuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCanCuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCanCuocActionPerformed(evt);
            }
        });
        jPanel4.add(txtCanCuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 464, 357, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 1390, 950));

        pnMenu.setBackground(new java.awt.Color(102, 102, 102));
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Account.png"))); // NOI18N
        jLabel16.setText("Mã :");
        pnMenu.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 110, 60));

        txtLayMa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtLayMa.setForeground(new java.awt.Color(255, 255, 255));
        pnMenu.add(txtLayMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 140, 38));

        panel4.setBackground(new java.awt.Color(255, 153, 0));
        panel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/KhachHang.png"))); // NOI18N
        jLabel17.setText("Khách hàng");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel17))
        );

        pnMenu.add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 397, 248, -1));

        panel5.setBackground(new java.awt.Color(255, 153, 0));
        panel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/SAnPham1.png"))); // NOI18N
        jLabel18.setText("Khuyến mãi");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnMenu.add(panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 476, 248, -1));

        panel6.setBackground(new java.awt.Color(255, 153, 0));
        panel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/SAnPham1.png"))); // NOI18N
        jLabel19.setText("Hóa Đơn");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnMenu.add(panel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 644, 248, -1));

        panel7.setBackground(new java.awt.Color(255, 153, 0));
        panel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/SAnPham1.png"))); // NOI18N
        jLabel24.setText("Bán Hàng");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnMenu.add(panel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 581, 248, -1));

        panel8.setBackground(new java.awt.Color(255, 153, 0));
        panel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/SAnPham1.png"))); // NOI18N
        jLabel27.setText("Đăng xuất");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel8Layout = new javax.swing.GroupLayout(panel8);
        panel8.setLayout(panel8Layout);
        panel8Layout.setHorizontalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel8Layout.setVerticalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnMenu.add(panel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 722, 248, -1));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/NguoiDUng1.png"))); // NOI18N
        jButton2.setText("Chức vụ");
        jButton2.setBorder(null);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnMenu.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 85, 240, 52));

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/SAnPham1.png"))); // NOI18N
        jButton3.setText("Sản phẩm");
        jButton3.setBorder(null);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnMenu.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 164, 240, 52));

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ThongKe.png"))); // NOI18N
        jButton4.setText("Thống kê doanh thu");
        jButton4.setBorder(null);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pnMenu.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 234, 240, 52));

        jPanel1.add(pnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 960));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/brackgroudTrangChu.jpg"))); // NOI18N
        jLabel28.setText("jLabel28");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1670, 980));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        fillData(row);

    }//GEN-LAST:event_jTable1MouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        name = txtSearch.getText();
        listNV = impl.searchNhanVien(name);
        impl.showData(dtm, listNV);

    }//GEN-LAST:event_txtSearchKeyReleased

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        new KhachHangViewQuanLy().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        new ViewKhuyenMai().setVisible(true);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        new ViewHoaDon().setVisible(true);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        index--;
        if (index == 0) {

            index = listNV.size() - 1;
        }
        fillData(index);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        index++;
        if (index > listNV.size() - 1) {

            index = 0;
        }
        fillData(index);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        index = 0;

        fillData(index);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        index = listNV.size() - 1;

        fillData(index);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        new BanHangView().setVisible(true);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cmnd = "";
//        int camera = ccbWebcam.getSelectedIndex();
        ScanCode sc = new ScanCode(new java.awt.Frame(), true,0);
        sc.setVisible(true);
        cmnd = sc.getScanResutlx();
        String soCC = cmnd.substring(0, 12);
        txtCMND.setText(soCC);
        String withouTen = cmnd.substring(14, cmnd.length());
        System.out.println(withouTen);
        String[] splits = withouTen.split("[|]");
        txtTenNV.setText(splits[0]);
        txtDiaChiNV.setText(splits[3]);

//               nguoiDung.setDiaChi(splits[3]);
//         txtCanCuoc.setText(cmnd);
//         String[] allcmnd = cmnd.split("");
//         int n = 200;
//         for (int i = 12; i < n; i++) {
//             if (allcmnd[i].equalsIgnoreCase("|")) {
//                 cmnd.substring(12,i);
//                 
//             } else {
//             }
//              String input = result.getText();
//                    String withoutTen = input.substring(14, input.length());
//                    String[] splits = withoutTen.split("[|]");
//                    if (iNguoiDungService.getObj(input.substring(0, 12)) != null) {
//                        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Đã tồn tại trong danh sách!");
//                        panel.showNotification();
//                    } else {
//                        NguoiDung nguoiDung = new NguoiDung();
//                        nguoiDung.setMa(input.substring(0, 12));
//                        nguoiDung.setTen(splits[0]);
//                        nguoiDung.setDiaChi(splits[3]);
//        txtCMND.setText(cmnd.substring(0,12));
//        for (String item : cmndten) {
//            System.out.println(item);
//        }
//        txtcmnd.setText(cmndten[0]);
//        txtTenNV.setText(cmndten[2]);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCanCuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCanCuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCanCuocActionPerformed

    private void txt_maActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maActionPerformed

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        System.out.println(implDX.dangXuat());
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseExited

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int row = jTable1.getSelectedRow();
        NhanVienView nv = listNV.get(row);
        String id = nv.getId();
        JOptionPane.showMessageDialog(rootPane, impl.chuyenTTNV(id));
        listNV.add(nv);
        listNV = impl.getAll();
        impl.showData(dtm, listNV);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        DangKi();   // TODO add your handling code here:
    }//GEN-LAST:event_btnDangKyActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        NhanVien nv = new NhanVien();
        String ids = id.getText();
        nv.setMa(txtMaNV.getText());
        nv.setTen(txtTenNV.getText());
        nv.setNgaySinh(txtNgaySinhNV.getText());
        nv.setEmail(txtEmail.getText());
        nv.setDiaChi(txtDiaChiNV.getText());
        nv.setSdt(txtSDT.getText());
        nv.setIdChucVu(idCV.get(cbbCV.getSelectedIndex()));
        nv.setMatKhau(txtPass.getText());
        if (radioNghi.isSelected()) {
            nv.setTrangThai(1);
        } else {
            nv.setTrangThai(2);
        }
        JOptionPane.showMessageDialog(rootPane, impl.update(nv, ids));
        listNV = impl.getAll();
        impl.showData(dtm, listNV);
        System.out.println(id);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       new ViewChucVu().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         QuanLySanPhamView spv = new QuanLySanPhamView();
        spv.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       new ThongKeView().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed
    public void setColor(JPanel p) {
        p.setBackground(new Color(255, 105, 0));
    }

    public void retColor(JPanel p1) {
        p1.setBackground(new Color(255, 153, 0));
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbCV;
    private javax.swing.JLabel cbbRPCV;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JPanel panel7;
    private javax.swing.JPanel panel8;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JRadioButton radioDangLam;
    private javax.swing.JRadioButton radioNghi;
    private javax.swing.JLabel textNgay;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtCanCuoc;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtLayMa;
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
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables

}