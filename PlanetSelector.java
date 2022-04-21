import javax.swing.JFrame;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Allows the user to select a {@code Planet} to travel to.
 * Used from the {@code UserInterface} class, i.e. it is called
 * when the user clicks the "Change Planet" button.
 * 
 * <p> Gets the one or two adjacent Planets to the current
 * planet and displays them as {@code JButton}s. The user can then
 * click on either one (or in some situations the only one) to change
 * planets.
 * <p>
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
    JButton planetLeft, planetRight;

    public PlanetSelector() {
        super("Planet Selector");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        ArrayList<String> planetNames = Game.currentPlanet.getAdjacentPlanetsArray();
        //If only one planet is adjacent, either Corvus or Artemisia, then only one JButton is needed
        if (planetNames.size() == 1) {
            planetLeft = new JButton(planetNames.get(0));
            planetLeft.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Game.currentPlanet = Game.arcadianSystem.getPlanet(planetLeft.getText());
                    dispose();
                    Game.ui.run();
                }
            });
            add(planetLeft);
        }
        //For most of the other planets, two JButtons are needed
        else {
            planetLeft = new JButton(planetNames.get(0));
            planetLeft.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Game.currentPlanet = Game.arcadianSystem.getPlanet(planetLeft.getText());
                    dispose();
                    Game.ui.run();
                }
            });
            planetRight = new JButton(planetNames.get(1));
            planetRight.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Game.currentPlanet = Game.arcadianSystem.getPlanet(planetRight.getText());
                    dispose();
                    Game.ui.run();
                }
            });
            add(planetLeft);
            add(planetRight);
        }
        pack();
    }
}
