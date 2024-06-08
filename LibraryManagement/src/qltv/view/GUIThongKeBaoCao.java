package qltv.view;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import qltv.util.DBConnect;
import qltv.util.PrintPDF;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class GUIThongKeBaoCao extends javax.swing.JPanel {

    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    Connection con = null;
    Vector<String> vec1 = new Vector<String>();
    Vector<String> vec2 = new Vector<String>();
    Vector<String> vec3 = new Vector<String>();

    PanelDocGia pDocGia;
    PanelSach pSach;
    PanelMuonTra pMuonTra;

    public GUIThongKeBaoCao() {
        try {
            initComponents();
            pDocGia = new PanelDocGia();
            pSach = new PanelSach();
            pMuonTra = new PanelMuonTra();
            con = DBConnect.getConnection();
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(GUIThongKeBaoCao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcbThongKe = new javax.swing.JComboBox<>();
        btnThongKe = new javax.swing.JButton();
        btnXuatBaoCao = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pThongKe = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfDenNgay = new javax.swing.JTextField();
        tfDenNgay.setForeground(Color.BLACK);
        tfTuNgay = new javax.swing.JTextField();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(1020, 490));
        setMinimumSize(new java.awt.Dimension(1020, 490));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("THỐNG KÊ - BÁO CÁO");

        jcbThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Độc giả", "Sách", "Mượn trả" }));

        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnXuatBaoCao.setText("Xuất báo cáo");
        btnXuatBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatBaoCaoActionPerformed(evt);
            }
        });

        jLabel2.setText("Thống kê theo : ");

        pThongKe.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin thống kê"));
        pThongKe.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Từ ngày :");

        jLabel4.setText("Đến ngày :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(382)
        					.addComponent(jLabel2)
        					.addGap(40)
        					.addComponent(jcbThongKe, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(316)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel3)
        							.addGap(18)
        							.addComponent(tfTuNgay, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(btnThongKe)
        							.addGap(11)))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(30)
        							.addComponent(jLabel4)
        							.addGap(18)
        							.addComponent(tfDenNgay, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(18)
        							.addComponent(btnXuatBaoCao))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(86)
        					.addComponent(pThongKe, GroupLayout.PREFERRED_SIZE, 852, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(402)
        					.addComponent(jLabel1)))
        			.addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(18)
        			.addComponent(jLabel1)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jcbThongKe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(tfTuNgay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4)
        				.addComponent(tfDenNgay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(19)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnXuatBaoCao)
        				.addComponent(btnThongKe))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(pThongKe, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        this.setLayout(layout);

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    //////////// taGia,  theLoai, NXB
    public Vector<String> NameAndSoLuong(String sql) {
        Vector<String> vector = new Vector<String>(100);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vector.add(rs.getString(1) + "\t" + rs.getInt(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIThongKeBaoCao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
//////////////

    public Vector<String> dsDGMuonSach() {
        Vector<String> vector = new Vector<String>(100);
        String sql = "";
        try {

            sql = "select mt.MaMuon, MaDocGiaMuon, TenDocGiaMuon, MaSachMuon, TenSach   from MuonTra mt, ChiTietMuon ctm, Sach s "
                    + " where mt.MaMuon = ctm.MaMuon AND ctm.MaSachMuon = s.MaSach AND TrangThai = N'Đang mượn'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vector.add(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GUIThongKeBaoCao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Loi loi loiiiii" + ex.toString());
        }
        return vector;
    }
///////

    public Vector<String> baTenSachMuonnhieuNhat() {
        Vector<String> vector = new Vector<String>(100);
        String sql = "";
        try {

            sql = "select top 3 MaSachMuon, s.TenSach, count(MaSachMuon) as SoLuong from ChiTietMuon ctm, Sach s "
                    + " where ctm.MaSachMuon = s.MaSach group by MaSachMuon, TenSach order by SoLuong DESC;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GUIThongKeBaoCao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Loi loi loiiiii" + ex.toString());
        }
        return vector;
    }

/////
    private void btnXuatBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatBaoCaoActionPerformed
        String result = (String) jcbThongKe.getSelectedItem();
        // thong ke theo docgia gia
        if (result.equals("Độc giả")) {
            int total = 0, sumDocGia = 0, i = 0;
            try {
                rs = st.executeQuery("SELECT COUNT(MaDG) FROM DocGia");
                if (rs.next()) {
                    total = rs.getInt(1); // lay tong so ma sach
                    System.out.println(total);
                }

                String[] gioiTinh = new String[2];
                rs = st.executeQuery("SELECT COUNT(GioiTinh) FROM DocGia "
                        + " GROUP BY GioiTinh;");

                while (rs.next()) {
                    gioiTinh[i] = rs.getString(1);
                    i++;
                }

                // theo dia chi
                String[] hDiaChi = {"Địa chỉ", "Số lượng"};
                vec1 = NameAndSoLuong("SELECT DiaChi, COUNT(DiaChi) FROM DocGia GROUP BY DiaChi;");

                String[][] diaChi = new String[vec1.size()][];
                for (int j = 0; j < vec1.size(); j++) {
                    diaChi[j] = vec1.get(j).split("\t");
                }

                PrintPDF print = new PrintPDF();
                JFileChooser fc = new JFileChooser();
                int retirnval = fc.showSaveDialog(this);
                if (retirnval == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    try {
                        print.printReaderStats(file.getPath(), total, gioiTinh[0], gioiTinh[1], hDiaChi, diaChi);
                    } catch (IOException ex) {
                        Logger.getLogger(GUIThongKeBaoCao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                JOptionPane.showMessageDialog(null, "Thong ke thanh cong!");

            } catch (SQLException ex) {
                Logger.getLogger(GUIThongKeBaoCao.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Thong ke loi!");
            }

        } // thong ke Sach
        // file, total, []gioitinh, []nxb, []tacgia
        if (result.equals("Sách")) {
            int total = 0, sumSach = 0, i = 0;
            try {
                rs = st.executeQuery("SELECT COUNT(MaSach) FROM Sach;");
                if (rs.next()) {
                    total = rs.getInt(1); // lay tong so ma sach
                    System.out.println(total);
                }

                rs = st.executeQuery("SELECT SUM(SoLuong) FROM Sach;");
                if (rs.next()) {
                    sumSach = rs.getInt(1); // lay tong so sach
                    System.out.println(sumSach);
                }

                // theo NXB
                String[] hNhaXuatban = {"Nhà xuất bản", "Số lượng"};
                vec1 = NameAndSoLuong("SELECT NXB, COUNT(NXB) FROM Sach GROUP BY NXB;");

                String[][] nhaXuatBan = new String[vec1.size()][];
                for (int j = 0; j < vec1.size(); j++) {
                    nhaXuatBan[j] = vec1.get(j).split("\t");
                }

                // theo tacgia
                String[] htacGia = {"Tên tác giả", "Số lượng"};
                vec2 = NameAndSoLuong("SELECT TacGia, COUNT(TacGia) FROM Sach GROUP BY TacGia;");

                String[][] tacGia = new String[vec2.size()][];
                for (int j = 0; j < vec2.size(); j++) {
                    tacGia[j] = vec2.get(j).split("\t");
                }

                // the the loai
                String[] hTheLoai = {"Tên thể loại", "Số lượng"};
                vec3 = NameAndSoLuong("SELECT TheLoai, COUNT(TheLoai) FROM Sach GROUP BY TheLoai;");

                String[][] theLoai = new String[vec3.size()][];
                for (int j = 0; j < vec3.size(); j++) {
                    theLoai[j] = vec3.get(j).split("\t");
                }

                PrintPDF print = new PrintPDF();
                JFileChooser fc = new JFileChooser();
                int retirnval = fc.showSaveDialog(this);
                if (retirnval == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    try {
                        print.printBookStats(file.getPath(), sumSach, total, htacGia, tacGia, hTheLoai, theLoai, hNhaXuatban, nhaXuatBan);
                    } catch (IOException ex) {
                        Logger.getLogger(GUIThongKeBaoCao.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("In lỗi.....!");
                    }
                }

                JOptionPane.showMessageDialog(null, "Thong ke thanh cong!");
            } catch (SQLException ex) {
                Logger.getLogger(GUIThongKeBaoCao.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Thong ke !");
            }
        }

        if (result.equals("Mượn trả")) {
            int sumSachMuon = 0, sumDGMuon = 0, sumQuaHan = 0;
            // Sach muon
            try {
                rs = st.executeQuery("select COUNT(ctm.MaSachMuon) from ChiTietMuon ctm, MuonTra mt where ctm.MaMuon = mt.MaMuon AND TrangThai = N'Đang mượn';");
                if (rs.next()) {
                    sumSachMuon = rs.getInt(1);
                }

                // Doc gia muon sach
                rs = st.executeQuery("SELECT  count(distinct MaDocGiaMuon) FROM MuonTra where TrangThai = N'Đang mượn';");
                if (rs.next()) {
                    sumDGMuon = rs.getInt(1);
                }
                // tong so doc gia muon qua han
                rs = st.executeQuery("SELECT  count(distinct MaDocGiaMuon) FROM MuonTra where TrangThai = N'Quá hạn';");
                if(rs.next()){
                    sumQuaHan = rs.getInt(1);
                }
                // danh sach doc gia muon sach
                String[] hDGMuonSach = {"Mã mượn", "Mã độc giả mượn", "Tên độc giả mượn", "Mã sách mượn", "Tên sách mượn"};
                vec1 = dsDGMuonSach();
                String[][] dGMuonSach = new String[vec1.size()][];
                for (int j = 0; j < vec1.size(); j++) {
                    dGMuonSach[j] = vec1.get(j).split("\t");
                }

                // Ba ten sach duoc muon nhieu nhat
                String[] hBaSachMuonNhieuNhat = {"Mã sách", "Tên sách", "Số lượng"};
                vec2 = baTenSachMuonnhieuNhat();
                String[][] baSachMuonNhieuNhat = new String[vec2.size()][];
                for (int j = 0; j < vec2.size(); j++) {
                    baSachMuonNhieuNhat[j] = vec2.get(j).split("\t");
                }
                
                PrintPDF print = new PrintPDF();
                JFileChooser fc = new JFileChooser();
                int retirnval = fc.showSaveDialog(this);
                if (retirnval == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    try {
                        print.printCheckingStats(file.getPath(), sumSachMuon, sumDGMuon, sumQuaHan, hDGMuonSach, dGMuonSach, hBaSachMuonNhieuNhat, baSachMuonNhieuNhat);
                    } catch (IOException ex) {
                        Logger.getLogger(GUIThongKeBaoCao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                JOptionPane.showMessageDialog(null, "Thong ke thanh cong!");

            } catch (SQLException ex) {
                Logger.getLogger(GUIThongKeBaoCao.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Thong ke loi!");
            }
        }
    }//GEN-LAST:event_btnXuatBaoCaoActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed

        String result = (String) jcbThongKe.getSelectedItem();
        ResultSet rs1 = null, rs2 = null, rs3 = null, rs4 = null, rs5 = null, rs6 = null, rs7 = null;
        con = DBConnect.getConnection();
        if (result.equals("Độc giả")) {
            pThongKe.removeAll();
            pThongKe.add(pDocGia, BorderLayout.CENTER);
            pThongKe.updateUI();

        }
        if (result.equals("Sách")) {
            pThongKe.removeAll();
            pThongKe.add(pSach, BorderLayout.CENTER);
            pThongKe.updateUI();
        }

        if (result.equals("Mượn trả")) {
            pThongKe.removeAll();
            pThongKe.add(pMuonTra, BorderLayout.CENTER);
            pThongKe.updateUI();
        }


    }//GEN-LAST:event_btnThongKeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnXuatBaoCao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> jcbThongKe;
    private javax.swing.JPanel pThongKe;
    private javax.swing.JTextField tfDenNgay;
    private javax.swing.JTextField tfTuNgay;
    // End of variables declaration//GEN-END:variables
}
