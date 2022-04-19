import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.Point;

/**
 * A star that moves downward on the screen in front of a static
 * png of a ship, giving the illusion that the ship is moving.
 * 
 * @author Paul Brouillette
 * @version April 18, 2022
 */
public class Star extends Thread {
    int x, y;
    JComponent container;
    Random rand;
    Point upperLeft;
    boolean done;

    /**
     * Constructor for a {@code Star} object.
     * 
     * @param container The {@code JComponent} that the {@code Star} will be 
     * drawn in.
     */
    public Star(JComponent container) {
        this.container = container;
        rand = new Random();
        x = rand.nextInt(container.getWidth());
        y = 0;
        upperLeft = new Point(x, y);
        done = false;
    }

    /**
     * Represents the life of the {@code Star} object.
     */
    @Override
    public void run() {
        while (upperLeft.y < container.getHeight()) {
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            upperLeft.y += 1;
            container.repaint();
        }
        done = true;
    }

    /**
     * Draws the {@code Star} object as a white circle.
     * 
     * @param g The {@code Graphics} object that will be used to draw the
     * {@code Star} object.
     */
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(upperLeft.x, upperLeft.y, 10, 10);
    }

    /**
     * Returns whether or not the {@code Star} object has finished its life.
     * 
     * @return {@code true} if the {@code Star} object has finished its life,
     * {@code false} otherwise.
     */
    public boolean done() {
        return done;
    }
}
