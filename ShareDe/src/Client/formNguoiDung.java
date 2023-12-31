/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Client;

import Data.Bin;
import Data.TaiKhoan;
import java.beans.Statement;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

/**
 *
 * @author kimdo
 */
public class formNguoiDung extends javax.swing.JFrame {
//    int id= 0;
    int id= formLogin.id_taiKhoan;
    private static final int KEY_LENGTH = 256;
    private static final int ITERATION_COUNT = 65536;
    String secretKey = "huynhnam";
    String salt = "nhuhuynh";
    String encryptmatkhau = null;
    
    /**
     * Creates new form formDangKy
     */
    public formNguoiDung() {
        initComponents();
        
//        LayId();
        Laydata();
        if(formLogin.phanquyen == false){
            jLabel8.hide();
            cbKhoa.hide();
            jLabel9.hide();
            cbCamThi.hide();
            lbCamTaoDe.hide();
            cbCamTao.hide();
           
            
        }
        
        String decryptedString = decrypt(encryptmatkhau, secretKey, salt);
        txtMatKhau.setText(decryptedString);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnDeThi = new javax.swing.JButton();
        btnDAngXuat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbNam = new javax.swing.JRadioButton();
        cbNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        NgaySinh = new com.toedter.calendar.JDateChooser();
        btnCapNhat = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbCamTaoDe = new javax.swing.JLabel();
        cbKhoa = new javax.swing.JCheckBox();
        cbCamThi = new javax.swing.JCheckBox();
        cbCamTao = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Người dùng");
        jButton1.setEnabled(false);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 119, 52));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Thống kê");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 119, 52));

        btnDeThi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDeThi.setText("Đề thi");
        btnDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeThiActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeThi, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 119, 53));

        btnDAngXuat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDAngXuat.setText("Đăng xuất");
        btnDAngXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDAngXuatActionPerformed(evt);
            }
        });
        getContentPane().add(btnDAngXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 119, 56));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("Thông tin tài khoản");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 180, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("Họ tên :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 62, 20));
        getContentPane().add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 272, 40));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("Email :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 62, 20));
        getContentPane().add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 208, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 204));
        jLabel4.setText("Mật Khẩu :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 76, 20));

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 272, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 204));
        jLabel5.setText("Giới tính :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 76, 20));

        cbNam.setBackground(new java.awt.Color(255, 255, 255));
        cbNam.setForeground(new java.awt.Color(255, 255, 255));
        cbNam.setText("Nam");
        getContentPane().add(cbNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 80, 30));

        cbNu.setBackground(new java.awt.Color(255, 255, 255));
        cbNu.setForeground(new java.awt.Color(255, 255, 255));
        cbNu.setText("Nữ");
        getContentPane().add(cbNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 80, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Ngày sinh :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 80, 20));
        getContentPane().add(NgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 272, 30));

        btnCapNhat.setBackground(new java.awt.Color(255, 255, 204));
        btnCapNhat.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        getContentPane().add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 110, 40));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-eye-20.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 30, 30));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Thi");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 119, 52));

        jLabel8.setText("Khóa tài khoản :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 100, -1));

        jLabel9.setText("Cấm thi :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 60, -1));

        lbCamTaoDe.setText("Cấm tạo đề :");
        getContentPane().add(lbCamTaoDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, 80, 20));
        getContentPane().add(cbKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, -1, -1));
        getContentPane().add(cbCamThi, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, -1, -1));
        getContentPane().add(cbCamTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, -1, -1));

        setSize(new java.awt.Dimension(1084, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDAngXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDAngXuatActionPerformed
        // TODO add your handling code here:
        formLogin frm = new  formLogin();
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDAngXuatActionPerformed
private boolean checkButton = false;
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (!checkButton) {
            txtMatKhau.setEchoChar((char) 0);
            checkButton = true;
        } else {
            txtMatKhau.setEchoChar('*');
            checkButton = false;
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        
         String name = txtTen.getText();
         String email = txtEmail.getText();
         Date birthday = NgaySinh.getDate();
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         String password = new String(txtMatKhau.getPassword());
         String encryptedPassword = encrypt(password, secretKey, salt);
         boolean gender = cbNam.isSelected() ? true : false;
         int i=0;
         if(gender == true){
             i = 1;
         }
         else
             i=0;
        int BLOCK = cbKhoa.isSelected() ? 1 : 0;
        int BLOCKTAODE = cbCamTao.isSelected()  ? 1 : 0 ;
        int BLOCKTHI= cbCamThi.isSelected()  ? 1 : 0;
         Connection connection = null;
         PreparedStatement statement = null;
            try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            connection = DriverManager.getConnection(URL);
            String sql = "UPDATE TAIKHOAN SET TEN=N'"+name+"',EMAIL = N'"+email+"', MATKHAU = N'"+encryptedPassword+"', GIOITINH = N'"+i+"', NGAYSINH= '"+df.format(birthday)+"',BLOCK = '"+BLOCK+"',BLOCKTAODE = '"+BLOCKTAODE+"',BLOCKTHI = '"+BLOCKTHI+"' WHERE TAIKHOAN_ID ='"+id+"';";
//                System.out.println(id);
            statement = connection.prepareCall(sql);        
            statement.execute();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");

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
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        formThongKe frm = new  formThongKe();
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDeThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeThiActionPerformed
        // TODO add your handling code here:
        formDeThi frm = new  formDeThi();
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDeThiActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        formThi frm = new  formThi();
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formNguoiDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formNguoiDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formNguoiDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formNguoiDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formNguoiDung().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser NgaySinh;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnDAngXuat;
    private javax.swing.JButton btnDeThi;
    private javax.swing.JCheckBox cbCamTao;
    private javax.swing.JCheckBox cbCamThi;
    private javax.swing.JCheckBox cbKhoa;
    private javax.swing.JRadioButton cbNam;
    private javax.swing.JRadioButton cbNu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbCamTaoDe;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
    public void LayId() {
        Connection connection = null;
        
        try {  
        Connection conn = null;       
        String QueryStr = "select * from BIN ";
        Server.DbAccess acc = new Server.DbAccess();

        ResultSet rsl = acc.Query(QueryStr);
        while (rsl.next()) {                
                Bin std = new Bin(rsl.getInt("ID"),rsl.getInt("ID_TAIKHOAN"),rsl.getInt("BLOCK"),
                rsl.getInt("BLOCKTAODE"),rsl.getInt("BLOCKTHI"),rsl.getInt("ID_CHUDE"),
                rsl.getInt("SOCAUHOI"),rsl.getInt("THOIGIAN"));
               id = std.getID_TAIKHOAN();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {                     
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Server.DbAccess.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    
    public void Laydata() {
        boolean gioitinh = false;
        int khoa = 0;
        int CamThi = 0;
        int CamTaoDe=0;
        Connection connection = null;
        java.sql.Statement statement = null;
        try {

            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            connection = DriverManager.getConnection(URL);
            String sql = "select * from TAIKHOAN where TAIKHOAN_ID ='"+id+"'";
            
            statement = connection.createStatement();           
            ResultSet rs = statement.executeQuery(sql);            
            while (rs.next()) {                
                 TaiKhoan std = new TaiKhoan(rs.getInt("TAIKHOAN_ID"), rs.getInt("BLOCK"),rs.getInt("BLOCKTAODE"),rs.getInt("BLOCKTHI"),
                        rs.getString("EMAIL"),rs.getString("TEN"),rs.getString("OTP") ,rs.getString("MATKHAU"), 
                        rs.getBoolean("GIOITINH"),rs.getBoolean("PHANQUYEN"),rs.getDate("NGAYSINH")
                        ,rs.getDate("NGAYXACNHAN"));
                txtTen.setText(std.getTEN());
                txtEmail.setText(std.getEMAIL());
//                txtMatKhau.setText(decryptPassword(std.getMATKHAU(),salt));
                encryptmatkhau = std.getMATKHAU();
                NgaySinh.setDate(std.getNGAYSINH());
                gioitinh = std.isGIOITINH();
//                txtKhoa.setText(Integer.toString(std.getBLOCK()));
//                txtCamThi.setText(Integer.toString(std.getBLOCKTHI()));
//                txtCamTaoDe.setText(Integer.toString(std.getBLOCKTAODE()));
                khoa = std.getBLOCK();
                CamThi =  std.getBLOCKTHI();
                CamTaoDe = std.getBLOCKTAODE();
            }
            if(khoa == 0 ){
                cbKhoa.setSelected(false);
            }else
                cbKhoa.setSelected(true);
            if(CamThi == 0 ){
                cbCamThi.setSelected(false);
            }else
                cbCamThi.setSelected(true);
            if(CamTaoDe == 0 ){
                cbCamTao.setSelected(false);
            }else
                cbCamTao.setSelected(true);
            if(gioitinh == true){
                cbNam.setSelected(true);
            }else
                cbNu.setSelected(true);
            
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



    public static String decrypt(String strToDecrypt, String secretKey, String salt) {

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
}
