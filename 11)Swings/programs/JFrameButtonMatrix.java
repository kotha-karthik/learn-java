// Implementing the matrix of frames with 5 rows and 5 columns by button and it give the response according to the button
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class ButtonEvent implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		String actionCommand = e.getActionCommand();
		JOptionPane.showMessageDialog(null,actionCommand);
	}
}
class JFrameDemo
{
	public static void main(String args[])
	{
		JFrame frm=new JFrame();
		int count=1;
		ButtonEvent listener=new ButtonEvent();
		frm.setLayout(null);
		JButton btn;
		frm.setSize(500,500);
		int x=0,y=0;
		for(int i=0;i<5;i++)
		{
			x=x+100;
			y=100;
			for(int j=0;j<5;j++)
			{
				btn=new JButton("Btn "+count);
				btn.setBounds(x,y,100,50);
				btn.setActionCommand("Btn"+count);
				btn.addActionListener(listener);
				frm.add(btn);
				count++;
				y=y+50;
			}
		}
		frm.pack();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
