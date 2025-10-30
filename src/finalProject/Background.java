package finalProject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Background {
	
	public BufferedImage sprite;
    private boolean spriteLoaded = false;
    
    // Emergency texture if sprite doesn't load
    private Color fallbackColor = Color.CYAN;
    
    public Background(String imageName) {
    	try {
			sprite = ImageIO.read(Background.class.getResource(imageName));
			spriteLoaded = true;
		} catch (Exception e) {
			spriteLoaded = false;
		}
    }
    
    public void draw(Graphics2D g2) {
    	if (spriteLoaded) {
    		g2.drawImage(sprite, 0, 0, GameComponent.WIDTH, GameComponent.HEIGHT, null);
    	} else {
    		g2.setColor(fallbackColor);
    		g2.fillRect(0, 0, GameComponent.WIDTH, GameComponent.HEIGHT);
    	}
    }
}
