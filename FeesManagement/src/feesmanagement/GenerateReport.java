/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package feesmanagement;

import java.awt.Color;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GenerateReport extends javax.swing.JFrame {

    DefaultTableModel model ;
    
    public GenerateReport() {
        initComponents();
        fillComboBox();
    }

      public void fillComboBox()
    {
        try
        {
            
            Class.forName("org.postgresql.Driver");//class loading
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            //here we create referance variable of class that implements interface (i.e Connection , Statement)
            PreparedStatement pst = con.prepareStatement("select cname from course");
            ResultSet rs=pst.executeQuery();
            
            while(rs.next())
            {
                combo_courseDetails.addItem(rs.getString("cname"));//addItem() method is comboBox method
            
            }
     
        }
        catch(Exception e)
        {
            e.printStackTrace();//for printing errors\exception
            
        }
    }
    
     public void setRecordsToTable()
    {
            String cname=combo_courseDetails.getSelectedItem().toString();
            //this 3 or 4 line for set values to ? of prepared statement
            SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
            String fromDate = dateFormat.format(dateChooser_from.getDate());
            String toDate=dateFormat.format(dateChooser_to.getDate());
            
            Float totalAmount = 0.0f;//here Wrapper class used
            
        try
        {
            Class.forName("org.postgresql.Driver");//class loading
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            PreparedStatement pst=con.prepareStatement("select * from fees_details where date between ? and ? and course_name = ? ");
            
            pst.setString(1, fromDate);
            pst.setString(2,toDate);
            pst.setString(3,cname);
            
            ResultSet rs=pst.executeQuery();
            
            while(rs.next())
            {
                String receiptNo=rs.getString("reciept_no");
                String rollNO=rs.getString("roll_no");
                String studentName=rs.getString("student_name");
                String courseName=rs.getString("course_name");
                float amount=rs.getFloat("total_amount");
                String remark=rs.getString("remark");
               
                totalAmount = totalAmount + amount;
                
                Object[] obj={receiptNo,rollNO,studentName,courseName,amount,remark};
                
                model=(DefaultTableModel)tbl_feesDetails.getModel();
                model.addRow(obj);//every time record create an array an object
                
              
            }
            
            lbl_course.setText(cname);
            lbl_totalAmount.setText(totalAmount.toString());
            lbl_totalInWords.setText(NumberToWordsConverter.convert(totalAmount.intValue()));
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }  
     
    public void clearTable()
    {
        DefaultTableModel model= (DefaultTableModel)tbl_feesDetails.getModel();//here model(i.e obj) represent table(i.e tbl_feesDetails)
        model.setRowCount(1);// DefaultTableModel use to do modification on table
    }  
    
    public void exportToExcel()
    {
        try
        {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet ws= wb.createSheet();
        DefaultTableModel model= (DefaultTableModel)tbl_feesDetails.getModel();
        
        TreeMap<String,Object[]> map=new TreeMap<>();
        
        //below code for getting columnname
        map.put("0", new Object[]{model.getColumnName(0),model.getColumnName(1),model.getColumnName(2),model.getColumnName(3),model.getColumnName(4),model.getColumnName(5)});
        
        for(int i=1; i< model.getRowCount();i++)
        {
            map.put(Integer.toString(i),new Object[]{model.getValueAt(i, 0),model.getValueAt(i, 1),model.getValueAt(i, 2), model.getValueAt(i, 3),model.getValueAt(i, 4),model.getValueAt(i, 5)});
        }
        
        Set<String> id=map.keySet();
        
        XSSFRow fRow;
        
        int rowId =0;
        
        for(String key : id)//this loop iterate till we have data//work on row
        {//this loop for row 
            fRow=ws.createRow(rowId++);
            
            Object[] value =map.get(key);
            
            int cellId=0;
            for(Object object:value)//this loop for inserting values
            {
                XSSFCell cell =fRow.createCell(cellId++);
                cell.setCellValue(object.toString());
            }
            
        }
        
            FileOutputStream fos=new FileOutputStream(new File(txt_filePath.getText()));//uses for writing data in file
            wb.write(fos);
            JOptionPane.showMessageDialog(this,"file exported successfully :"+txt_filePath.getText());
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
        combo_courseDetails = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateChooser_to = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txt_filePath = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_feesDetails = new javax.swing.JTable();
        dateChooser_from = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        lbl_totalAmount = new javax.swing.JLabel();
        lbl_totalInWords = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

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

        panelsideBar.add(panelViewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 329, 70));

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

        panelsideBar.add(panelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 329, 70));

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

        panelsideBar.add(panelCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 329, 70));

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

        panelsideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 329, 70));

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

        panelsideBar.add(panelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 329, 70));

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

        panelsideBar.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 329, 70));

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

        panelsideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 329, 70));

        getContentPane().add(panelsideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 700));

        jPanel1.setBackground(new java.awt.Color(192, 192, 192));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combo_courseDetails.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        combo_courseDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(combo_courseDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 220, 30));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Select Course :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Select Date :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("From Date :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, 30));
        jPanel1.add(dateChooser_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 100, 30));

        jButton1.setBackground(new java.awt.Color(52, 52, 52));
        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, 30));

        jButton2.setBackground(new java.awt.Color(52, 52, 52));
        jButton2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Export To Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, 30));
        jPanel1.add(txt_filePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 300, 30));

        jButton3.setBackground(new java.awt.Color(52, 52, 52));
        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 30));

        jButton4.setBackground(new java.awt.Color(52, 52, 52));
        jButton4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Browse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, 30));

        tbl_feesDetails.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tbl_feesDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Receipt No", "Roll No", "Student Name", "Course", "Amount", "Remark"
            }
        ));
        jScrollPane1.setViewportView(tbl_feesDetails);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 690, 420));
        jPanel1.add(dateChooser_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 100, 30));

        jPanel2.setBackground(new java.awt.Color(214, 217, 222));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_totalAmount.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel2.add(lbl_totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 120, 30));

        lbl_totalInWords.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel2.add(lbl_totalInWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 310, 30));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setText("Total Amount Collected :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setText("Course Selected  :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        lbl_course.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel2.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 160, 30));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setText("Total Amount In Words :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 320, 190));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setText("To Date :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 870, 700));

        setSize(new java.awt.Dimension(1268, 735));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRecordMouseClicked
        ViewAllRecords var=new ViewAllRecords();
        var.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnViewRecordMouseClicked

    private void btnViewRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRecordMouseEntered
        Color clr=new Color(98,98,98);
        panelViewRecord.setBackground(clr);
    }//GEN-LAST:event_btnViewRecordMouseEntered

    private void btnViewRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRecordMouseExited
        Color clr=new Color(52,52,52);
        panelViewRecord.setBackground(clr);
    }//GEN-LAST:event_btnViewRecordMouseExited

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        EditCourse ec=new EditCourse();
        ec.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditMouseClicked

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

    private void combo_courseDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_courseDetailsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            
    SimpleDateFormat Date_Format = new SimpleDateFormat("YYYY-MM-dd");
    String datefrom= Date_Format.format(dateChooser_from.getDate());
    String dateto= Date_Format.format(dateChooser_to.getDate());

    MessageFormat header=new MessageFormat("Report From "+datefrom+" To " +dateto);//PAge format for Header
    MessageFormat footer=new MessageFormat("page{0,number,integer}"); //Page format for Fotter
    
    try
    {
        tbl_feesDetails.print(JTable.PrintMode.FIT_WIDTH, header, footer);// MessageFormatclass present in java.text.MessageFormat package
    }
    catch (PrinterException e) 
    {
            e.getMessage();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            exportToExcel();
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clearTable();
        setRecordsToTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            JFileChooser jfc=new JFileChooser();
            jfc.showOpenDialog(this);
            
            SimpleDateFormat dateFormat =new SimpleDateFormat("YYYY-MM-dd");
            String date= dateFormat.format(new Date());
            
            try
            {
                File f= jfc.getSelectedFile();
                String path =f.getAbsolutePath();
                
                path=path+"_"+date+".xlsx";
                txt_filePath.setText(path);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
         
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GenerateReport().setVisible(true);
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
    private javax.swing.JComboBox<String> combo_courseDetails;
    private com.toedter.calendar.JDateChooser dateChooser_from;
    private com.toedter.calendar.JDateChooser dateChooser_to;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_totalAmount;
    private javax.swing.JLabel lbl_totalInWords;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelCourseList;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelViewRecord;
    private javax.swing.JPanel panelsideBar;
    private javax.swing.JTable tbl_feesDetails;
    private javax.swing.JTextField txt_filePath;
    // End of variables declaration//GEN-END:variables
}
