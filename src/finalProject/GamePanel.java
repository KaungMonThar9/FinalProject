package finalProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;
	private final GameComponent canvas = new GameComponent();
	Timer timer;
    private Player player;
    private Enemy enemy; 

	
	public GamePanel() {
    	this.setLayout(new BorderLayout(8, 8));
        this.add(canvas, BorderLayout.CENTER);
        //this.setBackground(canvas.BG);
        //this.add(buildControls(), BorderLayout.SOUTH);
        //this.buildKeys();

        player= new Player(100,400); 
        enemy= new Enemy(20,450,100,100,5,-15,0,500); 
        
        setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
        
	    timer = new Timer(16, e-> tick());
	    timer.start();
    }
	
	
	/**
	 * Runs every frame
	 */
	private void tick() {
		player.move(canvas.getHeight());
		canvas.setPlayer(player); 
		// The last thing so we can see everything visually move
		canvas.repaint();
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int input= e.getKeyCode(); 
		
		if(input==KeyEvent.VK_LEFT)
		  player.moveLeft();
		
		if(input==KeyEvent.VK_RIGHT)
		  player.moveRight();
		
		if(input==KeyEvent.VK_UP)
			player.jump();
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int input= e.getKeyCode(); 
		if(input==KeyEvent.VK_LEFT || input==KeyEvent.VK_RIGHT) 
		  player.stopMoving(); 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		tick(); 
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
