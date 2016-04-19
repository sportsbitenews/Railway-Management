import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Welcome implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3;
	Login l;
	Signup s;
	ImageIcon img;
	JButton b1,b2;
	Welcome()
	{
		img=new ImageIcon("/home/vjain/workspace/Railway-Management/images/indian-rail.jpg");
		f=new JFrame("Welcome");
		b1=new JButton("LOGIN");
		b1.setForeground(Color.blue);
		b1.addActionListener(this);
		b1.setBounds(500,500,100,30);
		b2=new JButton("SIGNUP");
		b2.setForeground(Color.blue);
		b2.addActionListener(this);
		b2.setBounds(700,500,100,30);
		f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		f.getContentPane().setLayout(null);
		f.getContentPane().setBackground(Color.yellow);
		l1=new JLabel("OnLine Railway Reservation");
		l1.setBounds(150,300,1000,50);
		l1.setFont(new Font("Courier new",Font.BOLD,60));
		l1.setForeground(Color.red);
		l2=new JLabel("And Enquiry");
		l2.setFont(new Font("Courier new",Font.BOLD,60));
		l2.setBounds(400,380,800,60);
		l2.setForeground(Color.red);
		l3=new JLabel(img);
		l3.setBounds(0,0,1300,1000);
		f.getContentPane().add(l1);
		f.getContentPane().add(l2);
		f.getContentPane().add(l3);	
		f.setSize(1300,1000);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			f.setVisible(false);
			l=new Login();
		}
		if(e.getSource()==b2)
		{
			f.setVisible(false);
			s=new Signup();
		}
	}
}