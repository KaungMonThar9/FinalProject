package finalProject;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class Enemy extends Entity {
	private boolean facingRight = false;
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
		if ((rightBound - x) > (x - leftBound)) {
			facingRight = true;
			dx++;
		}
		else {
			facingRight = false;
			dx--;
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
	      BufferedImage img = (facingRight) ? spriteRight : spriteLeft;
	      g2.drawImage(img, (int)x,(int)y,width,height,null);
	  }
}
