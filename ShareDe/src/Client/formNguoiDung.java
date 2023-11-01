/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Client;

import Data.Bin;
import Data.TaiKhoan;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kimdo
 */
public class formNguoiDung extends javax.swing.JFrame {
    int id= 0;
    
    /**
     * Creates new form formDangKy
     */
    public formNguoiDung() {
        initComponents();
        LayId();
        Laydata();
        
        
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
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
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
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Người dùng");
        jButton1.setEnabled(false);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 119, 52));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Thi");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 119, 52));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Đề thi");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 119, 53));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Đăng xuất");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 119, 56));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("Thông tin tài khoản");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 180, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("Họ tên :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 62, -1));
        getContentPane().add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 272, 31));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("Email :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 62, -1));
        getContentPane().add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 208, 27));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 204));
        jLabel4.setText("Mật Khẩu :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 76, -1));

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 272, 28));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 204));
        jLabel5.setText("Giới tính :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 76, -1));

        cbNam.setBackground(new java.awt.Color(255, 255, 255));
        cbNam.setForeground(new java.awt.Color(255, 255, 255));
        cbNam.setText("Nam");
        getContentPane().add(cbNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 80, -1));

        cbNu.setBackground(new java.awt.Color(255, 255, 255));
        cbNu.setForeground(new java.awt.Color(255, 255, 255));
        cbNu.setText("Nữ");
        getContentPane().add(cbNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, 80, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Ngày sinh :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 80, -1));
        getContentPane().add(NgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 272, 25));

        btnCapNhat.setBackground(new java.awt.Color(255, 255, 204));
        btnCapNhat.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        getContentPane().add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 110, 30));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-eye-20.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, 30, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/brg_xanhduong.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 600));

        setSize(new java.awt.Dimension(1090, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        formLogin frm = new  formLogin();
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
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
         String pass = txtMatKhau.getText();
         boolean gender = cbNam.isSelected() ? true : false;
         int i=0;
         if(gender == true){
             i = 1;
         }
         else
             i=0;
         
         Connection connection = null;
         PreparedStatement statement = null;
            try {
            String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            connection = DriverManager.getConnection(URL);
            String sql = "UPDATE TAIKHOAN SET TEN=N'"+name+"',EMAIL = N'"+email+"', MATKHAU = N'"+pass+"', GIOITINH = N'"+i+"', NGAYSINH= '"+df.format(birthday)+"' WHERE TAIKHOAN_ID ='"+id+"';";
                System.out.println(id);
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
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

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
    private javax.swing.JRadioButton cbNam;
    private javax.swing.JRadioButton cbNu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
                Bin std = new Bin(rsl.getInt("ID"),rsl.getInt("ID_TAIKHOAN"));
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
                 TaiKhoan std = new TaiKhoan(rs.getInt("TAIKHOAN_ID"), 
                        rs.getString("EMAIL"),rs.getString("TEN"),rs.getString("OTP") ,rs.getString("MATKHAU"), 
                        rs.getBoolean("GIOITINH"),rs.getBoolean("PHANQUYEN"),rs.getDate("NGAYSINH")
                        ,rs.getDate("NGAYXACNHAN"));
                txtTen.setText(std.getTEN());
                txtEmail.setText(std.getEMAIL());
                txtMatKhau.setText(std.getMATKHAU());
                NgaySinh.setDate(std.getNGAYSINH());
                gioitinh = std.isGIOITINH();
            }
           
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
}