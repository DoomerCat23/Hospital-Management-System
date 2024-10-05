package hospital.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class RoundedBorder implements Border {

    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius + 10, radius + 10, radius + 10, radius + 10); // Adjust insets to fit inside the rounded corners
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.GRAY); // Customize the border color if needed
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
