package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class Forget extends JFrame implements ActionListener
{
	private JPanel panel;
	private JTextField username_tf,name_tf,password_tf,answer_tf,sec_ques_tf;
	private JButton search,retrieve,back;
	
	public static void main(String[] args) 
	{
		new Forget().setVisible(true);
	}

	public Forget()
	{
		setBounds(400,150,550,450);
		setResizable(false);
		setTitle("Signup");
		panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		JLabel msg = new JLabel("Enter  'Username'  and  'Answer'  to  get  'Password' .");
		msg.setForeground(new Color(240,0,0));
		msg.setBounds(110, 30, 310, 30);
		panel.add(msg);
		
		JLabel username = new JLabel("Username :");
		username.setForeground(new Color(0,0,100));
		username.setBounds(80, 80, 70, 30);
		panel.add(username);
		
		username_tf = new JTextField();
		username_tf.setBackground(new Color(200,255,255));
		username_tf.setBounds(190, 85, 150, 20);
		panel.add(username_tf);
		
		JLabel name = new JLabel("Name :");
		name.setForeground(new Color(0,0,100));
		name.setBounds(80, 120, 70, 30);
		panel.add(name);
		
		name_tf = new JTextField();
		name_tf.setBackground(new Color(200,255,255));
		name_tf.setBounds(190, 125, 150, 20);
		name_tf.setEditable(false);
		panel.add(name_tf);
		
		JLabel password = new JLabel("Password :");
		password.setForeground(new Color(0,0,100));
		password.setBounds(80, 240, 70, 30);
		panel.add(password);
		
		password_tf = new JTextField();
		password_tf.setBackground(new Color(200,255,255));
		password_tf.setBounds(190, 245, 150, 20);
		password_tf.setEditable(false);
		panel.add(password_tf);
		
		JLabel security_ques = new JLabel("Security_Ques :");
		security_ques.setForeground(new Color(0,0,100));
		security_ques.setBounds(80, 160, 100, 30);
		panel.add(security_ques);
		
		sec_ques_tf = new JTextField();
		sec_ques_tf.setBackground(new Color(200,255,255));
		sec_ques_tf.setBounds(190, 165, 150, 20);
		sec_ques_tf.setEditable(false);
		panel.add(sec_ques_tf);
		
		JLabel answer = new JLabel("Answer :");
		answer.setForeground(new Color(0,0,100));
		answer.setBounds(80, 200, 70, 30);
		panel.add(answer);
		
		answer_tf = new JTextField();
		answer_tf.setBackground(new Color(200,255,255));
		answer_tf.setBounds(190, 205, 150, 20);
		panel.add(answer_tf);
		
		search = new JButton("Search"); 
		search.setBackground(new Color(150,200,130));
		search.setForeground(new Color(0,40,0));
		search.setBounds(370, 85, 90, 20);
		search.addActionListener(this);
		panel.add(search);
		
		retrieve = new JButton("Retrieve"); 
		retrieve.setBackground(new Color(150,200,130));
		retrieve.setForeground(new Color(0,40,0));
		retrieve.setBounds(370, 205, 90, 20);
		retrieve.addActionListener(this);
		panel.add(retrieve);
		
		back = new JButton("Back"); 
		back.setBackground(new Color(255,150,150));
		back.setForeground(new Color(90,0,0));
		back.setBounds(230, 300, 70, 30);
		back.addActionListener(this);
		panel.add(back);
		
	}	
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			
			if(ae.getSource()==search)
			{
				Conn con = new Conn();
				String sql = "Select * from account where username = ?";
				PreparedStatement ps = con.c.prepareStatement(sql);
					
				ps.setString(1, username_tf.getText());
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					name_tf.setText(rs.getString("name"));
					sec_ques_tf.setText(rs.getString("sec_ques"));
				}
			}
			if(ae.getSource()==retrieve)
			{
				Conn con = new Conn();
				String sql = "Select * from account where sec_ans=?";
				PreparedStatement ps = con.c.prepareStatement(sql);
					
				ps.setString(1, answer_tf.getText());
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					password_tf.setText(rs.getString("password"));
				}
			}
			if(ae.getSource()==back)
			{
				setVisible(false);
				new Login_user().setVisible(true);
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
}
