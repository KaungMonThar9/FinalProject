package finalProject;

public class Level1 extends Level {
	public Level1() {
		background = "/finalProject/images/backgroundSunny.png";
		
		player= new Player(50,200); 
        int platform1X = 140;
        int platform1Y = 350;
        
        int platform2X = 250;
        int platform2Y = 240;
        int platformWidth = 200;
        Platform platform1 = new Platform(platform1X, platform1Y, platformWidth, 20, 50, 450);
        
        platforms.add(platform1);
        platforms.add(new Platform(platform2X, platform2Y, platformWidth + 50, 20, 50, 450));
        enemies.add(new Enemy(platform1.getLeftBound()+50, platform1Y - 50, 50, 50, 2, 0, platform1));

        collectables.add(new Collectable(400, 200));
        collectables.add(new Collectable(200, 400));
	}
}
