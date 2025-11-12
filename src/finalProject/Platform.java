package finalProject;
/**
 * This class is responsible for the platforms which the player can collide with. It can also spawn the enemy and the Collectible items. There will 2-3 in every level
 */
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Platform extends Entity {
	private int leftPlatBound, rightPlatBound;
	private BufferedImage plat;
	
	public Platform(int xLeft, int yTop, int width, int height, int leftPlatBound, int rightPlatBound) {
		super(xLeft, yTop, width, height, 2, 0);
		this.leftPlatBound = leftPlatBound;
		this.rightPlatBound = rightPlatBound;
		
		try {
	          plat = ImageIO.read(getClass().getResource("/finalProject/images/Platform.png"));
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	}
	
	public void move() {
		if (x <= leftPlatBound) {
			x = leftPlatBound;
			dx = - dx;
		}
		else if (x + width >= rightPlatBound) {
			x = rightPlatBound - width;
			dx = - dx;
		}
			x += (dx);
}
	
	public void draw(Graphics g2d) {
		g2d.drawImage(plat, (int) x, (int) y, width, height, null);
	}
	
	public Rectangle getPlatCollision() {
		return new Rectangle ((int) x, (int)y, width, height);
	}

	public int getY() {
		return (int)y;
	}

	public int getHeight() {
		return height;
	}

	public int getLeftBound() {
		return (int)x;
	}

	public int getRightBound() {
		return (int)x + width;
	}
	
	 
}
