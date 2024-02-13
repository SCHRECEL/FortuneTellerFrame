import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JLabel titleLabel;
    private ImageIcon fortuneTellerImage;
    private JTextArea fortuneTextArea;
    private JButton readFortuneButton;
    private JButton quitButton;
    private JScrollPane scrollPane;
    private ArrayList<String> fortunes;
    private int previousFortuneIndex;
    private Font titleFont;
    private Font buttonFont;
    private Font fortuneFont;

    public FortuneTellerFrame() {
        super("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initializeComponents();
        loadFortunes();
        addComponentsToPanels();
        configureFrame();

        setSize(600, 600);
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        fortuneTellerImage = new ImageIcon("C:\\Users\\Earl\\IdeaProjects\\FortuneTellerFrame\\src\\fortune_teller.jpg");
        fortuneTellerImage.setImage(fortuneTellerImage.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        titleLabel.setIcon(fortuneTellerImage);

        fortuneTextArea = new JTextArea();
        scrollPane = new JScrollPane(fortuneTextArea);
        fortuneTextArea.setFont(new Font("Arial", Font.PLAIN, 18));

        readFortuneButton = new JButton("Read My Fortune");
        quitButton = new JButton("Quit");

        fortunes = new ArrayList<>();
        previousFortuneIndex = -1;

        titleFont = new Font("Arial", Font.BOLD, 48);
        buttonFont = new Font("Comic Sans", Font.PLAIN, 16);
        fortuneFont = new Font("Comic Sans", Font.PLAIN, 18);
    }
    private void loadFortunes() {
        fortunes.add("You will find an unlocked Kia in your area, bad fortune");
        fortunes.add("Follow the white rabbit");
        fortunes.add("Stop");
        fortunes.add("Go outside");
        fortunes.add("Rainbows and sunshine");
        fortunes.add("Ask again later");
        fortunes.add("One of us");
        fortunes.add("Crab people");
        fortunes.add("Don't dig straight down");
        fortunes.add("Also try minesweeper");
        fortunes.add("42");
        fortunes.add("W key");
        fortunes.add("qwerty");
    }
    private void addComponentsToPanels() {

        JPanel topPanel = new JPanel(new BorderLayout());
        titleLabel.setFont(titleFont);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        readFortuneButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    private void configureFrame() {

        readFortuneButton.addActionListener((ActionEvent e) -> {
            displayRandomFortune();
        });

        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }
    private void displayRandomFortune() {
        int randomIndex;
        do {
            randomIndex = new Random().nextInt(fortunes.size());
        } while (randomIndex == previousFortuneIndex);

        String randomFortune = fortunes.get(randomIndex);
        fortuneTextArea.append(randomFortune + "\n");

        previousFortuneIndex = randomIndex;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame fortuneTellerFrame = new FortuneTellerFrame();
            fortuneTellerFrame.setVisible(true);
        });
    }
}
