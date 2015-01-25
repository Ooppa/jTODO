/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Ooppa
 */
public class MainWindow extends JFrame {

    private JPanel leftPanel, rightPanel;
    private JSplitPane splitPanel;

    private JTree treeModelView;
    private JScrollPane treeModelViewScrollPanel;

    private JMenuBar menuBar;
    private JMenu menuTabFile, menuItemSettings;
    private JMenuItem menuItemFileNew, menuItemFileSave, menuItemFileOpen, menuItemFileExit;
    private JCheckBoxMenuItem menuItemSettingsAutoSave, menuItemSettingsAlwaysOnTop;

    /**
     * Creates new MainWindow form
     */
    public MainWindow() {
        initComponents();
        windowSettings();
    }

    /*
     * Initialize the layout components
     */
    private void initComponents() {

        // Splitpanel
        createSplitPanel();
        add(splitPanel);

        // TreeView
        createTreeView();

        createMenuBar();
        setJMenuBar(menuBar);

        // for debugging
        leftPanel.setBackground(new java.awt.Color(224, 246, 223));
        rightPanel.setBackground(new java.awt.Color(246, 223, 231));

        pack();
    }

    private void windowSettings() {
        Dimension minimum = new Dimension(500, 300);
        Dimension preferred = new Dimension(1000, 600);

        setSize(preferred);
        setPreferredSize(preferred);
        setMaximumSize(minimum);

        setTitle("jTODO");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createSplitPanel() {
        splitPanel = new javax.swing.JSplitPane();
        rightPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();

        splitPanel.setLeftComponent(leftPanel);
        splitPanel.setRightComponent(rightPanel);

        splitPanel.setDividerSize(4);
        splitPanel.setDividerLocation(250);
    }

    private void createTreeView() {
        treeModelViewScrollPanel = new JScrollPane();
        treeModelView = new JTree();

        treeModelViewScrollPanel.setViewportView(treeModelView);
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();

        menuTabFile = new JMenu();
        menuTabFile.setText("File");

        menuItemFileNew = new JMenuItem();
        menuItemFileNew.setText("New");
        
        System.out.println(System.getProperty("user.dir"));
        
        //menuItemFileNew.setIcon(new ImageIcon(getClass().getResource("/images/menubar/newsave.png")));
        
        menuTabFile.add(menuItemFileNew);
        

        menuItemFileSave = new JMenuItem();
        menuItemFileSave.setText("Save");
        menuTabFile.add(menuItemFileSave);

        // CTRL+S will count as action event for this menuitem
        menuItemFileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        menuItemFileOpen = new JMenuItem();
        menuItemFileOpen.setText("Open");
        menuTabFile.add(menuItemFileOpen);

        menuItemFileExit = new JMenuItem();
        menuItemFileExit.setText("Exit");
        menuTabFile.add(menuItemFileExit);

        menuItemSettings = new JMenu();
        menuItemSettings.setText("Settings");

        menuItemSettingsAutoSave = new JCheckBoxMenuItem();
        menuItemSettingsAutoSave.setText("Autosave");
        menuItemSettings.add(menuItemSettingsAutoSave);

        menuItemSettingsAlwaysOnTop = new JCheckBoxMenuItem();
        menuItemSettingsAlwaysOnTop.setText("Always on top");
        menuItemSettings.add(menuItemSettingsAlwaysOnTop);

        menuBar.add(menuTabFile);
        menuBar.add(menuItemSettings);

    }

}
