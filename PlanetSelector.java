import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Allows the user to select a {@code Planet} to travel to.
 * Used from the {@code UserInterface} class, i.e. it is called
 * when the user clicks the "Change Planet" button.
 * 
 * @author Paul Brouillette and Nathaniel Anderson
 * @version April 20, 2022
 * @see UserInterface
 * @see planetary_system.Planet
 */
public class PlanetSelector extends JFrame {
    protected JFrame frame;
    protected JPanel panel;
    protected JLabel mapLabel;
    protected JComboBox<String> planets;

    public PlanetSelector() {
        super("Planet Selector");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // BufferedImage image = null;
        // try {
        //     image = ImageIO.read(new File("assets/misc/planetsColor.png"));
        // } catch (IOException e1) {
        //     System.err.println("Cannot find the map image");
        //     e1.printStackTrace();
        // }
        // mapLabel = new JLabel(new ImageIcon(image));
        //add(mapLabel);

        planets = new JComboBox<String>();
        planets.addItem("Corvus");
        planets.addItem("Thantos");
        planets.addItem("New Terra");
        planets.addItem("Ligo");
        planets.addItem("Labyrinth");
        planets.addItem("Keres");
        planets.addItem("Aesop");
        planets.addItem("Uncas");
        planets.addItem("Abenaki");
        planets.addItem("Pollux");
        planets.addItem("Boreas");
        planets.addItem("Macintyre");
        planets.addItem("Vanu");
        planets.addItem("Gandash");
        planets.addItem("Artemisia");
        add(planets);

        JButton confirm = new JButton("Confirm");
        confirm.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String planet = (String) planets.getSelectedItem();
                Game.currentPlanet = Game.arcadianSystem.getPlanet(planet);
                dispose();
                Game.ui.run();
            }
        });
        add(confirm);
        pack();
    }
}
