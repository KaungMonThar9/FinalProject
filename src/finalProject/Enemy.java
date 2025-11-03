package finalProject;
/**
 * This class handles the movement of the Enemy within a given bounds. It moves automatically and uses multiple sprites
 */

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Enemy extends Entity {
	private boolean facingRight = true;
	private BufferedImage spriteLeft;
	private BufferedImage spriteRight; 
	 
	public Enemy(double x, double y, int width, int height, double dx, double dy, double leftBound, double rightBound) {
		super(x, y, width, height, dx, dy, leftBound, rightBound);
		try {
	          spriteRight = ImageIO.read(getClass().getResource("/finalProject/images/rightStation.png"));
	          spriteLeft = ImageIO.read(getClass().getResource("/finalProject/images/leftStation.png"));
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	}

	@Override
	public void move() {
		//test variables
		x += dx;
		if ((x < leftBound) || (x + width > rightBound)) {
			dx = -dx; 
			facingRight = !facingRight;
		}	
			
	}

	@Override
	public double getLeftBound() {
		return leftBound;
	}

	@Override
	public double getRightBound() {
		return rightBound;
	}


	public void draw(Graphics2D g2) {
		if(facingRight) {
			BufferedImage img = spriteRight;
			g2.drawImage(img, (int)x,(int)y,width,height,null);
		}
		else {
			BufferedImage img = spriteLeft;
			g2.drawImage(img, (int)x,(int)y,width,height,null);
		}
	  }
	
	public Rectangle getCollision() {
		return new Rectangle((int) x, (int) y, width, height);
	}
}
