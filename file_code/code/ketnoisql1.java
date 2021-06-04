package code;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ketnoisql1 {
 Connection db;  
 public static Connection dbketnoi(){
    Connection con = null;
    try {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String connectionUrl="jdbc:jtds:sqlserver://DESKTOP-V3I5LNT:1433/kt";
        con=DriverManager.getConnection(connectionUrl);
    }
    catch (Exception ex) {
        ex.printStackTrace();  
    }
     return con;
}
    public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL) {
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
        }

        return null;
    }

    public void ExcuteQueryUpdateDB(String cauTruyVanSQL) {

        try {
            Statement stmt = db.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
        } catch (SQLException ex) {
        }
    }
}
