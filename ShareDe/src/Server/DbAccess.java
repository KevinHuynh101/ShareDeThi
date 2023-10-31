/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;
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
    public static boolean DangNhap(String str) {
        boolean check = false;
        Connection connection = null;
        int id= 0;
        try {
  
        Connection conn = null;
        String[] arrStr = str.split("///");
        System.out.println( "\nUsername: " + arrStr[1] + "\nPassword: " + arrStr[2]);
        
        String name = arrStr[1];
        String pass = arrStr[2];
        String QueryStr = "select * from TAIKHOAN where EMAIL =N'"+name+"' and MATKHAU=N'"+pass+"'";
        DbAccess acc = new DbAccess();

        ResultSet rsl = acc.Query(QueryStr);
        while (rsl.next()) {                
                TaiKhoan std = new TaiKhoan(rsl.getInt("TAIKHOAN_ID"), 
                        rsl.getString("EMAIL"),rsl.getString("TEN"),rsl.getString("OTP") ,rsl.getString("MATKHAU"), 
                        rsl.getBoolean("GIOITINH"),rsl.getBoolean("PHANQUYEN"),rsl.getDate("NGAYSINH")
                        ,rsl.getDate("NGAYXACNHAN"));
               id = std.getTAIKHOAN_ID();
            }
        
        DbAccess.LuuId(id);
        ResultSet rs = acc.Query(QueryStr);
        System.out.println("rs = "+rs);
        if (rs.next()){
            check = true;
        }
        else{
            check = false;
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        System.out.println(check);
        return check;
    }
    
    
    public static void LuuId(int id){
        Connection connection = null;
        PreparedStatement statement = null;
          try {
            
             String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            System.out.println(URL);
            connection = DriverManager.getConnection(URL);
            String sql = "UPDATE BIN SET  ID_TAIKHOAN =N'"+id+"' WHERE ID = 1;";           
            statement = connection.prepareCall(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DbAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DbAccess.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DbAccess.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }      
    }
    
    
    
}
  
