package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*; 

public class Login_user extends JFrame implements ActionListener
{
	private JPanel panel ;
	private JTextField tf;
	private JPasswordField pf;
	private JButton login,signup,forget;
	
	public static void main(String args[])
	{
		new Login_user().setVisible(true);
	}
	
	public Login_user()
	{
		//setBackground(new Color(169,169,169));
		setBounds(400,150,550,450);
		setResizable(false);
		setTitle("Library Management System");
		setLayout(null);		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel user = new JLabel("Username :");
		user.setForeground(new Color(0,0,100));
		user.setBounds(140, 90, 70, 30);
		panel.add(user);
		
		JLabel pass = new JLabel("Password :");
		pass.setForeground(new Color(0,0,100));
		pass.setBounds(140, 130, 70, 30);
		panel.add(pass);
		
		tf = new JTextField();
		tf.setBackground(new Color(200,255,255));
		tf.setBounds(230, 97, 150, 20);
		panel.add(tf);
		
		pf = new JPasswordField();
		pf.setBackground(new Color(200,255,255));
		pf.setBounds(230, 137, 150, 20);
		panel.add(pf);
		
		login = new JButton("Login");
		login.addActionListener(this);
		login.setBackground(new Color(150,200,130));
		login.setForeground(new Color(0,40,0));
		login.setBounds(170, 190, 80, 30);
		panel.add(login);
		
		signup = new JButton("Signup");
		signup.addActionListener(this);
		signup.setBackground(new Color(150,200,130));
		signup.setForeground(new Color(0,40,0));
		signup.setBounds(280, 190, 80, 30);
		panel.add(signup);
		
		JLabel trouble = new JLabel("Trouble in Login ?");
		trouble.setForeground(new Color(255,0,0));
		trouble.setFont(new Font("Tahoma",Font.BOLD,13));
		trouble.setBounds(210, 240, 150, 30);
		panel.add(trouble);
		
		forget = new JButton("Forget Password...");
		forget.addActionListener(this);
		forget.setBackground(new Color(255,150,150));
		forget.setForeground(new Color(90,0,0));
		forget.setBounds(170, 285, 190, 30);
		panel.add(forget);
		
	}	
		public void actionPerformed(ActionEvent ae)
		{
			try 
			{
				if(ae.getSource()==login)
				{
					boolean status = false;
					Conn con = new Conn();
					String sql = "Select * from account where username=? and password=?";
					PreparedStatement ps = con.c.prepareStatement(sql);
						
					ps.setString(1, tf.getText());
					ps.setString(2, pf.getText());
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						this.setVisible(false);
						new Loading().setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"Invalid Details");//"Message",JOptionPane.ERROR_MESSAGE
				}
				if(ae.getSource()==signup)
				{
					this.setVisible(false);
					new Signup().setVisible(true);
				}
				if(ae.getSource()==forget)
				{
					this.setVisible(false);
					new Forget().setVisible(true);
				}
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		} 
}


