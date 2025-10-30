package finalProject;

import java.awt.*;

import javax.swing.*;

public class GameComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	
	// We can change these WIDTH and HEIGHT values to adjust the window size
	public static final int WIDTH = 800;
	public static final int HEIGHT = 400;
	Timer timer;
	
	public GameComponent() {
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
	    timer = new Timer(30, e-> {
	        });
    
	}

}
