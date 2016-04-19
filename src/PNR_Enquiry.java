import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class PNR_Enquiry implements  ActionListener {
    JFrame f;
    JLabel l1,l2,l3;
    Main m;
    ImageIcon img;
    JTextField t;
    JButton b1,b2;
    PNR_Enquiry() {
    img=new ImageIcon("images/indian-rail.jpg");
    f=new JFrame("PNR ENQUIRY");
    b1=new JButton("GET DETAILS");
    b1.setForeground(Color.blue);
    b1.addActionListener(this);
    b1.setBounds(500,500,150,45);
    
    b2=new JButton("Main Menu");
    b2.setForeground(Color.blue);
    b2.addActionListener(this);
    b2.setBounds(500,600,150,45);
    f.getContentPane().add(b1);
    b1.setEnabled(false);
    f.getContentPane().add(b2);
    f.getContentPane().setLayout(null);
    f.getContentPane().setBackground(Color.yellow);
    l1=new JLabel("PNR Number");
    l1.setBounds(150,300,500,50);
    l1.setFont(new Font("Courier new",Font.BOLD,40));
    l1.setForeground(Color.red);
    t=new JTextField(10);
    t.setForeground(Color.blue);
    t.setBounds(450,310,300,40);
    t.addActionListener(this);
    t.addKeyListener(new KeyAdapter() {
        int previ=-1;
        public void keyTyped(KeyEvent e) {
            System.out.println(previ + " " + t.getText().length());
        if (previ+1==t.getText().length()) {
            System.out.println("AAA "+t.getText().length());
            // limit textfield to 10 characters
            if(t.getText().length()==9) b1.setEnabled(true);
        }
        if (previ==t.getText().length() ) {
            b1.setEnabled(false);
        }
        if(t.getText().length() >=10) e.consume();
        previ=t.getText().length();
        }});
    f.getContentPane().add(t);
    f.getContentPane().add(l1);
    f.setSize(1300,1000);
    f.setVisible(true);
    
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            f.setVisible(false);
        }
        if(e.getSource()==b2) {
            f.setVisible(false);
            m=new Main();
        }
    }
}