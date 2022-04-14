import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.FlowLayout;
import java.awt.Font;

public class UserInterface implements Runnable {
    JFrame frame;
    JPanel mainPanel, currentTargetPanel, currentShipPanel, inputPanel, quadPanel;
    JButton mapButton, shipInventoryButton, currentQuestButton, fleetStatusButton, currentSystemButton;
    JTextArea mainTextBox;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new UserInterface());
    }

    @Override
    public void run() {
        frame = new JFrame("UI Test");
        frame.setSize(1225, 800);
        frame.setForeground(Color.BLACK);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        mainTextBox = new JTextArea();
        mainTextBox.setPreferredSize(new Dimension(600, 400));
        mainTextBox.setLocation(0, 0);
        mainTextBox.setBackground(Color.BLUE);
        mainTextBox.setLineWrap(true);
        mainTextBox.setWrapStyleWord(true);
        mainTextBox.setFont(new Font("OCR A Extended", Font.BOLD, 35));
        frame.add(mainTextBox);

        currentTargetPanel = new JPanel();
        currentTargetPanel.setPreferredSize(new Dimension(595, 400));
        frame.add(currentTargetPanel);
        currentTargetPanel.setBackground(Color.YELLOW);

        currentShipPanel = new JPanel(new SpringLayout());
        currentShipPanel.setPreferredSize(new Dimension(400, 400));
        currentShipPanel.setBackground(Color.GRAY);
        frame.add(currentShipPanel);

        inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(400, 400));
        inputPanel.setBackground(Color.GREEN);
        frame.add(inputPanel);

        quadPanel = new JPanel(new FlowLayout());
        quadPanel.setPreferredSize(new Dimension(390, 400));
        frame.add(quadPanel);

        shipInventoryButton = new JButton("Ship Inventory");
        shipInventoryButton.setPreferredSize(new Dimension(390, 82));
        shipInventoryButton.setBackground(Color.PINK);
        quadPanel.add(shipInventoryButton);

        currentQuestButton = new JButton("Current Quest");
        currentQuestButton.setPreferredSize(new Dimension(390, 82));
        currentQuestButton.setBackground(Color.PINK);
        quadPanel.add(currentQuestButton);

        fleetStatusButton = new JButton("Fleet Status");
        fleetStatusButton.setPreferredSize(new Dimension(390, 82));
        fleetStatusButton.setBackground(Color.PINK);
        quadPanel.add(fleetStatusButton);

        currentSystemButton = new JButton("Current System");
        currentSystemButton.setPreferredSize(new Dimension(390, 82));
        currentSystemButton.setBackground(Color.PINK);
        quadPanel.add(currentSystemButton);

        mapButton = new JButton("Map");
        mapButton.setPreferredSize(new Dimension(75, 75));
        mapButton.setBackground(Color.PINK);
        mapButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage image = null;
                try {
                    image = ImageIO.read(new File("PlanetsMap.png"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                JLabel picLabel = new JLabel(new ImageIcon(image));
                JOptionPane.showMessageDialog(null, picLabel, "Map",
                        JOptionPane.PLAIN_MESSAGE, null);
            }
        });
        currentShipPanel.add(mapButton);
    }
}
