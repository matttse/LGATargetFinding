import processing.core.*;

public class Draw extends PApplet {
	// variable set
	int populationSize = 50;
	ProjectileVectors projectile;
	Population population;
	Target target;
	int vectorLifeSpan = 200;//length of DNA genes
	int targetLifeSpan = 200;//length of DNA genes

	// PApplet extension
	public static void main(String[] args) {
		PApplet.main("Draw");
	}

	// canvas size
	public void settings() {
		size(1200,800); 
	}

	
	public void setup() {
		target = new Target(this, targetLifeSpan);
		population = new Population(target.position, populationSize);//instantiate new population
		//iterate through user setting of population size to add projectiles
		for (int pv = 0; pv < populationSize; pv++) {
			projectile = new ProjectileVectors(this, vectorLifeSpan);//instantiate each new projectile
			population.addProjectiles(projectile);//add each projectile to the population
		}
		
		
	}

	// draw canvas and run
	public void draw() {
		background(255);

		population.run(this);
		target.update();
		target.show(this);
		
		fill(0);
		
//		text(("Population Size: " + popSize), 12, this.height - 16);
		
		
	}
	

}
