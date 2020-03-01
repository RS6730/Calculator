import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.script.*;


public class Arithmetic {

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

    Arithmetic() {
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
        

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText(label.getText() + " + ");
            }
        });

        subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText(label.getText() + " - ");
            }
        });

        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText(label.getText() + " * ");
            }
        });

        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText(label.getText() + " / ");
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText("");
            }
        });

        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("js");
                try {
                    Object result = engine.eval(label.getText());
                    label.setText(label.getText() + " = " + Integer.toString((Integer) result));
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
            }
        });

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

        label.setText("");
        label.setFont(new Font("Verdana", Font.PLAIN, 18));
        label.setBounds(0, 15, 280, 60);
        label.setForeground(Color.WHITE);

        panel.setBounds(0, 15, 280, 60);
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.WHITE);
        panel.add(label);
        frame.add(panel);

        frame.add(add);
        frame.add(subtract);
        frame.add(multiply);
        frame.add(divide);
        frame.add(equal);
        frame.add(clear);

        frame.setSize(280, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Arithmetic();
    }
}
