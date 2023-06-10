/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itwpbl_hotel;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*; 
import net.proteanit.sql.*;
public class EmployeeRecord extends JFrame implements ActionListener  {
    
    JTable rt;
    JLabel name,age,gen,job,sal,phone,email,aadhar;
    JButton back;
    EmployeeRecord(){
        getContentPane().setBackground(Color.white);
        setBounds(300,200,1050,600);
        setLayout(null);
        
        rt = new JTable();
        rt.setBounds(0,30,1050,400);
        rt.setBackground(Color.white);
        rt.setForeground(Color.black);
        try{
        DatabaseCon db = new DatabaseCon();
        String q = "select * from empdetail";
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
        
        age = new JLabel("Age");
        age.setBounds(150,10,100,20);
        age.setForeground(Color.black);
        age.setFont(new Font("ARIAL",Font.BOLD,13));
        
        gen = new JLabel("Gender");
        gen.setBounds(290,10,100,20);
        gen.setForeground(Color.black);
        gen.setFont(new Font("ARIAL",Font.BOLD,13));
        
        job = new JLabel("Post");
        job.setBounds(430,10,100,20);
        job.setForeground(Color.black);
        job.setFont(new Font("ARIAL",Font.BOLD,13));
        
        sal = new JLabel("Salary");
        sal.setBounds(570,10,100,20);
        sal.setForeground(Color.black);
        sal.setFont(new Font("ARIAL",Font.BOLD,13));
        
        phone = new JLabel("Phone Number");
        phone.setBounds(660,10,100,20);
        phone.setForeground(Color.black);
        phone.setFont(new Font("ARIAL",Font.BOLD,13));

        email = new JLabel("Email");
        email.setBounds(850,10,100,20);
        email.setForeground(Color.black);
        email.setFont(new Font("ARIAL",Font.BOLD,13));
        
        aadhar = new JLabel("Aadhar No.");
        aadhar.setBounds(940,10,100,20);
        aadhar.setForeground(Color.black);
        aadhar.setFont(new Font("ARIAL",Font.BOLD,13));

        
        back = new JButton("BACK");
        back.setBounds(450,450,120,30);
        back.setForeground(Color.black);
        back.setFont(new Font("ARIAL",Font.BOLD,13));
        back.addActionListener(this);
        add(rt);
        add(name);
        add(age);
        add(gen);
        add(job);
        add(sal);
        add(back);
        add(phone);
        add(email);
        add(aadhar);
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
        new EmployeeRecord();
    }
}
