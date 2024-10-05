package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener{
    JTextField textField;
    JPasswordField passField;
    JButton b1,b2,b3;

    Login(){

        JLabel namelabel=new JLabel("Username");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Oswald",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        JLabel sig=new JLabel("Don't have an account yet?");
        sig.setBounds(40,205,195,30);
        sig.setFont(new Font("Oswald",Font.BOLD,13));
        sig.setForeground(Color.BLACK);
        add(sig);

        JLabel password=new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Oswald",Font.BOLD,16));
        password.setForeground(Color.BLACK);
        add(password);

        textField=new JTextField();
        textField.setBounds(150,22,150,27);
        textField.setFont(new Font("Oswald",Font.PLAIN,15));
        textField.setBackground(new Color(255, 255, 255));
        add(textField);

        passField=new JPasswordField();
        passField.setBounds(150,72,150,27);
        passField.setFont(new Font("Oswald",Font.PLAIN,15));
        passField.setBackground(new Color(255, 255, 255));
        add(passField);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/logo1.png"));
        Image i1=imageIcon.getImage().getScaledInstance(350,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(335,0,350,250);
        add(label);

        b1=new JButton("LOGIN");
        b1.setBounds(40,165,120,30);
        b1.setFont(new Font("Oswald", Font.BOLD,13));
        b1.setBackground(new Color(4, 176, 232));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("CANCEL");
        b2.setBounds(180,165,120,30);
        b2.setFont(new Font("Oswald", Font.BOLD,13));
        b2.setBackground(new Color(148, 10, 10));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Sign up");
        b3.setBounds(213,205,50,30);
        b3.setFont(new Font("Oswald", Font.BOLD,13));
        b3.setBackground(null);
        b3.setForeground(new Color(5, 66, 16));
        b3.setBorder(null);
        b3.addActionListener(this);
        add(b3);

        getContentPane().setBackground(new Color(251, 238, 247));
        setSize(700,300);
        setLocation(550,350);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }
    String user="";

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try{
                Conn c=new Conn();
                user=textField.getText();
                String pass=passField.getText();

                String q="select * from login where ID='"+user+"' and PWD='"+pass+"'";
                ResultSet resultSet=c.statement.executeQuery(q);

                if(resultSet.next()){
                    String firstName = resultSet.getString("Fname");
                    new Reception(firstName);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource()==b3){
            new CreateAcc();
        }
        else{
            System.exit(10);
        }
    }
}
