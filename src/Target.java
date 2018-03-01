import java.util.Iterator;

import processing.core.PApplet;
import processing.core.PVector;

public class Target {
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
	public Target(PApplet parent) {
		position = new PVector(parent.random(-50,50), parent.random(-50,50));//random start pos
//		position = new PVector(parent.width/2, 50);//start at center of window
//		velocity = new PVector(parent.random(-1,1),parent.random(-1,1));//hardcoded random vectors
		velocity = new PVector();//no velocity
		acceleration = new PVector();//no acceleration
		dna = new DNA();//dna		
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
		parent.ellipseMode(PApplet.CENTER);//center mode for projectile
		parent.ellipse(0, 0, 40, 30);//drawing the projectile
		parent.popMatrix();
	}

	
	
}
