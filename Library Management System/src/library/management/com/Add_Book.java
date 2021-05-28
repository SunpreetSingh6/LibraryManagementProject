package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Add_Book extends JFrame implements ActionListener
{
	private JPanel panel;
	private JTextField book_id_tf,name_tf,publisher_tf,price_tf,pages_tf;
	private JButton add_book,back;
	private JComboBox edition_cb;
	
	public static void main(String[] args)
	{
		new Add_Book().setVisible(true);
	}
	
	public void random()
	{
		Random r = new Random();
		book_id_tf.setText("" + r.nextInt(1000 + 1));
	}
	
	public Add_Book()
	{
		setBounds(400,150,550,450);
		setResizable(false);
		setTitle("Add Book");
		panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		JLabel book_id = new JLabel("Book Id :");
		book_id.setForeground(new Color(0,0,100));
		book_id.setBounds(120, 30, 70, 30);
		panel.add(book_id);
		
		book_id_tf = new JTextField();
		book_id_tf.setBackground(new Color(200,255,255));
		book_id_tf.setBounds(220, 35, 150, 20);
		book_id_tf.setEditable(false);
		panel.add(book_id_tf);
		
		JLabel name = new JLabel("Name :");
		name.setForeground(new Color(0,0,100));
		name.setBounds(120, 70, 70, 30);
		panel.add(name);
		
		name_tf = new JTextField();
		name_tf.setBackground(new Color(200,255,255));
		name_tf.setBounds(220, 75, 150, 20);
		panel.add(name_tf);
		
		JLabel publisher = new JLabel("Publisher :");
		publisher.setForeground(new Color(0,0,100));
		publisher.setBounds(120, 110, 70, 30);
		panel.add(publisher);
		
		publisher_tf = new JTextField();
		publisher_tf.setBackground(new Color(200,255,255));
		publisher_tf.setBounds(220, 115, 150, 20);
		panel.add(publisher_tf);
		
		JLabel edition = new JLabel("Edition :");
		edition.setForeground(new Color(0,0,100));
		edition.setBounds(120, 150, 100, 30);
		panel.add(edition);
		
		String options[] = { "1","2","3","4","5","6","7","8","9","10","11","12"};
		edition_cb = new JComboBox(options);
		edition_cb.setBounds(220, 155, 150, 20);
		panel.add(edition_cb);
		
		JLabel price = new JLabel("Price :");
		price.setForeground(new Color(0,0,100));
		price.setBounds(120, 190, 70, 30);
		panel.add(price);
		
		price_tf = new JTextField();
		price_tf .setBackground(new Color(200,255,255));
		price_tf .setBounds(220, 195, 150, 20);
		panel.add(price_tf );
		
		JLabel pages = new JLabel("Pages :");
		pages.setForeground(new Color(0,0,100));
		pages.setBounds(120, 230, 70, 30);
		panel.add(pages);
		
		pages_tf = new JTextField();
		pages_tf.setBackground(new Color(200,255,255));
		pages_tf.setBounds(220, 235, 150, 20);
		panel.add(pages_tf);
		
		add_book = new JButton("Add Book"); 
		add_book.setBackground(new Color(150,200,130));
		add_book.setForeground(new Color(0,40,0));
		add_book.setBounds(120, 290, 125, 30);
		add_book.addActionListener(this);
		panel.add(add_book);
		
		back = new JButton("Back"); 
		back.setBackground(new Color(255,150,150));
		back.setForeground(new Color(90,0,0));
		back.setBounds(270, 290, 125, 30);
		back.addActionListener(this);
		panel.add(back);
		
		random();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add_book)
		{
			try 
			{
				Conn con = new Conn();
				String sql = "insert into book(book_id,name,publisher,edition,price,pages) values(?,?,?,?,?,?)";
				PreparedStatement ps = con.c.prepareStatement(sql);
				ps.setString(1, book_id_tf.getText());
				ps.setString(2, name_tf.getText());
				ps.setString(3, publisher_tf.getText());
				ps.setString(4, (String)edition_cb.getSelectedItem());
				ps.setString(5, price_tf.getText());
				ps.setString(6, pages_tf.getText());
				
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
				publisher_tf.setText("");
				price_tf.setText("");
				pages_tf.setText("");
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
