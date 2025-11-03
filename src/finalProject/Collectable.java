package finalProject;
/**
 * This class is responsible for the collectible items on-screen which for Milestone 2 will result in increase in player score
 */

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Collectable {
	private int x;
	private int y;
	private final int WIDTH = 40;
	private final int HEIGHT = 40;
	
	private BufferedImage sprite;
	private boolean spriteLoaded = false;
	
	public Collectable(int x, int y) {
		this.x = x;
		this.y = y;
		
		try {
			sprite = ImageIO.read(Background.class.getResource("/finalProject/images/Collectable.png"));
			spriteLoaded = true;
		} catch (Exception e) {
			spriteLoaded = false;
		}
	}
	
	public void draw(Graphics2D g2) {
    	if (spriteLoaded) {
    		g2.drawImage(sprite, x, y, WIDTH, HEIGHT, null);
    	} else {
    		g2.fillRect(x, y, WIDTH, HEIGHT);
    	}
    }
	 public Rectangle getCCollision() {
			return new Rectangle(x, y, WIDTH,HEIGHT);
	  }
}
