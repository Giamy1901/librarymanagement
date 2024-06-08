package qltv.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class GUIMain extends javax.swing.JFrame {

    GUIQuanLyDocGia qldg;
    GUIQuanLySach qls;
    GUIQuanLyMuonTra qlmt;
    GUIThongKeBaoCao tkbc;

    public GUIMain() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(GUIMain.class.getResource("/qltv/image/unnamed.png")));
    	setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        
        qldg = new GUIQuanLyDocGia();
        qls = new GUIQuanLySach();
        qlmt = new GUIQuanLyMuonTra();
        tkbc = new GUIThongKeBaoCao();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelChinh = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setVerticalAlignment(SwingConstants.TOP);
        jPanel3 = new javax.swing.JPanel();
        setTitle("QUẢN LÝ THƯ VIỆN");
        setPreferredSize(new Dimension(1020, 679));

        jPanel1.setBackground(new Color(0, 0, 108));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); 
        jLabel1.setForeground(new Color(244, 240, 70));
        jLabel1.setText("TRƯỜNG ĐẠI HỌC GIAO THÔNG VẬN TẢI PHÂN HIỆU TP.HCM");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18));
        jLabel2.setForeground(new Color(255, 241, 217));
        jLabel2.setText("THƯ VIỆN UTC2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(152)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(442)
        					.addComponent(jLabel2)))
        			.addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(6)
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel2)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);
        panelChinh.setLayout(new BoxLayout(panelChinh, BoxLayout.X_AXIS));

        jLabel4.setIcon(new ImageIcon(GUIMain.class.getResource("/qltv/image/trangchu2.jpg"))); // NOI18N
        panelChinh.add(jLabel4);
        
        jPanel1_1 = new JPanel();
        jPanel1_1.setBackground(new Color(0, 0, 108));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panelChinh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        					.addComponent(jPanel1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jPanel3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1007, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panelChinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel1_1, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
        );
        jPanel1_1.setLayout(new BoxLayout(jPanel1_1, BoxLayout.X_AXIS));
        btnQLDG = new javax.swing.JButton();
        btnQLDG.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnQLDG.setIcon(new ImageIcon(GUIMain.class.getResource("/qltv/image/1.png")));
        
                btnQLDG.setFont(new java.awt.Font("Dialog", 0, 14));
                btnQLDG.setText("Quản lý độc giả");
                btnQLDG.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                btnQLDG.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnQLDGActionPerformed(evt);
                    }
                });
                jPanel3.setLayout(new GridLayout(0, 4, 0, 0));
                jPanel3.add(btnQLDG);
        btnQLS = new javax.swing.JButton();
        btnQLS.setIcon(new ImageIcon(GUIMain.class.getResource("/qltv/image/2.png")));
        
                btnQLS.setFont(new java.awt.Font("Dialog", 0, 14));
                btnQLS.setText("Quản lý sách");
                btnQLS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                btnQLS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                btnQLS.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnQLSActionPerformed(evt);
                    }
                });
                jPanel3.add(btnQLS);
        btnQLMT = new javax.swing.JButton();
        btnQLMT.setIcon(new ImageIcon(GUIMain.class.getResource("/qltv/image/4.png")));
        
                btnQLMT.setFont(new java.awt.Font("Dialog", 0, 14));
                btnQLMT.setText("Quản lý mượn trả");
                btnQLMT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                btnQLMT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                btnQLMT.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnQLMTActionPerformed(evt);
                    }
                });
                jPanel3.add(btnQLMT);
        btnTKBC = new javax.swing.JButton();
        btnTKBC.setIcon(new ImageIcon(GUIMain.class.getResource("/qltv/image/3.png")));
        
                btnTKBC.setFont(new java.awt.Font("Dialog", 0, 14));
                btnTKBC.setText("Thống kê - báo cáo");
                btnTKBC.setToolTipText("");
                btnTKBC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                btnTKBC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                btnTKBC.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnTKBCActionPerformed(evt);
                    }
                });
                jPanel3.add(btnTKBC);
        getContentPane().setLayout(layout);

        pack();
    }

    private void btnQLDGActionPerformed(java.awt.event.ActionEvent evt) {
        panelChinh.removeAll();
        panelChinh.add(qldg, BorderLayout.CENTER);
        panelChinh.updateUI();
    }

    private void btnQLSActionPerformed(java.awt.event.ActionEvent evt) {
        panelChinh.removeAll();
        panelChinh.add(qls, BorderLayout.CENTER);
        panelChinh.updateUI();
    }

    private void btnQLMTActionPerformed(java.awt.event.ActionEvent evt) {
        panelChinh.removeAll();
        panelChinh.add(qlmt, BorderLayout.CENTER);
        panelChinh.updateUI();
    }

    private void btnTKBCActionPerformed(java.awt.event.ActionEvent evt) {
        panelChinh.removeAll();
        panelChinh.add(tkbc, BorderLayout.CENTER);
        panelChinh.updateUI();
    }

    
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIMain main = new GUIMain();
                main.setLocationRelativeTo(null);
                main.setVisible(true);
                main.setVisible(true);

            }
        });
    }

    private javax.swing.JButton btnQLDG;
    private javax.swing.JButton btnQLMT;
    private javax.swing.JButton btnQLS;
    private javax.swing.JButton btnTKBC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelChinh;
    private JPanel jPanel1_1;
}
