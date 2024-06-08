package qltv.view;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import qltv.controler.CMuonTra;
import qltv.model.MuonTra;
import qltv.util.CalendarAdapter;
import qltv.util.DBConnect;
import qltv.util.PrintPDF;
import javax.swing.ImageIcon;


public class GUIQuanLyMuonTra extends javax.swing.JPanel {
    
    Vector<String> vec;
    DefaultTableModel dm = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    Connection con = null;
    int row = 0; // dong duoc chon trông bang
    private int maMuon = 0;
    CMuonTra cMuonTra = null;
    DBConnect conn = new DBConnect();
    
    public GUIQuanLyMuonTra() {
        try {
            initComponents();
            con = DBConnect.getConnection();
            st = con.createStatement();
            updateBangMuon();
            
            updateChiTietMuon();
            
            updateChiTietPhieuMuon();
        } catch (SQLException ex) {
            Logger.getLogger(GUIQuanLyMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateBangMuon() {
        conn.updateTable(jtableMuonSach, "SELECT * FROM MuonTra ");
        
    }
    
    public void updateChiTietMuon() {
        conn.updateTable(jtableChiTietMuonSach, "SELECT * FROM ChiTietMuon");
    }
    
    public void updateChiTietPhieuMuon() {
        conn.updateTable(jtablehiTietPhieuMuon, "SELECT ctm.*, s.TenSach, mt.MaDocGiaMuon, mt.TenDocGiaMuon, mt.NgayMuon, mt.HanTra FROM MuonTra mt, ChiTietMuon ctm, Sach s "
                + " WHERE ctm.MaMuon = mt.MaMuon AND s.MaSach = ctm.MaSachMuon");
    }
    
    private void loadDLSearch() {
        try {
            String sql = "SELECT ctm.*, mt.MaDocGiaMuon, mt.TenDocGiaMuon, mt.NgayMuon, mt.HanTra FROM MuonTra mt, ChiTietMuon ctm WHERE ctm.MaMuon = mt.MaMuon AND ctm.MaMuon = " + tfMaMuon2.getText() + " ;";
            rs = st.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(GUIQuanLyMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jtablehiTietPhieuMuon.setModel(DbUtils.resultSetToTableModel(rs));
    }
    
    public Vector<String> PhieuMuon(String maMuon) {
        Vector<String> vector = new Vector<String>(100);
        String sql = "";
        try {
            
            sql = "SELECT ctm.*, s.TenSach, mt.MaDocGiaMuon, mt.TenDocGiaMuon, mt.NgayMuon, mt.HanTra FROM MuonTra mt, ChiTietMuon ctm , Sach s WHERE ctm.MaMuon = mt.MaMuon AND s.MaSach = ctm.MaSachMuon AND mt.MaMuon = " + maMuon;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vector.add(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getDate(6) + "\t" + rs.getDate(7));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GUIQuanLyMuonTra.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Loi loi loiiiii" + ex.toString());
        }
        return vector;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel22 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfMaDocGia = new javax.swing.JTextField();
        tfMaSach = new javax.swing.JTextField();
        btnTimKiemSach = new javax.swing.JButton();
        btnTimKiemDocGia = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnMuonSach = new javax.swing.JButton();
        lbMaDocGia = new javax.swing.JLabel();
        lbTenDocGia = new javax.swing.JLabel();
        lbNgayMuon = new javax.swing.JLabel();
        lbHanTra = new javax.swing.JLabel();
        lbTenSach = new javax.swing.JLabel();
        lbMaSach = new javax.swing.JLabel();
        lbMaMuon = new javax.swing.JLabel();
        btnLayMaMuon = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableMuonSach = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        fdfs = new javax.swing.JScrollPane();
        jtableChiTietMuonSach = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        tfMaDocGia4 = new javax.swing.JTextField();
        btnTimKiemDocGia3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        tfMaMuon1 = new javax.swing.JTextField();
        btnTraSach1 = new javax.swing.JButton();
        btnRefreshTable1 = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        tfMaMuon2 = new javax.swing.JTextField();
        btnTimKiem5 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtablehiTietPhieuMuon = new javax.swing.JTable();
        btnRefresh3 = new javax.swing.JButton();
        btnInPhieu = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setMaximumSize(new java.awt.Dimension(1020, 490));
        setMinimumSize(new java.awt.Dimension(1020, 490));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1020, 490));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ MƯỢN TRẢ");

        jTabbedPane1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTabbedPane1ComponentAdded(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        jLabel2.setText("Nhập mã độc giả : ");

        jLabel3.setText("Nhập mã sách : ");

        btnTimKiemSach.setIcon(new ImageIcon(GUIQuanLyMuonTra.class.getResource("/qltv/image/11.png"))); // NOI18N
        btnTimKiemSach.setText("Tìm kiếm ");
        btnTimKiemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSachActionPerformed(evt);
            }
        });

        btnTimKiemDocGia.setIcon(new ImageIcon(GUIQuanLyMuonTra.class.getResource("/qltv/image/11.png"))); // NOI18N
        btnTimKiemDocGia.setText("Tìm kiếm");
        btnTimKiemDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemDocGiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(tfMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(btnTimKiemDocGia)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(btnTimKiemSach)
                        .addGap(90, 90, 90))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tfMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiemDocGia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(tfMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiemSach)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        jLabel4.setText("Ngày mượn :");

        jLabel5.setText("Tên độc giả : ");

        jLabel6.setText("Hạn trả : ");

        jLabel7.setText("Mã độc giả :");

        jLabel8.setText("Mã sách : ");

        jLabel9.setText("Tên sách : ");

        jLabel10.setText("Mã mượn : ");

        btnMuonSach.setIcon(new ImageIcon(GUIQuanLyMuonTra.class.getResource("/qltv/image/15.png"))); // NOI18N
        btnMuonSach.setText("Mượn sách");
        btnMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuonSachActionPerformed(evt);
            }
        });

        lbMaDocGia.setText(". . . . . . . ");

        btnLayMaMuon.setText("Lấy mã mượn");
        btnLayMaMuon.setEnabled(false);
        btnLayMaMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLayMaMuonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(77, 77, 77)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTenDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbHanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMaMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(btnLayMaMuon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMuonSach)))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbHanTra, lbMaDocGia, lbMaMuon, lbMaSach, lbNgayMuon, lbTenDocGia, lbTenSach});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lbMaDocGia)
                        .addGap(18, 18, 18)
                        .addComponent(lbTenDocGia)
                        .addGap(18, 18, 18)
                        .addComponent(lbNgayMuon)
                        .addGap(18, 18, 18)
                        .addComponent(lbHanTra))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(lbMaSach))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbMaMuon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLayMaMuon)
                            .addComponent(btnMuonSach))
                        .addGap(27, 27, 27))))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbHanTra, lbMaDocGia, lbMaMuon, lbMaSach, lbNgayMuon, lbTenDocGia, lbTenSach});

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý mượn sách", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách độc giả mượn sách"));

        jtableMuonSach.setModel(new javax.swing.table.DefaultTableModel(
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
        jtableMuonSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMuonSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableMuonSach);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Chi tiết mượn sách"));

        jtableChiTietMuonSach.setModel(new javax.swing.table.DefaultTableModel(
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
        fdfs.setViewportView(jtableChiTietMuonSach);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fdfs, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fdfs, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel16.setText("Nhập mã độc giả : ");

        btnTimKiemDocGia3.setIcon(new ImageIcon(GUIQuanLyMuonTra.class.getResource("/qltv/image/11.png"))); // NOI18N
        btnTimKiemDocGia3.setText("Tìm kiếm");
        btnTimKiemDocGia3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemDocGia3ActionPerformed(evt);
            }
        });

        jLabel17.setText("Nhập mã mượn : ");

        btnTraSach1.setIcon(new ImageIcon(GUIQuanLyMuonTra.class.getResource("/qltv/image/15.png"))); // NOI18N
        btnTraSach1.setText("Trả sách");
        btnTraSach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraSach1ActionPerformed(evt);
            }
        });

        btnRefreshTable1.setIcon(new ImageIcon(GUIQuanLyMuonTra.class.getResource("/qltv/image/12.png"))); // NOI18N
        btnRefreshTable1.setText("Refresh");
        btnRefreshTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTable1ActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new ImageIcon(GUIQuanLyMuonTra.class.getResource("/qltv/image/13.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMaDocGia4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMaMuon1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(btnRefreshTable1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoa)))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTraSach1)
                    .addComponent(btnTimKiemDocGia3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefreshTable1)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMaDocGia4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(btnTimKiemDocGia3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tfMaMuon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTraSach1))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách độc giả mượn sách", jPanel2);

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tìm kiếm thông tin"));

        jLabel15.setText("Nhập mã mượn :");

        btnTimKiem5.setIcon(new ImageIcon(GUIQuanLyMuonTra.class.getResource("/qltv/image/11.png"))); // NOI18N
        btnTimKiem5.setText("Tìm kiếm");
        btnTimKiem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMaMuon2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnTimKiem5)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(tfMaMuon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiem5)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Chi tiết phiếu mượn"));

        jtablehiTietPhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jtablehiTietPhieuMuon);

        btnRefresh3.setIcon(new ImageIcon(GUIQuanLyMuonTra.class.getResource("/qltv/image/12.png"))); // NOI18N
        btnRefresh3.setText("Refresh");
        btnRefresh3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh3ActionPerformed(evt);
            }
        });

        btnInPhieu.setIcon(new ImageIcon(GUIQuanLyMuonTra.class.getResource("/qltv/image/16.png"))); // NOI18N
        btnInPhieu.setText("In phiếu");
        btnInPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInPhieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInPhieu)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh3)
                .addGap(199, 199, 199))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInPhieu)
                    .addComponent(btnRefresh3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Chi tiết phiếu mượn", jPanel18);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1ComponentAdded

    private void btnInPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInPhieuActionPerformed
        String[] header = {"Mã mượn", "Mã sách mượn", "Tên sách mượn", "Mã độc giả", "Tên độc giả", "Ngày mượn", "Hạn trả"};
        
        vec = PhieuMuon(tfMaMuon2.getText());
      
        String[][] data = new String[vec.size()][];
        for (int i = 0; i < vec.size(); i++) {
            data[i] = vec.get(i).split("\t");
        }
        PrintPDF print = new PrintPDF();
        JFileChooser fc = new JFileChooser();
        int retirnval = fc.showSaveDialog(this);
        if (retirnval == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fc.getSelectedFile();
                print.printChiTietPhieuMuon(file.getPath(), header, data);
            } catch (IOException ex) {
                Logger.getLogger(GUIQuanLyMuonTra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnInPhieuActionPerformed

    private void btnRefresh3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh3ActionPerformed
        updateChiTietPhieuMuon();
    }//GEN-LAST:event_btnRefresh3ActionPerformed

    private void btnTimKiem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem5ActionPerformed
        loadDLSearch();
    }//GEN-LAST:event_btnTimKiem5ActionPerformed

    private void btnRefreshTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTable1ActionPerformed
        updateBangMuon();
    }//GEN-LAST:event_btnRefreshTable1ActionPerformed

    private void btnTraSach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraSach1ActionPerformed
        if (tfMaMuon1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ma muon khong duoc bo trong!");
        }
        if (tfMaDocGia4.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ma doc gia khong duoc bo trong!");
        } else {
            try {
                
                String time = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                
                rs = st.executeQuery("SELECT * FROM MuonTra WHERE MaMuon = '" + tfMaMuon1.getText() + "';");
                
                int comp = 0;
                System.out.println("tome = " + time);
                
                while (rs.next()) {
                    System.out.println("rs.getString(5) = " + rs.getString(5));
                    comp = time.compareTo(rs.getString(5)); // so sanh ngay hien tai voi han tra

                }
                
                if (comp >= 0) {
                    JOptionPane.showMessageDialog(null, "Tra sach qua han!");
                    
                    String sql2 = "UPDATE Sach SET SoLuong = SoLuong + 1 WHERE MaSach in (SELECT MaSach FROm Sach s, ChiTietMuon ctm, MuonTra mt "
                            + "WHERE mt.MaMuon = ctm.MaMuon AND s.MaSach = ctm.MaSachMuon  "
                            + "AND mt.MaMuon =  " + tfMaMuon1.getText() + ");";
                    System.out.println(sql2);
                    st.executeUpdate(sql2);
                    
                    String sql3 = "UPDATE MuonTra SET NgayTra = GETDATE(), TrangThai = N'Quá hạn' Where MaMuon = " + tfMaMuon1.getText();
                    st.executeUpdate(sql3);
                    
                    String sql1 = "update MuonTra set TienPhat =  DATEDIFF(DAY,HanTra, NgayTra)*3000 WHERE MaMuon = " + tfMaMuon1.getText();
                    st.executeQuery(sql1);
                    
                    updateChiTietMuon();
                    updateBangMuon();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Tra sach thanh cong!");
                    String sql2 = "UPDATE Sach SET SoLuong = SoLuong + 1 WHERE MaSach in (SELECT MaSach FROm Sach s, ChiTietMuon ctm, MuonTra mt "
                            + "WHERE mt.MaMuon = ctm.MaMuon AND s.MaSach = ctm.MaSachMuon  "
                            + "AND mt.MaMuon =  " + tfMaMuon1.getText() + ");";
                    System.out.println(sql2);
                    st.executeUpdate(sql2);
                    
                    String sql3 = "UPDATE  MuonTra SET NgayTra = GETDATE(), TrangThai = N'Đã trả' Where MaMuon = " + tfMaMuon1.getText();
                    st.executeUpdate(sql3);
                    //
                    updateChiTietMuon();
                    updateBangMuon();
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(GUIQuanLyMuonTra.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnTraSach1ActionPerformed

    private void btnTimKiemDocGia3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemDocGia3ActionPerformed
        try {
            rs = st.executeQuery("SELECT * FROM MuonTra WHERE MaDocGiaMuon = '" + tfMaDocGia4.getText() + "'");
            
        } catch (SQLException ex) {
            Logger.getLogger(GUIQuanLyMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jtableMuonSach.setModel(DbUtils.resultSetToTableModel(rs));
    }//GEN-LAST:event_btnTimKiemDocGia3ActionPerformed

    private void btnLayMaMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLayMaMuonActionPerformed
        try {

            // lay ngay muon va han tra
            String time = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
            lbNgayMuon.setText(time);
            
            String startDate = time;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(startDate));
            c.add(Calendar.DATE, 20); // hanj tra la 30 ngay sau ngay muon
            startDate = sdf.format(c.getTime()); // han tra

            lbHanTra.setText(startDate);
            // insert doc gia muon
            String sql1 = "INSERT INTO MuonTra(MaDocGiaMuon, TenDocGiaMuon, NgayMuon, HanTra) "
                    + "VALUES ('" + tfMaDocGia.getText() + "',N'" + lbTenDocGia.getText() + "','"
                    + CalendarAdapter.StringToDateUpdate(lbNgayMuon.getText()) + "','" + CalendarAdapter.StringToDateUpdate(lbHanTra.getText()) + "');";
            System.out.println(sql1);
            st.executeUpdate(sql1);
            
            con = DBConnect.getConnection();
            ps = con.prepareStatement("SELECT MaMuon FROM MuonTra WHERE MaDocGiaMuon = ?");
            
            ps.setString(1, lbMaDocGia.getText()); // gan ? = lbMaDG
            rs = ps.executeQuery();
            Integer maMuon = 0;
            while (rs.next()) {
                maMuon = rs.getInt(1);
            }
            
            System.out.println(maMuon);
            lbMaMuon.setText(String.valueOf(maMuon));
            
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(GUIQuanLyMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLayMaMuonActionPerformed

    private void btnMuonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuonSachActionPerformed
        try {
            rs = st.executeQuery("SELECT MaDG FROM DocGia WHERE MaDG = '" + tfMaDocGia.getText() + "'");
            if (!(rs.next())) {
                JOptionPane.showMessageDialog(null, "Ma doc gia chua ton tai!!");
                
            }
            rs = st.executeQuery("SELECT MaSach FROM Sach WHERE  MaSach = '" + tfMaSach.getText() + "' AND SoLuong <> 0 ;");
            if (!(rs.next())) {
                JOptionPane.showMessageDialog(null, "Ma sach chua ton tai hoac da het sach");
                
            } else if (tfMaDocGia.getText().equals("")) {
                JOptionPane.showConfirmDialog(null, "Ma doc gia khong duoc bo trong!");
            } else if (tfMaSach.getText().equals("")) {
                JOptionPane.showConfirmDialog(null, "Ma sach khong duoc bo trong!");
            } else if (lbMaDocGia.getText() == "") {
                JOptionPane.showMessageDialog(null, "Ma doc gia khong duoc bo trong!");
            } else if (lbNgayMuon.getText() == "") {
                JOptionPane.showMessageDialog(null, "Ma sach khong duoc bo trong!");
            } else if (lbMaMuon.getText() == "") {
                JOptionPane.showMessageDialog(null, "Ma muon khong duoc bo trong!");
            } else {
                String sql1 = "SELECT MaMuon, MaSachMuon FROM ChiTietMuon WHERE MaMuon = '" + lbMaMuon.getText() + "' AND MaSachMuon = '" + lbMaSach.getText() + "';";
                rs = st.executeQuery(sql1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Doc gia da muon sach nay roi!");
                } else {
                    st = con.createStatement();
                    conn.excuteQuery("INSERT INTO ChiTietMuon(MaMuon, MaSachMuon)"
                            + " VALUES ('" + lbMaMuon.getText() + "','" + lbMaSach.getText() + "');", "Muon sach  ");
                    
                    conn.excuteQuery("UPDATE Sach SET SoLuong = SoLuong - 1 WHERE MaSach = '" + lbMaSach.getText() + "';", "update so luong sach ");
                    tfMaDocGia.setText(null);
                    tfMaSach.setText(null);
                    
                    updateBangMuon();
                    
                    updateChiTietMuon();
                    updateChiTietPhieuMuon();
                    
                    btnLayMaMuon.setEnabled(false);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GUIQuanLyMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMuonSachActionPerformed

    private void btnTimKiemDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemDocGiaActionPerformed
        try {
            String sql = "SELECT MaDG, TenDG FROM DocGia WHERE MaDG = '" + tfMaDocGia.getText() + "'";
            rs = st.executeQuery(sql);
            System.out.println(sql);
            if (!(rs.next())) {
                JOptionPane.showMessageDialog(null, "Ma doc gia chua ton tai!!!");
                
            } else {
                //rs = st.executeQuery("SELECT TenDG FROM DocGia WHERE MaDG = '" + tfMaDocGia.getText() + "'");
                //while (rs.next()) {
                lbTenDocGia.setText(rs.getString(2));
                //}

                lbMaDocGia.setText(tfMaDocGia.getText());
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GUIQuanLyMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimKiemDocGiaActionPerformed

    private void btnTimKiemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSachActionPerformed
        try {
            // so luong sach != 0 thi moi cho muon
            rs = st.executeQuery("SELECT MaSach, TenSach  FROM Sach WHERE MaSach = '" + tfMaSach.getText() + "' ;");
            if (!(rs.next())) {
                JOptionPane.showMessageDialog(null, "Ma sach chua ton tai!!!");
            }

            // lay gia tri trong CSDL gans cho lable
            lbMaSach.setText(rs.getString(1));
            lbTenSach.setText(rs.getString(2));
            btnLayMaMuon.setEnabled(true);

            //}
        } catch (SQLException ex) {
            Logger.getLogger(GUIQuanLyMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimKiemSachActionPerformed
    

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        
        MuonTra mt = new MuonTra(maMuon);
        //mt.setMaMuon(maMuon);
        cMuonTra = new CMuonTra();
        boolean result1 = cMuonTra.deleteChiTietMuon(mt);
        boolean result2 = false;
        
        if (result1 = true) {
            result2 = cMuonTra.deleteMuonTra(mt);
            if (result2 = true) {
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                updateBangMuon();
                updateChiTietMuon();
                updateChiTietPhieuMuon();
                
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Chưa xóa được mã mượn!");
        }
        

    }//GEN-LAST:event_btnXoaActionPerformed

    private void jtableMuonSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMuonSachMouseClicked
        row = jtableMuonSach.getSelectedRow();
        maMuon = (Integer) jtableMuonSach.getValueAt(row, 0);
        
    }//GEN-LAST:event_jtableMuonSachMouseClicked
///////////////////////////////////


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInPhieu;
    private javax.swing.JButton btnLayMaMuon;
    private javax.swing.JButton btnMuonSach;
    private javax.swing.JButton btnRefresh3;
    private javax.swing.JButton btnRefreshTable1;
    private javax.swing.JButton btnTimKiem5;
    private javax.swing.JButton btnTimKiemDocGia;
    private javax.swing.JButton btnTimKiemDocGia3;
    private javax.swing.JButton btnTimKiemSach;
    private javax.swing.JButton btnTraSach1;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane fdfs;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtableChiTietMuonSach;
    private javax.swing.JTable jtableMuonSach;
    private javax.swing.JTable jtablehiTietPhieuMuon;
    private javax.swing.JLabel lbHanTra;
    private javax.swing.JLabel lbMaDocGia;
    private javax.swing.JLabel lbMaMuon;
    private javax.swing.JLabel lbMaSach;
    private javax.swing.JLabel lbNgayMuon;
    private javax.swing.JLabel lbTenDocGia;
    private javax.swing.JLabel lbTenSach;
    private javax.swing.JTextField tfMaDocGia;
    private javax.swing.JTextField tfMaDocGia4;
    private javax.swing.JTextField tfMaMuon1;
    private javax.swing.JTextField tfMaMuon2;
    private javax.swing.JTextField tfMaSach;
    // End of variables declaration//GEN-END:variables
}
