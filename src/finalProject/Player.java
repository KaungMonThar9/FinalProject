package finalProject;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
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
  private int currentPlatY = 0;
  private int width= 60, height=60;
  private boolean isOnGround=false;
//  private int yVel=0;
  private int dx = 0, dy = 0;
  private final int speed=5;
  private final int JUMP_STRENGTH = -15;
  private boolean facingRight;
  private Clip jumpSound;

  private BufferedImage spriteLeft;
  private BufferedImage spriteRight;

  private boolean collideY = false;

  private int platLB;
  //private boolean platBotCollide = false;
  private int platRB;
  
  private double platSpeed = 0;


  public Player(int x,int y) {
	  this.x=x;
	  this.y=y;
	  loadJumpSound();
	  try {
          spriteRight = ImageIO.read(getClass().getResource("/finalProject/images/RightProfile.png"));
          spriteLeft = ImageIO.read(getClass().getResource("/finalProject/images/LeftProfile.png"));
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
	
	private void loadJumpSound() { // Resource added to the Doc
		try {
			URL soundURL = getClass().getResource("/finalProject/Images/jump.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);
	        jumpSound = AudioSystem.getClip();
	        jumpSound.open(audioIn);	
		}
		catch (Exception e) {
		        e.printStackTrace();
		        System.out.println("Could not load jump sound file.");
		        jumpSound = null; 
		}
	}
 /**
  * Method to move the sprite using the KeyListerners in the GamePanel
  */
  public void move(int screen) {
	  x =x + dx;
	  x += platSpeed;
	  
      y =y + dy;

      if (!isOnGround)
      {
    	  dy=dy+1; //accounts for gravity
    	  if (currentPlatY != 0 && (x <= platLB - width || x >= platRB)) {
    	        currentPlatY = 0;
    	        platSpeed = 0;
    	    }
      }
      else
    	  dy=0;

      if(y+ height >= screen-50) {
    	  if (y+ height >= screen-50)
    	  {
        	  y = screen - height - 50;
    	  }
    	  isOnGround = true;
      	}
      else {
    	  isOnGround = false;
    	 }

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
      if (isOnGround || collideY) {
          dy = JUMP_STRENGTH;

          if (jumpSound != null) {

              jumpSound.stop();

              jumpSound.setFramePosition(0);

              jumpSound.start();
          }

    	  this.platSpeed = 0;
          isOnGround = false;
          collideY = false;
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

  public int getBot() {
	return y + height;
  }
  public int getDy() {
	return dy;
  }
  public void onPlat(int platY, int platLeftBound, int platRightBound, double platSpeed) {
	  y = platY - height;
	  dy = 0;
	  isOnGround = true;
	  collideY = true;
	  currentPlatY = platY;
	  platLB = platLeftBound;
	  platRB = platRightBound;
	  this.platSpeed = platSpeed;
	  //platBotCollide = false;
  }
  public int getTop() {
	return y;
  }
  public void collide(int platY) {
	y = platY;
	dy = 0;
	//platBotCollide = true;

  }
}