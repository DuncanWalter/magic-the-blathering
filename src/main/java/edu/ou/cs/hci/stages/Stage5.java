package edu.ou.cs.hci.stages;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import javax.swing.*;


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
	public static void main(String[] args)
	{
		Stage5 stage5 = new Stage5();
		JFrame frame = stage5.getUI();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set closing behavior
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setVisible(true);
				int returnValue = jFileChooser.showOpenDialog(frame);
				BufferedWriter bw = null;
				FileWriter fw = null;
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					String FILENAME = jFileChooser.getSelectedFile().getAbsolutePath();
					try {
						String content = "Button Group: " + stage5.getSelectedButtonText(stage5.group);
						content += "\nTypes: " + stage5.jComboBox.getSelectedItem();
						content += "\nSearch Field: " + stage5.searchField.getText();
						content += "\nSelected Mana: ";
						if(stage5.manaBox1.isSelected()) content += stage5.manaBox1.getText() +" ";
						if(stage5.manaBox2.isSelected()) content += stage5.manaBox2.getText() + " ";
						if(stage5.manaBox3.isSelected()) content += stage5.manaBox3.getText() + " ";
						if(stage5.manaBox4.isSelected()) content += stage5.manaBox4.getText();

						fw = new FileWriter(FILENAME);
						bw = new BufferedWriter(fw);
						bw.write(content);

						System.out.println("Done");

					} catch (IOException t) {

						t.printStackTrace();

					} finally {

						try {

							if (bw != null)
								bw.close();

							if (fw != null)
								fw.close();

						} catch (IOException ex) {

							ex.printStackTrace();

						}

					}
				}
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
}