package eLab.eLabTraining;

import java.awt.Image;
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
	int characterSpeed = 2;
	Image playerState;
	int x, y;
		
	ImageIcon front = new ImageIcon("resources/front_1.png");
	ImageIcon back = new ImageIcon("resources/back_1.png");
	ImageIcon right = new ImageIcon("resources/right_1.png");
	ImageIcon left = new ImageIcon("resources/left_1.png");

	

	public Player(String player) {
		// TODO Auto-generated constructor stub
		playerName = player;
		playerState = front.getImage();
		x = 300;
		y = 150;
	}
	
//	public JLabel getCharacter() {
//		return character;
//	}
	
	public void moveRight() {
		playerState = right.getImage();
		x += characterSpeed;
    }

    public void moveLeft() {
    	playerState = left.getImage();
    	x -= characterSpeed;
    }

    public void moveUp() {
    	playerState = back.getImage();
    	y -= characterSpeed;
    }

    public void moveDown() {
    	playerState = front.getImage();
    	y += characterSpeed;
    }
	
	public Image getImage() {
		return playerState;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
