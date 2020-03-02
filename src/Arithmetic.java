import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.script.*;


/**
 * Class Arithmetic is the Calculator class which opens a Swing GUI when run. It handles
 * integer input from 0 to 9 with add, subtract, multiply and divide operations. Text output
 * can be cleared to restart a new calculation.
 * @author Raj Silari
 */
public class Arithmetic {

    /*
     Initialise all swing objects
     */
    JFrame frame = new JFrame();
    JButton[] buttons = new JButton[10];
    JButton add = new JButton("+");
    JButton subtract = new JButton("-");
    JButton multiply = new JButton("*");
    JButton divide = new JButton("/");
    JButton clear = new JButton("Clear");
    JButton equal = new JButton("=");
    JPanel panel = new JPanel();
    JLabel label = new JLabel();

    /**
     * Constructor arithmetic sets the action events for all objects,
     * text fields and calibrates the grid layout of the buttons and
     * panels.
     */
    Arithmetic() {

        /**
         * Initialise all buttons with numbers. Set the action event to be
         * filling the text field "label".
         */
        for (int i = 0; i < 10; i++) {
            int finalI = i;

            buttons[i] = new JButton(String.valueOf(i));
            frame.add(buttons[i]);

            buttons[i].addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent actionEvent) {
                    label.setText(label.getText() + String.valueOf(finalI));
                }

            });

        }

        /**
         * Set action event for the button add.
         */
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText(label.getText() + " + ");
            }
        });

        /**
         * Set action event for the button subtract.
         */
        subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText(label.getText() + " - ");
            }
        });

        /**
         * Set action event for the button multiply.
         */
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText(label.getText() + " * ");
            }
        });

        /**
         * Set action event for the button divide.
         */
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText(label.getText() + " / ");
            }
        });

        /**
         * Set action event for the button Clear -- clear label.
         */
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText("");
            }
        });

        /**
         * Set action event for the button equal -- handles all
         * arithmetic logic.
         */
        equal.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent actionEvent) {
                // Use ScriptEngineManager to do a string eval.

                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("js");

                try {
                    Object result = engine.eval(label.getText());

                    // Add the result to the existing result.
                    label.setText(label.getText() + " = " + Integer.toString((Integer) result));
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
            }

        });



        // Set the layout for all the buttons.
        buttons[0].setBounds(25, 100, 65, 30);
        buttons[1].setBounds(100, 100, 65, 30);
        buttons[2].setBounds(175, 100, 65, 30);
        buttons[3].setBounds(25, 135, 65, 30);
        buttons[4].setBounds(100, 135, 65, 30);
        buttons[5].setBounds(175, 135, 65, 30);
        buttons[6].setBounds(25, 170, 65, 30);
        buttons[7].setBounds(100, 170, 65, 30);
        buttons[8].setBounds(175, 170, 65, 30);
        buttons[9].setBounds(100, 205, 65, 30);

        add.setBounds(25, 205, 65, 30);
        subtract.setBounds(175, 205, 65, 30);
        multiply.setBounds(25, 240, 65, 30);
        divide.setBounds(175, 240, 65, 30);
        equal.setBounds(100, 240, 65, 30);
        clear.setBounds(100, 275, 65, 30);

        // Set the layout for the label.
        label.setText("");
        label.setFont(new Font("Verdana", Font.PLAIN, 18));
        label.setBounds(0, 15, 280, 60);
        label.setForeground(Color.WHITE);

        // Set the layout for the panel.
        panel.setBounds(0, 15, 280, 60);
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.WHITE);
        panel.add(label);
        frame.add(panel);

        // Add all objects to the frame.
        frame.add(add);
        frame.add(subtract);
        frame.add(multiply);
        frame.add(divide);
        frame.add(equal);
        frame.add(clear);

        // Start the frame.
        frame.setSize(280, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) { new Arithmetic(); }
}
