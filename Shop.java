import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import inventory_system.Inventory;
import inventory_system.Item;

/**
 * A shop where {@code Item} objects can be bought and sold. An
 * extension off of {@code UserInterface}, a {@code Shop} is accessed
 * by pressing a button in UserInterface.
 * 
 * @author Paul Brouillette
 * @version April 17, 2022
 * @see UserInterface
 * @see Item
 * @see Inventory
 */
public class Shop extends JFrame {
    Inventory playerInventory = Game.inventory;
    public Inventory shopItems;
    public String planetName;
    private JComboBox<String> shopItemBox, playerItemBox;
    private JLabel shopLabel, playerLabel, playerMoneyLabel;
    private JButton buyButton, sellButton;
    private JPanel shopItemsPanel, playerItemsPanel, bottomPanel, subBottomPanel;

    /**
     * Constructor for Shop. Initializes the shop's inventory with a certain file
     * established through code passed in through {@code UserInterface}.
     * 
     * @param planetName The name of the planet the shop is on. Used to determine
     *                   which file to read from.
     * @see UserInterface
     */
    public Shop(String planetName) {
        setLayout(new BorderLayout());
        setTitle(planetName + " Shop");
        this.planetName = planetName;
        setSize(600, 600);
        shopItems = new Inventory();

        // SET UP THE BUYING SIDE ON THE LEFT
        shopItemsPanel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(shopItemsPanel, BoxLayout.Y_AXIS);
        shopLabel = new JLabel("Shop Items:");
        shopItemsPanel.add(shopLabel);
        shopItemsPanel.setLayout(boxlayout);
        add(shopItemsPanel, BorderLayout.WEST);
        shopItemBox = new JComboBox<String>();
        try {
            populateShopItems();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        shopItemsPanel.add(shopItemBox);
        buyButton = new JButton("Buy Item");
        buyButton.addActionListener(new AbstractAction() {
            /**
             * When the buy button is pressed, the item in the shopItems box is added to the
             * player's inventory,
             * money is deducted, and playerItems box is updated.
             * 
             * @param e The action event from which information is taken.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Item item = shopItems.getItem(shopItemBox.getSelectedIndex() + 1);
                if (playerInventory.getFunds() - item.getBuyPrice() >= 0) {
                    playerInventory.addItem(item);
                    playerInventory.addFunds((int) (-item.getBuyPrice()));
                } else {
                    JOptionPane.showMessageDialog(null, "You can't afford that item!");
                }
                playerMoneyLabel.setText("Money: $" + playerInventory.getFunds());
                populatePlayerItems();
            }
        });
        shopItemsPanel.add(buyButton);

        // SET UP THE SELLING SIDE ON THE RIGHT
        playerItemsPanel = new JPanel();
        boxlayout = new BoxLayout(playerItemsPanel, BoxLayout.Y_AXIS);
        playerLabel = new JLabel("Player Items:");
        playerItemsPanel.add(playerLabel);
        playerItemsPanel.setLayout(boxlayout);
        add(playerItemsPanel, BorderLayout.EAST);
        sellButton = new JButton("Sell Item");
        playerItemBox = new JComboBox<String>();
        populatePlayerItems();
        playerItemsPanel.add(playerItemBox);
        sellButton.addActionListener(new AbstractAction() {
            /**
             * When the sell button is pressed, the item in the playerItems box is removed
             * from the player's inventory,
             * funds are added, and the playerItems box is updated.
             * 
             * @param e The action event from which information is taken.
             */
            public void actionPerformed(ActionEvent e) {
                if (playerInventory.getSize() == 1) {
                    JOptionPane.showMessageDialog(null, "You don't have any items to sell!");
                } else {
                    Item item = playerInventory.getItem(playerItemBox.getSelectedIndex() + 1);
                    playerInventory.addFunds((int) (item.getSellPrice()));
                    playerInventory.removeItem(item.getName(), 1);
                    playerMoneyLabel.setText("Money: $" + playerInventory.getFunds());
                    populatePlayerItems();
                }
            }
        });
        playerItemsPanel.add(sellButton);

        // SET UP THE BOTTOM PANEL WITH MONEY
        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(100, 80));
        bottomPanel.setLayout(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        subBottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(subBottomPanel, BorderLayout.SOUTH);
        playerMoneyLabel = new JLabel();
        playerMoneyLabel.setText("Money: $" + playerInventory.getFunds());
        subBottomPanel.add(playerMoneyLabel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * From a file depending on what planet the player is currently on, this method
     * will populate the shopItems
     * box with specific items that are found on that planet.
     * 
     * @throws FileNotFoundException If the file, "shop_inventory/nameOfPlanet.txt"
     *                               is not found.
     */
    public void populateShopItems() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("shops/" + planetName + "Shop.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] splitLine = line.split(" ");
            Item i = new Item(splitLine[0], Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]));
            shopItemBox.addItem(i.getName() + ": $" + i.getBuyPrice());
            shopItems.addItem(i);
        }
    }

    /**
     * Updates the playerItemsBox whenever a new or more of an existing item is
     * added
     * to the player's inventory.
     */
    public void populatePlayerItems() {
        playerItemBox.removeAllItems();
        for (int i = 0; i < playerInventory.getSize(); i++) {
            Item item = playerInventory.getItem(i);
            if (!item.getName().equals("Money")) {
                playerItemBox
                        .addItem(item.getQuantity() + " " + item.getName() + ": $" + item.getSellPrice() + " each");
            }
        }
    }
}
