package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Discharge extends JFrame{
    Discharge(){

        JPanel panel=new JPanel();
        panel.setBounds(0,0,1920,820);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);

        JLabel labelName=new JLabel("<html><u>CHECK-OUT</u></html>");
        labelName.setBounds(35,11,340,53);
        labelName.setFont(new Font("Oswald",Font.BOLD,30));
        panel.add(labelName);

        JLabel label1 =new JLabel("Patient ID:");
        label1.setBounds(35,130,200,20);
        label1.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(label1);

        Choice choice=new Choice();
        choice.setBounds(240,130,150,250);
        panel.add(choice);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient");
            while (resultSet.next()) {
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

        JLabel RNo=new JLabel();
        RNo.setBounds(240,180,200,20);
        RNo.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(RNo);

        JLabel label4 =new JLabel("Check-In Time:");
        label4.setBounds(35,230,200,20);
        label4.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(label4);

        JLabel INTime=new JLabel();
        INTime.setBounds(240,230,280,20);
        INTime.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(INTime);

        JLabel label5 =new JLabel("Check-Out Time:");
        label5.setBounds(35,280,200,20);
        label5.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(label5);

        Date date=new Date();
        JLabel OUTTime =new JLabel(""+date);
        OUTTime.setBounds(240,280,280,20);
        OUTTime.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(OUTTime);

        JButton b1=new JButton();
        b1=new JButton("DISCHARGE");
        b1.setFont(new Font("Oswald", Font.BOLD,15));
        b1.setBounds(35,700,150,30);
        b1.setBackground(new Color(0, 128, 40));
        b1.setForeground(new Color(255,255,255));
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c=new Conn();
                try{
                    c.statement.executeUpdate("delete from patient where PatientID='"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability='Available' where room_no='"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton b2 =new JButton();
        b2 =new JButton("CHECK");
        b2.setFont(new Font("Oswald", Font.BOLD,15));
        b2.setBounds(235,700,150,30);
        b2.setBackground(new Color(4, 176, 232));
        b2.setForeground(new Color(255,255,255));
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c=new Conn();
                try{
                    ResultSet resultSet=c.statement.executeQuery("select * from patient where PatientID='"+choice.getSelectedItem()+"'");
                    while (resultSet.next()){
                        RNo.setText(resultSet.getString("Room"));
                        INTime.setText(resultSet.getString("Date"));
                    }
                } catch (Exception E) {
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
    }
    public static void main(String[] args){
        new Discharge();
    }
}
