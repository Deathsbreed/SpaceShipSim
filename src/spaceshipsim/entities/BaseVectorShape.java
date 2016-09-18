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
	private float x, y;
	private float velX, velY;
	private float moveAngle, faceAngle;

	// Constructor:
	public BaseVectorShape() {
		setShape(null);
		setAlive(false);
		setX(0.0f);
		setY(0.0f);
		setVelX(0.0f);
		setVelY(0.0f);
		setMoveAngle(0.0f);
		setFaceAngle(0.0f);
	}

	// Accessor methods:
	public Shape getShape() { return shape; }
	public boolean isAlive() { return alive; }
	public float getX() { return x; }
	public float getY() { return y; }
	public float getVelX() { return velX; }
	public float getVelY() { return velY; }
	public float getMoveAngle() { return moveAngle; }
	public float getFaceAngle() { return faceAngle; }

	// Setter methods:
	public void setShape(Shape shape) { this.shape = shape; }
	public void setAlive(boolean alive) { this.alive = alive; }
	public void setX(float x) { this.x = x; }
	public void incX(float iX) { this.x += iX; }
	public void setY(float y) { this.y = y; }
	public void incY(float iY) { this.y += iY; }
	public void setVelX(float velX) { this.velX = velX; }
	public void incVelX(float iVX) { this.velX += iVX; }
	public void setVelY(float velY) { this.velY = velY; }
	public void incVelY(float iVY) { this.velY += iVY; }
	public void setMoveAngle(float nMA) { this.moveAngle = nMA; }
	public void incMoveAngle(float iMA) { this.moveAngle += iMA; }
	public void setFaceAngle(float nFA) { this.faceAngle = nFA; }
	public void incFaceAngle(float iFA) { this.faceAngle += iFA; }
}
