package eLab.eLabTraining;


public class CoOrds {
	private int x;
	private int y;
	
	public CoOrds(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public CoOrds() {
		// TODO Auto-generated constructor stub
	}

	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setValues(int x, int y){
		this.x = x;
		this.y = y;
	}
}
