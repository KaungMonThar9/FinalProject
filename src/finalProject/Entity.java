package finalProject;

import java.awt.Rectangle;

public abstract class Entity {
	double x;
	double y; 
	int width;
	int height; 
	double dx;
	double dy;
	protected double leftBound;
	protected double rightBound;

	public Entity(double x, double y, int width, int height, double dx, double dy, double leftBound, double rightBound) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.dx = dx;
		this.dy = dy;
		this.leftBound = leftBound;
		this.rightBound = rightBound;
	}
	
	public abstract double getLeftBound();
	public abstract double getRightBound();
	public abstract void move();
}
