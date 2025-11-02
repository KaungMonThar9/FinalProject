package finalProject;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.imageio.ImageIO;
/**
 * @author medhanshgupta
 */
public class Player {
	
  private int x,y; 
  private int width= 100, height=100; 
  private boolean isOnGround=false; 
  private int yVel=0;
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
          spriteRight = ImageIO.read(getClass().getResource("/finalProject/RightProfile.png"));
          spriteLeft = ImageIO.read(getClass().getResource("/finalProject/LeftProfile.png"));
      } catch (IOException e) {
          e.printStackTrace();
      }
 }
 /**
  * Method to move the sprite using the KeyListerners in the GamePanel 
  */
  public void move(int screen) {
	  x =x+ dx;
      y =y+ dy;
      
      if (!isOnGround)
    	  dy=dy+1; //accounts for gravity
      else
    	  dy=0;
      
      if(y+ height >= screen-50) {
    	  y = screen - height - 50;
    	  isOnGround=true; }
    else {
    	  isOnGround=false;  
    	 }
      
      //here
      
      if(x==490) {
    	  x=0;
      }
      else if(x==0) {
    	  x=490;
      }
      }
  
  public void moveLeft() {  // Justin, use in keys 
      dx =-speed;
      facingRight = false;
  }
  
  public void moveRight() {
      dx = speed;
      facingRight = true;
  }
  
  public void stopMoving() {
      dx = 0;
  }
  
  public void jump() {
      if (isOnGround) {
          dy = JUMP_STRENGTH;
          isOnGround = false;
      }
      
      if (jumpSound != null) {
    	  
          jumpSound.stop();
          
          jumpSound.setFramePosition(0); 
          
          jumpSound.start();
      }
  }
 /**
  * Method to draw just like in Ball Class
  */
  public void draw(Graphics2D g2) {
      BufferedImage img = (facingRight) ? spriteRight : spriteLeft;
      g2.drawImage(img, x, y,width,height,null);
  }
  
}
