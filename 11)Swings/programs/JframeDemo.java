//used to create the button to display the hello message into the dialogpane
import javax.swing.*;
import java.awt.event.*;

class ButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		//System.out.println("hellooooooooo");
		JOptionPane.showMessageDialog(null,"Helloooooo");
	}
}

class Program
{
	public static void main(String args[])
	{
		JFrame	frm=new JFrame();
		ButtonListener listener=new ButtonListener();
		frm.setLayout(null);

		JButton	btn=new JButton("Ok");
		btn.addActionListener(listener);
		btn.setBounds(100,100,100,30);
		frm.add(btn);
		
		frm.setSize(500,500);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
