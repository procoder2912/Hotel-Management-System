/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itwpbl_hotel;


import javax.swing.*;
import java.sql.*; 
import java.awt.*; 
import java.awt.event.*;

public class HotelEmpire extends JFrame implements ActionListener {
	JButton cont;
	HotelEmpire()
	{
		setBounds(0,0,1550,1000);
		setTitle("Hotel Empire");
		ImageIcon empire = new ImageIcon("C:/Users/abhid/OneDrive/Documents/NetBeansProjects/ITWPBL_HOTEL/src/itwpbl_hotel/EMPD.jpeg");
		Image e1 = empire.getImage().getScaledInstance(1500,1000,Image.SCALE_DEFAULT);
		ImageIcon e2 = new ImageIcon(e1);
		JLabel l = new JLabel(e2); 
		l.setBounds(0,0,1280,960);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JLabel greet = new JLabel("WELCOME TO HOTEL EMPIRE");
		greet.setBounds(190,50,1500,100); 
		greet.setForeground(Color.BLACK);
		greet.setFont(new Font("ARIAL",Font.ITALIC,70));
		l.add(greet);
		
	        cont = new JButton("CONTINUE");
		cont.setBounds(550,700,150,50);
		cont.setForeground(Color.BLACK);
		cont.setFont(new Font("ARIAL",Font.ITALIC,20));
		cont.addActionListener(this);
		//cont.setBackground(Color.WHITE);
		
		
		
		l.add(cont);
		
		add(l);
		setVisible(true); 
		while(true)
		{
			greet.setVisible(false);
			try{
				Thread.sleep(800);
			}catch(Exception e)
			{
			   e.printStackTrace();		
			}
			greet.setVisible(true);
			try{
				Thread.sleep(800);
			}catch(Exception e)
			{
			   e.printStackTrace();		
			}
		}
		
	}
	public void actionPerformed(ActionEvent a)
	{
	
        
		//setVisible(false);
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
			  new UserLogin();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void main(String args[])throws Exception
	{
	  UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
	  new  HotelEmpire(); 
	}

}

