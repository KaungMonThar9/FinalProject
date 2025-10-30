package finalProject;

import java.awt.Rectangle;

public class Enemy extends Entity {

	public Enemy(double x, double y, int width, int height, double dx, double dy, double leftBound, double rightBound) {
		super(x, y, width, height, dx, dy, leftBound, rightBound);
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

}
