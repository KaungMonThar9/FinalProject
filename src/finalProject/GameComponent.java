package finalProject;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class GameComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private Background BG;
	
	private Player player;
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList<Platform> platforms = new ArrayList<>();
    private ArrayList<Collectable> collectables = new ArrayList<>();

	private int score=0;
	private int life=3;
	private int iframes=0;
	
	// We can change these WIDTH and HEIGHT values to adjust the window size
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	public GameComponent() {
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		// I'll probably move the background related stuff to a level class
		this.BG = new Background("/finalProject/images/backgroundSunny.png");
	}
	
	public void setPlayer(Player p) {
	    this.player = p;
	}
	
	public void addEnemy(Enemy e) {
		enemies.add(e);
	}
	
	
	public void addPlatform(Platform p) {
		platforms.add(p);
	}
	
	public void addCollectable(int x, int y) {
		collectables.add(new Collectable(x, y));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (BG != null) {
            BG.draw(g2);
        }
		for (Collectable c : collectables) {
			c.draw(g2);
		}
		if (player != null) {
            player.draw(g2);
        }
		for (Enemy e : enemies) {
			e.draw(g2);
		}
		for (Platform p : platforms) {
			p.draw(g2);
		}
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Arial", Font.BOLD, 20));
		g2.drawString("Score: " + score, 20, 30);
		
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Arial", Font.BOLD, 20));
		g2.drawString("Lives: " + life, 20, 50);

	}
	
	public void handleCollisions() {
		if (iframes > 0) {
			iframes -= 1;
		}
		
		for (Enemy e : enemies) {
			if (e.getCollision().intersects(player.getCollision())) {
				System.out.println("Enemy Collision");
				if (iframes == 0) {
					life -= 1;
					iframes = 50;
				}
			}
		}
		
		for (Platform p: platforms) {
			if (p.getPlatCollision().intersects(player.getCollision())) {
		        if (player.getBot() - player.getDy() < p.getY() &&
		                player.getDy() > 0 && player.getBot() >= p.getY()) {
		            player.onPlat(p.getY(), p.getLeftBound(), p.getRightBound());
		        }
		        else if (player.getTop() < p.getY() + p.getHeight() && player.getDy() < 0) {
		            player.collide(p.getY() + p.getHeight());
		        }
		    }
		}
			

		//Start of Collectible-Player collides 
		ArrayList<Collectable> toDelete = new ArrayList<>();
		for(Collectable c : collectables) {
			if (player.getCollision().intersects(c.getCCollision())) {
	            System.out.println("Collected an powerup");
	            score=score+10; 
	            toDelete.add(c);
		 }
	   }
		for (Collectable c : toDelete) {
	        collectables.remove(c);
	    }
		//End of Collectible-Player collides 
	}
}


