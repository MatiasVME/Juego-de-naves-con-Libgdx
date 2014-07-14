package Imputs;

public class VirtualController {
	
	// falta: cambiar a privado las propiedades
	
	public boolean moveRight;
	public boolean moveLeft;
	public boolean shoot;
	
	public boolean getMoveRight() {
		return this.moveRight;
	}
	
	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}
	
	public boolean getMoveLeft() {
		return this.moveLeft;
	}
	
	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}
	public boolean getShoot() {
		return this.shoot;
	}
	
	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}
}
