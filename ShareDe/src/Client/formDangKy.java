/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Client;

import Data.TaiKhoan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class formDangKy extends javax.swing.JFrame {

    /**
     * Creates new form formDangKy
     */
    public formDangKy() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        txtXacNhan = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbNam = new javax.swing.JRadioButton();
        cbNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        btnDangKy = new javax.swing.JButton();
        btnDangNhap = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        NgaySinh = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("Đăng ký tài  khoản");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, 161, 20));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("Họ tên:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 79, -1));
        getContentPane().add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 340, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 94, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 340, -1));
        getContentPane().add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 340, -1));
        getContentPane().add(txtXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 340, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 204));
        jLabel4.setText("Mật  khẩu:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 94, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 204));
        jLabel5.setText("Nhập lại mật khẩu:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 120, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Giới tính");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 93, -1));

        cbNam.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbNam.setForeground(new java.awt.Color(255, 255, 255));
        cbNam.setText("Nam");
        getContentPane().add(cbNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, 98, -1));

        cbNu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbNu.setForeground(new java.awt.Color(255, 255, 255));
        cbNu.setText("Nữ");
        getContentPane().add(cbNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 300, 64, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 204));
        jLabel7.setText("Ngày sinh");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 86, -1));

        btnDangKy.setBackground(new java.awt.Color(255, 255, 51));
        btnDangKy.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDangKy.setText("Đăng ký");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, 90, -1));

        btnDangNhap.setBackground(new java.awt.Color(255, 255, 51));
        btnDangNhap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, -1, -1));

        btnThoat.setBackground(new java.awt.Color(204, 204, 204));
        btnThoat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThoat.setText("Thoát");
        getContentPane().add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, 75, -1));

        NgaySinh.setDateFormatString("dd-MM-yyyy");
        getContentPane().add(NgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, 340, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-eye-20.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 200, 30, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-eye-20.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 240, 30, 30));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/brg_xanhduong.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 720, 600));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgr-dangky.jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 0, 490, 670));

        setSize(new java.awt.Dimension(1084, 606));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        // TODO add your handling code here:
        formLogin frm = new  formLogin();
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        // TODO add your handling code here:
        if (txtTen.getText().equals("") || txtMatKhau.getText().equals("") || txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "VUI LÒNG ĐIỀN ĐẦY ĐỦ THÔNG TIN!!");
            txtTen.requestFocus();
            return;
        }
        Connection connection = null;
        PreparedStatement statement = null;
         String name = txtTen.getText();
         String email = txtEmail.getText();
         Date birthday = NgaySinh.getDate();
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         String pass = txtMatKhau.getText();
         String rePass = txtXacNhan.getText();
         boolean gender = cbNam.isSelected() ? true : false;
         int i=0;
         if(gender == true){
             i = 1;
         }
         else
             i=0;
        if(pass.equals(rePass)){
            try {
         String URL = "jdbc:sqlserver://NAMHUYNH\\SQLEXPRESS:1433;"+
                    "databaseName=SHAREDETHI;user=sas;password=12345;encrypt=false";
            System.out.println(URL);
            connection = DriverManager.getConnection(URL);
            String sql = "insert into TAIKHOAN(EMAIL, MATKHAU, TEN, GIOITINH,NGAYSINH,PHANQUYEN,OTP,NGAYXACNHAN) values(N'"+email+"',N'"+pass+"',N'"+name+"','"+i+"',N'"+df.format(birthday)+"',0,null,null)";
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
            JOptionPane.showMessageDialog(this, "Đăng ký tài khoản thành công!!");
        }else{
            JOptionPane.showMessageDialog(this, "Xác nhận mật khẩu không chính xác!!");
            txtXacNhan.requestFocus();
            return;
        }
            
         
    }//GEN-LAST:event_btnDangKyActionPerformed
private boolean checkButton = false;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (!checkButton) {
            txtMatKhau.setEchoChar((char) 0);
            checkButton = true;
        } else {
            txtMatKhau.setEchoChar('*');
            checkButton = false;
        }
    }//GEN-LAST:event_jButton2ActionPerformed
private boolean checkButton1 = false;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (!checkButton1) {
            txtXacNhan.setEchoChar((char) 0);
            checkButton1 = true;
        } else {
            txtXacNhan.setEchoChar('*');
            checkButton1 = false;
        }
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
            java.util.logging.Logger.getLogger(formDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formDangKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser NgaySinh;
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnThoat;
    private javax.swing.JRadioButton cbNam;
    private javax.swing.JRadioButton cbNu;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTen;
    private javax.swing.JPasswordField txtXacNhan;
    // End of variables declaration//GEN-END:variables
}
