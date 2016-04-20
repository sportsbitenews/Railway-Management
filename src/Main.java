import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
class Main implements ActionListener {
    JFrame f;
    JButton b1,b2,b3,b4;
    Reservation r;
    PNR_Enquiry q;
    Train_Enquiry TE;
    JLabel imgL,imgL2;
    ImageIcon img,img2;
    Main() {
        b1 = new JButton(new ImageIcon(((new ImageIcon(
            "images/reservations_button.png").getImage()
            .getScaledInstance(140,40,
                    java.awt.Image.SCALE_SMOOTH)))));
        b2 = new JButton(new ImageIcon(((new ImageIcon(
            "images/pnr.png").getImage()
            .getScaledInstance(140,40,
                    java.awt.Image.SCALE_SMOOTH)))));
        b3 = new JButton(new ImageIcon(((new ImageIcon(
            "images/enquiry.jpg").getImage()
            .getScaledInstance(140,40,
                    java.awt.Image.SCALE_SMOOTH)))));
        b4 = new JButton(new ImageIcon(((new ImageIcon(
            "images/exit-44205_640.png").getImage()
            .getScaledInstance(210, 60,
                    java.awt.Image.SCALE_SMOOTH)))));
        img=new ImageIcon("images/fantastic-railway-wallpaper-1825-1971-hd-wallpapers.jpg");
        //img2=new ImageIcon("");
        imgL=new JLabel(img);
        //Img = new JButton(img2);
        imgL.setBounds(0,0,1400,1000);
        f=new JFrame("Main");
        f.getContentPane().setLayout(null);
        f.getContentPane().setBackground(Color.yellow);
        //b1=new JButton("Reservation Form");
        b1.addActionListener(this);
        b1.setBounds(900,90,140,40);
        //b2=new JButton("PNR-enquiry");
        b2.addActionListener(this);
        b2.setBounds(1050,90,140,40);
        //b3=new JButton("Cancellation Form");
        b3.addActionListener(this);
        b3.setBounds(900,190,140,40);
        //b4=new JButton("Exit");
        b4.addActionListener(this);
        b4.setBounds(1050,190,140,40);
        
        b1.setBackground(new Color(233,213,34));
        b1.setForeground(new Color(255,255,255));
        b2.setBackground(new Color(233,213,34));
        b2.setForeground(new Color(255,255,255));
        b3.setBackground(new Color(233,213,34));
        b3.setForeground(new Color(255,255,255));
        b4.setBackground(new Color(233,213,34));
        b4.setForeground(new Color(255,255,255));
        
        b1.setMnemonic('R');
        b2.setMnemonic('P');
        b3.setMnemonic('C');
        b4.setMnemonic('E');
        
        f.getContentPane().add(b1);
        f.getContentPane().add(b2);
        f.getContentPane().add(b3);
        f.getContentPane().add(b4);
        f.getContentPane().add(imgL);
        f.setSize(1400,1000);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            f.setVisible(false);
            r=new Reservation();
        }
        if(e.getSource()==b2) {
            f.setVisible(false);
            q=new PNR_Enquiry();
        }
        if(e.getSource()==b3) {
            f.setVisible(false);
            TE=new Train_Enquiry();
        }
        if(e.getSource()==b4) {
            f.setVisible(false);
            System.exit(0);
        }
    }
}