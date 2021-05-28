package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable
{
	private JPanel panel;
	private JProgressBar pb;
	//Connection conn;
	int s;
	Thread th;
	
	public static void main(String[] args) 
	{
		new Loading().setVisible(true);
	}

	public void setUploading()
	{
		setVisible(false);
		th.start();
	}
	
	public void run()
	{
		try 
		{
			for(int i =0 ; i<200 ; i++)
			{
				s = s + 1;
				int m = pb.getMaximum();
				int v = pb.getValue();
				if(v < m)
				{
					pb.setValue(pb.getValue() + 1);
				}
				else
				{
					i=201;
					setVisible(false);
					new Home().setVisible(true);
				}
				Thread.sleep(20);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public Loading()
	{
		//super("Loading");
		th = new Thread(this);
		
		setBounds(400,150,550,450);
		setTitle("Loading...");
		setResizable(false);
		panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		JLabel lib_manage = new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lib_manage.setForeground(new Color(255,80,0));
		lib_manage.setFont(new Font("",Font.BOLD,25));
		lib_manage.setBounds(60, 50, 500, 50);
		panel.add(lib_manage);
		
		pb = new JProgressBar();
		pb.setStringPainted(true);
		pb.setBounds(140, 130, 250, 30);
		panel.add(pb);
		
		JLabel please_wait = new JLabel("Please Wait . . . . . ");
		please_wait.setForeground(new Color(0,80,100));
		please_wait.setFont(new Font("",Font.BOLD,15));
		please_wait.setBounds(220, 180, 150, 50);
		panel.add(please_wait);
		
		/*JPanel panel1 = new JPanel();
		panel1.setBackground(Color.YELLOW);
		panel1.setBounds(0, 0, 490, 390);
		panel.add(panel1);*/
		
		setUploading();
	}
}
