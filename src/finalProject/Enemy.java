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
	private Platform platform;

	public Enemy(double x, double y, int width, int height, double dx, double dy, Platform platform) {
		super(x, y, width, height, dx, dy);
		this.platform = platform;
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
		if ((x < platform.getLeftBound())) {
			x = platform.getLeftBound();	
			dx = -dx; 
			facingRight = !facingRight;
		}
		else if (x + width > platform.getRightBound()) {
			x = platform.getRightBound() - width;
			dx = - dx;
			facingRight = !facingRight;
		}
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
