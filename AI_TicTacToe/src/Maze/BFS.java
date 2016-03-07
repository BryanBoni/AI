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
        (1) We start the search by setting the already visited flag for the starting location to true value 

        and adding the starting location to the back of the queue.*/
        alreadyVisited[currentPos.x][currentPos.y] = true;
        
        
        /*

        (2) An outer loop runs until either the queue is empty or the goal is found where: 

        (i) We examine the Position object at the front of the queue (but do not remove it) and 

        get the adjacent locations to the current position in the maze. 

        (ii) We loop over each possible move; if the possible move is valid (i.e., not null) and we 

        have not already visited the possible move location then we add the possible move to the 

        back of the queue and set the predecessor array for the new location to the last visited cell 

        (the value from the front of the queue). If we find the goal, break out of the loop. 

        (iii) We have processed the location at the front of the queue, so we remove it. 

        (3) Out of the main loop, we need to use the predecessor array to get the shortest path. The 

        searchPath array is filled in reverse order, starting with the goal location.
        */
        
        
        
    }

}
