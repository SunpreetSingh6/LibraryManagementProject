package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;

public class Issue_Book extends JFrame implements ActionListener
{
	private JPanel panel;
	private JTextField book_id_tf,bname_tf,publisher_tf,price_tf,pages_tf,edition_tf;
	private JTextField sname_tf,fathername_tf,student_id_tf,course_tf,branch_tf,year_tf,semester_tf;
	private JButton issue_book,back;
	private JButton b_find,b_search,s_find,s_search;
	JDateChooser date;
	
	public static void main(String args[])
	{
		new Issue_Book().setVisible(true);
	}

	public Issue_Book()
	{
		setBounds(400,150,550,450);
		setResizable(false);
		setTitle("Issue Book");
		panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		JLabel book_id = new JLabel("Book Id :");
		book_id.setForeground(new Color(0,0,100));
		book_id.setBounds(20, 30, 70, 30);
		panel.add(book_id);
		
		book_id_tf = new JTextField();
		book_id_tf.setBackground(new Color(200,255,255));
		book_id_tf.setBounds(100, 35, 120, 20);
		panel.add(book_id_tf);
		
		JLabel bname = new JLabel("Name :");
		bname.setForeground(new Color(0,0,100));
		bname.setBounds(20, 110, 70, 30);
		panel.add(bname);
		
		bname_tf = new JTextField();
		bname_tf.setBackground(new Color(200,255,255));
		bname_tf.setBounds(100, 115, 120, 20);
		bname_tf.setEditable(false);
		panel.add(bname_tf);
		
		JLabel publisher = new JLabel("Publisher :");
		publisher.setForeground(new Color(0,0,100));
		publisher.setBounds(20, 150, 70, 30);
		panel.add(publisher);
		
		publisher_tf = new JTextField();
		publisher_tf.setBackground(new Color(200,255,255));
		publisher_tf.setBounds(100, 155, 120, 20);
		publisher_tf.setEditable(false);
		panel.add(publisher_tf);
		
		JLabel edition = new JLabel("Edition :");
		edition.setForeground(new Color(0,0,100));
		edition.setBounds(20, 190, 100, 30);
		panel.add(edition);
		
		edition_tf = new JTextField();
		edition_tf.setBackground(new Color(200,255,255));
		edition_tf.setBounds(100, 195, 120, 20);
		edition_tf.setEditable(false);
		panel.add(edition_tf);
		
		JLabel price = new JLabel("Price :");
		price.setForeground(new Color(0,0,100));
		price.setBounds(20, 230, 70, 30);
		panel.add(price);
		
		price_tf = new JTextField();
		price_tf .setBackground(new Color(200,255,255));
		price_tf .setBounds(100, 235, 120, 20);
		price_tf.setEditable(false);
		panel.add(price_tf );
		
		JLabel pages = new JLabel("Pages :");
		pages.setForeground(new Color(0,0,100));
		pages.setBounds(20, 270, 70, 30);
		panel.add(pages);
		
		pages_tf = new JTextField();
		pages_tf.setBackground(new Color(200,255,255));
		pages_tf.setBounds(100, 275, 120, 20);
		pages_tf.setEditable(false);
		panel.add(pages_tf);
		
		b_find = new JButton("Find Book"); 
		b_find.setBackground(new Color(150,200,130));
		b_find.setForeground(new Color(0,40,0));
		b_find.setBounds(25, 70, 90, 25);
		b_find.addActionListener(this);
		panel.add(b_find);
		
		b_search = new JButton("Search"); 
		b_search.setBackground(new Color(150,200,130));
		b_search.setForeground(new Color(0,40,0));
		b_search.setBounds(120, 70, 90, 25);
		b_search.addActionListener(this);
		panel.add(b_search);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Book Details",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(190,0,0)));
		panel1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel1.setBounds(10,10,230,300);
	    panel1.setBackground(Color.LIGHT_GRAY);
		panel.add(panel1);
		
		// Student Section
		
		
		
		JLabel studentid = new JLabel("Student Id :");
		studentid.setForeground(new Color(0,0,100));
		studentid.setBounds(270, 30, 70, 30);
		panel.add(studentid);
		
		student_id_tf = new JTextField();
		student_id_tf.setBackground(new Color(200,255,255));
		student_id_tf.setBounds(380, 35, 120, 20);
		panel.add(student_id_tf);
		
		JLabel sname = new JLabel("Name :");
		sname.setForeground(new Color(0,0,100));
		sname.setBounds(270, 110, 70, 30);
		panel.add(sname);
		
		sname_tf = new JTextField();
		sname_tf.setBackground(new Color(200,255,255));
		sname_tf.setBounds(380, 115, 120, 20);
		sname_tf.setEditable(false);
		panel.add(sname_tf);
		
		JLabel fathername = new JLabel("Father's Name :");
		fathername.setForeground(new Color(0,0,100));
		fathername.setBounds(270, 150, 100, 30);
		panel.add(fathername);
		
		fathername_tf = new JTextField();
		fathername_tf.setBackground(new Color(200,255,255));
		fathername_tf.setBounds(380, 155, 120, 20);
		fathername_tf.setEditable(false);
		panel.add(fathername_tf);
		
		JLabel course = new JLabel("Course :");
		course.setForeground(new Color(0,0,100));
		course.setBounds(270, 190, 100, 30);
		panel.add(course);
		
		course_tf = new JTextField();
		course_tf.setBackground(new Color(200,255,255));
		course_tf.setBounds(380, 195, 120, 20);
		course_tf.setEditable(false);
		panel.add(course_tf);
		
		JLabel branch = new JLabel("Branch :");
		branch.setForeground(new Color(0,0,100));
		branch.setBounds(270, 230, 100, 30);
		panel.add(branch);
		
		branch_tf = new JTextField();
		branch_tf.setBackground(new Color(200,255,255));
		branch_tf.setBounds(380, 235, 120, 20);
		branch_tf.setEditable(false);
		panel.add(branch_tf);
		
		JLabel year = new JLabel("Year :");
		year.setForeground(new Color(0,0,100));
		year.setBounds(270, 270, 100, 30);
		panel.add(year);
		
		year_tf = new JTextField();
		year_tf.setBackground(new Color(200,255,255));
		year_tf.setBounds(380, 275, 120, 20);
		year_tf.setEditable(false);
		panel.add(year_tf);
		
		JLabel semester = new JLabel("Semester :");
		semester.setForeground(new Color(0,0,100));
		semester.setBounds(270, 310, 100, 30);
		panel.add(semester);
		
		semester_tf = new JTextField();
		semester_tf.setBackground(new Color(200,255,255));
		semester_tf.setBounds(380, 315, 120, 20);
		semester_tf.setEditable(false);
		panel.add(semester_tf);
		
		s_find = new JButton("Find Student"); 
		s_find.setBackground(new Color(150,200,130));
		s_find.setForeground(new Color(0,40,0));
		s_find.setBounds(290, 70, 105, 25);
		s_find.addActionListener(this);
		panel.add(s_find);
		
		s_search = new JButton("Search"); 
		s_search.setBackground(new Color(150,200,130));
		s_search.setForeground(new Color(0,40,0));
		s_search.setBounds(400, 70, 90, 25);
		s_search.addActionListener(this);
		panel.add(s_search);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Student Details",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(190,0,0)));
		panel2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel2.setBounds(260, 10, 260, 340);//(10,15,240,300)
	    panel2.setBackground(Color.LIGHT_GRAY);
		panel.add(panel2);
		
		
		// Buttons 
		
		issue_book = new JButton("Issue Book"); 
		issue_book.setBackground(new Color(150,200,130));
		issue_book.setForeground(new Color(0,40,0));
		issue_book.setBounds(20, 370, 100, 30);
		issue_book.addActionListener(this);
		panel.add(issue_book);
		
		back = new JButton("Back"); 
		back.setBackground(new Color(255,150,150));
		back.setForeground(new Color(90,0,0));
		back.setBounds(150, 370, 100, 30);
		back.addActionListener(this);
		panel.add(back);
		
		// Date Chooser
		
		JLabel label = new JLabel("Date of Issue :-");
		label.setBounds(10, 330, 85, 20);
		label.setForeground(Color.BLACK);
		panel.add(label);
		
		date = new JDateChooser();
		date.setBounds(100, 328, 140, 25);
		panel.add(date);
		
	}

	public void actionPerformed(ActionEvent ae)
	{
		try 
		{
			Conn con = new Conn();
			if(ae.getSource()==issue_book)
			{
				String sql = "insert into issuebook(book_id,student_id,bname,sname,course,branch,dateofIssue) values(?,?,?,?,?,?,?)";
				PreparedStatement ps = con.c.prepareStatement(sql);
				ps.setString(1, book_id_tf.getText());
				ps.setString(2, student_id_tf.getText());
				ps.setString(3, bname_tf.getText());
				ps.setString(4, sname_tf.getText());
				ps.setString(5, course_tf.getText());
				ps.setString(6, branch_tf.getText());
				ps.setString(7, ((JTextField) date.getDateEditor().getUiComponent()).getText());
				int i = ps.executeUpdate();
				if(i>0)
				{
					JOptionPane.showMessageDialog(null, "Successfully Issued");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
				}
				book_id_tf.setText("");
				bname_tf.setText("");
				publisher_tf.setText("");
				edition_tf.setText("");
				price_tf.setText("");
				pages_tf.setText("");
				student_id_tf.setText("");
				sname_tf.setText("");
				fathername_tf.setText("");
				course_tf.setText("");
				branch_tf.setText("");
				year_tf.setText("");
				semester_tf.setText("");
			}
			if(ae.getSource()==b_search)
			{
				String sql = "select * from book where book_id = ?";
				PreparedStatement ps = con.c.prepareStatement(sql);
				ps.setString(1, book_id_tf.getText());
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					bname_tf.setText(rs.getString("name"));
					publisher_tf.setText(rs.getString("publisher"));
					edition_tf.setText(rs.getString("edition"));
					price_tf.setText(rs.getString("price"));
					pages_tf.setText(rs.getString("pages"));
				}
			}
			if(ae.getSource()==s_search)
			{
				String sql = "select * from student where student_id = ?";
				PreparedStatement ps = con.c.prepareStatement(sql);
				ps.setString(1, student_id_tf.getText());
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					sname_tf.setText(rs.getString("name"));
					fathername_tf.setText(rs.getString("father"));
					course_tf.setText(rs.getString("course"));
					branch_tf.setText(rs.getString("branch"));
					year_tf.setText(rs.getString("year"));
					semester_tf.setText(rs.getString("semester"));
				}
			}
			if(ae.getSource()==s_find)
			{
				new Student_Details().setVisible(true);
			}
			if(ae.getSource()==b_find)
			{
				new Book_Details().setVisible(true);
			}
			if(ae.getSource()==back)
			{
				setVisible(false);
				new Home().setVisible(true);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

