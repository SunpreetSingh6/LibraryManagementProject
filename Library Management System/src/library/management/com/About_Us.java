package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About_Us extends JFrame implements ActionListener
{	
	private JPanel panel;
	private JButton back;
	
	public static void main(String[] args) 
	{
		new About_Us().setVisible(true);
	}
	public About_Us()
	{
		setBounds(400,150,550,450);
		setResizable(false);
		setTitle("About Us");
		panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		JLabel lib_manage = new JLabel("ABOUT US");
		lib_manage.setForeground(new Color(255,80,0));
		lib_manage.setFont(new Font("",Font.BOLD,25));
		lib_manage.setBounds(190, 50, 150, 50);
		panel.add(lib_manage);
		
		JLabel l1= new JLabel("Developed By :- Sunpreet Singh");
		l1.setForeground(new Color(0,80,100));
		l1.setFont(new Font("",Font.BOLD,20));
		l1.setBounds(110, 100, 350, 40);
		panel.add(l1);
		
		JLabel connect = new JLabel("CONNECT WITH US");
		connect.setForeground(new Color(255,80,0));
		connect.setFont(new Font("",Font.BOLD,20));
		connect.setBounds(170, 160, 250, 50);
		panel.add(connect);
		
		JLabel l3= new JLabel("Email :- ssunpreet@gmail.com");
		l3.setForeground(new Color(0,80,100));
		l3.setFont(new Font("",Font.BOLD,15));
		l3.setBounds(150, 200, 350, 40);
		panel.add(l3);
		
		JLabel l2= new JLabel("Instagram :- @sunpreetxsingh");
		l2.setForeground(new Color(0,80,100));
		l2.setFont(new Font("",Font.BOLD,15));
		l2.setBounds(150, 240, 350, 40);
		panel.add(l2);
		
		back = new JButton("Back"); 
		back.setBackground(new Color(255,150,150));
		back.setForeground(new Color(90,0,0));
		back.setBounds(215, 370, 100, 30);
		back.addActionListener(this);
		panel.add(back);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			setVisible(false);
			new Home().setVisible(true);
		}
	}
	
}
