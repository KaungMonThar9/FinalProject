package finalProject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
/**
 * @author medhanshgupta
 */
public class Player {
	
  private double x,y; 
  private int width= 50, height=50; 
  private boolean isOnGround=false; 
  private int yVel=0;
  private int dx = 0, dy = 0;
 
  
  private BufferedImage sprite; 
  private boolean spriteLoaded = false;
  
  public Player(double x,double y,BufferedImage sprite) {
	  this.x=x; 
	  this.y=y; 
	  this.sprite=sprite; 
	  }
 /**
  * Method to move the sprite using the KeyListerners in the GamePanel 
  */
  public void move(int screen) {
	  x =x+ dx;
      y =y+ dy;
      
      dy=dy+1; 
      
      if(y+ height >= screen-100) {
    	  y = screen - height - 50;
    	  dy=0; 
    	  isOnGround=true; }
    else {
    	  isOnGround=false;  
    	 }
      }
  
 /**
  * Method to draw just like in Ball Class
  */
 
  
}
