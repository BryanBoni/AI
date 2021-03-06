package TicTacToe;

import java.util.*;

public abstract class GameSearch {

    public static boolean PROGRAM = false;
    public static boolean HUMAN = true;

    // Abstract methods:  
    public abstract boolean tiedPosition(Position p);

    public abstract boolean wonPosition(Position p, boolean player);

    public abstract float positionEvaluation(Position p, boolean player);

    public abstract void printPosition(Position p);

    public abstract Position[] possibleMoves(Position p, boolean player);

    public abstract Position makeMove(Position p, boolean player);

    public abstract boolean reachedMaxDepth(Position p, int depth);

    //Search methods:
    protected Vector alphaBeta(int depth, Position p, boolean player) {
        Vector v = alphaBetaHelper(depth, p, player, 1000000.0f, -1000000.0f);
        return v;
    }

    protected Vector alphaBetaHelper(int depth, Position p,
            boolean player, float alpha, float beta) {
        if (reachedMaxDepth(p, depth)) {
            Vector v = new Vector(2);
            float value = positionEvaluation(p, player);
            v.addElement(new Float(value));
            v.addElement(null);
            return v;
        }
        Vector best = new Vector();
        Position[] moves = possibleMoves(p, player);
        for (int i = 0; i < moves.length; i++) {
            Vector v2 = alphaBetaHelper(depth + 1, moves[i], !player, -beta, -alpha);
            float value = -((Float) v2.elementAt(0)).floatValue();
            if (value > beta) {
                beta = value;
                best = new Vector();
                best.addElement(moves[i]);
                Enumeration enum2 = v2.elements();
                enum2.nextElement(); // skip previous value
                while (enum2.hasMoreElements()) {
                    Object o = enum2.nextElement();
                    if (o != null) {
                        best.addElement(o);
                    }
                }
            }
            // alpha-beta cutoff test is used to abort search
            if (beta >= alpha) {
                break;
            }
        }
        Vector v3 = new Vector();
        v3.addElement(new Float(beta));
        Enumeration enum2 = best.elements();
        while (enum2.hasMoreElements()) {
            v3.addElement(enum2.nextElement());
        }
        return v3;
    }
    public void endChoice(){
        /*
         This function is used to make a choice about retrying or ending
         the TicTacToe program.
         If yes re do the game and enjoy,
         Else ending the program.
         */
        boolean check = false;
        do {
            Scanner sc = new Scanner(System.in);
            String choice;
            System.out.println("Do you want to retry ? (Y/N)");
            System.out.print("> ");
            choice = sc.nextLine();
            if (choice.equals("Y") || choice.equals("y")) {
                check = true;
                TicTacToePosition p = new TicTacToePosition();
                TicTacToe ttt = new TicTacToe();
                ttt.playGame(p);
            } else if (choice.equals("N") || choice.equals("n")) {
                check = true;
                System.out.println("Program exit...");
                System.exit(0);
            } else {
                System.out.println("Please type a valide answer !");
            }
        } while (check == false); //loop while the answer given is false or not taken.
    }

    public void playGame(Position startingPosition) {
        printPosition(startingPosition);
        while (true) {
            System.out.println("Human move (type 0 to 8 to place your cross) :");
            System.out.print("> ");
            startingPosition = makeMove(startingPosition, HUMAN);
            printPosition(startingPosition);
            if (wonPosition(startingPosition, HUMAN)) {
                //Impossible the Human will never won if we implementing entirely the minimax algorithm, or else that mean you're a cheater !.
                System.out.println("Human won");
                endChoice();
            }
            if (tiedPosition(startingPosition)) {
                System.out.println("Tied game");
                endChoice();
            }
            Vector v = alphaBeta(0, startingPosition, PROGRAM);
            for (Enumeration enum2 = v.elements(); enum2.hasMoreElements();) {
                System.out.println(" next element: " + enum2.nextElement());
            }
            startingPosition = (Position) v.elementAt(1);
            printPosition(startingPosition);
            if (wonPosition(startingPosition, PROGRAM)) {
                System.out.println("Program won");
                endChoice();
            }
        }
    }

}
