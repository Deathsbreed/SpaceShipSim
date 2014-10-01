package spaceshipsim.entities;

import java.awt.*;

/**
 * @author Nicolás A. Ortega
 * @copyright Nicolás A. Ortega
 * @license GNU GPLv3
 * @year 2014
 * 
 */
public class Ship extends BaseVectorShape {
	// Ship shape points for vector image
	private int[] shipx = { -6, -3, 0, 3, 6, 0 };
	private int[] shipy = { 6, 7, 7, 7, 6, -7 };

	// Booleans for movement
	private boolean accelerate = false;
	private boolean turnLeft = false;
	private boolean turnRight = false;

	// Acceleration variables
	private double accelerateX;
	private double accelerateY;

	// Constructor:
	public Ship(double nx, double ny) {
		setX(nx);
		setY(ny);
		setShape(new Polygon(shipx, shipy, shipx.length));
		setAlive(true);
	}

	// Update Method:
	public void update() {
		if(accelerate) {
			setMoveAngle(getFaceAngle() - 90);
			accelerateX = calcAngleMoveX(getMoveAngle()) * 0.1;
			accelerateY = calcAngleMoveY(getMoveAngle()) * 0.1;
			incVelX(accelerateX);
			incVelY(accelerateY);
		} else {
			accelerateX = 0;
			accelerateY = 0;
		}
		if(turnLeft) {
			incFaceAngle(-5);
			if(getFaceAngle() < 0) { setFaceAngle(355); } // 355 = 360 - 5
		}
		if(turnRight) {
			incFaceAngle(5);
			if(getFaceAngle() > 360) { setFaceAngle(5); }
		}

		incX(getVelX());
		incY(getVelY());
	}

	// Accessor methods:
	public Rectangle getBounds() {
		Rectangle r;
		r = new Rectangle((int)getX() - 6, (int)getY() - 6, 12, 12);
		return r;
	}

	public double getAccelX() { return accelerateX; }
	public double getAccelY() { return accelerateY; }

	// Setter methods:
	public void setAccelerate(boolean accel) { this.accelerate = accel; }
	public void setAccelX(double aX) { this.accelerateX = aX; }
	public void setAccelY(double aY) { this.accelerateY = aY; }
	public void incAccelX(double iaX) { this.accelerateX += iaX; }
	public void incAccelY(double iaY) { this.accelerateY += iaY; }
	public void setTurnLeft(boolean tL) { this.turnLeft = tL; }
	public void setTurnRight(boolean tR) { this.turnRight = tR; }

	// Methods used for calculations:
	public double calcAngleMoveX(double angle) { return (double) (Math.cos(angle * Math.PI / 180)); }
	public double calcAngleMoveY(double angle) { return (double) (Math.sin(angle * Math.PI / 180)); }
}
