package finalProject;

public class Level1 extends Level {
	public Level1() {
		background = "/finalProject/images/backgroundSunny.png";
		player= new Player(30,600); 
        
                 
		 int w = 300; 
	     int h = 30;    


	     	    
	     Platform platform1 = new Platform(90, 200, w, h, 50, 550);
	     //Platform platform3 = new Platform(500, 175,w,h, 50,1050); 
	     Platform platform2= new Platform(350,390,w,h, 550, 1050); 
	     platforms.add(new Platform(50,480,w,h, 50,550)); 
	     
	      
	    enemies.add(new Enemy(platform1.getLeftBound()+50, platform1.getY()- 50, 50, 50, 2, 0, platform1));    
	    enemies.add(new Enemy(platform2.getLeftBound()+50, platform2.getY() - 50, 50, 50, 2, 0, platform2));     

//	  enemies.add(new Enemy(60, 390, 50, 50, 2, 0, 50, 150));     
//      enemies.add(new Enemy(210, 310, 50, 50, 2, 0, 200, 300));
        
	    platforms.add(platform1);  
        platforms.add(platform2); 
	    
	    collectables.add(new Collectable(130, 300));  
	    collectables.add(new Collectable(240, 210));  
	    collectables.add(new Collectable(70, 130));   
	   

        collectables.add(new Collectable(400, 200));
        collectables.add(new Collectable(200, 400));
	}
}
