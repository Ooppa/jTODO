/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import jtodo.domain.ListItemColor;
import jtodo.domain.Task;

/**
 *
 * @author Ooppa
 */
public class TaskTableDeadlineBasedCellRenderer extends DefaultTableCellRenderer {

    private TaskTableModel taskTableModel;

    /**
     * Creates a new TaskTableCategoryBasedCellRenderer with access to
     * TaskTableModel
     *
     * @param taskTableModel TaskTableModel to add
     *
     * @see TaskTableModel
     */
    public TaskTableDeadlineBasedCellRenderer(TaskTableModel taskTableModel) {
        super(); // DefaultTableCellRenderer constructor
        this.taskTableModel = taskTableModel;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        Task taskOnRow = taskTableModel.getRelativeTask(row);

        // If no category set to white, else set to one specified in category
        if(taskOnRow.getCategory()==null) {
            component.setBackground(ListItemColor.WHITE.getColor());
        } else {
            component.setBackground(taskOnRow.getCategory().getListItemColor().getColor());
        }

        if(taskOnRow.isDeadlineActive()) {
            // Overrides the default behaviour:
            // If the deadline is before the current time then show the field in bright red
            if(taskOnRow.getDeadline().getDateTime().isBeforeNow()) {
                component.setBackground(Color.RED);
            }
        }

        return component;
    }

    /**
     * @return the taskTableModel
     */
    public TaskTableModel getTaskTableModel() {
        return taskTableModel;
    }

    /**
     * @param taskTableModel the taskTableModel to set
     */
    public void setTaskTableModel(TaskTableModel taskTableModel) {
        this.taskTableModel = taskTableModel;
    }

}
