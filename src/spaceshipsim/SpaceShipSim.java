package spaceshipsim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.*;

import spaceshipsim.entities.*;

/**
 * @author Nicolás A. Ortega
 * @copyright Nicolás A. Ortega
 * @license GNU GPLv3
 * @year 2014
 * 
 */
public class SpaceShipSim extends JFrame implements Runnable, KeyListener {
	private final String version = "v0.2";

	// Menu items
	JMenuBar menuBar;
	JMenu simulationMenu;
	JMenuItem exitMenuItem;

	// Graphics/Framework items
	private Thread gameloop;
	private BufferedImage backbuffer;
	private Graphics2D g2d;
	private AffineTransform identity = new AffineTransform();

	// The Ship
	private Ship ship;

	// Constructor:
	public SpaceShipSim() {
		super("Space Ship Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		menuSetup();
		setVisible(true);

		backbuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
		g2d = backbuffer.createGraphics();

		ship = new Ship(400, 300);
		addKeyListener(this);

		start();
	}

	// FIXME: There are no errors in compilation or while running, but the menu bar does not appear
	public void menuSetup() {
		menuBar = new JMenuBar();
		simulationMenu = new JMenu("Simulation");
		exitMenuItem = new JMenuItem("Exit");

		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				stop();
				System.exit(0);
			}
		});
		menuBar.add(simulationMenu);
		this.setJMenuBar(menuBar);
	}
	// !!!FIXME-END!!!

	public void start() {
		gameloop = new Thread(this);
		gameloop.start();
	}

	public void stop() { gameloop = null; }

	public void paint(Graphics g) {
		g2d.setTransform(identity);
		g2d.setPaint(Color.BLACK);
		g2d.fillRect(0, 0, getSize().width, getSize().height);

		drawInfo();
		drawShip();

		g.drawImage(backbuffer, 0, 0, this);
	}

	private void drawInfo() {
		g2d.setPaint(Color.WHITE);
		g2d.drawString("Welcome to SpaceShipSim " + version, 10, 40);
		g2d.drawString("Position: " + (int)ship.getX() + ", " + (int)ship.getY(), 10, 55);
		g2d.drawString("Velocity (px/s): " + (int)(ship.getVelX() * 50) + ", " + (int)(ship.getVelY() * 50), 10, 70);
		g2d.drawString("Acceleration (px/s/s): " + (int)(ship.getAccelX() * Math.pow(50, 2)) + ", " + (int)(ship.getAccelY() * Math.pow(50, 2)), 10, 85);
		g2d.drawString("Move Angle: " + (int)ship.getMoveAngle(), 10, 100);
		g2d.drawString("Face Angle: " + (int)(ship.getFaceAngle() - 90), 10, 115);
	}

	private void drawShip() {
		g2d.setTransform(identity);
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

	public static void main(String[] args) { new SpaceShipSim(); }
}