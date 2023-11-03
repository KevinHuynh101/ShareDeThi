/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Client;

import Data.TaiKhoan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
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
 * @author kimdo
 */
public class formLogin extends javax.swing.JFrame {
    private static final int KEY_LENGTH = 256;
    private static final int ITERATION_COUNT = 65536;
    String secretKey = "huynhnam";
    String salt = "nhuhuynh";
    int id;

    public static int id_taiKhoan;
    public formLogin() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("THI TRẮC NGHIỆM");

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jButtonThoat = new javax.swing.JButton();
        jButtonDangNhap = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 204)));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG NHẬP");
        jLabel1.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EMAIL :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MẬT KHẨU :");

        jButtonThoat.setBackground(new java.awt.Color(255, 246, 0));
        jButtonThoat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonThoat.setText("THOÁT");
        jButtonThoat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));
        jButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoatActionPerformed(evt);
            }
        });

        jButtonDangNhap.setBackground(new java.awt.Color(255, 246, 0));
        jButtonDangNhap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonDangNhap.setText("ĐĂNG NHẬP");
        jButtonDangNhap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));
        jButtonDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDangNhapActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-eye-20.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEmail)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 440, 360));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgr_dangnhap.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 600));

        setSize(new java.awt.Dimension(1084, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDangNhapActionPerformed
        // TODO add your handling code here:
//        String send = "";
//        String flag = "2";
//
//        send += flag;
//        send += "///";
//
//        
//        send += jTextFieldUsername.getText();
//        send += "///";
//
//        send += jPasswordField1.getText();
//        send += "///";
//
//        boolean check = false;
//        try {
//            while (!check) {
//                String Username, Password;
//                
//                Username = jTextFieldUsername.getText();
//                Password = jPasswordField1.getText();
//
//                if (Username.equals("") && Password.equals("")) {
//                    JOptionPane.showMessageDialog(this, "USERNAME HOẶC PASSWORD KHÔNG ĐƯỢC ĐỂ TRỐNG. VUI LÒNG NHẬP LẠI!!");                    
//                    return;
//                } else {
//                    Socket socket = new Socket("localhost", 8000);
//                    DataInputStream dis = new DataInputStream(socket.getInputStream());
//                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//                    dos.writeUTF(send);
//                    String arrStr[] = send.split("///");
//                    System.out.println("\nUsername: " + arrStr[1] + "\nPassword: " + arrStr[2]);
//                    String receive = dis.readUTF();
//                    System.out.println("Receive: " + receive);
//                    if ("1".equals(receive)) {
//                        JOptionPane.showMessageDialog(this, "KẾT NỐI THÀNH CÔNG");
//                        formLogin DN = new formLogin();
//                        this.setVisible(false);
//                        formNguoiDung TT = new formNguoiDung();
//                        TT.setVisible(true);
//                        check = true;
//                        socket.close();
//                    } else {
//                        JOptionPane.showMessageDialog(null, "KẾT NỐI CSDL THẤT BẠI");
//                        
//                        return;
//                    }
//                }
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(formClient.class.getName()).log(Level.SEVERE, null, ex);
//        }
        java.util.List<TaiKhoan> taikhoanList = new ArrayList<>();
        String matkhau = null;
        boolean s= true ;
        try {
            String email = txtEmail.getText();
            String pass = new String(txtPass.getPassword());
            
            DbAccess acc = new DbAccess();
            String QueryStr = "select * from TAIKHOAN where EMAIL =N'"+email+"'";
            ResultSet rsl = acc.Query(QueryStr);
           while (rsl.next()) {                
                TaiKhoan std = new TaiKhoan(rsl.getInt("TAIKHOAN_ID"),rsl.getInt("BLOCK"),rsl.getInt("BLOCKTAODE"),rsl.getInt("BLOCKTHI"),
                        rsl.getString("EMAIL"),rsl.getString("TEN"),rsl.getString("OTP") ,rsl.getString("MATKHAU"), 
                        rsl.getBoolean("GIOITINH"),rsl.getBoolean("PHANQUYEN"),rsl.getDate("NGAYSINH")
                        ,rsl.getDate("NGAYXACNHAN"));
               id = std.getTAIKHOAN_ID();
               matkhau = std.getMATKHAU();
            }
            String decryptedString = decrypt(matkhau, secretKey, salt);
            System.out.println("decryptedString :"+decryptedString);
            ResultSet rs = acc.Query(QueryStr);
            
            if (rs.next()){
                if(pass.equals(decryptedString)){ 
                    id_taiKhoan= id;
                    LuuId(id);
                    Socket socket = new Socket("localhost", 8000);
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    String send = "";
                    String flag = "2";
                    send += flag;
                    send += "///";
                    send += id;
                    send += "///";
                    dos.writeUTF(send);
                    String receive = dis.readUTF();
                    if ("0".equals(receive)) {
                        JOptionPane.showMessageDialog(this, "Đăng nhập thành công ");
                        formNguoiDung frm = new formNguoiDung();
                        frm.setVisible(true);
                        dispose();
                        socket.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Tài khoản bị khóa");
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(this, "Mật khẩu không chính xác");
                }
            }else{
            JOptionPane.showMessageDialog(this, "Email không chính xác");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonDangNhapActionPerformed

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        // TODO add your handling code here:
        JFrame Frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(Frame, "Bạn có chắc chắn muốn thoát!", "Thoát!",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jButtonThoatActionPerformed
private boolean checkButton = false;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (!checkButton) {
            txtPass.setEchoChar((char) 0);
            checkButton = true;
        } else {
            txtPass.setEchoChar('*');
            checkButton = false;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonDangNhap;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
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
            Logger.getLogger(Server.DbAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Server.DbAccess.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Server.DbAccess.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }      
    }
}
