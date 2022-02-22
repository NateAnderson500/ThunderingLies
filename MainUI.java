import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The file that contains the main UI Elements of Thundering Lies
 * 
 * @author Nate Anderson
 * @version Alpha Build 0.1
 */

 public class MainUI implements Runnable, ActionListener, ItemListener, ChangeListener {
    private JTextArea Maintext;
    
    @Override
    public void run() {
        // sets the look of the window
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        // gives the frame a name and dimensions
        JFrame frame = new JFrame("ThunderingLies");
        frame.setPreferredSize(new Dimension(800, 425));

        // tells the program to terminate when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel framePanel = new JPanel(new BorderLayout());
        frame.add(framePanel);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JScrollPane scrollFrame = new JScrollPane();
        Maintext = new JTextArea(10, 50);

        Maintext.setEditable(false);
        scrollFrame.add(Maintext);
        scrollFrame.setViewportView(Maintext);
        Maintext.add(scrollFrame);

        framePanel.add(Maintext, BorderLayout.NORTH);

     /**
     * main method to construct our object and launch a thread
     * to run it.
     * 
     * @param args not used
     */
    public static void main(String args[]) {

        // The main method is responsible for creating a thread that
        // will construct and show the graphical user interface.
        javax.swing.SwingUtilities.invokeLater(new MainUI());
    }
    }
 }