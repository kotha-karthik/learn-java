import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.io.*;
class JdbcScroll extends JFrame
{
	private JTextField tf1, tf2, tf3;
    private JButton First, prev, next, last;
	private Connection con;
    private Statement stmt;
    private ResultSet rs;
	public JdbcScroll()
	{
		setSize(1000, 600);
		setLayout(null);
		tf1=new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf1.setBounds(30, 20, 100, 30);
		tf2.setBounds(140, 20, 100, 30);
		tf3.setBounds(250, 20, 100, 30);
		add(tf1); 
		add(tf2); 
		add(tf3);
		First = new JButton("First");
		prev = new JButton("prev");
		next = new JButton("next");
		last = new JButton("last");

		First.setBounds(510, 20, 100, 30);
		prev.setBounds(620, 20, 100, 30);
		next.setBounds(730, 20, 100, 30);
		last.setBounds(840, 20, 100, 30);

		add(First); 
		add(prev); 
		add(next); 
		add(last);
		// --- Database Connection ---
        try {
            con = DriverManager.getConnection(
                "jdbc:sqlserver://localhost\\sqlexpress;databaseName=pratice;integratedSecurity=true;encrypt=true;trustServerCertificate=true"
            );
			//setting's
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM pratice"); 

            if (rs.next()) {
                displayRow();
            }

            First.addActionListener(e -> {
                try {
                    if (rs.first())
					{ 
						displayRow();
					
					}
                } catch (SQLException ex) { ex.printStackTrace(); }
            });

            prev.addActionListener(e -> {
                try {
                    if (!rs.isFirst() && rs.previous()) 
					{
						displayRow();
					}
                } catch (SQLException ex) { ex.printStackTrace(); }
            });

            next.addActionListener(e -> {
                try {
                    if (!rs.isLast() && rs.next()) 
					{	
						displayRow();
					}
                } catch (SQLException ex) { ex.printStackTrace(); }
            });

            last.addActionListener(e -> {
                try {
                    if (rs.last()) 
					{
						displayRow();
					}
                } catch (SQLException ex) { ex.printStackTrace(); }
            });

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!");
        }

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void displayRow() {
        try {
            tf1.setText(rs.getString(1));
            tf2.setText(rs.getString(2));
            tf3.setText(rs.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String args[])
	{
		new JdbcScroll();
	}
}
