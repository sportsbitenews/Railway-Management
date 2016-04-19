import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Reservation implements ActionListener,FocusListener {
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
    JLabel imgL;
    ImageIcon img;
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
    public void focusLost(FocusEvent e) {
        if(t2.getText().length()!=0) {
            try {
                //ps=con.prepareStatement("select Train_Name from Train where Train_No=?");
                //ps.setString(1,t2.getText());
                //rs=ps.executeQuery();
                //if(rs.next()) {
                  //  t3.setText(rs.getString(1));
                //}
            }
            catch(Exception e1) {
                System.out.println("Connection failed:"+e1);
            }
        }
    }
    public void focusGained(FocusEvent e) {}
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            b1.setEnabled(false);
            try {
                //st=con.createStatement();
                rs=st.executeQuery("select * from PNR");
                rs.next();
                x=rs.getInt(1);
                t1.setText(String.valueOf(x));
                
            }
            catch(Exception e1) {
                System.out.println("Connection failed:"+e1);
            }
        }
        if(e.getSource()==b2) {
            try {
                //ps=con.prepareStatement("insert into Reservation values(?,?,?,?,?,?,?,?)");
                ps.setString(1,t1.getText());
                ps.setString(2,t2.getText());
                ps.setString(3,t3.getText());
                ps.setString(4,h.getSelectedItem());
                ps.setString(5,t4.getText());
                ps.setString(6,t5.getText());
                ps.setString(7,t6.getText());
                ps.setString(8,t7.getText());
                ps.executeUpdate();
                
                
                //update PNR no.
                //ps=con.prepareStatement("update PNR set PNR_No=? where PNR_No=?");
                ps.setInt(1,(x+1));
                ps.setInt(2,x);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Saved");
                
                b1.setEnabled(true);
                b2.setEnabled(false);
                f.setVisible(false);
                AR = new afterReservation(Integer.parseInt(t3.getText()));
            }
            catch(Exception e1) {
                System.out.println("Connection failed:"+e1);
            }
            try {
                //st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                rs=st.executeQuery("select * from Reservation");
                rs.last();
                x=rs.getInt(1);
                //Passenger P=new Passenger(x);
                //st=con.createStatement();
                rs=st.executeQuery("select * from PassengerID");
                rs.next();
                x=rs.getInt(1);
                //P.t1.setText(String.valueOf(x));
                //ps=con.prepareStatement("update PassengerID set PID=? where PID=?");
                ps.setInt(1,(x+1));
                ps.setInt(2,x);
                ps.executeUpdate();
            }
            catch(Exception e1) {
                System.out.println("Connection failed:"+e1);
            }
        }
        if(e.getSource()==b3) {
            f.setVisible(false);
            new Main();
        }
    }
    public static void main(String args[]) {
        new Reservation();
    }
}