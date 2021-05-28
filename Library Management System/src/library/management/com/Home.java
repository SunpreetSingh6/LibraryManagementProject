package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton logout,add_book,add_student,statistics,issue_book,return_book,about;
	
	public static void main(String[] args) 
	{
		new Home().setVisible(true);
	}

	public Home()
	{
		setBounds(400,150,550,450);
		setResizable(false);
		setTitle("Home");
		panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		// MenuBar
		
		JMenuBar menubar = new JMenuBar();
		menubar.setBounds(0, 0, 600, 25);
		menubar.setBackground(new Color(255,150,150));//192,192,150  ,  150,200,130 green   ,  
		panel.add(menubar);
		
		JMenu record = new JMenu("Record");
		panel.add(record);
		menubar.add(record);
		
		JMenuItem  book_detail = new JMenuItem("Book Details");
		book_detail.addActionListener(this);
		record.add(book_detail);
		JMenuItem  student_detail = new JMenuItem("Student Details");
		student_detail.addActionListener(this);
		record.add(student_detail);
		
		JMenu help = new JMenu("Help");
		panel.add(help);
		menubar.add(help);
		
		JMenuItem  read_me = new JMenuItem("Read Me");
		read_me.addActionListener(this);
		help.add(read_me);
		JMenuItem  about_us = new JMenuItem("About Us");
		about_us.addActionListener(this);
		help.add(about_us);
	
		JMenu exit = new JMenu("Exit");
		panel.add(exit);
		menubar.add(exit);
		
		JMenuItem  exitMI = new JMenuItem("Exit");
		exitMI.addActionListener(this);
		exit.add(exitMI);
		
		
		// Add Buttons
		
		add_book = new JButton("Add Book");
		add_book.addActionListener(this);
		add_book.setBackground(new Color(150,200,130));
		add_book.setForeground(new Color(0,40,0));
		add_book.setBounds(60, 140, 110, 25);
		panel.add(add_book);
		
		add_student = new JButton("Add Student");
		add_student.addActionListener(this);
		add_student.setBackground(new Color(150,200,130));
		add_student.setForeground(new Color(0,40,0));
		add_student.setBounds(205, 140, 110, 25);
		panel.add(add_student);
		
		statistics = new JButton("Statistics");
		statistics.addActionListener(this);
		statistics.setBackground(new Color(150,200,130));
		statistics.setForeground(new Color(0,40,0));
		statistics.setBounds(350, 140, 110, 25);
		panel.add(statistics);
		
		issue_book = new JButton("Issue Book");
		issue_book.addActionListener(this);
		issue_book.setBackground(new Color(150,200,130));
		issue_book.setForeground(new Color(0,40,0));
		issue_book.setBounds(60, 290, 110, 25);
		panel.add(issue_book);
		
		return_book = new JButton("Return Book");
		return_book.addActionListener(this);
		return_book.setBackground(new Color(150,200,130));
		return_book.setForeground(new Color(0,40,0));
		return_book.setBounds(205, 290, 110, 25);
		panel.add(return_book);
		
		about = new JButton("About");
		about.addActionListener(this);
		about.setBackground(new Color(150,200,130));
		about.setForeground(new Color(0,40,0));
		about.setBounds(350, 290, 110, 25);
		panel.add(about);
	
		// Add Images
		
		JLabel l1 = new JLabel("");	
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/com/Icons/addbook1.png"));
		Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		l1 = new JLabel(i3);
		l1.setBounds(65, 40, 100, 110);
		panel.add(l1);
		
		JLabel l2 = new JLabel("");	
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("library/management/com/Icons/addstudent1.png"));
		Image i5 = i4.getImage().getScaledInstance(100,110,Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		l2 = new JLabel(i6);
		l2.setBounds(215, 40, 100, 110);
		panel.add(l2);
		
		JLabel l3 = new JLabel("");	
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("library/management/com/Icons/statistics.png"));
		Image i8 = i7.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		l3 = new JLabel(i9);
		l3.setBounds(350, 40, 100, 110);
		panel.add(l3);
		
		JLabel l4 = new JLabel("");	
		ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("library/management/com/Icons/addbook.png"));
		Image i11 = i10.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT);
		ImageIcon i12 = new ImageIcon(i11);
		l4 = new JLabel(i12);
		l4.setBounds(70, 195, 100, 100);
		panel.add(l4);
		
		JLabel l5 = new JLabel("");	
		ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("library/management/com/Icons/book.png"));
		Image i14 = i13.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon i15 = new ImageIcon(i14);
		l5 = new JLabel(i15);
		l5.setBounds(210, 190, 100, 100);
		panel.add(l5);
		
		JLabel l6 = new JLabel("");	
		ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("library/management/com/Icons/about.png"));
		Image i17 = i16.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT);
		ImageIcon i18 = new ImageIcon(i17);
		l6 = new JLabel(i18);
		l6.setBounds(350, 190, 100, 110);
		panel.add(l6);
		
		ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("library/management/com/Icons/logout.png"));
		Image i20 = i19.getImage().getScaledInstance(22,22,Image.SCALE_DEFAULT);
		ImageIcon i21 = new ImageIcon(i20);
	
		logout = new JButton("Logout"); 
		logout.setBackground(new Color(255,150,150));
		logout.setForeground(new Color(90,0,0));
		logout.setBounds(400, 360, 110, 30);
		logout.addActionListener(this);
		logout.setIcon(i21);
		panel.add(logout);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String msg = ae.getActionCommand();
		if(msg.equals("Student Details"))
		{
			setVisible(false);
			new Student_Details().setVisible(true);
		}
		else if(msg.equals("Book Details"))
		{
			setVisible(false);
			new Book_Details().setVisible(true);
		}
		else if(msg.equals("Read Me"))
		{
			setVisible(false);
			new Read_Me().setVisible(true);
		}
		else if(msg.equals("About Us"))
		{
			setVisible(false);
			new About_Us().setVisible(true);
		}
		else if(msg.equals("Exit"))
		{
			System.exit(0);
		}
		
		if(ae.getSource()==add_book)
		{
			setVisible(false);
			new Add_Book().setVisible(true);
		}
		if(ae.getSource()==add_student)
		{
			setVisible(false);
			new Add_Student().setVisible(true);
		}
		if(ae.getSource()==statistics)
		{
			setVisible(false);
			new Statistics().setVisible(true);
		}
		if(ae.getSource()==issue_book)
		{
			setVisible(false);
			new Issue_Book().setVisible(true);
		}
		if(ae.getSource()==return_book)
		{
			setVisible(false);
			new Return_Book().setVisible(true);
		}
		if(ae.getSource()==about)
		{
			setVisible(false);
			new About_Us().setVisible(true);
		}
		if(ae.getSource()==logout)
		{
			setVisible(false);
			new Login_user().setVisible(true);
		}
		
	}
}
