package Taller_no_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Circle extends JFrame {

    private JTextArea areaResultArea, areaResultPerimeter;
    private int radius;

    public Circle(int radius) {
        this.radius = radius;

        setTitle("Circle");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        JButton buttonCalculateArea = new JButton("Calculate Area");
        buttonCalculateArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateArea();
            }
        });

        JButton buttonCalculatePerimeter = new JButton("Calculate Perimeter");
        buttonCalculatePerimeter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculatePerimeter();
            }
        });

        add(buttonCalculateArea);
        areaResultArea = new JTextArea();
        areaResultArea.setEditable(false);
        add(new JScrollPane(areaResultArea));

        add(buttonCalculatePerimeter);
        areaResultPerimeter = new JTextArea();
        areaResultPerimeter.setEditable(false);
        add(new JScrollPane(areaResultPerimeter));

        setVisible(true);
    }

    void calculateArea() {
        Double result = Math.PI * Math.pow(radius, 2);
        areaResultArea.setText("" + result);
    }

    void calculatePerimeter() {
        Double result = 2 * Math.PI * radius;
        areaResultPerimeter.setText("" + result);
    }
}
