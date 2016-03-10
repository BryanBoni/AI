/*
Implement  breadth first search: 
All posible move are computed from a specified search position one possible
move is made at a time.
We use a queue data structure for storing possible moves,
placing them in the queue as they are calculated, and dequeuing test move from
the front of the queue

 */
package Maze;

import java.util.Queue;
import java.util.LinkedList;

public class BFS extends AbstractSearch {

    protected boolean[][] alreadyVisited; // keeps us from searching the same location twice
    protected Position[][] predecessor;

    protected class PositionQueue {

        // Class to manage the queue  
        private final Queue<Position> queue = new LinkedList<>();// Doubly-linked list implementation of the List and Deque interfaces. Implements all optional list operations, and permits all elements (including null).

        public PositionQueue() {
        }

        public void addingQueue(Position add) {
            //Adds the specified element as the tail (last element) of this list.
            queue.offer(add);
        }

        public Position deQueue() {
            //Retrieves and removes the head (first element) of this list.
            return queue.poll();
        }

        public Position topQueue() {
            //Retrieves, but does not remove, the head (first element) of this list.
            return queue.peek();
        }
    }

    public BFS(int width, int height) {
        super(width, height);
        System.out.println("Performing BFS...");
        performBFS(width, height);
    }

    private void performBFS(int width, int height) {
        /*
            NO RECURSIVITY !
            Use a loop  to add new position to the end of the queue and to
            remove and test new positions from the front of the queue.

            (1) We start the search by setting the already visited 
            flag for the starting location to true value 
            and adding the starting location to the back of the queue.
         */
        
        alreadyVisited = new boolean[width][height];
        predecessor = new Position[width][height];
        PositionQueue queueMaze = new PositionQueue();

        queueMaze.addingQueue(startPos);

        Position[] possibleMoves;
        Position tempPosition;

        alreadyVisited[startPos.x][startPos.y] = true;
        System.out.println("Scanning possibilities...");
        //(2) An outer loop runs until either the queue is empty or the goal is found
        while(queueMaze.topQueue()!= null && !equals(queueMaze.topQueue(),goalPos)) {
            /*
            steps of this loop:
            
            (i) We examine the Position object at the front of the queue (but do not remove it) and 
            get the adjacent locations to the current position in the maze. 
            
            (ii) We loop over each possible move; if the possible move is valid (i.e., not null) and we 
            have not already visited the possible move location then we add the possible move to the 
            back of the queue and set the predecessor array for the new location to the last visited cell 
            (the value from the front of the queue). If we find the goal, break out of the loop. 
                       
             */
            possibleMoves = getPossibleMoves(queueMaze.topQueue());
            for (int i = 0; i < 4; i++) {
                if (possibleMoves[i] != null) {
                    for (int j = 1; j < 4; j++) {
                        if (possibleMoves[j] != null) {
                            if (Math.pow(width - 1 - possibleMoves[j].x, 2) + Math.pow(height - 1 - possibleMoves[j].y, 2) < Math.pow(width - 1 - possibleMoves[i].x, 2) + Math.pow(height - 1 - possibleMoves[i].y, 2)) {
                                tempPosition = possibleMoves[i];
                                possibleMoves[i] = possibleMoves[j];
                                possibleMoves[j] = tempPosition;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                if (possibleMoves[i] != null && alreadyVisited[possibleMoves[i].x][possibleMoves[i].y] == false) {
                    
                    alreadyVisited[possibleMoves[i].x][possibleMoves[i].y] = true;
                    queueMaze.addingQueue(possibleMoves[i]);
                    predecessor[possibleMoves[i].x][possibleMoves[i].y] = queueMaze.topQueue();
                    if (equals(possibleMoves[i], goalPos)) {
                        break;
                    }
                }
            }
            //(iii) We have processed the location at the front of the queue, so we remove it. 
            queueMaze.deQueue();
        }
        /*
            (3) Out of the main loop, we need to use the predecessor array to get the shortest path. The 
            searchPath array is filled in reverse order, starting with the goal location.
         */
        if (queueMaze.topQueue() == null) {
            System.out.println("It's not possible to finish this maze !");
            //System.exit(0);
        } else {
            
            int i = 0;
            Position precPos = goalPos;
            System.out.println("Tracing the path...");
            while (!equals(precPos, startPos)) {
                searchPath[i] = precPos;
                precPos = predecessor[precPos.x][precPos.y];
                i++;
            }
            maxDepth = i + 1;
            System.out.println("Done !\n Maze maximum depth = " + maxDepth);
        }
    }

}
