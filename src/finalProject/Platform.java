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
	private int xLeft, yTop, width, height;
	private BufferedImage plat; 
	
	public Platform(int xLeft, int yTop, int width, int height) {
		this.xLeft = xLeft;
		this.yTop = yTop;
		this.width = width;
		this.height = height;
		
		try {
	          plat = ImageIO.read(getClass().getResource("/finalProject/images/Platform.png"));
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	}
	
	public void draw(Graphics g2d) {
		g2d.drawImage(plat, xLeft, yTop, width, height, null);
	}
	
	public Rectangle getPlatCollision() {
		return new Rectangle (xLeft, yTop, width, height);
	}
}
