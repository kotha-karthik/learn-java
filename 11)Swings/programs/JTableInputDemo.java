// which used to take the input from the testfiled with an add button when we click the add button these data is added to the table and when clicked to the data in the table which is added to the textfileds
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class TableMouseListener extends MouseAdapter {
    JTable table;
    JTextField tf1, tf2, tf3, tf4;

    public TableMouseListener(JTable table, JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4) {
        this.table = table;
        this.tf1 = tf1;
        this.tf2 = tf2;
        this.tf3 = tf3;
        this.tf4 = tf4;
    }

    public void mouseClicked(MouseEvent e) {
        int row = table.rowAtPoint(e.getPoint());
        if (row >= 0) {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            tf1.setText(dtm.getValueAt(row, 0).toString());
            tf2.setText(dtm.getValueAt(row, 1).toString());
            tf3.setText(dtm.getValueAt(row, 2).toString());
            tf4.setText(dtm.getValueAt(row, 3).toString());
        }
    }
}

class JTableInputDemo extends JFrame {
    private JTextField tf1, tf2, tf3, tf4;
    private JButton btn;
    private JScrollPane jsp;
    private DefaultTableModel model;
    private JTable table;

    public JTableInputDemo() {
        setSize(1000, 600);
        setLayout(null);
        tf1 = new JTextField();
        tf1.setBounds(30, 30, 100, 30);
        tf2 = new JTextField();
        tf2.setBounds(140, 30, 100, 30);
        tf3 = new JTextField();
        tf3.setBounds(250, 30, 100, 30);
        tf4 = new JTextField(); 
        tf4.setBounds(360, 30, 100, 30);
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);

        
        tf4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getAbsolutePath();
                    tf4.setText(path);
                }
            }
        });

        btn = new JButton("ADD");
        btn.setBounds(470, 30, 100, 30);
        add(btn);

        
        model = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 3) return ImageIcon.class;
                return String.class;
            }
        };

        model.addColumn("Sno");
        model.addColumn("Name");
        model.addColumn("Fee");
        model.addColumn("Image");

        table = new JTable(model);
        table.setRowHeight(80);
        jsp = new JScrollPane(table);
        jsp.setBounds(30, 80, 540, 350);
        add(jsp);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sno = tf1.getText();
                String name = tf2.getText();
                String fee = tf3.getText();
                String imgPath = tf4.getText();

                ImageIcon icon = new ImageIcon(imgPath);
                Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                icon = new ImageIcon(img);

                model.addRow(new Object[]{sno, name, fee, icon});

                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
            }
        });

        table.addMouseListener(new TableMouseListener(table, tf1, tf2, tf3, tf4));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JTableInputDemo();
    }
}
