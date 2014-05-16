package eLab.eLabTraining;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class PlayerTester extends JFrame implements KeyListener {

		static Player player;

		public PlayerTester() {
			player = new Player("Fred");

			getContentPane().setBackground(Color.white);
			setSize(600, 300);
			show();
			addKeyListener((KeyListener) this);
			
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			
			Graphics2D g2d = (Graphics2D)g;
			g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
		}

		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
			if (arg0.getKeyCode() == KeyEvent.VK_UP) {
				player.moveUp();
				repaint();
			} else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
				player.moveDown();
				repaint();
			} else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				player.moveRight();
				repaint();
			} else if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				player.moveLeft();
				repaint();
			}
		}

		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}

		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}

	}

