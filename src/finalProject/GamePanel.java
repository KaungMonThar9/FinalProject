package finalProject;

import java.awt.*;

import javax.swing.*;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final GameComponent canvas = new GameComponent();
	
	public GamePanel() {
    	this.setLayout(new BorderLayout(8, 8));
        this.add(canvas, BorderLayout.CENTER);
        //this.setBackground(canvas.BG);
        //this.add(buildControls(), BorderLayout.SOUTH);
        //this.buildKeys();
    	
    }
}
