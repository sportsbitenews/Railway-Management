import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class PNR_Enquiry implements  ActionListener {
    JFrame f;
    JLabel l1,l2,l3,imgL;
    Main m;
    ImageIcon img;
    JTextField t;
    JButton b1,b2;
    PNR_Enquiry() {
    img=new ImageIcon("images/512496759.jpg");
    imgL = new JLabel(img);
    imgL.setBounds(0,0,1300,700);
    f=new JFrame("PNR ENQUIRY");
    b1=new JButton("GET DETAILS");
    b1.setForeground(Color.blue);
    b1.addActionListener(this);
    b1.setBounds(50,300,150,45);
    
    b2=new JButton("Main Menu");
    b2.setForeground(Color.blue);
    b2.addActionListener(this);
    b2.setBounds(200,300,150,45);
    f.getContentPane().add(b1);
    b1.setEnabled(false);
    f.getContentPane().add(b2);
    f.getContentPane().setLayout(null);
    f.getContentPane().setBackground(Color.black);
    l1=new JLabel("PNR Number");
    l1.setBounds(50,100,500,50);
    l1.setFont(new Font("Courier new",Font.BOLD,40));
    l1.setForeground(Color.white);
    t=new JTextField(10);
    t.setForeground(Color.blue);
    t.setBounds(50,200,300,40);
    t.addActionListener(this);
    t.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
      
            
        if(t.getText().length()>=9) b1.setEnabled(true);
        if(t.getText().length() >=10) e.consume();
        if(t.getText().length()<9) b1.setEnabled(false);
        }});
    f.getContentPane().add(t);
    f.getContentPane().add(imgL);
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