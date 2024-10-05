package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search extends JFrame {
    JTable table;
    Search(){

        JPanel panel=new JPanel();
        panel.setBounds(0,0,1920,820);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);

        JLabel For =new JLabel("<html><u>SEARCH FOR ROOM</u></html>");
        For.setBounds(35,11,450,53);
        For.setFont(new Font("Oswald",Font.BOLD,30));
        panel.add(For);

        JLabel label1 =new JLabel("Room Number:");
        label1.setBounds(35,130,150,20);
        label1.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(label1);

        Choice choice=new Choice();
        choice.setBounds(190,130,100,100);
        panel.add(choice);

        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from room");
            while(resultSet.next()){
                choice.add(resultSet.getString("room_no"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        table=new JTable();
        table.setBounds(10,40,600,200);
        table.setBackground(new Color(255,255,255));
        table.setFont(new Font("Oswald", Font.PLAIN, 18)); // Change to your desired font and size
        table.setRowHeight(30);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Oswald", Font.BOLD, 20)); // Customize the font and size here
        tableHeader.setBackground(new Color(149, 239, 251));

        panel.add(table);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(35, 200, 550, 165); // Set the size of the scroll pane

        scrollPane.setBorder(new RoundedBorder(30)); // Adjust the radius as needed
        scrollPane.setOpaque(false); // Make sure the scroll pane's background is transparent
        scrollPane.getViewport().setOpaque(false); // Make the viewport background transparent

        // Add a margin around the table inside the scroll pane
        scrollPane.setViewportBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));

        panel.add(scrollPane);

        try{
            Conn c=new Conn();
            String q="select * from Room where room_no='"+choice.getSelectedItem()+"'";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(0).setHeaderValue("Room No");
            columnModel.getColumn(1).setHeaderValue("Availability");
            columnModel.getColumn(2).setHeaderValue("Price(₹)");
            columnModel.getColumn(3).setHeaderValue("Bed Type");

            table.getColumnModel().getColumn(1).setCellRenderer(new CustomCellRenderer());

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(470, 130, 120,30);
        searchButton.setFont(new Font("Oswald", Font.BOLD, 15));
        searchButton.setBackground(new Color(0, 128, 40));
        searchButton.setForeground(Color.WHITE);
        panel.add(searchButton);

        // ActionListener for search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRoomNo = choice.getSelectedItem();
                if (selectedRoomNo != null && !selectedRoomNo.isEmpty()) {
                    try {
                        Conn c = new Conn();
                        String q = "select * from room where room_no='" + selectedRoomNo + "'";
                        ResultSet resultSet = c.statement.executeQuery(q);
                        table.setModel(DbUtils.resultSetToTableModel(resultSet));

                        // Customize column headers
                        TableColumnModel columnModel = table.getColumnModel();
                        columnModel.getColumn(0).setHeaderValue("Room No");
                        columnModel.getColumn(1).setHeaderValue("Availability");
                        columnModel.getColumn(2).setHeaderValue("Price(₹)");
                        columnModel.getColumn(3).setHeaderValue("Bed Type");

                        // Set custom cell renderer for Availability column (column index 1)
                        table.getColumnModel().getColumn(1).setCellRenderer(new CustomCellRenderer());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JButton b3 =new JButton();
        b3 =new JButton("BACK");
        b3.setFont(new Font("Oswald", Font.BOLD,15));
        b3.setBounds(35,700,120,30);
        b3.setBackground(new Color(170, 28, 40, 136));
        b3.setForeground(new Color(255,255,255));
        panel.add(b3);
        b3.addActionListener(new ActionListener() {
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
        setVisible(true);
    }
    public static void main(String [] args){
        new Search();
    }
}
