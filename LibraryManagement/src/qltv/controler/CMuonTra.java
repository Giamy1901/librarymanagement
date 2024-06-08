package qltv.controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import qltv.model.MuonTra;
import qltv.util.DBConnect;

public class CMuonTra {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public CMuonTra() {
        con = DBConnect.getConnection();
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// Xóa MuonTra
    public boolean deleteMuonTra(MuonTra mt) {
        try {
            String sql = "DELETE FROM MuonTra WHERE MaMuon = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, mt.getMaMuon());
            
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // Xóa ChiTietMuon
    public boolean deleteChiTietMuon(MuonTra mt) {
        try {
            String sql = "DELETE FROM ChiTietMuon WHERE MaMuon = ?";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, mt.getMaMuon());
            
            
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

}
