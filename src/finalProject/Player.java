package finalProject;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.imageio.ImageIO;
/**
 * This class handles the on-screen player and it's key controls. 
 */
public class Player {
	
	/**
	 * A hardcoded value for that one feature we talked about, if false the player
	 * cannot move left or right after jumping
	 */
  private final boolean moveMidAir = true;
	
  private int x,y; 
  private int width= 60, height=60; 
  public boolean isOnGround=false; 
//  private int yVel=0;
  private int dx = 0, dy = 0;
  private final int speed=5; 
  private final int JUMP_STRENGTH = -15;
  private boolean facingRight; 
  private Clip jumpSound;
  
  private BufferedImage spriteLeft;
  private BufferedImage spriteRight;  
  
  public Player(int x,int y,Clip sound) {
	  this.x=x; 
	  this.y=y; 
	  this.jumpSound= sound;
	  try {
          spriteRight = ImageIO.read(getClass().getResource("/finalProject/images/RightProfile.png"));
          spriteLeft = ImageIO.read(getClass().getResource("/finalProject/images/LeftProfile.png"));
      } catch (IOException e) {
          e.printStackTrace();
      }
 }
 /**
  * Method to move the sprite using the KeyListerners in the GamePanel 
  */
  public void move() {
	  x =x + dx;
      y =y + dy;
      
      if (!isOnGround)
    	  dy=dy+1; //accounts for gravity
      else
    	  dy=0;
      
//      if(y+ height >= GameComponent.HEIGHT-50) {
//    	  y = GameComponent.HEIGHT - height - 50;
//    	  isOnGround=true; }
//      else {
//    	  isOnGround=false;  
//    	 }
      
      	//here
      
      	if(x > GameComponent.WIDTH) {
      		x = 0 - this.width;
      	}
      	else if(x < 0 - this.width) {
      		x = GameComponent.WIDTH;
      	}
  	}
  
  /**
   * Sets the player to move left
   */
  public void moveLeft() {  // Justin, use in keys
	  if (isOnGround || moveMidAir) {
	  	dx = -speed;
      	facingRight = false;
	  }
  }
  
  public void moveRight() {
	  if (isOnGround || moveMidAir) {
		  dx = speed;
		  facingRight = true;
	  }
  }
  
  public void stopMoving() {
	  if (isOnGround || moveMidAir) {
		  dx = 0;
	  }
  }
  
  public void jump() {
      if (isOnGround) {
          dy = JUMP_STRENGTH;
          
          if (jumpSound != null) {
        	  
              jumpSound.stop();
              
              jumpSound.setFramePosition(0); 
              
              jumpSound.start();
          }
          
          isOnGround = false;
      }
  }
 /**
  * Method to draw 
  */
  public void draw(Graphics2D g2) {
	  if(facingRight) {
		  BufferedImage img = spriteRight; 
		  g2.drawImage(img, x, y,width,height,null);
	  }
	  else {
		  BufferedImage img = spriteLeft;
		  g2.drawImage(img, x, y,width,height,null);
	  }
  }
  
  public Rectangle getCollision() {
		return new Rectangle(x, y, width, height);
  }
  public Rectangle fallCollision() {
	  if (dy>0) {
		return new Rectangle(x, y+dy, width, height);
	  }
	  else return getCollision();
  }
  public Rectangle testFallOnce() {
	  return new Rectangle(x, y+1, width, height);
  }
  public Rectangle fallOnce() {
	  return new Rectangle(x, y+1, width, height);
  }
  
  public void platSideCollide() {
	x -= dx;
	dx = 0;
	
//	y -= dy;
	//dy = 0;
  }
  public void platTopCollide() {
//		x -= dx;
//		dx = 0;
//		
	  int temp = 0;
	  if (dy >= 1)
		  temp = dy-1;
	  if (dy <= 0)
		  temp = -dy;
		  
	  
	  y -= dy;
	  dy = temp;
  }
  
}
