package a9;

import java.awt.geom.Point2D;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 
 * @author Jorge Orozco A9 juggernaut Zombie subClass
 */
public class juggernautZombie extends Zombie {

	static final int HEALTH = 200;
	static final int COOLDOWN = 50;
	static final int DAMAGE = 10;
	static final int SPEED = -2;

	Random randGenerator = new Random();
	//This boolean causes the zombie to only teleport once.
	boolean teleport = true;

	public juggernautZombie(BufferedImage zombieImage2, int col, int row) {

		super(new Point2D.Double(col, row), new Point2D.Double(zombieImage2.getWidth(), zombieImage2.getHeight()),
				zombieImage2, HEALTH, COOLDOWN, SPEED, DAMAGE);

	}

	/*
	 * This zombie override causes the juggernaut zombie to teleport when it faces a
	 * plant.
	 * 
	 * @param Actor other
	 */
	@Override
	public void attack(Actor other) {
		//this random generator is used to generate a random 
		//row for the zombie to teleport too.
		int randRow = (randGenerator.nextInt(5) * 100);
		if (randRow == 0 || randRow == 1) {
			randRow = randRow + 200;

		}
		//the column will always be on the 500th column so it doesn't
		//fall off the grid, but the row will always be random.
		if (other instanceof Plant) {
			if (this != other && this.isCollidingOther(other)) {
				if (this.isReadyForAction() && teleport == true) {
					this.moveTo(new Point2D.Double(600, randRow));
					teleport = false;
				}
				if (this.isReadyForAction() && teleport == false)
					other.changeHealth(-DAMAGE);
				this.resetCoolDown();

			}
		}

	}

}
