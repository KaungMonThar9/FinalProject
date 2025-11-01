package finalProject;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Platform {
	private int xLeft, yTop, width, height;
	
	public Platform(int xLeft, int yTop, int width, int height) {
		this.xLeft = xLeft;
		this.yTop = yTop;
		this.width = width;
		this.height = height;
	}
	
	public void drawRect(Graphics g2d) {
		g2d.drawRect(this.xLeft, this.yTop, this.width, this.height);
	}
	
	public int[] platCoords() {
		return new int [] {xLeft, yTop, width, height};
	}
}
