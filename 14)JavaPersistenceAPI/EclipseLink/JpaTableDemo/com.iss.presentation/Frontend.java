package com.iss.presentation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.iss.BLL.EmployeeBLL;
import com.iss.models.EmployeeInfo;




public class Frontend  extends JFrame
{
	private JTextField tf1, tf2, tf3,tf4;
    private JTable table;
    private DefaultTableModel model;
    private EmployeeBLL bll;
	public Frontend()
	{
	        setSize(1000, 600);
	        setLayout(null);

	        tf1 = new JTextField(); 
	        tf1.setBounds(20, 30, 100, 30); 
	        add(tf1);
	        tf2 = new JTextField(); 
	        tf2.setBounds(130, 30, 100, 30); 
	        add(tf2);
	        tf3 = new JTextField(); 
	        tf3.setBounds(240, 30, 100, 30); 
	        add(tf3);
	        tf4=new JTextField();
	        tf4.setBounds(350,30,100,30);
	        add(tf4);

	        JButton addBtn = new JButton("ADD");
	        JButton updateBtn = new JButton("UPDATE");
	        JButton deleteBtn = new JButton("DELETE");
	        JButton displayBtn = new JButton("DISPLAY");
	        
	        addBtn.setBounds(470, 20, 100, 30);
	        updateBtn.setBounds(580, 20, 100, 30);
	        deleteBtn.setBounds(690, 20, 100, 30);
	        displayBtn.setBounds(800, 20, 100, 30);
	        add(addBtn); 
	        add(updateBtn); 
	        add(deleteBtn); 
	        add(displayBtn);
	        
	        
	        model = new DefaultTableModel(new Object[]{"Sno", "Name", "Salary","Department"}, 0);
	        table = new JTable(model);
	        table.setRowHeight(30);
	        JScrollPane jsp = new JScrollPane(table);
	        jsp.setBounds(30, 80, 770, 400); 
	        add(jsp);
	        
	        
	        bll=new EmployeeBLL();
	        addBtn.addActionListener(e -> {
	        	try {
	        	EmployeeInfo emp = new EmployeeInfo();
	            emp.setEmpid(Integer.parseInt(tf1.getText()));
	            emp.setEmpname(tf2.getText());
	            emp.setEmpsal(Double.parseDouble(tf3.getText()));
	            emp.setDep(tf4.getText());
	            if (bll.addEmployee(emp)) displayData();
	        	}catch(Exception ex)
		        {
		        	JOptionPane.showMessageDialog(null,ex.getMessage());
		        }
	        });
	        
	       
		    updateBtn.addActionListener(e->{
		    	try {
		        	EmployeeInfo emp=new EmployeeInfo();
		        	emp.setEmpid(Integer.parseInt(tf1.getText()));
		            emp.setEmpname(tf2.getText());
		            emp.setEmpsal(Double.parseDouble(tf3.getText()));
		            emp.setDep(tf4.getText());
		            if (bll.updateEmployee(emp)) displayData();
		    	}catch(Exception ex)
		        {
		        	JOptionPane.showMessageDialog(null,ex.getMessage());
		        }
		        });
	        
		        deleteBtn.addActionListener(e -> {
		        	try {
		        		if (bll.deleteEmployee(Integer.parseInt(tf1.getText()))) displayData();
		        	}catch(Exception ex)
			        {
			        	JOptionPane.showMessageDialog(null,ex.getMessage());
			        }
		        });
	        
	        
		        displayBtn.addActionListener(e -> displayData());
			        table.addMouseListener(new MouseAdapter() {
			            public void mouseClicked(MouseEvent e) {
			                int row = table.getSelectedRow();
			                tf1.setText(model.getValueAt(row, 0).toString());
			                tf2.setText(model.getValueAt(row, 1).toString());
			                tf3.setText(model.getValueAt(row, 2).toString());
			                tf4.setText(model.getValueAt(row, 3).toString());
			            }
			        
		        });
		        
	        
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setVisible(true);
	}
	private void displayData()
	{
		model.setRowCount(0);
        List<EmployeeInfo> list = bll.getAllEmployee();
        for (EmployeeInfo emp : list) {
        	model.addRow(new Object[]{emp.getEmpid(),emp.getEmpname(),emp.getEmpsal(),emp.getDep()});
        }
	}
	public static void main(String args[])
	{
		new Frontend();
	}

}
