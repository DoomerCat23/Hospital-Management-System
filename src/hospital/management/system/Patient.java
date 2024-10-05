package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Patient extends JFrame {
    JTable table;

    Patient() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1920, 820);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);

        table = new JTable();
        table.setBounds(10, 40, 600, 800);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Oswald", Font.PLAIN, 18)); // Change to your desired font and size
        table.setRowHeight(30);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Oswald", Font.BOLD, 20)); // Customize the font and size here
        tableHeader.setBackground(new Color(203, 246, 237));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 10, 1900, 640); // Set the size of the scroll pane

        scrollPane.setBorder(new RoundedBorder(30)); // Adjust the radius as needed
        scrollPane.setOpaque(false); // Make sure the scroll pane's background is transparent
        scrollPane.getViewport().setOpaque(false); // Make the viewport background transparent

        // Add a margin around the table inside the scroll pane
        scrollPane.setViewportBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));

        panel.add(scrollPane);

        try {
            Conn c = new Conn();
            String q = "SELECT * FROM patient";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(0).setHeaderValue("ID");
            columnModel.getColumn(1).setHeaderValue("Name");
            columnModel.getColumn(2).setHeaderValue("DOB");
            columnModel.getColumn(3).setHeaderValue("Gender");
            columnModel.getColumn(4).setHeaderValue("Marital Status");
            columnModel.getColumn(5).setHeaderValue("Address");
            columnModel.getColumn(6).setHeaderValue("Phone Number");
            columnModel.getColumn(7).setHeaderValue("E-Mail");
            columnModel.getColumn(8).setHeaderValue("ID Type");
            columnModel.getColumn(9).setHeaderValue("ID Number");
            columnModel.getColumn(10).setHeaderValue("Diagnosis");
            columnModel.getColumn(11).setHeaderValue("Medical History");
            columnModel.getColumn(12).setHeaderValue("Allergies");
            columnModel.getColumn(13).setHeaderValue("Current Medication");
            columnModel.getColumn(14).setHeaderValue("Alt Contact");
            columnModel.getColumn(15).setHeaderValue("Room");
            columnModel.getColumn(16).setHeaderValue("Insurance");
            columnModel.getColumn(17).setHeaderValue("Policy No");
            columnModel.getColumn(18).setHeaderValue("Deposit");
            columnModel.getColumn(19).setHeaderValue("Occupation");
            columnModel.getColumn(20).setHeaderValue("Date");

            // Set column widths
            columnModel.getColumn(0).setPreferredWidth(50); // ID
            columnModel.getColumn(1).setPreferredWidth(250); // Name
            columnModel.getColumn(2).setPreferredWidth(120); // DOB
            columnModel.getColumn(3).setPreferredWidth(100); // Gender
            columnModel.getColumn(4).setPreferredWidth(150); // Marital Status
            columnModel.getColumn(5).setPreferredWidth(250); // Address
            columnModel.getColumn(6).setPreferredWidth(120); // Phone Number
            columnModel.getColumn(7).setPreferredWidth(200); // E-Mail
            columnModel.getColumn(8).setPreferredWidth(150); // ID Type
            columnModel.getColumn(9).setPreferredWidth(120); // ID Number
            columnModel.getColumn(10).setPreferredWidth(150); // Diagnosis
            columnModel.getColumn(11).setPreferredWidth(150); // Allergies
            columnModel.getColumn(12).setPreferredWidth(200); // Current Medication
            columnModel.getColumn(13).setPreferredWidth(150); // Alt Contact
            columnModel.getColumn(14).setPreferredWidth(150); // Room
            columnModel.getColumn(15).setPreferredWidth(150); // Insurance
            columnModel.getColumn(16).setPreferredWidth(150); // Policy No
            columnModel.getColumn(17).setPreferredWidth(120); // Deposit
            columnModel.getColumn(18).setPreferredWidth(150); // Occupation
            columnModel.getColumn(19).setPreferredWidth(150); // Date

            // Adjust the total width if necessary to ensure horizontal scrolling
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton btn10 = new JButton("BACK");
        btn10.setFont(new Font("Oswald", Font.BOLD, 13));
        btn10.setBounds(25, 710, 80, 30);
        btn10.setBackground(new Color(188, 68, 68));
        btn10.setForeground(new Color(255, 255, 255));
        panel.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1920, 820);
        setLayout(null);
        setLocation(0, 215);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Patient();
    }
}
