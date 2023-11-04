/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;
import Client.formThongKe;
import Data.Bin;
import Data.TaiKhoan;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author huyho
 */
public class DbAccess {
    private Connection conn;
    private Statement stmt;
    private static final int KEY_LENGTH = 256;
    private static final int ITERATION_COUNT = 65536;
    String secretKey = "huynhnam";
    String salt = "nhuhuynh";
    
    public DbAccess(){
        try{
            MyConnection mycon = new MyConnection();
            conn = mycon.getConnect();
            stmt = conn.createStatement();
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
//       String decryptedString = DbAccess.decrypt(secretKey, secretKey, salt);
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
        String matkhau = null;
        int block = 0;
        try {
        Connection conn = null;
        String[] arrStr = str.split("///");
//        System.out.println( "\nid_taikhoan: " + arrStr[1]);       
        String id_TaiKhoan = arrStr[1];
        String QueryStr = "select * from TAIKHOAN where TAIKHOAN_ID = '"+id_TaiKhoan+"'";
        DbAccess acc = new DbAccess();

        ResultSet rsl = acc.Query(QueryStr);
        while (rsl.next()) {                
                TaiKhoan std = new TaiKhoan(rsl.getInt("TAIKHOAN_ID"),rsl.getInt("BLOCK"),rsl.getInt("BLOCKTAODE"),rsl.getInt("BLOCKTHI"),
                        rsl.getString("EMAIL"),rsl.getString("TEN"),rsl.getString("OTP") ,rsl.getString("MATKHAU"), 
                        rsl.getBoolean("GIOITINH"),rsl.getBoolean("PHANQUYEN"),rsl.getDate("NGAYSINH")
                        ,rsl.getDate("NGAYXACNHAN"));
               block = std.getBLOCK();

            }

        if (block == 1){
            check = true;
        }
        else{
            check = false;
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
//        System.out.println(check);
        return check;
    }
    
    
    public static void LuuId(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        String matkhau ;
          try {
            
             String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
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
    public static boolean CheckBlockAdd(String str) {
   
        boolean check = false;
        Connection connection = null;
        String matkhau = null;
        int block = 0;
        try {
        Connection conn = null;
        String[] arrStr = str.split("///");
//        System.out.println( "\nid_taikhoan: " + arrStr[1]);       
        String id_TaiKhoan = arrStr[1];
        String QueryStr = "select * from TAIKHOAN where TAIKHOAN_ID = '"+id_TaiKhoan+"'";
        DbAccess acc = new DbAccess();

        ResultSet rsl = acc.Query(QueryStr);
        while (rsl.next()) {                
                TaiKhoan std = new TaiKhoan(rsl.getInt("TAIKHOAN_ID"),rsl.getInt("BLOCK"),rsl.getInt("BLOCKTAODE"),rsl.getInt("BLOCKTHI"),
                        rsl.getString("EMAIL"),rsl.getString("TEN"),rsl.getString("OTP") ,rsl.getString("MATKHAU"), 
                        rsl.getBoolean("GIOITINH"),rsl.getBoolean("PHANQUYEN"),rsl.getDate("NGAYSINH")
                        ,rsl.getDate("NGAYXACNHAN"));
               block = std.getBLOCKTAODE();

            }

        if (block == 1){
            check = true;
        }
        else{
            check = false;
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return check;
    }
    public static boolean CheckBlockThi(String str) {
   
        boolean check = false;
        Connection connection = null;
        String matkhau = null;
        int block = 0;
        try {
        Connection conn = null;
        String[] arrStr = str.split("///");
//        System.out.println( "\nid_taikhoan: " + arrStr[1]);       
        String id_TaiKhoan = arrStr[1];
        String QueryStr = "select * from TAIKHOAN where TAIKHOAN_ID = '"+id_TaiKhoan+"'";
        DbAccess acc = new DbAccess();

        ResultSet rsl = acc.Query(QueryStr);
        while (rsl.next()) {                
                TaiKhoan std = new TaiKhoan(rsl.getInt("TAIKHOAN_ID"),rsl.getInt("BLOCK"),rsl.getInt("BLOCKTAODE"),rsl.getInt("BLOCKTHI"),
                        rsl.getString("EMAIL"),rsl.getString("TEN"),rsl.getString("OTP") ,rsl.getString("MATKHAU"), 
                        rsl.getBoolean("GIOITINH"),rsl.getBoolean("PHANQUYEN"),rsl.getDate("NGAYSINH")
                        ,rsl.getDate("NGAYXACNHAN"));
               block = std.getBLOCKTAODE();

            }

        if (block == 1){
            check = true;
        }
        else{
            check = false;
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 

        return check;
    }
    public static String CountChuDe(){
        Connection connection = null;
        Statement statement = null;
        String std = null;
//        String bode = (String) cbBoDe4.getSelectedItem();
             try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            connection = DriverManager.getConnection(URL);
            String sql = "SELECT  COUNT(CHUDE_ID) AS COUNTCD FROM CHUDE ;";
            statement = connection.createStatement();           
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                 std = resultSet.getString("COUNTCD");
               
            }
                 System.out.println("Tổng số đề tài: "+std);
            
        } catch (SQLException ex) {
            Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return std;
        
    }
    public static String CountCauHoi(){
        Connection connection = null;
        Statement statement = null;
        String std = null;
             try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            connection = DriverManager.getConnection(URL);
            String sql = "SELECT  COUNT(BODE_ID) AS COUNTBD FROM BODE ;";
            statement = connection.createStatement();           
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                 std = resultSet.getString("COUNTBD");
               
            }
                 System.out.println("Tổng số câu hỏi :" +std);
//            btnCountCauHoi.setText(std);
        } catch (SQLException ex) {
            Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
             return std;
        
    }
    public static String TaiKhoanMax (String bode){
        Connection connection = null;
        Statement statement = null;
        List<String> listTen = new ArrayList<>();
//        System.out.println("bode"+bode);
        String name = "";
//        String bode = (String) cbBoDe5.getSelectedItem();
             try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            connection = DriverManager.getConnection(URL);
            String sql = "WITH RankedScores AS (\n" +
"    SELECT TAIKHOAN.TEN, SCORE.SCORE,\n" +
"           DENSE_RANK() OVER (ORDER BY SCORE.SCORE DESC) AS Rank\n" +
"    FROM SCORE\n" +
"    JOIN CHUDE ON SCORE.CHUDE_ID = CHUDE.CHUDE_ID\n" +
"    JOIN TAIKHOAN ON SCORE.TAIKHOAN_ID = TAIKHOAN.TAIKHOAN_ID\n" +
"    WHERE CHUDE.TENCHUDE =  N'"+bode+"'\n" +
")\n" +
"SELECT TEN\n" +
"FROM RankedScores\n" +
"WHERE Rank <= 1;";
            
            statement = connection.createStatement();           
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                   name += resultSet.getString("TEN");
                   
//                  listTen.add(name);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
        
        }
             System.out.println("Tài khoản có diểm số cao nhất "+name);
        return name;
    }
    public static String AvgScore (String bode){
                Connection connection = null;
        Statement statement = null;
        String std = null;
//        String bode = (String) cbBoDe2.getSelectedItem();
             try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            connection = DriverManager.getConnection(URL);
            String sql = "SELECT AVG(SCORE.SCORE) AS AVGDIEM FROM SCORE JOIN CHUDE ON SCORE.CHUDE_ID=CHUDE.CHUDE_ID WHERE CHUDE.TENCHUDE = N'"+bode+"'";
            statement = connection.createStatement();           
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                 std = resultSet.getString("AVGDIEM");
               
            }
                 System.out.println("Avgscore :"+std);
//            lbDiemTrungBinh.setText(std);
        } catch (SQLException ex) {
            Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
             return std;
    }
    public static String MaxScore (String bode){
        Connection connection = null;
        Statement statement = null;
        String std = null;
//        String bode = (String) cbBoDe.getSelectedItem();
             try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            connection = DriverManager.getConnection(URL);
            String sql = "SELECT MAX(SCORE.SCORE) AS MAXDIEM FROM SCORE JOIN CHUDE ON SCORE.CHUDE_ID=CHUDE.CHUDE_ID WHERE CHUDE.TENCHUDE = N'"+bode+"'";
            statement = connection.createStatement();           
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                 std = resultSet.getString("MAXDIEM");
            }
                 System.out.println("MaxScore :"+std);
//            lbDiemCaoNhat.setText(std);
        } catch (SQLException ex) {
            Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
             return std;
    }
    public static String CountSoNguoiLamDe (String bode){
                       Connection connection = null;
        Statement statement = null;
        String std = null;
//        String bode = (String) cbBoDe3.getSelectedItem();
             try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            connection = DriverManager.getConnection(URL);
            String sql = "SELECT  COUNT(DISTINCT SCORE.TAIKHOAN_ID) AS COUNT FROM SCORE JOIN CHUDE ON SCORE.CHUDE_ID=CHUDE.CHUDE_ID WHERE CHUDE.TENCHUDE = N'"+bode+"' GROUP BY SCORE.CHUDE_ID  ;";
            statement = connection.createStatement();           
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                 std = resultSet.getString("COUNT");
               
            }
                 System.out.println("Số người làm bộ đề "+bode+" là "+std);
//            lbCount.setText(std);
        } catch (SQLException ex) {
            Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
             return std;
    }
    public static String CountDeDuocLam (String bode){
                Connection connection = null;
        Statement statement = null;
        String std = null;
//        String bode = (String) cbBoDe4.getSelectedItem();
             try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            connection = DriverManager.getConnection(URL);
            String sql = "SELECT  COUNT(SCORE.TAIKHOAN_ID) AS COUNT FROM SCORE JOIN CHUDE ON SCORE.CHUDE_ID=CHUDE.CHUDE_ID WHERE CHUDE.TENCHUDE = N'"+bode+"' GROUP BY SCORE.CHUDE_ID  ;";
            statement = connection.createStatement();           
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                 std = resultSet.getString("COUNT");
               
            }
                 System.out.println("Số lần bộ đề "+bode+" đã được làm :"+std);
//            lbCount1.setText(std);
        } catch (SQLException ex) {
            Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
             return std;
    }
    public static String CountTaiKhoan(){
        Connection connection = null;
        Statement statement = null;
        String std = null;
             try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            connection = DriverManager.getConnection(URL);
            String sql = "SELECT  COUNT(TAIKHOAN_ID) AS COUNTTK FROM TAIKHOAN ;";
            statement = connection.createStatement();           
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                 std = resultSet.getString("COUNTTK");
               
            }
                 System.out.println("Số lượng người dùng :"+std);
//            btnCountCauHoi.setText(std);
        } catch (SQLException ex) {
            Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(formThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
             return std;
    }
        public static String getAllCauHoi(String id_chude,String socauhoi) {
         int id_ChuDe = Integer.parseInt(id_chude);
        String str = "";
        int[] soCau = new int[40];
//        System.out.println("id_ChuDE:"+id_ChuDe);
        int soCauHoi = Integer.parseInt(socauhoi);
        Arrays.fill(soCau, 0);// tạo một danh sách câu hỏi có độ dài 32, ác câu hỏi đều chưa được chọn (0)
        String sql = "SELECT * FROM BODE WHERE CHUDE_ID = '"+id_ChuDe+"'";
        Random rand = new Random();
        int dem = 0;//đếm số lượng câu hỏi đã được chọn.
        while (dem < soCauHoi+1) {//chọn đủ 10 câu hỏi.
            int k = rand.nextInt(21);//random 0-10
            if (soCau[k] != 1) {
                soCau[k] = 1;//k là đã được chọn bằng cách gán giá trị 1 
                dem++;//thêm một câu hỏi.
            }
        }
         dem = -1;
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
            } catch (SQLException ex) {
            Logger.getLogger(DbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;

    }
    
}
  
