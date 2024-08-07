package Taller_no_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrianguloInfo extends JFrame {

    private JTextField txtLado;
    private JTextArea areaResultado;

    public TrianguloInfo() {
        setTitle("Información del Triángulo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para los campos de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(2, 2, 10, 10));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelEntrada.add(new JLabel("Lado:"));
        txtLado = new JTextField();
        panelEntrada.add(txtLado);

        JButton btnCalcular = new JButton("Calcular Área, Perímetro y Altura");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTriangulo();
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

    private void calcularTriangulo() {
        try {
            double lado = Double.parseDouble(txtLado.getText());
            double perimetro = lado * 3;
            double altura = lado * Math.sqrt(3) / 2;
            double area = (lado * lado * Math.sqrt(3)) / 4;

            String resultado = "Altura: " + altura + 
                               "\nPerímetro: " + perimetro + 
                               "\nÁrea del Triángulo: " + area;
            
            areaResultado.setText(resultado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new TrianguloInfo();
    }
}
