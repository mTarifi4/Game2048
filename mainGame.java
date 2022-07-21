/*
 * Name: Ebram Youssef
 * Partner's Name: Mahmoud Altarifi
 * eyousse2@u.rochester.edu
 * URID: 31529075
 * CSC172-3 (MW 6:15p-7:30p)
 * Spring 2022
 * Project 1 (2048)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Scanner;

public class mainGame extends JPanel implements KeyListener {

	Board game = new Board();
	static mainGame newGame = new mainGame();
	static JFrame f = new JFrame("Project 1 - 2048");
	String boardString = game.toString();
	
	
	/**
	 * starts a new GUI with a key listener
	 */
	
	public static void startGUI() {
		f.addKeyListener(newGame);
		f.getContentPane().add(newGame);
		f.setSize(600, 450);
		f.setResizable(false);
		f.setVisible(true);
		f.getContentPane().setBackground(new Color(250,248,239));
	}
	
	
	/**
	 * takes an action based on the key entered
	 */
	
	@Override
	public void keyPressed(KeyEvent e) {
		Scanner s = new Scanner(System.in);
		if(e.getKeyChar()== 'w' || e.getKeyChar()== 'W' || e.getKeyCode() == KeyEvent.VK_UP) {
			game.swipeUp();
			game.placeRandom();
			boardString = game.toString();
			f.repaint();
			game.score ++;
			if (e.getKeyChar()=='w' || e.getKeyChar()== 'W') {
				System.out.println("Key pressed: w \nValid move");
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("Key pressed: up arrow \nValid move");
			}
			game.printScore();
		} else if (e.getKeyChar() == 's' || e.getKeyChar() == 'S' || e.getKeyCode() == KeyEvent.VK_DOWN) {
			game.swipeDown();
			game.placeRandom();
			boardString = game.toString();
			f.repaint();
			game.score ++;
			if (e.getKeyChar()=='s' || e.getKeyChar()== 'S') {
				System.out.println("Key pressed: s \nValid move");
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("Key pressed: down arrow \nValid move");
			}
			game.printScore();
		} else if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D' || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			game.swipeRight();
			game.placeRandom();
			boardString = game.toString();
			f.repaint();
			game.score ++;
			if (e.getKeyChar()=='d' || e.getKeyChar()== 'D') {
				System.out.println("Key pressed: d \nValid move");
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("Key pressed: right arrow \nValid move");
			}
			game.printScore();
		} else if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A' || e.getKeyCode() == KeyEvent.VK_LEFT) {
			game.swipeLeft();
			game.placeRandom();
			boardString = game.toString();
			f.repaint();
			game.score ++;
			if (e.getKeyChar()=='a' || e.getKeyChar()== 'A') {
				System.out.println("Key pressed: a \nValid move");
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("Key pressed: left arrow \nValid move");
			}
			game.printScore();
		} else if (e.getKeyChar () == 'r' || e.getKeyChar() == 'R') {
			System.out.println("Are you sure you would like to restart? Type 'y' in the console to confirm.");
			String in = s.next();
			if(in.equals("y")) {
				game = new Board();
				game.placeRandom();
				game.placeRandom();
				f.repaint();
				game.score ++;
				game.printScore();
			}
			
		} else if (e.getKeyChar () == 'q' || e.getKeyChar() == 'Q') {
			System.out.println("Are you sure you would like to quit? Type 'y' in the console to confirm.");
			String in = s.next();
			if(in.equals("y")) {
				f.dispose();
				System.out.println("Final Score: "+game.score);
				System.out.println("Highest Tile: "+game.getHighScore());
			}
			
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            game = new Board();
            game.placeRandom();
            game.placeRandom();
            f.repaint();
			game.score ++;
			game.printScore();
		}
	}
	
	
	/**
	 * draws tiles on the GUI
	 * colors used are based on the original game
	 * @param g
	 * @param piece
	 * @param x
	 * @param y
	 */
	public void drawTiles(Graphics g, Piece piece, int x, int y) {
        int tileValue = piece.getValue();
        int length = String.valueOf( tileValue ).length();
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(new Color(205, 193, 180));
        g2.fillRoundRect( x, y, 50, 50, 5, 5 );
        g2.setColor( Color.black );
        if (tileValue > 0)
        {
            g2.setColor(piece.getColor());
            g2.fillRoundRect(x, y, 50, 50, 5, 5);
            Color txt;
            if (piece.getValue() == 2 ||piece.getValue() ==  4) {
            	txt = new Color(119, 110, 101);
            }
            else {
                txt = new Color(249, 246, 242);
            }
            g2.setColor(txt);
            g.drawString("" + tileValue, x + 25 - 3 * length, y + 25);
        }
    }

	
	/**
	 * Paints the GUI and user interface; GUI changes when game ends
	 */
	
	public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawString("Score: " + game.getScore(), 220, 40);
        g2.drawString("Highest Tile: " + game.getHighScore(), 220, 20);
        g2.drawString( "Press ENTER to START", 210, 315);
        g2.drawString( "Press 'r' to RESTART", 210, 335);
        g2.drawString( "Press w, a, s, d or arrow keys to MOVE", 180, 355);
        g2.drawString( "Press 'q' to QUIT", 230, 375);
        Color bgframe = new Color(187, 173, 160);
        g2.setColor(bgframe);
        g2.fillRect(140, 50, 250, 250);
        for (int i = 0; i < 4; i++) {
            for ( int j = 0; j < 4; j++ ) {
                drawTiles(g, game.board[i][j], j * 60 + 150, i * 60 + 60);
            }
        }
        if (game.isOver() || game.isFull()) {
            g2.setColor(Color.gray);
            g2.fillRect(140, 50, 250, 250);
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    g2.setColor( Color.blue );
                    g2.fillRoundRect(j * 60 + 150, i * 60 + 60, 50, 50, 5, 5);
                    g2.setColor( Color.black );
                    g.drawString("GAME", j * 60 + 160, i * 60 + 75);
                    g.drawString("OVER", j * 60 + 160, i * 60 + 95);
                }
            }
        }
    }
	
	@Override
    public void keyTyped(KeyEvent e) {
        // created to be able to implement KeyListener in the class without errors

    }
	
	@Override
    public void keyReleased(KeyEvent e) {
		// created to be able to implement KeyListener in the class without errors

    }
	
	public static void main(String[] args) {
		startGUI();
	}
}
