package edu.ou.cs.hci.stages;
//
//import edu.ou.cs.hci.resources.Resources;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Enumeration;
//import java.util.List;
//import javax.swing.*;
//import javax.swing.border.LineBorder;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//import javax.swing.filechooser.FileNameExtensionFilter;
//import javax.swing.text.AttributeSet;
//import javax.swing.text.SimpleAttributeSet;
//import javax.swing.text.StyleConstants;
//import javax.swing.text.StyleContext;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVPrinter;
//import org.apache.commons.csv.CSVRecord;
//
//
public final class Stage7
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
//    private JPanel libraryPanel;
//    private JPanel selectedPanel;
//    JTextField nameLabel;
//    JLabel picLabel;
//    JTextArea descriptionArea;
//    JTextPane loreText;
//    GridBagConstraints c;
//    Card editingCard;
//    boolean unsaved = false;
//
//    public static void main(String[] args)
//    {
//        Stage7 stage7 = new Stage7();
//        JFrame frame = stage7.getUI();
//        frame.pack();
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        // set closing behavior
//        frame.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                stage7.quit.doClick();
//            }
//        });
//    }
//
//    private JFrame getUI(){
//        group = new ButtonGroup();
//        searchButton = new JButton();
//        jComboBox = new JComboBox<>(new String[]{"Type1", "Type2", "Type3"});
//        JFrame frame = new JFrame("Magic!");
//        frame.setPreferredSize(new Dimension(1500, 900));
//        frame.setSize(new Dimension(1500, 900));
//        // set main layout
//        frame.setLayout(new GridBagLayout());
//        frame.setJMenuBar(getMenuBar());
//        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//        c = new GridBagConstraints();
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
//        c.weightx = 3;
//        c.gridwidth = 3;
//        //Middle pane
//        frame.add(getLibraryLayout(), c);
//        //Right pane
//        c.gridx = GridBagConstraints.RELATIVE;
//        c.gridwidth = 1;
//        c.weightx  = 1;
//        this.frame = frame;
//        return frame;
//    }
//
//    private JMenuBar getMenuBar() {
//        menuBar = new JMenuBar();
//        open.addActionListener(event -> importCSV());
//        fileMenu.add(open);
//        save.addActionListener(event -> saveAlert(false));
//        fileMenu.add(save);
//        fileMenu.add(print);
//        quit.addActionListener((event) ->{
//            quitAlert();
//        });
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
//    private void saveAlert(boolean quitAfter) {
//        JFileChooser fileChooser = new JFileChooser();
//        int val = fileChooser.showOpenDialog(frame);
//        if(val == JFileChooser.APPROVE_OPTION){
//            File file = fileChooser.getSelectedFile().getAbsoluteFile();
//            if(file.exists()){
//                JOptionPane.showMessageDialog(null, "Cannot overwrite existing files!");
//            }else{
//                System.out.println("Save like normal");
//                try{
//                    FileWriter writer = new FileWriter(file);
//                    CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withRecordSeparator("\n"));
//                    for(Component c : libraryPanel.getComponents()){
//                        if(c instanceof  Card) {
//                            List<String> cardList = new ArrayList<>();
//                            cardList.add(((Card) c).name);
//                            cardList.add(((Card) c).manaString);
//                            cardList.add(((Card) c).descText);
//                            cardList.add(((Card) c).flavorText);
//                            cardList.add(((Card) c).type);
//                            cardList.add(((Card) c).path);
//                            System.out.println("Printed line");
//                            csvPrinter.printRecord(cardList);
//                        }
//                    }
//                    writer.flush();
//                    writer.close();
//                    csvPrinter.close();
//                    JOptionPane.showMessageDialog(null, "Save successful!");
//                    unsaved = false;
//                    if(quitAfter){
//                        System.exit(0);
//                    }
//                }catch (IOException e){
//                    System.out.println("Failed");
//                    e.printStackTrace();
//                    JOptionPane.showMessageDialog(null, "Error saving!");
//                }
//            }
//        }
//    }
//
//    private void quitAlert() {
//        if(unsaved){
//            String[] buttons = { "Exit Anyway", "Cancel", "Save and Quit" };
//            int returnValue = JOptionPane.showOptionDialog(null, "You have unsaved changes! Would you like to save?", "Quit",
//                    JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[0]);
//            System.out.println(returnValue);
//            if(returnValue == 0){
//                System.exit(0);
//            }
//            if(returnValue == 1){
//                System.out.println("User continues working");
//            }
//            if(returnValue == 2){
//                //attempt save and quit
//                saveAlert(true);
//            }
//        }else{
//            System.exit(0);
//        }
//    }
//
//    private void importCSV(){
//        JFileChooser chooser = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                "CSV", "csv");
//        chooser.setFileFilter(filter);
//        int returnVal = chooser.showOpenDialog(frame);
//        if(returnVal == JFileChooser.APPROVE_OPTION) {
//            File file = chooser.getSelectedFile().getAbsoluteFile();
//            if(selectedPanel == null)
//                frame.add(getSelectedCardLayout(), c);
//
//            try {
//                InputStream is = file.toURI().toURL().openStream();
//                InputStreamReader isr = new InputStreamReader(is);
//                BufferedReader r = new BufferedReader(isr);
//                for (CSVRecord record : CSVFormat.DEFAULT.parse(r)) {
//                    Card card = new Card(record.get(0), record.get(1), record.get(2), record.get(3), record.get(4), record.get(5));
//                    card.addMouseListener(new MouseListener() {
//                        @Override
//                        public void mouseClicked(MouseEvent e) {
//                            editingCard = card;
//                            nameLabel.setText(card.getName());
//                            loreText.setText(card.getFlavorText());
//                            descriptionArea.setText(card.getDescText());
//                            picLabel.setIcon(card.icon);
//                        }
//
//                        @Override
//                        public void mousePressed(MouseEvent e) {
//
//                        }
//
//                        @Override
//                        public void mouseReleased(MouseEvent e) {
//
//                        }
//
//                        @Override
//                        public void mouseEntered(MouseEvent e) {
//
//                        }
//
//                        @Override
//                        public void mouseExited(MouseEvent e) {
//
//                        }
//                    });
//                    libraryPanel.add(card);
//                }
//            } catch (IOException | ArrayIndexOutOfBoundsException e) {
//                System.out.println("Failed importing data!");
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Unable to import CSV! " + e.toString());
//            }
//        }
//        frame.setVisible(false);
//        frame.pack();
//        frame.setVisible(true);
//
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
//        libraryPanel = new JPanel();
//        libraryPanel.setLayout(new GridLayout(0, 4, 10, 10));
//        return new JScrollPane(libraryPanel);
//    }
//
//    private JScrollPane getSelectedCardLayout(){
//        selectedPanel = new JPanel();
//        selectedPanel.setLayout(new BoxLayout(selectedPanel, BoxLayout.Y_AXIS));
//        // title for selected card
//        nameLabel = new JTextField();
//        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        nameLabel.setMaximumSize(new Dimension(315, 40));
//        nameLabel.addActionListener(event -> {
//            editingCard.setName(nameLabel.getText());
//            unsaved = true;
//        });
//        nameLabel.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                changedUpdate(e);
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                changedUpdate(e);
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                if(editingCard == null)
//                    return;
//                editingCard.setName(nameLabel.getText());
//                unsaved = true;
//            }
//        });
//        selectedPanel.add(nameLabel);
//        picLabel = new JLabel();
//        picLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        selectedPanel.add(picLabel);
//        descriptionArea = new JTextArea();
//        descriptionArea.setEditable(true);
//        descriptionArea.setLineWrap(true);
//        descriptionArea.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                changedUpdate(e);
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                changedUpdate(e);
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                if(editingCard == null)
//                    return;
//                editingCard.setDescText(descriptionArea.getText());
//                unsaved = true;
//            }
//        });
//        descriptionArea.setAlignmentX(Component.LEFT_ALIGNMENT);
//        descriptionArea.setMaximumSize(new Dimension(315, 500));
//        descriptionArea.setForeground(Color.ORANGE);
//
//        loreText = new JTextPane();
//        loreText.setEditable(true);
//        loreText.setMaximumSize(new Dimension(315, 1000));
//        loreText.setAlignmentX(Component.LEFT_ALIGNMENT);
//        loreText.setBorder(new LineBorder(Color.black, 1));
//        StyleContext sc = StyleContext.getDefaultStyleContext();
//        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.black);
//        loreText.setCharacterAttributes(aset, true);
//        loreText.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//             changedUpdate(e);
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                changedUpdate(e);
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                if(editingCard == null)
//                    return;
//                editingCard.setFlavorText(loreText.getText());
//                unsaved = true;
//                System.out.println("Changed");
//            }
//        });
//        selectedPanel.add(descriptionArea);
//        selectedPanel.add(loreText);
//        return new JScrollPane(selectedPanel);
//    }
}
