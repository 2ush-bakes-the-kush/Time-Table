/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rup.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahe
 */
public class viewTeacherTable extends javax.swing.JFrame {

    /**
     * Creates new form viewTeacherTable
     */
    public viewTeacherTable() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton1.setText("Display");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "08:00-09:00  ", "09:00-10:00", "10:00-10:30  ", "10:30-11:30 ", "11:30-12:30", "12:30-01:00", "01:00-02:00     ", "02:00-03:00", "03:00-03:30", "03:30-04:30", "04:30-05:30 "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Teacher ID");

        jButton2.setText("HOME");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(477, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(455, 455, 455))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system", "qwerty123");
            Statement stmt=(Statement) con.createStatement();
            String a=jComboBox1.getSelectedItem().toString();
            //int b=Integer.parseInt(jComboBox2.getSelectedItem().toString());
            //String c=jComboBox3.getSelectedItem().toString();;
            String query2="select distinct(Section) from teaches where TID='"+a+"'";
           // System.out.println (query2);
            ResultSet rs2=stmt.executeQuery(query2);
            rs2.next();
            String c=rs2.getString(1);
            char [] bre= {'B','R','E','A','K','.'}; int i=0;
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            //System.out.print(gets("ICT302",c));
            int rowCount = model.getRowCount();//Remove rows one by one from the end of the table
            for (int j=rowCount-1; j>=0;j--)
            model.removeRow(j);
            String query="select * from "+a;
            //System.out.print (query);
            ResultSet rs=stmt.executeQuery(query);
            for(int m=0;m<=5;m++)
            {
                rs.next();
                Object[] row = {rs.getString(1),gets(rs.getString(2),c),gets(rs.getString(3),c),bre[i],gets(rs.getString(4),c),gets(rs.getString(5),c),bre[i],gets(rs.getString(6),c),gets(rs.getString(7),c),bre[i],gets(rs.getString(8),c),gets(rs.getString(9),c)};
                model.addRow(row);
                i++;
            }
        }
        catch (SQLException e) {
            System.out.println("Connection Failed! Check output console"+e);

        }       // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
             try{     
        Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system", "qwerty123");
             Statement stmt=(Statement) con.createStatement();
             String query="select distinct(TID) from teaches";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {   
                String branch=rs.getString(1);
                jComboBox1.addItem(branch);
            }
        }
                catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        
    }       
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        new admin().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    public String gets(String SID,String sec){  
        try{ 
            if(SID.equals("0")){
                return(" ");
            }
            else{
            Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system", "qwerty123");
             Statement stmt=(Statement) con.createStatement();
             String query1="Select name from subject where id='"+SID+"'";
             //System.out.print (query1);
             ResultSet rs1=stmt.executeQuery(query1);
             rs1.next();
             String Subject=rs1.getString(1);
             char ch= SID.charAt(3);
             
             return(Subject+" in Sem "+ch+" "+sec);   
            }
        }
                catch (SQLException e) {
                System.out.println("Connection Failed! Check output console"+e);
                return ("Error");
    } 
    }
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
            java.util.logging.Logger.getLogger(viewTeacherTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewTeacherTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewTeacherTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewTeacherTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewTeacherTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
