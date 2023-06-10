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

public class AddEmployee extends JFrame implements ActionListener {
	JLabel ename,eage,egen,job,salary,ephone,eemail,eadhar,img;
	JTextField tename,teage,tephone,temail,tadhar;
	JRadioButton male,female;
	JComboBox jobb;
	JSpinner spinner;
	AddEmployee()
        {
                setTitle("Employee Window");
		getContentPane().setBackground(Color.white);
		setBounds(350,200,850,540);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		ename = new JLabel("NAME");
		ename.setBounds(60,30,120,30);
		ename.setForeground(Color.black);
		ename.setFont(new Font("ARIAL",Font.BOLD,13));
		
		tename = new JTextField();
		tename.setBounds(200,30,150,30);
		
		eage =  new JLabel("AGE");
		eage.setBounds(60,80,120,30);
		eage.setFont(new Font("ARIAL",Font.BOLD,13));
		eage.setForeground(Color.BLACK);
	    
		teage = new JTextField();
		teage.setBounds(200,80,150,30);
		
		egen = new JLabel("GENDER");
		egen.setBounds(60,130,120,30);
		egen.setFont(new Font("ARIAL",Font.BOLD,13));
		egen.setForeground(Color.black);
		
		male = new JRadioButton("MALE");
		male.setBounds(200,130,70,30);
		male.setBackground(Color.WHITE);
		male.setForeground(Color.black);
		male.setFont(new Font("ARIAL",Font.BOLD,13));

		
		female = new JRadioButton("FEMALE");
		female.setBounds(280,130,100,30);
		female.setBackground(Color.WHITE);
		female.setForeground(Color.black);
		female.setFont(new Font("ARIAL",Font.BOLD,13));
        
		ButtonGroup b = new ButtonGroup();
		b.add(male);
		b.add(female);
		job = new JLabel("JOBS");
                job.setBounds(60,180,120,30);
    	        job.setForeground(Color.black);
		job.setFont(new Font("ARIAL",Font.BOLD,13));
		
                ImageIcon i = new ImageIcon("C:/Users/abhid/OneDrive/Documents/NetBeansProjects/ITWPBL_HOTEL/src/itwpbl_hotel/emp 1.jpg");
                img = new JLabel(i);
                img.setBounds(370,30,480,510);
		String j[] = {"Manager","Chef","Waitre/Waitress","Roomservice"};
		jobb = new JComboBox(j);
		jobb.setBounds(200,180,150,30);
		jobb.setBackground(Color.white);
		jobb.setForeground(Color.black);
		
		salary = new JLabel("SALARY");
		salary.setBounds(60,230,120,30);
		salary.setFont(new Font("ARIAL",Font.BOLD,13));
		salary.setForeground(Color.black);
		//JSpinner spinner = new JSpinner(new SpinnerNumberModel(18,18,50,1));
		//spinner.setBounds(200,80,150,30);
		 spinner = new JSpinner(new SpinnerNumberModel(10000,10000,50000,1000));
		spinner.setBounds(200,230,150,30);
		
		ephone = new JLabel("Phone");
		ephone.setBounds(60,280,120,30);
		ephone.setFont(new Font("ARIAL",Font.BOLD,13));
		ephone.setForeground(Color.black);
		
		tephone = new JTextField();
		tephone.setBounds(200,280,150,30);
		
		JButton submit = new JButton("SUBMIT");
		submit.setBounds(200,430,150,30);
		submit.setFont(new Font("ARIAL",Font.BOLD,13));
		submit.addActionListener(this);
		
		
		eemail = new JLabel("E-MAIL");
		eemail.setBounds(60,330,120,30);
		eemail.setFont(new Font("ARIAL",Font.BOLD,13));
		eemail.setForeground(Color.black);
		
		eadhar = new JLabel("AADHAR NO");
		eadhar.setBounds(60,380,120,30);
		eadhar.setFont(new Font("ARIAL",Font.BOLD,13));
		eadhar.setForeground(Color.black);
		
		temail = new JTextField();
		temail.setBounds(200,330,150,30);
		
		tadhar = new JTextField();
		tadhar.setBounds(200,380,150,30);
		add(ename);
		add(tename);
		add(eage);
		add(teage);
		add(egen);
		add(male);
		add(female);
		add(job);
		add(jobb);
		add(salary);
		add(tephone);
		add(spinner);
		add(ephone);
		add(temail);
		add(submit);
		add(eemail);
		add(eadhar);
		add(tadhar);
                add(img);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent a)
	{
		String n = tename.getText();
		String age = teage.getText();
		String gend;
		if(male.isSelected())
		{
			gend = "Male";
		}
		else {
			gend = "female";
		}
		
		String jo = (String) jobb.getSelectedItem();
		int sal = (int)spinner.getValue();
		String p = tephone.getText();
		String em = temail.getText();
		String ad = tadhar.getText();
		try {
		DatabaseCon db =  new DatabaseCon();
		
		String query  = "select * from empSal where post = '"+jo+"' and sal= '"+sal+"'" ;
		ResultSet r = db.s.executeQuery(query);
		if(r.next()) 
		{
			String q2 = "insert into empdetail values('"+n+"','"+age+"','"+gend+"','"+jo+"',"+sal+",'"+p+"','"+em+"','"+ad+"')";
			db.s.executeUpdate(q2);
		    JOptionPane.showMessageDialog(null, "Employee Added Successfully");
			setVisible(false);
		}
		else {
			JOptionPane.showMessageDialog(null, "You can't get the demanded salary for the post");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
    public static void main(String[] args)throws Exception
    {
    	UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
		  new AddEmployee();
    	 
    }
}


