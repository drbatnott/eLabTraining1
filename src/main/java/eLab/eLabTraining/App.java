package eLab.eLabTraining;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * Hello world!
 * 
 */
public class App extends JFrame implements KeyListener {

	static Player fred;

	public App() {
		fred = new Player("fred");

		getContentPane().setBackground(Color.white);
		setSize(600, 300);
		show();
		addKeyListener((KeyListener) this);
		
	}

	public static void main(String[] args) {
		App app = new App();
		System.out.println("Hello World w a7la messa 3al 7elween :D");

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(fred.getImage(), fred.getX(), fred.getY(), this);
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			fred.moveUp();
			repaint();
		} else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			fred.moveDown();
			repaint();
		} else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			fred.moveRight();
			repaint();
		} else if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			fred.moveLeft();
			repaint();
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("pressed");
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("pressed");
	}

}
