package finalProject;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Enemy extends Entity {
	
	private final int width= 100; 
	private final int height= 100; 

	public Enemy(double x, double y, double dx, double dy, double leftBound, double rightBound) {
	
		super(x, y, dx, dy, leftBound, rightBound);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		//test variables
		if ((rightBound - x) > (x - leftBound)) dx++;
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
	  }
	  

}
