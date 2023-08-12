/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package feesmanagement;

import java.awt.Color;
import java.sql.*;

/**
 *
 * @author OM
 */
public class home extends javax.swing.JFrame {

 
    public home() {
        initComponents();
      
    }
    
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblVreport = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblSrecord = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblVrecord = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblVcourse = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblAdd = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblEcourse = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelAbout = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(192, 192, 192));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(52, 52, 52));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVreport.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        lblVreport.setForeground(new java.awt.Color(255, 255, 255));
        lblVreport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/view report.png"))); // NOI18N
        lblVreport.setText("Annual Report");
        lblVreport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVreportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblVreportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblVreportMouseExited(evt);
            }
        });
        jPanel3.add(lblVreport, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 140));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, 300, 180));

        jPanel4.setBackground(new java.awt.Color(52, 52, 52));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel4.setMinimumSize(new java.awt.Dimension(280, 160));
        jPanel4.setPreferredSize(new java.awt.Dimension(280, 160));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSrecord.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        lblSrecord.setForeground(new java.awt.Color(255, 255, 255));
        lblSrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/search-document.png"))); // NOI18N
        lblSrecord.setText("Search Record");
        lblSrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSrecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSrecordMouseExited(evt);
            }
        });
        jPanel4.add(lblSrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, 140));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/plus.png"))); // NOI18N
        jLabel3.setText(" Add Fees");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, 140));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 260, 180));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 300, 180));

        jPanel6.setBackground(new java.awt.Color(52, 52, 52));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVrecord.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        lblVrecord.setForeground(new java.awt.Color(255, 255, 255));
        lblVrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/text-book-opened-from-top-view.png"))); // NOI18N
        lblVrecord.setText(" View Record");
        lblVrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVrecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblVrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblVrecordMouseExited(evt);
            }
        });
        jPanel6.add(lblVrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 270, 140));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 300, 180));

        jPanel7.setBackground(new java.awt.Color(52, 52, 52));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVcourse.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        lblVcourse.setForeground(new java.awt.Color(255, 255, 255));
        lblVcourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/text-book-opened-from-top-view.png"))); // NOI18N
        lblVcourse.setText("View Course");
        lblVcourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVcourseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblVcourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblVcourseMouseExited(evt);
            }
        });
        jPanel7.add(lblVcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 270, 140));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 300, 180));

        jPanel8.setBackground(new java.awt.Color(52, 52, 52));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/plus.png"))); // NOI18N
        jLabel7.setText(" Add Fees");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, 140));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 260, 180));

        lblAdd.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        lblAdd.setForeground(new java.awt.Color(255, 255, 255));
        lblAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/plus.png"))); // NOI18N
        lblAdd.setText(" Add Fees");
        lblAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddMouseExited(evt);
            }
        });
        jPanel8.add(lblAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 240, 130));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 280, 180));

        jPanel10.setBackground(new java.awt.Color(52, 52, 52));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(0, 102, 102));
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/plus.png"))); // NOI18N
        jLabel9.setText(" Add Fees");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        jPanel11.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, 140));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 260, 180));

        lblEcourse.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        lblEcourse.setForeground(new java.awt.Color(255, 255, 255));
        lblEcourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/edit.png"))); // NOI18N
        lblEcourse.setText("Edit Course");
        lblEcourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEcourseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEcourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEcourseMouseExited(evt);
            }
        });
        jPanel10.add(lblEcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 250, 140));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 280, 180));

        panelLogout.setBackground(new java.awt.Color(52, 52, 52));
        panelLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelLogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(0, 102, 102));
        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/plus.png"))); // NOI18N
        jLabel10.setText(" Add Fees");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        jPanel13.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, 140));

        panelLogout.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 260, 180));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/logout.png"))); // NOI18N
        jLabel13.setText("Logout");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        panelLogout.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 70));

        jPanel1.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 170, 70));

        panelAbout.setBackground(new java.awt.Color(52, 52, 52));
        panelAbout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelAbout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(0, 102, 102));
        jPanel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/plus.png"))); // NOI18N
        jLabel14.setText(" Add Fees");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        jPanel17.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, 140));

        panelAbout.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 260, 180));

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/about.png"))); // NOI18N
        jLabel15.setText("About");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        panelAbout.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 60));

        jPanel1.add(panelAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 470, 170, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1250, 540));

        jPanel2.setBackground(new java.awt.Color(52, 52, 52));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 38)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ahmednagar College ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 360, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Station Road, Ahmednagar - 414001 Maharashtra");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 420, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("B.P.H.E. Society's ");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 220, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/d2de2njt.png"))); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 110, 150));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 160));

        setSize(new java.awt.Dimension(1268, 735));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblSrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSrecordMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(27,27,27);
        jPanel4.setBackground(clr);
    }//GEN-LAST:event_lblSrecordMouseEntered

    private void lblSrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSrecordMouseExited
        // TODO add your handling code here:
          Color clr=new Color(52,52,52);
        jPanel4.setBackground(clr);
    }//GEN-LAST:event_lblSrecordMouseExited

    private void lblVrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVrecordMouseEntered
        // TODO add your handling code here:
         Color clr=new Color(27,27,27);
        jPanel6.setBackground(clr);
    }//GEN-LAST:event_lblVrecordMouseEntered

    private void lblVrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVrecordMouseExited
        // TODO add your handling code here:
         Color clr=new Color(52,52,52);
        jPanel6.setBackground(clr);
    }//GEN-LAST:event_lblVrecordMouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseExited

    private void lblVreportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVreportMouseEntered
        // TODO add your handling code here:
         Color clr=new Color(27,27,27);
        jPanel3.setBackground(clr);
    }//GEN-LAST:event_lblVreportMouseEntered

    private void lblVreportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVreportMouseExited
        // TODO add your handling code here:
        Color clr=new Color(52,52,52);
        jPanel3.setBackground(clr);
    }//GEN-LAST:event_lblVreportMouseExited

    private void lblVcourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVcourseMouseEntered
        // TODO add your handling code here:
         Color clr=new Color(27,27,27);
        jPanel7.setBackground(clr);
    }//GEN-LAST:event_lblVcourseMouseEntered

    private void lblVcourseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVcourseMouseExited
        // TODO add your handling code here:
        Color clr=new Color(52,52,52);
        jPanel7.setBackground(clr);
    }//GEN-LAST:event_lblVcourseMouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseExited

    private void lblEcourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEcourseMouseEntered
        // TODO add your handling code here:
          Color clr=new Color(27,27,27);
        jPanel10.setBackground(clr);
        
    }//GEN-LAST:event_lblEcourseMouseEntered

    private void lblEcourseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEcourseMouseExited
        // TODO add your handling code here:
         Color clr=new Color(52,52,52);
        jPanel10.setBackground(clr);
    }//GEN-LAST:event_lblEcourseMouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseExited

    private void lblAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(27,27,27);
        jPanel8.setBackground(clr);
    }//GEN-LAST:event_lblAddMouseEntered

    private void lblAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseExited
        // TODO add your handling code here:
          Color clr=new Color(52,52,52);
        jPanel8.setBackground(clr);
    }//GEN-LAST:event_lblAddMouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
                Color clr=new Color(27,27,27);
                panelLogout.setBackground(clr);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
                 Color clr=new Color(52,52,52);
                 panelLogout.setBackground(clr);
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
                 Color clr=new Color(27,27,27);
                 panelAbout.setBackground(clr);
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
                   Color clr=new Color(52,52,52);
                   panelAbout.setBackground(clr);
    }//GEN-LAST:event_jLabel15MouseExited

    private void lblAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseClicked
                AddFees addFees=new AddFees();
                addFees.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_lblAddMouseClicked

    private void lblSrecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSrecordMouseClicked
                SearchRecord search = new SearchRecord();
                search.setVisible(true);
                this.dispose();
                
    }//GEN-LAST:event_lblSrecordMouseClicked

    private void lblEcourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEcourseMouseClicked
                EditCourse ec=new EditCourse();
                ec.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_lblEcourseMouseClicked

    private void lblVrecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVrecordMouseClicked
                ViewAllRecords var=new ViewAllRecords();
                var.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_lblVrecordMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
               CopyRightPage crp=new CopyRightPage();
               crp.setVisible(true);
               this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void lblVreportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVreportMouseClicked
                GenerateReport gr=new GenerateReport();
                gr.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_lblVreportMouseClicked

    private void lblVcourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVcourseMouseClicked
                  ViewCourse vc=new ViewCourse();
                vc.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_lblVcourseMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
                Login ln=new Login();
                ln.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblEcourse;
    private javax.swing.JLabel lblSrecord;
    private javax.swing.JLabel lblVcourse;
    private javax.swing.JLabel lblVrecord;
    private javax.swing.JLabel lblVreport;
    private javax.swing.JPanel panelAbout;
    private javax.swing.JPanel panelLogout;
    // End of variables declaration//GEN-END:variables
}
