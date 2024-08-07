package Taller_no_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcuacionCuadratica extends JFrame {

    private JTextField txtA, txtB, txtC;
    private JTextArea areaResultado;

    public EcuacionCuadratica() {
        setTitle("Ecuación Cuadrática");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para los campos de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(4, 2, 10, 10));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelEntrada.add(new JLabel("Número A:"));
        txtA = new JTextField();
        panelEntrada.add(txtA);

        panelEntrada.add(new JLabel("Número B:"));
        txtB = new JTextField();
        panelEntrada.add(txtB);

        panelEntrada.add(new JLabel("Número C:"));
        txtC = new JTextField();
        panelEntrada.add(txtC);

        JButton btnCalcular = new JButton("Calcular Soluciones");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularEcuacion();
            }
        });
        panelEntrada.add(btnCalcular);

        // Área de resultados
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaResultado);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Añadir paneles al frame
        add(panelEntrada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void calcularEcuacion() {
        try {
            double A = Double.parseDouble(txtA.getText());
            double B = Double.parseDouble(txtB.getText());
            double C = Double.parseDouble(txtC.getText());

            double discriminante = B * B - 4 * A * C;
            String resultado;

            if (discriminante > 0) {
                double x1 = (-B + Math.sqrt(discriminante)) / (2 * A);
                double x2 = (-B - Math.sqrt(discriminante)) / (2 * A);
                resultado = "Las soluciones son x1 = " + x1 + " y x2 = " + x2;
            } else if (discriminante == 0) {
                double x = -B / (2 * A);
                resultado = "La solución es x = " + x;
            } else {
                double parteReal = -B / (2 * A);
                double parteImaginaria = Math.sqrt(-discriminante) / (2 * A);
                resultado = "Las soluciones son x1 = " + parteReal + " + " + parteImaginaria + "i y x2 = " + parteReal + " - " + parteImaginaria + "i";
            }

            areaResultado.setText(resultado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new EcuacionCuadratica();
    }
}
