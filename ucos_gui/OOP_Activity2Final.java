package ucos_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OOP_Activity2Final extends JFrame {

    private JTextField num1Field;
    private JTextField num2Field;
    private JTextField resultField;
    private JButton addButton, subButton, mulButton, divButton, clearButton;

    public OOP_Activity2Final() {
    	getContentPane().setBackground(new Color(0, 0, 0));
        setTitle("OOP_Activity2Final");
        setSize(600, 400);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel label = new JLabel("Number 1:");
        label.setForeground(new Color(255, 255, 255));
        label.setBackground(new Color(128, 128, 128));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setBounds(1, 1, 146, 87);
        getContentPane().add(label);
        num1Field = new JTextField();
        num1Field.setForeground(new Color(248, 248, 255));
        num1Field.setBackground(Color.DARK_GRAY);
        num1Field.setFont(new Font("Tahoma", Font.PLAIN, 35));
        num1Field.setBounds(147, 1, 146, 87);
        getContentPane().add(num1Field);
        JLabel label_1 = new JLabel("Number 2:");
        label_1.setForeground(new Color(255, 255, 255));
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label_1.setBounds(293, 1, 146, 87);
        getContentPane().add(label_1);
        num2Field = new JTextField();
        num2Field.setForeground(new Color(248, 248, 255));
        num2Field.setBackground(Color.DARK_GRAY);
        num2Field.setFont(new Font("Tahoma", Font.PLAIN, 35));
        num2Field.setBounds(439, 1, 146, 87);
        getContentPane().add(num2Field);

        JLabel label_2 = new JLabel("Result:");
        label_2.setForeground(new Color(255, 255, 255));
        label_2.setBackground(new Color(128, 128, 128));
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        label_2.setBounds(1, 88, 146, 87);
        getContentPane().add(label_2);
        resultField = new JTextField();
        resultField.setForeground(new Color(255, 255, 255));
        resultField.setBackground(new Color(0, 0, 0));
        resultField.setFont(new Font("Tahoma", Font.PLAIN, 35));
        resultField.setHorizontalAlignment(SwingConstants.TRAILING);
        resultField.setBounds(147, 88, 438, 87);
        resultField.setEditable(false);
        getContentPane().add(resultField);

        addButton = new JButton("+");
        addButton.setForeground(new Color(255, 250, 250));
        addButton.setBackground(new Color(255, 165, 0));
        addButton.setFont(new Font("Tahoma", Font.BOLD, 35));
        addButton.setBounds(1, 175, 146, 87);
        getContentPane().add(addButton);
        subButton = new JButton("-");
        subButton.setForeground(new Color(255, 250, 250));
        subButton.setBackground(new Color(255, 165, 0));
        subButton.setFont(new Font("Tahoma", Font.BOLD, 35));
        subButton.setBounds(147, 175, 146, 87);
        getContentPane().add(subButton);
        mulButton = new JButton("×");
        mulButton.setForeground(new Color(255, 250, 250));
        mulButton.setBackground(new Color(255, 165, 0));
        mulButton.setFont(new Font("Tahoma", Font.BOLD, 35));
        mulButton.setBounds(293, 175, 146, 87);
        getContentPane().add(mulButton);
        divButton = new JButton("÷");
        divButton.setForeground(new Color(255, 250, 250));
        divButton.setBackground(new Color(255, 165, 0));
        divButton.setFont(new Font("Tahoma", Font.BOLD, 35));
        divButton.setBounds(439, 175, 146, 87);
        getContentPane().add(divButton);

        clearButton = new JButton("C");
        clearButton.setForeground(new Color(255, 250, 250));
        clearButton.setBackground(new Color(255, 165, 0));
        clearButton.setFont(new Font("Tahoma", Font.BOLD, 35));
        clearButton.setBounds(230, 266, 136, 87);  
        getContentPane().add(clearButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('+');
            }
        });

        subButton.addActionListener(e -> calculate('-'));
        mulButton.addActionListener(e -> calculate('*'));
        divButton.addActionListener(e -> calculate('/'));

        clearButton.addActionListener(e -> {
            num1Field.setText("");
            num2Field.setText("");
            resultField.setText("");
        });
    }

    private void calculate(char op) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("Undefined");
                    }
                    result = num1 / num2;
                    break;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            resultField.setText("Invalid input");
        } catch (ArithmeticException e) {
            resultField.setText(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new OOP_Activity2Final().setVisible(true);
        });
    }
}
