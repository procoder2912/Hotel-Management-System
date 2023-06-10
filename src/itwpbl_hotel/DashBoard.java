/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itwpbl_hotel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;
public class DashBoard extends JFrame implements ActionListener {
	JMenuItem addemp,addroom;
	DashBoard()
	{
                setTitle("Dashboard");
		setBounds(0,0,1550,1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon Dash = new ImageIcon("C:/Users/abhid/OneDrive/Documents/NetBeansProjects/ITWPBL_HOTEL/src/itwpbl_hotel/DASHBOARD.jpeg");
		Image d = Dash.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
		ImageIcon dash2 = new ImageIcon(d);
		JLabel dash = new JLabel(dash2);
		dash.setBounds(0,0,1550,1000);
		
		JLabel show = new JLabel("HOTEL EMPIRE");
		show.setBounds(560,40,1000,60);
		show.setFont(new Font("ARIAL",Font.BOLD,50));
		show.setForeground(Color.black);
		
		JMenuBar manage = new JMenuBar();
		manage.setBounds(0,0,1550,30);
		
		JMenu hotel = new JMenu("HOTEL MANAGEMENT");
		hotel.setFont(new Font("ARIAL",Font.BOLD,15));
		manage.add(hotel);
	  
		
		JMenu admin = new JMenu("ADMIN");
		admin.setFont(new Font("ARIAL",Font.BOLD,15));
		manage.add(admin);
		
		 addemp = new JMenuItem("ADD EMPLOYEES");
	    admin.add(addemp);
	    addemp.addActionListener(this);
	    
	   addroom = new JMenuItem("ADD ROOM");
	   admin.add(addroom);
	   addroom.addActionListener(this);
	    JMenuItem reception = new JMenuItem("RECEPTION");
	    hotel.add(reception);
	    reception.addActionListener(this);
	    
		add(manage);
		add(dash);
		dash.add(show);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==addemp)
		{
			new AddEmployee();
		}
		else if(e.getSource()==addroom)
		{
			new AddRoom();
		}
		else {
			new Reception();
		}
	}
	public static void main(String args[])throws Exception
	{
	   UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
	   new DashBoard();
	}
  
}

