//browsing the image from files to display in the label
import javax.swing.*;
import java.awt.event.*;

class MyFrame extends JFrame
{
	JButton		btn;
	JLabel		lbl,imagelbl;
	JScrollPane	jsp;
	public MyFrame()
	{
		setSize(500,500);
		setLayout(null);
		lbl=new JLabel();
		lbl.setText("Select Image..");
		lbl.setBounds(100,100,100,30);
		imagelbl=new JLabel();
		jsp=new JScrollPane(imagelbl);
		jsp.setBounds(100,150,250,200);
		btn=new JButton("Browse");
		btn.setBounds(230,100,100,30);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				showDialog();
			}
		});
		add(btn);
		add(jsp);
		add(lbl);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void showDialog()
	{
		JFileChooser	jfc=new JFileChooser();
		int choice=jfc.showOpenDialog(this);
		if(choice==JFileChooser.APPROVE_OPTION)
		{
			String filepath=jfc.getSelectedFile().getPath();
			ImageIcon imageIcon=new ImageIcon(filepath);
			imagelbl.setIcon(imageIcon);
		}
	}

	public static void main(String args[])
	{
		new MyFrame();
	}
}
