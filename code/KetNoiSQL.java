/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class KetNoiSQL {

    Connection conn;

    public KetNoiSQL() {

        String url = "net.sourceforge.jtds.jdbc.Driver";
        try {

            Class.forName(url);

            String dbUrl = "jdbc:jtds:sqlserver://DESKTOP-V3I5LNT:1433/kt";

            conn = DriverManager.getConnection(dbUrl);

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {

            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
    public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
        }

        return null;
    }

    public void ExcuteQueryUpdateDB(String cauTruyVanSQL) {

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
        } catch (SQLException ex) {
        }
    }
    public boolean addtk(taikhoan s) {

        String sql = "INSERT INTO taikhoan(taiKhoan,matKhau)"
                + "VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getTaiKhoan());
            ps.setString(2, s.getMatKhau());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<taikhoan> getListtaikhoan() {
        ArrayList<taikhoan> list = new ArrayList<>();
        String sql = "SELECT * FROM taikhoan";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                taikhoan s = new taikhoan();
                s.setTaiKhoan(rs.getString("taiKhoan"));
                s.setMatKhau(rs.getString("matKhau"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
  