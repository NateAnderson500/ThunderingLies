import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
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
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Graphics;

public class UserInterface implements Runnable {
    JFrame frame, shopFrame;
    JPanel mainPanel, currentTargetPanel, currentShipPanel, inputPanel, quadPanel;
    JButton mapButton, shipInventoryButton, currentQuestButton, fleetStatusButton, currentSystemButton,
            changePlanetButton, dockAtStationButton;
    JTextArea mainTextBox;
    JLabel planetPictureLabel;
    Shop shop;
    ArrayList<Star> stars;
    int r;
    Random rand = new Random();
    Scanner sc;
    PlanetSelector planetSelector;

    public void getRandomNumber() {
        r = rand.nextInt(40);
    }

    @Override
    public void run() {
        frame = new JFrame("Thundering Lies");
        frame.setSize(1225, 800);
        frame.setForeground(Color.BLACK);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        stars = new ArrayList<Star>();
        r = 0;

        mainTextBox = new JTextArea();
        mainTextBox.setPreferredSize(new Dimension(600, 400));
        mainTextBox.setLocation(0, 0);
        mainTextBox.setBackground(Color.BLUE);
        mainTextBox.setLineWrap(true);
        mainTextBox.setWrapStyleWord(true);
        mainTextBox.setFont(new Font("OCR A Extended", Font.BOLD, 30));
        try {
            mainTextBox.setText(printDialogue());
        } catch (FileNotFoundException e) {
            System.err.println("Cannot find txt file, " + Game.currentPlanet.getPlanetDialogueFile());
            e.printStackTrace();
        }
        frame.add(mainTextBox);

        

        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new File(Game.currentPlanet.getPlanetPicture()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image newResizedImage = bi.getScaledInstance(375, 375, Image.SCALE_SMOOTH);

        planetPictureLabel = new JLabel(new ImageIcon(newResizedImage));
        currentTargetPanel = new JPanel();
        currentTargetPanel.setPreferredSize(new Dimension(595, 400));
        frame.add(currentTargetPanel);
        currentTargetPanel.add(planetPictureLabel);
        currentTargetPanel.setBackground(Color.BLACK);

        currentShipPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (r == 0) {
                    Star s = new Star(currentShipPanel);
                    s.start();
                    stars.add(s);
                }
                int i = 0;
                while (i < stars.size()) {
                    Star star = stars.get(i);
                    if (star.done()) {
                        stars.remove(i);
                    } else {
                        star.paint(g);
                        i++;
                    }
                }
                g.drawImage(Game.currentShip.getShipImage(), 25, 0, null);
                getRandomNumber();
            }
        };
        currentShipPanel.setLayout(new SpringLayout());
        currentShipPanel.setPreferredSize(new Dimension(400, 400));
        currentShipPanel.setBackground(Color.BLACK);
        frame.add(currentShipPanel);

        inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(400, 400));
        inputPanel.setBackground(Color.GREEN);
        frame.add(inputPanel);

        //Change planet button
        changePlanetButton = new JButton("Change Planet");
        changePlanetButton.setPreferredSize(new Dimension(400, 100));
        changePlanetButton.setBackground(Color.GRAY);
        //changePlanetButton.setForeground(Color.WHITE);
        changePlanetButton.setFont(new Font("OCR A Extended", Font.BOLD, 30));
        changePlanetButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                planetSelector = new PlanetSelector();
                planetSelector.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        planetSelector.dispose();
                        frame.setVisible(true);
                        Star s = new Star(currentShipPanel);
                        s.start();
                        stars.add(s);
                        currentShipPanel.repaint();
                    }
                });
            }
        });
        inputPanel.add(changePlanetButton);

        //Dock at station button
        dockAtStationButton = new JButton("Dock at station");
        dockAtStationButton.setPreferredSize(new Dimension(400, 100));
        dockAtStationButton.setBackground(Color.GRAY);
        //dockAtStationButton.setForeground(Color.WHITE);
        dockAtStationButton.setFont(new Font("OCR A Extended", Font.BOLD, 30));
        inputPanel.add(dockAtStationButton);

        quadPanel = new JPanel(new FlowLayout());
        quadPanel.setPreferredSize(new Dimension(390, 400));
        frame.add(quadPanel);

        shipInventoryButton = new JButton("Ship Inventory");
        shipInventoryButton.setPreferredSize(new Dimension(390, 82));
        shipInventoryButton.setBackground(Color.PINK);
        shipInventoryButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = { "Sounds good to me!" };
                JOptionPane.showOptionDialog(frame,
                        Game.inventory.toString(),
                        "Inventory",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        options[0]);
            }
        });

        quadPanel.add(shipInventoryButton);

        currentQuestButton = new JButton("Current Quest");
        currentQuestButton.setPreferredSize(new Dimension(390, 82));
        currentQuestButton.setBackground(Color.PINK);
        quadPanel.add(currentQuestButton);

        fleetStatusButton = new JButton("Fleet Status");
        fleetStatusButton.setPreferredSize(new Dimension(390, 82));
        fleetStatusButton.setBackground(Color.PINK);
        fleetStatusButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                shop = new Shop(Game.currentPlanet.getName());
                shop.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        shop.dispose();
                        frame.setVisible(true);
                        Star s = new Star(currentShipPanel);
                        s.start();
                        stars.add(s);
                        currentShipPanel.repaint();
                    }
                });
            }
        });
        quadPanel.add(fleetStatusButton);

        currentSystemButton = new JButton("Current System");
        currentSystemButton.setPreferredSize(new Dimension(390, 82));
        currentSystemButton.setBackground(Color.PINK);
        currentSystemButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Game.currentPlanet.toString(), "Current System",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
        quadPanel.add(currentSystemButton);

        mapButton = new JButton("Map");
        mapButton.setPreferredSize(new Dimension(75, 75));
        mapButton.setBackground(Color.PINK);
        mapButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage image = null;
                try {
                    image = ImageIO.read(new File("assets/misc/planetsColor.png"));
                } catch (IOException e1) {
                    System.err.println("Cannot find the map image");
                    e1.printStackTrace();
                }
                JLabel picLabel = new JLabel(new ImageIcon(image));
                JOptionPane.showMessageDialog(null, picLabel, "Map",
                        JOptionPane.PLAIN_MESSAGE, null);
            }
        });
        currentShipPanel.add(mapButton);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Game.saveGame.save(Game.currentPlanet.getName(), 0);
            }
        });
    }

    public String printDialogue() throws FileNotFoundException {
        try {
            sc = new Scanner(new File(Game.currentPlanet.getPlanetDialogueFile()));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot find the dialogue file titled: " + Game.currentPlanet.getPlanetDialogueFile());
            e.printStackTrace();
        }
        String s = sc.nextLine();
        return s;
    }
}