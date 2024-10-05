package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT extends JFrame implements ActionListener{

    JComboBox comboBox, comboBox1,comboMar;
    JTextField textFieldNumber, textName,textDOB,textAddress,textEmail,textIdno, textHistory,textAllergy,textMed,textEmph,textIns,textInsno,textOcc,textLang,textNote, textFieldDisease, textFieldDeposit;
    JRadioButton r1,r2,r3;
    JLabel date;
    JButton b1,b2;
    Choice c1;

    NEW_PATIENT(){

        JPanel panel=new JPanel();
        panel.setBounds(0,0,1920,820);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/patient2.png"));
        Image image=imageIcon.getImage().getScaledInstance(850,783,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(1050,0,1500,783);
        panel.add(label);

        JLabel labelName=new JLabel("<html><u>NEW PATIENT FORM</u></html>");
        labelName.setBounds(35,11,340,53);
        labelName.setFont(new Font("Oswald",Font.BOLD,30));
        panel.add(labelName);



        JLabel labelName1 =new JLabel("Full Name:");
        labelName1.setBounds(35,130,200,20);
        labelName1.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelName1);

        textName=new JTextField();
        textName.setBounds(240,130,150,25);
        panel.add(textName);

        JLabel dob =new JLabel("Date of Birth:");
        dob.setBounds(35,180,200,20);
        dob.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(dob);

        textDOB=new JTextField();
        textDOB.setBounds(240,180,150,25);
        panel.add(textDOB);

        JLabel labelGender =new JLabel("Gender:");
        labelGender.setBounds(35,230,200,20);
        labelGender.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelGender);

//        r1=new JRadioButton("Male");
//        r1.setFont(new Font("Oswald",Font.BOLD,14));
//        r1.setBounds(271,191,80,12);
//        panel.add(r1);
//
//        r2=new JRadioButton("Female");
//        r2.setFont(new Font("Oswald",Font.BOLD,14));
//        r2.setBounds(271,210,80,12);
//        panel.add(r2);
//
//        r3=new JRadioButton("Others");
//        r3.setFont(new Font("Oswald",Font.BOLD,14));
//        r3.setBounds(271,230,80,12);
//        panel.add(r3);

        comboBox1=new JComboBox(new String[]{"Male","Female","Others"});
        comboBox1.setBounds(240,230,150,25);
        comboBox1.setFont(new Font("Oswald",Font.BOLD,14));
        comboBox1.setBackground(Color.WHITE);
        panel.add(comboBox1);

        JLabel labelMar =new JLabel("Marital Status:");
        labelMar.setBounds(35,280,200,20);
        labelMar.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelMar);

        comboMar=new JComboBox(new String[]{"Married","Unmarried","Divorced"});
        comboMar.setBounds(240,280,150,25);
        comboMar.setFont(new Font("Oswald",Font.BOLD,14));
        comboMar.setBackground(Color.WHITE);
        panel.add(comboMar);

        JLabel labelAddr =new JLabel("Address:");
        labelAddr.setBounds(35,330,200,20);
        labelAddr.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelAddr);

        textAddress=new JTextField();
        textAddress.setBounds(240,330,150,25);
        panel.add(textAddress);

        JLabel labelNumber =new JLabel("Contact No:");
        labelNumber.setBounds(35,380,200,20);
        labelNumber.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelNumber);

        textFieldNumber=new JTextField();
        textFieldNumber.setBounds(240,380,150,25);
        panel.add(textFieldNumber);

        JLabel labelEmail =new JLabel("E-mail:");
        labelEmail.setBounds(35,430,200,20);
        labelEmail.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelEmail);

        textEmail=new JTextField();
        textEmail.setBounds(240,430,150,25);
        panel.add(textEmail);

        JLabel labelID =new JLabel("ID Type:");
        labelID.setBounds(35,480,200,20);
        labelID.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelID);

        comboBox=new JComboBox(new String[]{"Aadhar Card","Voter Id","Driving License","PAN Card"});
        comboBox.setBounds(240,480,150,25);
        comboBox.setFont(new Font("Oswald",Font.BOLD,14));
        comboBox.setBackground(Color.WHITE);
        panel.add(comboBox);

        JLabel labelIdno =new JLabel("ID Number:");
        labelIdno.setBounds(35,530,200,20);
        labelIdno.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelIdno);

        textIdno=new JTextField();
        textIdno.setBounds(240,530,150,25);
        panel.add(textIdno);

        JLabel labelDisease =new JLabel("Diagnosis:");
        labelDisease.setBounds(35,580,200,20);
        labelDisease.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelDisease);

        textFieldDisease=new JTextField();
        textFieldDisease.setBounds(240,580,150,25);
        panel.add(textFieldDisease);

        JLabel labelMedhis =new JLabel("Medical History:");
        labelMedhis.setBounds(500,130,200,20);
        labelMedhis.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelMedhis);

        textHistory=new JTextField();
        textHistory.setBounds(705,130,150,25);
        panel.add(textHistory);

        JLabel labelAllergy =new JLabel("Allergies:");
        labelAllergy.setBounds(500,180,200,20);
        labelAllergy.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelAllergy);

        textAllergy=new JTextField();
        textAllergy.setBounds(705,180,150,25);
        panel.add(textAllergy);

        JLabel labelMed =new JLabel("Current Medication:");
        labelMed.setBounds(500,230,200,20);
        labelMed.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelMed);

        textMed=new JTextField();
        textMed.setBounds(705,230,150,25);
        panel.add(textMed);

        JLabel labelConal =new JLabel("Alternate Contact:");
        labelConal.setBounds(500,330,200,20);
        labelConal.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelConal);

        textEmph=new JTextField();
        textEmph.setBounds(705,330,150,25);
        panel.add(textEmph);

        JLabel labelRoom =new JLabel("Room:");
        labelRoom.setBounds(500,380,200,20);
        labelRoom.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelRoom);

        //Room Choice//
        c1=new Choice();
        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from Room");
            while(resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(705,380,150,25);
        c1.setFont(new Font("Oswald",Font.BOLD,14));
        c1.setBackground(Color.white);
        panel.add(c1);

        JLabel labelIns =new JLabel("Insurance Name:");
        labelIns.setBounds(500,430,200,20);
        labelIns.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelIns);

        textIns=new JTextField();
        textIns.setBounds(705,430,150,25);
        panel.add(textIns);

        JLabel labelInsno =new JLabel("Policy Number:");
        labelInsno.setBounds(500,480,200,20);
        labelInsno.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelInsno);

        textInsno=new JTextField();
        textInsno.setBounds(705,480,150,25);
        panel.add(textInsno);

        JLabel labelDeposit =new JLabel("Deposit:");
        labelDeposit.setBounds(500,530,200,25);
        labelDeposit.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelDeposit);

        textFieldDeposit=new JTextField();
        textFieldDeposit.setBounds(705,530,150,25);
        panel.add(textFieldDeposit);

        JLabel labelOcc =new JLabel("Occupation:");
        labelOcc.setBounds(500,580,200,25);
        labelOcc.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelOcc);

        textOcc=new JTextField();
        textOcc.setBounds(705,580,150,25);
        panel.add(textOcc);

        JLabel labelLang =new JLabel("Language:");
        labelLang.setBounds(930,130,200,25);
        labelLang.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelLang);

        textLang=new JTextField();
        textLang.setBounds(1100,130,150,25);
        panel.add(textLang);

        JLabel labelDate =new JLabel("Date & Time:");
        labelDate.setBounds(930,180,200,20);
        labelDate.setFont(new Font("Oswald",Font.BOLD,20));
        panel.add(labelDate);

        Date date1=new Date();

        date=new JLabel(""+date1);
        date.setBounds(1100,180,290,25);
        date.setFont(new Font("Oswald",Font.BOLD,17));
        panel.add(date);

        b1=new JButton("ADD");
        b1.setFont(new Font("Oswald", Font.BOLD,15));
        b1.setBounds(35,700,120,30);
        b1.setBackground(new Color(4, 176, 232));
        b1.setForeground(new Color(255,255,255));
        b1.addActionListener(this);
        panel.add(b1);

        b2=new JButton("CANCEL");
        b2.setFont(new Font("Oswald", Font.BOLD,15));
        b2.setBounds(180,700,120,30);
        b2.setBackground(new Color(248, 82, 82));
        b2.setForeground(new Color(255, 255, 255));
        b2.addActionListener(this);
        panel.add(b2);


        setUndecorated(true);
        setSize(1920,820);
        setLayout(null);
        setLocation(0,215);
        setVisible(true);
    }
    public static void main(String[] args) {
        new NEW_PATIENT();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            Conn c=new Conn();
            String s1=textName.getText();
            String s2=textDOB.getText();
            String s3=(String) comboBox1.getSelectedItem();
            String s4=(String) comboMar.getSelectedItem();
            String s5=textAddress.getText();
            String s6= textFieldNumber.getText();
            String s7=textEmail.getText();
            String s8=(String) comboBox.getSelectedItem();
            String s9=textIdno.getText();
            String s10=textFieldDisease.getText();
            String s11=textHistory.getText();
            String s12=textAllergy.getText();
            String s13=textMed.getText();
            String s14=textEmph.getText();
            String s15=c1.getSelectedItem();
            String s16=textIns.getText();
            String s17=textInsno.getText();
            String s18=textFieldDeposit.getText();
            String s19=textOcc.getText();
            String s20=textLang.getText();
            String s21= date.getText();


            try{
                String q="INSERT INTO patient (FullName, DateOfBirth, Gender, MaritalStatus, Address, PhoneNumber, EmailAddress, IDType, IDNumber, Diagnosis, MedicalHistory, Allergies, CurrentMedications, EmergencyContactPhoneNumber,Room, InsuranceProvider, PolicyNumber, Deposit, Occupation, LanguagePreferences,Date) VALUES ('"+s1+"', '"+s2+"', '"+s3+"', '"+s4+"', '"+s5+"', '"+s6+"', '"+s7+"', '"+s8+"', '"+s9+"', '"+s10+"', '"+s11+"', '"+s12+"', '"+s13+"', '"+s14+"', '"+s15+"', '"+s16+"', '"+s17+"', '"+s18+"', '"+s19+"', '"+s20+"', '"+s21+"')";
                String q1 = "UPDATE Room SET Availability = 'Occupied' WHERE room_no = '" + s15 + "'";
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Patient admitted successfully");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
}
