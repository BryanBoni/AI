package Maze;

/*
 The class BFSGraphicalMaze supports the graphical display
 of breadth first search.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class BFSGraphicalMaze extends javax.swing.JFrame {

    JPanel jPanel1 = new JPanel();
    BFS currSearch = null;
    boolean done = true;

    public BFSGraphicalMaze() {
        doMaze();
    }

    public void doMaze() {
        /*
        This function contain the initialisation of the maze 
        (graphical part and after the back-end part).
         */
        try {
            initGUI();
        } catch (Exception e) {
            System.out.println("Interface error: " + e);
        }
        currSearch = new BFS(10, 10);
        repaint();
        endChoice();
    }

    public void endChoice() {
        /*
         This function is used to make a choice about retrying or ending
         the maze program.
         If yes re do the maze and call recusively this function,
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
                currSearch = new BFS(10, 10);
                repaint();
                endChoice();
            } else if (choice.equals("N") || choice.equals("n")) {
                check = true;
                System.out.println("Program exit...");
                System.exit(0);
            } else {
                System.out.println("Please type a valide answer !");
            }
        } while (check == false); //loop while the answer given is false or not taken.
    }

    public void paint(Graphics g_unused) {
        if (currSearch == null) {
            return;
        }
        Maze maze = currSearch.getMaze();
        int width = maze.getWidth();
        int height = maze.getHeight();
        Graphics g = jPanel1.getGraphics();
        BufferedImage image = new BufferedImage(320, 320, BufferedImage.TYPE_INT_RGB);
        Graphics g2 = image.getGraphics();
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 320, 320);
        g2.setColor(Color.black);
        maze.setValue(0, 0, Maze.START_POS_VALUE);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                short val = maze.getValue(x, y);

                if (val == Maze.OBSTACLE) {
                    g2.setColor(Color.lightGray);
                    g2.fillRect(6 + x * 29, 3 + y * 29, 29, 29);
                    g2.setColor(Color.black);
                    g2.drawRect(6 + x * 29, 3 + y * 29, 29, 29);
                } else if (val == Maze.START_POS_VALUE) {
                    g2.setColor(Color.blue);
                    g2.drawString("S", 16 + x * 29, 19 + y * 29);
                    g2.setColor(Color.black);
                    g2.drawRect(6 + x * 29, 3 + y * 29, 29, 29);
                } else if (val == Maze.GOAL_POS_VALUE) {
                    g2.setColor(Color.red);
                    g2.drawString("G", 16 + x * 29, 19 + y * 29);
                    g2.setColor(Color.black);
                    g2.drawRect(6 + x * 29, 3 + y * 29, 29, 29);
                } else {
                    g2.setColor(Color.black);
                    g2.drawRect(6 + x * 29, 3 + y * 29, 29, 29);
                }
            }
        }
        // redraw the path
        g2.setColor(Color.black);
        Position[] path = currSearch.getPath();
        for (int i = 1; i < (path.length - 1); i++) {
            int x = path[i].x;
            int y = path[i].y;
            short val = maze.getValue(x, y);
            g2.drawString("" + (path.length - i), 16 + x * 29, 19 + y * 29);
        }
        g.drawImage(image, 30, 40, 320, 320, null);

    }

    private void initGUI() throws Exception {

        this.setContentPane(jPanel1);
        this.setCursor(null);
        this.setDefaultCloseOperation(3);
        this.setTitle("MazeBreadthFirstSearch");
        this.getContentPane().setLayout(null);
        jPanel1.setBackground(Color.white);
        jPanel1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        jPanel1.setDoubleBuffered(false);
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(null);
        this.setSize(370, 420);
        this.setVisible(true);
    }
}
