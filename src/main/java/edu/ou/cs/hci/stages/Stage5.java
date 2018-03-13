package edu.ou.cs.hci.stages;
import edu.ou.cs.hci.resources.Resources;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.KeyStroke;


public final class Stage5
{

    ButtonGroup group;
    JButton searchButton;
    JComboBox<String> jComboBox;
    JTextField searchField;
    JCheckBox manaBox1 = new JCheckBox("1");
    JCheckBox manaBox2 = new JCheckBox("2");
    JCheckBox manaBox3 = new JCheckBox("3");
    JCheckBox manaBox4 = new JCheckBox("4");

    // a few actions...
    protected menuAction openAction, saveAction, printAction, exitAction, cutAction, copyAction, pasteAction, importAction,
            removeAction, createCAction, deleteCAction, importCAction, exportCCSVAction, exportCJSONAction, viewCAction,
            viewRecentAction, helpLinkAction, editCAddAction, editCRemoveAction;

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;
    public static void main(String[] args)
    {
        System.out.println("Application running!");
        Stage5 stage5 = new Stage5();
        JFrame frame = stage5.getUI();
        frame.setJMenuBar(stage5.getMenuBar());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set closing behavior
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Exiting by window button.");
                stage5.exitAction();
            }
        });
    }

    public JFrame getUI(){
        group = new ButtonGroup();
        searchButton = new JButton();
        jComboBox = new JComboBox<>(new String[]{"Type1", "Type2", "Type3"});
        JFrame frame = new JFrame("Magic!");
        frame.setPreferredSize(new Dimension(960, 900));
        frame.setSize(new Dimension(960, 900));
        // set main layout
        frame.setLayout(new GridLayout(0, 3));

        //Left pane
        frame.add(getFilteringLayout());
        //Middle pane
        frame.add(getLibraryLayout());
        //Right pane
        frame.add(getSelectedCardLayout());
        return frame;
    }

    public void setupMenuActions() {
        openAction = new menuAction("Open", null, "opens a card collection", null);
        saveAction = new menuAction("Save", null, "saves the current card collection", null);
        printAction = new menuAction("Print", null, "prints the current card collection", null);
        exitAction = new menuAction("Exit", null, "exits the application", null);
        cutAction = new menuAction("Cut", null, "\"cuts\" the selected card to the clipboard", KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        copyAction = new menuAction("Copy", null, "copies the selected card to the clipboard", KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        pasteAction = new menuAction("Paste", null, "\"pastes\" the clipboard contents", KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        importAction = new menuAction("Import Cards", Resources.getImage("/edu/ou/cs/hci/resources/icons/import.png"), "imports cards from file", null);
        removeAction = new menuAction("Remove Cards", null, "removes cards from the collection", null);
        createCAction = new menuAction("Create Collection", null, "creates a new collection", null);
        deleteCAction = new menuAction("Delete Collection", Resources.getImage("/edu/ou/cs/hci/resources/icons/delete.png"), "deletes a collection", null);
        importCAction = new menuAction("Import Collection", null, "imports a collection from file", null);
        exportCCSVAction = new menuAction("To CSV", null, "exports the collection to a CSV formatted file", null);
        exportCJSONAction = new menuAction("To JSON", null, "exports the collection to a JSON formatted file", null);
        viewCAction = new menuAction("Collection", Resources.getImage("/edu/ou/cs/hci/resources/icons/view.png"), "view a different collection", null);
        viewRecentAction = new menuAction("Recent", null, "view a different, recently opened, collection", null);
        helpLinkAction = new menuAction("Official Page", null, "go to the official MtG page", null);
        editCAddAction = new menuAction("Add Card", Resources.getImage("/edu/ou/cs/hci/resources/icons/add.png"), "adds a card to the current collection", KeyStroke.getKeyStroke(KeyEvent.VK_F5, KeyEvent.CTRL_DOWN_MASK));
        editCRemoveAction = new menuAction("Remove Card", null, "removes a card from the current collection", KeyStroke.getKeyStroke(KeyEvent.VK_F9, KeyEvent.CTRL_DOWN_MASK));
    }

    public JMenuBar getMenuBar() {
        setupMenuActions();
        JMenuBar menuBar = new JMenuBar();

        // INDENTATION IS COSMETIC
        menuAction[] fileActions = {openAction, saveAction, printAction, exitAction};
        menuAction[] editActions = {cutAction, copyAction, pasteAction, importAction, removeAction};
            menuAction[] CActions = {createCAction, deleteCAction};
                menuAction[] editCActions = {editCAddAction, editCRemoveAction};
                menuAction[] exportCActions = {exportCCSVAction, exportCJSONAction};
        menuAction[] viewActions = {viewCAction, viewRecentAction};
        menuAction[] helpActions = {helpLinkAction};

        fileMenu = getMenu("File", fileActions);
        fileMenu.insertSeparator(3);
        menuBar.add(fileMenu);

        JMenu editMenu = getMenu("Edit", editActions);
        JMenu CMenu = getMenu("Collections", CActions);
        JMenu editCMenu = getMenu("Edit Collection", editCActions);
        JMenu exportCMenu = getMenu("Export Collection", exportCActions);
        CMenu.add(editCMenu);
        CMenu.add(exportCMenu);
        editMenu.add(CMenu);
        editMenu.insertSeparator(3);
        menuBar.add(editMenu);

        menuBar.add(getMenu("View", viewActions));

        menuBar.add(getMenu("Help", helpActions));

        return menuBar;
    }

    public JMenu getMenu(String title, menuAction[] actions) {
        JMenu tempMenu = new JMenu(title);
        JMenuItem menuItem;

        for (int i = 0; i < actions.length; i++) {
            menuItem = new JMenuItem(actions[i]);
            if (actions[i].getAccelerator() != null) {
                menuItem.setAccelerator(actions[i].getAccelerator());
            }
            tempMenu.add(menuItem);
        }
        return tempMenu;
    }

    private JScrollPane getFilteringLayout(){
        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new GridLayout(15, 1));
        wrapperPanel.add(new JLabel("Filters"));

        wrapperPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        wrapperPanel.add(new JLabel("Colors"));
        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.Y_AXIS));
        JPanel wrapperColorPanel = new JPanel();
        wrapperColorPanel.setLayout(new GridLayout(2, 2));

        JRadioButton redButton = new JRadioButton("Red");
        JRadioButton blueButton = new JRadioButton("Blue");
        JRadioButton whiteButton = new JRadioButton("White");
        JRadioButton greenButton = new JRadioButton("Green");
        group.add(redButton);
        group.add(blueButton);
        group.add(whiteButton);
        group.add(greenButton);
        redButton.setSelected(true);
        wrapperColorPanel.add(redButton);
        wrapperColorPanel.add(blueButton);
        wrapperColorPanel.add(whiteButton);
        wrapperColorPanel.add(greenButton);
        colorPanel.add(wrapperColorPanel);
        wrapperPanel.add(colorPanel);
        wrapperPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        wrapperPanel.add(new JLabel("Mana Cost"));
        JPanel manaPanel = new JPanel();
        manaPanel.setLayout(new GridLayout(2, 2));
        manaPanel.add(manaBox1);
        manaPanel.add(manaBox2);
        manaPanel.add(manaBox3);
        manaPanel.add(manaBox4);
        manaBox1.setSelected(true);

        wrapperPanel.add(manaPanel);
        wrapperPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        wrapperPanel.add(new JLabel("Types"));
        wrapperPanel.add(jComboBox);
        wrapperPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        wrapperPanel.add(new JLabel("Search By Name:"));
        searchField = new JTextField();
        wrapperPanel.add(searchField);
        wrapperPanel.add(new JButton("Search!"));
        return new JScrollPane(wrapperPanel);
    }

    private JScrollPane getLibraryLayout(){
        JPanel panel = new JPanel();
        JPanel libraryPanel = new JPanel();
        libraryPanel.setLayout(new GridLayout(0, 4));

        // add a whole bunch of dummy "cards" to the library panel
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                JButton tempButton = new JButton("Card");
                libraryPanel.add(tempButton);
            }
        }
        return new JScrollPane(libraryPanel);
    }
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    private JScrollPane getSelectedCardLayout(){
        JPanel selectedPanel = new JPanel();
        selectedPanel.setLayout(new BoxLayout(selectedPanel, BoxLayout.Y_AXIS));


        // title for selected card
        JLabel selectedLabel = new JLabel("Aesthir Glider");
        selectedLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        selectedPanel.add(selectedLabel);
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/edu/ou/cs/hci/img/19.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(image));
        picLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        selectedPanel.add(picLabel);
        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setText("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?");
        descriptionArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        descriptionArea.setMaximumSize(new Dimension(315, 1000));
        selectedPanel.add(descriptionArea);
        return new JScrollPane(selectedPanel);
    }

    public class menuAction extends AbstractAction {
        String actionName;
        String actionDesc;
        KeyStroke accel;
        public menuAction(String text, ImageIcon icon, String description, KeyStroke accelerator) {
            super(text, icon);
            actionName = text;
            actionDesc = description;
            accel = accelerator;
        }
        public void actionPerformed(ActionEvent e) {
            // couldn't figure out how to programmatically "click" menu items
            if (actionName == "Exit") {
                exitAction();
            } else {
                System.out.println("Button pressed: " + this.toString());
            }
        }
        public String toString() {
            return actionName = actionName + ", " + actionDesc;
        }
        public KeyStroke getAccelerator() {
            return accel;
        }
    }

    public void exitAction() {
        System.out.println("Button pressed: " + openAction.toString());
        System.out.println("Button pressed: " + saveAction.toString());
        System.out.println("Button pressed: " + printAction.toString());
        System.out.println("Button pressed: " + cutAction.toString());
        System.out.println("Button pressed: " + copyAction.toString());
        System.out.println("Button pressed: " + pasteAction.toString());
        System.out.println("Button pressed: " + importAction.toString());
        System.out.println("Button pressed: " + removeAction.toString());
        System.out.println("Button pressed: " + createCAction.toString());
        System.out.println("Button pressed: " + deleteCAction.toString());
        System.out.println("Button pressed: " + importCAction.toString());
        System.out.println("Button pressed: " + editCRemoveAction.toString());
        System.out.println("Button pressed: " + editCAddAction.toString());
        System.out.println("Button pressed: " + exportCCSVAction.toString());
        System.out.println("Button pressed: " + exportCJSONAction.toString());
        System.out.println("Button pressed: " + viewCAction.toString());
        System.out.println("Button pressed: " + viewRecentAction.toString());
        System.out.println("Button pressed: " + helpLinkAction.toString());
        System.exit(0);
    }
}