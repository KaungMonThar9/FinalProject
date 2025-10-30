package finalProject;

import java.awt.*;

import javax.swing.*;

public class GameComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private Background BG;
	
	// We can change these WIDTH and HEIGHT values to adjust the window size
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	public GameComponent() {
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		// I'll probably move the background related stuff to a level class
		this.BG = new Background("backgroundSunny.png");
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		BG.draw(g2);
	}
}
