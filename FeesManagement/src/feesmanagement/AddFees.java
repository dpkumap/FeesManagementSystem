/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package feesmanagement;

import java.sql.*;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class AddFees extends javax.swing.JFrame {

   
    public AddFees() {
        initComponents();
        displayCashFirst();
        fillComboBox();
        
        int receiptNo=getReceiptNo();
        txt_receiptNo.setText(Integer.toString(receiptNo));
        
    }
    
    public void displayCashFirst()
    {
        lbl_DDno.setVisible(false);
        lbl_chequeNo.setVisible(false);
        lbl_bankName.setVisible(false);
        
        txt_DDNo.setVisible(false);
        txt_ChequeNo.setVisible(false);
        txt_bankName.setVisible(false);
        
    }
    public boolean validation()
    {
        // Validation OF UserName
        if(txt_recievedFrom.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter Receiver Name");
            return false;
        }
        
        // Validation OF Roll No
        if(txt_rollNo.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter Roll No");
            return false;
        }
        
        // Validation OF Date
        if(dateChooser.getDate() ==null)
        {
            JOptionPane.showMessageDialog(this, "Please Select a Date");
            return false;
        }
        
        // Validation OF Amount
        if(txt_amount.getText().equals("")| txt_amount.getText().matches("[0-9]+")== false)
        {
            JOptionPane.showMessageDialog(this, "Please enter amount in (numbers)");
            return false;
        }
        
        //validation Cheque Item of ComboBox
        if(combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("cheque"))
        {
            if(txt_ChequeNo.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please enter Cheque No");
                return false;
            }
            
            if(txt_bankName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please Enter Bank Name");
                return false;
            }
            
        }
        
        //validation DD Item of ComboBox
        if(combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("dd"))
        {
           if(txt_DDNo.getText().equals(""))
           {
               JOptionPane.showMessageDialog(this, "Please Enter DD NO");
                return false;
           }
           
           if(txt_bankName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please Enter Bank Name");
                return false;
            }
        }
        
        //validation card Item of ComboBox
        if(combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("card"))
        {
            if(txt_bankName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please Enter Bank Name");
                return false;
            }
            
        }
                
      return true;
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
                comboCourse.addItem(rs.getString("cname"));
            
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();//for printing errors\exception
            
        }
    }
    
    public int getReceiptNo()
    {
        int receiptNo = 0;
        try
        {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("select max(reciept_no) from fees_Details");
            ResultSet rs=pst.executeQuery();
            
            if(rs.next()==true)
            {
                receiptNo=rs.getInt(1);
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return receiptNo+1;
    }
    
    public String insertData()
    {
        String status= "";
        
        int recieptNo=Integer.parseInt(txt_receiptNo.getText());
        String studentName=txt_recievedFrom.getText();
        String rollNo=txt_rollNo.getText();
        String paymentMode =combo_PaymentMode.getSelectedItem().toString();
        String chequeNo=txt_ChequeNo.getText();
        String bankName=txt_bankName.getText();
        String ddNo=txt_DDNo.getText();
        String courseName = txt_courseName.getText();
        String gstin=txt_GSTNo.getText();
        float totalAmount = Float.parseFloat(txt_total.getText());
        
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date =dateFormat.format(dateChooser.getDate());
        
        float initialAmount=Float.parseFloat(txt_amount.getText());
        float cgst=Float.parseFloat(txt_cgst.getText());
        float sgst=Float.parseFloat(txt_sgst.getText());
        String totalInWords=txt_total_words.getText();
        String remark=txt_remark.getText();
        int year1=Integer.parseInt(txt_year1.getText());
        int year2=Integer.parseInt(txt_year2.getText());

        try
        {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1,recieptNo);
            pst.setString(2,studentName);
            pst.setString(3,rollNo );
            pst.setString(4,paymentMode);
            pst.setString(5,chequeNo);
            pst.setString(6,bankName);
            pst.setString(7,ddNo);
            pst.setString(8,courseName);
            pst.setString(9,gstin); 
            
            pst.setFloat(10,totalAmount);
            pst.setString(11,date);
            pst.setFloat(12,initialAmount);
            pst.setFloat(13,cgst);
            pst.setFloat(14,sgst);
            pst.setString(15,totalInWords);
            pst.setString(16,remark);
            pst.setInt(17,year1);
            pst.setInt(18,year2);
            
            int rowCount=pst.executeUpdate();
            if(rowCount==1)
            {
                status="success";
          
            }else
            {
                status="Failed";
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        return status;
        
        
    }
    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelParent = new javax.swing.JPanel();
        lbl_DDno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_chequeNo = new javax.swing.JLabel();
        lbl_bankName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_GSTNo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_DDNo = new javax.swing.JTextField();
        txt_bankName = new javax.swing.JTextField();
        txt_ChequeNo = new javax.swing.JTextField();
        txt_receiptNo = new javax.swing.JTextField();
        combo_PaymentMode = new javax.swing.JComboBox<>();
        dateChooser = new com.toedter.calendar.JDateChooser();
        panelChild = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_year2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        comboCourse = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_rollNo = new javax.swing.JTextField();
        txt_total_words = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_cgst = new javax.swing.JTextField();
        txt_courseName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_sgst = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_recievedFrom = new javax.swing.JTextField();
        txt_year1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
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

        panelParent.setBackground(new java.awt.Color(192, 192, 192));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_DDno.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lbl_DDno.setText("DD NO : ");
        panelParent.add(lbl_DDno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("ACA-");
        panelParent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        lbl_chequeNo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lbl_chequeNo.setText("Cheque No :");
        panelParent.add(lbl_chequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        lbl_bankName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lbl_bankName.setText("Bank Name :");
        panelParent.add(lbl_bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Date : ");
        panelParent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, -1));

        txt_GSTNo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txt_GSTNo.setText("22HVIGI55");
        panelParent.add(txt_GSTNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setText("Mode fo Payment :");
        panelParent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setText("GST No :");
        panelParent.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setText("Receipt No :");
        panelParent.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        txt_DDNo.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_DDNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DDNoActionPerformed(evt);
            }
        });
        panelParent.add(txt_DDNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 160, 30));

        txt_bankName.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_bankName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bankNameActionPerformed(evt);
            }
        });
        panelParent.add(txt_bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 160, 30));

        txt_ChequeNo.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_ChequeNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ChequeNoActionPerformed(evt);
            }
        });
        panelParent.add(txt_ChequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 160, 30));

        txt_receiptNo.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        panelParent.add(txt_receiptNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 22, 160, 30));

        combo_PaymentMode.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        combo_PaymentMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Cash", "Card", " " }));
        combo_PaymentMode.setSelectedIndex(2);
        combo_PaymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_PaymentModeActionPerformed(evt);
            }
        });
        panelParent.add(combo_PaymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 160, 30));
        panelParent.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 140, -1));

        panelChild.setBackground(new java.awt.Color(192, 192, 192));
        panelChild.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setText("the following payment in the college office for the year");
        panelChild.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel11.setText("To ");
        panelChild.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 30, -1));

        txt_year2.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year2ActionPerformed(evt);
            }
        });
        panelChild.add(txt_year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 60, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel12.setText("Recieved From :");
        panelChild.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        txt_total.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        panelChild.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 230, -1));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setText("Roll No :");
        panelChild.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 70, 30));

        comboCourse.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        comboCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        comboCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCourseActionPerformed(evt);
            }
        });
        panelChild.add(comboCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 310, 30));

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel14.setText("Amount");
        panelChild.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 60, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelChild.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 730, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panelChild.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 250, 30));

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel15.setText("Remark :");
        panelChild.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 80, 30));

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel17.setText("Head");
        panelChild.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 60, -1));

        txt_rollNo.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_rollNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rollNoActionPerformed(evt);
            }
        });
        panelChild.add(txt_rollNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 60, -1));

        txt_total_words.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_total_words.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_wordsActionPerformed(evt);
            }
        });
        panelChild.add(txt_total_words, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 350, -1));

        txt_amount.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        panelChild.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 230, -1));

        txt_cgst.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cgstActionPerformed(evt);
            }
        });
        panelChild.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 230, -1));

        txt_courseName.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_courseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseNameActionPerformed(evt);
            }
        });
        panelChild.add(txt_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 350, -1));

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel18.setText("SGST 9%");
        panelChild.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 70, 30));

        txt_sgst.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_sgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sgstActionPerformed(evt);
            }
        });
        panelChild.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 230, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        panelChild.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 730, 30));

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel19.setText("Reciever Signature");
        panelChild.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 140, 30));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane1.setViewportView(txt_remark);

        panelChild.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 350, 70));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        panelChild.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 250, 30));

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel20.setText("Total in words :");
        panelChild.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 130, 30));

        btn_print.setBackground(new java.awt.Color(79, 205, 11));
        btn_print.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        panelChild.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, -1, 30));

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel21.setText("Course");
        panelChild.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 83, 60, 30));

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel22.setText("CGST 9%");
        panelChild.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 70, 30));

        txt_recievedFrom.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_recievedFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_recievedFromActionPerformed(evt);
            }
        });
        panelChild.add(txt_recievedFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 310, 30));

        txt_year1.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txt_year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year1ActionPerformed(evt);
            }
        });
        panelChild.add(txt_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 60, -1));

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel23.setText("Sr No");
        panelChild.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 60, -1));

        panelParent.add(panelChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 800, 500));

        getContentPane().add(panelParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 810, 690));

        panelsideBar.setBackground(new java.awt.Color(52, 52, 52));
        panelsideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelViewRecord.setBackground(new java.awt.Color(52, 52, 52));
        panelViewRecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(214, 217, 222), null, null));
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

        panelsideBar.add(panelViewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 329, 70));

        panelEdit.setBackground(new java.awt.Color(52, 52, 52));
        panelEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(214, 217, 222), null, null));
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

        panelsideBar.add(panelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 329, 70));

        panelCourseList.setBackground(new java.awt.Color(52, 52, 52));
        panelCourseList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(214, 217, 222), null, null));
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

        panelsideBar.add(panelCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 329, 70));

        panelBack.setBackground(new java.awt.Color(52, 52, 52));
        panelBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(214, 217, 222), null, null));
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

        panelsideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 329, 70));

        panelSearch.setBackground(new java.awt.Color(52, 52, 52));
        panelSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(214, 217, 222), null, null));
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

        panelsideBar.add(panelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 329, 70));

        panelLogout.setBackground(new java.awt.Color(52, 52, 52));
        panelLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(214, 217, 222), null, null));
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

        panelsideBar.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 329, 70));

        panelHome.setBackground(new java.awt.Color(52, 52, 52));
        panelHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 255, 255), null, null));
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

        panelsideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 329, 70));

        getContentPane().add(panelsideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 690));

        setSize(new java.awt.Dimension(1277, 725));
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

    private void txt_ChequeNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ChequeNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ChequeNoActionPerformed

    private void txt_DDNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DDNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DDNoActionPerformed

    private void txt_bankNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bankNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bankNameActionPerformed

    private void txt_year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_year2ActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_rollNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rollNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rollNoActionPerformed

    private void txt_total_wordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_wordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_wordsActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
      //here Wrapper Class(i.e Float[use for primtive to obj]) use to Convert Amount in Float
      
     Float amt=Float.parseFloat(txt_amount.getText());
     
     Float cgst=(float)(amt * 0.09);//in java by default decimal values are double(thats why typecast)
     Float sgst=(float) (amt * 0.09);
     
     txt_cgst.setText(cgst.toString());
     txt_sgst.setText(sgst.toString());
     
     float total =amt + cgst + sgst;
     
     txt_total.setText(Float.toString(total));
     
     txt_total_words.setText(NumberToWordsConverter.convert((int)total)+ " Only");//For Amount To Convert Number to Word 
     
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_cgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cgstActionPerformed

    private void txt_courseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_courseNameActionPerformed

    private void txt_sgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sgstActionPerformed

    private void txt_recievedFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_recievedFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_recievedFromActionPerformed

    private void combo_PaymentModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_PaymentModeActionPerformed
            if(combo_PaymentMode.getSelectedIndex()==0)
            {
                lbl_DDno.setVisible(true);
                txt_DDNo.setVisible(true);
                
                lbl_chequeNo.setVisible(false);
                txt_ChequeNo.setVisible(false);
                
                lbl_bankName.setVisible(true);
                txt_bankName.setVisible(true);
                
            }
            
             if(combo_PaymentMode.getSelectedIndex()==1)
            {
                lbl_DDno.setVisible(false);
                txt_DDNo.setVisible(false);
                
                lbl_chequeNo.setVisible(true);
                txt_ChequeNo.setVisible(true);
                
                lbl_bankName.setVisible(true);
                txt_bankName.setVisible(true);
                
            }
             if(combo_PaymentMode.getSelectedIndex()==2)
            {
                lbl_DDno.setVisible(false);
                txt_DDNo.setVisible(false);
                
                lbl_chequeNo.setVisible(false);
                txt_ChequeNo.setVisible(false);
                
                lbl_bankName.setVisible(false);
                txt_bankName.setVisible(false);
                
            } 
             if(combo_PaymentMode.getSelectedItem().equals("Card"))
            {
                //here getSelectedItem() returns obj (equals() method is present in object ClasssequalEgnoreCase)
                lbl_DDno.setVisible(false);
                txt_DDNo.setVisible(false);
                
                lbl_chequeNo.setVisible(false);
                txt_ChequeNo.setVisible(false);
                
                lbl_bankName.setVisible(true);
                txt_bankName.setVisible(true);
                
            }  
    }//GEN-LAST:event_combo_PaymentModeActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        if(validation()==true)
        {
            String result=insertData();
            
            if(result.equals("success"))
            {
                JOptionPane.showMessageDialog(this,"Record Inserted Successfully");
                
                PrintReciept p= new PrintReciept();//To redirect from page another 
                p.setVisible(true);//Just Create Object of that file
                this.dispose();
                
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Record Insertion Failed");
            }
        }
        
    }//GEN-LAST:event_btn_printActionPerformed

    private void comboCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCourseActionPerformed
            txt_courseName.setText(comboCourse.getSelectedItem().toString());
    }//GEN-LAST:event_comboCourseActionPerformed

    private void txt_year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_year1ActionPerformed

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
                home Home=new home();
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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
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
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox<String> comboCourse;
    private javax.swing.JComboBox<String> combo_PaymentMode;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_DDno;
    private javax.swing.JLabel lbl_bankName;
    private javax.swing.JLabel lbl_chequeNo;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelChild;
    private javax.swing.JPanel panelCourseList;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelParent;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelViewRecord;
    private javax.swing.JPanel panelsideBar;
    private javax.swing.JTextField txt_ChequeNo;
    private javax.swing.JTextField txt_DDNo;
    private javax.swing.JLabel txt_GSTNo;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bankName;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_courseName;
    private javax.swing.JTextField txt_receiptNo;
    private javax.swing.JTextField txt_recievedFrom;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_rollNo;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_total_words;
    private javax.swing.JTextField txt_year1;
    private javax.swing.JTextField txt_year2;
    // End of variables declaration//GEN-END:variables
}
