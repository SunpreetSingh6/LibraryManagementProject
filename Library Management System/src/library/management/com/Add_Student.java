package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Add_Student extends JFrame implements ActionListener
{
	JPanel panel;
	private JTextField name_tf,fathername_tf,studentid_tf;
	private JButton add_student,back;
	private JComboBox course_cb,branch_cb,year_cb,semester_cb;

	public static void main(String[] args) 
	{
		new Add_Student().setVisible(true);
	}
	
	public void random()
	{
		Random r = new Random();
		studentid_tf.setText("" + r.nextInt(1000 + 1));
	}
	
	public Add_Student()
	{
		setBounds(400,150,550,450);
		setResizable(false);
		setTitle("Add Book");
		panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		JLabel studentid = new JLabel("Student Id :");
		studentid.setForeground(new Color(0,0,100));
		studentid.setBounds(120, 30, 70, 30);
		panel.add(studentid);
		
		studentid_tf = new JTextField();
		studentid_tf.setBackground(new Color(200,255,255));
		studentid_tf.setBounds(220, 35, 150, 20);
		studentid_tf.setEditable(false);
		panel.add(studentid_tf);
		
		JLabel name = new JLabel("Name :");
		name.setForeground(new Color(0,0,100));
		name.setBounds(120, 70, 70, 30);
		panel.add(name);
		
		name_tf = new JTextField();
		name_tf.setBackground(new Color(200,255,255));
		name_tf.setBounds(220, 75, 150, 20);
		panel.add(name_tf);
		
		JLabel fathername = new JLabel("Father's Name :");
		fathername.setForeground(new Color(0,0,100));
		fathername.setBounds(120, 110, 100, 30);
		panel.add(fathername);
		
		fathername_tf = new JTextField();
		fathername_tf.setBackground(new Color(200,255,255));
		fathername_tf.setBounds(220, 115, 150, 20);
		panel.add(fathername_tf);
		
		JLabel course = new JLabel("Course :");
		course.setForeground(new Color(0,0,100));
		course.setBounds(120, 150, 100, 30);
		panel.add(course);
		
		String options1[] = {"BBA","MBA","BA","MA","B.TECH","M.TECH","B.Sc","M.Sc"};
		course_cb = new JComboBox(options1);
		course_cb.setBounds(220, 155, 150, 20);
		panel.add(course_cb);
		
		JLabel branch = new JLabel("Branch :");
		branch.setForeground(new Color(0,0,100));
		branch.setBounds(120, 190, 100, 30);
		panel.add(branch);
		
		String options3[] = {"CS", "IT", "Civil", "EEE", "Automobile","Mechanical", "Other"};
		branch_cb = new JComboBox(options3);
		branch_cb.setBounds(220, 195, 150, 20);
		panel.add(branch_cb);
		
		JLabel year = new JLabel("Year :");
		year.setForeground(new Color(0,0,100));
		year.setBounds(120, 230, 100, 30);
		panel.add(year);
		
		String options4[] = { "First", "Second", "Third", "Four"};
		year_cb = new JComboBox(options4);
		year_cb.setBounds(220, 235, 150, 20);
		panel.add(year_cb);
		
		JLabel semester = new JLabel("Semester :");
		semester.setForeground(new Color(0,0,100));
		semester.setBounds(120, 270, 100, 30);
		panel.add(semester);
		
		String options2[] = { "1","2","3","4","5","6","7","8"};
		semester_cb = new JComboBox(options2);
		semester_cb.setBounds(220, 275, 150, 20);
		panel.add(semester_cb);
		
		add_student = new JButton("Add Student"); 
		add_student.setBackground(new Color(150,200,130));
		add_student.setForeground(new Color(0,40,0));
		add_student.setBounds(120, 320, 125, 30);
		add_student.addActionListener(this);
		panel.add(add_student);
		
		back = new JButton("Back"); 
		back.setBackground(new Color(255,150,150));
		back.setForeground(new Color(90,0,0));
		back.setBounds(270, 320, 125, 30);
		back.addActionListener(this);
		panel.add(back);
		
		random();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add_student)
		{
			try
			{
				Conn con = new Conn();
				String sql = "insert into student(Student_id,name,father,course,branch,year,semester) values(?,?,?,?,?,?,?)";
				PreparedStatement ps = con.c.prepareStatement(sql);
				ps.setString(1, studentid_tf.getText());
				ps.setString(2, name_tf.getText());
				ps.setString(3, fathername_tf.getText());
				ps.setString(4, (String)course_cb.getSelectedItem());
				ps.setString(5, (String)branch_cb.getSelectedItem());
				ps.setString(6, (String)year_cb.getSelectedItem());
				ps.setString(7, (String)semester_cb.getSelectedItem());
				
				int i = ps.executeUpdate();
				if(i>0)
				{
					JOptionPane.showMessageDialog(null, "Successfully Created");
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Error");
				}
				random();
				name_tf.setText("");
				fathername_tf.setText("");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(ae.getSource()==back)
		{
			setVisible(false);
			new Home().setVisible(true);
		}
	}
	
}
