/*
 Implement  breadth first search: 
All posible move are computed from a specified search position one possible
move is made at a time.
We use a queue data structure for storing possible moves,
placing them in the queue as they are calculated, and dequeuing test move from
the front of the queue

 */
package Maze;

public class BFS extends AbstractSearch {
//To implement
    protected boolean[][] alreadyVisited; // keeps us from searching the same location twice
    protected short[][] predecessor;
    protected class PositionQueue {
        // Class to manage the queue       

    }

    public BFS(int width, int height) {
        super(width, height);
        performBFS();
    }

    private void performBFS() {
        /*
            NO RECURSIVITY !
            Use a loop  to add new position to the end of the queue and to
            remove and test new positions from the front of the queue.
        */
        
    }

}
