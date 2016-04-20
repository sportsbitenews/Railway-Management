import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Train_Enquiry implements ActionListener {
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,imgL;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1,b2;
    Welcome w;
    ImageIcon img;
    Choice h,h1;
    Main M;
    User U;
    Train_Enquiry() {
        f=new JFrame("Train Enquiry");
        f.getContentPane().setLayout(null);
        f.getContentPane().setBackground(Color.white);
        l1=new JLabel("From Station");
        l1.setForeground(Color.blue);
        l1.setBounds(50,110,100,30);
        l2=new JLabel("To Station");
        l2.setForeground(Color.blue);
        l2.setBounds(50,140,100,30);
        l3=new JLabel("Date of Journey");
        l3.setForeground(Color.blue);
        l3.setBounds(50,170,100,30);
        l4=new JLabel("Class Seat");
        l4.setForeground(Color.blue);
        l4.setBounds(50,200,100,30);
        l5=new JLabel("Train Type");
        l5.setForeground(Color.blue);
        l5.setBounds(50,230,100,30);
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
        h=new Choice();
        h.setBounds(150,200,100,22);
        h.add("AC");
        h.add("SL");
        h.add("GENERAL");
        h1=new Choice();
        h1.setBounds(150,230,100,22);
        h1.add("All");
        h1.add("Superfast");
        h1.add("Express");
        h1.add("Rajdhani");
        h1.add("Shatabdi");
        h1.add("Duronto");
       
        b1=new JButton("Enquire");
        b1.setForeground(Color.blue);
        b1.addActionListener(this);
        b1.setBounds(50,380,100,30);
        b2=new JButton("Cancel");
        b2.setForeground(Color.blue);
        b2.addActionListener(this);
        b2.setBounds(180,380,100,30);
        f.getContentPane().add(l1);
        f.getContentPane().add(l2);
        f.getContentPane().add(l3);
        f.getContentPane().add(l4);
        f.getContentPane().add(l5);
        f.getContentPane().add(h);
        f.getContentPane().add(h1);
        f.getContentPane().add(t1);
        f.getContentPane().add(t2);
        f.getContentPane().add(t3);
        f.getContentPane().add(b1);
        f.getContentPane().add(b2);
        f.setBounds(0,0,1200,600);

        f.setResizable(true);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==b1) {
            if(t1.getText().length()==0||t2.getText().length()==0||t3.getText().length()==0) {
                JOptionPane.showMessageDialog(null,"Fields are empty");
            }
           
        }
        if(e.getSource()==b2) {
            f.setVisible(false);
            M=new Main();
        }
    }
}