/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;
import Data.TaiKhoan;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
                TaiKhoan std = new TaiKhoan(rsl.getInt("TAIKHOAN_ID"),rsl.getInt("BLOCK"),rsl.getInt("BLOCKTAODE"),rsl.getInt("BLOCKTHI"),
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
    public static String getAllCauHoi() {
        int[] soCau = new int[40];
        Connection connection = null;
        PreparedStatement statement = null;
        Arrays.fill(soCau, 0);
        String sql = "SELECT * FROM BODE";
        Random rand = new Random();
        int dem = 0;
        while (dem < 10) {
//            int k = 32;
            int k = rand.nextInt(32);
            if (soCau[k] != 1) {
                soCau[k] = 1;
                dem++;
            }
        }
        dem = -1;
        String str = "";
        try {
        DbAccess acc = new DbAccess();

        ResultSet rs = acc.Query(sql);
            while (rs.next()) {
                dem++;
                if (soCau[dem] > 0) {
                    str += rs.getString("BODE_ID");
                    str += "///";
                    str += rs.getString("CHUDE_ID");
                    str += "///";
                    str += rs.getString("NOIDUNG");
                    str += "///";
                    str += rs.getString("A");
                    str += "///";
                    str += rs.getString("B");
                    str += "///";
                    str += rs.getString("C");
                    str += "///";
                    str += rs.getString("D");
                    str += "///";
                    str += rs.getString("DAP_AN");
                    str += "///";
                }
            }
            System.out.println(str);
        } catch (SQLException ex) {
            Logger.getLogger(DbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }
    
    
    
}
  
