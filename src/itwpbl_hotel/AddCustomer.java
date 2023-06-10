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

public class AddCustomer extends JFrame implements ActionListener {
	JLabel Name,addc,idp,phone,eemail,gender,roomn,pay,img;
	JTextField tname,tphone,temail;
	TextField payable;
	JComboBox proof;
	JRadioButton male,female;
	JButton aroom,back;
	Choice room;
	DatabaseCon db;
        AddCustomer()       
        {
        	getContentPane().setBackground(Color.white);
        	addc = new JLabel("Add Customer");
        	addc.setForeground(Color.black);
        	addc.setBounds(650,30,150,30);
        	addc.setFont(new Font("ARIAL",Font.BOLD,18));
                
                ImageIcon i = new ImageIcon("C:/Users/abhid/OneDrive/Documents/NetBeansProjects/ITWPBL_HOTEL/src/itwpbl_hotel/139-1396457_add-customer-icon-png-add-to-contacts.png");
                Image i1 = i.getImage().getScaledInstance(540,540, Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i1);
        	img = new JLabel(i2);
                img.setBounds(0,0,540,540);
                Name = new JLabel("Name");	
        	Name.setForeground(Color.black);
        	Name.setFont(new Font("ARIAL",Font.BOLD,18));
        	Name.setBounds(550,80,150,30);
        	
        	tname = new JTextField();
        	tname.setBounds(700,80,150,30);
        	tname.setFont(new Font("ARIAL",Font.BOLD,13));
        	
        	idp = new JLabel("ID Proof");
        	idp.setForeground(Color.black);
        	idp.setFont(new Font("ARIAL",Font.BOLD,18));
        	idp.setBounds(550,130,150,30);
        	
        	String p[] = {"PAN","AADHAR","LICENSE","VOTER ID"};
        	proof = new JComboBox(p);
        	proof.setBounds(700,130,150,30);
        	proof.setForeground(Color.white);
        	
        	phone = new JLabel("Phone No.");
        	phone.setForeground(Color.black);
        	phone.setFont(new Font("ARIAL",Font.BOLD,18));
        	phone.setBounds(550,180,150,30);
        	
        	tphone = new JTextField();
        	tphone.setBounds(700,180,150,30);
        	tphone.setFont(new Font("ARIAL",Font.BOLD,13));
        	
        	eemail = new JLabel("Email");
        	eemail.setForeground(Color.black);
        	eemail.setFont(new Font("ARIAL",Font.BOLD,18));
        	eemail.setBounds(550,230,150,30);
        	
        	temail = new JTextField();
        	temail.setBounds(700,230,150,30);
        	temail.setFont(new Font("ARIAL",Font.BOLD,13));
        	
                gender = new JLabel("Gender");
                gender.setForeground(Color.black);
        	gender.setFont(new Font("ARIAL",Font.BOLD,18));
        	gender.setBounds(550,280,150,30);
 
        	male = new JRadioButton("Male");
        	male.setBounds(700,280,70,30);
        	male.setBackground(Color.WHITE);
    		male.setForeground(Color.black);
    		male.setFont(new Font("ARIAL",Font.BOLD,13));
            
    		female = new JRadioButton("Female");
    		female.setBounds(790,280,100,30);
    		female.setBackground(Color.WHITE);
    		female.setForeground(Color.black);
    		female.setFont(new Font("ARIAL",Font.BOLD,13));
    		
    		roomn = new JLabel("Room No.");
    		roomn.setForeground(Color.black);
         	roomn.setFont(new Font("ARIAL",Font.BOLD,18));
         	roomn.setBounds(550,330,150,30);
    		
         	room = new Choice();
         	room.setBounds(700,330,150,40);
         	room.setBackground(Color.black);
         	room.setForeground(Color.white);
         	
         	aroom = new JButton("ADD");
         	aroom.setBounds(550,450,150,30);
         	aroom.setFont(new Font("ARIAL",Font.BOLD,13));
    		aroom.addActionListener(this);
    		
    		back = new JButton("BACK");
    		back.setBounds(720,450,150,30);
    		back.setFont(new Font("ARIAL",Font.BOLD,13));
    		back.addActionListener(this);
    		
    		
         	try {
         	    db = new DatabaseCon();
         		String query = "select * from AddRoom where room_state = 'AVAILABLE' ";
         	    ResultSet rs = db.s.executeQuery(query);
         	    
         	    while(rs.next())
         	    {
         	    	room.add(rs.getString("room_no"));
         	    }
         	}catch(Exception e)
         	{
         		e.printStackTrace();
         	}
         	
    		ButtonGroup b = new ButtonGroup();
    		b.add(female);
    		b.add(male);
    		
    		pay = new JLabel("Payable Amt.");
    		pay.setBounds(550,380,150,30);
    		pay.setForeground(Color.black);
        	pay.setFont(new Font("ARIAL",Font.BOLD,18));   		

        	payable = new TextField();
        	payable.setBounds(700,380,150,30);
        	payable.setFont(new Font("ARIAL",Font.BOLD,13));
        	payable.setBackground(Color.black);
        	
        	setBounds(350,200,940,540);
        	setLayout(null);
        	setVisible(true);  
        	
        	add(Name);
        	add(addc);
        	add(tname);
        	add(idp);
        	add(proof);
        	add(phone);
        	add(tphone);
        	add(eemail);
        	add(temail);
        	add(gender);
        	add(male);
        	add(female);
        	add(roomn);
        	add(room);
        	add(pay);
        	add(payable);
        	add(aroom);
        	add(back);
                add(img);
        }
        public void actionPerformed(ActionEvent ae)
        {
        	String name = tname.getText();
        	String id = (String)proof.getSelectedItem();
        	String no = tphone.getText();
        	String mail = temail.getText();
        	String g;
        	if(male.isSelected())
        	{
        		g = "MALE";
        		
        	}
        	else
        	{
        		 g = "FEMALE";
        	}
        	String r = room.getSelectedItem();
         
          
          if(ae.getSource()==aroom)
          {
        	  if(name.equals(""))
              {
            	  JOptionPane.showMessageDialog(null,"Name Must be Entered");
            	  return;
              }
        	  try {
        	  String q1 = "select * from AddRoom where room_no = '"+r+"'";
        	  ResultSet rq1 = db.s.executeQuery(q1);
        	  String p;
        	  if(rq1.next())
                      
        	  {
        	   p = rq1.getString("price");
        	  payable.setText(p);
        	  
        	  String q2 = "insert into CustomerDetail values ( '"+name+"','"+id+"','"+no+"','"+mail+"','"+g+"','"+r+"','"+p+"')";
        	  
        	  String q3 = "update AddRoom set room_state = 'OCCUPIED' where room_no = '"+r+"'";
        	  
        	  db.s.executeUpdate(q2);
        	  db.s.executeUpdate(q3);
        	   JOptionPane.showMessageDialog(null, "Room Alloted Successfully to "+name);
        	   setVisible(false);
        	  }
        	  }catch(Exception e)
        	  {
        		  e.printStackTrace();
        	  }
          }
          else {
        	  setVisible(false);
        	  new Reception();
          }
        	
        	
        }
        public static void main(String args[])throws Exception
        {
        	UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        	new AddCustomer();
        }
	
}
