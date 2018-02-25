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
	public ProjectileVectors(PApplet parent) {
		//start at middle bottom of window
		position = new PVector(parent.width/2, parent.height);
		//no velocity
//		velocity = new PVector(parent.random(-1,1),parent.random(-1,1));
		velocity = new PVector();
		//no acceleration
		acceleration = new PVector();
		
		//dna
		dna = new DNA();
	}
	//adding force
	private void applyForce(PVector force) {
		acceleration.add(force);
	}
	//applying physics
	void update() {
//		float location = position.dist(position, target);
//		this.applyForce(dna.genes.listIterator().next());
//		while(dna.genes.listIterator().hasNext()) {
//			this.applyForce(dna.genes.iterator().next());
//		}
//		this.applyForce(PVector.random2D());//this works
		Iterator<PVector> force = dna.genes.iterator();
		while (force.hasNext()) {
			this.applyForce(force.next());
		}
//		PVector vector = dna.genes.get(0);
//		this.applyForce(vector);
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

}
