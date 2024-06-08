package qltv.view;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import qltv.controler.CSach;

import qltv.model.Sach;
import qltv.util.DBConnect;
import qltv.util.PrintPDF;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
import java.awt.Component;


public class GUIQuanLySach extends javax.swing.JPanel {

    DefaultTableModel dm;
    CSach cSach = new CSach();
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    SimpleDateFormat sdf = new SimpleDateFormat();
    List<Sach> sachList = null;

    public GUIQuanLySach() {
        initComponents();

        con = DBConnect.getConnection();
        try {
            st = con.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadDataInTable();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfMaSach = new javax.swing.JTextField();
        tfTenSach = new javax.swing.JTextField();
        tfNhaXuatBan = new javax.swing.JTextField();
        tfSoLuong = new javax.swing.JTextField();
        tfDonGia = new javax.swing.JTextField();
        tfTacGia = new javax.swing.JTextField();
        tfTheLoai = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnThemTuFile = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tfTimKiem = new javax.swing.JTextField();
        cbbTimKiem = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        XuatPDF = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSach = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(1020, 490));
        setMinimumSize(new java.awt.Dimension(1020, 490));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1020, 490));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ SÁCH");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Thông tin sách"));
        jPanel1.setMaximumSize(new java.awt.Dimension(740, 225));
        jPanel1.setMinimumSize(new java.awt.Dimension(740, 225));
        jPanel1.setPreferredSize(new java.awt.Dimension(740, 225));

        jLabel2.setText("Mã sách:");

        jLabel3.setText("Số lượng:");

        jLabel4.setText("Tên sách:");

        jLabel5.setText("Nhà xuất bản:");

        jLabel6.setText("Tác giả:");

        jLabel7.setText("Đơn giá:");

        jLabel8.setText("Thể loại:");

        btnThem.setIcon(new ImageIcon(GUIQuanLySach.class.getResource("/qltv/image/14.png"))); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new ImageIcon(GUIQuanLySach.class.getResource("/qltv/image/13.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setIcon(new ImageIcon(GUIQuanLySach.class.getResource("/qltv/image/6.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new ImageIcon(GUIQuanLySach.class.getResource("/qltv/image/12.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnThemTuFile.setIcon(new ImageIcon(GUIQuanLySach.class.getResource("/qltv/image/8.png"))); // NOI18N
        btnThemTuFile.setText("Thêm file");
        btnThemTuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTuFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(27)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        					.addComponent(btnThem)
        					.addGap(18)
        					.addComponent(btnSua)
        					.addGap(18)
        					.addComponent(btnXoa)
        					.addPreferredGap(ComponentPlacement.RELATED))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel4)
        						.addComponent(jLabel2)
        						.addComponent(jLabel5)
        						.addComponent(jLabel3))
        					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(tfSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(tfTenSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(tfNhaXuatBan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(tfMaSach, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(23)
        					.addComponent(btnRefresh))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(76)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel6)
        						.addComponent(jLabel7)
        						.addComponent(jLabel8))))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        							.addComponent(tfTheLoai, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        							.addContainerGap())
        						.addComponent(tfDonGia, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(tfTacGia, 174, 174, 174)
        							.addContainerGap())))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(14)
        					.addComponent(btnThemTuFile)
        					.addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(tfMaSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2)
        				.addComponent(jLabel7)
        				.addComponent(tfDonGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel4)
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(tfTenSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addComponent(jLabel6))))
        				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
        					.addComponent(tfTacGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(10)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(tfNhaXuatBan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel5))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(tfSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel3)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel8)
        						.addComponent(tfTheLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        			.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnThem)
        				.addComponent(btnSua)
        				.addComponent(btnXoa)
        				.addComponent(btnRefresh)
        				.addComponent(btnThemTuFile))
        			.addGap(28))
        );
        jPanel1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {tfMaSach, tfTenSach, tfNhaXuatBan, tfSoLuong, tfDonGia, tfTacGia, tfTheLoai});
        jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {tfMaSach, tfTenSach, tfNhaXuatBan, tfSoLuong, tfDonGia, tfTacGia, tfTheLoai});
        jPanel1.setLayout(jPanel1Layout);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Tìm kiếm sách"));
        jPanel2.setPreferredSize(new java.awt.Dimension(325, 158));

        jLabel9.setText("Nhập từ khóa tìm kiếm : ");

        cbbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sách", "Tên sách", "Tác giả", "Nhà xuất bản", "Thể loại", "None", " ", " " }));

        btnTimKiem.setIcon(new ImageIcon(GUIQuanLySach.class.getResource("/qltv/image/11.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        XuatPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qltv/image/pdf.png"))); // NOI18N
        XuatPDF.setText("Xuất pdf");
        XuatPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XuatPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(26)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel9)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(jPanel2Layout.createSequentialGroup()
        						.addGap(18)
        						.addComponent(btnTimKiem))
        					.addGroup(jPanel2Layout.createSequentialGroup()
        						.addComponent(tfTimKiem, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        						.addGap(18)
        						.addComponent(cbbTimKiem, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(32, Short.MAX_VALUE))
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap(105, Short.MAX_VALUE)
        			.addComponent(XuatPDF)
        			.addGap(113))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(22)
        			.addComponent(jLabel9)
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(tfTimKiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbbTimKiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(30)
        			.addComponent(btnTimKiem)
        			.addGap(18)
        			.addComponent(XuatPDF)
        			.addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sách"));

        tbSach.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSach);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 989, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(434, 434, 434)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadDataInTable() {

        dm = new DefaultTableModel();
        sachList = new ArrayList<Sach>();
        Vector<String> colName = new Vector<>();
        dm.addColumn("Mã sách");
        dm.addColumn("Tên sách");
        dm.addColumn("Nhà xuất bản");
        dm.addColumn("Tác giả");
        dm.addColumn("Thể loại");
        dm.addColumn("Đơn giá");
        dm.addColumn("Số lượng");

        cSach = new CSach();
        sachList = cSach.selectAll();

        for (Sach s : sachList) {
            Vector vector = new Vector();

            vector.add(s.getMaSach());
            vector.add(s.getTenSach());
            vector.add(s.getNxb());
            vector.add(s.getTacGia());
            vector.add(s.getTheLoai());
            vector.add(s.getDonGia());
            vector.add(s.getSoLuong());

            // tao hang
            dm.addRow(vector);
        }
        // Dua DL tu dm vao table
        tbSach.setModel(dm);

    }

    private void loadDateSearch() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //khởi tạo lại model, xóa hết cột cũ dòng cũ đi
        dm = new DefaultTableModel();
        Vector<String> colName = new Vector<>();
        //tạo cột
        dm.addColumn("Mã sách");
        dm.addColumn("Tên sách");
        dm.addColumn("Nhà xuất bản");
        dm.addColumn("Tác giả");
        dm.addColumn("Thể loại");
        dm.addColumn("Đơn giá");
        dm.addColumn("Số lượng");

        // lay ra toan bo danh sach doc gia
        cSach = new CSach();

        Sach sach = new Sach();
        sach.setMaSach(tfTimKiem.getText());
        sach.setTenSach(tfTimKiem.getText());
        sach.setNxb(tfTimKiem.getText());
        sach.setTacGia(tfTimKiem.getText());
        sach.setTheLoai(tfTimKiem.getText());

        String result = (String) cbbTimKiem.getSelectedItem();
        System.out.println("result search = " + result);

        if (result.equals("Mã sách")) {
            try {
                sachList = cSach.search(sach, result);
            } catch (SQLException ex) {
                Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (result.equals("Tên sách")) {
            try {
                sachList = cSach.search(sach, result);
            } catch (SQLException ex) {
                Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (result.equals("Nhà xuất bản")) {
            try {
                sachList = cSach.search(sach, result);
            } catch (SQLException ex) {
                Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (result.equals("Tác giả")) {
            try {
                sachList = cSach.search(sach, result);
            } catch (SQLException ex) {
                Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (result.equals("Thể loại")) {
            try {
                sachList = cSach.search(sach, result);
            } catch (SQLException ex) {
                Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (result.equals("None")) {
            try {
                sachList = cSach.search(sach, result);
            } catch (SQLException ex) {
                Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // add toan bo DL tu CSDL vao table
        for (Sach s : sachList) {
            Vector vector = new Vector();
            vector.add(s.getMaSach());
            vector.add(s.getTenSach());
            vector.add(s.getNxb());
            vector.add(s.getTacGia());
            vector.add(s.getTheLoai());
            vector.add(s.getDonGia());
            vector.add(s.getSoLuong());

            // tao hang
            dm.addRow(vector);
        }
        // Dua DL tu dm vao table
        tbSach.setModel(dm);

    }

    private void clear() {
        tfMaSach.setText("");
        tfTenSach.setText("");
        tfNhaXuatBan.setText("");
        tfTacGia.setText("");
        tfTheLoai.setText("");
        tfDonGia.setText("");
        tfSoLuong.setText("");
    }
// sai

    private void themFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("G:\\"));
        int check = chooser.showOpenDialog(this);
        if (check == chooser.APPROVE_OPTION) {

            try {
                String[] titile = new String[]{"Mã sách", "Tên sách", "Nhà xuất bản", "Tác giả", "Thể loại", "Đơn giá", "Số lượng"};

                dm = new DefaultTableModel(titile, 0);
                File file = chooser.getSelectedFile();

                Workbook wb = Workbook.getWorkbook(file);
                Sheet sheet = wb.getSheet(0);

                Cell cell;

                //List<Sach> sachList = null;
                DBConnect conn = new DBConnect();
                String[] values = new String[7];
                for (int i = 1; i < sheet.getRows(); i++) {
                    Sach s = new Sach();

                    cell = sheet.getCell(0, i);
                    values[0] = cell.getContents();
                    cell = sheet.getCell(1, i);
                    values[1] = cell.getContents();
                    cell = sheet.getCell(2, i);
                    values[2] = cell.getContents();
                    cell = sheet.getCell(3, i);
                    values[3] = cell.getContents();
                    cell = sheet.getCell(4, i);
                    values[4] = cell.getContents();
                    cell = sheet.getCell(5, i);
                    values[5] = cell.getContents();
                    cell = sheet.getCell(6, i);
                    values[6] = cell.getContents();

                    conn.insert("Sach", values); // insert DL vao trong CSDL
                    dm.addRow(values);
                }

                tbSach.setModel(dm);
            } catch (IOException ex) {
                Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lỗi IOException");
            } catch (BiffException ex) {
                Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    private void writeFileExcel() {

        WritableWorkbook wb;

        try {
            wb = Workbook.createWorkbook(new File("G:\\ouputSach.xls"));
            WritableSheet sheet = wb.createSheet("Sach", 0);
            try {
                sheet.addCell(new jxl.write.Label(0, 0, "DANH SACH SACH"));
                sheet.addCell(new jxl.write.Label(0, 1, "Mã sách")); // cột 0 d
                sheet.addCell(new jxl.write.Label(1, 1, "Tên sách"));
                sheet.addCell(new jxl.write.Label(2, 1, "NXB"));
                sheet.addCell(new jxl.write.Label(3, 1, "Tác giả"));
                sheet.addCell(new jxl.write.Label(4, 1, "Thể loại"));
                sheet.addCell(new jxl.write.Label(5, 1, "Đơn giá"));
                sheet.addCell(new jxl.write.Label(6, 1, "Số lượng"));
                int rowBegin = 2;
                TableModel tableModel = tbSach.getModel();
                for (int row = rowBegin, i = 0; row < rowBegin + tbSach.getRowCount(); row++, i++) {
                    sheet.addCell(new jxl.write.Label(0, row, (String) tableModel.getValueAt(i, 0)));
                    sheet.addCell(new jxl.write.Label(1, row, (String) tableModel.getValueAt(i, 1)));
                    sheet.addCell(new jxl.write.Label(2, row, (String) tableModel.getValueAt(i, 2)));
                    sheet.addCell(new jxl.write.Label(3, row, (String) tableModel.getValueAt(i, 3)));
                    
                    sheet.addCell(new jxl.write.Label(4, row, (String) tableModel.getValueAt(i, 4)));
                    sheet.addCell(new jxl.write.Label(5, row, String.valueOf((float)tableModel.getValueAt(i, 5))));
                    sheet.addCell(new jxl.write.Label(6, row, String.valueOf((int) tableModel.getValueAt(i, 6))));

                }
                wb.write();
                wb.close();
                JOptionPane.showMessageDialog(null, "Write to excel success!");
            } catch (WriteException ex) {
                Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        //Hiển thị confirm
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Thông báo", OK_CANCEL_OPTION);
        String sql = "SELECT DISTINCT ctm.MaSachMuon FROM ChiTietMuon ctm WHERE ctm.MaSachMuon = '" + tfMaSach.getText().trim() + "'";
//Nếu chọn Yes
        if (confirm == JOptionPane.YES_OPTION) {

            try {
                st = DBConnect.getConnection().createStatement();
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Sách đang được mượn");
                } else {
                    Sach sach = new Sach(tfMaSach.getText());
                    boolean result = cSach.delete(sach);
                    if (result == true) {
                        JOptionPane.showMessageDialog(this, "Xóa sách thành công!");
                    }
                }

                clear();
                loadDataInTable();
            } catch (SQLException ex) {
                Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm dữ liệu ?", "Thêm sách", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {

            if (tfMaSach.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập mã sách");
                return;
            }
            if (tfTenSach.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập tên sách");
                return;
            }
            if (tfNhaXuatBan.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập nhà xuất bản");
                return;
            }
            if (tfDonGia.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập đơn giá");
                return;
            }
            if (tfSoLuong.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập số lượng");
                return;
            }

            String sql = "SELECT MaSach FROM Sach WHERE MaSach = '" + tfMaSach.getText() + "'";
            try {
                rs = st.executeQuery(sql);
            } catch (SQLException ex) {
                Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (!rs.next()) {
                    Sach s = new Sach();
                    s.setMaSach(tfMaSach.getText());
                    s.setTenSach(tfTenSach.getText());
                    s.setNxb(tfNhaXuatBan.getText());
                    s.setTacGia(tfTacGia.getText());
                    s.setTheLoai(tfTheLoai.getText());
                    s.setDonGia(Float.parseFloat(tfDonGia.getText()));
                    System.out.println(Float.parseFloat(tfDonGia.getText()));
                    s.setSoLuong(Integer.parseInt(tfSoLuong.getText()));
                    

                    boolean inS = cSach.insert(s);
                    if (inS) {
                        JOptionPane.showMessageDialog(this, "Thêm sách thành công!");
                    }
                    loadDataInTable();
                    
                }
                else{
                JOptionPane.showMessageDialog(null, "Mã sách đã tồn tại");
                }
                } catch (SQLException ex) {
                Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa dữ liệu ?", "Thêm sách", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            if (tfMaSach.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập mã sách");
                return;
            }

            Sach s = new Sach();
            s.setMaSach(tfMaSach.getText() != null ? tfMaSach.getText() : "");
            s.setTenSach(tfTenSach.getText() != null ? tfTenSach.getText() : "");
            s.setNxb(tfNhaXuatBan.getText() != null ? tfNhaXuatBan.getText() : "");
            s.setTacGia(tfTacGia.getText() != null ? tfTacGia.getText() : "");
            s.setTheLoai(tfTheLoai.getText() != null ? tfTheLoai.getText() : "");
            s.setDonGia(Float.parseFloat(tfDonGia.getText()));
            s.setSoLuong(Integer.parseInt(tfSoLuong.getText()));

            boolean inS = cSach.update(s);
            if (inS) {
                JOptionPane.showMessageDialog(this, "Sửa sách thành công!");
            }
            loadDataInTable();
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadDataInTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnThemTuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTuFileActionPerformed
        themFile();
    }//GEN-LAST:event_btnThemTuFileActionPerformed

    private void tbSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSachMouseClicked
        int i = tbSach.getSelectedRow();
        TableModel model = tbSach.getModel();
        tfMaSach.setText((String) model.getValueAt(i, 0));
        tfTenSach.setText((String) model.getValueAt(i, 1));
        tfNhaXuatBan.setText((String) model.getValueAt(i, 2));
        tfTacGia.setText((String) model.getValueAt(i, 3));
        tfTheLoai.setText((String) model.getValueAt(i, 4));
        tfDonGia.setText(((Float) model.getValueAt(i, 5)).toString());
        tfSoLuong.setText(((Integer) model.getValueAt(i, 6)).toString());
    }//GEN-LAST:event_tbSachMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        loadDateSearch();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void XuatPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XuatPDFActionPerformed
        String[] header = {"Mã sách", "Tên sách", "Nhà xuất bản", "Tác giả", "Thể loại", "Đơn giá", "Số lượng"};

        loadDateSearch();
        String[][] data = new String[sachList.size()][];
        String str = null;

        for (int i = 0; i < sachList.size(); i++) {
            //str = sachList.get(i).getMaSach() + "\t" + sachList.get(i).getTenSach() + "\t" + v sachList.get(i).getNxb()+ "\t" + sachList.get(i).getTacGia() + "\t" + sachList.get(i).getTheLoai() + "\t" + sachList.get(i).getDonGia() + "\t" + sachList.get(i).getSoLuong();
            str = sachList.get(i).getMaSach() + "\t" + sachList.get(i).getTenSach() + "\t" + sachList.get(i).getNxb() + "\t"
                    + sachList.get(i).getTacGia() + "\t" + sachList.get(i).getTheLoai() + "\t" + sachList.get(i).getDonGia() + "\t" + sachList.get(i).getSoLuong();
            data[i] = str.split("\t");
        }

        PrintPDF print = new PrintPDF();
        JFileChooser fc = new JFileChooser();
        int retirnval = fc.showSaveDialog(this);
        if (retirnval == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fc.getSelectedFile();
                print.printSearchReport(file.getPath(), "Sach", header, data, (String) cbbTimKiem.getSelectedItem(), tfTimKiem.getText(), "sách");

            } catch (IOException ex) {
                Logger.getLogger(GUIQuanLySach.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_XuatPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton XuatPDF;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemTuFile;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbTimKiem;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSach;
    private javax.swing.JTextField tfDonGia;
    private javax.swing.JTextField tfMaSach;
    private javax.swing.JTextField tfNhaXuatBan;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTacGia;
    private javax.swing.JTextField tfTenSach;
    private javax.swing.JTextField tfTheLoai;
    private javax.swing.JTextField tfTimKiem;
    // End of variables declaration//GEN-END:variables
}
