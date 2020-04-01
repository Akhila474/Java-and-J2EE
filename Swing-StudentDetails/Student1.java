import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;

import javax.swing.*;
public class Student1 implements ActionListener{
JLabel name,usn,age,address,s1,s2,s3,s4,s5,s6,s7,s8,cgpa;
JTextField tname,tusn,tage,taddr,t1,t2,t3,t4,t5,t6,t7,t8,tcgpa;
JButton compute,clear,done,display;
static JFrame frm1,frm2;
JTextArea tr;
static JPanel jpan;
double total=0;
List<StudentDetails> ar=new ArrayList<>();
Student1()
{
	frm1=new JFrame("Student Details");
	jpan=new JPanel();
	name=new JLabel("NAME : ");
	usn=new JLabel("USN : ");
	age=new JLabel("AGE : ");
	address=new JLabel("ADDRESS : ");
	s1=new JLabel("SGPA sem1 : ");
	s2=new JLabel("SGPA sem2 : ");
	s3=new JLabel("SGPA sem3 : ");
	s4=new JLabel("SGPA sem4 : ");
	s5=new JLabel("SGPA sem5 : ");
	s6=new JLabel("SGPA sem6 : ");
	s7=new JLabel("SGPA sem7 : ");
	s8=new JLabel("SGPA sem8 : ");
	cgpa=new JLabel("CGPA : ");
	
	tname=new JTextField(50);
	tusn=new JTextField(50);
	tage=new JTextField(50);
	taddr=new JTextField(50);
	t1=new JTextField(4);
	t2=new JTextField(4);
	t3=new JTextField(4);
	t4=new JTextField(4);
	t5=new JTextField(4);
	t6=new JTextField(4);
	t7=new JTextField(4);
	t8=new JTextField(4);
	tcgpa=new JTextField(10);
	
	jpan.add(name);
	jpan.add(tname);
	jpan.add(usn);
	jpan.add(tusn);
	jpan.add(age);
	jpan.add(tage);
	jpan.add(address);
	jpan.add(taddr);
	jpan.add(s1);
	jpan.add(t1);
	jpan.add(s2);
	jpan.add(t2);
	jpan.add(s3);
	jpan.add(t3);
	jpan.add(s4);
	jpan.add(t4);
	jpan.add(s5);
	jpan.add(t5);
	jpan.add(s6);
	jpan.add(t6);
	jpan.add(s7);
	jpan.add(t7);
	jpan.add(s8);
	jpan.add(t8);
	
	compute=new JButton("COMPUTE");
	jpan.add(compute);
	compute.addActionListener(this);
	clear=new JButton("CLEAR");
	jpan.add(clear);
	clear.addActionListener(this);
	
	done=new JButton("DONE");
	jpan.add(done);
	done.addActionListener(this);
	
	display=new JButton("DISPLAY");
	jpan.add(display);
	display.addActionListener(this);
	
	jpan.add(cgpa);
	jpan.add(tcgpa);
	jpan.setSize(500, 500);
	jpan.setLayout(new GridLayout(20,1));
	frm1.add(jpan);
	jpan.setVisible(true);
	frm1.setSize(800,800);
	frm1.setVisible(true);

}


public static void main(String args[]) {
	Student1 sc=new Student1();
}


@Override
public void actionPerformed(ActionEvent e) {
	double m1,m2,m3,m4,m5,m6,m7,m8;
	int age;
	String sname,susn,saddr,sage;
	
	if(e.getSource()==compute)
	{
	try{
		age=Integer.parseInt(tage.getText());
		if(age>=18 && age<25)
		{	
			m1=Double.parseDouble(t1.getText());
			m2=Double.parseDouble(t2.getText());
			m3=Double.parseDouble(t3.getText());
			m4=Double.parseDouble(t4.getText());
			m5=Double.parseDouble(t5.getText());
			m6=Double.parseDouble(t6.getText());
			m7=Double.parseDouble(t7.getText());
			m8=Double.parseDouble(t8.getText());
			total=(m1+m2+m3+m4+m5+m6+m7+m8)/8;
			if(total>5 && total<=10)
				tcgpa.setText(total+"");
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid sgpa entered...error in finding cgpa","Warning!!",JOptionPane.WARNING_MESSAGE);
				t1.requestFocus();
			}
				
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Invalid AGE","Warning!!",JOptionPane.WARNING_MESSAGE);
			tage.requestFocus();
		}
	}
	catch(NumberFormatException ev)
	{
		JOptionPane.showMessageDialog(null,"Invalid format of SGPA or AGE given","Warning!!",JOptionPane.WARNING_MESSAGE);
	}
	}
	else if(e.getSource()==done)
	{
		sname=tname.getText();
		susn=tusn.getText();
		saddr=taddr.getText();
		sage=tage.getText();
		StudentDetails st=new StudentDetails(sname,susn,sage,saddr,total);
		ar.add(st);
	}
	else if(e.getSource()==clear)
	{
		tname.setText("");
		tusn.setText("");
		taddr.setText("");
		tage.setText("");
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");
		tname.requestFocus();
	}
	else
	{
		frm2=new JFrame("Student Details");
		tr=new JTextArea(20,20);
		frm2.add(tr);
		for(StudentDetails i : ar)
		{
		//System.out.println("Student detail "+i);
		tr.append(i.toString());
		
		}
		frm1.setVisible(false);
		frm2.setSize(650,1000);
		frm2.setVisible(true);
		frm2.setLayout(new GridLayout(1,1));	
	}
	}
}