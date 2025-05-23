// creates the frame with text input for the sum and display's the output
import javax.swing.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener
{
	private JTextField	tf1,tf2,tf3;
	private JButton		btn;

	public MyFrame()
	{	
		tf1=new JTextField();
		tf1.setBounds(100,50,100,30);
		tf2=new JTextField();
		tf2.setBounds(100,100,100,30);
		tf3=new JTextField();
		tf3.setBounds(100,150,100,30);
		btn=new JButton("Sum");
		btn.setBounds(100,200,100,30);
		btn.addActionListener(this);
		setSize(500,500);
		setLayout(null);
		add(tf1);
		add(tf2);
		add(tf3);
		add(btn);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e)
	{
		tf3.setText((Integer.parseInt(tf1.getText())+Integer.parseInt(tf2.getText()))+"");
	}
}

class program
{
	public static void main(String args[])
	{
		MyFrame		frm=new MyFrame();
	}
}
