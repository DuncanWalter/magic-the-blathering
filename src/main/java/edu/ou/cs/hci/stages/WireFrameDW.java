package edu.ou.cs.hci.stages;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class WireFrameDW {

	private static Font font = new Font(Font.SERIF, Font.ITALIC, 36);
	private static Color fillColor = Color.WHITE;
	private static Color edgeColor = Color.decode("#444444");

	private static String message;

	public static void main(String[] args){
		message = "Build Test";

		JFrame frame = new JFrame("Magic The Blatherring");
		JPanel panel = new HelloPanel(message);

		frame.setBounds(50, 50, 600, 600);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private static final class HelloPanel extends JPanel {

		private final String message;

		public HelloPanel(String message){
			this.message = message != null ? message : "";
		}

		public HelloPanel(){
			this("");
		}

		public void	paintComponent(Graphics g){

			FontMetrics	fm = g.getFontMetrics(font);
			int	fw = fm.stringWidth(message);
			int	fh = fm.getMaxAscent() + fm.getMaxDescent();
			int	x = (getWidth() - fw) / 2;
			int	y = (getHeight() - fh) / 2;
			Rectangle r = new Rectangle(x, y, fw + 4, fh + 1);

			if (fillColor != null){
				g.setColor(fillColor);
				g.fillRect(r.x, r.y, r.width - 1, r.height - 1);
			}

			if (edgeColor != null){
				g.setColor(edgeColor);
				g.drawRect(r.x, r.y, r.width - 1, r.height - 1);

				g.setFont(font);
				g.drawString(message, r.x + 2, r.y + fm.getMaxAscent());
			}
		}
	}
}

