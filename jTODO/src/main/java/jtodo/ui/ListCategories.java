/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * List categories saved in the system, allows the user to add and edit.
 *
 * @author Ooppa
 * @see Category
 */
public class ListCategories extends javax.swing.JFrame {
    
    private static final Logger logger = Logger.getLogger(ListCategories.class.getName());

    /**
     * Creates a new ListCategories with it's location relative to window
     *
     * @param window Window which ListCategories should be attached to
     */
    public ListCategories(Window window) {
        this.initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(window);
        
        logger.log(Level.INFO, "Created a new ListCategories window.");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoryListScrollPane = new javax.swing.JScrollPane();
        categoryList = new javax.swing.JList();
        buttonAdd = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        categoryListScrollPane.setName("categoryListScrollPane"); // NOI18N

        categoryList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Example Category 1", "Example Category 2", "This pane doesn't work yet", "Example Category 3", "Example Category 4", "Example Category 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        categoryList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        categoryList.setName("categoryList"); // NOI18N
        categoryList.addMouseListener(formListener);
        categoryListScrollPane.setViewportView(categoryList);

        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/categoryadd.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("jtodo/ui/Bundle"); // NOI18N
        buttonAdd.setText(bundle.getString("ListCategories.buttonAdd.text")); // NOI18N
        buttonAdd.setName("buttonAdd"); // NOI18N
        buttonAdd.addActionListener(formListener);

        buttonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/categoryedit.png"))); // NOI18N
        buttonEdit.setText(bundle.getString("ListCategories.buttonEdit.text")); // NOI18N
        buttonEdit.setName("buttonEdit"); // NOI18N
        buttonEdit.addActionListener(formListener);

        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cross.png"))); // NOI18N
        buttonDelete.setText(bundle.getString("ListCategories.buttonDelete.text")); // NOI18N
        buttonDelete.setName("buttonDelete"); // NOI18N
        buttonDelete.addActionListener(formListener);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(categoryListScrollPane)
                    .add(layout.createSequentialGroup()
                        .add(buttonAdd)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buttonEdit)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buttonDelete)
                        .add(0, 101, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(categoryListScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 255, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(buttonAdd)
                    .add(buttonEdit)
                    .add(buttonDelete))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == buttonAdd) {
                ListCategories.this.buttonAddActionPerformed(evt);
            }
            else if (evt.getSource() == buttonEdit) {
                ListCategories.this.buttonEditActionPerformed(evt);
            }
            else if (evt.getSource() == buttonDelete) {
                ListCategories.this.buttonDeleteActionPerformed(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == categoryList) {
                ListCategories.this.categoryListMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    /**
     * If list item is double-clicked (or spam-clicked)
     */
    private void categoryListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryListMouseClicked
        // TODO
        System.out.println("MouseClickEvent");
        if(evt.getClickCount() >= 2){
            int index = categoryList.locationToIndex(evt.getPoint());
            System.out.println("index = "+index);
        }
        
    }//GEN-LAST:event_categoryListMouseClicked

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // TODO
        Object selectedValue = categoryList.getSelectedValue();
        logEvent(evt, "Selected value was: "+ selectedValue.toString());
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        CategoryEditorWindow categoryEditorWindow = new CategoryEditorWindow(this);
        logEvent(evt);
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        // TODO add your handling code here:
        logEvent(evt);
    }//GEN-LAST:event_buttonEditActionPerformed

    private void logEvent(ActionEvent evt) {
        logger.log(Level.INFO, "User performed action: "+evt.toString());
    }
    
    private void logEvent(ActionEvent evt, String customString) {
        logger.log(Level.INFO, "User performed action: "+evt.toString() + "("+ customString + ")");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JList categoryList;
    private javax.swing.JScrollPane categoryListScrollPane;
    // End of variables declaration//GEN-END:variables
}
