package eLab.eLabTraining;

import java.awt.Point;
import java.io.CharConversionException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player {
	
	String playerName;
	String playerCharacter;
	int playerScore;
	int playerLevel;
	int playerRemainingTime;
	JLabel character;
	int characterSpeed = 2;
		
	ImageIcon front = new ImageIcon("resources/front_1.png");
	ImageIcon back = new ImageIcon("resources/back_1.png");
	ImageIcon right = new ImageIcon("resources/right_1.png");
	ImageIcon left = new ImageIcon("resources/left_1.png");

	

	public Player(String player) {
		// TODO Auto-generated constructor stub
		playerName = player;
		character = new JLabel(front);
	}
	
	public JLabel getCharacter() {
		return character;
	}
	
	public void moveRight(Point p) {
		character.setIcon(right);
		character.setLocation(p.x+characterSpeed, p.y);
    }

    public void moveLeft(Point p) {
    	character.setIcon(left);
    	character.setLocation(p.x-characterSpeed, p.y);
    }

    public void moveUp(Point p) {
    	character.setIcon(back);
    	character.setLocation(p.x, p.y-characterSpeed);
    }

    public void moveDown(Point p) {
    	character.setIcon(front);
    	character.setLocation(p.x, p.y+characterSpeed);
    }
	
	

}
