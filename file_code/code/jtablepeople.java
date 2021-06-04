/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class jtablepeople {
        public static void update(String tk,String ht,String sdt,String dc,int id){
         Connection con =ketnoisql1.dbketnoi();
         int co=0;    
        Statement st = null;
        ResultSet rs = null;
        String sqlkt ="select * from thongtin";
            try {
                st =con.createStatement();
                rs =st.executeQuery(sqlkt);
                while(rs.next()){
                    if(rs.getInt("idTaiKhoan")==(id)){
                        co=1;
                        String sqlud="update thongtin set HoTen=?,SDT=?,diaChi=? where idTaiKhoan=?";
       
                        PreparedStatement pst =con.prepareStatement(sqlud);
                        pst.setString(1,ht);
                        pst.setString(2,sdt);
                        pst.setString(3,dc);
                        pst.setInt(4,id);
                        int co1=pst.executeUpdate();
                       
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(jtablepeople.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(co==0){
         String sql="insert into  thongtin values(?,?,?,?)";
        try {
            PreparedStatement pst =con.prepareStatement(sql);
    
            pst.setInt(1,id);
            pst.setString(2,ht);
            pst.setString(3,sdt);
            pst.setString(4,dc);
            int i = pst.executeUpdate();
            System.out.println(i);
            con.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(jtablepeople.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            }
            
    }
}
