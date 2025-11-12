	package finalProject;
	
	import java.awt.Color;
	import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	
	public class StartScreen extends JFrame{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public StartScreen() {
			this.setSize(1100,700); 
			this.setTitle("Start");
			
		    JPanel panel = new JPanel()
		    {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                ImageIcon bg = new ImageIcon("src/finalProject/Images/startScreenBg.png");
	                g.drawImage(bg.getImage(), 0, 0, 1100, 700, this);
	            }
	        };
	        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		    
	        JLabel title = new JLabel("MJJCraft");
	        title.setFont(new Font("Serif", Font.BOLD, 48));
	        title.setPreferredSize(new Dimension(1000, 48));
	        title.setHorizontalAlignment(JLabel.CENTER);

	        JButton start = new JButton("Start");
	        JButton exit = new JButton("Exit");
	        start.setPreferredSize(new Dimension(150, 50));
	        exit.setPreferredSize(new Dimension(150, 50));

	
	        start.addActionListener(e -> { 
	            this.dispose(); 
	            new GameApp().show(); 
	        });
	        
	        exit.addActionListener(e -> System.exit(0));
	        
	        panel.add(title);
	        panel.add(start);
	        panel.add(exit);
	        this.add(panel);
	           
	        
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
		    setLocationRelativeTo(null); 
	        setVisible(true);	    
	    }
	}    
	      
	
	
