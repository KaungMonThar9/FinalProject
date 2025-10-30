package finalProject;

import java.awt.*;

import javax.swing.*;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final GameComponent canvas = new GameComponent();
	Timer timer;
	
	public GamePanel() {
    	this.setLayout(new BorderLayout(8, 8));
        this.add(canvas, BorderLayout.CENTER);
        //this.setBackground(canvas.BG);
        //this.add(buildControls(), BorderLayout.SOUTH);
        //this.buildKeys();

	    timer = new Timer(30, e-> tick());
    }
	
	
	/**
	 * Runs every frame
	 */
	private void tick() {
		
		// The last thing so we can see everything visually move
		canvas.repaint();
	}
}
