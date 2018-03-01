import java.util.ArrayList;
import java.util.Iterator;

import processing.core.*;

public class ProjectileVectors {
	//declare properties
	//physics properties
	PVector position;
	PVector velocity;
	PVector acceleration;
	//fitness score
	float fitness;
	//detectors
	boolean touching;
	boolean collision;
	boolean border;
	//sketch
	PApplet parent;
	//dna property
	DNA dna;
	
	//constructors for properties
	public ProjectileVectors(PApplet parent, int lifeSpan) {
		position = new PVector(parent.random(-50,50), parent.random(-50,50));//random start pos
//		position = new PVector(parent.width/2, parent.height);//start at middle bottom of window
//		velocity = new PVector(parent.random(-1,1),parent.random(-1,1));//hardcoded random vectors
		velocity = new PVector();//no velocity
		acceleration = new PVector();//no acceleration
		dna = new DNA(lifeSpan);//dna
	}
	//adding force
	private void applyForce(PVector force) {
		acceleration.add(force);
	}
	//applying physics
	void update() {
//		float location = position.dist(position, target);
//		this.applyForce(PVector.random2D());//this works
		Iterator<PVector> force = dna.genes.iterator();
		while (force.hasNext()) {//iterates as long as there is a force to be iterated through
			this.applyForce(force.next());
		}

		velocity.add(acceleration);
		position.add(velocity);
		acceleration.mult(0);//clear acceleration at the end
		
	}
	void show(PApplet parent) {
		parent.pushMatrix();
		parent.fill(127);
		parent.noStroke();
		parent.translate(position.x, position.y);//rotated toward direction of movement
		parent.rotate(velocity.heading());//towards the angle its moving
		parent.rectMode(PApplet.CENTER);//center mode for projectile
		parent.rect(0, 0, 50, 10);//drawing the projectile
		parent.popMatrix();
	}
	
	void calcFitness(PVector vectorPos, PVector targetPos) {
		float distanceMeasure = PVector.dist(vectorPos, targetPos);
		fitness = PApplet.map(distanceMeasure, 0, PApplet.DEFAULT_WIDTH, 0, PApplet.DEFAULT_WIDTH);
//		fitness = 1/distanceMeasure;
	}

}
