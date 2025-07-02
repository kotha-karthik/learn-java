package com.iss.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.iss.BLL.StudentBLL;
import com.iss.models.StudentInfo;

public class ThreeLayerArch extends JFrame {
	
	private JTextField idtf,nametf,feetf;
	private JButton	savebtn;
	
	private StudentBLL	studentbll;
	private StudentInfo	studentinfo;
	
	public ThreeLayerArch()
	{
		try {
			studentbll=new StudentBLL();
			
			setLayout(null);
			setSize(500,500);
			idtf=new JTextField();
			idtf.setBounds(100,100,100,30);
			nametf=new JTextField();
			nametf.setBounds(100,150,100,30);
			feetf=new JTextField();
			feetf.setBounds(100,200,100,30);
			
			savebtn=new JButton("Save");
			savebtn.setBounds(100,250,100,30);
			
			savebtn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e)
				{
					try {
						studentinfo=new StudentInfo();
						studentinfo.setId(Integer.parseInt(idtf.getText()));
						studentinfo.setName(nametf.getText());
						studentinfo.setFee(Double.parseDouble(feetf.getText()));
						studentbll.save(studentinfo);
					}catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex);
					}
				}
				
			});
			
			add(savebtn);
			add(idtf);
			add(nametf);
			add(feetf);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	
	
	
	public static void main(String args[])
	{
		new ThreeLayerArch();
	}
}
