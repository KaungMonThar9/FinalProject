package finalProject;

import java.awt.Color;

public class Level2 extends Level {
	public Level2() {
		background = "/finalProject/images/backgroundEvil.png";
		
		textColor = Color.RED;
		
		player = new Player(225,100);

        platforms.add(new Platform(225, 225, 50, 10));
        
        enemies.add(new Enemy(0, 400, 8));
        enemies.add(new Enemy(400, 400, 8));
        enemies.add(new Enemy(200, 400, 10));
        
        collectables.add(new Collectable(450, 300));
	}
}
