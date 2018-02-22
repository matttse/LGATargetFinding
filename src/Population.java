import java.util.ArrayList;

import processing.core.*;

public class Population {
	//hold all projectiles
	ArrayList<ProjectileVectors> projectiles;
	//constructor to instantiate a new list
	Population() {
		projectiles = new ArrayList<ProjectileVectors>();
	}
	//simply add projectile to arraylist
	public void addProjectiles(ProjectileVectors projectileVectors) {
		//add a projectile to the list
		projectiles.add(projectileVectors);		
		
	}
	//show the population
	public void run(PApplet parent) {
		for (ProjectileVectors projectileVectors : projectiles) {
			projectileVectors.update();
			projectileVectors.show(parent);
		}
	}

}
