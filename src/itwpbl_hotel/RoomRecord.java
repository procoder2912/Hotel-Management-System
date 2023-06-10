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
public class RoomRecord extends JFrame implements ActionListener {
    JTable rt;
    JLabel ron,rst,clean,amt,bed;
    JButton back;
    RoomRecord()
    {
        
        getContentPane().setBackground(Color.white);
        setBounds(300,200,800,600);
        setLayout(null);
        
        rt = new JTable();
        rt.setBounds(0,30,800,400);
        rt.setBackground(Color.white);
        rt.setForeground(Color.black);
        try{
        DatabaseCon db = new DatabaseCon();
        String q = "select * from AddRoom";
        ResultSet rs = db.s.executeQuery(q);
        rt.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        ron = new JLabel("Room Number");
        ron.setBounds(10,10,100,20);
        ron.setForeground(Color.black);
        ron.setFont(new Font("ARIAL",Font.BOLD,13));
        
        rst = new JLabel("Room Status");
        rst.setBounds(180,10,100,20);
        rst.setForeground(Color.black);
        rst.setFont(new Font("ARIAL",Font.BOLD,13));
        
        clean = new JLabel("Clean Status");
        clean.setBounds(350,10,100,20);
        clean.setForeground(Color.black);
        clean.setFont(new Font("ARIAL",Font.BOLD,13));
        
        amt = new JLabel("Payable Amount");
        amt.setBounds(520,10,100,20);
        amt.setForeground(Color.black);
        amt.setFont(new Font("ARIAL",Font.BOLD,13));
        
        bed = new JLabel("Bed Type");
        bed.setBounds(690,10,100,20);
        bed.setForeground(Color.black);
        bed.setFont(new Font("ARIAL",Font.BOLD,13));
        
        back = new JButton("BACK");
        back.setBounds(320,450,120,30);
        back.setForeground(Color.black);
        back.setFont(new Font("ARIAL",Font.BOLD,13));
        back.addActionListener(this);
        add(rt);
        add(ron);
        add(rst);
        add(clean);
        add(amt);
        add(bed);
        add(back);
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
        new RoomRecord();
    }
}
