/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itwpbl_hotel;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Checkout extends JFrame implements ActionListener
{
       JLabel phone,roomn,lname;
       Choice name;
       JTextField tphone,troomn;
       JButton checkout,getdetails,back;
       DatabaseCon db;
       Checkout()   
       {
           setTitle("Checkout Window");
           getContentPane().setBackground(Color.white);
           setBounds(500,200,550,450);
           
           lname = new JLabel("Name");
           lname.setBounds(100,30,120,30);
           lname.setFont(new Font("ARIAL",Font.BOLD,18));
           lname.setForeground(Color.BLACK);
           
           name = new Choice();
           name.setBounds(230,30,150,30);
           name.setBackground(Color.black);
           name.setFont(new Font("ARIAL",Font.BOLD,13));
           
           try{
               db = new DatabaseCon();
               String q = "select * from CustomerDetail";
               ResultSet rs = db.s.executeQuery(q);
               
               while(rs.next())
               {
                  name.add(rs.getString("cname"));   
               }
               
           }catch(Exception e)
           {
               e.printStackTrace();
           }
           
           
           phone = new JLabel("Phone No.");
           phone.setBounds(100,100,120,30);
           phone.setFont(new Font("ARIAL",Font.BOLD,18));
           phone.setForeground(Color.BLACK);
           
           tphone = new JTextField();
           tphone.setBounds(230,100,150,30);
           tphone.setForeground(Color.white);
           tphone.setFont(new Font("ARIAL",Font.BOLD,18));
           
           roomn = new JLabel("Room No.");
           roomn.setBounds(100,170,120,30);
           roomn.setFont(new Font("ARIAL",Font.BOLD,18));
           roomn.setForeground(Color.BLACK);
           
          
         
           troomn = new JTextField();
           troomn.setBounds(230,170,150,30);
           troomn.setForeground(Color.white);
           troomn.setFont(new Font("ARIAL",Font.BOLD,18));
           
           checkout = new JButton("Checkout");
           checkout.setBounds(100,250,120,30);
           checkout.setFont(new Font("ARIAL",Font.BOLD,18));
           checkout.addActionListener(this);
           
           getdetails = new JButton("Get Details"); 
           getdetails.setBounds(250,250,120,30);
           getdetails.setFont(new Font("ARIAL",Font.BOLD,18));
           getdetails.addActionListener(this);
           
           back = new JButton("Back");
           back.setBounds(170,300,120,30);
           back.setFont(new Font("ARIAL",Font.BOLD,18));
           back.addActionListener(this);
           
           add(lname);
           add(name);
           add(phone);
           add(tphone);
           add(roomn);
           add(troomn);
           add(checkout);
           add(getdetails);
           add(back);
           setLayout(null);
           setVisible(true);
           
       }
       public void actionPerformed(ActionEvent ae)
       {
           String na = name.getSelectedItem();
           String p;
           String ro;
           if(ae.getSource()==getdetails)
           {
               try{
               String q2 = "select * from CustomerDetail where cname = '"+na+"' ";
               ResultSet r = db.s.executeQuery(q2);
               if(r.next())
               {
                    p = r.getString("phone_no");
                    ro = r.getString("room_no");
                   tphone.setText(p);
                   troomn.setText(ro);
               }
               else{
                   JOptionPane.showMessageDialog(null, "Record with this name " +na+" not found ");
                   return;
               }
               }catch(Exception e)
               {
                   e.printStackTrace();
               }
           }
           else if(ae.getSource()==checkout)
           {
               String ron = troomn.getText();
               try{
                String q3 = "update AddRoom set room_state = 'AVAILABLE' where room_no= '"+ron+"' ";
               
                String q4 = "delete from CustomerDetail where room_no = '"+ron+"' ";
                db.s.executeUpdate(q4);
                 db.s.executeUpdate(q3);
                JOptionPane.showMessageDialog(null,"Customer Checkedout successfully");
                setVisible(false);
               }catch(Exception e)
               {
                   e.printStackTrace();
               }
           }
           else{
               setVisible(false);
               new Reception();
           }
       }
       public static void main(String args[])throws Exception
       {
           UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
           new Checkout();
       }
       
           
}
