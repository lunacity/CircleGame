//Entity Class

package CircleGame;


public class Entity {
	
	private int x = 200;
	private int y = 200;
	private int speedX = 0;
	private int speedY = 0;
	
	private boolean attacked = false;
	
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean movingUp = false;
	private boolean movingDown = false;
	
	
	public void update() {
		x += speedX;
		y += speedY;
	}
	
	public void moveRight() {
		speedX=5;
	}
		
	public void moveLeft() {
		speedX=-5;
	}
		
	public void moveUp() {
		speedY=-5;
	}
		
	public void moveDown() {
		speedY=5;
	}
	
	public void stop() {
		speedX = 0;
		speedY = 0;
	}
		
	public void attack() {
		if(attacked==false){
			//attackanimationhere;
			attacked=true;
		}
	}

	public void setCenterY(int centerY) {
		this.y = centerY;
	}

	public void setCenterX(int centerX) {
		this.x = centerX;
	}
	
	public int getCenterX(){
		return x;
	}
	
	public int getCenterY() {
		return y;
	}

	public int setSpeedY(int speedX) {
		this.speedX = speedX;
		return x;
	}

	public int setSpeedX(int speedY) {
		this.speedY = speedY;
		return y;
	}
	
	public int getSpeedX(){
		return speedX;
	}
	
	public int getSpeedY() {
		return speedY;
	}
	
	public boolean isAttack() {
		return attacked;
	}
	
	public void setAttack(boolean attacked) {
		this.attacked = attacked;
	}
}
