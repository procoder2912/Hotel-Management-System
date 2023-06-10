/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itwpbl_hotel;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class CustomerRecord extends JFrame implements ActionListener {
    
    JTable rt;
    JLabel name,id,phone,email,gen,roomn,paid;
    JButton back;
    CustomerRecord()
    {
        getContentPane().setBackground(Color.white);
        setBounds(300,200,1050,600);
        setLayout(null);
        
        rt = new JTable();
        rt.setBounds(0,30,1050,400);
        rt.setBackground(Color.white);
        rt.setForeground(Color.black);
        try{
        DatabaseCon db = new DatabaseCon();
        String q = "select * from CustomerDetail";
        ResultSet rs = db.s.executeQuery(q);
        rt.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        name = new JLabel("Name");
        name.setBounds(10,10,100,20);
        name.setForeground(Color.black);
        name.setFont(new Font("ARIAL",Font.BOLD,13));
        
        id = new JLabel("ID-proof");
        id.setBounds(160,10,100,20);
        id.setForeground(Color.black);
        id.setFont(new Font("ARIAL",Font.BOLD,13));
        
        phone = new JLabel("Phone No.");
        phone.setBounds(310,10,100,20);
        phone.setForeground(Color.black);
        phone.setFont(new Font("ARIAL",Font.BOLD,13));
        
        email = new JLabel("Email");
        email.setBounds(460,10,100,20);
        email.setForeground(Color.black);
        email.setFont(new Font("ARIAL",Font.BOLD,13));
        
        gen = new JLabel("Gender");
        gen.setBounds(610,10,100,20);
        gen.setForeground(Color.black);
        gen.setFont(new Font("ARIAL",Font.BOLD,13));
        
        roomn = new JLabel("Room No.");
        roomn.setBounds(760,10,100,20);
        roomn.setForeground(Color.black);
        roomn.setFont(new Font("ARIAL",Font.BOLD,13));
        
        paid = new JLabel("Amt.Paid");
        paid.setBounds(930,10,100,20);
        paid.setForeground(Color.black);
        paid.setFont(new Font("ARIAL",Font.BOLD,13));
        
        back = new JButton("BACK");
        back.setBounds(450,450,120,30);
        back.setForeground(Color.black);
        back.setFont(new Font("ARIAL",Font.BOLD,13));
        back.addActionListener(this);
        back.addActionListener(this);
        
        add(rt);
        add(name);
        add(id);
        add(phone);
        add(email);
        add(gen);
        add(back);
        add(roomn);
        add(paid);
       
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Reception();
    }
        
    public static void main(String args[])throws Exception
    {
        UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        new CustomerRecord();
    }
}
