/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import DomainModel.DienThoai;
import DomainModel.Dong;
import DomainModel.Hang;
import DomainModel.QuocGia;
import DomainModel.ThongSo;
import Repository.ThemSanPhamRepon;
import Service.AddElementServices;
import Service.SanPhamServices;
import Service.ServiceImpl.AddElementImpl;
import Service.ServiceImpl.SanPhamServicesImpl;
import Service.ServiceImpl.TSPImpl;
import Service.ThemSPServices;
import View.SanPham.DienThoaiView;
import View.SanPham.DongView;
import View.SanPham.ViewCamera;
import View.SanPham.HangView;
import View.SanPham.QuocGiaView;
import View.SanPham.ViewBoNho;
import View.SanPham.ViewHDH;
import View.SanPham.ViewIMEIexcel;
import View.SanPham.ViewKetNoi;
import View.SanPham.ViewMH;
import View.SanPham.ViewPinSac;
import View.SanPham.ViewSacMau;
import View.SanPham.ViewTI;
import View.SanPham.ViewTK;
import View.SanPham.ViewThemSanPham;
import View.SanPham.ViewViXuLy;
import ViewModel.SanPhamViewModel;
import ViewModel.ThongSoViewModel;
import ViewModel.vts;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haha
 */
public class QuanLySanPhamView extends javax.swing.JDialog {

    HangView hv = new HangView(new javax.swing.JFrame(), true, "");
    DongView dv = new DongView(new javax.swing.JFrame(), true, "");
    QuocGiaView qgv = new QuocGiaView(new javax.swing.JFrame(), true, "");
    ViewThemSanPham vtsp = new ViewThemSanPham(new javax.swing.JFrame(), true);
    ViewBoNho bnv = new ViewBoNho(new javax.swing.JFrame(), true, "");
    ViewCamera cmdv = new ViewCamera(new javax.swing.JFrame(), true, "");
    DienThoaiView dtv = new DienThoaiView(new javax.swing.JFrame(), true, "");
    ViewKetNoi vkn = new ViewKetNoi(new javax.swing.JFrame(), true, "");
    ViewMH vmh = new ViewMH(new javax.swing.JFrame(), true, "");
    ViewTI vti = new ViewTI(new javax.swing.JFrame(), true, "");
    ViewTK vtk = new ViewTK(new javax.swing.JFrame(), true, "");
    ViewViXuLy vcpu = new ViewViXuLy(new javax.swing.JFrame(), true, "");
    ViewHDH vhdh = new ViewHDH(new javax.swing.JFrame(), true, "");
    ViewPinSac vpin = new ViewPinSac(new javax.swing.JFrame(), true, "");
    ViewSacMau vsm = new ViewSacMau(new javax.swing.JFrame(), true, "");
    int trangThai = 0;
    String srcAnh = "";
    int trang = 0;
    String idDong = "";
    Double giaBan = 0.0;
    Double giaNhap = 0.0;
    DefaultComboBoxModel modelCBB;
    DefaultComboBoxModel modelcbb1;
    DefaultComboBoxModel modelcbb2;
    DefaultComboBoxModel modelcbb3;
    DefaultComboBoxModel modelcbb4;
    DefaultTableModel modelTBL;
    DefaultTableModel modelTT;
    DefaultTableModel modeldx;
    SanPhamServices sps = new SanPhamServicesImpl();
    List<SanPhamViewModel> ls = new ArrayList<>();
    int index;
    List<String> mei = new ArrayList<>();
    ThongSoViewModel thongSoView = new ThongSoViewModel();
    int dataLs[] = new int[50];
    List<vts> ttList = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("###,###,###,###");
    ThemSPServices tsp = new TSPImpl();
    AddElementServices ae  = new AddElementImpl();

    /**
     * Creates new form QuanLySanPhamView
     */
    public QuanLySanPhamView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modelCBB = (DefaultComboBoxModel) cbbIMEI.getModel();
        modelcbb1 = (DefaultComboBoxModel) cbbHang.getModel();
        modelcbb2 = (DefaultComboBoxModel) cbbDong.getModel();
        modelcbb3 = (DefaultComboBoxModel) cbbQuocGia.getModel();
        modelcbb4 = (DefaultComboBoxModel) cbbDienThoai.getModel();
        modelTT = (DefaultTableModel) tblThongTin.getModel();
        loadTable(sps.getAll());
        modelTT.setRowCount(0);
        loadCBB();
        loadThongSo(null);

    }

    private void loadTable(List<SanPhamViewModel> spsa) {
        ls = spsa;
        modelTBL = (DefaultTableModel) tblSanPham.getModel();
        modelTBL.setRowCount(0);
        String[] title = new String[]{
            "Ảnh", "Tên máy", "Hãng", "Số lượng còn",};
        modelTBL.setColumnIdentifiers(title);

        for (SanPhamViewModel sp : spsa) {
            ImageIcon x = new ImageIcon(new ImageIcon(sp.getSrcAnh()).getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
            Object[] row = new Object[]{x, sp.getTen(), sp.getTenHang(), sp.getSoLuongCon()};
            modelTBL.addRow(row);
        }

    }

    private ThongSo ts(ThongSoViewModel s, String id) {
        ThongSo ss = new ThongSo("", id, s.getHDHID(), s.getCPUID(), s.getBoNhoID(),
                s.getPinID(), s.getKetNoiID(), s.getManHinhID(), s.getThietKeID(), s.getTienIchID(), s.getMauSacID());
        JOptionPane.showMessageDialog(rootPane, sps.addDT(ss));

        return ss;

    }

    private void loadCBB() {
        modelcbb1.removeAllElements();
        modelcbb2.removeAllElements();
        modelcbb3.removeAllElements();
        modelcbb4.removeAllElements();
        List<String> s = new ArrayList<>();
        for (Hang hang : sps.getHang()) {
            s.add(hang.getTen());
        }
        modelcbb1.addAll(s);
        s.removeAll(s);
        for (Dong hang : sps.getDong()) {
            s.add(hang.getTen());
        }
        modelcbb2.addAll(s);
        s.removeAll(s);
        for (QuocGia hang : sps.getQG()) {
            s.add(hang.getTen());
        }
        modelcbb3.addAll(s);
        s.removeAll(s);
        for (DienThoai hang : sps.getDT()) {
            s.add(hang.getTen());
        }
        modelcbb4.addAll(s);
    }

    private void loadThongSo(String id) {
        modelTT.setRowCount(0);
        ThongSoViewModel t = sps.getAllThongSo(id);
        for (vts x : ae.view(t)) {
            Object[] row = new Object[]{x.getThuocTinh(), x.getGiaTri()};
            modelTT.addRow(row);
        }
       

    }

    private void save() {

    }

    private String Value(int x) {
        if (tblThongTin.getValueAt(x, 1) != null) {
            return tblThongTin.getValueAt(x, 1).toString();
        }

        return "";

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        anhSanPham = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbbIMEI = new javax.swing.JComboBox<>();
        btnAddImei = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtSoLuongNhap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbbHang = new javax.swing.JComboBox<>();
        cbbDong = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDoMoi = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        btnHang = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbbQuocGia = new javax.swing.JComboBox<>();
        btnQG = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtMaDT = new javax.swing.JTextField();
        btnHome = new javax.swing.JButton();
        cbbDienThoai = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTin = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        pn1 = new javax.swing.JPanel();
        pn2 = new javax.swing.JPanel();
        pn3 = new javax.swing.JPanel();
        pn4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý sản phẩm");
        setAutoRequestFocus(false);
        setLocation(new java.awt.Point(50, 50));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setEnabled(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm đang bán"));

        txtTimKiem.setForeground(new java.awt.Color(102, 102, 102));
        txtTimKiem.setText("Tìm kiếm");
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                ImageIcon.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setRowHeight(48);
        tblSanPham.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSanPham.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSanPham.setSurrendersFocusOnKeystroke(true);
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtTimKiem.getAccessibleContext().setAccessibleDescription("Tìm kiếm");

        anhSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        anhSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anhSanPhamMouseClicked(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin cơ bản"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tên điện thoại");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 34, 87, -1));

        jLabel2.setText("Danh sách IMEI");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 64, -1, -1));

        cbbIMEI.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbIMEIItemStateChanged(evt);
            }
        });
        jPanel4.add(cbbIMEI, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 61, 264, -1));

        btnAddImei.setText("IMEI");
        btnAddImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImeiActionPerformed(evt);
            }
        });
        jPanel4.add(btnAddImei, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 70, -1));

        jLabel3.setText("Giá bán");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 96, 52, -1));

        jLabel4.setText("Giá nhập");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 122, 64, -1));
        jPanel4.add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 93, 114, -1));
        jPanel4.add(txtGiaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 119, 114, -1));
        jPanel4.add(txtSoLuongNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 150, 114, -1));

        jLabel5.setText("Số lượng nhập");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 153, 81, -1));

        cbbHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cbbHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 92, 115, -1));

        cbbDong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cbbDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 119, 115, -1));

        jLabel6.setText("Hãng");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 95, 48, -1));

        jLabel7.setText("Dòng");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 122, 48, -1));

        jLabel8.setText("Độ mới");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 185, -1, -1));
        jPanel4.add(txtDoMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 182, 114, -1));

        btnThem.setText("thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel4.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 211, 75, 52));

        btnSua.setText("sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel4.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 80, 52));

        btnXoa.setText("xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel4.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 76, 50));

        btnChiTiet.setText("Chi tiết");
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });
        jPanel4.add(btnChiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 80, 50));

        btnHang.setText("jButton1");
        btnHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangActionPerformed(evt);
            }
        });
        jPanel4.add(btnHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 24, -1));

        btnDong.setText("jButton1");
        jPanel4.add(btnDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 24, -1));

        jLabel9.setText("Quốc gia");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 154, -1, -1));

        cbbQuocGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cbbQuocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 151, 115, -1));

        btnQG.setText("jButton1");
        btnQG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQGActionPerformed(evt);
            }
        });
        jPanel4.add(btnQG, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 24, -1));

        jLabel10.setText("Mã điện thoại");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));
        jPanel4.add(txtMaDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 90, -1));

        btnHome.setText("Trang Chủ");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel4.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 100, 50));

        cbbDienThoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cbbDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 260, -1));

        jButton6.setText("ĐT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 70, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        tblThongTin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tblThongTin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Thuộc tính", "Thông tin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongTin.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblThongTin.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongTinMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThongTin);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(anhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(anhSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(28, 28, 28))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        anhSanPham.getAccessibleContext().setAccessibleDescription("ảnh sản phẩm");

        jTabbedPane1.addTab("Sản phẩm đang bán", jPanel1);

        jPanel6.setBackground(java.awt.Color.pink);

        jLabel11.setText("Số sản phẩm đã bán tháng này");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 0, 0));

        jLabel12.setText("Tổng số còn tồn kho");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 255, 204));

        jLabel13.setText("Số sản phẩm đã nhập tháng này");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(41, 41, 41))
        );

        jPanel9.setBackground(new java.awt.Color(242, 203, 43));

        jLabel14.setText("Số sản phẩm tồn kho lâu ngày");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel14)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pn1.setLayout(new java.awt.CardLayout());

        pn2.setLayout(new java.awt.CardLayout());

        pn3.setLayout(new java.awt.CardLayout());

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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout pn4Layout = new javax.swing.GroupLayout(pn4);
        pn4.setLayout(pn4Layout);
        pn4Layout.setHorizontalGroup(
            pn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(637, Short.MAX_VALUE))
        );
        pn4Layout.setVerticalGroup(
            pn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn3.add(pn4, "card2");

        pn2.add(pn3, "card2");

        pn1.add(pn2, "card2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(pn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("đang cập nhật....", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed

    }//GEN-LAST:event_btnChiTietActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked

    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        if (txtTimKiem.getText().isBlank()) {
            txtTimKiem.setText("Tìm kiếm");
            txtTimKiem.setForeground(Color.GRAY);
        }

    }//GEN-LAST:event_txtTimKiemFocusLost

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        txtTimKiem.setText("");
        txtTimKiem.setForeground(Color.black);
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String idbn = "";
        String idcmd = "";
        String idkn = "";
        String idti = "";
        String idtk = "";
        String idpin = "";
        String idms = "";
        String idhdh = "";
        String idmh = "";
        String idcpu = "";
        vtsp.setVisible(true);
        hv.setVisible(true);
        String idh = hv.getID();
        dtv.setVisible(true);
        String iddt = dtv.getID();
        dv.setVisible(true);
        String idd = dv.getID();
        qgv.setVisible(true);
        String idqg = qgv.getID();
        if (vtsp.viewx().isEmpty() == false) {
            for (Integer integer : vtsp.viewx()) {
                switch (integer) {
                    case 1:
                        bnv.setVisible(true);
                        idbn = bnv.id();
                        break;
                    case 2:

                        cmdv.setVisible(true);
                        idcmd = cmdv.id();
                        break;
                    case 3:

                        vhdh.setVisible(true);
                        idhdh = vhdh.id();
                        break;
                    case 4:

                        vkn.setVisible(true);
                        idkn = vkn.id();
                        break;
                    case 5:

                        vmh.setVisible(true);
                        idmh = vmh.id();
                        break;
                    case 6:

                        vsm.setVisible(true);
                        idms = vsm.id();
                        break;
                    case 7:

                        vpin.setVisible(true);
                        idpin = vpin.id();
                        break;
                    case 8:

                        vtk.setVisible(true);
                        idtk = vtk.id();
                        break;
                    case 9:

                        vcpu.setVisible(true);
                        idcpu = vcpu.id();
                        break;
                    case 10:

                        vti.setVisible(true);
                        idti = vti.id();
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }

        ThongSo tsAdd = new ThongSo("", null, idhdh, idcpu, idbn, idpin, idkn, idmh, idtk, idti, idms, idcmd);
        JOptionPane.showMessageDialog(rootPane,ae.themThongSo(tsAdd) , "", 1);


    }//GEN-LAST:event_btnThemActionPerformed

    private void btnAddImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImeiActionPerformed
        mei.removeAll(mei);
        ViewIMEIexcel c = new ViewIMEIexcel(new javax.swing.JFrame(), true);
        c.setVisible(true);
        if (c.allIMEI().isEmpty() == false) {
            modelCBB.removeAllElements();
            mei = c.allIMEI();
            modelCBB.addAll(mei);
            cbbIMEI.setSelectedIndex(0);
            txtSoLuongNhap.setText(mei.size() + "");
        }


    }//GEN-LAST:event_btnAddImeiActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        if (trangThai != 1) {
            index = tblSanPham.getSelectedRow();
            SanPhamViewModel s = ls.get(index);

            modelcbb1.setSelectedItem(s.getTenHang());
            modelcbb2.setSelectedItem(s.getTenDong());
            modelcbb3.setSelectedItem(s.getTenQuocGia());
            modelcbb4.setSelectedItem(s.getTen());

            if (s.getSrcAnh() != null) {
                ImageIcon x = new ImageIcon(new ImageIcon(s.getSrcAnh()).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
                anhSanPham.setIcon(x);
            } else {
                anhSanPham.setText("Không có ảnh sản phẩm");
            }

            txtGiaBan.setText(df.format(s.getGiaBan()));
            txtGiaNhap.setText(df.format(s.getGiaNhap()));

            txtMaDT.setText(s.getMa());
            idDong = s.getId();
            loadThongSo(s.getId());
            modelCBB.removeAllElements();
            modelCBB.addAll(sps.getImei(s.getId()));
            mei.addAll(sps.getImei(s.getId()));
            cbbIMEI.setSelectedIndex(0);

        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void anhSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anhSanPhamMouseClicked
        if (trangThai == 1) {
            anhSanPham.setText("");
            try {
                JFileChooser jfc = new JFileChooser("source");
                this.setVisible(false);
                FileNameExtensionFilter fnf = new FileNameExtensionFilter("Hình ảnh", "jpg", "png");
                jfc.setFileFilter(fnf);
                jfc.setMultiSelectionEnabled(false);
                jfc.showOpenDialog(null);
                File file = jfc.getSelectedFile();
                if (file != null) {
                    srcAnh = file.getPath();
                    System.out.println(srcAnh);
                    Image im = ImageIO.read(file);
                    anhSanPham.setText("");
                    anhSanPham.setIcon(new ImageIcon(im.getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            this.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_anhSanPhamMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        new ThemSanPhamRepon().Xoa(sps.getAll().get(index).getId());

        loadTable(sps.getAll());

    }//GEN-LAST:event_btnXoaActionPerformed

    private void cbbIMEIItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbIMEIItemStateChanged

        txtDoMoi.setText(sps.moi((String) cbbIMEI.getSelectedItem()) + "%");


    }//GEN-LAST:event_cbbIMEIItemStateChanged

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        loadTable(sps.getTimKiemSanPham(txtTimKiem.getText()));
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void tblThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinMouseClicked

    }//GEN-LAST:event_tblThongTinMouseClicked

    private void btnQGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQGActionPerformed
        QuocGiaView s = new QuocGiaView(new JFrame(), true, "");
        s.setVisible(true);
        cbbQuocGia.setSelectedItem(s.getName());
    }//GEN-LAST:event_btnQGActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangActionPerformed
        HangView s = new HangView(new JFrame(), true, "");
        s.setVisible(true);
        cbbHang.setSelectedItem(s.getName());
    }//GEN-LAST:event_btnHangActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        save();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DienThoaiView s = new DienThoaiView(new JFrame(), true, "");
        s.setVisible(true);
        cbbDienThoai.setSelectedItem(s.getName());

    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLySanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLySanPhamView dialog = new QuanLySanPhamView(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel anhSanPham;
    private javax.swing.JButton btnAddImei;
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnHang;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnQG;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbDienThoai;
    private javax.swing.JComboBox<String> cbbDong;
    private javax.swing.JComboBox<String> cbbHang;
    private javax.swing.JComboBox<String> cbbIMEI;
    private javax.swing.JComboBox<String> cbbQuocGia;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JPanel pn3;
    private javax.swing.JPanel pn4;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblThongTin;
    private javax.swing.JTextField txtDoMoi;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaDT;
    private javax.swing.JTextField txtSoLuongNhap;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
