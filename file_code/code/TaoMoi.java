/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import newpackage.DangNhap;
import newpackage.MuaSach;

/**
 *
 * @author Admin
 */
public class TaoMoi {
    public static  MuaSach frmTC=new MuaSach();
     public static code.KetNoiSQL connection = new  code.KetNoiSQL();
     public static void main(String[] args) {
         DangNhap DN= new  DangNhap();
       DN.show();
    }
}
