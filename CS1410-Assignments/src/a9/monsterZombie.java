package a9;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 
 * @author Jorge Orozco A9 monsterZombie Zombie subClass
 */
public class monsterZombie extends Zombie {

	static final int HEALTH = 100;
	static final int COOLDOWN = 50;
	static final int DAMAGE = 12;
	static final int SPEED = -2;
	Random randGenerator = new Random();

	public monsterZombie(BufferedImage zombieImage, int col, int row) {

		super(new Point2D.Double(col, row), new Point2D.Double(zombieImage.getWidth(), zombieImage.getHeight()),
				zombieImage, HEALTH, COOLDOWN, SPEED, DAMAGE);

	}

}
