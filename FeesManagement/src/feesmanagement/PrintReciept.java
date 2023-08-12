/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package feesmanagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.ImageIcon;
import java.sql.*;

/**
 *
 * @author OM
 */
public class PrintReciept extends javax.swing.JFrame {

    /**
     * Creates new form PrintReciept
     */
    public PrintReciept() {
        initComponents();
        getRecords();
        
        Container c=getContentPane();
        c.setBackground(new Color(0,153,153));
        
        
        
       
    }
    
    public void getRecords()
    {
        try
        {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst =con.prepareStatement("select * from fees_details order by reciept_no desc limit 1");//here reciept no according record will display
            ResultSet rs=pst.executeQuery();//above code can be write using result set last() and SCROLLABLE_INSENSITIVE
            
            rs.next();
            txt_receiptNo.setText(rs.getString("reciept_no"));
            txt_paymentMode.setText(rs.getString("payment_mode"));
            
            String paymentMode=rs.getString("payment_mode");
            
            if(paymentMode.equalsIgnoreCase("cash"))
            {
                lbl_cheque_Dd.setText("Cheque No ");
                txt_cheque_dd.setText("-");
                txt_bankName.setText("-");
                
            }
            
            if(paymentMode.equalsIgnoreCase("cheque"))
            {
                lbl_cheque_Dd.setText("Cheque No ");
                txt_cheque_dd.setText(rs.getString("cheque_no"));
                txt_bankName.setText(rs.getString("bank_name"));
                
            }
            
            if(paymentMode.equalsIgnoreCase("dd"))
            {
                lbl_cheque_Dd.setText("DD No ");
                txt_cheque_dd.setText(rs.getString("dd_no"));
                txt_bankName.setText(rs.getString("bank_name"));
                
            }
             
            if(paymentMode.equalsIgnoreCase("card"))
            {
                lbl_cheque_Dd.setText("Cheque No ");
                txt_cheque_dd.setText("-");
                txt_bankName.setText(rs.getString("bank_name"));
                
            } 
            
            txt_receivedFrom.setText(rs.getString("student_name"));
            txt_date.setText(rs.getString("date"));
            txt_gstin.setText(rs.getString("gstin"));
            txt_year1.setText(rs.getString("year1"));
            txt_year2.setText(rs.getString("year2"));
            
            txt_initialAmount.setText(rs.getString("amount"));
            txt_courseName.setText(rs.getString("course_name"));
            txt_cgst.setText(rs.getString("cgst"));
            txt_sgst.setText(rs.getString("sgst"));
            txt_total.setText(rs.getString("total_amount"));
            txt_totalInWords.setText(rs.getString("total_in_words"));
            txt_remark.setText(rs.getString("remark"));
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelsideBar = new javax.swing.JPanel();
        panelViewRecord = new javax.swing.JPanel();
        btnViewRecord = new javax.swing.JLabel();
        panelEditC = new javax.swing.JPanel();
        btnEditC = new javax.swing.JLabel();
        panelCourseList = new javax.swing.JPanel();
        btnCourseList = new javax.swing.JLabel();
        panelSearch = new javax.swing.JPanel();
        btnSearch = new javax.swing.JLabel();
        panelEdit = new javax.swing.JPanel();
        btnEdit = new javax.swing.JLabel();
        panelHome = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        panelPrint = new javax.swing.JPanel();
        btnPrint = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        btnLogout = new javax.swing.JLabel();
        panelBack = new javax.swing.JPanel();
        btnBack = new javax.swing.JLabel();
        panel_print = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_receiptNo = new javax.swing.JLabel();
        txt_paymentMode = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_cheque_dd = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_cheque_Dd = new javax.swing.JLabel();
        txt_bankName = new javax.swing.JLabel();
        txt_year2 = new javax.swing.JLabel();
        txt_receivedFrom = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_year1 = new javax.swing.JLabel();
        lbl_bankName = new javax.swing.JLabel();
        txt_gstin = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_date = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        txt_sgst = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_courseName = new javax.swing.JLabel();
        txt_initialAmount = new javax.swing.JLabel();
        txt_cgst = new javax.swing.JLabel();
        txt_cgst2 = new javax.swing.JLabel();
        txt_totalInWords = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txt_sgst2 = new javax.swing.JLabel();
        txt_total = new javax.swing.JLabel();
        txt_total2 = new javax.swing.JLabel();
        txt_remark = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txt_total4 = new javax.swing.JLabel();
        txt_total5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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
        btnViewRecord.setText(" View Record");
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

        panelsideBar.add(panelViewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 329, 70));

        panelEditC.setBackground(new java.awt.Color(52, 52, 52));
        panelEditC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelEditC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditC.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnEditC.setForeground(new java.awt.Color(255, 255, 255));
        btnEditC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/edit2.png"))); // NOI18N
        btnEditC.setText(" Edit Course");
        btnEditC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditCMouseExited(evt);
            }
        });
        panelEditC.add(btnEditC, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 230, 60));

        panelsideBar.add(panelEditC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 329, 60));

        panelCourseList.setBackground(new java.awt.Color(52, 52, 52));
        panelCourseList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelCourseList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCourseList.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnCourseList.setForeground(new java.awt.Color(255, 255, 255));
        btnCourseList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/list.png"))); // NOI18N
        btnCourseList.setText(" Course List");
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

        panelsideBar.add(panelCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 329, 70));

        panelSearch.setBackground(new java.awt.Color(52, 52, 52));
        panelSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearch.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/search2.png"))); // NOI18N
        btnSearch.setText(" Search Record");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
        });
        panelSearch.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 260, 60));

        panelsideBar.add(panelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 329, 60));

        panelEdit.setBackground(new java.awt.Color(52, 52, 52));
        panelEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEdit.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/edit2.png"))); // NOI18N
        btnEdit.setText(" Edit");
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
        panelEdit.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 190, -1));

        panelsideBar.add(panelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 329, 70));

        panelHome.setBackground(new java.awt.Color(52, 52, 52));
        panelHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setFont(new java.awt.Font("Sylfaen", 0, 25)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/home.png"))); // NOI18N
        btnHome.setText("  HOME");
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

        panelsideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 329, 60));

        panelPrint.setBackground(new java.awt.Color(52, 52, 52));
        panelPrint.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelPrint.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPrint.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/printer-.png"))); // NOI18N
        btnPrint.setText(" Print");
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrintMouseExited(evt);
            }
        });
        panelPrint.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 190, 70));

        panelsideBar.add(panelPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 329, 70));

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

        panelsideBar.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 329, -1));

        panelBack.setBackground(new java.awt.Color(52, 52, 52));
        panelBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/left-arrow.png"))); // NOI18N
        btnBack.setText(" Back");
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
        panelBack.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 190, 40));

        panelsideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 329, 60));

        getContentPane().add(panelsideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 690));

        panel_print.setBackground(new java.awt.Color(255, 255, 255));
        panel_print.setForeground(new java.awt.Color(0, 153, 255));
        panel_print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 255));
        jLabel16.setText("B.P.H.E. Society's ");
        panel_print.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 220, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 34)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("Ahmednagar College ");
        panel_print.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 360, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 255));
        jLabel12.setText("Station Road, Ahmednagar - 414001 Maharashtra");
        panel_print.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 370, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/d2de2njt.png"))); // NOI18N
        panel_print.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 120));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_print.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 770, 4));

        txt_receiptNo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_receiptNo.setForeground(new java.awt.Color(0, 153, 255));
        txt_receiptNo.setText("Receipt No :    ");
        panel_print.add(txt_receiptNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        txt_paymentMode.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_paymentMode.setForeground(new java.awt.Color(0, 153, 255));
        txt_paymentMode.setText("Payment Mode :");
        panel_print.add(txt_paymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Receipt No :      ACA -");
        panel_print.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txt_cheque_dd.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_cheque_dd.setForeground(new java.awt.Color(0, 153, 255));
        txt_cheque_dd.setText("Cheque_DD :");
        panel_print.add(txt_cheque_dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Payment Mode :");
        panel_print.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("The following payment in the college office for the year");
        panel_print.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        lbl_cheque_Dd.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lbl_cheque_Dd.setForeground(new java.awt.Color(0, 153, 255));
        lbl_cheque_Dd.setText("Cheque_DD :");
        panel_print.add(lbl_cheque_Dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txt_bankName.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_bankName.setForeground(new java.awt.Color(0, 153, 255));
        txt_bankName.setText("Bank Name :");
        panel_print.add(txt_bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        txt_year2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_year2.setForeground(new java.awt.Color(0, 153, 255));
        txt_year2.setText("2021");
        panel_print.add(txt_year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        txt_receivedFrom.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_receivedFrom.setForeground(new java.awt.Color(0, 153, 255));
        txt_receivedFrom.setText("Received From :");
        panel_print.add(txt_receivedFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel13.setText("-");
        panel_print.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 20, -1));

        txt_year1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_year1.setForeground(new java.awt.Color(0, 153, 255));
        txt_year1.setText("2020");
        panel_print.add(txt_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        lbl_bankName.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lbl_bankName.setForeground(new java.awt.Color(0, 153, 255));
        lbl_bankName.setText("Bank Name :");
        panel_print.add(lbl_bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        txt_gstin.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_gstin.setForeground(new java.awt.Color(0, 153, 255));
        txt_gstin.setText("GSTIN :");
        panel_print.add(txt_gstin, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, -1, -1));

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 255));
        jLabel19.setText("Amount(Rs)");
        panel_print.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, -1, -1));

        txt_date.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_date.setForeground(new java.awt.Color(0, 153, 255));
        txt_date.setText("Date :");
        panel_print.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, -1, -1));

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 153, 255));
        jLabel21.setText("GSTIN :");
        panel_print.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, -1));

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 255));
        jLabel22.setText("Date :");
        panel_print.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 153, 255));
        panel_print.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 250, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 153, 255));
        panel_print.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 770, 20));

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 255));
        jLabel20.setText("Received From :");
        panel_print.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        txt_sgst.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_sgst.setForeground(new java.awt.Color(0, 153, 255));
        txt_sgst.setText("sgst");
        panel_print.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, 80, -1));

        jLabel24.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 153, 255));
        jLabel24.setText("Head");
        panel_print.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        jLabel25.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 153, 255));
        jLabel25.setText("Sr No");
        panel_print.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel26.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 153, 255));
        jLabel26.setText("1");
        panel_print.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        txt_courseName.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_courseName.setForeground(new java.awt.Color(0, 153, 255));
        txt_courseName.setText("1");
        panel_print.add(txt_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 90, -1));

        txt_initialAmount.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_initialAmount.setForeground(new java.awt.Color(0, 153, 255));
        txt_initialAmount.setText("cgst");
        panel_print.add(txt_initialAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 80, -1));

        txt_cgst.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_cgst.setForeground(new java.awt.Color(0, 153, 255));
        txt_cgst.setText("cgst");
        panel_print.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 80, -1));

        txt_cgst2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_cgst2.setForeground(new java.awt.Color(0, 153, 255));
        txt_cgst2.setText("CGST(9 %)");
        panel_print.add(txt_cgst2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 70, -1));

        txt_totalInWords.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_totalInWords.setForeground(new java.awt.Color(0, 153, 255));
        txt_totalInWords.setText("Total in words :");
        panel_print.add(txt_totalInWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 330, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 153, 255));
        panel_print.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 770, 20));

        txt_sgst2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_sgst2.setForeground(new java.awt.Color(0, 153, 255));
        txt_sgst2.setText("SGST(9 %)");
        panel_print.add(txt_sgst2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 70, -1));

        txt_total.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_total.setForeground(new java.awt.Color(0, 153, 255));
        txt_total.setText("total");
        panel_print.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 500, 110, -1));

        txt_total2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_total2.setForeground(new java.awt.Color(0, 153, 255));
        txt_total2.setText("Receiver Signature");
        panel_print.add(txt_total2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 570, 150, -1));

        txt_remark.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_remark.setForeground(new java.awt.Color(0, 153, 255));
        txt_remark.setText("Remark :");
        panel_print.add(txt_remark, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, 160, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 153, 255));
        panel_print.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 490, 250, 10));

        txt_total4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_total4.setForeground(new java.awt.Color(0, 153, 255));
        txt_total4.setText("Total In Words :");
        panel_print.add(txt_total4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 110, -1));

        txt_total5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txt_total5.setForeground(new java.awt.Color(0, 153, 255));
        txt_total5.setText("Remark :");
        panel_print.add(txt_total5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 60, -1));

        getContentPane().add(panel_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 770, 640));

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Print Receipt");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 190, 40));

        pack();
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

    private void btnEditCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCMouseEntered
        Color clr=new Color(98,98,98);
        panelEditC.setBackground(clr);
    }//GEN-LAST:event_btnEditCMouseEntered

    private void btnEditCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCMouseExited
        Color clr=new Color(52,52,52);
        panelEditC.setBackground(clr);
    }//GEN-LAST:event_btnEditCMouseExited

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

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        Color clr=new Color(98,98,98);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        Color clr=new Color(52,52,52);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseExited

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        Color clr=new Color(98,98,98);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        Color clr=new Color(52,52,52);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
         Color clr=new Color(98,98,98);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        Color clr=new Color(52,52,52);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnPrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseEntered
          Color clr=new Color(98,98,98);
        panelPrint.setBackground(clr);
    }//GEN-LAST:event_btnPrintMouseEntered

    private void btnPrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseExited
        Color clr=new Color(52,52,52);
        panelPrint.setBackground(clr);
    }//GEN-LAST:event_btnPrintMouseExited

    private void btnPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseClicked
        
        PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");
            
            job.setPrintable(new Printable(){                           /*it is an anonymous Innner class */
            public int print(Graphics pg,PageFormat pf, int pageNum){   //Anonymous Innner class use for One Time Use 
                    pf.setOrientation(PageFormat.LANDSCAPE);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.50,0.50);
                
                panel_print.print(g2);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
            boolean ok = job.printDialog();
        if(ok){
        try{
            
        job.print();
        }
        catch (PrinterException ex){
                ex.printStackTrace();
        }
        
        }
    
    }//GEN-LAST:event_btnPrintMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
            UpdateFeesDetails update=new UpdateFeesDetails();
            update.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnViewRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRecordMouseClicked
            ViewAllRecords var=new ViewAllRecords();
            var.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnViewRecordMouseClicked

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
            home H=new home();
            H.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnHomeMouseClicked

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

    private void btnEditCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCMouseClicked
             EditCourse ec=new EditCourse();
                ec.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btnEditCMouseClicked

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
            java.util.logging.Logger.getLogger(PrintReciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintReciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintReciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintReciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintReciept().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnCourseList;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnEditC;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnPrint;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel btnViewRecord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_bankName;
    private javax.swing.JLabel lbl_cheque_Dd;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelCourseList;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelEditC;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelPrint;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelViewRecord;
    private javax.swing.JPanel panel_print;
    private javax.swing.JPanel panelsideBar;
    private javax.swing.JLabel txt_bankName;
    private javax.swing.JLabel txt_cgst;
    private javax.swing.JLabel txt_cgst2;
    private javax.swing.JLabel txt_cheque_dd;
    private javax.swing.JLabel txt_courseName;
    private javax.swing.JLabel txt_date;
    private javax.swing.JLabel txt_gstin;
    private javax.swing.JLabel txt_initialAmount;
    private javax.swing.JLabel txt_paymentMode;
    private javax.swing.JLabel txt_receiptNo;
    private javax.swing.JLabel txt_receivedFrom;
    private javax.swing.JLabel txt_remark;
    private javax.swing.JLabel txt_sgst;
    private javax.swing.JLabel txt_sgst2;
    private javax.swing.JLabel txt_total;
    private javax.swing.JLabel txt_total2;
    private javax.swing.JLabel txt_total4;
    private javax.swing.JLabel txt_total5;
    private javax.swing.JLabel txt_totalInWords;
    private javax.swing.JLabel txt_year1;
    private javax.swing.JLabel txt_year2;
    // End of variables declaration//GEN-END:variables
}
