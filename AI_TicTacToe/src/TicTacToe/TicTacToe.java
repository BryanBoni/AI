package TicTacToe;
import TicTacToe.Position;
/*import Maze.*;*/

public class TicTacToe extends GameSearch {

   

    public float positionEvaluation(Position p, boolean player) {
        return 0;
	  // code to write
    }
    
    public void printPosition(Position p) {
      // code to write
    }
    
    public boolean reachedMaxDepth(Position p, int depth) {
        return false;
      // code to write
    }
        
    public Position [] possibleMoves(Position p, boolean player) {
        Position pos = (Position)p;
        int count = 0;
        for (int i=0; i<9; i++) if (pos.board[i] == 0) count++;
        if (count == 0) return null;
        Position [] ret = new Position[count];
        count = 0;
        for (int i=0; i<9; i++) {
            if (pos.board[i] == 0) {
                Position pos2 = new  Position();
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
        Move m = new TicTacToeMove();
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
    

    public boolean tiedPosition(TicTacToePosition p) {
            if(wonPosition(p,true) || wonPosition(p,false))
                return false; // already won

            if(p.getTurn()==9)
                return true; // last turn passed
            else
                return false; // can play at lest another turn
        }

        public boolean wonPosition(TicTacToePosition p, boolean player) {
            int play=player ? 1 : -1;
            for(int j=0;j<3;j++) {
                if(p.board[0+j*3]==play && p.board[1+j*3]==play && p.board[2+j*3]==play)
                    return true; // horizontal win
                if(p.board[j+0]==play && p.board[j+3]==play && p.board[j+6]==play)
                    return true; // vertical win
            }
            if(p.board[0]==play && p.board[4]==play && p.board[8]==play)
                    return true; // diagonal win
            if(p.board[2]==play && p.board[4]==play && p.board[6]==play)
                    return true; // diagonal win

            return false;
        }

        public float positionEvaluation(TicTacToePosition p, boolean player) {
            if(tiedPosition(p) || wonPosition(p,!player))
                return 0; // drop if tied or loss
            if(wonPosition(p,player)) {
                return 100f; // keep if winned
            }
            return p.getScore(player); // get potential
        }

        public void printPosition(TicTacToePosition p) {
              System.out.println("-------------------------------------------------");
          for(int i=0;i<3;i++) {
              System.out.println("|\t\t|\t\t|\t\t|");
              System.out.print("|\t"+p.board[0+i*3]);
              System.out.print("\t|\t"+p.board[1+i*3]);
              System.out.println("\t|\t"+p.board[2+i*3]+"\t|");
              System.out.println("|\t\t|\t\t|\t\t|");
              System.out.println("-------------------------------------------------");
          }
        }

        public boolean reachedMaxDepth(TicTacToePosition p, int depth) {
            return p.getTurn()==9; // if can't play more
        }
   
        /*static public void main(String [] args) {
        TicTacToePosition p = new TicTacToePosition();
        TicTacToe ttt = new TicTacToe();
        ttt.playGame(p);
    }*/
}

