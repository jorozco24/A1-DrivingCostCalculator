package a9;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 
 * @author Jorge Orozco 
 * A9 simplePlant Plant subClass
 */
public class simplePlant extends Plant {

	static final int HEALTH = 100;
	static final int COOLDOWN = 5;
	static final int DAMAGE = 5;
	static final int HEALTH_AMOUNT = 1;
	Random randGenerator = new Random();

	// Creates the simple plant for the UI
	public simplePlant(BufferedImage plantImage, int col, int row) {
		super(new Point2D.Double(col, row), new Point2D.Double(plantImage.getWidth(), plantImage.getHeight()),
				plantImage, HEALTH, COOLDOWN, DAMAGE);

	}

	/*
	 * This plant override causes the simple plant to regenerate
	 * when it is getting attacked.
	 * @param Actor other
	 */
	@Override
	public void attack(Actor other) {
		// To make the game challenging it does not have a
		// speedy regeneration. If the random generator shoots
		// back a 2 then it will regenerate.
		int regeneration = randGenerator.nextInt(3);
		if (other instanceof Zombie) {
			if (this != other && this.isCollidingOther(other)) {
				if (this.isReadyForAction() && regeneration == 2) {
					this.changeHealth(HEALTH_AMOUNT);
				}

				if (this.isReadyForAction()) {

					other.changeHealth(-DAMAGE);
					this.resetCoolDown();
				}
			}

		}

	}

}
