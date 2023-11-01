/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Client;



import Data.CauHoi;
import Data.KetQua;
import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Pham Minh Hieu
 */
public final class formThiTN extends javax.swing.JFrame {

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    int soCau = 0;
    private static int timer = 30;
    int current = -1;
    int dem = 0;
    ArrayList<CauHoi> listCauhoi = null;
    ArrayList cauChon = null;

    /**
     * Creates new form formThiTracNghiem
     */
    public formThiTN() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("THI TRẮC NGHIỆM");
        listCauhoi = new ArrayList();
        cauChon = new ArrayList();
        ThiTracNghiem();
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        String time = " Timer : " + timer;
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 21));

        if (timer > 0) {
            g.drawString(time, 30, 80);
        } else {
            g.drawString("Times up", 30, 80);
            timer = 31;
            try {
                try {
                    cauHoiKeTiep();
                } catch (InterruptedException ex) {
                    Logger.getLogger(formThiTN.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(formThiTN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        } catch (InterruptedException ex) {
            Logger.getLogger(formThiTN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cauHoiKeTiep() throws IOException, InterruptedException {
        timer = 30;
        current++;
        //hiện kết quả vừa chọn lên console
        if (current > 0) {
            if (jRadioButtonCauA.isSelected()) {
                cauChon.add("A");
                System.out.println("Ban vua chon dap an A\n");
            } else if (jRadioButtonCauB.isSelected()) {
                cauChon.add("B");
                System.out.println("Ban vua chon dap an B\n");
            } else if (jRadioButtonCauC.isSelected()) {
                cauChon.add("C");
                System.out.println("Ban vua chon dap an C\n");
            } else if (jRadioButtonCauD.isSelected()) {
                cauChon.add("D");
                System.out.println("Ban vua chon dap an D\n");
            } else {
                cauChon.add("E");
                System.out.println("E");
            }
        }


        if (current < soCau) {
            dem++;
            CauHoi CH = listCauhoi.get(current);
            System.out.println("Câu " + dem + ". " + CH.getNOIDUNG());
            jLabelCauHoi.setText("Câu " + dem + ". " + CH.getNOIDUNG());
            System.out.println("A. " + CH.getA());
            jRadioButtonCauA.setText("A. " + CH.getA());
            System.out.println("B. " + CH.getB());
            jRadioButtonCauB.setText("B. " + CH.getB());
            System.out.println("C. " + CH.getC());
            jRadioButtonCauC.setText("C. " + CH.getC());
            System.out.println("D. " + CH.getD());
            jRadioButtonCauD.setText("D. " + CH.getD());
            if (dem == soCau) {
                jButtonTiepTheo.setText("NỘP BÀI");
            }
        } else {
            String send = "";
            for (int i = 0; i < cauChon.size(); i++) {
                send += cauChon.get(i) + "///";
            }
            dos.writeUTF(send);
            String diem = dis.readUTF();
            System.out.println("Điểm của bạn là: " + diem);
            KetQua.diem = diem;
            KetQua.soCauDung = diem;
            JOptionPane.showMessageDialog(null, "Bạn đã hoàn thành bài thi!! Nộp bài!");
            this.setVisible(false);
            //formKetQua KQ = new formKetQua();
            //KQ.setVisible(true);
            socket.close();
        }
    }

    public void ThiTracNghiem() {
        try {
            socket = new Socket("localhost", 8000);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            String flag = "3";
            dos.writeUTF(flag);
           
            String receive = dis.readUTF();
            String[] arrStr = receive.split("///");//tách chuỗi thành các phần con dựa trên một chuỗi phân tách được chỉ định.
//            System.out.println("arrstr"+arrStr);
            //
            int dem = 0;
            for (int i = 0; i < arrStr.length; i +=8) {
                if (dem < 5)//chỉ dc làm 5 câu hỏi
                {
                    CauHoi CH = new CauHoi();
                    CH.setBODE_ID(Integer.parseInt(arrStr[i]));
                    CH.setCHUDE_ID(Integer.parseInt(arrStr[i + 1]));
                    CH.setNOIDUNG(arrStr[i + 2]);
                    CH.setA(arrStr[i + 3]);
                    CH.setB(arrStr[i + 4]);
                    CH.setC(arrStr[i + 5]);
                    CH.setD(arrStr[i + 6]);
                    CH.setDAP_AN(arrStr[i + 7]);
                    listCauhoi.add(CH);
                }
                dem++;               
            }
            soCau = listCauhoi.size();
            cauHoiKeTiep();
        } catch (IOException ex) {
            Logger.getLogger(formClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(formThiTN.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroupDapAn = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonCauA = new javax.swing.JRadioButton();
        jRadioButtonCauB = new javax.swing.JRadioButton();
        jRadioButtonCauC = new javax.swing.JRadioButton();
        jRadioButtonCauD = new javax.swing.JRadioButton();
        jLabelCauHoi = new javax.swing.JLabel();
        jButtonTiepTheo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THI TRẮC NGHIỆM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 190, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        buttonGroupDapAn.add(jRadioButtonCauA);
        jRadioButtonCauA.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButtonCauA.setText("A.");

        buttonGroupDapAn.add(jRadioButtonCauB);
        jRadioButtonCauB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButtonCauB.setText("B.");

        buttonGroupDapAn.add(jRadioButtonCauC);
        jRadioButtonCauC.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButtonCauC.setText("C.");

        buttonGroupDapAn.add(jRadioButtonCauD);
        jRadioButtonCauD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButtonCauD.setText("D.");

        jLabelCauHoi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelCauHoi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelCauHoi.setText("CÂU 1. ");

        jButtonTiepTheo.setText("TIẾP THEO");
        jButtonTiepTheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTiepTheoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonTiepTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jRadioButtonCauD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                            .addComponent(jRadioButtonCauC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButtonCauB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButtonCauA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabelCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jRadioButtonCauA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jRadioButtonCauB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jRadioButtonCauC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jRadioButtonCauD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jButtonTiepTheo)
                .addGap(17, 17, 17))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 707, 470));

        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Data/brg_TTN.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 600));

        setSize(new java.awt.Dimension(1084, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTiepTheoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTiepTheoActionPerformed
        // TODO add your handling code here:
        try {
            cauHoiKeTiep();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(formThiTN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(formThiTN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonTiepTheoActionPerformed

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
            java.util.logging.Logger.getLogger(formThiTN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formThiTN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formThiTN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formThiTN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formThiTN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupDapAn;
    private javax.swing.JButton jButtonTiepTheo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCauHoi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonCauA;
    private javax.swing.JRadioButton jRadioButtonCauB;
    private javax.swing.JRadioButton jRadioButtonCauC;
    private javax.swing.JRadioButton jRadioButtonCauD;
    // End of variables declaration//GEN-END:variables
}
