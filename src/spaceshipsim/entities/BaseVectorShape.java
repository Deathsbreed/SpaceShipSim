package spaceshipsim.entities;

import java.awt.Shape;

/**
 * @author Nicolás A. Ortega
 * @copyright Nicolás A. Ortega
 * @license GNU GPLv3
 * @year 2014
 * 
 */
public class BaseVectorShape {
	private Shape shape;
	private boolean alive;
	private double x, y;
	private double velX, velY;
	private double moveAngle, faceAngle;

	// Constructor:
	public BaseVectorShape() {
		setShape(null);
		setAlive(false);
		setX(0.0);
		setY(0.0);
		setVelX(0.0);
		setVelY(0.0);
		setMoveAngle(0.0);
		setFaceAngle(0.0);
	}

	// Accessor methods:
	public Shape getShape() { return shape; }
	public boolean isAlive() { return alive; }
	public double getX() { return x; }
	public double getY() { return y; }
	public double getVelX() { return velX; }
	public double getVelY() { return velY; }
	public double getMoveAngle() { return moveAngle; }
	public double getFaceAngle() { return faceAngle; }

	// Setter methods:
	public void setShape(Shape shape) { this.shape = shape; }
	public void setAlive(boolean alive) { this.alive = alive; }
	public void setX(double x) { this.x = x; }
	public void incX(double iX) { this.x += iX; }
	public void setY(double y) { this.y = y; }
	public void incY(double iY) { this.y += iY; }
	public void setVelX(double velX) { this.velX = velX; }
	public void incVelX(double iVX) { this.velX += iVX; }
	public void setVelY(double velY) { this.velY = velY; }
	public void incVelY(double iVY) { this.velY += iVY; }
	public void setMoveAngle(double nMA) { this.moveAngle = nMA; }
	public void incMoveAngle(double iMA) { this.moveAngle += iMA; }
	public void setFaceAngle(double nFA) { this.faceAngle = nFA; }
	public void incFaceAngle(double iFA) { this.faceAngle += iFA; }
}