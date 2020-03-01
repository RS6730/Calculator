import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class Calculator {
    JFrame frame; // Declare JFrame object
    JPanel panel; // Declare JPanel object
    JLabel label;

    JButton button0 = new JButton("0");
    JButton button_add = new JButton("+");
    JButton button_subtract = new JButton("-");
    JButton button_multiply = new JButton("*");
    JButton button_divide = new JButton("/");

    /**
     * Calculator is the constructor for Calculator.
     * Consists of all GUI elements
     */
    Calculator() {
        frame = new JFrame(); // Create the JFrame instance
        panel = new JPanel(); // Create the JPanel instance
        label = new JLabel();
        panel.setLayout(new GridLayout(3, 3));


        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setBackground(Color.CYAN);
            button.setForeground(Color.GRAY);
            button.setPreferredSize(new Dimension(95, 30));
            panel.add(button);
        }

        label.setBounds(0, 300, 50, 50);
        label.setText("Hi");
        label.setBackground(Color.GREEN);
        button0.setBounds(50, 100, 95, 30);

        frame.add(button0);
        frame.add(button_add);
        frame.add(button_subtract);
        frame.add(button_multiply);
        frame.add(button_divide);
        frame.add(label);

        frame.add(panel);
        frame.pack();

        frame.setSize(400, 400);
        frame.setLayout(null);


        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Calculator();
    }
}
