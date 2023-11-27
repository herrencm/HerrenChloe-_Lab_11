package recursivelister;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RecursiveListerGUI extends JFrame {

    private JTextArea fileListArea;

    public RecursiveListerGUI() {
        setTitle("Recursive File Lister");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Recursive File Lister");
        add(titleLabel, BorderLayout.NORTH);

        fileListArea = new JTextArea(20, 50);
        JScrollPane scrollPane = new JScrollPane(fileListArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton startButton = new JButton("Select Directory");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedDirectory = fileChooser.getSelectedFile();
                    listFiles(selectedDirectory);
                }
            }
        });
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void listFiles(File directory) {
        fileListArea.setText(""); // Clear previous content
        FileLister fileLister = new FileLister();
        fileListArea.append(fileLister.listFiles(directory));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RecursiveListerGUI();
            }
        });
    }
}


