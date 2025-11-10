package finalProject;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Level[] levels = {new Level1(), new Level2(), new GameOver()};
	private int levelIndex;
	
	private GameComponent canvas = new GameComponent();
	public Clip jumpSound;
	Timer timer;
    private Player player;
    private EntityModel model = new EntityModel();
    
    private boolean movingLeft = false;
    private boolean movingRight = false;
    
    private int platLeftBound = 50;
    private int platRightBound = 450;

	
	public GamePanel() {
    	this.setLayout(new BorderLayout(8, 8));
        this.add(canvas, BorderLayout.CENTER);

        player= new Player(50,200); 
        int platform1X = 140;
        int platform1Y = 350;
        
        int platform2X = 250;
        int platform2Y = 240;
        int platformWidth = 200;
        Platform platform1 = new Platform(platform1X, platform1Y, platformWidth, 20, platLeftBound, platRightBound);
        
        Platform platform2 = new Platform(platform2X, platform2Y, platformWidth, 20, platLeftBound, platRightBound);
     
        Enemy enemy = new Enemy(platform1X+50, platform1Y - 50, 50, 50, 2, 0, platform1);
                
		canvas.setPlayer(player); 
		canvas.addEnemy(enemy);
		canvas.addPlatform(platform1);
		canvas.addPlatform(platform2);
		
		model.addEntity(enemy);
		model.addEntity(platform1);
		model.addEntity(platform2);

		// Delete this test code
		//canvas.addPlatform(new Platform(platform1X-50, platform1Y-150, platform1Width, 20));
		
		canvas.addCollectable(new Collectable(1, 390));
		canvas.addCollectable(new Collectable(300, 390));
		canvas.addCollectable(new Collectable(250, platform1Y));
        levelIndex = 0;
        loadNewLevel(levels[levelIndex]);
		
        this.buildKeys();
        setFocusable(true);
		requestFocusInWindow();
		
        
	    timer = new Timer(16, e-> tick());
	    timer.start();
    }
	
	
	/**
	 * Runs every frame
	 */
	private void tick() {
		player.move(canvas.getHeight());
		model.updateAll();
		canvas.handleCollisions();
		//canvas.addCollectable(0,0)
		// The last thing so we can see everything visually move
		canvas.repaint();
		if (canvas.testLoad() == 1 && levelIndex+1 != levels.length) {
    			levelIndex += 1;
    			loadNewLevel(levels[levelIndex]);
		} else if (canvas.testLoad() == 2 && levelIndex + 1 != levels.length) {
			levelIndex = levels.length - 1;
			loadNewLevel(levels[levelIndex]);
		}
	}
	
	private void loadNewLevel(Level level) {
		canvas.clear();
		model.clear();
		
		player = level.player;
		canvas.setPlayer(player);
		
		level.updateComponent(canvas, model);
	}

	private void buildKeys() {
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		this.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	    		int input= e.getKeyCode(); 
	    		
	    		if (input==KeyEvent.VK_LEFT) {
	    			player.moveLeft();
	    			movingLeft = true;
	    		}
	    		
	    		if (input==KeyEvent.VK_RIGHT) {
	    			player.moveRight();
	    			movingRight = true;
	    		}
	    		
	    		if (input==KeyEvent.VK_UP)
	    			player.jump();
	    		
	    		
//	    		/**
//	    		 * This is a debug key event, it should likely be commented out for final game
//	    		 */
//	    		if (input==KeyEvent.VK_F1) {
//	    			levelIndex += 1;
//	    			loadNewLevel(levels[levelIndex]);
//	    		}
	    			
	    	}
	        
	        @Override
	        public void keyReleased(KeyEvent e) {
	    		int input= e.getKeyCode(); 
	    		
	    		if(input==KeyEvent.VK_LEFT) {
	    			movingLeft = false;
	    			if (!movingRight)
	    				player.stopMoving();
	    		}
	    		
	    		if(input==KeyEvent.VK_RIGHT) {
	    			movingRight = false;
	    			if (!movingLeft)
	    				player.stopMoving();
	    		}
	    	}
	    });
	}
}
