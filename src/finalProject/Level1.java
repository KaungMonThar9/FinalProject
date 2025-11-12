package finalProject;

public class Level1 extends Level {
	public Level1() {
		background = "/finalProject/images/backgroundSunny.png";
		player= new Player(30,600); 
        
                 
		 int w = 300; 
	     int h = 30;    


	     
	     Platform platform3= new Platform(50,175,w,h, 50,1050); 
	    
	     Platform platform1 = new Platform(90, 340, w, h, 50, 550);
	     Platform platform2 = new Platform(220,250,w,h, 550, 1050);
	     
	     platforms.add(new Platform(50,480,w,h, 50,550)); 
	     platforms.add(new Platform(350,430,w,h, 550, 1050)); 
	      
	    enemies.add(new Enemy(platform1.getLeftBound()+50, 340 - 50, 50, 50, 1, 0, platform1));    
	    enemies.add(new Enemy(platform3.getLeftBound()+50, platform3.getY() - 50, 50, 50, 1, 0, platform3));     

//	  enemies.add(new Enemy(60, 390, 50, 50, 2, 0, 50, 150));     
//      enemies.add(new Enemy(210, 310, 50, 50, 2, 0, 200, 300));
        
	    platforms.add(platform1);  
	    platforms.add(platform2);
        platforms.add(platform3); 
	    
	    collectables.add(new Collectable(400, 400));  
	    collectables.add(new Collectable(500, 210));  
	    collectables.add(new Collectable(70, 500));   
	    collectables.add(new Collectable(900, 130)); 
	    collectables.add(new Collectable(240, 210));  
	   

        collectables.add(new Collectable(300, 300));
        collectables.add(new Collectable(720, 270));
	}
}
