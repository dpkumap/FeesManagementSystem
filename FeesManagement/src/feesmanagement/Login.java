/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package feesmanagement;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
 public String username;
    
    public Login() {
        initComponents();
   
    }
    
    void userVerification(String username,String password)
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            String sql="select * from signup where username=? and password=?";//for checking username and password
            PreparedStatement pst=con.prepareStatement(sql);
            
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
               JOptionPane.showMessageDialog(this, "Login Successful");
               home home=new home();
               home.show();
               this.dispose();//current frame dispose next frame open
           
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Wrong username or Password");
            }
           
        }
        catch(Exception e)
        {
            
        }
        
    }
    
   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnExit = new javax.swing.JButton();
        btnSignup = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(192, 192, 192));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel3.setText("Enter Password :");
        jLabel3.setPreferredSize(new java.awt.Dimension(178, 27));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel4.setText("Enter Username :");
        jLabel4.setPreferredSize(new java.awt.Dimension(178, 27));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        txtUsername.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        txtUsername.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 52, 240, 40));

        txtPassword.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtPassword.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 240, 40));

        btnExit.setBackground(new java.awt.Color(52, 52, 52));
        btnExit.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/exit.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setPreferredSize(new java.awt.Dimension(86, 32));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 130, 50));

        btnSignup.setBackground(new java.awt.Color(52, 52, 52));
        btnSignup.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        btnSignup.setForeground(new java.awt.Color(255, 255, 255));
        btnSignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/signup.png"))); // NOI18N
        btnSignup.setText("Signup");
        btnSignup.setPreferredSize(new java.awt.Dimension(86, 32));
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 140, 50));

        btnLogin.setBackground(new java.awt.Color(52, 52, 52));
        btnLogin.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/login.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setPreferredSize(new java.awt.Dimension(86, 32));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 130, 50));

        lblError.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblError.setForeground(new java.awt.Color(204, 0, 0));
        lblError.setPreferredSize(new java.awt.Dimension(51, 20));
        jPanel1.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 370, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 730, 350));

        jPanel2.setBackground(new java.awt.Color(52, 52, 52));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/admin.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 45)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 110));

        setSize(new java.awt.Dimension(743, 498));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        username=txtUsername.getText();
        String password=txtPassword.getText();
        if(username.trim().equals("")||password.trim().equals(""))//trim method trim space
        {
            lblError.setText("Please Enter Username and Password");
        }
        else
        {
            userVerification(username,password);
            
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        // TODO add your handling code here:
          Color clr=new Color(52,52,52);
        btnSignup.setBackground(clr);
        Signup_Page signup=new Signup_Page();
        signup.show();
        this.dispose();
       
    }//GEN-LAST:event_btnSignupActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblError;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
