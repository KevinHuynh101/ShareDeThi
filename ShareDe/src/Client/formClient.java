/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;

/**
 *
 * @author kimdo
 */
public class formClient extends javax.swing.JFrame {

    /**
     * Creates new form formClient
     */
    String diaChi, port;

    public formClient() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("THI TRẮC NGHIỆM");
//        URL urlIcon = formClient.class.getResource("icon.png");
//        Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
//        this.setIconImage(img);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextDiaChi = new javax.swing.JTextField();
        jTextPort = new javax.swing.JTextField();
        jButtonThoat = new javax.swing.JButton();
        jButtonDangNhap = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 204,60));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN TO SERVER");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TÊN ĐỊA CHỈ ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CỔNG PORT");

        jButtonThoat.setBackground(new java.awt.Color(0, 51, 153));
        jButtonThoat.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButtonThoat.setForeground(new java.awt.Color(255, 255, 255));
        jButtonThoat.setText("THOÁT");
        jButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoatActionPerformed(evt);
            }
        });

        jButtonDangNhap.setBackground(new java.awt.Color(0, 51, 153));
        jButtonDangNhap.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButtonDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDangNhap.setText("ĐĂNG NHẬP");
        jButtonDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDangNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                                .addComponent(jButtonDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextDiaChi)
                                    .addComponent(jTextPort))))
                        .addGap(43, 43, 43)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDiaChi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonThoat)
                    .addComponent(jButtonDangNhap))
                .addGap(77, 77, 77))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 118, 380, 380));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/br_client-goose-blue-bottom.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 600));

        setSize(new java.awt.Dimension(1084, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDangNhapActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonDangNhapActionPerformed
        // TODO add your handling code here:
        boolean check = false;
        diaChi = jTextDiaChi.getText();
        port = jTextPort.getText();
        if (diaChi.equals("") && port.equals("")) {
            JOptionPane.showMessageDialog(this, "ĐỊA CHỈ VÀ CỔNG PORT KHÔNG ĐƯỢC ĐỂ TRỐNG. VUI LÒNG NHẬP LẠI!!");
            jTextDiaChi.requestFocus();
            return;
        } else if (diaChi.equals("")) {
            JOptionPane.showMessageDialog(this, "ĐỊA CHỈ KHÔNG ĐƯỢC ĐỂ TRỐNG. VUI LÒNG NHẬP LẠI!!");
            jTextDiaChi.requestFocus();
            return;
        } else if (port.equals("")) {
            JOptionPane.showMessageDialog(this, "CỔNG PORT KHÔNG ĐƯỢC ĐỂ TRỐNG. VUI LÒNG NHẬP LẠI!!");
            jTextPort.requestFocus();
            return;
        }
        try {
            while (!check) {
                if (!"localhost".equals(diaChi) && "1433".equals(port)) {
                    JOptionPane.showMessageDialog(null, "ĐỊA CHỈ SAI! VUI LÒNG NHẬP LẠI!!");
                    jTextDiaChi.requestFocus();
                    return;
                } else if ("localhost".equals(diaChi) && !"1433".equals(port)) {
                    JOptionPane.showMessageDialog(null, "PORT SAI! VUI LÒNG NHẬP LẠI!!");
                    jTextPort.requestFocus();
                    return;
                } else if (!"localhost".equals(diaChi) && !"1433".equals(port)) {
                    JOptionPane.showMessageDialog(null, "ĐỊA CHỈ & PORT SAI! VUI LÒNG NHẬP LẠI!!");
                    jTextDiaChi.requestFocus();
                    return;
                } else {
                    Socket socket = new Socket("localhost", 8000);
                    JOptionPane.showMessageDialog(null, "THÀNH CÔNG KẾT NỐI VỚI SERVER!");
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    String flag = "1";
                    String str = "";
                    str += flag;
                    str += "///";
                    str += diaChi;
                    str += "///";
                    str += port;
                    str += "///";
                    dos.writeUTF(str);
                    String receive = dis.readUTF();
                    System.out.println(receive);
                    socket.close();
//                    formClient login = new formClient();
//                    this.setVisible(false);
//                    formLoginDB DN = new formLoginDB();
                    //DN.setVisible(true);
                    System.out.println("dang nhap thanh cong ");
                    check = true;
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "KẾT NỐI THẤT BẠI!");
            jTextDiaChi.requestFocus();
        }
    }//GEN-LAST:event_jButtonDangNhapActionPerformed

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        // TODO add your handling code here:
        JFrame Frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(Frame, "Bạn có chắc chắn muốn thoát!", "Thoát!",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jButtonThoatActionPerformed

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
            java.util.logging.Logger.getLogger(formClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDangNhap;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextDiaChi;
    private javax.swing.JTextField jTextPort;
    // End of variables declaration//GEN-END:variables
}
