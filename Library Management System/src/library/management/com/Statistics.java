package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Statistics extends JFrame implements ActionListener
{
	JPanel panel;
	JTable t1,t2;
	JButton back;
	public static void main(String[] args) 
	{
		new Statistics().setVisible(true);
	}
	
	public void issuebook()
	{
		try 
		{
			Conn con = new Conn();
			String sql = "Select * from issuebook"; 
			PreparedStatement ps = con.c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			t1.setModel(DbUtils.resultSetToTableModel(rs));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void returnbook()
	{
		try 
		{
			Conn con = new Conn();
			String sql = "Select * from returnbook"; 
			PreparedStatement ps = con.c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			t2.setModel(DbUtils.resultSetToTableModel(rs));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public Statistics()
	{
		setBounds(400,150,550,450);
		setResizable(false);
		setTitle("Statistics");
		panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
	
		JScrollPane sp1 = new JScrollPane();
		sp1.setBounds(40, 30, 440, 140);
		panel.add(sp1);
		
		t1 = new JTable();
		t1.setForeground(Color.BLACK);
		sp1.setViewportView(t1);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Issue Book",
					TitledBorder.LEFT, TitledBorder.TOP, null, new Color(190,0,0)));
		panel1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel1.setBounds(30, 10, 460, 170);
	    panel1.setBackground(Color.LIGHT_GRAY);
		panel.add(panel1);
		
		
		JScrollPane sp2 = new JScrollPane();
		sp2.setBounds(40, 200, 440, 140);
		panel.add(sp2);
		
		t2 = new JTable();
		t2.setForeground(Color.BLACK);
		sp2.setViewportView(t2);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Return Book",
					TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(190,0,0)));
		panel2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel2.setBounds(30, 180, 460, 170);
	    panel2.setBackground(Color.LIGHT_GRAY);
		panel.add(panel2);
		
		back = new JButton("Back");
		back.addActionListener(this);
		back.setBackground(new Color(255,150,150));
		back.setForeground(new Color(90,0,0));
		back.setBounds(410, 360, 100, 30);
		panel.add(back);
		
		issuebook();
		returnbook();
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
