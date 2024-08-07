package Taller_no_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MayorQue extends JFrame {

    private JTextField txtA, txtB;
    private JTextArea areaResultado;

    public MayorQue() {
        setTitle("Comparar Números");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para los campos de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 10, 10));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelEntrada.add(new JLabel("A:"));
        txtA = new JTextField();
        panelEntrada.add(txtA);

        panelEntrada.add(new JLabel("B:"));
        txtB = new JTextField();
        panelEntrada.add(txtB);

        JButton btnCalcular = new JButton("Calcular cuál es mayor");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                compararNumeros();
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

    private void compararNumeros() {
        try {
            double A = Double.parseDouble(txtA.getText());
            double B = Double.parseDouble(txtB.getText());
            String resultado;
            
            if (A > B) {
                resultado = "A es mayor que B";
            } else if (A < B) {
                resultado = "A es menor que B";
            } else {
                resultado = "A es igual a B";
            }

            areaResultado.setText(resultado);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new MayorQue();
    }
}
