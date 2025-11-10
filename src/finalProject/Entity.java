package finalProject;

import java.awt.Rectangle;

public abstract class Entity {
	double x;
	double y; 
	int width;
	int height; 
	double dx;
	double dy;

	public Entity(double x, double y, int width, int height, double dx, double dy) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.dx = dx;
		this.dy = dy;
	}
	public abstract void move();
}
