/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author jijwa
 */
public class frmSuperStringsJW extends javax.swing.JFrame {

    /**
     * Creates new form frmSuperStringsJW
     */
    public frmSuperStringsJW() {
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

        txtFirstString = new javax.swing.JTextField();
        lblOperation = new javax.swing.JLabel();
        cmbOperation = new javax.swing.JComboBox<>();
        lblFirstString = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblSecondString = new javax.swing.JLabel();
        txtSecondString = new javax.swing.JTextField();
        lblResults = new javax.swing.JLabel();
        lblResultsHeader = new javax.swing.JLabel();
        btnDetermineResults = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Super String Software");

        txtFirstString.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFirstString.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstStringActionPerformed(evt);
            }
        });

        lblOperation.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblOperation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOperation.setText("Select your Operation");

        cmbOperation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbOperation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Length of String", "Capitalize String", "Determine the Fourth Character", "Determine if Strings are the Same", "Determine if a Letter is in a String", "Determine the Fourth, Fifth and Sixth Characters", "Replace \"i\" with \"u\"", " " }));
        cmbOperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOperationActionPerformed(evt);
            }
        });

        lblFirstString.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFirstString.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFirstString.setText("Enter a String");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Super String Software");

        lblSecondString.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSecondString.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSecondString.setMaximumSize(new java.awt.Dimension(395, 24));
        lblSecondString.setMinimumSize(new java.awt.Dimension(295, 0));

        txtSecondString.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSecondString.setToolTipText("");
        txtSecondString.setEnabled(false);
        txtSecondString.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecondStringActionPerformed(evt);
            }
        });

        lblResults.setBackground(new java.awt.Color(255, 255, 255));
        lblResults.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblResults.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResults.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblResults.setOpaque(true);

        lblResultsHeader.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblResultsHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultsHeader.setText("String Length");

        btnDetermineResults.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDetermineResults.setText("Determine Results");
        btnDetermineResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetermineResultsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFirstString, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFirstString, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblSecondString, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                            .addComponent(txtSecondString, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblResults, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                            .addComponent(lblResultsHeader, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                            .addComponent(btnDetermineResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblOperation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbOperation, 0, 395, Short.MAX_VALUE))
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(lblOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFirstString, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFirstString, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSecondString, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSecondString, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblResultsHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResults, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDetermineResults, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstStringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstStringActionPerformed

    private void txtSecondStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecondStringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecondStringActionPerformed

    private void btnDetermineResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetermineResultsActionPerformed
        // TODO add your handling code here:
        
        // Variables
        int operation;
        
        String firstString;
        String secondString;
        String answer;
        
        // Get operation from user
        operation = cmbOperation.getSelectedIndex();
        
        // Get input strings from user
        firstString = txtFirstString.getText();
        secondString = txtSecondString.getText();
        
        // Get results based on selected operation
        switch (operation) {
            case 0:
               answer = String.valueOf(firstString.length());
               break;
            case 1:
                answer = firstString.toUpperCase();
                break;
            case 2:
                answer = String.valueOf(firstString.charAt(3));
                break;
            case 3:
                answer = String.valueOf(firstString.equals(secondString));
                break;
            case 4:
                answer = String.valueOf(firstString.contains(secondString));
                break;
            case 5:
                answer = String.valueOf(firstString.substring(3, 6));
                break;
            case 6:
                answer = firstString.replace("i", "u");
                break;
            default:
                answer = "";
                System.out.println("Error, invalid response!");
        }
        
        // Ouput the results
        lblResults.setText(String.valueOf(answer));
    }//GEN-LAST:event_btnDetermineResultsActionPerformed

    private void cmbOperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOperationActionPerformed
        // TODO add your handling code here:
        
        // Constants
        final String [] FIRST_STRING_LABELS = {
          "Enter a String", "Enter a Lowercase String", "Enter at Least Four Characters", "Enter the First String",
          "Enter a String", "Enter at Least Eight Characters", "Enter a String containing i"
        };
        
        final String [] SECOND_STRING_LABELS = {
            "", "", "", "Enter the Second String", "Enter a Character", "", ""
        };
        
        final String [] RESULT_LABELS = {
            "String Length: ", "Uppercase String: ", "Fourth Character: ", "Strings are Identical: ",
            "Charcter is found at index: ", "Characters 4-6: ", "Updated String"
        };
        
        final Boolean [] SECOND_STRING_ENABLED = {
            false, false, false, true, true, false, false
        };
        
        // Variables
        int operation;
        
        // Get operation from user
        operation = cmbOperation.getSelectedIndex();
        
        // Change textbox labels
        lblFirstString.setText(FIRST_STRING_LABELS[operation]);
        lblSecondString.setText(SECOND_STRING_LABELS[operation]);
        lblResultsHeader.setText(RESULT_LABELS[operation]);
        
        // Enable or disable the second input box depending on selected operation
        txtSecondString.setEnabled(SECOND_STRING_ENABLED[operation]);
        
        
        
    }//GEN-LAST:event_cmbOperationActionPerformed

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
            java.util.logging.Logger.getLogger(frmSuperStringsJW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSuperStringsJW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSuperStringsJW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSuperStringsJW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSuperStringsJW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetermineResults;
    private javax.swing.JComboBox<String> cmbOperation;
    private javax.swing.JLabel lblFirstString;
    private javax.swing.JLabel lblOperation;
    private javax.swing.JLabel lblResults;
    private javax.swing.JLabel lblResultsHeader;
    private javax.swing.JLabel lblSecondString;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtFirstString;
    private javax.swing.JTextField txtSecondString;
    // End of variables declaration//GEN-END:variables
}
