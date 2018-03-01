import java.util.ArrayList;
import java.util.Random;

import processing.core.*;

public class Population {
	//hold all projectiles
	ArrayList<ProjectileVectors> projectiles;
	ArrayList<ProjectileVectors> matingPool;
	PVector targetPosition;
	int populationSize;
	//constructor to instantiate a new list
	Population(PVector targetPos, int popSize) {
		projectiles = new ArrayList<ProjectileVectors>();
		matingPool = new ArrayList<ProjectileVectors>();
		targetPosition = targetPos;
		populationSize = popSize;
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
	
	//evaluate fitness
	public void evaluateFitness() {
		float maximumFitness = 0;//the max fitness score of all elements
		//loop through each vector
		for (ProjectileVectors projectileVectors : projectiles) {
			//get the fitness of each vector
			projectileVectors.calcFitness(projectileVectors.position, targetPosition);
			//get the best fit vector score
			if (projectileVectors.fitness > maximumFitness) {
				maximumFitness = projectileVectors.fitness;
			}
		}
		//avoid breaking maths
		if (maximumFitness > 0) {
			//normalize the pool against the most fit, eg 1
			for (ProjectileVectors projectileVectors : projectiles) {
				projectileVectors.fitness /= maximumFitness;
			}			
		}
		//stores values that are desirable ie better fitness score for the mating pool
		for (ProjectileVectors projectileVectors : projectiles) {
			float n = projectileVectors.fitness * 100;//getting the values between 0-100
			for (int i = 0; i < n; i++) {
				matingPool.add(projectileVectors);//add values to the mating pool
				
			}
		}

	}
	
	//selection function ie natural selection
	public void natSelection() {
		Random rdm = new Random();
		ArrayList<ProjectileVectors> babyVectors = new ArrayList<ProjectileVectors>();
		int idxA = rdm.nextInt(matingPool.size());
//		ProjectileVectors projectileVectorOne = new ProjectileVectors(matingPool.get(idxA), 200);
		
	}

}
