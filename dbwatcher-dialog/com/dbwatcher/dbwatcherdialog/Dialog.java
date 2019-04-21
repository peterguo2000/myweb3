package com.dbwatcher.dbwatcherdialog;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Dialog {

    private static int count = 1;
    private static JFrame lastFrame = null;
    private static JTextArea inputTextArea1;
    private static JTextArea inputTextArea2;
    private static JTextArea inputTextArea3;

    public static void main(String[] args) {
        new Dialog();
    }

    public Dialog() {
        SwingUtilities.invokeLater(this::showFrame);
    }

    private void showFrame() {
        inputTextArea1 = new javax.swing.JTextArea();
        inputTextArea1.setEditable(true);
        inputTextArea1.setColumns(30);
        inputTextArea1.setLineWrap(true);
        inputTextArea1.setRows(1);
        inputTextArea1.setWrapStyleWord(true);
        inputTextArea1.setBackground(Color.lightGray);

        inputTextArea2 = new javax.swing.JTextArea();
        inputTextArea2.setEditable(true);
        inputTextArea2.setColumns(10);
        inputTextArea2.setLineWrap(true);
        inputTextArea2.setRows(1);
        inputTextArea2.setWrapStyleWord(true);
        inputTextArea2.setBackground(Color.yellow);

        inputTextArea3 = new javax.swing.JTextArea();
        inputTextArea3.setEditable(true);
        inputTextArea3.setColumns(20);
        inputTextArea3.setLineWrap(true);
        inputTextArea3.setRows(1);
        inputTextArea3.setWrapStyleWord(true);
        inputTextArea3.setBackground(Color.lightGray);

        JFrame frame = new JFrame("Beeper " + count++);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(5,35));
        frame.add(new JLabel("DB URL: "));
        frame.add(inputTextArea1);
        frame.add(new JLabel("DB User Name: "));
        frame.add(inputTextArea2);
        frame.add(new JLabel("DB Password: "));
        frame.add(inputTextArea3);
        frame.add(new ConfirmButton(frame, "OK"));

        frame.pack();
       // if (lastFrame == null) {
          //  frame.setLocationByPlatform(true);
       // } else {
       //     Point p = lastFrame.getLocation();
       //     p.translate(50, 50);
       //     frame.setLocation(p);
      //  }
     //   lastFrame = frame;
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static class ConfirmButton extends JButton {
        ConfirmButton(JFrame frame, final String text) {
            super(text);
            setPreferredSize(new Dimension(140, 60));
            addActionListener((e) -> {
System.out.println("+++++++++++++++++ DB URL: " + inputTextArea1.getText()  + "  DB UserName: " + inputTextArea2.getText() + " DB password: " + inputTextArea3.getText());
            frame.dispose();
            });
        }
    }
}
