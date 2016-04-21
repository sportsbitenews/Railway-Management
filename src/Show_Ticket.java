import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Show_Ticket implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3;
	JTextArea t1;
	ImageIcon img;
	JButton b1,b2;
	Show_Ticket()
	{
		f=new JFrame("TICKET");
		l1=new JLabel("Your Ticket Details ");
		l1.setBounds(150,100,1000,50);
		l1.setFont(new Font("Courier new",Font.BOLD,60));
		l1.setForeground(Color.red);
		t1=new JTextArea();
		t1.setBounds(150,250,1000,500);
		f.getContentPane().add(l1);
		f.getContentPane().add(t1);
		f.getContentPane().setLayout(null);
		f.getContentPane().setBackground(Color.yellow);
		f.setSize(1300,1000);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		
	}
}