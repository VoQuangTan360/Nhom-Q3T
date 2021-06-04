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
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 * Connection con = null;
    Statement st = null;
    ResultSet rs = null;
 * 
 *             int row =tblbangsach.getSelectedRow();
          String  co=(tblbangsach.getModel().getValueAt(row,0)).toString();
 */
public class capnhatsach {
    public static void delete (String mau){
           Connection con =ketnoisql1.dbketnoi();
        String sql="DELETE FROM sach where idSach = "+mau;
         
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
    public static void insert( String ts,String tg,String g){
        Connection con =ketnoisql1.dbketnoi();
        Statement st = null;
        ResultSet rs = null;
        String sql1 = "select * from sach";
        try {
            st =con.createStatement();
            rs =st.executeQuery(sql1);
            
            int demms=1;
            while(rs.next())
            {
             demms=rs.getInt("idSach")+1;
            }          
            int a=Integer.parseInt(g);
           String sql="Insert Into sach values(?,?,?,?)";     
           PreparedStatement pst =con.prepareStatement(sql);
           pst.setInt(1,demms);
           pst.setString(2,ts);
           pst.setString(3,tg);
           pst.setInt(4,a);
   
           int co=pst.executeUpdate();
 
            pst.close();
           con.close();
           st.close();
           rs.close();
        }catch(Exception ex){
         ex.printStackTrace();  
        }

    }

}
