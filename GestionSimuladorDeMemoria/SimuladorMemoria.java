import javax.swing.SwingUtilities;

public class SimuladorMemoria {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new VentanaSimulador();
        });
    }
}