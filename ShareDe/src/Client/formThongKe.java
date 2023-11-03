/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kimdo
 */
public class formThongKe extends javax.swing.JFrame {
//    int id= formLogin.id_taiKhoan;
    /**
     * Creates new form formThongKe
     */
    public formThongKe() {
        initComponents();
        showCB();
        
    }
    private void showCB() {
        List<String> data = DbAccess.findTenBoDe();
        for(String s: data){
            cbBoDe.addItem(s);
            cbBoDe2.addItem(s);
            cbBoDe3.addItem(s);
            cbBoDe4.addItem(s);
            cbBoDe5.addItem(s);
        }
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
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbBoDe = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbDiemCaoNhat = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbBoDe2 = new javax.swing.JComboBox<>();
        btnAvg = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbDiemTrungBinh = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbBoDe3 = new javax.swing.JComboBox<>();
        btnCount = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbCount = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbBoDe4 = new javax.swing.JComboBox<>();
        btnCount1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbCount1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbBoDe5 = new javax.swing.JComboBox<>();
        btntaikhoan = new javax.swing.JButton();
        cbTen = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Người dùng");

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Thống kê");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnDeThi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDeThi.setText("Đề thi");
        btnDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeThiActionPerformed(evt);
            }
        });

        btnDAngXuat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDAngXuat.setText("Đăng xuất");
        btnDAngXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDAngXuatActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Thi");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Điểm số cao nhất của mỗi bộ đề :");

        cbBoDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------------------" }));

        jButton4.setText("Thống kê");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Điểm :");

        lbDiemCaoNhat.setText("0");

        jLabel3.setText("Điểm số trung bình của  mỗi bộ đề :");

        cbBoDe2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------------------" }));

        btnAvg.setText("Thống kê");
        btnAvg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvgActionPerformed(evt);
            }
        });

        jLabel4.setText("Điểm :");

        lbDiemTrungBinh.setText("0");

        jLabel5.setText("Số người đã làm bộ đề ( mỗi  tài khoản chỉ tính 1 lần) :");

        cbBoDe3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------------------" }));

        btnCount.setText("Thống kê");
        btnCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCountActionPerformed(evt);
            }
        });

        jLabel6.setText("Số người :");

        lbCount.setText("0");

        jLabel7.setText("Số lần bộ đề đã được làm :");

        cbBoDe4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------------------" }));

        btnCount1.setText("Thống kê");
        btnCount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCount1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Số lần :");

        lbCount1.setText("0");

        jLabel8.setText("Tài khoản có điểm số cao nhất trong mỗi bộ đề :");

        cbBoDe5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------------------" }));

        btntaikhoan.setText("Thống kê");
        btntaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntaikhoanActionPerformed(evt);
            }
        });

        cbTen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cbBoDe5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btntaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cbBoDe, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbDiemCaoNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cbBoDe2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnAvg, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(cbBoDe4, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addComponent(btnCount1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbCount1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbDiemTrungBinh, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbCount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cbBoDe3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCount, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(42, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDAngXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(528, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbBoDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4)
                            .addComponent(lbDiemCaoNhat)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbBoDe5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btntaikhoan)
                            .addComponent(cbTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAvg)
                                .addComponent(lbDiemTrungBinh)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbBoDe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbBoDe3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCount)
                            .addComponent(jLabel6)
                            .addComponent(lbCount))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDAngXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbBoDe4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCount1)
                            .addComponent(jLabel9)
                            .addComponent(lbCount1))))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnDAngXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDAngXuatActionPerformed
        // TODO add your handling code here:
        formLogin frm = new  formLogin();
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDAngXuatActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         Connection connection = null;
        Statement statement = null;
        String std = null;
        String bode = (String) cbBoDe.getSelectedItem();
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
            lbDiemCaoNhat.setText(std);
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnAvgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvgActionPerformed
        // TODO add your handling code here:
        Connection connection = null;
        Statement statement = null;
        String std = null;
        String bode = (String) cbBoDe2.getSelectedItem();
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
            lbDiemTrungBinh.setText(std);
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
    }//GEN-LAST:event_btnAvgActionPerformed

    private void btnCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCountActionPerformed
        // TODO add your handling code here:
                Connection connection = null;
        Statement statement = null;
        String std = null;
        String bode = (String) cbBoDe3.getSelectedItem();
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
            lbCount.setText(std);
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
    }//GEN-LAST:event_btnCountActionPerformed

    private void btnCount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCount1ActionPerformed
        // TODO add your handling code here:
        Connection connection = null;
        Statement statement = null;
        String std = null;
        String bode = (String) cbBoDe4.getSelectedItem();
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
            lbCount1.setText(std);
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
    }//GEN-LAST:event_btnCount1ActionPerformed

    private void btntaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaikhoanActionPerformed
        // TODO add your handling code here:
        Connection connection = null;
        Statement statement = null;
        List<String> listTen = new ArrayList<>();;
        String bode = (String) cbBoDe5.getSelectedItem();
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
                  String name = resultSet.getString("TEN");
                  listTen.add(name);
            }
//                 System.out.println("listTen "+listTen);
            StringBuilder result = new StringBuilder();
            cbTen.removeAllItems();
            for (String item : listTen) {
                cbTen.addItem(item);
                
            }

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
    }//GEN-LAST:event_btntaikhoanActionPerformed

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
            java.util.logging.Logger.getLogger(formThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvg;
    private javax.swing.JButton btnCount;
    private javax.swing.JButton btnCount1;
    private javax.swing.JButton btnDAngXuat;
    private javax.swing.JButton btnDeThi;
    private javax.swing.JButton btntaikhoan;
    private javax.swing.JComboBox<String> cbBoDe;
    private javax.swing.JComboBox<String> cbBoDe2;
    private javax.swing.JComboBox<String> cbBoDe3;
    private javax.swing.JComboBox<String> cbBoDe4;
    private javax.swing.JComboBox<String> cbBoDe5;
    private javax.swing.JComboBox<String> cbTen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbCount;
    private javax.swing.JLabel lbCount1;
    private javax.swing.JLabel lbDiemCaoNhat;
    private javax.swing.JLabel lbDiemTrungBinh;
    // End of variables declaration//GEN-END:variables
}
