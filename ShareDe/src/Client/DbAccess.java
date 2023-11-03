/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;
import Data.CauHoi;
import Data.ChuDe;
import Server.*;
import Data.TaiKhoan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


//client
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
     public static List<ChuDe> findChuDe() {
        List<ChuDe> ChuDetList = new ArrayList<>();
         Connection connection = null;
        Statement statement = null;
        try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
//            System.out.println(URL);
            connection = DriverManager.getConnection(URL);
            String sql = "select * from CHUDE;";
            
            statement = connection.createStatement();           
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                ChuDe std = new ChuDe(resultSet.getInt("CHUDE_ID"),resultSet.getInt("SOCAUHOI"), resultSet.getInt("TIME")
                        ,resultSet.getInt("TAIKHOAN_ID"),resultSet.getString("TENCHUDE"),
                        resultSet.getString("LOP_ID"));
                ChuDetList.add(std);
            }
        }catch (SQLException ex) {
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
         return ChuDetList;
    }
     
         public static List<String> findPhongThi() {
        List<String> phongthilist = new ArrayList<>();
         Connection connection = null;
        Statement statement = null;
        try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            connection = DriverManager.getConnection(URL);
            String sql = "select * from LOP ";
            
            statement = connection.createStatement();           
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                String std = resultSet.getString("LOP_ID");
                phongthilist.add(std);
            }
        }catch (SQLException ex) {
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
         return phongthilist;
    }
    
     public static List<CauHoi> findCauHoi() {
        List<CauHoi> CauHoitList = new ArrayList<>();
         Connection connection = null;
        Statement statement = null;
        try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
//            System.out.println(URL);
            connection = DriverManager.getConnection(URL);
            String sql = "SELECT BODE.BODE_ID,BODE.CHUDE_ID,BODE.NOIDUNG,BODE.A,BODE.B,BODE.C,BODE.D,BODE.DAP_AN\n" +
                          "FROM BODE\n" +
                          "INNER JOIN CHUDE ON BODE.CHUDE_ID=CHUDE.CHUDE_ID\n" +
                          "WHERE CHUDE.CHUDE_ID = 1";
            
            statement = connection.createStatement();           
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                CauHoi std = new CauHoi(resultSet.getInt("BODE_ID"),resultSet.getInt("CHUDE_ID"), resultSet.getString("NOIDUNG")
                        ,resultSet.getString("A"),resultSet.getString("B"),
                        resultSet.getString("C"),resultSet.getString("D"),resultSet.getString("DAP_AN"));
                CauHoitList.add(std);
            }
        }catch (SQLException ex) {
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
         return CauHoitList;
    }
     
     public static List<String> findTenBoDe() {
        List<String> studentList = new ArrayList<>();
         Connection connection = null;
        Statement statement = null;
        try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            connection = DriverManager.getConnection(URL);
            String sql = "select * from CHUDE ";
            
            statement = connection.createStatement();           
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(resultSet);
            
            while (resultSet.next()) {                
                String std = resultSet.getString("TENCHUDE");
                studentList.add(std);
            }
        }catch (SQLException ex) {
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
        //ket thuc.
         return studentList;
    }
    
    
}
  
