import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Login implements ActionListener {
    JFrame f;
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    Welcome W;
    Main M;
    ImageIcon img,img2;
    Login() {
        img = new ImageIcon("images/student login.jpg");
        img2 = new ImageIcon("images/railway_track-wallpaper-1366x768.jpg");
        f=new JFrame("Login");
        f.getContentPane().setLayout(null);
        f.getContentPane().setBackground(Color.white);
        l1=new JLabel("User Name");
        l1.setForeground(Color.black);
        l1.setBounds(40,15,150,30);
        l2=new JLabel("Password");
        l2.setForeground(Color.black);
        l2.setBounds(40,65,150,30);
        l3=new JLabel(img);
        l3.setBounds(0,0,320,180);
        l4=new JLabel(img2);
        l4.setBounds(0,0,600,600);
        t1=new JTextField(10);
        t1.setForeground(Color.black);
        t1.addActionListener(this);
        t1.setBounds(140,15,120,30);
        t2=new JPasswordField(10);
        t2.setForeground(Color.black);
        t2.setEchoChar('*');
        t2.addActionListener(this);
        t2.setBounds(140,65,120,30);
        b1=new JButton("Ok");
        b1.setForeground(Color.blue);
        b1.addActionListener(this);
        b1.setBounds(60,145,80,20);
        b2=new JButton("Cancel");
        b2.setForeground(Color.blue);
        b2.addActionListener(this);
        b2.setBounds(170,145,80,20);
        
        b1.setMnemonic('O');
        b2.setMnemonic('C');
        
        f.getContentPane().add(l1);
        f.getContentPane().add(l2);
        f.getContentPane().add(t1);
        f.getContentPane().add(t2);
        f.getContentPane().add(b1);
        f.getContentPane().add(b2);
        f.getContentPane().add(l3);
//        f.getContentPane().add(l4);
        f.setBounds(0,0,320,206);
        f.setResizable(false);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            if(t1.getText().length()==0||t2.getText().length()==0) {
                JOptionPane.showMessageDialog(null,"Fields are empty");
            }
            else if(t1.getText().equals("dush") && t2.getText().equals("1234")) {
                f.setVisible(false);
                M=new Main();
            }
            else {
                JOptionPane.showMessageDialog(null,"Invalid User Name or Password");
            }
        }
        if(e.getSource()==b2) {
            f.setVisible(false);
            W = new Welcome();
        }
    }
}