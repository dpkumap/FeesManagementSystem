/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package feesmanagement;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author OM
 */
public class EditCourse extends javax.swing.JFrame {

   DefaultTableModel model;
   
    public EditCourse() {
        initComponents();
        setRecordsToTable();
    }

    public void setRecordsToTable()
    {
        try
        {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("select * from course");
            ResultSet rs=pst.executeQuery();
            
            while(rs.next())
            {
                String courseId=rs.getString("id");
                String cname=rs.getString("cname");
                String cost=rs.getString("cost");
               
                
                Object[] obj={courseId,cname,cost};
                
                model=(DefaultTableModel)tbl_courseData.getModel();
                model.addRow(obj);
                
              
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    // Add Button Action Method
    public void addCourse(int id,String cname,float cost)//these are parameters of methods
    {
        try
        {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("insert into course values(?,?,?)");
            //here we have to set values for(?) before execution of statement
            
            pst.setInt(1, id);
            pst.setString(2,cname);
            pst.setFloat(3, cost);
            
            int rowCount = pst.executeUpdate();
            if(rowCount == 1)
            {
                JOptionPane.showMessageDialog(this,"Course Added Successfully");
                clearTable();
                setRecordsToTable();
                clearTxtField();                
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Course Insertion failed");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    // Update Button Action method
    public void update(int id,String cname,float cost)
    {
         try
        {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("update course set cname=?, cost=? where id=?");
            //here we have to set values for(?) before execution of statement
            
            
            pst.setString(1,cname);
            pst.setFloat(2, cost);
            pst.setInt(3, id);
            
            int rowCount = pst.executeUpdate();
            if(rowCount == 1)
            {
                JOptionPane.showMessageDialog(this,"Course Updation Successfully");
                clearTable();
                setRecordsToTable();
                clearTxtField();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Course Updation failed");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
      // Delete Button Action method 
      public void delete(int id)
    {
         try
        {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("delete from course where id = ?");
            //here we have to set values for(?) before execution of statement
            
           
            pst.setInt(1, id);
            
            int rowCount = pst.executeUpdate();
            if(rowCount == 1)
            {
                JOptionPane.showMessageDialog(this,"Course Deletion Successfully");
                clearTable();
                setRecordsToTable();
               clearTxtField();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Course Deletion failed");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void clearTable()
    {
        DefaultTableModel model= (DefaultTableModel)tbl_courseData.getModel();
        model.setRowCount(0);// DefaultTableModel use to do modification on table
    }
    
    public void clearTxtField()
    {
                txt_courseId.setText("");
                txt_courseName.setText("");
                txt_coursePrice.setText("");
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_courseData = new javax.swing.JTable();
        txt_coursePrice = new javax.swing.JTextField();
        txt_courseId = new javax.swing.JTextField();
        txt_courseName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(192, 192, 192));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_courseData.setBackground(new java.awt.Color(248, 248, 255));
        tbl_courseData.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tbl_courseData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course id", "Course Name", "Course Price"
            }
        ));
        tbl_courseData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_courseDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_courseData);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, -1, 560));

        txt_coursePrice.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_coursePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coursePriceActionPerformed(evt);
            }
        });
        jPanel1.add(txt_coursePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 210, 40));

        txt_courseId.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        jPanel1.add(txt_courseId, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 210, 40));

        txt_courseName.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        jPanel1.add(txt_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 210, 40));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 19)); // NOI18N
        jLabel1.setText("Course Price :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 120, 40));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 19)); // NOI18N
        jLabel2.setText("Course Id :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 100, 40));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 19)); // NOI18N
        jLabel3.setText("Course Name :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 120, 40));

        jButton1.setBackground(new java.awt.Color(52, 52, 52));
        jButton1.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/delete.png"))); // NOI18N
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, -1, 50));

        jButton2.setBackground(new java.awt.Color(52, 52, 52));
        jButton2.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/add2.png"))); // NOI18N
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, -1, 50));

        jButton3.setBackground(new java.awt.Color(52, 52, 52));
        jButton3.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/update.png"))); // NOI18N
        jButton3.setText("UPDATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, -1, 50));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 44)); // NOI18N
        jLabel4.setText("Edit Course Details");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 380, 20));

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

        panelsideBar.add(panelViewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 329, 70));

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

        panelsideBar.add(panelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 329, 70));

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

        panelsideBar.add(panelCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 329, 70));

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

        panelsideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 329, 70));

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

        panelsideBar.add(panelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 329, 70));

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

        panelsideBar.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 329, 70));

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

        panelsideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 329, 70));

        jPanel1.add(panelsideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 700));

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

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        SearchRecord search = new SearchRecord();
        search.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSearchMouseClicked

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

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        home Home = new home();
        Home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        Color clr=new Color(98,98,98);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        Color clr=new Color(52,52,52);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseExited

    private void txt_coursePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coursePriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_coursePriceActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                
                int id=Integer.parseInt(txt_courseId.getText());
                String cname=txt_courseName.getText();
                float cost=Float.parseFloat(txt_coursePrice.getText());
                
                update(id, cname, cost);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                
                int id=Integer.parseInt(txt_courseId.getText());//this line for getting Id From TextField
          
                delete(id);
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_courseDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_courseDataMouseClicked
            
            int rowNo =tbl_courseData.getSelectedRow();// it return selected row (in iNt) our row start with 0 
            TableModel model= tbl_courseData.getModel();// these 2 lines used to perform operation  on table
            
            txt_courseId.setText(model.getValueAt(rowNo,0).toString()); 
            txt_courseName.setText((String)model.getValueAt(rowNo,1));// Type Casting of var from int to string
            txt_coursePrice.setText(model.getValueAt(rowNo,2).toString());//getValueAt()- take 2 arg (1- row number) AND (2 - column index(i.e cloumn name)) 
    }//GEN-LAST:event_tbl_courseDataMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                     int id=Integer.parseInt(txt_courseId.getText());
                    String cname=txt_courseName.getText();
                    float cost=Float.parseFloat(txt_coursePrice.getText());
            
                    addCourse(id,cname,cost);
               
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
             EditCourse ec=new EditCourse();
             ec.setVisible(true);
             this.dispose();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnViewRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRecordMouseClicked
                ViewAllRecords var=new ViewAllRecords();
                var.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btnViewRecordMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
            home Home=new home();//on label we cannot Add actionPerformed method
            Home.setVisible(true);
            this.dispose();

    }//GEN-LAST:event_btnBackMouseClicked

    private void btnCourseListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseListMouseClicked
              ViewCourse vc=new ViewCourse();
                vc.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btnCourseListMouseClicked

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCourse().setVisible(true);
            }
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JTable tbl_courseData;
    private javax.swing.JTextField txt_courseId;
    private javax.swing.JTextField txt_courseName;
    private javax.swing.JTextField txt_coursePrice;
    // End of variables declaration//GEN-END:variables
}
