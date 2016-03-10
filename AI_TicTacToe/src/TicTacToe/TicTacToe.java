package TicTacToe;

public class TicTacToe extends GameSearch {

    public boolean tiedPosition(Position p) {
        //return true if the given position is a tie situation.

        return true;
    }

    public boolean wonPosition(Position p, boolean player) {
        //return true it the input position is won for the indicated player.
        return true;
    }

    public float positionEvaluation(Position p, boolean player) {
        /*
        return a position evaluation for a specified board position and player. 
        If it is called switching the player for the same board position, 
        then the returned value is the negative of the value calculated for the opposing player.
         */
        return 0.0f;
    }

    public void printPosition(Position p) {
        // display a text-based representation of the board
    }

    public boolean reachedMaxDepth(Position p, int depth) {
        /*
        return a Boolean true value if the search process has reached a satisfactory depth. 
        For the tic-tac-toe program, 
        the method reachedMaxDepth does not return true unless either side has won the game or the board is full.
        */
        return true;
    }

    public Position[] possibleMoves(Position p, boolean player) {
        //return an array of objects belonging to the class Position.
        TicTacToePosition pos = (TicTacToePosition) p;
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (pos.board[i] == 0) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        Position[] ret = new Position[count];
        count = 0;
        for (int i = 0; i < 9; i++) {
            if (pos.board[i] == 0) {
                TicTacToePosition pos2 = new TicTacToePosition();
                for (int j = 0; j < 9; j++) {
                    pos2.board[j] = pos.board[j];
                }
                if (player) {
                    pos2.board[i] = 1;
                } else {
                    pos2.board[i] = -1;
                }
                ret[count++] = pos2;
            }
        }
        return ret;
    }

    public Position makeMove(Position p, boolean player) {
        //will return a new position object for a specified board position,side to move, and move.
        int i = 0;
        try {
            int ch = System.in.read();
            i = ch - 48;
            System.in.read();
        } catch (Exception e) {
        }
        TicTacToeMove m = new TicTacToeMove();
        m.moveIndex = i;
        TicTacToePosition pos = (TicTacToePosition) p;
        TicTacToePosition pos2 = new TicTacToePosition();
        for (int j = 0; j < 9; j++) {
            pos2.board[j] = pos.board[j];
        }
        int pp;
        if (player) {
            pp = 1;
        } else {
            pp = -1;
        }
        pos2.board[m.moveIndex] = pp;
        return pos2;
    }

}
