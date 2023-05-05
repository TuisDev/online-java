/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author jijwa
 */
public class frmMagicMathJW extends javax.swing.JFrame {

    /**
     * Creates new form frmMagicMathJW
     */
    public frmMagicMathJW() {
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

        cmbOperation = new javax.swing.JComboBox<>();
        lblArg1 = new javax.swing.JLabel();
        lblArg2 = new javax.swing.JLabel();
        txtArg1 = new javax.swing.JTextField();
        txtArg2 = new javax.swing.JTextField();
        lblResultHeader = new javax.swing.JLabel();
        lblResult = new javax.swing.JLabel();
        btnCalculate = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblOperation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Magic Math Machine");

        cmbOperation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbOperation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Largest", "Smallest", "Power Of", "Absolute", "Round Up", "Round Down", "Hypotenuse", "Square Root", "Convert To Radians", "Convert To Degrees" }));
        cmbOperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOperationActionPerformed(evt);
            }
        });

        lblArg1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblArg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArg1.setText("First number: ");

        lblArg2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblArg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArg2.setText("Second number: ");

        txtArg1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtArg2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtArg2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArg2ActionPerformed(evt);
            }
        });

        lblResultHeader.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblResultHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultHeader.setText("The largest number is:");

        lblResult.setBackground(new java.awt.Color(255, 255, 255));
        lblResult.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblResult.setOpaque(true);

        btnCalculate.setText("Calculate");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Magic Math Machine");

        lblOperation.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblOperation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOperation.setText("Select the Operation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblResultHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCalculate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblArg2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtArg2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblArg1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtArg1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblOperation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbOperation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addComponent(lblArg1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArg1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblArg2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArg2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblResultHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCalculate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbOperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOperationActionPerformed
        // TODO add your handling code here:
        
        // Constants
        final String [] ARG1_LABELS = {
            "First number: ", "First number: ", "Base: ", "Number: ", "Decimal to be rounded: ",
            "Decimal to be rounded: ", "Length of side a: ", "Number: ", "Degree value: ", "Radian value: "
        };
        final String [] ARG2_LABELS = {
            "Second number: ", "Second number: ", "Exponent: ", "", "",
            "", "Length of side b: ", "", "", ""
        };
        final String [] RESULTS_LABELS = {
            "The larger number is: ", "The smallest number is: ", "The result is: ", "The absolute value is: ",
            "The rounded number is: ", "The rounded number is: ", "The length of the hypotenuse is: ", "The square root is: ",
            "The radian value  is: ", "The degree value is: "
        };
        final Boolean [] ARG2_ENABLED = {true, true, true, false, false, false, true, false, false, false};
        
        // Variables
        int operation;
        
        // Get the operation from the user
        operation = cmbOperation.getSelectedIndex();
        
        // Change the labels for the text boxes
        lblArg1.setText(ARG1_LABELS[operation]);
        lblArg2.setText(ARG2_LABELS[operation]);
        lblResultHeader.setText(RESULTS_LABELS[operation]);
        
        // Enable or disable the second box
        txtArg2.setEnabled(ARG2_ENABLED[operation]);
    }//GEN-LAST:event_cmbOperationActionPerformed

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        // TODO add your handling code here:
        
        // Variables
        int operation;
        
        double num1;
        double num2;
        double answer;
        
        // Get the operation from the user
        operation = cmbOperation.getSelectedIndex();
        
        // Get the numbers from the user
        num1 = Double.parseDouble(txtArg1.getText());
        
        if (txtArg2.isEnabled()) {
            num2 = Double.parseDouble(txtArg2.getText());
        } else {
            num2 = 0;
        }
        // Get the result depending on the operation chosen
        switch (operation) {
            case 0:
               answer = Math.max(num1, num2);
               break;
            case 1:
                answer = Math.min(num1, num2);
                break;
            case 2:
                answer = Math.pow(num1, num2);
                break;
            case 3:
                answer = Math.abs(num1);
                break;
            case 4:
                answer = Math.ceil(num1);
                break;
            case 5:
                answer = Math.floor(num1);
                break;
            case 6:
                answer = Math.hypot(num1, num2);
                break;
            case 7:
                answer = Math.sqrt(num1);
                break;
            case 8:
                answer = Math.toRadians(num1);
                break;
            case 9:
                answer = Math.toDegrees(num1);
                break; 
            default:
                answer = 0;
                System.out.println("Error, invalid response!");
        }
        
        // Output the result
        lblResult.setText(String.valueOf(answer));
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void txtArg2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArg2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArg2ActionPerformed

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
            java.util.logging.Logger.getLogger(frmMagicMathJW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMagicMathJW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMagicMathJW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMagicMathJW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMagicMathJW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JComboBox<String> cmbOperation;
    private javax.swing.JLabel lblArg1;
    private javax.swing.JLabel lblArg2;
    private javax.swing.JLabel lblOperation;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblResultHeader;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtArg1;
    private javax.swing.JTextField txtArg2;
    // End of variables declaration//GEN-END:variables
}
