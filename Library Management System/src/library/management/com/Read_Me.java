package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Read_Me extends JFrame implements ActionListener
{
	private JTextArea ta;
	private JPanel panel;
	private JButton back;
	public static void main(String[] args) 
	{
		new Read_Me().setVisible(true);
	}
	
	public Read_Me()
	{
		setBounds(400,150,550,450);
		setResizable(false);
		setTitle("Read Me");
		panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		JLabel lib_manage = new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lib_manage.setForeground(new Color(255,80,0));
		lib_manage.setFont(new Font("",Font.BOLD,25));
		lib_manage.setBounds(60, 50, 500, 50);
		panel.add(lib_manage);
		
		JLabel l1= new JLabel("Developed By :- Sunpreet Singh");
		l1.setForeground(new Color(0,80,100));
		l1.setFont(new Font("",Font.BOLD,20));
		l1.setBounds(110, 100, 350, 40);
		panel.add(l1);
		
		ta = new JTextArea("Library management system is a project which aims in developing\n a computerized system to maintain all the "
				+ "daily work of a library.\n The system helps both students and library manager to keep a \n constant track of all the "
				+ " books available in the library. It allows both \n the admin and the student to search for the desired book.\n\n"
				+ "The main feature of this system is that all the books available in the \n library can be displayed in a list so that "
				+ "students need not roam \n through the entire library to find a book. Additionally, the application \n effectively maintains "
				+ "the details of users/students to whom books \n have been issued; it also records the issued date and return date.");
		ta.setEditable(false);
		ta.setBackground(Color.LIGHT_GRAY);
		ta.setForeground(Color.BLACK);
		ta.setBounds(80, 170, 370, 200);
		panel.add(ta);
		
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
