package finalProject;

import java.awt.Color;

public class Level2 extends Level {
	public Level2() {
		background = "/finalProject/images/backgroundEvil.png";
		
		textColor = Color.RED;
		
		player = new Player(225,100);

        Platform ground = new Platform(225, 225, 150, 10, 0, 500);
        
        platforms.add(ground);
        
        enemies.add(new Enemy(50, 400, 50, 50, 3, 0, 500));
        enemies.add(new Enemy(300, 400, 50, 50, -3, 0, 500));
        enemies.add(new Enemy(200, 400, 50, 50, 2, 0, 500));
        
        collectables.add(new Collectable(450, 300));
	}
}
