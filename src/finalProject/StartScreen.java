	package finalProject;
	
	import java.awt.Color;
	import java.awt.*;
	
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
			this.setSize(600,400); 
			this.setTitle("Start");
			this.setLayout(new GridLayout(1, 3, 10, 10));
			
		    JPanel panel = new JPanel();
	        panel.setBackground(Color.BLACK); 
	        
	        
	        JLabel title = new JLabel("Our Game name");
	        title.setFont(new Font("Serif", Font.BOLD, 48));
	        
	        JButton start = new JButton("Start");
	        JButton exit = new JButton("Exit");

	
	        start.addActionListener(e -> { 
	            this.dispose(); 
	            new GameApp().show(); 
	        });
	        
	        exit.addActionListener(e -> System.exit(0));
	        
	        panel.add(title);
	        panel.add(start);
	        panel.add(exit);
	        this.add(panel);
	        panel.setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
		    setLocationRelativeTo(null); 
		    
	    }
	}    
	      
	
	
