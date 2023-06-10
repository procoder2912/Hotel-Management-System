/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itwpbl_hotel;

/**
 *
 * @author abhid
 */
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener {
	
	JLabel greet;
	JButton newroom,rooms,empinfo,customer,checkout,back;
	Reception()
	{
                setTitle("Reception");
		getContentPane().setBackground(Color.white);
		setBounds(480,200,560,560);
		setLayout(null);
		greet = new JLabel("Welcome to reception");
		greet.setBounds(165,30,230,30);
		greet.setFont(new Font("ARIAL",Font.BOLD,20));
		greet.setForeground(Color.black);
		
		newroom = new JButton("Customer Room Booking");
		newroom.setBounds(128,90,280,40);
		newroom.setFont(new Font("ARIAL",Font.BOLD,18));
		newroom.setForeground(Color.black);
		newroom.addActionListener(this);
		rooms = new JButton("Rooms");
		rooms.setBounds(128,150,280,40);
		rooms.setFont(new Font("ARIAL",Font.BOLD,18));
		rooms.setForeground(Color.black);
		rooms.addActionListener(this);
		
		empinfo = new JButton("Employee Info.");
		empinfo.setBounds(128,210,280,40);
		empinfo.setFont(new Font("ARIAL",Font.BOLD,18));
		empinfo.setForeground(Color.black);
                empinfo.addActionListener(this);
		
		customer = new JButton("Customer Info.");
		customer.setBounds(128,270,280,40);
		customer.setFont(new Font("ARIAL",Font.BOLD,18));
		customer.setForeground(Color.black);
	        customer.addActionListener(this);
                
		checkout = new JButton("Checkout");
		checkout.setBounds(128,330,280,40);
		checkout.setFont(new Font("ARIAL",Font.BOLD,18));
		checkout.setForeground(Color.black);
                checkout.addActionListener(this);
		
		back = new JButton("Back");
		back.setBounds(128,390,280,40);
		back.setFont(new Font("ARIAL",Font.BOLD,18));
		back.setForeground(Color.black);
                back.addActionListener(this);
		
		add(newroom);
		add(greet);
		add(rooms);
		add(empinfo);
		add(customer);
		add(checkout);
		add(back);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==newroom)
		{
			setVisible(false);
			new AddCustomer();
		}
                else if(ae.getSource()==rooms)
                {
                    setVisible(false);
                    new RoomRecord();
                }
                else if(ae.getSource()==empinfo)
                {
                    setVisible(false);
                    new EmployeeRecord();
                }
                else if(ae.getSource()==customer)
                {
                    setVisible(false);
                    new CustomerRecord();
                }
                else if(ae.getSource()==checkout)
                {
                    setVisible(false);
                    new Checkout();
                }
                else
                {
                    setVisible(false);
                    
                }
	}
	
	public static void main(String args[])throws Exception
	{
		UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
		new Reception();
		
	}

}

