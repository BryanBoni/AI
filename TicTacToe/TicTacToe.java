public class TicTacToe extends GameSearch {

    public boolean tiedPosition(Position p) {
        // code to write
    }
    
    public boolean wonPosition(Position p, boolean player) {
       // code to write
    }

    public float positionEvaluation(Position p, boolean player) {
	  // code to write
    }
    
    public void printPosition(Position p) {
      // code to write
    }
    
    public boolean reachedMaxDepth(Position p, int depth) {
      // code to write
    }
        
    public Position [] possibleMoves(Position p, boolean player) {
        TicTacToePosition pos = (TicTacToePosition)p;
        int count = 0;
        for (int i=0; i<9; i++) if (pos.board[i] == 0) count++;
        if (count == 0) return null;
        Position [] ret = new Position[count];
        count = 0;
        for (int i=0; i<9; i++) {
            if (pos.board[i] == 0) {
                TicTacToePosition pos2 = new  TicTacToePosition();
                for (int j=0; j<9; j++) pos2.board[j] = pos.board[j];
                if (player) pos2.board[i] = 1; else pos2.board[i] = -1;
                ret[count++] = pos2;
            }
        }
        return ret;
    }
    
    public Position makeMove(Position p, boolean player) {
        int i = 0;
        try {
            int ch = System.in.read();
            i = ch - 48;
            System.in.read();
        } catch (Exception e) { }
        TicTacToeMove m = new TicTacToeMove();
        m.moveIndex = i;
        TicTacToePosition pos = (TicTacToePosition)p;
        TicTacToePosition pos2 = new  TicTacToePosition();
        for (int j=0; j<9; j++) pos2.board[j] = pos.board[j];
        int pp;
        if (player) pp =  1;
        else        pp = -1;
        pos2.board[m.moveIndex] = pp;
        return pos2;
    }
    
    static public void main(String [] args) {
        TicTacToePosition p = new TicTacToePosition();
        TicTacToe ttt = new TicTacToe();
        ttt.playGame(p);
    }
}
