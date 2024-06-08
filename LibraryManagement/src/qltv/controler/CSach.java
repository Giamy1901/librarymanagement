package qltv.controler;

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
import javax.swing.JOptionPane;
import qltv.model.Sach;
import qltv.model.Sach;
import qltv.util.*;
import qltv.view.GUIQuanLySach;

public class CSach {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public CSach() {
        con = DBConnect.getConnection();
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CSach.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    // Lấy ra toàn bộ DS Sach
    public List<Sach> selectAll() {
        try {
            con = DBConnect.getConnection();
            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM Sach;");
            List<Sach> sachList = new ArrayList<Sach>();
            while (rs.next()) {
                Sach sach = new Sach();
                sach.setMaSach(rs.getString("MaSach"));
                sach.setTenSach(rs.getString("TenSach"));
                sach.setNxb(rs.getString("NXB"));
                sach.setTacGia(rs.getString("TacGia"));
                sach.setTheLoai(rs.getString("TheLoai"));
                sach.setDonGia(rs.getFloat("DonGia"));
                sach.setSoLuong(rs.getInt("SoLuong"));

                sachList.add(sach);
            }

            return sachList;
        } catch (SQLException ex) {
            Logger.getLogger(CSach.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return null;

    }

    // Lấy ra DS Sach khi tìm kiếm
    // columName = {ma, ten, dia chi, so dien thoai, gioi tinh}
    public List<Sach> search(Sach sach, String columnName) throws SQLException {
        try {
            String sql = "SELECT * FROM Sach WHERE 1 = 1 ";
            switch (columnName) {
                case "Mã sách": {
                    sql += " AND MaSach LIKE N'%" + sach.getMaSach() + "%';";

                    break;
                }

                case "Tên sách": {
                    sql += " AND TenSach LIKE N'%" + sach.getTenSach() + "%';";

                    break;
                }
                case "Nhà xuất bản": {
                    sql += " AND NXB LIKE N'%" + sach.getNxb() + "%';";
                    break;
                }
                case "Tác giả": {
                    sql += " AND TacGia LIKE N'%" + sach.getTacGia() + "%';";
                    break;
                }
                case "Thể loại": {
                    sql += " AND TheLoai LIKE N'%" + sach.getTheLoai() + "%';";
                    break;
                }

                case "None": {
                    break;
                }
            }
            System.out.println(sql);
            rs = st.executeQuery(sql);

            List<Sach> sachList = new ArrayList<Sach>();
            while (rs.next()) {
                Sach s = new Sach();

                s.setMaSach(rs.getString("MaSach"));
                s.setTenSach(rs.getString("TenSach"));
                s.setNxb(rs.getString("NXB"));
                s.setTacGia(rs.getString("TacGia"));
                s.setTheLoai(rs.getString("TheLoai"));
                s.setDonGia(rs.getFloat("DonGia"));
                s.setSoLuong(rs.getInt("SoLuong"));

                sachList.add(s);
            }

            return sachList;
        } catch (SQLException ex) {
            Logger.getLogger(CSach.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return null;

    }

    // Insert Sach
    public boolean insert(Sach sach) {

        try {
            String sql = "INSERT INTO Sach(MaSach, TenSach, NXB, TacGia, TheLoai, DonGia, SoLuong) VALUES(?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, sach.getMaSach());
            ps.setString(2, sach.getTenSach());
            ps.setString(3, sach.getNxb());
            ps.setString(4, sach.getTacGia());
            ps.setString(5, sach.getTheLoai());
            ps.setFloat(6, sach.getDonGia());
            ps.setInt(7, sach.getSoLuong());

            System.out.println(sql);
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CSach.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

// update DL
    public boolean update(Sach sach) {
        try {
            String sql = "UPDATE Sach SET TenSach = ?, NXB = ?, TacGia = ?, TheLoai = ?, DonGia = ?, SoLuong = ? WHERE MaSach = ? ";

            ps = con.prepareStatement(sql);

            ps.setString(1, sach.getTenSach());
            ps.setString(2, sach.getNxb());
            ps.setString(3, sach.getTacGia());
            ps.setString(4, sach.getTheLoai());
            ps.setFloat(5, sach.getDonGia());
            ps.setInt(6, sach.getSoLuong());
            ps.setString(7, sach.getMaSach());

            System.out.println(sql);
            return ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CSach.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;

    }

    // Xóa
    public boolean delete(Sach sach) {

        try {
            String sql = "DELETE FROM Sach WHERE MaSach = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, sach.getMaSach());

            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CSach.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Xóa sách không thành công!");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GUIQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }


}
