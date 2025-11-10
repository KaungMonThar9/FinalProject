package finalProject;
/**
 * This class is responsible for the platforms which the player can collide with. It can also spawn the enemy and the Collectible items. There will 2-3 in every level
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Platform {
	private int xLeft, yTop, width, height, leftPlatBound, rightPlatBound;
	private BufferedImage plat;
	private int dx = 2;
	
	public Platform(int xLeft, int yTop, int width, int height, int leftPlatBound, int rightPlatBound) {
		this.xLeft = xLeft;
		this.yTop = yTop;
		this.width = width;
		this.height = height;
		this.leftPlatBound = leftPlatBound;
		this.rightPlatBound = rightPlatBound;
		
		try {
	          plat = ImageIO.read(getClass().getResource("/finalProject/images/Platform.png"));
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	}
	
	public void move() {
		if (xLeft == leftPlatBound) {
			dx = - dx;
		}
		else if (xLeft + width == rightPlatBound) {
			dx = - dx;
		}
			xLeft += (dx);
}
	
	public void draw(Graphics g2d) {
		g2d.drawImage(plat, xLeft, yTop, width, height, null);
	}
	
	public Rectangle getPlatCollision() {
		return new Rectangle (xLeft, yTop, width, height);
	}

	public int getY() {
		return yTop;
	}

	public int getHeight() {
		return height;
	}

	public int getLeftBound() {
		return xLeft;
	}

	public int getRightBound() {
		return xLeft + width;
	}
	
	 
}
