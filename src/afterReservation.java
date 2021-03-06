import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
class afterReservation implements ActionListener {
    JFrame f;
    JLabel sNo,Name,Age,Gender,srNo[];
    JTextField details[][];
    Choice h[];
    afterReservation AR;
    JTextArea ta;
    JButton b1,b2,b3;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    Main M;
    int x;
    JLabel imgL;
    Show_Ticket ST;
    int N;
    Reservation_Class RC;
    ImageIcon img;
    ArrayList<Passenger> Passenger_Array=new ArrayList<Passenger>();
    afterReservation(int n,Reservation_Class RC) {
        img = new ImageIcon("images/maxresdefault (1).jpg");
        imgL = new JLabel(img);
        imgL.setBounds(0,0,1000,600);
        N=n;
        this.RC=RC;
        b1 = new JButton(new ImageIcon(((new ImageIcon(
        "images/Next-Thin-Master-Logo-2014-Reversed.jpg").getImage()
        .getScaledInstance(100,30,
                java.awt.Image.SCALE_SMOOTH)))));
        b2 = new JButton(new ImageIcon(((new ImageIcon(
            "images/back-clipart-back-md.png").getImage()
            .getScaledInstance(100,30,
                    java.awt.Image.SCALE_SMOOTH)))));
        srNo = new JLabel[n+1];
       
        details = new JTextField[n+1][4];
        h=new Choice[n+1];
        f = new JFrame("afterReservation");
        f.getContentPane().setLayout(null);
        sNo = new JLabel("Serial Number");
        Name = new JLabel("Name");
        Age = new JLabel("Age");
        Gender = new JLabel("Gender");
        sNo.setForeground(Color.black);
        Name.setForeground(Color.black);
        Age.setForeground(Color.black);
        Gender.setForeground(Color.black);
        sNo.setBounds(100,150,100,30);
        Name.setBounds(300,150,100,30);
        Age.setBounds(500,150,100,30);
        Gender.setBounds(700,150,100,30);
        f.getContentPane().add(sNo);
        f.getContentPane().add(Name);
        f.getContentPane().add(Age);
        f.getContentPane().add(Gender);
        int add = 50;
        int []pos = new int[4];
        pos[0]=100;
        pos[1]=300;
        pos[2]=500;
        pos[3]=700;
        
        for(int i=1;i<=n;i++) {
            for(int j=0;j<3;j++) {
                if(j==0) {
                    srNo[i]=new JLabel(""+i);
                    srNo[i].setForeground(Color.red);
                    srNo[i].setBounds(pos[j],150+add*i,100,22);
                    f.getContentPane().add(srNo[i]);
                }
                else {
                    details[i][j]=new JTextField(30);
                    details[i][j].setForeground(Color.red);
                    details[i][j].setBounds(pos[j],150+add*i,100,22);
                    details[i][j].addActionListener(this);
                    f.getContentPane().add(details[i][j]);       
                    
                }
            }
            h[i]=new Choice();
             h[i].setBounds(pos[3],150+add*i,100,22);
             h[i].add("Male");
             h[i].add("Female");
             f.getContentPane().add(h[i]);
            }
        
        f.setBounds(0,0,1000,600);
        b1.setBounds(300,495,100,30);
        b2.setBounds(500,495,100,30);
        b1.addActionListener(this);
        b2.addActionListener(this);

        f.getContentPane().add(b1);
        f.getContentPane().add(b2);
        f.getContentPane().add(imgL);
        
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        RC.setReservation_Status("Confirmed");
        for(int i=1;i<=N;i++) 
        { 
            char c=' ';
            if(h[i].getSelectedItem().equalsIgnoreCase("male"))
                c='M';
            if(h[i].getSelectedItem().equalsIgnoreCase("female"))
                c='F';
            Passenger_Array.add(new Passenger(details[i][1].getText(),Integer.parseInt(details[i][2].getText()),c));
            RC.setPassenger_array(Passenger_Array);
        }
        if(e.getSource()==b1) {
            Reserve_Seat rse = new Reserve_Seat();
            rse.Reserve(RC);
            f.setVisible(false);
            ST=new Show_Ticket();
        }
      if(e.getSource()==b2) {
          f.setVisible(false);
            M=new Main();
}
}
}