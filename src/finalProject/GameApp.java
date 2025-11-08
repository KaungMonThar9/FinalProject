package finalProject;

import javax.swing.JFrame;

public class GameApp {
	private final JFrame frame = new JFrame("INSERT NAME HERE!");
	private final GamePanel panel = new GamePanel();
	
	/**
     * Constructs the main game window and attaches the {@link GamePanel}.
     * The window is configured but not made visible yet.
     */
	public GameApp() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();                  // Fit to preferred component sizes
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setResizable(false); // Screen cannot be manully morphed to bad sizes
	}
	
	/**
     * Displays the game window on screen.
     */
	public void show() {
		frame.setVisible(true);
	}
}
