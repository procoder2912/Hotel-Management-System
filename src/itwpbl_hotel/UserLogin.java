/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itwpbl_hotel;

/**
 *
 * @author abhid
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class UserLogin extends JFrame implements ActionListener{
	JTextField username;
	JPasswordField password;
	JButton log,back;
	UserLogin()
	{
          setTitle("Login Page");
	  getContentPane().setBackground(Color.WHITE);
	  setLayout(null);
	 // setDefaultCloseOperation(EXIT_ON_CLOSE);
	  JLabel user = new JLabel("USERNAME");
	  user.setForeground(Color.BLACK);
	  user.setFont(new Font("ARIAL",Font.BOLD,12));
	  user.setBounds(40,20,100,30);
	  
	  username = new JTextField();
	  username.setForeground(Color.white);
	  username.setBounds(160,20,150,30); 
	  
	  JLabel pass = new JLabel("PASSWORD");
	  pass.setForeground(Color.BLACK);
	  pass.setFont(new Font("ARIAL",Font.BOLD,12));
	  pass.setBounds(40,80,100,30);
	  
	  password = new JPasswordField();
	  password.setForeground(Color.white);
	  password.setBounds(160,80,150,30);
	  
	   log = new JButton("LOGIN");
	  log.setBounds(40,150,120,30);
	  log.addActionListener(this);
	  
	  back = new JButton("CANCEL");
	  back.setBounds(180,150,120,30);
	  back.addActionListener(this); 
	  
	  ImageIcon logi = new ImageIcon("C:/Users/abhid/OneDrive/Documents/NetBeansProjects/ITWPBL_HOTEL/src/itwpbl_hotel/log2.png");
      Image i = logi.getImage().getScaledInstance(280,200,Image.SCALE_DEFAULT);
      ImageIcon logB = new ImageIcon(i);
      JLabel logimage = new JLabel(logB);
      logimage.setBounds(350,10,200,200);
	  setBounds(500,200,600,300);
	    
	  add(logimage);
	  add(user);
	  add(pass);
	  add(username);
	  add(log);
	  add(password);
	  add(back);
	  setVisible(true);		
	}
	public void call()throws Exception
	{
			
	}
	public void actionPerformed(ActionEvent e)
	{
	
		if(e.getSource()==log)
		{
			String u = username.getText();
			String p = password.getText();
			if(u.equals("")|| p.equals(""))
			{
				JOptionPane.showMessageDialog(null, "All the Fields must be entered");
				return;
			}
			username.setText("");
			password.setText("");
			try {
			   DatabaseCon obj = new DatabaseCon();
			  
			   String query = "select * from UserDetails where name = '"+u+"' and password = '" +p+"'";
			   ResultSet rs = obj.s.executeQuery(query);
			   
			   if(rs.next()==true)
			   {
				   setVisible(false);
				   new DashBoard();
			   }
			   else {
				   JOptionPane.showMessageDialog(null, "INVALID PASSWORD OR USERNAME");
				   setVisible(false);
			   }
			}catch(Exception f)
			{
				f.printStackTrace();
			}
		 
		}
		else if(e.getSource()==back)
		{
			setVisible(false);
			
			
		}
		
	}
	public static void main(String args[])
	{
		try {
		UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
		new UserLogin();
		}catch(Exception e)
		{
		 e.printStackTrace();
		  
		}
	}
        
}