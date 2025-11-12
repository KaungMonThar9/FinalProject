package finalProject;

import java.awt.Color;

public class Level2 extends Level {
	public Level2() {
		background = "/finalProject/images/backgroundEvil.png";
		
		textColor = Color.RED;
		
		player = new Player(80,600);

		int w = 250;
        int h = 18;

      
        Platform platform1 = new Platform(100, 470, w, h, 50, 400);      
        Platform platform2 = new Platform(420, 360, w, h, 350, 750);     
        Platform platform3 = new Platform(780, 250, w, h, 700, 1060);    
        Platform platform4 = new Platform(280, 160, w, h, 200, 600); 

        

        platforms.add(platform1);
        platforms.add(platform2);
        platforms.add(platform3);
        platforms.add(platform4);

       
        enemies.add(new Enemy(platform1.getLeftBound() + 40, platform1.getY() - 50, 50, 50, 2, 0, platform1));
        enemies.add(new Enemy(platform2.getLeftBound() + 50, platform2.getY() - 50, 50, 50, 2, 0, platform2));
        enemies.add(new Enemy(platform3.getLeftBound() + 60, platform3.getY() - 50, 50, 50, 3, 0, platform3));
        enemies.add(new Enemy(platform4.getLeftBound() + 30, platform4.getY() - 50, 50, 50, 2, 0, platform4));

       
        collectables.add(new Collectable(160, 420));   
        collectables.add(new Collectable(520, 310));   
        collectables.add(new Collectable(850, 210));   
        collectables.add(new Collectable(350, 110));   
        collectables.add(new Collectable(1020, 620));  
    }
}