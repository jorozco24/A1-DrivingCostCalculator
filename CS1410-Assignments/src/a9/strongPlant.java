package a9;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 
 * @author Jorge Orozco 
 * A9 strongPlant Plant subClass
 */
public class strongPlant extends Plant {
	
	static final int HEALTH = 250;
	static final int COOLDOWN = 6;
	static final int DAMAGE = 10;
	
	public strongPlant(BufferedImage plantImage2, int col, int row) {
		super(new Point2D.Double(col , row),
				new Point2D.Double(plantImage2.getWidth(), plantImage2.getHeight()), plantImage2, HEALTH, COOLDOWN, DAMAGE);
		
	}

	public static void main(String[] args) {
	
	}
}



