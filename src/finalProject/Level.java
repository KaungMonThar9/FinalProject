package finalProject;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Game levels
 */
public class Level {
	protected String background;
	protected Player player;
	protected ArrayList<Enemy> enemies = new ArrayList<>();
	protected ArrayList<Platform> platforms = new ArrayList<>();
	protected ArrayList<Collectable> collectables = new ArrayList<>();
	protected Color textColor = Color.BLACK;
	
	public void updateComponent(GameComponent canvas, EntityModel model) {
		canvas.setBackgroundImage(background);
		canvas.setTextColor(textColor);
		
		canvas.setPlayer(player);
		for (Enemy e : enemies) {
			canvas.addEnemy(e);
			model.addEntity(e);
		}
		for (Platform p : platforms) {
			canvas.addPlatform(p);
			model.addEntity(p);
		}

			
		for (Collectable c : collectables)
			canvas.addCollectable(c);
	}
}
