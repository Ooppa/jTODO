/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.awt.Window;

/**
 * Creates a error message pop-up for the user to see.
 *
 * @author Ooppa
 */
public class ErrorWindow extends javax.swing.JFrame {

    /**
     * Creates a new ErrorWindow dialog for the user to see
     *
     * @param text   Error text to display
     * @param window Window which TaskEditorWindow should be attached to
     */
    public ErrorWindow(String text, Window window) {
        this.initComponents();
        this.setLocationRelativeTo(window);
        this.errorMessageLabel.setText(text);
        this.setVisible(true);
        this.setAlwaysOnTop(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errorMessageLabel = new javax.swing.JLabel();
        buttonConfirm = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("jtodo/ui/Bundle"); // NOI18N
        setTitle(bundle.getString("ErrorWindow.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        errorMessageLabel.setIcon(new javax.swing.ImageIcon("T:\\Gits\\jTODO\\jTODO\\src\\main\\resources\\images\\labels\\warning.png")); // NOI18N
        errorMessageLabel.setText(bundle.getString("ErrorWindow.errorMessageLabel.text")); // NOI18N
        errorMessageLabel.setName("errorMessageLabel"); // NOI18N

        buttonConfirm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonConfirm.setText(bundle.getString("ErrorWindow.buttonConfirm.text")); // NOI18N
        buttonConfirm.setName("buttonConfirm"); // NOI18N
        buttonConfirm.addActionListener(formListener);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(buttonConfirm))
                    .add(errorMessageLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(errorMessageLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(buttonConfirm, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == buttonConfirm) {
                ErrorWindow.this.buttonConfirmActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Closes (dispose) the ErrorWindow.
     */
    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonConfirmActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JLabel errorMessageLabel;
    // End of variables declaration//GEN-END:variables
}
