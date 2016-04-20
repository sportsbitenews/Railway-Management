import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
class Reservation implements ActionListener{
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    Choice h;
    afterReservation AR;
    JTextArea ta;
    JButton b1,b2,b3;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    int x;
    Login L;
    JLabel imgL;
    ImageIcon img;
    Check_Seat CS;
    Reservation_Class RC;
    Reservation() {
        b2 = new JButton(new ImageIcon(((new ImageIcon(
        "images/Next-Thin-Master-Logo-2014-Reversed.jpg").getImage()
        .getScaledInstance(100,30,
                java.awt.Image.SCALE_SMOOTH)))));
        b3 = new JButton(new ImageIcon(((new ImageIcon(
        "images/back-clipart-back-md.png").getImage()
        .getScaledInstance(100,30,
                java.awt.Image.SCALE_SMOOTH)))));

        img=new ImageIcon("images/ticket-ticket-icon-63140.png");
        imgL=new JLabel(img);
        imgL.setBounds(420,60,500,250);
        f=new JFrame("Reservation");
        f.getContentPane().setLayout(null);
        f.getContentPane().setBackground(Color.yellow);
        l2=new JLabel("Train No");
        l2.setBounds(50,80,100,22);
        l3=new JLabel("No of Passengers");
        l3.setBounds(50,110,150,22);
        l4=new JLabel("Class");
        l4.setBounds(50,140,100,22);
        l5=new JLabel("Date of Journey");
        l5.setBounds(50,170,100,22);
        l6=new JLabel("From");
        l6.setBounds(50,200,100,22);
        l7=new JLabel("To");
        l7.setBounds(300,200,50,22);
        t2=new JTextField(10);
        t2.setBounds(180,80,100,22);
        t3=new JTextField(10);
        t3.setBounds(180,110,100,22);
        t4=new JTextField(10);
        t4.setBounds(180,170,100,22);
        t5=new JTextField(10);
        t5.setBounds(180,200,100,22);
        t6=new JTextField(10);
        t6.setBounds(320,200,100,22);
        h=new Choice();
        h.setBounds(180,140,100,30);
        h.add("AC");
        h.add("SL");
        h.add("GENERAL");
        //b2=new JButton("Next");
        b2.setBackground(Color.yellow);
        b2.setBounds(160,270,100,30);
        b2.addActionListener(this);
        //b3=new JButton("Main");
        b3.setBackground(Color.yellow);
        b3.setBounds(270,270,100,30);
        b3.addActionListener(this);
        f.getContentPane().add(l2);
        f.getContentPane().add(l3);
        f.getContentPane().add(l4);
        f.getContentPane().add(l5);
        f.getContentPane().add(l6);
        f.getContentPane().add(l7);
        f.getContentPane().add(t2);
        f.getContentPane().add(t3);
        f.getContentPane().add(t4);
        f.getContentPane().add(t5);
        f.getContentPane().add(t6);
        f.getContentPane().add(h);
        f.getContentPane().add(b2);
        f.getContentPane().add(b3);
        f.getContentPane().add(imgL);
        f.setSize(1000,600);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2) {
            RC = new Reservation_Class();
            RC.setPnr();
            RC.setTrain_No(Integer.parseInt(t2.getText()));
            RC.setNo_of_Passengers(Integer.parseInt(t3.getText()));
            RC.setClass_Type(h.getSelectedItem());
            try 
            {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = (Date) formatter.parse(t4.getText());
                RC.setReservation_Date(date);
            }
            catch (ParseException pe)
            {
                pe.printStackTrace();
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
            RC.setDestination_name(t5.getText());
            RC.setSource_name(t6.getText());
            RC.setBooked_By_User(L.Username);
            RC.findID();
            //System.out.println(RC);
                f.setVisible(false);
            if(CS.check(RC)==true)
                AR = new afterReservation(Integer.parseInt(t3.getText()),RC);
            else
                JOptionPane.showMessageDialog(null,"Sorry! Seats are FULL");
            }
          
        if(e.getSource()==b3) {
            f.setVisible(false);
            new Main();
        }
    }
}