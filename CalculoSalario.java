package Taller_no_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculoSalario extends JFrame {

    private JTextField txtSalarioHora, txtNombre, txtHorasTrabajadasMes;
    private JTextArea areaResultado;

    public CalculoSalario() {
        setTitle("Cálculo de Salario");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para los campos de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(4, 2, 10, 10));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelEntrada.add(new JLabel("Salario por hora:"));
        txtSalarioHora = new JTextField();
        panelEntrada.add(txtSalarioHora);

        panelEntrada.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelEntrada.add(txtNombre);

        panelEntrada.add(new JLabel("Horas trabajadas al mes:"));
        txtHorasTrabajadasMes = new JTextField();
        panelEntrada.add(txtHorasTrabajadasMes);

        JButton btnCalcular = new JButton("Calcular Salario");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularSalario();
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

    private void calcularSalario() {
        try {
            double salarioPorHora = Double.parseDouble(txtSalarioHora.getText());
            double horasTrabajadasMes = Double.parseDouble(txtHorasTrabajadasMes.getText());
            String nombre = txtNombre.getText();

            double salario = salarioPorHora * horasTrabajadasMes;
            String resultado;
            if (salario > 450000) {
                resultado = "Nombre: " + nombre + "\nSalario: " + salario;
            } else {
                resultado = "Nombre: " + nombre;
            }

            areaResultado.setText(resultado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new CalculoSalario();
    }
}
