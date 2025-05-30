// This program is a simple text editor built using Java Swing that mimics basic functionality of Windows Notepad. It allows users to create, open, edit, and save text files through a graphical user interface.


import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class MyFrame extends JFrame {
    JMenuBar menubar;
    JMenu file, edit;
    JMenuItem nw, open, save, exit;
    JTextArea textArea;
    File currentFile = null;

    public MyFrame() {
        setSize(500, 500);
        menubar = new JMenuBar();
        file = new JMenu("File");

        
        nw = new JMenuItem("New");
        nw.addActionListener(e -> {
            textArea.setText("");
            currentFile = null;
            
        });

        
        open = new JMenuItem("Open");
        open.addActionListener(e -> {
            try {
                JFileChooser jfc = new JFileChooser();
                int choice = jfc.showOpenDialog(this);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    currentFile = jfc.getSelectedFile();
                    FileReader reader = new FileReader(currentFile);
                    char[] data = new char[(int) currentFile.length()];
                    reader.read(data);
                    reader.close();
                    textArea.setText(new String(data));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        
        save = new JMenuItem("Save");
        save.addActionListener(e -> {
            try {
                if (currentFile != null) {
                    FileWriter writer = new FileWriter(currentFile);
                    writer.write(textArea.getText());
                    writer.close();
                } else {
                    JFileChooser jfc = new JFileChooser();
                    int choice = jfc.showSaveDialog(this);
                    if (choice == JFileChooser.APPROVE_OPTION) {
                        currentFile = jfc.getSelectedFile();
                        FileWriter writer = new FileWriter(currentFile);
                        writer.write(textArea.getText());
                        writer.close();
                        
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        
        exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));

        
        file.add(nw);
        file.add(open);
        file.add(save);
        file.add(exit);

        edit = new JMenu("Edit");

        menubar.add(file);
        menubar.add(edit);
        setJMenuBar(menubar);

        textArea = new JTextArea();
        add(textArea);

        setTitle("Untitled - Notepad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

public class JMenuBarDemo {
    public static void main(String args[]) {
        new MyFrame();
    }
}
