/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class nhanvien {
    public static void insert(String tk,String mk,String luong){
        int l=Integer.parseInt(luong);
     Connection con =ketnoisql1.dbketnoi();
        Statement st = null;
        ResultSet rs = null;
        String sql1 = "select * from nhanvien";
        try {
            st =con.createStatement();
            rs =st.executeQuery(sql1);
            
            int demms=1;
            while(rs.next())
            {
             demms=rs.getInt("maNV")+1;
            }
            

           String sql="Insert Into nhanvien values(?,?,?,?)";     
           PreparedStatement pst =con.prepareStatement(sql);
           pst.setInt(1,demms);
           pst.setString(2,tk);
           pst.setString(3,mk);
           pst.setString(4,luong);
 
   
           int co=pst.executeUpdate();
 
            pst.close();
           con.close();
           st.close();
           rs.close();
        }catch(Exception ex){
         ex.printStackTrace();  
        }

    }
    public static void delete (String mau){
           Connection con =ketnoisql1.dbketnoi();
        String sql="DELETE FROM nhanvien where maNV = "+mau;
         
        try{
        PreparedStatement pst =con.prepareStatement(sql);
        pst.executeUpdate();
        pst.close();
        con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
