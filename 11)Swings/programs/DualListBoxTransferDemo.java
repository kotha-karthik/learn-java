import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;

class ListBoxDemo extends JFrame implements ListSelectionListener {
    JScrollPane jsp, jsp1;
    JList<String> listbox, listbox1;
    DefaultListModel<String> dlm, dlm1;
    JTextField tf;
    JButton btn, btn1, btn2, btn3, btn4;

    public ListBoxDemo() {
        setSize(500, 500);
        setLayout(null);

        dlm = new DefaultListModel<>();
        dlm1 = new DefaultListModel<>();

        listbox = new JList<>(dlm);
        listbox1 = new JList<>(dlm1);
        listbox.addListSelectionListener(this);

        jsp = new JScrollPane(listbox);
        jsp1 = new JScrollPane(listbox1);
        jsp.setBounds(30, 50, 150, 150);
        jsp1.setBounds(300, 50, 150, 150);

        tf = new JTextField();
        tf.setBounds(150, 250, 100, 30);
        JLabel lblTo = new JLabel("Add Item's:");
        lblTo.setBounds(140, 230, 100, 25);

        btn = new JButton("Add");
        btn.setBounds(260, 250, 70, 30);

        btn1 = new JButton(">");
        btn1.setBounds(200, 60, 50, 30);

        btn2 = new JButton("<");
        btn2.setBounds(200, 100, 50, 30);

        btn3 = new JButton(">>");
        btn3.setBounds(200, 140, 50, 30);

        btn4 = new JButton("<<");
        btn4.setBounds(200, 180, 50, 30);

        btn.addActionListener(e -> {
            String item = tf.getText();
            if (!item.isEmpty()) {
                dlm.addElement(item);
                tf.setText("");
            }
        });

        btn1.addActionListener(e -> {
            String selected = listbox.getSelectedValue();
            if (selected != null) {
                dlm.removeElement(selected);
                dlm1.addElement(selected);
            }
        });

        btn2.addActionListener(e -> {
            String selected = listbox1.getSelectedValue();
            if (selected != null) {
                dlm1.removeElement(selected);
                dlm.addElement(selected);
            }
        });
        btn3.addActionListener(e -> {
            for (int i = 0; i < dlm.size(); i++) {
                dlm1.addElement(dlm.get(i));
            }
            dlm.clear();
        });

        btn4.addActionListener(e -> {
            for (int i = 0; dlm1.size()>0; i++) {
				System.out.println(dlm1.size());
                dlm.addElement(dlm1.get(0));
				dlm1.removeElementAt(0);
				
            }
            //dlm1.clear();
        });
        add(lblTo);
        add(tf);
        add(btn);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(jsp);
        add(jsp1);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            System.out.println(listbox.getSelectedValue());
        }
    }

    public static void main(String args[]) {
        new ListBoxDemo();
    }
}
