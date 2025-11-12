package finalProject;

public class Level1 extends Level {
	public Level1() {
		background = "/finalProject/images/backgroundSunny.png";
		player= new Player(30,400); 
        
                 
		 int w = 130; 
	     int h = 20;    

	     
	     Platform platform1 = new Platform(90, 340, w, h, 50, 300);
	     Platform platform2 = new Platform(220,250,w,h, 300, 500);
	     
	     platforms.add(new Platform(50,175,w,h, 50,300)); 
	     platforms.add(new Platform(350,175,w,h, 300, 500)); 
	      
	    enemies.add(new Enemy(platform1.getLeftBound()+50, 340 - 50, 50, 50, 2, 0, platform1));    
	    enemies.add(new Enemy(platform2.getLeftBound()+50, 250 - 50, 50, 50, 2, 0, platform2));     

//	  enemies.add(new Enemy(60, 390, 50, 50, 2, 0, 50, 150));     
//      enemies.add(new Enemy(210, 310, 50, 50, 2, 0, 200, 300));
        
	    platforms.add(platform1);  
	    platforms.add(platform2);
	    
	    collectables.add(new Collectable(130, 300));  
	    collectables.add(new Collectable(240, 210));  
	    collectables.add(new Collectable(70, 130));   
	    collectables.add(new Collectable(370, 130)); 

        collectables.add(new Collectable(400, 200));
        collectables.add(new Collectable(200, 400));
	}
}
