/*
 * Name: Ebram Youssef
 * Partner's Name: Mahmoud Altarifi
 * eyousse2@u.rochester.edu
 * URID: 31529075
 * CSC172-3 (MW 6:15p-7:30p)
 * Spring 2022
 * Project 1 (2048)
 */

public class Board {
	
	// instance variables
	public int score = 0;
	int dim = 4;
	int border = 0;
	public Piece[][] board;
	
	
	/**
	 * Default constructor: instantiates a new 4x4 2D Array of type Piece
	 */
	
	public Board() {
		 board = new Piece[4][4];
	        for(int i=0; i<dim; i++)
	        {
	            for (int j=0; j<dim; j++)
	            {
	                board[i][j] = new Piece();
	            }
	        }
	}
	
	
	/**
	 * Getter: returns board as an array at current state
	 * @return board
	 */
	
	public Piece[][] getBoard() {
		return board;
	}
	
	
	/**
	 * returns the board as a string to be used in the GUI
	 * @return s
	 */
	
	public String toString() {
	       String s = "";
	       for (int i=0; i<dim; i++)
	       {
	           for (int j=0; j<dim; j++)
	           {
	              s += board[i][j].toString() + " ";
	           }
	           s += "\n";
	       }
	       return s;
	}
	
	
	/**
	 * Getter: returns the highest number on the board
	 * @return highScore
	 */
	
	public int getHighScore() {
		int highScore = board[0][0].getValue();
        for (int i=0; i<dim; i++)
        {
            for (int j=0; j<dim; j++)
            {
                if (board[i][j].getValue()>highScore)
                {
                    highScore = board[i][j].getValue();
                }
            }
        }
       // System.out.println();
       // System.out.println("Highest Tile: "+highScore);
        return highScore;
	}
	
	
	/**
	 * Getter: returns score (move count)
	 * @return score
	 */
	
	public int getScore() {
		return score;
	}
	
	
	/**
	 * prints score (number of moves made) and highest tile on the board
	 */
	
	public void printScore() {
		System.out.println("Number of moves: " + score);
		System.out.println("Highest tile: " + getHighScore());
	}
	
	
	/**
	 * checks whether the board is full (doesn't necessarily mean the game is over)
	 * @return boolean true/false
	 */
	public boolean isFull() {
		int count = 0;
        for (int i=0; i<dim; i++)
        {
            for (int j=0; j<dim; j++)
            {
                if (board[i][j].getValue()>0)
                {
                	count++;
                }
            }
        }
        
        if (count == 16)
        {
            return true;
        } 
    	
        return false;
	}
	
	
	/**
	 * spawns either a 2 (0.8 probability) or a 4 (0.2 probability) whenever a new move is made
	 * given there's empty space on the board
	 */
	
	public void placeRandom() {
        boolean isEmpty = true;
        while (isEmpty) {
            int row = (int)(Math.random()*4); // random row
            int col = (int)(Math.random()*4); // random column
            double x = Math.random(); // 2 and 4 probability
            if (board[row][col].getValue()==0) { 
                if (x < 0.2) {
                    board[row][col] = new Piece(4);
                    isEmpty = false;
	            }
                else {
                    board[row][col] = new Piece(2);
                    isEmpty = false;
	            }
            }
        }
	}
	
	/**
	 * this method uses a series of if/else statements to check
	 * whether there are valid moves to be made, if not, the game is over
	 * @return boolean true/false
	 */
	
	public boolean isOver() {
		int x = 0;
        for (int i=0; i<dim; i++)
        {
            for (int j=0; j<dim; j++ )
            {
                if (board[i][j].getValue()>0)
                {
                    if (i == 0 && j == 0)
                    {
                        if (board[i][j].getValue() != board[i+1][j].getValue()
                            && board[i][j].getValue() != board[i][j+1].getValue())
                        {
                            x++;
                        }
                    }
                    else if (i == 0 && j == 3)
                    {
                        if ( board[i][j].getValue() != board[i+1][j].getValue()
                            && board[i][j].getValue() != board[i][j-1].getValue())
                        {
                            x++;
                        }
                    }
                    else if (i == 3 && j == 0)
                    {
                        if (board[i][j].getValue() != board[i-1][j].getValue()
                            && board[i][j].getValue() != board[i][j+1].getValue())
                        {
                            x++;
                        }
                    }
                    else if (i == 3 && j == 3)
                    {
                        if (board[i][j].getValue() != board[i-1][j].getValue()
                            && board[i][j].getValue() != board[i][j-1].getValue())
                        {
                            x++;
                        }
                    }
                    else if (i == 3 && (j == 1 || j == 2))
                    {
                        if (board[i][j].getValue() != board[i-1][j].getValue()
                            && board[i][j].getValue() != board[i][j+1].getValue()
                            && board[i][j].getValue() != board[i][j-1].getValue())
                        {
                            x++;
                        }
                    }
                    else if (i == 0 && (j == 1 || j == 2))
                    {
                        if ( board[i][j].getValue() != board[i+1][j].getValue()
                            && board[i][j].getValue() != board[i][j+1].getValue()
                            && board[i][j].getValue() != board[i][j-1].getValue())
                        {
                            x++;
                        }
                    }
                    else if (j == 3 && (i == 1 || i == 2))
                    {
                        if (board[i][j].getValue() != board[i][j-1].getValue()
                            && board[i][j].getValue() != board[i-1][j].getValue()
                            && board[i][j].getValue() != board[i+1][j].getValue())
                        {
                            x++;
                        }
                    }
                    else if (j == 0 && (i == 1 || i == 2 ))
                    {
                        if (board[i][j].getValue() != board[i][j+1].getValue()
                            && board[i][j].getValue() != board[i-1][j].getValue()
                            && board[i][j].getValue() != board[i+1][j].getValue())
                        {
                            x++;
                        }
                    }
                    else
                    {
                        if (board[i][j].getValue() != board[i][j-1].getValue()
                            && board[i][j].getValue() != board[i][j+1].getValue()
                            && board[i][j].getValue() != board[i-1][j].getValue()
                            && board[i][j].getValue() != board[i+1][j].getValue())
                        {
                            x++;
                        }
                    }
                }
            }
        }
        if (x == 16) {
            return true;
        } 
    	return false;
	}
	
	
	/**
	 * this method manages the logic of a vertical move to add
	 * tiles if they match value. Recursion is used to go through
	 * the whole column
	 * @param row
	 * @param col
	 * @param dir : inputed direction (u for up or d down)
	 */
	
	public void verticalSwipe(int row, int col, char dir) {
        Piece first = board[border][col];
        Piece second = board[row][col];
        if (first.getValue() == 0 || first.getValue() == second.getValue())
        {
            if (row > border || (dir=='d' && (row < border)))
            {
                int mergedNumber = first.getValue() + second.getValue();
                first.setValue(mergedNumber);
                second.setValue(0);
            }
        }
        else
        {
            if (dir=='d')
            {
                border--;
            }
            else
            {
                border++;
            }
            verticalSwipe(row, col, dir);
        }
	}
	
	
	/**
	 * this method manages the movement of an upward swipe
	 * and calls verticalSwipe for each tile on the board
	 */
	
	public void swipeUp() {
	       for (int i = 0; i < dim; i++){
	           border = 0;
	           for (int j = 0; j < dim; j++){
	               if (board[j][i].getValue() != 0){
	                   if (border <= j){
	                       verticalSwipe( j, i, 'u');
	                   }
	               }
	           }
	       }
	}
	
	
	/**
	 * this method manages the movement of an downward swipe
	 * and calls verticalSwipe for each tile on the board
	 */
	
	public void swipeDown() {
		for (int i=0; i<dim; i++) {
			border = dim-1;
			for (int j=dim-1; j>=0; j--) {
				if (board[j][i].getValue() != 0) {
					if (border >= j) {
						verticalSwipe(j, i, 'd');
					}
				}
			}
		}
	}

	
	/**
	 * this method manages the logic of a horizontal move to add
	 * tiles if they match value. Recursion is used to go through
	 * the whole row
	 * @param row
	 * @param col
	 * @param dir (direction, r for right, l for left)
	 */
	
	public void horizontalSwipe(int row, int col, char dir) {
		Piece first = board[row][border];
        Piece second = board[row][col];
        if (first.getValue() == 0 || first.getValue() == second.getValue())  {
            if (col > border || (dir=='r'&& (col < border))) {
                int mergedNumber = first.getValue() + second.getValue();
                first.setValue(mergedNumber);
                second.setValue(0);
            }
        }
        else
        {
            if (dir == 'r') {
                border--;
            } else {
                border++;
            }
            horizontalSwipe(row, col, dir);
        }
	}
	
	
	/**
	 * this method manages the movement of an rightward swipe
	 * and calls horizontalSwipe for each tile on the board
	 */
	
	public void swipeRight() {
		for (int i = 0; i < dim; i++) {
			border = dim-1;
			for (int j = dim-1; j >= 0; j--) {
				if (board[i][j].getValue() != 0) {
					if (border >= j) {
						horizontalSwipe(i, j, 'r');
					}
				}
			}
		}
	}
	
	
	/**
	 * this method manages the movement of an rightward swipe
	 * and calls horizontalSwipe for each tile on the board
	 */
	
	public void swipeLeft() {
		for (int i = 0; i < dim; i++) {
			border = 0;
			for (int j = 0; j < dim; j++) {
				if (board[i][j].getValue() != 0) {
					if (border <= j) {
						horizontalSwipe(i, j, 'l');
					}
				}
			}
		}
	}
	
}
