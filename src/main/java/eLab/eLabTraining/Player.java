package spiderGame;



import java.awt.Color;

public class Player {
	
	public String spriteID;
	public Color colour;
	public Color selectedColour;
	
	public void newPlayer(Color colour, Color selectedColour){
		this.colour = colour;
		this.selectedColour = selectedColour;
	}
	
	public void setSprite(String id){
		this.spriteID = id;
	}

	public String getSpriteID(){
		return spriteID;
	}
	
	public Color getColour(){
		return colour;
	}
	
	public Color getSelectedColour(){
		return selectedColour;
	}
	
}
