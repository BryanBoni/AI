/*
    This class is used to choose which program you want to launch.
 */
package Main;

import Maze.BFSGraphicalMaze;
import TicTacToe.TicTacToe;
import TicTacToe.TicTacToePosition;
import java.util.Scanner;

public class launcher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Choose what do you want to do:\n"
                + "     (1) launch the maze program.\n"
                + "     (2) launch the TicTacToe program.\n"
                + "     (3) exit.");
        System.out.print("> ");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Launching the maze");
                new BFSGraphicalMaze();
                break;
            case 2:
                System.out.println("Launching the TicTacToe");
                TicTacToePosition p = new TicTacToePosition();
                TicTacToe ttt = new TicTacToe();
                ttt.playGame(p);
                break;
            case 3:
                System.out.println("Program exit...");
                System.exit(0);
                break;
        }

    }
}
