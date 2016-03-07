/*package TicTacToe;

abstract public class Position {  

    public int getTurn() {
            int turn=1;
            for(int i:board)
                if(i!=0)
                    turn++;
            return turn;
        }
        public float getScore(boolean player) {
            int play=player? 1 : -1;
            float score=0;
            //System.out.println("Get score for player "+play+" on turn "+getTurn());

            for(int j=0;j<3;j++) {
                for(int k=0;k<3;k++) {
                    if(board[(k)+j*3]==play && board[(k+1)%3+j*3]==play) {
                        score+=5; // horizontal potential
                        //System.out.print("(H:"+((k)+j*3)+","+((k+1)%3+j*3)+")");
                    }
                }
                for(int k=0;k<3;k++) {
                    if(board[j+(k)*3]==play && board[j+(k+1)%3*3]==play) {
                        score+=5; // vertical potential
                        //System.out.print("(V:"+(j+(k)*3)+","+(j+(k+1)%3*3)+")");
                    }
                }
            }

            // diag TL BR potential
            if(board[0]==play && board[4]==play) {
                score+=5;
                //System.out.print("(V:"+0+","+4+")");
            }
            if(board[0]==play && board[8]==play) {
                score+=5;
                //System.out.print("(V:"+0+","+4+")");
            }
            if(board[4]==play && board[8]==play) {
                score+=5;
                //System.out.print("(V:"+4+","+8+")");
            }

            // diag TR BL potential
            if(board[2]==play && board[4]==play) {
                score+=5;
                //System.out.print("(V:"+2+","+4+")");
            }
            if(board[2]==play && board[6]==play) {
                score+=5;
                //System.out.print("(V:"+2+","+6+")");
            }
            if(board[4]==play && board[6]==play) {
                score+=5;
                //System.out.print("(V:"+4+","+6+")");
            }
            //System.out.println("\nTotal score = "+score);
            return score;
        }
}

*/