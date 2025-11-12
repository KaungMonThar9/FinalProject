package finalProject;

public class Level1 extends Level {
	public Level1() {
		background = "/finalProject/images/backgroundSunny.png";
		player= new Player(30,400); 
        
                 
		 int w = 130; 
	     int h = 20;    

	     
	     platforms.add(new Platform(90, 340, w, h));  
	     platforms.add(new Platform(220,250,w,h)); 
	     platforms.add(new Platform(50,175,w,h)); 
	     platforms.add(new Platform(350,175,w,h)); 
	      
	     enemies.add(new Enemy(100, 290, 50, 50, 2, 0, 90, 220)); 
	     enemies.add(new Enemy(360, 125, 50, 50, 2, 0, 350, 480)); 
        
//	  enemies.add(new Enemy(60, 390, 50, 50, 2, 0, 50, 150));     
//      enemies.add(new Enemy(210, 310, 50, 50, 2, 0, 200, 300));
        
	     collectables.add(new Collectable(130, 300));  
	     collectables.add(new Collectable(240, 210));  
	     collectables.add(new Collectable(70, 130));   
	     collectables.add(new Collectable(370, 130)); 
	}
}
