package finalProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final GameComponent canvas = new GameComponent();
	public Clip jumpSound;
	Timer timer;
    private Player player;
    private Enemy enemy; 
    private Platform platform1;

	
	public GamePanel() {
    	this.setLayout(new BorderLayout(8, 8));
        this.add(canvas, BorderLayout.CENTER);
        
        //this.setBackground(canvas.BG);
        //this.add(buildControls(), BorderLayout.SOUTH);
        loadJumpSound();

        player= new Player(100,400, jumpSound); 
        int platform1X = 140;
        int platform1Y = 200;
        int platform1Width = 300;
        enemy = new Enemy(platform1X+50, platform1Y -10, 50, 50, 2, 0, platform1X +20 , platform1Width +100);
        platform1 = new Platform(platform1X, platform1Y, platform1Width, 100);
     
		canvas.setPlayer(player); 
		canvas.setEnemy(enemy);
		canvas.setPlatform(platform1);
		
		canvas.addCollectable(1, 390);
		canvas.addCollectable(300, 390);
		canvas.addCollectable(250, platform1Y);
		
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
		enemy.move();
		//canvas.addCollectable(0,0)
		// The last thing so we can see everything visually move
		canvas.repaint();
	}

	private void buildKeys() {
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		this.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	    		int input= e.getKeyCode(); 
	    		
	    		if (input==KeyEvent.VK_LEFT)
	    			player.moveLeft();
	    		
	    		if (input==KeyEvent.VK_RIGHT)
	    			player.moveRight();
	    		
	    		if (input==KeyEvent.VK_UP)
	    			player.jump();
	    			
	    	}
	        
	        @Override
	        public void keyReleased(KeyEvent e) {
	    		int input= e.getKeyCode(); 
	    		if(input==KeyEvent.VK_LEFT || input==KeyEvent.VK_RIGHT) 
	    			player.stopMoving(); 
	    	}
	    });
		
	}
	
	public void loadJumpSound() { // Resource added to the Doc
		try {
			URL soundURL = getClass().getResource("/finalProject/Images/jump.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);
	        jumpSound = AudioSystem.getClip();
	        jumpSound.open(audioIn);	
		}
		catch (Exception e) {
		        e.printStackTrace();
		        System.out.println("Could not load jump sound file.");
		        jumpSound = null; 
		}
	}
}
