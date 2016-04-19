import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

class Signup implements ActionListener {
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,imgL;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1,b2;
    Welcome w;
    ImageIcon img;
    Choice h1,h2;
    Main M;
    User U;
    Signup() {
        img = new ImageIcon("images/maxresdefault.jpg");
        imgL=new JLabel(img);
        imgL.setBounds(0,0,1200,600);
        b1 = new JButton(new ImageIcon(((new ImageIcon(
        "images/SignUpNow.jpg").getImage()
        .getScaledInstance(100,30,
                java.awt.Image.SCALE_SMOOTH)))));
        b2 = new JButton(new ImageIcon(((new ImageIcon(
            "images/back-clipart-back-md.png").getImage()
            .getScaledInstance(100,30,
                    java.awt.Image.SCALE_SMOOTH)))));
        ArrayList<String> al = new ArrayList<String>();
        al.add("Andaman and Nicobar Islands");
        al.add("Andhra Pradesh");
        al.add("Arunachal Pradesh");
        al.add("Assam");
        al.add("Bihar");
        al.add("Chandigarh");
        al.add("Chhattisgarh");
        al.add("Dadra and Nagar Haveli");
        al.add("Daman and Diu");
        al.add("National Capital Territory of Delhi");
        al.add("Goa");
        al.add("Gujrat");
        al.add("Haryana");
        al.add("Himachal Pradesh");
        al.add("Jammu and Kashmir");
        al.add("Jharkhand");
        al.add("Karnatka");
        al.add("Kerala");
        al.add("Lakshadeep");
        al.add("Madhya Pradesh");
        al.add("Maharashtra");
        al.add("Manipur");
        al.add("Meghalaya");
        al.add("Mizormam");
        al.add("Nagaland");
        al.add("Odisha");
        al.add("Puducherry");
        al.add("Punjab");
        al.add("Rajasthan");
        al.add("Sikkim");
        al.add("Tamil Nadu");
        al.add("Telangana");
        al.add("Tripura");
        al.add("Uttar Pradesh");
        al.add("Uttarakhand");
        al.add("West Bengal");
        f=new JFrame("Signup");
        f.getContentPane().setLayout(null);
        f.getContentPane().setBackground(Color.white);
        l1=new JLabel("Email id");
        l1.setForeground(Color.yellow);
        l1.setBounds(50,110,100,30);
        l2=new JLabel("Password");
        l2.setForeground(Color.yellow);
        l2.setBounds(50,140,100,30);
        l3=new JLabel("Full Name");
        l3.setForeground(Color.yellow);
        l3.setBounds(50,170,100,30);
        l4=new JLabel("Gender");
        l4.setForeground(Color.yellow);
        l4.setBounds(50,200,100,30);
        h1=new Choice();
        h1.setBounds(150,200,100,30);
        h1.add("MALE");
        h1.add("FEMALE");
        l5=new JLabel("Age");
        l5.setForeground(Color.yellow);
        l5.setBounds(50,230,100,30);
        l6=new JLabel("Mobile Number");
        l6.setForeground(Color.yellow);
        l6.setBounds(50,260,100,30);
        l7=new JLabel("City");
        l7.setForeground(Color.yellow);
        l7.setBounds(50,290,100,30);
        l8=new JLabel("State");
        l8.setForeground(Color.yellow);
        l8.setBounds(50,320,100,30);
        h2=new Choice();
        h2.setBounds(150,320,100,50);
        for(int i=0;i<=35;i++) {
            h2.add(al.get(i));
        }
        t1=new JTextField(10);
        t1.setForeground(Color.blue);
        t1.addActionListener(this);
        t1.setBounds(150,110,100,22);
        t2=new JTextField(10);
        t2.setForeground(Color.blue);
        t2.addActionListener(this);
        t2.setBounds(150,140,100,22);
        t3=new JTextField(10);
        t3.setForeground(Color.blue);
        t3.addActionListener(this);
        t3.setBounds(150,170,100,22);
        t4=new JTextField(10);
        t4.setForeground(Color.blue);
        t4.addActionListener(this);
        t4.setBounds(150,200,100,22);
        t5=new JTextField(10);
        t5.setForeground(Color.blue);
        t5.addActionListener(this);
        t5.setBounds(150,230,100,22);
        t6=new JTextField(10);
        t6.setForeground(Color.blue);
        t6.addActionListener(this);
        t6.setBounds(150,260,100,22);
        t7=new JTextField(10);
        t7.setForeground(Color.blue);
        t7.addActionListener(this);
        t7.setBounds(150,290,100,22);
        t8=new JTextField(10);
        t8.setForeground(Color.blue);
        t8.addActionListener(this);
        t8.setBounds(150,320,100,22);
        //b1=new JButton("ADD");
        b1.setForeground(Color.blue);
        b1.addActionListener(this);
        b1.setBounds(50,380,100,30);
        //b2=new JButton("Cancel");
        b2.setForeground(Color.blue);
        b2.addActionListener(this);
        b2.setBounds(180,380,100,30);
        f.getContentPane().add(l1);
        f.getContentPane().add(l2);
        f.getContentPane().add(l3);
        f.getContentPane().add(l4);
        f.getContentPane().add(l5);
        f.getContentPane().add(l6);
        f.getContentPane().add(l7);
        f.getContentPane().add(l8);
        f.getContentPane().add(h1);
        f.getContentPane().add(h2);
        f.getContentPane().add(t1);
        f.getContentPane().add(t2);
        f.getContentPane().add(t3);
        f.getContentPane().add(t4);
        f.getContentPane().add(t5);
        f.getContentPane().add(t6);
        f.getContentPane().add(t7);
        f.getContentPane().add(t8);
        f.getContentPane().add(b1);
        f.getContentPane().add(b2);
        f.setBounds(0,0,1200,600);
        f.getContentPane().add(imgL);

        f.setResizable(true);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==b1) {
            if(t1.getText().length()==0||t2.getText().length()==0||t3.getText().length()==0||t5.getText().length()==0||t6.getText().length()==0||t7.getText().length()==0) {
                JOptionPane.showMessageDialog(null,"Fields are empty");
            }
           U=new User();
           U.setEmail(t1.getText());
           U.setPassword(t2.getText());
           U.setName(t3.getText());
           if(h1.getSelectedItem().compareTo("Male")==0)
                U.setGender('M');
           else
                U.setGender('F');
           U.setAge(Integer.parseInt(t5.getText()));
           U.setMobile(t6.getText());
           U.setCity(t7.getText());
           U.setState(h2.getSelectedItem());
           //U.print();
           
        }
        if(e.getSource()==b2) {
            f.setVisible(false);
            w=new Welcome();
        }
    }
}