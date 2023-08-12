/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package feesmanagement;

import java.awt.Color;
import java.sql.*;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class SearchRecord extends javax.swing.JFrame {

  DefaultTableModel model;
    public SearchRecord() {
        initComponents();
        setRecordsToTable();
    }
    
    public void setRecordsToTable()
    {
        try
        {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("select * from fees_details");
            ResultSet rs=pst.executeQuery();
            
            while(rs.next())
            {
                String receiptNo=rs.getString("reciept_no");
                String rollNo=rs.getString("roll_no");
                String studentName=rs.getString("student_name");
                String courseName=rs.getString("course_name");
                String paymentMode=rs.getString("payment_mode");
                float amount=rs.getFloat("total_amount");
                String remark=rs.getString("remark");
                
                Object[] obj={receiptNo,rollNo,studentName,courseName,paymentMode,amount,remark};
                
                model=(DefaultTableModel)tbl_studentdata.getModel();
                model.addRow(obj);
                
              
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void search(String str)
    {
         model=(DefaultTableModel)tbl_studentdata.getModel();
         TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
         tbl_studentdata.setRowSorter(trs);
         trs.setRowFilter(RowFilter.regexFilter(str));
         
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelsideBar = new javax.swing.JPanel();
        panelViewRecord = new javax.swing.JPanel();
        btnViewRecord = new javax.swing.JLabel();
        panelEdit = new javax.swing.JPanel();
        btnEdit = new javax.swing.JLabel();
        panelCourseList = new javax.swing.JPanel();
        btnCourseList = new javax.swing.JLabel();
        panelBack = new javax.swing.JPanel();
        btnBack = new javax.swing.JLabel();
        panelSearch = new javax.swing.JPanel();
        btnSearch = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        btnLogout = new javax.swing.JLabel();
        panelHome = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentdata = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsideBar.setBackground(new java.awt.Color(52, 52, 52));
        panelsideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelViewRecord.setBackground(new java.awt.Color(52, 52, 52));
        panelViewRecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelViewRecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnViewRecord.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnViewRecord.setForeground(new java.awt.Color(255, 255, 255));
        btnViewRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/view all record.png"))); // NOI18N
        btnViewRecord.setText("View Record");
        btnViewRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewRecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnViewRecordMouseExited(evt);
            }
        });
        panelViewRecord.add(btnViewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 250, 70));

        panelsideBar.add(panelViewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 329, 70));

        panelEdit.setBackground(new java.awt.Color(52, 52, 52));
        panelEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEdit.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/edit2.png"))); // NOI18N
        btnEdit.setText("Edit Course");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditMouseExited(evt);
            }
        });
        panelEdit.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 230, 60));

        panelsideBar.add(panelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 329, 70));

        panelCourseList.setBackground(new java.awt.Color(52, 52, 52));
        panelCourseList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelCourseList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCourseList.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnCourseList.setForeground(new java.awt.Color(255, 255, 255));
        btnCourseList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/list.png"))); // NOI18N
        btnCourseList.setText("Course List");
        btnCourseList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCourseListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCourseListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCourseListMouseExited(evt);
            }
        });
        panelCourseList.add(btnCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 220, 70));

        panelsideBar.add(panelCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 329, 70));

        panelBack.setBackground(new java.awt.Color(52, 52, 52));
        panelBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/left-arrow.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        panelBack.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 190, 60));

        panelsideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 329, 70));

        panelSearch.setBackground(new java.awt.Color(52, 52, 52));
        panelSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearch.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/search2.png"))); // NOI18N
        btnSearch.setText("Search Record");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
        });
        panelSearch.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 260, 60));

        panelsideBar.add(panelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 329, 70));

        panelLogout.setBackground(new java.awt.Color(52, 52, 52));
        panelLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelLogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/logout.png"))); // NOI18N
        btnLogout.setText(" Logout");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        panelLogout.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 190, 70));

        panelsideBar.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 329, 70));

        panelHome.setBackground(new java.awt.Color(52, 52, 52));
        panelHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/home.png"))); // NOI18N
        btnHome.setText(" HOME");
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        panelHome.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 190, 60));

        panelsideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 329, 70));

        getContentPane().add(panelsideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 700));

        jPanel1.setBackground(new java.awt.Color(192, 192, 192));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_studentdata.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        tbl_studentdata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Receipt No", "Roll No", "Student Name", "Course", "Payment Mode", "Amount", "Remark"
            }
        ));
        jScrollPane1.setViewportView(tbl_studentdata);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 720, 500));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 44)); // NOI18N
        jLabel1.setText("Search Record");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 290, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 19)); // NOI18N
        jLabel2.setText("Enter Search String :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, 30));

        txt_search.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        jPanel1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 310, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 330, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 790, 700));

        setSize(new java.awt.Dimension(1268, 735));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRecordMouseEntered
        Color clr=new Color(98,98,98);
        panelViewRecord.setBackground(clr);
    }//GEN-LAST:event_btnViewRecordMouseEntered

    private void btnViewRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRecordMouseExited
        Color clr=new Color(52,52,52);
        panelViewRecord.setBackground(clr);
    }//GEN-LAST:event_btnViewRecordMouseExited

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        Color clr=new Color(98,98,98);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        Color clr=new Color(52,52,52);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseExited

    private void btnCourseListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseListMouseEntered
        Color clr=new Color(98,98,98);
        panelCourseList.setBackground(clr);
    }//GEN-LAST:event_btnCourseListMouseEntered

    private void btnCourseListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseListMouseExited
        Color clr=new Color(52,52,52);
        panelCourseList.setBackground(clr);
    }//GEN-LAST:event_btnCourseListMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        Color clr=new Color(98,98,98);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        Color clr=new Color(52,52,52);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        Color clr=new Color(98,98,98);
        panelSearch.setBackground(clr);
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        Color clr=new Color(52,52,52);
        panelSearch.setBackground(clr);
    }//GEN-LAST:event_btnSearchMouseExited

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        Color clr=new Color(98,98,98);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        Color clr=new Color(52,52,52);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        Color clr=new Color(98,98,98);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        Color clr=new Color(52,52,52);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseExited

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
            
            String searchString =txt_search.getText();
            search(searchString);
    }//GEN-LAST:event_txt_searchKeyReleased

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
            home Home =new home();
            Home.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
            SearchRecord search =new SearchRecord();
            search.setVisible(true);
            this.dispose();
            
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnViewRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRecordMouseClicked
             ViewAllRecords var=new ViewAllRecords();
                var.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btnViewRecordMouseClicked

    private void btnCourseListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseListMouseClicked
                ViewCourse vc=new ViewCourse();
                vc.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btnCourseListMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
               home h=new home();
                h.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
                 EditCourse ec=new EditCourse();
                ec.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
             Login ln=new Login();
                ln.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btnLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(SearchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SearchRecord().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnCourseList;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel btnViewRecord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelCourseList;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelViewRecord;
    private javax.swing.JPanel panelsideBar;
    private javax.swing.JTable tbl_studentdata;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
