package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Reception extends JFrame {
    private String userName;
    Reception(String userName) throws SQLException {
        this.userName = userName;



        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1894,836);
        panel.setBackground(new Color(255,255,255));
        add(panel);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0,0,1950,150);
        panel1.setBackground(new Color(251, 231, 241));
        add(panel1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/doctor.png"));
        Image image=i1.getImage().getScaledInstance(500,350,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(image);
        JLabel label=new JLabel(i2);
        label.setBounds(30,0,500,250);
        panel1.add(label);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/back.png"));
        Image lol=imageIcon.getImage().getScaledInstance(1500,900,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(lol);
        JLabel label1 =new JLabel(imageIcon1);
        label1.setBounds(325,-30,1500,900);
        panel.add(label1);

        JButton btn1=new JButton("Add New Patient");
        btn1.setBounds(550,15,200,30);
        btn1.setBackground(new Color(255,255,255));
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();
            }
        });

        JButton btn2=new JButton("Room");
        btn2.setBounds(550,60,200,30);
        btn2.setBackground(new Color(255,255,255));
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton btn3=new JButton("Department");
        btn3.setBounds(550,105,200,30);
        btn3.setBackground(new Color(255,255,255));
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton btn4=new JButton("Employee Info");
        btn4.setBounds(800,15,200,30);
        btn4.setBackground(new Color(255,255,255));
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee();
            }
        });

        JButton btn5=new JButton("Patient Info");
        btn5.setBounds(800,60,200,30);
        btn5.setBackground(new Color(255,255,255));
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient();
            }
        });

        JButton btn6=new JButton("Patient Discharge");
        btn6.setBounds(800,105,200,30);
        btn6.setBackground(new Color(255,255,255));
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Discharge();
            }
        });

        JButton btn7 =new JButton("Search Room");
        btn7.setBounds(1050,15,200,30);
        btn7.setBackground(new Color(255,255,255));
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Search();
            }
        });

        JButton btn8 =new JButton("Update Patient Details");
        btn8.setBounds(1050,60,200,30);
        btn8.setBackground(new Color(255,255,255));
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Update();
            }
        });

        JButton btn9 =new JButton("Ambulance Service");
        btn9.setBounds(1050,105,200,30);
        btn9.setBackground(new Color(255,255,255));
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });

        JButton btn10 =new JButton("Log Out");
        btn10.setBounds(1792,15,100,30);
        btn10.setBackground(new Color(145, 57, 57));
        btn10.setForeground(new Color(255,255,255));
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        JLabel namelabel=new JLabel("Welcome, "+userName);
        namelabel.setBounds(1600,15,500,30);
        namelabel.setFont(new Font("Oswald",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        panel1.add(namelabel);

        JLabel namelabel2=new JLabel("Contact: 033-256-3841");
        namelabel2.setBounds(1600,60,500,30);
        namelabel2.setFont(new Font("Oswald",Font.PLAIN,16));
        namelabel2.setForeground(Color.BLACK);
        panel1.add(namelabel2);

        JLabel namelabel3 =new JLabel("info@carewave.com");
        namelabel3.setBounds(1600,85,500,30);
        namelabel3.setFont(new Font("Oswald",Font.PLAIN,16));
        namelabel3.setForeground(Color.BLACK);
        panel1.add(namelabel3);


        setSize(1920,1080);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }


    public static void main(String[] args) throws SQLException {
        new Reception("Guest");
    }
}
