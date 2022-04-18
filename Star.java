import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.Point;

public class Star extends Thread {
    int x, y;
    JComponent container;
    Random rand;
    Point upperLeft;
    boolean done;

    public Star(JComponent container) {
        this.container = container;
        rand = new Random();
        x = rand.nextInt(container.getWidth());
        y = 0;
        upperLeft = new Point(x, y);
        done = false;
    }

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

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(upperLeft.x, upperLeft.y, 10, 10);
    }

    public boolean done() {
        return done;
    }
}
