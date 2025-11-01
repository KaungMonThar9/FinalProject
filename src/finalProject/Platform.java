package finalProject;

import java.awt.Color;
import java.awt.Graphics;

public class Platform {
	private int xLeft, yTop, width, height;
	
	public Platform(int xLeft, int yTop, int width, int height) {
		this.xLeft = xLeft;
		this.yTop = yTop;
		this.width = width;
		this.height = height;
	}
	
	public void drawRect(Graphics g2d) {
		g2d.setColor(Color.lightGray);
		g2d.fillRect(this.xLeft, this.yTop, this.width, this.height);
	}
	
	public int[] platCoords() {
		return new int [] {xLeft, yTop, width, height};
	}
}
