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
	private float accelerateX;
	private float accelerateY;

	// Constructor:
	public Ship(float nx, float ny) {
		setX(nx);
		setY(ny);
		setShape(new Polygon(shipx, shipy, shipx.length));
		setAlive(true);
	}

	// Update Method:
	public void update() {
		if(accelerate) {
			setMoveAngle(getFaceAngle() - 90);
			accelerateX = calcAngleMoveX(getMoveAngle()) * 0.1f;
			accelerateY = calcAngleMoveY(getMoveAngle()) * 0.1f;
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

	public float getAccelX() { return accelerateX; }
	public float getAccelY() { return accelerateY; }

	// Setter methods:
	public void setAccelerate(boolean accel) { this.accelerate = accel; }
	public void setAccelX(float aX) { this.accelerateX = aX; }
	public void setAccelY(float aY) { this.accelerateY = aY; }
	public void incAccelX(float iaX) { this.accelerateX += iaX; }
	public void incAccelY(float iaY) { this.accelerateY += iaY; }
	public void setTurnLeft(boolean tL) { this.turnLeft = tL; }
	public void setTurnRight(boolean tR) { this.turnRight = tR; }

	// Methods used for calculations:
	public float calcAngleMoveX(float angle) { return (float)Math.cos(angle * Math.PI / 180); }
	public float calcAngleMoveY(float angle) { return (float)Math.sin(angle * Math.PI / 180); }
}
