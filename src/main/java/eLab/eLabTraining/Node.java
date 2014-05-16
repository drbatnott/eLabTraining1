package eLab.eLabTraining;


public class Node {

	
	private CoOrds cO;
	private int value;
	private int nodeID;
	private boolean display;
	private boolean selected;
	private boolean correct;
	
	public void setCoOrds (CoOrds cO){
		this.cO = cO;
	}
	
	public CoOrds getCoOrds(){
		return cO;
	}
	
	public int getX(){
		return cO.getX();
	}
	
	public int getY(){
		return cO.getY();
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setNodeID(int id){
		nodeID = id;
	}
	
	public int getNodeID(){
		return nodeID;
	}
	
	public void setDisplay(boolean d){
		display = d;
	}
	
	public boolean getDisplay(){
		return display;
	}
	
	public void setSelected(boolean s){
		selected = s;
	}
	
	public boolean getSelected(){
		return selected;
	}
	
	public void setCorrect(int c){
		if(c == 0){
			correct = false;
		}else{
			correct = true;
		}
	}
	
	public boolean getCorrect(){
		return correct;
	}
	
}
