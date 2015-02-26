/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * Creates a error message pop-up for the user to see.
 *
 * @author Ooppa
 */
public class ErrorWindow extends JFrame {

    private static final Logger logger = Logger.getLogger(ErrorWindow.class.getName());

    /**
     * Creates a new ErrorWindow dialog for the user to see
     *
     * @param text Error text to display
     */
    public ErrorWindow(String text) {
        logger.log(Level.FINE, "Displaying Error window for ''{0}''.", text);

        initComponents();
        setLocationRelativeTo(null);

        errorMessageLabel.setText(text);

        setVisible(true);
        setAlwaysOnTop(true);
    }

    private void initComponents() {

        errorMessageLabel = new javax.swing.JLabel();
        buttonConfirm = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("jtodo/ui/Bundle");
        setTitle(bundle.getString("ErrorWindow.title"));
        setName("Form");
        setResizable(false);

        errorMessageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/warning.png")));
        errorMessageLabel.setText(bundle.getString("ErrorWindow.errorMessageLabel.text"));
        errorMessageLabel.setName("errorMessageLabel");

        buttonConfirm.setFont(new java.awt.Font("Tahoma", 0, 12));
        buttonConfirm.setText(bundle.getString("ErrorWindow.buttonConfirm.text"));
        buttonConfirm.setName("buttonConfirm");
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

        FormListener() {
        }

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(evt.getSource()==buttonConfirm) {
                ErrorWindow.this.buttonConfirmActionPerformed(evt);
            }
        }
    }

    /*
     * Closes (dispose) the ErrorWindow.
     */
    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private javax.swing.JButton buttonConfirm;
    private javax.swing.JLabel errorMessageLabel;
}
