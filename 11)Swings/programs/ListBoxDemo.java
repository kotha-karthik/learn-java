import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;

class ListBoxDemo extends JFrame implements ListSelectionListener
{
	JScrollPane 	jsp;
	JList<String>	listbox;
	String		[]items;
	DefaultListModel<String>	dlm;
	JTextField		tf;
	JButton			btn;
	public ListBoxDemo()
	{
		btn=new JButton("Add");
		btn.setBounds(200,150,100,30);

		

		tf=new JTextField();
		tf.setBounds(100,150,100,30);
		
		items=new String[]{"c","c++","Oracle","Python",".net","Sql-Server","Javascript","Angular"};
		dlm=new DefaultListModel<String>();
		setSize(500,500);
		setLayout(null);
		listbox=new JList<String>(dlm);
		listbox.addListSelectionListener(this);
		jsp=new JScrollPane(listbox);
		jsp.setBounds(100,50,100,100);

		/*btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dlm.addElement(tf.getText());
				tf.setText("");
			}
		});*/

		btn.addActionListener((e)->{
			dlm.addElement(tf.getText());
				tf.setText("");
		});

		add(btn);
		add(tf);
		add(jsp);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void valueChanged(ListSelectionEvent e)
	{
		if(!e.getValueIsAdjusting())
		{
			System.out.println(listbox.getSelectedValue());	
		}	
	}

	public static void main(String args[])
	{
		new ListBoxDemo();
	}
}

