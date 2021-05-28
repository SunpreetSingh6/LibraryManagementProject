package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.util.*;

public class Student_Details extends JFrame implements ActionListener 
{
	JPanel panel;
	JTable table;
	JTextField search;
	JButton search1,delete,back;
	public static void main(String[] args) 
	{
		new Student_Details().setVisible(true);
	}
	
	public void Book()
	{
		try
		{
			Conn con = new Conn();
			String sql = "select * from student";
			PreparedStatement st  = con.c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));  // Converting ResultSet to TableModel
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Student_Details()
	{
		setBounds(400,150,550,450);
		setResizable(false);
		setTitle("Student Details");
		panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(30, 100, 480, 230);
		panel.add(sp);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) 
			{
				int row = table.getSelectedRow();
				search.setText(table.getModel().getValueAt(row,1).toString());
			}
		});
		table.setForeground(Color.BLACK);
		sp.setViewportView(table);
		
		search1 = new JButton("Search");
		search1.addActionListener(this);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/com/Icons/search.png"));
		Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		search1.setIcon(i3);
		search1.setBackground(new Color(150,200,130));
		search1.setForeground(new Color(0,40,0));
		search1.setBounds(290, 50, 100, 30);
		panel.add(search1);
		
		delete = new JButton("Delete");
		delete.addActionListener(this);
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("library/management/com/Icons/delete.png"));
		Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		delete.setIcon(i6);
		delete.setBackground(new Color(255,150,150));
		delete.setForeground(new Color(90,0,0));
		delete.setBounds(410, 50, 100, 30);
		panel.add(delete);
		
		back = new JButton("Back");
		back.addActionListener(this);
		back.setBackground(new Color(255,150,150));
		back.setForeground(new Color(90,0,0));
		back.setBounds(410, 350, 100, 30);
		panel.add(back);
		
		search = new JTextField();
		search.setBackground(new Color(200,255,255));
		search.setBounds(30, 50, 230, 30);
		//search.setColumns(10);
		panel.add(search);
		
		Book();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try 
		{	
			Conn con = new Conn();
			if(ae.getSource()==search1)
			{
				String sql = "select * from student where name like ?";
				PreparedStatement ps = con.c.prepareStatement(sql);
				ps.setString(1, "%" + search.getText() + "%");
				ResultSet rs  = ps.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			if(ae.getSource()==delete)
			{
				String sql = "delete from student where name='" + search.getText() + "'";
				PreparedStatement ps = con.c.prepareStatement(sql);
				int response = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Confirm", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if(response == JOptionPane.YES_OPTION)
				{
					int i = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted!!!");
					setVisible(false);
					new Student_Details().setVisible(true);
				}
			}
			if(ae.getSource()==back)
			{
				setVisible(false);
				new Home().setVisible(true);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
