package Taller_no_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpleadoInfo extends JFrame {

    private JTextField txtCodigo, txtNombre, txtHorasTrabajadas, txtValorHora, txtRetencion;
    private JTextArea areaResultado;

    public EmpleadoInfo() {
        
        setTitle("Información del Empleado");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para los campos de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(6, 2, 10, 10));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelEntrada.add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        panelEntrada.add(txtCodigo);

        panelEntrada.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelEntrada.add(txtNombre);

        panelEntrada.add(new JLabel("Horas trabajadas al mes:"));
        txtHorasTrabajadas = new JTextField();
        panelEntrada.add(txtHorasTrabajadas);

        panelEntrada.add(new JLabel("Valor por hora trabajada:"));
        txtValorHora = new JTextField();
        panelEntrada.add(txtValorHora);

        panelEntrada.add(new JLabel("Retención en la fuente (%):"));
        txtRetencion = new JTextField();
        panelEntrada.add(txtRetencion);

        JButton btnCalcular = new JButton("Calcular Salario");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularSalario();
            }
        });

        panelEntrada.add(btnCalcular);

        // Area de resultados
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
            int codigo = Integer.parseInt(txtCodigo.getText());
            String nombre = txtNombre.getText();
            double horasTrabajadas = Double.parseDouble(txtHorasTrabajadas.getText());
            double valorHora = Double.parseDouble(txtValorHora.getText());
            double retencion = Double.parseDouble(txtRetencion.getText()) / 100;

            double salarioBruto = valorHora * horasTrabajadas;
            double salarioNeto = salarioBruto - salarioBruto * retencion;

            String resultado = "Código: " + codigo + "\nNombre: " + nombre + 
                               "\nSalario bruto: " + salarioBruto + 
                               "\nSalario neto: " + salarioNeto;
            areaResultado.setText(resultado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new EmpleadoInfo();
    }
}

