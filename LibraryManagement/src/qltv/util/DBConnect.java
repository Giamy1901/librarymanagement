package qltv.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class DBConnect {

    private static final String url = "jdbc:sqlserver://localhost:1433;encrypt=true;databaseName=Quan_Ly_Thu_Vien;;encrypt=true;trustServerCertificate=true;";
    private static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String username = "sa";
    private static final String password = "yennhi0710";
    private static Connection con;
    DefaultTableModel dm = new DefaultTableModel();
    
    
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);  // Đăng ký trình điều khiển
            try {
                
                con = DriverManager.getConnection(url, username, password); // Kết nối CSDL
                System.out.println("Success ");

            } catch (Exception ex) {
            	ex.printStackTrace();
                System.out.println("Failed to create the database connection.");
            }

        } catch (ClassNotFoundException ex) {
            ex.getMessage();
            System.out.println("Driver not found.");
            return null;
        }
        return con;
    }
    
    public static void main(String[] args) {
        getConnection();
    }

    // Đóng kết nối
    public static void close() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public  void updateTable(JTable table, String sql){
        try {
            DBConnect.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void excuteQuery(String sql, String message) throws SQLException {
        Connection connection = DBConnect.getConnection();
        Statement st = null;
        try {
            st = connection.createStatement();
            if ((st.executeUpdate(sql)) > 0) {
                JOptionPane.showMessageDialog(null, message + " success");
            } else {
                JOptionPane.showMessageDialog(null, message + " dont success");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        st.close();
        connection.close();

    }
    public static Vector<String> select(String table, String[] key) {
        ResultSet rs = null;
        Vector<String> vector = new Vector<String>(100);
        String sqlcommand = "select * " + " from " + table ;
        PreparedStatement pst = null;
        if (key == null) {
            sqlcommand = "SELECT * FROM " + table ;
        } else {
               sqlcommand = "SELECT * FROM " + table + " WHERE ";
            for (int i = 0; i < key.length; i++) {
                sqlcommand = sqlcommand + key[i];
                if (i < key.length - 1) {
                    sqlcommand += " AND ";
                }
            }
            sqlcommand = sqlcommand + " ;";
        }
        try {
            pst = con.prepareStatement(sqlcommand);
            rs = pst.executeQuery();

            switch (table) {
                case "DocGia":
                    while (rs.next()) {

                        vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
                                + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7));
                    }
                case "Sach":
                    while (rs.next()) {

                        vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
                                + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7));
                    }
                case "MuonTra":
                    while (rs.next()) {

                        vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t"
                                + rs.getString(5)  + "\t" + rs.getString(6) + "\t" + rs.getString(7) + "\t" + rs.getString(8));
                    }
                case "ChiTietMuon":
                    while (rs.next()) {

                        vector.add(rs.getString(1) + "\t" + rs.getString(2));
                    }

            }
        } catch (SQLException ex) {
            System.out.println("Select error !" + ex.toString());
        }

        return vector;
    }
    
    // Thực hiện truy vấn khi tìm kiếm
    public static Vector<String> selectLike(String table, String key, String textField) {
        ResultSet rs = null;
        Vector<String> vector = new Vector<String>(100);
        String sqlcommand = "select * " + " from " + table ;
        PreparedStatement pst = null;
        if (key == null) {
            sqlcommand = "SELECT * FROM " + table ;
        } else {
               sqlcommand = "SELECT * FROM " + table + " WHERE " + key + " LIKE N'%" + textField + "%' ;";
               System.out.println(sqlcommand);
           
        }
        try {
            pst = con.prepareStatement(sqlcommand);
            rs = pst.executeQuery();

            switch (table) {
                case "DocGia":
                    while (rs.next()) {

                        vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
                                + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7));
                    }
                case "Sach":
                    while (rs.next()) {

                        vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
                                + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7));
                    }
                case "MuonTra":
                    while (rs.next()) {

                        vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t"
                                + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) + "\t" + rs.getString(8));
                    }
                case "ChiTietMuonTra":
                    while (rs.next()) {

                        vector.add(rs.getString(1) + "\t" + rs.getString(2) );
                    }

            }
        } catch (SQLException ex) {
            System.out.println("Select error !" + ex.toString());
        }

        return vector;
    }
    
    // insert data into table in SQL Server
    public boolean insert(String table, String[] values) {

        try {
            
            String sqlcommand = "INSERT INTO " + table;
            PreparedStatement pst = null;

            if (table.equals("DocGia")) {
                sqlcommand = sqlcommand + " VALUES(" + "'" + values[0] + "',N'" + values[1] + "','" + values[2] + "','" + values[3]
                                + "',N'"+ values[4] + "','" + values[5] + "','" + values[6] + "');";
            } else if (table.equals("Sach")) {
                sqlcommand = sqlcommand + " VALUES(" + "'" + values[0] + "',N'" + values[1] + "',N'" + values[2] + "',N'" + values[3] 
                        + "',N'" + values[4] + "','" + values[5] + "','" + values[6] +  "');";
            } else if (table.equals("MuonTra")) {
                sqlcommand = sqlcommand + " values (" + "'" + values[0] + "','" + values[1] + "','" + values[2] + "','" + values[3] + 
                        "','" + values[4] + "','" + values[5] + "','" + values[6] + "');";
            } else if (table.equals("ChiTietMuonTra")) {
                sqlcommand = sqlcommand + table + " values (" + "'" + values[0] + "','" + values[1] + "','" + values[2] + "');";
            } 
           // System.out.println(sqlcommand);
            pst = con.prepareStatement(sqlcommand);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    // delete column data into table in SQL Server
     public boolean delete(String table, String columnName, String key) {
        try {
            
            String sqlcommand = " delete from " + table + " where " + columnName + " ='"  +key+ "';";
            PreparedStatement pst = null;
            //System.out.println(sqlcommand);
            
            pst = con.prepareStatement(sqlcommand);
            pst.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

     // update data in table with record have columnname = key
    
    public boolean update(String table, String[] values, String key) {
        try {
           
            String sqlcommand = " update " + table + " set ";
            PreparedStatement pst = null;
                  
            for (int i = 0; i < values.length; i++) {
                sqlcommand += values[i];
                if (i < values.length - 1) {
                  sqlcommand += ",";
                }
            }
            sqlcommand += " where " + key +";";
            System.out.println(sqlcommand);
            
            pst = con.prepareStatement(sqlcommand);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    

}
