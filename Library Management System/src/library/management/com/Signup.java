package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener
{
	private JPanel panel;
	private JTextField username_tf,name_tf,answer_tf,password_tf;
	private JButton create_acc,back;
	private JComboBox comboBox;
	
	public static void main(String[] args) 
	{
		new Signup().setVisible(true);
	}
	
	public Signup()
	{
		setBounds(400,150,550,450);
		setResizable(false);
		setTitle("Signup");
		panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		JLabel username = new JLabel("Username :");
		username.setForeground(new Color(0,0,100));
		username.setBounds(120, 70, 70, 30);
		panel.add(username);
		
		username_tf = new JTextField();
		username_tf.setBackground(new Color(200,255,255));
		username_tf.setBounds(230, 75, 150, 20);
		panel.add(username_tf);
		
		JLabel name = new JLabel("Name :");
		name.setForeground(new Color(0,0,100));
		name.setBounds(120, 110, 70, 30);
		panel.add(name);
		
		name_tf = new JTextField();
		name_tf.setBackground(new Color(200,255,255));
		name_tf.setBounds(230, 115, 150, 20);
		panel.add(name_tf);
		
		JLabel password = new JLabel("Password :");
		password.setForeground(new Color(0,0,100));
		password.setBounds(120, 150, 70, 30);
		panel.add(password);
		
		password_tf = new JTextField();
		password_tf.setBackground(new Color(200,255,255));
		password_tf.setBounds(230, 155, 150, 20);
		panel.add(password_tf);
		
		JLabel security_ques = new JLabel("Security_Ques :");
		security_ques.setForeground(new Color(0,0,100));
		security_ques.setBounds(120, 190, 100, 30);
		panel.add(security_ques);
		
		String options[] = { "Your Nick Name ?" , "Your Pet Name ?" , "Your Lucky Number ?"  , "Your Favourite Food ?" };
		comboBox = new JComboBox(options);
		comboBox.setBounds(230, 195, 150, 20);
		panel.add(comboBox);
		
		JLabel answer = new JLabel("Answer :");
		answer.setForeground(new Color(0,0,100));
		answer.setBounds(120, 230, 70, 30);
		panel.add(answer);
		
		answer_tf = new JTextField();
		answer_tf.setBackground(new Color(200,255,255));
		answer_tf.setBounds(230, 235, 150, 20);
		panel.add(answer_tf);
		
		create_acc = new JButton("Create Account"); 
		create_acc.setBackground(new Color(150,200,130));
		create_acc.setForeground(new Color(0,40,0));
		create_acc.setBounds(110, 290, 125, 30);
		create_acc.addActionListener(this);
		panel.add(create_acc);
		
		back = new JButton("Back"); 
		back.setBackground(new Color(255,150,150));
		back.setForeground(new Color(90,0,0));
		back.setBounds(260, 290, 125, 30);
		back.addActionListener(this);
		panel.add(back);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		try 
		{
			
			if(ae.getSource()==create_acc)
			{
				Conn con = new Conn();
				String sql = "insert into account(username, name, password, sec_ques, sec_ans) values(?, ?, ?, ?, ?)";
				PreparedStatement ps =  con.c.prepareStatement(sql);
				
				ps.setString(1, username_tf.getText());
				ps.setString(2, name_tf.getText());
				ps.setString(3, password_tf.getText());
				ps.setString(4, (String) comboBox.getSelectedItem());
				ps.setString(5, answer_tf.getText());
				
				int i = ps.executeUpdate();
				if(i>0)
				{	
					JOptionPane.showMessageDialog(null,"Successfully Created"); 
				}
				username_tf.setText("");
				name_tf.setText("");
				password_tf.setText("");
				answer_tf.setText("");
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
