package library.management.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;

public class Return_Book extends JFrame implements ActionListener
{
	private JPanel panel;
	private JTextField book_id_tf,bname_tf;
	private JTextField sname_tf,student_id_tf,course_tf,branch_tf,issue_date;
	private JButton return_book,back;
	private JButton search;
	JDateChooser date;
	public static void main(String[] args) 
	{
		new Return_Book().setVisible(true);
	}

	public void delete() 
	{
        try 
        {
            Conn con = new Conn();
            String sql = "delete from issueBook where book_id=?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, book_id_tf.getText());
            int i = st.executeUpdate();
            if (i > 0)
                JOptionPane.showConfirmDialog(null, "Book Returned");
            else
                JOptionPane.showMessageDialog(null, "error in Deleting");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
	
	public Return_Book()
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
		book_id.setBounds(60, 80, 70, 30);
		panel.add(book_id);
		
		book_id_tf = new JTextField();
		book_id_tf.setBackground(new Color(200,255,255));
		book_id_tf.setBounds(120, 85, 70, 20);
		panel.add(book_id_tf);
		
		JLabel bname = new JLabel("Book :");
		bname.setForeground(new Color(0,0,100));
		bname.setBounds(60, 125, 70, 30);
		panel.add(bname);
		
		bname_tf = new JTextField();
		bname_tf.setBackground(new Color(200,255,255));
		bname_tf.setBounds(120, 130, 120, 20);
		bname_tf.setEditable(false);
		panel.add(bname_tf);
		
		// Student Section
		
		JLabel studentid = new JLabel("Student Id :");
		studentid.setForeground(new Color(0,0,100));
		studentid.setBounds(210, 80, 70, 30);
		panel.add(studentid);
		
		student_id_tf = new JTextField();
		student_id_tf.setBackground(new Color(200,255,255));
		student_id_tf.setBounds(285, 85, 70, 20);
		panel.add(student_id_tf);
		
		JLabel sname = new JLabel("Name :");
		sname.setForeground(new Color(0,0,100));
		sname.setBounds(270, 125, 70, 30);
		panel.add(sname);
		
		sname_tf = new JTextField();
		sname_tf.setBackground(new Color(200,255,255));
		sname_tf.setBounds(340, 130, 120, 20);
		sname_tf.setEditable(false);
		panel.add(sname_tf);
		
		JLabel course = new JLabel("Course :");
		course.setForeground(new Color(0,0,100));
		course.setBounds(60, 170, 100, 30);
		panel.add(course);
		
		course_tf = new JTextField();
		course_tf.setBackground(new Color(200,255,255));
		course_tf.setBounds(120, 175, 120, 20);
		course_tf.setEditable(false);
		panel.add(course_tf);
		
		JLabel branch = new JLabel("Branch :");
		branch.setForeground(new Color(0,0,100));
		branch.setBounds(270, 170, 100, 30);
		panel.add(branch);
		
		branch_tf = new JTextField();
		branch_tf.setBackground(new Color(200,255,255));
		branch_tf.setBounds(340, 175, 120, 20);
		branch_tf.setEditable(false);
		panel.add(branch_tf);
		
		// Buttons 
		
		search = new JButton("Search"); 
		search.setBackground(new Color(150,200,130));
		search.setForeground(new Color(0,40,0));
		search.setBounds(380, 85, 80, 20);
		search.addActionListener(this);
		panel.add(search);
		
		return_book = new JButton("Return Book"); 
		return_book.setBackground(new Color(150,200,130));
		return_book.setForeground(new Color(0,40,0));
		return_book.setBounds(150, 290, 110, 30);
		return_book.addActionListener(this);
		panel.add(return_book);
		
		back = new JButton("Back"); 
		back.setBackground(new Color(255,150,150));
		back.setForeground(new Color(90,0,0));
		back.setBounds(280, 290, 100, 30);
		back.addActionListener(this);
		panel.add(back);
		
		// Date Chooser
		
		JLabel label1 = new JLabel("Date of Issue :-");
		label1.setBounds(60, 220, 100, 20);
		label1.setForeground(new Color(0,0,100));
		panel.add(label1);
		
		issue_date = new JTextField();
		issue_date.setBounds(150, 220, 90, 20);
		issue_date.setBackground(new Color(200,255,255));
		issue_date.setEditable(false);
		panel.add(issue_date);
		
		JLabel label2 = new JLabel("Date of Return :-");
		label2.setBounds(260, 220, 100, 20);
		label2.setForeground(new Color(0,0,100));
		panel.add(label2);
		
		date = new JDateChooser();
		date.setBounds(360, 220, 100, 20);
		date.setBackground(new Color(200,255,255));
		panel.add(date);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Return Book",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(190,0,0)));
		panel1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel1.setBounds(30, 50, 460, 210);
	    panel1.setBackground(Color.LIGHT_GRAY);
		panel.add(panel1);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try 
		{
			
			if(ae.getSource()==return_book)
			{
				Conn con = new Conn();
				String sql = "insert into returnbook(book_id,student_id,bname,sname,course,branch,dateofIssue,dateofReturn) values(?,?,?,?,?,?,?,?)";
				PreparedStatement ps = con.c.prepareStatement(sql);
				ps.setString(1, book_id_tf.getText());
				ps.setString(2, student_id_tf.getText());
				ps.setString(3, bname_tf.getText());
				ps.setString(4, sname_tf.getText());
				ps.setString(5, course_tf.getText());
				ps.setString(6, branch_tf.getText());
				ps.setString(7, issue_date.getText());
				ps.setString(8, ((JTextField) date.getDateEditor().getUiComponent()).getText());
				int i = ps.executeUpdate();
				if(i>0)
				{
					JOptionPane.showMessageDialog(null, "Processing");
					delete();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
				}
				book_id_tf.setText("");
				bname_tf.setText("");
				student_id_tf.setText("");
				sname_tf.setText("");
				course_tf.setText("");
				branch_tf.setText("");
				issue_date.setText("");
			}
			if(ae.getSource()==search)
			{
				Conn con = new Conn();
				String sql = "select * from issuebook where book_id = ? and student_id = ?";
				PreparedStatement ps = con.c.prepareStatement(sql);
				ps.setString(1, book_id_tf.getText());
				ps.setString(2, student_id_tf.getText());
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					bname_tf.setText(rs.getString("bname"));
					sname_tf.setText(rs.getString("sname"));
					course_tf.setText(rs.getString("course"));
					branch_tf.setText(rs.getString("branch"));
					issue_date.setText(rs.getString("dateofIssue"));
				}
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
