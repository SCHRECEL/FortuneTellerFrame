import javax.swing.SwingUtilities;

public class FortuneTellerDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame fortuneTellerFrame = new FortuneTellerFrame();
            fortuneTellerFrame.setVisible(true);
        });
    }
}
