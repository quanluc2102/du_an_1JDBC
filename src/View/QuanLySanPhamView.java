/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import DomainModel.BoNho;
import DomainModel.ChiTietDienThoai;
import DomainModel.Cpu;
import DomainModel.DienThoai;
import DomainModel.Dong;
import DomainModel.Hang;
import DomainModel.HeDieuHanh;
import DomainModel.KetNoi;
import DomainModel.ManHinh;
import DomainModel.MauSac;
import DomainModel.Pin;
import DomainModel.QuocGia;
import DomainModel.QuocGiaDong;
import DomainModel.ThietKe;
import DomainModel.ThongSo;
import DomainModel.TienIch;
import Repository.SanPhamRespository;
import Repository.ThemSanPhamRepon;
import Service.SanPhamServices;
import Service.ServiceImpl.SanPhamServicesImpl;
import Service.ServiceImpl.TSPImpl;
import Service.ThemSPServices;
import View.SanPham.HangView;
import View.SanPham.QuocGiaView;
import View.SanPham.ViewBoNho;
import View.SanPham.ViewCPU;
import View.SanPham.ViewHeDieuHanh;
import View.SanPham.ViewIMEIexcel;
import View.SanPham.ViewKetNoi;
import View.SanPham.ViewManHinh;
import View.SanPham.ViewMauSac;
import View.SanPham.ViewPin;
import View.SanPham.ViewThietKe;
import View.SanPham.ViewTienIch;
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
        modelTT = (DefaultTableModel) tblThongTin.getModel();
        loadTable(sps.getAll());
        modelTT.setRowCount(0);
        loadCBB();
        loadTable2();

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

    private void loadTable2() {

        modeldx = (DefaultTableModel) tbldaxoa.getModel();
        modeldx.setRowCount(0);
        String[] title = new String[]{
            "Tên máy", "Hãng", "Số lượng còn",};
        modeldx.setColumnIdentifiers(title);

        for (SanPhamViewModel sp : new SanPhamRespository().getAll2()) {

            Object[] row = new Object[]{sp.getTen(), sp.getTenHang(), sp.getSoLuongCon()};
            modeldx.addRow(row);
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

    }

    private void loadThongSo(String id) {
        modelTT.setRowCount(0);
        ThongSoViewModel t = sps.getAllThongSo(id);
        ttList.removeAll(ttList);
        ttList.add(new vts("--------------- BỘ NHỚ ---------------------", "_"));
        ttList.add(new vts("RAM", t.getRam()));
        ttList.add(new vts("ROM", t.getRom()));
        ttList.add(new vts("Thẻ nhớ", t.getTheNho()));
        ttList.add(new vts("--------------- Vi xử lý -------------------", "_"));
        ttList.add(new vts("CPU", t.getCPU()));
        ttList.add(new vts("GPU", t.getGPU()));
        ttList.add(new vts("Loại CPU", t.getCPULoai()));
        ttList.add(new vts("Hãng CPU", t.getCPUHang()));
        ttList.add(new vts("Tiến trình", t.getTienTrinh()));
        ttList.add(new vts("--------------- PIN ------------------------", "_"));
        ttList.add(new vts("Dung lượng Pin", t.getPinDungLuong()));
        ttList.add(new vts("Loại Pin", t.getPinLoai()));
        ttList.add(new vts("Sạc", t.getSac()));
        ttList.add(new vts("Đặc biệt", t.getPindacBiet()));
        ttList.add(new vts("--------------- HỆ ĐIỀU HÀNH ---------------", "_"));
        ttList.add(new vts("Hệ điều hành", t.getHeDieuhanh()));
        ttList.add(new vts("Phiên bản", t.getHDHphienBan()));
        ttList.add(new vts("--------------- THIẾT KẾ -------------------", "_"));
        ttList.add(new vts("Mặt trước", t.getMatTruoc()));
        ttList.add(new vts("Mặt Lưng", t.getMatLung()));
        ttList.add(new vts("Khung viền", t.getKhungVien()));
        ttList.add(new vts("Trọng lượng", t.getTrongLuong()));
        ttList.add(new vts("--------------- MÀN HÌNH -------------------", "_"));
        ttList.add(new vts("Kích thước màn hình", t.getManHinhKichThuoc()));
        ttList.add(new vts("Loại màn hình", t.getManHinhLoai()));
        ttList.add(new vts("Kiểu màn hình", t.getManHinhKieu()));
        ttList.add(new vts("Tầng số quét", t.getTangSoQuet()));
        ttList.add(new vts("Độ phân giải", t.getDoPhanGiai()));
        ttList.add(new vts("Công nghệ màn hình", t.getManHinhCongNghe()));
        ttList.add(new vts("--------------- KẾT NỐI -------------------", "_"));
        ttList.add(new vts("SIM", t.getSIM()));
        ttList.add(new vts("Cổng hồng ngoại", t.getHongNgoai()));
        ttList.add(new vts("Jack tai nghe", t.getJackTaiNghe()));
        ttList.add(new vts("Mạng hỗ trợ", t.getMangHoTro()));
        ttList.add(new vts("Wifi", t.getWifi()));
        ttList.add(new vts("Blutooth", t.getBlutooth()));
        ttList.add(new vts("GPS", t.getGPS()));
        ttList.add(new vts("--------------- MÀU SẮC -------------------", "_"));
        ttList.add(new vts("Màu sắc", t.getMauTen()));
        ttList.add(new vts("Mã màu", t.getMauMa()));
        ttList.add(new vts("--------------- TIỆN ÍCH ĐI KÈM -----------", "_"));
        ttList.add(new vts("Bảo mật", t.getBaoMat()));
        ttList.add(new vts("Kháng nước", t.getKhangNuoc()));
        ttList.add(new vts("Đặc biệt", t.getDacBiet()));

        for (vts x : ttList) {
            Object[] row = new Object[]{x.getThuocTinh(), x.getGiaTri()};
            modelTT.addRow(row);
        }

    }

    private void save() {

        Hang h = new Hang();

        h = tsp.getHang(1).get(cbbHang.getSelectedIndex());
        DienThoai dt = new DienThoai();
        dt.setTen(txtTenDienThoai.getText());
        dt.setIdHang(h.getId());
        dt.setMa(txtMaDT.getText());
        Dong d = new Dong();
        d = sps.getDong().get(cbbDong.getSelectedIndex());
        d.setIdDienThoai(dt.getId());
        QuocGiaDong qgd = new QuocGiaDong();
        qgd.setIdDong(d.getId());

        qgd.setGiaBan(Double.valueOf(txtGiaBan.getText().replace(",", "")));
        qgd.setGiaNhap(Double.valueOf(txtGiaNhap.getText().replace(",", "")));
        if (srcAnh.isBlank() == false) {
            qgd.setSrcAnh(srcAnh.substring(0, 12));
        }
        qgd.setIdQuocGia(sps.getQG().get(cbbQuocGia.getSelectedIndex()).getId());
        BoNho bn = new BoNho("", Value(1), Value(2), Value(3), 1);
        Cpu cpu = new Cpu("", Value(5), Value(6), Value(7), Value(8), Value(9), 1);
        Pin pin = new Pin("", Value(11), Value(12), Value(13), Value(14), 1);
        HeDieuHanh hdh = new HeDieuHanh("", Value(16), Value(17), 1);
        ThietKe tk = new ThietKe("", Value(19), Value(20), Value(21), Value(22), 1);
        ManHinh mh = new ManHinh("", Value(24), Value(25), Value(26), Value(27), Value(28), Value(29), 1);
        KetNoi kn = new KetNoi("", Value(31), Value(32), Value(33), Value(34), Value(35), Value(36), Value(37), 1);
        MauSac ms = new MauSac("", Value(39), Value(40), 1);
        TienIch ti = new TienIch("", Value(42), Value(43), Value(44), 1);
        ThongSo ts = new ThongSo("", tsp.timKiem(qgd), thongSoView.getHDHID(), thongSoView.getCPU(), thongSoView.getBoNhoID(), thongSoView.getPinID(),
                thongSoView.getKetNoiID(), thongSoView.getManHinhID(), thongSoView.getThietKeID(), thongSoView.getTienIchID(), thongSoView.getMauSacID());
        tsp.themHang(h);
        tsp.themQGD(qgd);
        tsp.themSP(ts);
        tsp.themDT(dt);
        for (String string : mei) {
            ChiTietDienThoai ctdt = new ChiTietDienThoai(string, true, Integer.parseInt(txtDoMoi.getText().replace("%", "")), "", tsp.timKiem(qgd));
            JOptionPane.showMessageDialog(this, tsp.themCTDT(ctdt));
        }
        loadTable(sps.getAll());

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
        txtTenDienThoai = new javax.swing.JTextField();
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
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnHang = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbbQuocGia = new javax.swing.JComboBox<>();
        btnQG = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtMaDT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTin = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldaxoa = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
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

        txtTenDienThoai.setEditable(false);
        jPanel4.add(txtTenDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 31, 341, -1));

        jLabel1.setText("Tên điện thoại");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 34, 87, -1));

        jLabel2.setText("Danh sách IMEI");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 64, -1, -1));

        cbbIMEI.setEditable(true);
        cbbIMEI.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbIMEIItemStateChanged(evt);
            }
        });
        jPanel4.add(cbbIMEI, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 61, 264, -1));

        btnAddImei.setText("jButton1");
        btnAddImei.setEnabled(false);
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

        txtGiaBan.setEditable(false);
        jPanel4.add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 93, 114, -1));

        txtGiaNhap.setEditable(false);
        jPanel4.add(txtGiaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 119, 114, -1));

        txtSoLuongNhap.setEditable(false);
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

        txtDoMoi.setEditable(false);
        jPanel4.add(txtDoMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 182, 114, -1));

        btnThem.setText("thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel4.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 211, 75, 52));

        jButton3.setText("sửa");
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 80, 52));

        jButton4.setText("xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 76, 50));

        jButton5.setText("Chi tiết");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 80, 50));

        btnHang.setText("jButton1");
        btnHang.setEnabled(false);
        btnHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangActionPerformed(evt);
            }
        });
        jPanel4.add(btnHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 24, -1));

        btnDong.setText("jButton1");
        btnDong.setEnabled(false);
        jPanel4.add(btnDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 24, -1));

        jLabel9.setText("Quốc gia");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 154, -1, -1));

        cbbQuocGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cbbQuocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 151, 115, -1));

        btnQG.setText("jButton1");
        btnQG.setEnabled(false);
        btnQG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQGActionPerformed(evt);
            }
        });
        jPanel4.add(btnQG, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 24, -1));

        jLabel10.setText("Mã điện thoại");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        txtMaDT.setEditable(false);
        jPanel4.add(txtMaDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 90, -1));

        jButton1.setText("Trang Chủ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 100, 50));

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
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
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        anhSanPham.getAccessibleContext().setAccessibleDescription("ảnh sản phẩm");

        jTabbedPane1.addTab("Sản phẩm đang bán", jPanel1);

        tbldaxoa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbldaxoa);

        jButton2.setText("jButton2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(538, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int i = tblThongTin.getSelectedRow();
        index = tblSanPham.getSelectedRow();
        SanPhamViewModel s = ls.get(index);
        if (trangThai == 0 || trangThai == 2 && i != -1) {
            if (i >= 0 && i <= 3) {
                ViewBoNho v = new ViewBoNho(new javax.swing.JFrame(), true, sps.getAllThongSo(s.getId()).getBoNhoID());
                v.setVisible(true);
                thongSoView.setBoNhoID(v.id());

            } else if (i >= 4 && i <= 8) {
                ViewCPU v = new ViewCPU(new javax.swing.JFrame(), true, sps.getAllThongSo(s.getId()).getCPUID());
                v.setVisible(true);
                thongSoView.setCPUID((v.id()));

            } else if (i >= 9 && i <= 14) {
                ViewPin v = new ViewPin(new javax.swing.JFrame(), true, sps.getAllThongSo(s.getId()).getPinID());
                v.setVisible(true);
                thongSoView.setPinID(v.id());

            } else if (i >= 15 && i <= 17) {
                ViewHeDieuHanh v = new ViewHeDieuHanh(new javax.swing.JFrame(), true, sps.getAllThongSo(s.getId()).getHDHID());
                v.setVisible(true);
                thongSoView.setHDHID(v.id());

            } else if (i >= 18 && i <= 22) {
                ViewThietKe v = new ViewThietKe(new javax.swing.JFrame(), true, sps.getAllThongSo(s.getId()).getThietKeID());
                v.setVisible(true);
                thongSoView.setThietKeID(v.id());

            } else if (i >= 23 && i <= 29) {
                ViewManHinh v = new ViewManHinh(new javax.swing.JFrame(), true, sps.getAllThongSo(s.getId()).getManHinhID());
                v.setVisible(true);
                thongSoView.setManHinhID(v.id());

            } else if (i >= 30 && i <= 37) {
                ViewKetNoi v = new ViewKetNoi(new javax.swing.JFrame(), true, sps.getAllThongSo(s.getId()).getKetNoiID());
                v.setVisible(true);
                thongSoView.setKetNoiID(v.id());

            } else if (i >= 37 && i <= 39) {
                ViewMauSac v = new ViewMauSac(new javax.swing.JFrame(), true, sps.getAllThongSo(s.getId()).getMauSacID());
                v.setVisible(true);
                thongSoView.setMauSacID(v.id());

            } else if (i >= 40 && i <= 44) {
                ViewTienIch v = new ViewTienIch(new javax.swing.JFrame(), true, sps.getAllThongSo(s.getId()).getTienIchID());
                v.setVisible(true);
                thongSoView.setTienIchID(v.id());

            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
        ThongSo ts = new ThongSo();
        if (btnThem.getText() == "Lưu") {
            save();
            btnThem.setText("Thêm");
            btnThem.setText("Thêm");
            txtMaDT.setEditable(false);
            btnAddImei.setEnabled(false);
            btnDong.setEnabled(false);
            btnHang.setEnabled(false);
            txtDoMoi.setEditable(false);
            txtTenDienThoai.setEditable(false);
            txtGiaBan.setEditable(false);
            txtGiaNhap.setEditable(false);
            txtSoLuongNhap.setEditable(false);
            btnQG.setEnabled(false);
            trangThai = 0;
        } else {
            txtMaDT.setEditable(true);
            anhSanPham.setText("                  Chọn ảnh");
            trangThai = 1;
            btnQG.setEnabled(true);
            btnAddImei.setEnabled(true);
            btnDong.setEnabled(true);
            btnHang.setEnabled(true);
            txtDoMoi.setEditable(true);
            txtTenDienThoai.setEditable(true);
            txtGiaBan.setEditable(true);
            txtGiaNhap.setEditable(true);
            txtSoLuongNhap.setEditable(true);
            btnThem.setText("Lưu");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnAddImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImeiActionPerformed
        mei.removeAll(mei);
        ViewIMEIexcel c = new ViewIMEIexcel(new javax.swing.JFrame(), true);
//        this.setVisible(false);
        c.setVisible(true);
        if (c.allIMEI().isEmpty() == false) {
            modelCBB.removeAllElements();
            mei = c.allIMEI();
            modelCBB.addAll(mei);
            cbbIMEI.setSelectedIndex(0);
            txtSoLuongNhap.setText(mei.size() + "");
        }

//        this.setVisible(true);

    }//GEN-LAST:event_btnAddImeiActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        if (trangThai != 1) {
            index = tblSanPham.getSelectedRow();
            SanPhamViewModel s = ls.get(index);

            modelcbb1.setSelectedItem(s.getTenHang());
            modelcbb2.setSelectedItem(s.getTenDong());
            modelcbb3.setSelectedItem(s.getTenQuocGia());

            if (s.getSrcAnh() != null) {
                ImageIcon x = new ImageIcon(new ImageIcon(s.getSrcAnh()).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
                anhSanPham.setIcon(x);
            } else {
                anhSanPham.setText("Không có ảnh sản phẩm");
            }

            txtGiaBan.setText(df.format(s.getGiaBan()));
            txtGiaNhap.setText(df.format(s.getGiaNhap()));
            txtTenDienThoai.setText(s.getTen());

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new ThemSanPhamRepon().Xoa(sps.getAll().get(index).getId());
        loadTable2();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbbIMEIItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbIMEIItemStateChanged

        txtDoMoi.setText(sps.moi((String) cbbIMEI.getSelectedItem()) + "%");


    }//GEN-LAST:event_cbbIMEIItemStateChanged

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        loadTable(sps.getTimKiemSanPham(txtTimKiem.getText()));
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void tblThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinMouseClicked

        //        
        if (trangThai == 1) {
            tblThongTin.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                    },
                    new String[]{
                        "Thuộc tính", "Thông tin"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                    false, true
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[1];
                }
            });

            modelTT = (DefaultTableModel) tblThongTin.getModel();
            loadThongSo(idDong);
        }


    }//GEN-LAST:event_tblThongTinMouseClicked

    private void btnQGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQGActionPerformed
        QuocGiaView s = new QuocGiaView(new JFrame(), true, "");
        s.setVisible(true);
        cbbQuocGia.setSelectedItem(s.getName());
    }//GEN-LAST:event_btnQGActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangActionPerformed
        HangView s = new HangView(new JFrame(), true, "");
        s.setVisible(true);
        cbbHang.setSelectedItem(s.getName());
    }//GEN-LAST:event_btnHangActionPerformed

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
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnHang;
    private javax.swing.JButton btnQG;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbbDong;
    private javax.swing.JComboBox<String> cbbHang;
    private javax.swing.JComboBox<String> cbbIMEI;
    private javax.swing.JComboBox<String> cbbQuocGia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblThongTin;
    private javax.swing.JTable tbldaxoa;
    private javax.swing.JTextField txtDoMoi;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaDT;
    private javax.swing.JTextField txtSoLuongNhap;
    private javax.swing.JTextField txtTenDienThoai;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
