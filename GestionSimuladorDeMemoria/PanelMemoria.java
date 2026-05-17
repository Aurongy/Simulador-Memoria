import javax.swing.*;
import java.awt.*;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelMemoria extends JPanel {

    private GestorMemoria gestor;

    public PanelMemoria(GestorMemoria gestor) {

        this.gestor = gestor;

        setBackground(new Color(245,245,245));
        setPreferredSize(new Dimension(950, 350));
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // suavizado
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        List<BloqueMemoria> bloques = gestor.getBloques();

        int x = 25;
        int y = 70;

        int ancho = 120;
        int alto = 90;

        // =============================
        // TITULO
        // =============================

        g2.setFont(new Font("Segoe UI", Font.BOLD, 26));
        g2.setColor(new Color(45,45,45));

        g2.drawString(
                "SIMULACIÓN DE MEMORIA - PRIMER AJUSTE",
                180,
                35);

        // =============================
        // DIBUJAR BLOQUES
        // =============================

        for (BloqueMemoria b : bloques) {

            // sombra
            g2.setColor(new Color(210,210,210));
            g2.fillRoundRect(
                    x + 4,
                    y + 4,
                    ancho,
                    alto,
                    18,
                    18);

            // fondo tarjeta
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(
                    x,
                    y,
                    ancho,
                    alto,
                    18,
                    18);

            // borde
            g2.setColor(new Color(180,180,180));
            g2.drawRoundRect(
                    x,
                    y,
                    ancho,
                    alto,
                    18,
                    18);

            // =============================
            // TITULO BLOQUE
            // =============================

            g2.setFont(new Font("Segoe UI", Font.BOLD, 16));
            g2.setColor(new Color(60,60,60));

            g2.drawString(
                    "Bloque " + b.getId(),
                    x + 20,
                    y + 25);

            // =============================
            // ESTADO
            // =============================

            if (b.isOcupado()) {

                g2.setColor(new Color(220,70,70));

                g2.fillRoundRect(
                        x + 20,
                        y + 35,
                        80,
                        25,
                        10,
                        10);

                g2.setColor(Color.WHITE);

                g2.setFont(new Font("Segoe UI", Font.BOLD, 14));

                g2.drawString(
                        "BUSY",
                        x + 38,
                        y + 52);

                // proceso
                g2.setColor(new Color(50,50,50));

                g2.setFont(new Font("Segoe UI", Font.PLAIN, 14));

                g2.drawString(
                        b.getProceso(),
                        x + 45,
                        y + 80);

            } else {

                g2.setColor(new Color(50,180,90));

                g2.fillRoundRect(
                        x + 20,
                        y + 35,
                        80,
                        25,
                        10,
                        10);

                g2.setColor(Color.WHITE);

                g2.setFont(new Font("Segoe UI", Font.BOLD, 14));

                g2.drawString(
                        "FREE",
                        x + 38,
                        y + 52);

                // memoria
                g2.setColor(new Color(50,50,50));

                g2.setFont(new Font("Segoe UI", Font.PLAIN, 14));

                g2.drawString(
                        b.getTamano() + " MB",
                        x + 35,
                        y + 80);
            }

            x += 145;

            // salto de línea
            if (x > 780) {

                x = 25;
                y += 120;
            }
        }
    }
}
