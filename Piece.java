/*
 * Name: Ebram Youssef
 * Partner's Name: Mahmoud Altarifi
 * eyousse2@u.rochester.edu
 * URID: 31529075
 * CSC172-3 (MW 6:15p-7:30p)
 * Spring 2022
 * Project 1 (2048)
 */

import java.awt.Color;

public class Piece {
	
	// instance variables
	
	int val;
	Color color;
	
	
	/**
	 * Default constructor: instantiates a new piece (default val = 0)
	 */
	public Piece() {
		val = 0;
	}
	
	
	/**
	 * constructor: creates a piece with a specific integer value
	 * @param value
	 */
	
	public Piece(int value) {
		val = value;
	}
	
	
	/**
	 * Getter: returns integer value of a specific piece
	 * @return
	 */
	
	public int getValue() {
		return val;
	}
	
	
	/**
	 * Setter: sets the value of a specific piece to a new integer value
	 * @param value
	 */
	public void setValue(int value) {
		val = value;
	}
	
	
	/**
	 * Getter: returns color of a specific piece 
	 * @return
	 */
	
	public Color getColor() {
        this.setColor();
        return color;
    }
	
	
	/**
	 * Setter: sets the color of a piece according to its value
	 * all the colors picked are based on the RGB values of the
	 * colors used in the original game attached in the project PDF file
	 * https://2048game.com/
	 */
	
	public void setColor() {
		if (this.getValue() == 2) {
            color = new Color(238, 228, 218);
        } else if (this.getValue() == 4) {
            color = new Color(237, 224, 200);
        } else if (this.getValue() == 8) {
            color = new Color(242, 177, 121);
        }  else if (this.getValue() == 16) {
            color = new Color(245, 149, 99);
        } else if (this.getValue() == 32) {
            color = new Color(246, 124, 95);
        }  else if (this.getValue() == 64) {
            color = new Color(246, 94, 59);
        } else if (this.getValue() == 128) {
            color = new Color(237, 207, 114);
        } else if (this.getValue() == 256) {
            color = new Color(237, 204, 97);
        } else if (this.getValue() == 512) {
            color = new Color(237, 200, 80);
        } else if ( this.getValue() == 1024) {
            color = new Color(237, 197, 63);
        } else {
            color = new Color(237, 194, 46);
        }
	}
}
