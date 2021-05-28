package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Start extends JFrame implements ActionListener
{
	JPanel panel;
	JButton b;
	public static void main(String[] args) 
	{
		new Start().setVisible(true);
	}

	public Start()
	{
		setBounds(400,150,550,450);
		setResizable(false);
		setTitle("Home");
		panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		JLabel l = new JLabel("");
		b = new JButton("CLICK HERE TO PROCEED");
		b.setBackground(new Color(90,70,40));
		b.setForeground(Color.WHITE);
		b.setBounds(280, 250, 200, 30);
		b.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/com/Icons/lms1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(578, 430, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		l = new JLabel(i3);
		l.setBounds(0, 0, 578, 430);
		add(l);
		l.add(b);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b)
		{
			setVisible(false);
			new Login_user().setVisible(true);
		}
	}
}
