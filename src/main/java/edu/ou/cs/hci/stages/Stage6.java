package edu.ou.cs.hci.stages;
//import edu.ou.cs.hci.resources.Resources;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.util.Enumeration;
//import javax.swing.*;
//import javax.swing.border.LineBorder;
//import javax.swing.text.AttributeSet;
//import javax.swing.text.SimpleAttributeSet;
//import javax.swing.text.StyleConstants;
//import javax.swing.text.StyleContext;
//
//
public final class Stage6
{
//
//    private ButtonGroup group;
//    private JButton searchButton;
//    private JComboBox<String> jComboBox;
//    private JTextField searchField;
//    private final JCheckBox manaBox1 = new JCheckBox("1");
//    private final JCheckBox manaBox2 = new JCheckBox("2");
//    private final JCheckBox manaBox3 = new JCheckBox("3");
//    private final JCheckBox manaBox4 = new JCheckBox("4");
//
//    private JMenuBar menuBar;
//    private final JMenu fileMenu = new JMenu("File");
//    private final PrintingMenuItem open = new PrintingMenuItem("Open", "Opens a file");
//    private final PrintingMenuItem save = new PrintingMenuItem("Save", "Saves the state of the program");
//    private final PrintingMenuItem print = new PrintingMenuItem("Print", "Prints the contents of the screen");
//    private final PrintingMenuItem quit = new PrintingMenuItem("Quit", "Exits the program");
//
//    private final JMenu editMenu = new JMenu("Edit");
//    private final PrintingMenuItem cut = new PrintingMenuItem("Cut", "Cut a card for pasting");
//    private final PrintingMenuItem copy = new PrintingMenuItem("Copy", "Copy a card.");
//    private final PrintingMenuItem paste = new PrintingMenuItem("Paste", "Paste a card.");
//    private final PrintingMenuItem addCard = new PrintingMenuItem("Add Card", "Allows users to add cards to the card viewer", Resources.getImage("icons/add_doc_icon.png"));
//    private final PrintingMenuItem importCards = new PrintingMenuItem("Import Cards", "Allows users to import cards to the card viewer");
//    private final PrintingMenuItem removeCards = new PrintingMenuItem("Remove Card", "Allows users to remove cards from the card viewer");
//    private final JMenu collectionMenu = new JMenu("Collection");
//    private final PrintingMenuItem createCollection = new PrintingMenuItem("Create", "Creates a new collection of cards");
//    private final PrintingMenuItem deleteCollection = new PrintingMenuItem("Delete", "Deletes an existing collection", Resources.getImage("icons/trash_icon.png"));
//    private final PrintingMenuItem editCollection = new PrintingMenuItem("Edit", "Allows the user to edit an existing collection");
//    private final PrintingMenuItem importCollection = new PrintingMenuItem("Import", "Imports a collection", Resources.getImage("icons/import_icon.png"));
//    private final JMenu exportCollection = new JMenu("Export");
//    private final PrintingMenuItem toCSV = new PrintingMenuItem("To CSV", "Export option to export a collection as a CSV");
//    private final PrintingMenuItem toJSON = new PrintingMenuItem("To JSON", "Export option to export a collection as a JSON");
//
//    private final JMenu helpMenu = new JMenu("Help");
//    private final PrintingMenuItem magicWebsite = new PrintingMenuItem("Magic Website", "Sends the user to a website for MTG");
//    private final JMenu view = new JMenu("View");
//    private final PrintingMenuItem collection = new PrintingMenuItem("Collection", "Opens a collection window", Resources.getImage("icons/document_icon.png"));
//    private JFrame frame;
//
//    public static void main(String[] args)
//    {
//        Stage6 stage6 = new Stage6();
//        JFrame frame = stage6.getUI();
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        // set closing behavior
//        frame.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                stage6.quit.doClick();
//            }
//        });
//    }
//
//    private JFrame getUI(){
//        group = new ButtonGroup();
//        searchButton = new JButton();
//        jComboBox = new JComboBox<>(new String[]{"Type1", "Type2", "Type3"});
//        JFrame frame = new JFrame("Magic!");
//        frame.setPreferredSize(new Dimension(960, 900));
//        frame.setSize(new Dimension(960, 900));
//        // set main layout
//        frame.setLayout(new GridBagLayout());
//        frame.setJMenuBar(getMenuBar());
//        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//        GridBagConstraints c = new GridBagConstraints();
//        c.weightx = 1;
//        c.weighty = 1.0;
//        c.gridx = 0;
//        c.gridy = 0;
//        c.fill = GridBagConstraints.BOTH;
//        c.anchor = GridBagConstraints.PAGE_END;
//        c.ipady = 100;
//        //Left pane
//        frame.add(getFilteringLayout(), c);
//        c.gridx = 1;
//        c.gridwidth = 3;
//        //Middle pane
//        frame.add(getLibraryLayout(), c);
//        //Right pane
//        c.gridx = GridBagConstraints.RELATIVE;
//        c.gridwidth = 1;
//        frame.add(getSelectedCardLayout(), c);
//        this.frame = frame;
//        quit.addActionListener((event) ->{
//
//        });
//        return frame;
//    }
//
//    private JMenuBar getMenuBar() {
//        menuBar = new JMenuBar();
//        fileMenu.add(open);
//        fileMenu.add(save);
//        fileMenu.add(print);
//
//        fileMenu.add(quit);
//        menuBar.add(fileMenu);
//        editMenu.add(cut);
//        editMenu.add(copy);
//        editMenu.add(paste);
//        editMenu.add(new JSeparator());
//        editMenu.add(addCard);
//        editMenu.add(importCards);
//        editMenu.add(removeCards);
//
//        menuBar.add(editMenu);
//        collectionMenu.add(createCollection);
//        collectionMenu.add(deleteCollection);
//        collectionMenu.add(editCollection);
//        collectionMenu.add(new JSeparator());
//        collectionMenu.add(importCollection);
//        exportCollection.add(toCSV);
//        exportCollection.add(toJSON);
//        exportCollection.setIcon(Resources.getImage("icons/share_icon.png"));
//        collectionMenu.add(exportCollection);
//        menuBar.add(collectionMenu);
//
//        view.add(collection);
//        menuBar.add(view);
//        helpMenu.add(magicWebsite);
//        menuBar.add(helpMenu);
//
//        return menuBar;
//    }
//
//    private JScrollPane getFilteringLayout(){
//        JPanel wrapperPanel = new JPanel();
//        wrapperPanel.setLayout(new GridLayout(15, 1));
//        wrapperPanel.add(new JLabel("Filters"));
//
//        wrapperPanel.add(new JSeparator(JSeparator.HORIZONTAL));
//        wrapperPanel.add(new JLabel("Colors"));
//        JPanel colorPanel = new JPanel();
//        colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.Y_AXIS));
//        JPanel wrapperColorPanel = new JPanel();
//        wrapperColorPanel.setLayout(new GridLayout(2, 2));
//
//        JRadioButton redButton = new JRadioButton("Red");
//        redButton.setForeground(Color.RED);
//        JRadioButton blueButton = new JRadioButton("Blue");
//        blueButton.setForeground(Color.BLUE);
//        JRadioButton whiteButton = new JRadioButton("White");
//        JRadioButton greenButton = new JRadioButton("Green");
//        greenButton.setForeground(Color.GREEN);
//        group.add(redButton);
//        group.add(blueButton);
//        group.add(whiteButton);
//        group.add(greenButton);
//        redButton.setSelected(true);
//        wrapperColorPanel.add(redButton);
//        wrapperColorPanel.add(blueButton);
//        wrapperColorPanel.add(whiteButton);
//        wrapperColorPanel.add(greenButton);
//        colorPanel.add(wrapperColorPanel);
//        wrapperPanel.add(colorPanel);
//        wrapperPanel.add(new JSeparator(JSeparator.HORIZONTAL));
//        wrapperPanel.add(new JLabel("Mana Cost"));
//        JPanel manaPanel = new JPanel();
//        manaPanel.setLayout(new GridLayout(2, 2));
//        manaPanel.add(manaBox1);
//        manaPanel.add(manaBox2);
//        manaPanel.add(manaBox3);
//        manaPanel.add(manaBox4);
//        manaBox1.setSelected(true);
//
//        wrapperPanel.add(manaPanel);
//        wrapperPanel.add(new JSeparator(JSeparator.HORIZONTAL));
//        wrapperPanel.add(new JLabel("Types"));
//        wrapperPanel.add(jComboBox);
//        wrapperPanel.add(new JSeparator(JSeparator.HORIZONTAL));
//        wrapperPanel.add(new JLabel("Search By Name:"));
//        searchField = new JTextField();
//        wrapperPanel.add(searchField);
//        wrapperPanel.add(new JButton("Search!"));
//        return new JScrollPane(wrapperPanel);
//    }
//
//    private JScrollPane getLibraryLayout(){
//        JPanel panel = new JPanel();
//        JPanel libraryPanel = new JPanel();
//        libraryPanel.setLayout(new GridLayout(0, 4, 10, 10));
//
//        // add a whole bunch of dummy "cards" to the library panel
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 8; j++) {
//                Card card = new Card(Resources.getImage("img/19.jpg"), Card.getRandomColor());
//                libraryPanel.add(card);
//            }
//        }
//        return new JScrollPane(libraryPanel);
//    }
//    public String getSelectedButtonText(ButtonGroup buttonGroup) {
//        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
//            AbstractButton button = buttons.nextElement();
//
//            if (button.isSelected()) {
//                return button.getText();
//            }
//        }
//
//        return null;
//    }
//
//    private JScrollPane getSelectedCardLayout(){
//        JPanel selectedPanel = new JPanel();
//        selectedPanel.setLayout(new BoxLayout(selectedPanel, BoxLayout.Y_AXIS));
//        // title for selected card
//        JLabel selectedLabel = new JLabel("Aesthir Glider");
//        selectedLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        selectedPanel.add(selectedLabel);
//        ImageIcon image = Resources.getImage("img/19.jpg");
//        JLabel picLabel = new JLabel(image);
//        picLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        selectedPanel.add(picLabel);
//        JTextArea descriptionArea = new JTextArea();
//        descriptionArea.setEditable(false);
//        descriptionArea.setLineWrap(true);
//        descriptionArea.setText("Flying. Aesthir Glider cannot block.");
//        descriptionArea.setAlignmentX(Component.LEFT_ALIGNMENT);
//        descriptionArea.setMaximumSize(new Dimension(315, 500));
//        descriptionArea.setForeground(Color.ORANGE);
//
//        JTextPane loreText = new JTextPane();
//        loreText.setEditable(false);
//        loreText.setMaximumSize(new Dimension(315, 1000));
//        loreText.setAlignmentX(Component.LEFT_ALIGNMENT);
//        loreText.setBorder(new LineBorder(Color.black, 1));
//        StyleContext sc = StyleContext.getDefaultStyleContext();
//        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.black);
//        loreText.setCharacterAttributes(aset, true);
//        loreText.setText("A fine example of the rewards of artifice: a thoroughly obedient steed with tings of Soldevi steel. - Arcum Dagsson, Soldevi machinist");
//        selectedPanel.add(descriptionArea);
//        selectedPanel.add(loreText);
//        return new JScrollPane(selectedPanel);
//    }
}