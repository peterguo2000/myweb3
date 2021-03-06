package com.dbwatcher.dbwatcherdbconfig;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.Color;

public class DBConfig {
    private static JTextArea inputTextArea1;
    private static JTextArea inputTextArea2;
    private static JTextArea inputTextArea3;

    public static void main(String[] args) {
        new DBConfig();
    }

    public DBConfig() {
        SwingUtilities.invokeLater(this::showFrame);
    }

    private void showFrame() {
        inputTextArea1 = new javax.swing.JTextArea();
        inputTextArea1.setEditable(false);
        inputTextArea1.setColumns(30);
        inputTextArea1.setLineWrap(true);
        inputTextArea1.setRows(1);
        inputTextArea1.setWrapStyleWord(true);
        inputTextArea1.setText("jdbc:mysql://localhost:3306/pdfparse?autoReconnect=true");
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

        JFrame frame = new JFrame("DB Config ");
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
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static class ConfirmButton extends JButton {
		private static final long serialVersionUID = 1L;

		ConfirmButton(JFrame frame, final String text) {
            super(text);
            setPreferredSize(new Dimension(140, 60));
            addActionListener((e) -> {
            	String port = "server.port = 8090" + "\n";
            	String dbURL= "spring.datasource.url = " + inputTextArea1.getText() + "\n"; 
            	String dbUserName= "spring.datasource.username =" + inputTextArea2.getText() + "\n";
            	String dbPassword= "spring.datasource.password =" + inputTextArea3.getText() + "\n";
            	String dbDriver= "spring.datasource.driverClassName = com.mysql.jdbc.Driver" + "\n";
            	String dbJPAOption= "spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl"+ "\n";
            	
            	String content = port + dbURL + dbUserName + dbPassword + dbDriver + dbJPAOption;
            	ConfigFileWriter.appendToFile("./application.properties", content);
            frame.dispose();
            });
        }
    }
}
