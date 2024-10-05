package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class CreateAcc extends JFrame implements ActionListener {
    JTextField fnameField, lnameField, textField;
    JPasswordField passField, repassField;
    JButton b1;

    CreateAcc() {

        JLabel fname = new JLabel("First name");
        fname.setBounds(40, 20, 150, 30);
        fname.setFont(new Font("Oswald", Font.BOLD, 16));
        fname.setForeground(Color.BLACK);
        add(fname);

        JLabel lname = new JLabel("Last name");
        lname.setBounds(40, 60, 150, 30);
        lname.setFont(new Font("Oswald", Font.BOLD, 16));
        lname.setForeground(Color.BLACK);
        add(lname);

        JLabel newuser = new JLabel("New username");
        newuser.setBounds(40, 100, 150, 30);
        newuser.setFont(new Font("Oswald", Font.BOLD, 16));
        newuser.setForeground(Color.BLACK);
        add(newuser);

        JLabel newpass = new JLabel("New password");
        newpass.setBounds(40, 140, 150, 30);
        newpass.setFont(new Font("Oswald", Font.BOLD, 16));
        newpass.setForeground(Color.BLACK);
        add(newpass);

        JLabel renewpass = new JLabel("Re-type password");
        renewpass.setBounds(40, 180, 150, 30);
        renewpass.setFont(new Font("Oswald", Font.BOLD, 16));
        renewpass.setForeground(Color.BLACK);
        add(renewpass);

        fnameField = new JTextField();
        fnameField.setBounds(200, 22, 150, 27);
        fnameField.setFont(new Font("Oswald", Font.PLAIN, 15));
        fnameField.setBackground(new Color(255, 255, 255));
        add(fnameField);

        lnameField = new JTextField();
        lnameField.setBounds(200, 62, 150, 27);
        lnameField.setFont(new Font("Oswald", Font.PLAIN, 15));
        lnameField.setBackground(new Color(255, 255, 255));
        add(lnameField);

        textField = new JTextField();
        textField.setBounds(200, 102, 150, 27);
        textField.setFont(new Font("Oswald", Font.PLAIN, 15));
        textField.setBackground(new Color(255, 255, 255));
        add(textField);

        passField = new JPasswordField();
        passField.setBounds(200, 142, 150, 27);
        passField.setFont(new Font("Oswald", Font.PLAIN, 15));
        passField.setBackground(new Color(255, 255, 255));
        add(passField);

        repassField = new JPasswordField();
        repassField.setBounds(200, 182, 150, 27);
        repassField.setFont(new Font("Oswald", Font.PLAIN, 15));
        repassField.setBackground(new Color(255, 255, 255));
        add(repassField);

        b1 = new JButton("CREATE ACCOUNT");
        b1.setBounds(40, 250, 160, 30);
        b1.setFont(new Font("Oswald", Font.BOLD, 13));
        b1.setBackground(new Color(2, 36, 31));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(new Color(251, 238, 247));
        setSize(700, 350);
        setLocation(550, 350);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CreateAcc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                Conn c = new Conn();
                String fname= fnameField.getText();
                String lname= lnameField.getText();
                String user = textField.getText();
                String pass = new String(passField.getPassword()); // Convert char[] to String
                String repass = new String(repassField.getPassword()); // Convert char[] to String

                if (Objects.equals(pass, repass)) {
                    String q = "INSERT INTO login (ID, PWD,Fname,Lname) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = c.connection.prepareStatement(q); // Use c.connection

                    pstmt.setString(1, user);
                    pstmt.setString(2, pass);
                    pstmt.setString(3, fname);
                    pstmt.setString(4, lname);

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Account created successfully");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Operation failed");
                    }

                    pstmt.close(); // Close PreparedStatement
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords didn't match");
                }

                c.connection.close(); // Close Connection
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
