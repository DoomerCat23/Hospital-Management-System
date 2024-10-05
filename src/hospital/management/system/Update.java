package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update extends JFrame {

    Update(){

        JPanel panel=new JPanel();
        panel.setBounds(0,0,1920,820);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);

        JLabel labelName=new JLabel("<html><u>UPDATE PATIENT DETAILS</u></html>");
        labelName.setBounds(35,11,450,53);
        labelName.setFont(new Font("Oswald",Font.BOLD,30));
        panel.add(labelName);

        JLabel label1 =new JLabel("Patient ID:");
        label1.setBounds(35,130,200,20);
        label1.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(label1);

        Choice choice=new Choice();
        choice.setBounds(240,130,150,250);
        panel.add(choice);

        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from patient");
            while(resultSet.next()){
                choice.add(resultSet.getString("PatientID"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JLabel label2 =new JLabel("Room Number:");
        label2.setBounds(35,180,200,20);
        label2.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(label2);

        JTextField textFieldR=new JTextField();
        textFieldR.setBounds(240,180,200,20);
        panel.add(textFieldR);

        JLabel label4 =new JLabel("Check-In Time:");
        label4.setBounds(35,230,200,20);
        label4.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(label4);

        JTextField textFieldINTIME =new JTextField();
        textFieldINTIME.setBounds(240,230,200,20);
        panel.add(textFieldINTIME);

        JLabel label5 =new JLabel("Amount Paid:");
        label5.setBounds(35,280,200,20);
        label5.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(label5);

        JTextField textFieldAMOUNT =new JTextField();
        textFieldAMOUNT.setBounds(240,280,200,20);
        panel.add(textFieldAMOUNT);

        JLabel label6 =new JLabel("Pending:");
        label6.setBounds(35,330,200,20);
        label6.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(label6);

        JTextField textFieldPENDING =new JTextField();
        textFieldPENDING.setBounds(240,330,200,20);
        panel.add(textFieldPENDING);

        JButton b1=new JButton();
        b1=new JButton("CHECK");
        b1.setFont(new Font("Oswald", Font.BOLD,15));
        b1.setBounds(35,700,150,30);
        b1.setBackground(new Color(4, 176, 232));
        b1.setForeground(new Color(255,255,255));
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String q="select * from patient where PatientID='"+id+"'";
                try{
                    Conn c=new Conn();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    while(resultSet.next()){
                        textFieldR.setText(resultSet.getString("Room"));
                        textFieldINTIME.setText(resultSet.getString("Date"));
                        textFieldAMOUNT.setText(resultSet.getString("Deposit"));
                    }
                    ResultSet resultSet1=c.statement.executeQuery("select * from room where room_no='"+textFieldR.getText()+"'");
                    while(resultSet1.next()){
                        String price=resultSet1.getString("Price");
                        int amoundPaid=Integer.parseInt(price)-Integer.parseInt(textFieldAMOUNT.getText());
                        textFieldPENDING.setText(""+amoundPaid);
                    }
                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton b2 =new JButton();
        b2 =new JButton("UPDATE");
        b2.setFont(new Font("Oswald", Font.BOLD,15));
        b2.setBounds(235,700,150,30);
        b2.setBackground(new Color(0, 128, 40));
        b2.setForeground(new Color(255,255,255));
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Conn c=new Conn();
                    String q=choice.getSelectedItem();
                    String room=textFieldR.getText();
                    String time=textFieldINTIME.getText();
                    String amount=textFieldAMOUNT.getText();
                    c.statement.executeUpdate("update patient set Room='"+room+"', Date='"+time+"', Deposit='"+amount+"' where PatientID='"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton b3 =new JButton();
        b3 =new JButton("BACK");
        b3.setFont(new Font("Oswald", Font.BOLD,15));
        b3.setBounds(435,700,150,30);
        b3.setBackground(new Color(228, 36, 52));
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
    public static void main(String[] args){
        new Update();
    }
}
