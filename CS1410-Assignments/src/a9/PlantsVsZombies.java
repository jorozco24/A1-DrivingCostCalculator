package a9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @author Jorge Orozco A9 PlantsVsZombies
 */

public class PlantsVsZombies extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private Timer timer;
	int timerSec = 200;
	private int difficultyEXP = 0;
	private ArrayList<Actor> actors; // Plants and zombies all go in here
	BufferedImage plantImage; // Maybe these images should be in those classes, but easy to change here.
	BufferedImage zombieImage;
	BufferedImage plantImage2;
	BufferedImage zombieImage2;
	int numRows;
	int numCols;
	int cellSize;
	private Random randGenerator;
	int coins = 100;
	JPanel gameOver = new JPanel();
	JPanel topSection = new JPanel();
	JLabel notEnoughCoins = new JLabel(" ");
	JLabel outOfBounds = new JLabel("");
	JLabel coinsCollected = new JLabel("Coins Collected: " + coins);
	JLabel expPoints = new JLabel("Points: " + difficultyEXP);
	JLabel nsfCoins = new JLabel(" ");
	JLabel gameOverMessage = new JLabel("GAME OVER");
	JButton simplePlant = new JButton("Simple Plant- 50 coins");
	JButton strongPlant = new JButton("Strong Plant- 75 coins");
	private static Dimension size = new Dimension(1000, 500);
	private static Dimension gameOverSize = new Dimension(1000, 500);
	boolean coinsSimplePlant = false;
	boolean coinsStrongPlant = false;

	/**
	 * Setup the basic info for the example
	 */
	public PlantsVsZombies() throws IOException {

		super();
		Dimension topSectionSize = new Dimension(1000, 30);
		GridLayout grid = new GridLayout(1, 5);
		simplePlant.addActionListener(this);
		strongPlant.addActionListener(this);

		outOfBounds.setFont(new Font("Serif", Font.BOLD, 10));
		nsfCoins.setFont(new Font("Serif", Font.BOLD, 10));

		gameOver.add(gameOverMessage);
		gameOver.setPreferredSize(gameOverSize);
		topSection.setPreferredSize(topSectionSize);
		topSection.setLayout(grid);

		topSection.add(outOfBounds);
		topSection.add(expPoints);
		topSection.add(nsfCoins);
		topSection.add(coinsCollected);
		topSection.add(simplePlant);
		topSection.add(strongPlant);
		super.add(topSection);

		addMouseListener(this);

		// Define some quantities of the scene
		randGenerator = new Random();

		numRows = 5;
		numCols = 7;
		cellSize = 100;
		setPreferredSize(new Dimension(50 + numCols * cellSize, 50 + numRows * cellSize));

		// Store all the plants and zombies in here.
		actors = new ArrayList<>();

		// Load images
		try {
			plantImage2 = ImageIO.read(new File("src/a9/plant2.png"));
			plantImage = ImageIO.read(new File("src/a9/plant.png"));
			zombieImage = ImageIO.read(new File("src/a9/zombie.png"));
			zombieImage2 = ImageIO.read(new File("src/a9/juggernaut.png"));
		} catch (IOException e) {
			System.out.println("A file was not found");
			System.exit(0);
		}

		// The timer updates the game each time it goes.
		// Get the javax.swing Timer, not from util.
		timer = new Timer(timerSec, this);
		timer.start();

	}

	/***
	 * Implement the paint method to draw the plants
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Actor actor : actors) {
			actor.draw(g, 0);
			actor.drawHealthBar(g);
		}
	}

	/**
	 * 
	 * This is triggered by the timer. It is the game loop of this test.
	 * 
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// This method is getting a little long, but it is mostly loop code
		// Increment their cooldowns and reset collision status
		for (Actor actor : actors) {
			actor.update();
		}

		// Increase the difficulty by increasing the rate of generation
		// the difficulty variable shows up as experience points in the game's UI
		int row = 0;
		if (difficultyEXP > 50 && difficultyEXP < 700) {
			timerSec = 80;
			timer.setDelay(timerSec);
			if (randGenerator.nextInt(100) > 97)

				row = randGenerator.nextInt(5);
			int col = 1;
			if (row != 0 && row != 1) {
				int x = col * 1000;
				int y = row * 100;

				monsterZombie zombie = new monsterZombie(zombieImage, x, y);
				actors.add(zombie);
				if (randGenerator.nextInt(100) < 8) {
					juggernautZombie juggernaut = new juggernautZombie(zombieImage2, x, y);
					actors.add(juggernaut);
				}

			}
		}
		if (difficultyEXP > 700 && difficultyEXP < 1200) {

			timerSec = 60;
			timer.setDelay(timerSec);
			if (randGenerator.nextInt(100) > 95)

				row = randGenerator.nextInt(5);
			int col = 1;
			if (row != 0 && row != 1) {
				int x = col * 1000;
				int y = row * 100;

				monsterZombie zombie = new monsterZombie(zombieImage, x, y);
				actors.add(zombie);

				if (randGenerator.nextInt(100) < 10) {
					juggernautZombie juggernaut = new juggernautZombie(zombieImage2, x, y);
					actors.add(juggernaut);
				}
			}
		}
		if (difficultyEXP > 1200) {

			timerSec = 30;
			timer.setDelay(timerSec);

			if (randGenerator.nextInt(100) > 92)

				row = randGenerator.nextInt(5);
			int col = 1;
			if (row != 0 && row != 1) {
				int x = col * 1000;
				int y = row * 100;

				monsterZombie zombie = new monsterZombie(zombieImage, x, y);
				actors.add(zombie);

				if (randGenerator.nextInt(100) < 12) {
					juggernautZombie juggernaut = new juggernautZombie(zombieImage2, x, y);
					actors.add(juggernaut);
				}
			}
		}

		// Try to attack
		for (Actor actor : actors) {
			for (Actor other : actors) {
				actor.attack(other);
			}
		}

		// Remove plants and zombies with low health
		ArrayList<Actor> nextTurnActors = new ArrayList<>();
		for (Actor actor : actors) {
			if (actor.isAlive())
				nextTurnActors.add(actor);
			else
				actor.removeAction(actors); // any special effect or whatever on removal

		}
		actors = nextTurnActors;

		// Check for collisions between zombies and plants and set collision status
		for (Actor actor : actors) {
			for (Actor other : actors) {
				actor.setCollisionStatus(other);
			}
		}

		// Move the actors.
		for (Actor actor : actors) {
			actor.move(); // for Zombie, only moves if not colliding.
			// If the zombie reaches the left side of the screen
			// a the timer will stop and 'Game Over' JPanel will appear
			if (actor.isCollidingPoint(new Point2D.Double(0, 100))) {
				super.add(gameOver);
				timer.stop();

			}
			if (actor.isCollidingPoint(new Point2D.Double(0, 200))) {
				super.add(gameOver);
				timer.stop();

			}
			if (actor.isCollidingPoint(new Point2D.Double(0, 300))) {
				super.add(gameOver);
				timer.stop();

			}
			if (actor.isCollidingPoint(new Point2D.Double(0, 400))) {
				super.add(gameOver);
				timer.stop();

			}
			if (actor.isCollidingPoint(new Point2D.Double(0, 500))) {
				super.add(gameOver);
				timer.stop();

			}
		}

		// update coins throughout the game
		if (randGenerator.nextInt(100) > 97) {
			coins = coins + 30;
			coinsCollected.setText("Coins Collected: " + coins);
			if (randGenerator.nextInt(100) > 75 && randGenerator.nextInt(100) < 85) {
				coins = coins + 75;
				coinsCollected.setText("Coins Collected: " + coins);
				if (randGenerator.nextInt(100) > 85 && randGenerator.nextInt(100) < 97) {
					coins = coins + 100;
					coinsCollected.setText("Coins Collected: " + coins);
				}
			}
		}
		// clicking on plants and checking the coin balance
		if (e.getSource() == simplePlant && coins < 50) {
			coinsSimplePlant = false;
			nsfCoins.setText("Not Enough Coins!");
		}
		if (e.getSource() == simplePlant && coins >= 50) {
			coinsSimplePlant = true;

		}

		if (e.getSource() == strongPlant && coins < 75) {
			coinsStrongPlant = false;
			nsfCoins.setText("Not Enough Coins!");
		}
		if (e.getSource() == strongPlant && coins >= 75) {
			coinsStrongPlant = true;

		}

		// Redraw the new scene
		difficultyEXP++;
		expPoints.setText("Points: " + difficultyEXP);
		repaint();
	}

	/**
	 * Make the game and run it
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame app = new JFrame("Plant and Zombie Test");
				app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				PlantsVsZombies panel;
				try {
					panel = new PlantsVsZombies();
					panel.setPreferredSize(size);
					app.setContentPane(panel);
					app.pack();
					app.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Something is wrong");
				}

			}
		});
	}

	/*
	 * @param int y which is the row of the mouse click
	 * 
	 * @return it returns a simplified row
	 */
	public int yPosition(int y) {
		y = (y / cellSize);

		return y;
	}

	/*
	 * @param int x which is the column of the mouse click
	 * 
	 * @return it returns a simplified column
	 */
	public int xPosition(int x) {
		x = (x / cellSize);

		return x;
	}

	/*
	 * Allows the code to check for plant locations and add them to the grid using
	 * their simplified column and row locations.
	 * 
	 * @param e
	 * 
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		// locates where on the grid the mouse was clicked
		// then sends it to the methods to get a simplified version
		// for example if the Y location was 232 it will bring back 2
		int x = e.getX();
		int y = e.getY();
		int placeRow = yPosition(y);
		int placeColumn = xPosition(x);
		int yPos = cellSize * placeRow;
		int xPos = (cellSize * placeColumn) + 50;

		// makes sure that the plants will bot be stacked one on top of the other.
		for (Actor actor : actors) {
			if (actor.isCollidingPoint(new Point2D.Double(xPos, yPos))) {
				coinsSimplePlant = false;
				coinsStrongPlant = false;
			}
		}
		// ensures that no plant will be placed outside of the grid.
		if (xPos > 600 || yPos > 400 || yPos <= 30) {
			outOfBounds.setText("OUT OF BOUNDS");
			coinsSimplePlant = false;
			coinsStrongPlant = false;
		}
		// checks to see if there are enough coins and then places the plant
		if (coinsSimplePlant == true) {
			nsfCoins.setText(" ");
			coins = coins - 50;
			coinsCollected.setText("Coins Collected: " + coins);
			simplePlant plant = new simplePlant(plantImage, xPos, yPos);

			actors.add(plant);
			outOfBounds.setText(" ");
			coinsSimplePlant = false;
		}

		if (coinsStrongPlant == true) {
			nsfCoins.setText(" ");
			coins = coins - 75;
			coinsCollected.setText("Coins Collected: " + coins);
			strongPlant plant2 = new strongPlant(plantImage2, xPos, yPos);
			actors.add(plant2);
			outOfBounds.setText(" ");
			coinsStrongPlant = false;
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}