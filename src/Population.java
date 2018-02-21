import java.util.ArrayList;

import processing.core.*;

public class Population {
	ArrayList<ProjectileVectors> projectiles;
	Population() {
		projectiles = new ArrayList<ProjectileVectors>();
	}
	public void addProjectiles(ProjectileVectors projectileVectors) {
		//add a projectile to the list
		projectiles.add(projectileVectors);		
		
	}
	public void run(PApplet parent) {
		for (ProjectileVectors projectileVectors : projectiles) {
			projectileVectors.update();
			projectileVectors.show(parent);
		}
	}

}
