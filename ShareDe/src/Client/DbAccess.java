/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;
import Server.*;
import Data.TaiKhoan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author huyho
 */
public class DbAccess {
    private Connection conn;
    private Statement stmt;
    
    
    public DbAccess(){
        try{
            MyConnection mycon = new MyConnection();
            conn = mycon.getConnect();
            stmt = conn.createStatement();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
      
    
    public ResultSet Query(String str){
        try{
              ResultSet rs = stmt.executeQuery(str);
              return rs;
        }catch(Exception ex){
            return  null;
        }
    }
    
    
}
  
