import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.io.*;
import java.sql.*;

public class JTableSQLDemo extends JFrame {
    private JTextField tf1, tf2, tf3;
    private JButton addBtn, updateBtn, deleteBtn, displayBtn, chooseImageBtn;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane jsp;
    private File selectedImageFile = null;
    private Connection con;

    public JTableSQLDemo() {
        setTitle("Student Info with Image in JTable");
        setSize(1000, 600);
        setLayout(null);

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf1.setBounds(30, 20, 100, 30);
        tf2.setBounds(140, 20, 100, 30);
        tf3.setBounds(250, 20, 100, 30);
        add(tf1); add(tf2); add(tf3);

        chooseImageBtn = new JButton("Choose Image");
        chooseImageBtn.setBounds(360, 20, 140, 30);
        add(chooseImageBtn);

        addBtn = new JButton("ADD");
        updateBtn = new JButton("UPDATE");
        deleteBtn = new JButton("DELETE");
        displayBtn = new JButton("DISPLAY");

        addBtn.setBounds(510, 20, 100, 30);
        updateBtn.setBounds(620, 20, 100, 30);
        deleteBtn.setBounds(730, 20, 100, 30);
        displayBtn.setBounds(840, 20, 100, 30);

        add(addBtn); add(updateBtn); add(deleteBtn); add(displayBtn);

        model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) { return false; }
            public Class<?> getColumnClass(int column) {
                return column == 3 ? ImageIcon.class : Object.class;
            }
        };
        model.addColumn("Sno");
        model.addColumn("Name");
        model.addColumn("Fee");
        model.addColumn("Image");

        table = new JTable(model);
        table.setRowHeight(80);
        jsp = new JScrollPane(table);
        jsp.setBounds(30, 70, 930, 460);
        add(jsp);

        // --- Database Connection ---
        try {
            con = DriverManager.getConnection(
                "jdbc:sqlserver://localhost\\sqlexpress;databaseName=studentdb;integratedSecurity=true;encrypt=true;trustServerCertificate=true"
            );
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!");
        }

        // --- Choose Image ---
        chooseImageBtn.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedImageFile = chooser.getSelectedFile();
            }
        });

        // --- Add Button ---
        addBtn.addActionListener(e -> {
            try {
                int sno = Integer.parseInt(tf1.getText());
                String name = tf2.getText();
                double fee = Double.parseDouble(tf3.getText());

                PreparedStatement pstmt = con.prepareStatement("INSERT INTO studentinfo VALUES (?, ?, ?, ?)");
                pstmt.setInt(1, sno);
                pstmt.setString(2, name);
                pstmt.setDouble(3, fee);

                if (selectedImageFile != null) {
                    FileInputStream fis = new FileInputStream(selectedImageFile);
                    pstmt.setBinaryStream(4, fis, (int) selectedImageFile.length());
                } else {
                    pstmt.setNull(4, Types.BINARY);
                }

                pstmt.executeUpdate();
                displayData();
                clearFields();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Insert failed");
            }
        });

        // --- Update Button ---
        updateBtn.addActionListener(e -> {
            try {
                int sno = Integer.parseInt(tf1.getText());
                String name = tf2.getText();
                double fee = Double.parseDouble(tf3.getText());

                PreparedStatement pstmt = con.prepareStatement("UPDATE studentinfo SET sname=?, fee=?, photo=? WHERE sno=?");
                pstmt.setString(1, name);
                pstmt.setDouble(2, fee);

                if (selectedImageFile != null) {
                    FileInputStream fis = new FileInputStream(selectedImageFile);
                    pstmt.setBinaryStream(3, fis, (int) selectedImageFile.length());
                } else {
                    pstmt.setNull(3, Types.BINARY);
                }

                pstmt.setInt(4, sno);
                pstmt.executeUpdate();
                displayData();
                clearFields();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Update failed");
            }
        });

        // --- Delete Button ---
        deleteBtn.addActionListener(e -> {
            try {
                int sno = Integer.parseInt(tf1.getText());
                PreparedStatement pstmt = con.prepareStatement("DELETE FROM studentinfo WHERE sno=?");
                pstmt.setInt(1, sno);
                pstmt.executeUpdate();
                displayData();
                clearFields();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Delete failed");
            }
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
        try {
            model.setRowCount(0);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM StudentInfo");

            while (rs.next()) {
                int sno = rs.getInt("sno");
                String name = rs.getString("sname");
                double fee = rs.getDouble("fee");
                byte[] imgBytes = rs.getBytes("photo");

                ImageIcon icon = null;
                if (imgBytes != null) {
                    Image img = Toolkit.getDefaultToolkit().createImage(imgBytes);
                    Image scaled = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(scaled);
                }

                model.addRow(new Object[]{sno, name, fee, icon});
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Display failed");
        }
    }

    private void clearFields() {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        selectedImageFile = null;
    }

    public static void main(String[] args) {
        new JTableSQLDemo();
    }
}
