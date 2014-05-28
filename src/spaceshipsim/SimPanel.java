package spaceshipsim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

import spaceshipsim.entities.*;

/**
 * @author Nicolás A. Ortega
 * @copyright Nicolás A. Ortega
 * @license GNU GPLv3
 * @year 2014
 * 
 */
public class SimPanel extends JPanel implements Runnable, KeyListener {
	public final static String version = "v0.3";

	// Graphics/Framework items
	private Thread gameloop;
	//private BufferedImage backbuffer;
	private Graphics2D g2d;
	//private AffineTransform identity = new AffineTransform();

	// The Ship
	private Ship ship;

	public SimPanel() {
		setFocusable(true);
		ship = new Ship(400, 300);
		addKeyListener(this);
		start();
	}

	public void start() {
		gameloop = new Thread(this);
		gameloop.start();
	}

	public void stop() { gameloop = null; }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;

		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, 800, 600);

		drawInfo();
		drawShip();
	}

	private void drawInfo() {
		g2d.translate(0, 10);
		g2d.setColor(Color.WHITE);
		g2d.drawString("Welcome to SpaceShipSim " + version, 10, 10);
		g2d.drawString("Position: " + (int)ship.getX() + ", " + (int)ship.getY(), 10, 25);
		g2d.drawString("Velocity (px/s): " + (int)(ship.getVelX() * 50) + ", " + (int)(ship.getVelY() * 50), 10, 40);
		g2d.drawString("Acceleration (px/s/s): " + (int)(ship.getAccelX() * Math.pow(50, 2)) + ", " + (int)(ship.getAccelY() * Math.pow(50, 2)), 10, 55);
		g2d.drawString("Move Angle: " + (int)ship.getMoveAngle(), 10, 70);
		g2d.drawString("Face Angle: " + (int)(ship.getFaceAngle() - 90), 10, 85);
	}

	private void drawShip() {
		g2d.translate(ship.getX(), ship.getY());
		g2d.rotate(Math.toRadians(ship.getFaceAngle()));
		g2d.setColor(Color.RED);
		g2d.fill(ship.getShape());
	}

	public void run() {
		Thread t = Thread.currentThread();

		while(t == gameloop) {
			try {
				ship.update();

				Thread.sleep(20);
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}

			repaint();
		}
	}

	public void keyPressed(KeyEvent ke) {
		int keyCode = ke.getKeyCode();

		if(keyCode == KeyEvent.VK_UP) { ship.setAccelerate(true); }
		if(keyCode == KeyEvent.VK_LEFT) { ship.setTurnLeft(true); }
		if(keyCode == KeyEvent.VK_RIGHT) { ship.setTurnRight(true); }
	}
	public void keyReleased(KeyEvent ke) {
		int keyCode = ke.getKeyCode();

		if(keyCode == KeyEvent.VK_UP) { ship.setAccelerate(false); }
		if(keyCode == KeyEvent.VK_LEFT) { ship.setTurnLeft(false); }
		if(keyCode == KeyEvent.VK_RIGHT) { ship.setTurnRight(false); }
	}
	public void keyTyped(KeyEvent ke) {}

	public void reset() {
		ship = new Ship(400, 300);
	}
}