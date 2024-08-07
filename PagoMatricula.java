package Taller_no_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagoMatricula extends JFrame {

    private JTextField txtNumeroInscripcion, txtNombre, txtPatrimonio, txtEstrato;
    private JTextArea areaResultado;

    public PagoMatricula() {
        setTitle("Cálculo de Pago de Matrícula");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para los campos de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(5, 2, 10, 10));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelEntrada.add(new JLabel("Número de inscripción:"));
        txtNumeroInscripcion = new JTextField();
        panelEntrada.add(txtNumeroInscripcion);
        
        panelEntrada.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelEntrada.add(txtNombre);

        panelEntrada.add(new JLabel("Patrimonio:"));
        txtPatrimonio = new JTextField();
        panelEntrada.add(txtPatrimonio);

        panelEntrada.add(new JLabel("Estrato social:"));
        txtEstrato = new JTextField();
        panelEntrada.add(txtEstrato);

        JButton btnCalcular = new JButton("Calcular Pago");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPagoMatricula();
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
    
    private void calcularPagoMatricula() {
        try {
            double patrimonio = Double.parseDouble(txtPatrimonio.getText());
            int estratoSocial = Integer.parseInt(txtEstrato.getText());
            int numeroInscripcion = Integer.parseInt(txtNumeroInscripcion.getText());
            String nombre = txtNombre.getText();
            
            double pagoMatricula = 50000.0;
            if (patrimonio > 2000000 && estratoSocial > 3) {
                pagoMatricula += 0.03 * patrimonio;
            }
            
            String resultado = "El estudiante con número de inscripción: " + numeroInscripcion + 
                               "\nNombre: " + nombre + 
                               "\nDebe pagar: $" + pagoMatricula;
            areaResultado.setText(resultado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new PagoMatricula();
    }
}
