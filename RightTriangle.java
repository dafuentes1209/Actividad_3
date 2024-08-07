package Taller_no_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightTriangle extends JFrame {

    private JTextArea areaResultArea, areaResultPerimeter, areaResultHypotenuse, areaResultTriangleType;
    private int base;
    private int height;

    public RightTriangle(int base, int height) {
        this.base = base;
        this.height = height;

        setTitle("Right Triangle");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

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

        JButton buttonCalculateHypotenuse = new JButton("Calculate Hypotenuse");
        buttonCalculateHypotenuse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateHypotenuse();
            }
        });

        JButton buttonDetermineTriangleType = new JButton("Determine Triangle Type");
        buttonDetermineTriangleType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                determineTriangleType();
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

        add(buttonCalculateHypotenuse);
        areaResultHypotenuse = new JTextArea();
        areaResultHypotenuse.setEditable(false);
        add(new JScrollPane(areaResultHypotenuse));

        add(buttonDetermineTriangleType);
        areaResultTriangleType = new JTextArea();
        areaResultTriangleType.setEditable(false);
        add(new JScrollPane(areaResultTriangleType));

        setVisible(true);
    }

    void calculateArea() {
        Double result = (double) (base * height / 2);
        areaResultArea.setText("" + result);
    }

    void calculatePerimeter() {
        Double result = base + height + calculateHypotenuseReturn();
        areaResultPerimeter.setText("" + result);
    }

    void calculateHypotenuse() {
        Double result = calculateHypotenuseReturn();
        areaResultHypotenuse.setText("" + result);
    }

    Double calculateHypotenuseReturn() {
        Double result = Math.sqrt(base * base + height * height);
        return result;
    }

    void determineTriangleType() {
        if ((base == height) && (base == calculateHypotenuseReturn()) && (height == calculateHypotenuseReturn())) {
            areaResultTriangleType.setText("It's an equilateral triangle");
        } else if ((base != height) && (base !=
