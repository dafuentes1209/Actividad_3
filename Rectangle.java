package Taller_no_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rectangle extends JFrame {

    private JTextArea areaResultArea, areaResultPerimeter;
    private int base;
    private int height;

    public Rectangle(int base, int height) {
        this.base = base;
        this.height = height;

        setTitle("Rectangle");
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
        Double result = (double) base * height;
        areaResultArea.setText("" + result);
    }

    void calculatePerimeter() {
        Double result = (double) (2 * base + 2 * height);
        areaResultPerimeter.setText("" + result);
    }
}
