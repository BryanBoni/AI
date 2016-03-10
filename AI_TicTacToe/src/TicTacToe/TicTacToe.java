package TicTacToe;

/*
    The TicTacToe class defines the methods tiedPosition, 
    wonPosition, positionEvaluation, printPosition, reachedMaxDepth, 
    possibleMoves and makeMove from the GameSearch base class. 
    These methods must always cast arguments of class type Position 
    and Move to TicTacToePosition and TicTacToeMove.
 */
public class TicTacToe extends GameSearch {

    public boolean tiedPosition(Position p) {
        //return true if the given position is a tie situation.
        boolean isTie = true;
        int[] currentBoard = ((TicTacToePosition) p).getBoard();

        for (int i = 0; i < 9; i++) {
            if (currentBoard[i] == 0) {
                return isTie = false;//imediately return false if it's not a tie situation.
            }
        }
        return isTie;
    }

    public boolean wonPosition(Position p, boolean player) {
        /*
        This function test for all possible winning patterns.
        Return true it the input position is won for the indicated player.
         */
        boolean isWinning = false;

        int[] currentBoard = ((TicTacToePosition) p).getBoard();
        int currPlayer = (player == true) ? 1 : -1;//if it's the player, currPlayer = 1 else -1.

        if ((currentBoard[0] == currPlayer && currentBoard[4] == currPlayer && currentBoard[8] == currPlayer)) {//analysing the line winnning situation
            isWinning = true;
        } else if ((currentBoard[2] == currPlayer && currentBoard[4] == currPlayer && currentBoard[6] == currPlayer)) {
            isWinning = true;
        }

        for (int i = 0; i < 3; i++) {
            //analysing the diagonal winning situation
            if ((currentBoard[i] == currPlayer && currentBoard[i + 3] == currPlayer && currentBoard[i + 6] == currPlayer)) {
                isWinning = true;
            } else if ((currentBoard[3 * i] == currPlayer && currentBoard[3 * i + 1] == currPlayer && currentBoard[3 * i + 2] == currPlayer)) {
                isWinning = true;
            }
        }
        return isWinning;
    }

    public float positionEvaluation(Position p, boolean player) {
        /*
        return a position evaluation for a specified board position and player. 
        If it is called switching the player for the same board position, 
        then the returned value is the negative of the value calculated for the opposing player.
         */
        if(!(wonPosition(p, player))){
            return -10.0f;
        }else{
            return +10.0f;
        }
    }

    public void printPosition(Position p) {
        // display a text-based representation of the board
        System.out.println("The Current Board :\n" + ((TicTacToePosition)p).toString());
    }

    public boolean reachedMaxDepth(Position p, int depth) {
        /*
        return a Boolean true value if the search process has reached a satisfactory depth. 
        For the tic-tac-toe program, 
        the method reachedMaxDepth does not return true unless either side has won the game or the board is full.
         */
        if(wonPosition(p,false) ||  tiedPosition(p) || wonPosition(p,true)) {
            return true;
        }else{
            return false;
        }    
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
