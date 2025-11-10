package finalProject;

import java.util.ArrayList;

public class EntityModel {
	private ArrayList<Entity> entities = new ArrayList<>();
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void clear() {
		entities = new ArrayList<>();
	}
	
	public void updateAll() {
		for (Entity e : entities) {
			e.move();
		}
	}
}
