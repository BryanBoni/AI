package TicTacToe;

/*
This class allocate an array of nine integers to represent the board, 
defines constant values for empty, human, and computer cells, 
and defines a toString method to print out the board representation to a string. 
The board position indices are in the range of [0..8] 
and can be considered to be in the following order: 
    0 1 2 
    3 4 5 
    6 7 8
 */

public class TicTacToePosition extends Position {

    int BLANK, HUMAN, PROGRAM;
    int[] board;

    public TicTacToePosition() {
        //Setting the game variable
        BLANK = 0;
        HUMAN = 1;
        PROGRAM = -1;
        board = new int[9];
    }

    @Override
    public String toString() {
        //Printing the board
        String strBoard = "\n|";
        for (int i = 0; i < 9; i++) {
            if (board[i] == -1) {
                strBoard += " O " + "|";
            } else if (board[i] == 1) {
                strBoard += " X " + "|";
            } else {
                strBoard += " "+ i +" " + "|";
            }
            if (i == 2 || i == 5) {
                strBoard += "\n|---+---+---|\n|";
            }
        }
        strBoard += "\n";
        return strBoard;
    }

    public int[] getBoard() {
        return board;
    }
}
