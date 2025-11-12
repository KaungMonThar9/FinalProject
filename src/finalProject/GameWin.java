package finalProject;

public class GameWin extends Level {
	public GameWin() {
		background = "/finalProject/images/gameWin.png";
		
		player = new Player(225,300);
		
		// Y
		for (int i = 0; i < 5; i++)
			collectables.add(new Collectable(50 + 20*i, 50 + 20*i));
		for (int i = 0; i < 5; i++)
	        collectables.add(new Collectable(250 - 20*i, 50 + 20*i));
		for (int i = 0; i < 5; i++)
	        collectables.add(new Collectable(150, 150 + 40*i));
		
		// O
		for (int i = 0; i < 7; i++)
	        collectables.add(new Collectable(350, 70 + 40*i));
		for (int i = 0; i < 5; i++)
	        collectables.add(new Collectable(350 + 40*i, 70));
		for (int i = 1; i < 7; i++)
	        collectables.add(new Collectable(510, 70 + 40*i));
		for (int i = 1; i < 5; i++)
	        collectables.add(new Collectable(350 + 40*i, 310));
		
		// U
		for (int i = 0; i < 7; i++)
	        collectables.add(new Collectable(610, 70 + 40*i));
		for (int i = 0; i < 6; i++)
	        collectables.add(new Collectable(770, 70 + 40*i));
		for (int i = 1; i < 5; i++)
	        collectables.add(new Collectable(610 + 40*i, 310));
		
		// New Line
		
		// W
		for (int i = 0; i < 9; i++)
	        collectables.add(new Collectable(30 + 10*i, 375 + 30*i));
		for (int i = 0; i < 8; i++)
	        collectables.add(new Collectable(190 - 10*i, 375 + 30*i));
		for (int i = 1; i < 9; i++)
	        collectables.add(new Collectable(190 + 10*i, 375 + 30*i));
		for (int i = 0; i < 8; i++)
	        collectables.add(new Collectable(350 - 10*i, 375 + 30*i));
		
		// I
		for (int i = 0; i < 7; i++)
	        collectables.add(new Collectable(500, 375 + 40*i));
		for (int i = 0; i < 5; i++)
	        collectables.add(new Collectable(420 + 40*i, 375));
		for (int i = 0; i < 5; i++)
	        collectables.add(new Collectable(420 + 40*i, 615));
		
		// N
		for (int i = 0; i < 7; i++)
	        collectables.add(new Collectable(660, 375 + 40*i));
		for (int i = 0; i < 7; i++)
	        collectables.add(new Collectable(820, 375 + 40*i));
		for (int i = 1; i < 7; i++)
	        collectables.add(new Collectable(670 + 20*i, 355 + 40*i));
	}
}
