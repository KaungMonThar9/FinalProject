package finalProject;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends Entity {
	private double x,y;
	private boolean facingRight = false;
	private BufferedImage spriteLeft;
	private BufferedImage spriteRight; 
	 
	public Enemy(double x, double y, int width, int height, double dx, double dy, double leftBound, double rightBound) {
		super(x, y, width, height, dx, dy, leftBound, rightBound);
		this.x = x;
		this.y = y;
		try {
	          spriteRight = ImageIO.read(getClass().getResource(""));
	          spriteLeft = ImageIO.read(getClass().getResource(""));
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	}

	@Override
	public void move() {
		//test variables
		x += dx;
		if ((rightBound - x) > (x - leftBound)) {
			facingRight = true;
			dx++;
		}
		else dx--;
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
	      BufferedImage img = (facingRight) ? spriteRight : spriteLeft;
	      g2.drawImage(img, (int)x,(int)y,width,height,null);
	  }
}
