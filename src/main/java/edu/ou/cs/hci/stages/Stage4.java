package edu.ou.cs.hci.stages;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class Stage4
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Magic!");
		frame.setPreferredSize(new Dimension(900, 500));
		frame.setSize(new Dimension(900, 500));
		// set main layout
		frame.setLayout(new GridLayout(0, 3));

		//Left pane
		frame.add(getFilteringLayout());
		//Middle pane
		frame.add(getLibraryLayout());
		//Right pane
		frame.add(getSelectedCardLayout());

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set closing behavior
		frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
	}

	private static JPanel getFilteringLayout(){
		// first panel is for "filters"
		JPanel mainPanel = new JPanel();

		JPanel wrapperPanel = new JPanel();
		wrapperPanel.setLayout(new BoxLayout(wrapperPanel, BoxLayout.Y_AXIS));
		wrapperPanel.add(new JLabel("Filters", JLabel.CENTER));
		JPanel filtersPanel = new JPanel();

		filtersPanel.setLayout(new GridLayout(10, 0));

		for (int i = 0; i < 5; i++) {
			filtersPanel.add(new JCheckBox("Box " + i));
		}
		ButtonGroup group = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			JRadioButton tempButton = new JRadioButton("Button " + i);
			group.add(tempButton);
			filtersPanel.add(tempButton);
		}

		// a dropdown
		String[] dropdownStrings = new String[5];
		for (int i = 0; i < 5; i++) {
			dropdownStrings[i] = ("Option " + (i + 1));
		}
		filtersPanel.add(new JComboBox(dropdownStrings));
		wrapperPanel.add(filtersPanel);
		return wrapperPanel;
	}

	private static JScrollPane getLibraryLayout(){
		// main/central library panel
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

	private static JPanel getSelectedCardLayout(){
		// panel to display information about currently selected card
		JPanel selectedPanel = new JPanel();
		selectedPanel.setLayout(new BoxLayout(selectedPanel, BoxLayout.Y_AXIS));


		// title for selected card
		JLabel selectedLabel = new JLabel("Selected Card");
		selectedPanel.add(selectedLabel);

		// details for selected card (just placeholder text for now)
		JTextArea descriptionArea = new JTextArea();
		descriptionArea.setEditable(false);
		descriptionArea.setLineWrap(true);
		descriptionArea.setText("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?");
		selectedPanel.add(descriptionArea);
		return selectedPanel;
	}
}

//******************************************************************************
