package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator1 extends JFrame implements ActionListener {
    private JTextField tf;
    private JTextField tf2;
    private JTextField tf3;
    private int a;
    private int b;

    public Calculator1() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Create text fields
        tf = new JTextField(10);
        tf2 = new JTextField(10);
        tf3 = new JTextField(20);
        tf3.setEditable(false);

        // Create buttons
        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");

        // Add action listeners to the buttons
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        // Create panels
        JPanel inputPanel = new JPanel(new GridLayout(2, 1));
        inputPanel.add(tf);
        inputPanel.add(tf2);

        JPanel operatorPanel = new JPanel(new GridLayout(1, 4));
        operatorPanel.add(addButton);
        operatorPanel.add(subtractButton);
        operatorPanel.add(multiplyButton);
        operatorPanel.add(divideButton);

        JPanel resultPanel = new JPanel();
        resultPanel.add(tf3);

        // Add panels to the frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(operatorPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        a = Integer.parseInt(tf.getText());
        b = Integer.parseInt(tf2.getText());
        int res = 0;
        if (command.equals("+")) {
            res = a + b;
        } else if (command.equals("-")) {
            res = a - b;
        } else if (command.equals("*")) {
            res = a * b;
        } else if (command.equals("/")) {
            if (b != 0) {
                res = a / b;
            } else {
                // Handle division by zero error
                tf3.setText("Error: Division by zero");
                return;
            }
        }
        String ans = Integer.toString(res);
        tf3.setText(ans);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator1());
    }
}
