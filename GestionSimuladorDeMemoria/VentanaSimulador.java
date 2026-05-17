import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
public class VentanaSimulador extends JFrame {

    private GestorMemoria gestor;
    private PanelMemoria panelMemoria;

    private JLabel lblDisponible;
    private JLabel lblProcesos;
    private JLabel lblUso;

    private JTextField txtEspacio;



    public VentanaSimulador() {

        gestor = new GestorMemoria();
        setTitle("Administrador de Memoria - Primer Ajuste");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245,245,245));


        // =============================
        // PANEL MEMORIA
        // =============================
        panelMemoria = new PanelMemoria(gestor);
        add(panelMemoria, BorderLayout.CENTER);

        // =============================
        // PANEL CONTROL
        // =============================
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(null);
        panelInferior.setPreferredSize(new Dimension(1000, 180));

        lblDisponible = new JLabel();
        lblDisponible.setBounds(40, 20, 300, 30);


        JLabel lblEspacio = new JLabel("Espacio (MB):");
        lblEspacio.setBounds(40, 70, 100, 30);

        txtEspacio = new JTextField();
        txtEspacio.setBounds(140, 70, 120, 30);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(280, 70, 100, 30);

        lblProcesos = new JLabel();
        lblProcesos.setBounds(40, 120, 180, 30);

        lblUso = new JLabel();
        lblUso.setBounds(250, 120, 250, 30);


        Font fuente = new Font("Segoe UI", Font.PLAIN, 16);

        lblDisponible.setFont(fuente);
        lblProcesos.setFont(fuente);
        lblUso.setFont(fuente);
        lblEspacio.setFont(fuente);

        txtEspacio.setFont(fuente);

        btnAgregar.setFont(
                new Font("Segoe UI", Font.BOLD, 15));

        panelInferior.add(lblDisponible);
        panelInferior.add(lblEspacio);
        panelInferior.add(txtEspacio);
        panelInferior.add(btnAgregar);
        panelInferior.add(lblProcesos);
        panelInferior.add(lblUso);


        add(panelInferior, BorderLayout.SOUTH);

        // =============================
        // EVENTO BOTÓN
        // =============================
        btnAgregar.addActionListener(e -> {

            try {

                int espacio = Integer.parseInt(txtEspacio.getText());

                boolean asignado = gestor.asignarProceso(espacio);

                if (!asignado) {

                    JOptionPane.showMessageDialog(this,
                            "No existe un bloque con suficiente espacio.");
                }


                actualizarDatos();
                panelMemoria.repaint();

                txtEspacio.setText("");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Ingrese un valor válido.");
            }
        });

        gestor.setOnUpdate(() -> {
            actualizarDatos();
            panelMemoria.repaint();
        });

        actualizarDatos();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void actualizarDatos() {

        lblDisponible.setText(
                "Memoria disponible: " +
                        gestor.getMemoriaLibre() + " MB");

        lblProcesos.setText(
                "Total de procesos: " +
                        gestor.getTotalProcesos());

        lblUso.setText(
                "Memoria en uso: " +
                        gestor.getMemoriaUsada() + " MB");
    }
}