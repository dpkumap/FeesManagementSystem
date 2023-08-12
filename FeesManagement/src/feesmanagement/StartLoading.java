/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package feesmanagement;


public class StartLoading extends javax.swing.JFrame {

    public StartLoading() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        myProgressBar = new javax.swing.JProgressBar();
        lbl_count = new javax.swing.JLabel();
        per = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(52, 52, 52));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fees");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Management System");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 90));

        jPanel2.setBackground(new java.awt.Color(192, 192, 192));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feesmanagement/images/rupee_system_128x128.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 130, 130));

        myProgressBar.setForeground(new java.awt.Color(52, 52, 52));
        jPanel2.add(myProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 450, 10));

        lbl_count.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        lbl_count.setText("Loading...");
        jPanel2.add(lbl_count, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        per.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        per.setText("%");
        jPanel2.add(per, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 490, 180));

        setSize(new java.awt.Dimension(484, 270));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      StartLoading sl=new StartLoading();
      sl.setVisible(true);
      try
      {
          for(int i=0;i<=100;i++)
          {
              Thread.sleep(40);
              sl.myProgressBar.setValue(i);
              sl.per.setText(Integer.toString(i)+"%");
          }
      }
      catch(Exception e)
      {
          
      }
      new Login().setVisible(true);
      sl.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_count;
    private javax.swing.JProgressBar myProgressBar;
    private javax.swing.JLabel per;
    // End of variables declaration//GEN-END:variables
}
