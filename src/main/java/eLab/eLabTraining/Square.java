package spiderGame;



public class Square {
	
	public int x;
	public int y;
	public int width;
	public int height;
	public boolean selected;
	public int ID;
	
	public Square(){ }
	
	public Square(int ID, int x, int y, int width, int height){
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void setValues(int ID, int x, int y, int width, int height){
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void selectCharacter(){
		selected = true;
	}
	
	public void deselectCharacter(){
		selected = false;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}	

}
