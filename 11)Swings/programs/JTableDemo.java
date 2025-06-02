import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.*;

class TableMouseListener extends MouseAdapter
{
	JTable	table;
	public TableMouseListener(JTable table)
	{
		this.table=table;
	}
	public void mouseClicked(MouseEvent e)
	{
		int row=table.rowAtPoint(e.getPoint());
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		for(int i=0;i<3;i++)
		{
			System.out.print(dtm.getValueAt(row,i));
		}
		System.out.println();
	}
}

class JTableDemo extends JFrame
{
	JScrollPane	jsp;
	JTable		table;
	DefaultTableModel	model;

	public JTableDemo()
	{
		setSize(500,500);
		setVisible(true);
		model=new DefaultTableModel();
		model.addColumn("Sno");
		model.addColumn("Name");
		model.addColumn("Fee");
		
		model.addRow(new Object[]{1001,"Ravi",4500});
		model.addRow(new Object[]{1002,"Ramesh",7500});
		model.addRow(new Object[]{1003,"suresh",5500});


		table=new JTable(model);
		table.addMouseListener(new TableMouseListener(table));
		jsp=new JScrollPane(table);
		jsp.setBounds(50,50,350,350);		
		
		add(jsp);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[])
	{
		JTableDemo	jtd=new JTableDemo();
	}
}
