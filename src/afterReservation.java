import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class afterReservation implements ActionListener,FocusListener {
    JFrame f;
    JLabel sNo,Name,Age,Gender,srNo[];
    JTextField details[][];
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
    afterReservation(int n) {
        b1 = new JButton(new ImageIcon(((new ImageIcon(
        "Next-Thin-Master-Logo-2014-Reversed.jpg").getImage()
        .getScaledInstance(100,30,
                java.awt.Image.SCALE_SMOOTH)))));
        b2 = new JButton(new ImageIcon(((new ImageIcon(
            "back-clipart-back-md.png").getImage()
            .getScaledInstance(100,30,
                    java.awt.Image.SCALE_SMOOTH)))));
        srNo = new JLabel[n+1];
        details = new JTextField[n+1][4];
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
            for(int j=0;j<4;j++) {
                if(j==0) {
                    srNo[i]=new JLabel(""+i);
                    srNo[i].setForeground(Color.red);
                    srNo[i].setBounds(pos[j],150+add*i,100,30);
                    f.getContentPane().add(srNo[i]);
                }
                else {
                    details[i][j]=new JTextField(30);
                    details[i][j].setForeground(Color.red);
                    details[i][j].setBounds(pos[j],150+add*i,100,30);
                    details[i][j].addActionListener(this);
                    f.getContentPane().add(details[i][j]);
                }
            }
        }
        f.setBounds(0,0,1200,1000);
        b1.setBounds(300,495,100,30);
        b2.setBounds(500,495,100,30);
        b1.addActionListener(this);
        b2.addActionListener(this);

        f.getContentPane().add(b1);
        f.getContentPane().add(b2);
        
        f.setVisible(true);
    }
    public void focusLost(FocusEvent e) {
/*        if(t2.getText().length()!=0) {
            try {
                //ps=con.prepareStatement("select Train_Name from Train where Train_No=?");
                ps.setString(1,t2.getText());
                rs=ps.executeQuery();
                if(rs.next()) {
                    t3.setText(rs.getString(1));
                }
            }
            catch(Exception e1) {
                System.out.println("Connection failed:"+e1);
            }
        }
*/    }
    public void focusGained(FocusEvent e) {}
    public void actionPerformed(ActionEvent e) {
/*        if(e.getSource()==b1) {
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
*/    }
    public static void main(String args[]) {
        new Reservation();
    }
}