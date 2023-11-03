/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;
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
        int id= 0;
        String matkhau = null;
        String decryptedString = null;
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
               matkhau = std.getMATKHAU();
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

    public  String decrypt(String strToDecrypt, String secretKey, String salt) {

    try {

        byte[] encryptedData = Base64.getDecoder().decode(strToDecrypt);
        byte[] iv = new byte[16];
        System.arraycopy(encryptedData, 0, iv, 0, iv.length);
        IvParameterSpec ivspec = new IvParameterSpec(iv);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), ITERATION_COUNT, KEY_LENGTH);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivspec);

        byte[] cipherText = new byte[encryptedData.length - 16];
        System.arraycopy(encryptedData, 16, cipherText, 0, cipherText.length);

        byte[] decryptedText = cipher.doFinal(cipherText);
        return new String(decryptedText, "UTF-8");
    } catch (Exception e) {
        // Handle the exception properly
        e.printStackTrace();
        return null;
        }
    }
    public static String encrypt(String strToEncrypt, String secretKey, String salt) {

    try {

        SecureRandom secureRandom = new SecureRandom();
        byte[] iv = new byte[16];
        secureRandom.nextBytes(iv);
        IvParameterSpec ivspec = new IvParameterSpec(iv);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), ITERATION_COUNT, KEY_LENGTH);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivspec);

        byte[] cipherText = cipher.doFinal(strToEncrypt.getBytes("UTF-8"));
        byte[] encryptedData = new byte[iv.length + cipherText.length];
        System.arraycopy(iv, 0, encryptedData, 0, iv.length);
        System.arraycopy(cipherText, 0, encryptedData, iv.length, cipherText.length);

        return Base64.getEncoder().encodeToString(encryptedData);
    } catch (Exception e) {
        // Handle the exception properly
        e.printStackTrace();
        return null;
    }
  }
//    public static String getAllCauHoi() {
//
//        int id_ChuDe = 0;
//        int socauhoi = 0 ;
//
//        System.out.println("id_chude :"+id_ChuDe);
//        int[] soCau = new int[40];
//
//        PreparedStatement statement = null;
//        Arrays.fill(soCau, 0);// tạo một danh sách câu hỏi có độ dài 32, ác câu hỏi đều chưa được chọn (0)
//        String sql = "SELECT * FROM BODE WHERE CHUDE_ID = '"+id_ChuDe+"'";
//        Random rand = new Random();
//        int dem = 0;//đếm số lượng câu hỏi đã được chọn.
//        while (dem < socauhoi) {//chọn đủ 10 câu hỏi.
//
//            int k = rand.nextInt(20);//random 0-19
//            if (soCau[k] != 1) {
//                soCau[k] = 1;//k là đã được chọn bằng cách gán giá trị 1 
//                dem++;//thêm một câu hỏi.
//            }
//        }
//         dem = -1;
//        String str = "";
//        try {
//        DbAccess acc = new DbAccess();
//
//        ResultSet rs = acc.Query(sql);
//            while (rs.next()) {
//                dem++;
//                if (soCau[dem] > 0) {
//                    str += rs.getString("BODE_ID");
//                    str += "///";
//                    str += rs.getString("CHUDE_ID");
//                    str += "///";
//                    str += rs.getString("NOIDUNG");
//                    str += "///";
//                    str += rs.getString("A");
//                    str += "///";
//                    str += rs.getString("B");
//                    str += "///";
//                    str += rs.getString("C");
//                    str += "///";
//                    str += rs.getString("D");
//                    str += "///";
//                    str += rs.getString("DAP_AN");
//                    str += "///";
//                }
//            }
//
//            System.out.println(str);
//        } catch (SQLException ex) {
//            Logger.getLogger(DbAccess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return str;
//    }
    

    
    
}
  
