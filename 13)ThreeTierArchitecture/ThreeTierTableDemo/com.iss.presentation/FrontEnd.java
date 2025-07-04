package com.iss.presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.iss.BLL.StudentBLL;
import com.iss.models.Studentinfo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;


class JLabelCellenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    	ImageIcon icon=null;
    	
    	if(value!=null)
    	{
    		ImageIcon original = new ImageIcon((byte[])value);
            Image img = original.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
            return new JLabel(icon);
    	}
    	return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}

public class Frontend extends JFrame {
    private JTextField tf1, tf2, tf3;
    private JTable table;
    private DefaultTableModel model;
    private StudentBLL bll;
   
    private byte[] imageBytes;
    

    public Frontend() {
        setSize(1000, 600);
        setLayout(null);

        tf1 = new JTextField(); 
        tf1.setBounds(30, 30, 100, 30); 
        add(tf1);
        tf2 = new JTextField(); 
        tf2.setBounds(140, 30, 100, 30); 
        add(tf2);
        tf3 = new JTextField(); 
        tf3.setBounds(250, 30, 100, 30); 
        add(tf3);

        JButton addBtn = new JButton("ADD");
        JButton updateBtn = new JButton("UPDATE");
        JButton deleteBtn = new JButton("DELETE");
        JButton displayBtn = new JButton("DISPLAY");
       
        JButton browseBtn = new JButton("Browse Image");
        browseBtn.setBounds(360, 30, 130, 30);
        add(browseBtn);

        browseBtn.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fc.getSelectedFile();
                    FileInputStream fis = new FileInputStream(file);
                    imageBytes = fis.readAllBytes();  // Convert to byte[]
                    fis.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        addBtn.setBounds(510, 20, 100, 30);
        updateBtn.setBounds(620, 20, 100, 30);
        deleteBtn.setBounds(730, 20, 100, 30);
        displayBtn.setBounds(840, 20, 100, 30);
        add(addBtn); 
        add(updateBtn); 
        add(deleteBtn); 
        add(displayBtn);
        
        model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
            public Class<?> getColumnClass(int column) {
                return column == 3 ? ImageIcon.class : Object.class;
            }
        };
		model.addColumn("Sno");
		model.addColumn("Name");
		model.addColumn("Fee");
		model.addColumn("Image");
        //model = new DefaultTableModel(new Object[]{"Sno", "Name", "Fee","Image"}, 0);
        table = new JTable(model);
        table.setRowHeight(30);
        //table.setDefaultRenderer(byte[].class, new JLabelCellenderer());
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(30, 80, 770, 400); 
        add(jsp);

        bll = new StudentBLL();
        
        

        addBtn.addActionListener(e -> {
            Studentinfo s = new Studentinfo();
            s.setId(Integer.parseInt(tf1.getText()));
            s.setName(tf2.getText());
            s.setFee(Double.parseDouble(tf3.getText()));
            s.setPhoto(imageBytes);
            if (bll.addStudent(s)) displayData();
        });

        updateBtn.addActionListener(e -> {
            Studentinfo s = new Studentinfo();
            s.setId(Integer.parseInt(tf1.getText()));
            s.setName(tf2.getText());
            s.setFee(Double.parseDouble(tf3.getText()));
            if (bll.updateStudent(s)) displayData();
        });

        deleteBtn.addActionListener(e -> {
            if (bll.deleteStudent(Integer.parseInt(tf1.getText()))) displayData();
        });

        displayBtn.addActionListener(e -> displayData());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                tf1.setText(model.getValueAt(row, 0).toString());
                tf2.setText(model.getValueAt(row, 1).toString());
                tf3.setText(model.getValueAt(row, 2).toString());
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void displayData() {
        model.setRowCount(0);
        List<Studentinfo> list = bll.getAllStudents();
        for (Studentinfo s : list) {
        	
        	Image img = Toolkit.getDefaultToolkit().createImage(s.getPhoto());
            Image scaled = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaled);
            model.addRow(new Object[]{s.getId(), s.getName(), s.getFee(),icon});
        }
        tf1.setText(""); 
        tf2.setText(""); 
        tf3.setText("");
        imageBytes=null;
    }

    public static void main(String[] args) {
        new Frontend();
    }
}
