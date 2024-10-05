package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    JTable table;

    Department(){
        JPanel panel=new JPanel();
        panel.setBounds(0,0,1920,820);
        panel.setBackground(new Color(255,255,255));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/dept.png"));
        Image image=imageIcon.getImage().getScaledInstance(800,783,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(1000,0,1500,783);
        panel.add(label);

        table=new JTable();
        table.setBounds(10,40,600,800);
        table.setBackground(new Color(255,255,255));
        table.setFont(new Font("Oswald", Font.PLAIN, 18)); // Change to your desired font and size
        table.setRowHeight(30);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Oswald", Font.BOLD, 20)); // Customize the font and size here
        tableHeader.setBackground(new Color(203, 246, 237));

        panel.add(table);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 10, 1300, 640); // Set the size of the scroll pane

        scrollPane.setBorder(new RoundedBorder(30)); // Adjust the radius as needed
        scrollPane.setOpaque(false); // Make sure the scroll pane's background is transparent
        scrollPane.getViewport().setOpaque(false); // Make the viewport background transparent

        // Add a margin around the table inside the scroll pane
        scrollPane.setViewportBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));

        panel.add(scrollPane);

        try{
            Conn c=new Conn();
            String q="select * from department";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(0).setHeaderValue("Department ID");
            columnModel.getColumn(1).setHeaderValue("Department Name");
            columnModel.getColumn(2).setHeaderValue("Department Head");
            columnModel.getColumn(3).setHeaderValue("Location");
            columnModel.getColumn(4).setHeaderValue("Contact Number");

            columnModel.getColumn(0).setPreferredWidth(150); // Department ID
            columnModel.getColumn(1).setPreferredWidth(300); // Department Name
            columnModel.getColumn(2).setPreferredWidth(250); // Department Head
            columnModel.getColumn(3).setPreferredWidth(300); // Location
            columnModel.getColumn(4).setPreferredWidth(150); // Contact Number

            table.getColumnModel().getColumn(1).setCellRenderer(new CustomCellRenderer());

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JButton btn10 =new JButton("BACK");
        btn10.setFont(new Font("Oswald",Font.BOLD,13));
        btn10.setBounds(25,710,80,30);
        btn10.setBackground(new Color(188, 68, 68));
        btn10.setForeground(new Color(255,255,255));
        panel.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1920,820);
        setLayout(null);
        setLocation(0,215);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
