/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itwpbl_hotel;

/**
 *
 * @author abhid
 */
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddRoom extends JFrame implements ActionListener {
	JLabel addroom,roomn,available,status,price,bedtype,img;
	JTextField addRoom,prc;
	JComboBox avail,clean,bed;
	JButton add,cancel;
	AddRoom()
	{
                
		setBounds(330,200,940,470);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		addroom = new JLabel("ADD ROOM");
		addroom.setBounds(650,30,150,30);
		addroom.setForeground(Color.black);
		addroom.setFont(new Font("ARIAL",Font.BOLD,18));
		ImageIcon i = new ImageIcon("C:/Users/abhid/OneDrive/Documents/NetBeansProjects/ITWPBL_HOTEL/src/itwpbl_hotel/registration1.jpg");
                img = new JLabel(i);
                img.setBounds(0,0,540,470);
		roomn = new JLabel("Room Number");
		roomn.setBounds(550,80,150,30);
		roomn.setForeground(Color.black);
		roomn.setFont(new Font("ARIAL",Font.BOLD,16));
		
		addRoom = new JTextField();
		addRoom.setBounds(720,80,150,30);
		
		available = new JLabel("Room Status");
		available.setBounds(550,130,150,30);
		available.setForeground(Color.black);
		available.setFont(new Font("ARIAL",Font.BOLD,16));
		
		String s[] = {"AVAILABLE","OCCUPIED"};
		avail = new JComboBox(s);
		avail.setBounds(720,130,150,30);
		avail.setForeground(Color.WHITE);
		
		
		
		status = new JLabel("Cleaning Status");
		status.setBounds(550,180,150,30);
		status.setForeground(Color.black);
		status.setFont(new Font("ARIAL",Font.BOLD,16));
		
		String[] claenSta = {"CLEANED","DIRTY"};
		clean = new JComboBox(claenSta);
		clean.setBounds(720,180,150,30);
		clean.setForeground(Color.WHITE);
		
		price = new JLabel("Price");
		price.setBounds(550,230,150,30);
		price.setForeground(Color.black);
		price.setFont(new Font("ARIAL",Font.BOLD,16));
		
		prc = new JTextField();
		prc.setBounds(720,230,150,30);
		
		bedtype = new JLabel("Bed Type");
		bedtype.setBounds(550,280,150,30);
		bedtype.setForeground(Color.black);
		bedtype.setFont(new Font("ARIAL",Font.BOLD,16));
		
		String type[] = {"Single Bed","Double Bed"};
		bed = new JComboBox(type);
		bed.setBounds(720,280,150,30);
		
		add = new JButton("Add Room");
		add.setBounds(550,350,150,30);
		add.setFont(new Font("ARIAL",Font.BOLD,16));
		add.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(720,350,150,30);
		cancel.setFont(new Font("ARIAL",Font.BOLD,16));
		cancel.addActionListener(this);
		
		add(addroom);
		add(roomn);
		add(addRoom);
		add(available);
		add(avail);
		add(status);
		add(clean);
		add(price);
		add(prc);
		add(bedtype);
		add(bed);
		add(add);
		add(cancel);
                add(img);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		 String n = addRoom.getText();
		 String st = (String)avail.getSelectedItem();
		 String c = (String)clean.getSelectedItem();
		 String price = prc.getText();
		 String t = (String)bed.getSelectedItem();
		 
		 
		 if(ae.getSource()==add)
		 {
			 if(n.equals("")||price.equals(""))
			 {
				 JOptionPane.showMessageDialog(null, "All the fields must be entered");
	              return;			 
			 }
			 try 
			 {
				 DatabaseCon obj = new DatabaseCon();
				 
				 String query = "insert into AddRoom values('"+n+"','"+st+"','"+c+"','"+price+"','"+t+"')";
				 obj.s.executeUpdate(query);
				 JOptionPane.showMessageDialog(null, "Room added successfully");
				 setVisible(false);
			 }catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 
			
		 }
		 else {
			 setVisible(false);
		 }
	}
    public static void main(String[] args)
    {
    	try {
    	UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
    	new AddRoom();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}

