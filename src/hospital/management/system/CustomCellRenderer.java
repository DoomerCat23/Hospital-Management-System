package hospital.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Check the cell value and set the background color if it contains "Occupied"
        if (value != null && value.toString().equalsIgnoreCase("Occupied")) {
            cellComponent.setBackground(new Color(250, 95, 95));
            cellComponent.setForeground(Color.WHITE); // Optional: set text color for better readability
        }
        else {
            cellComponent.setBackground(Color.WHITE); // Default background color
            cellComponent.setForeground(Color.BLACK); // Default text color
        }

        return cellComponent;
    }
}

