/*
 Allows characterizing a position in the grid with coordinates x and y

 */
package Maze;

public class Position {

    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
}
