/*
 * Allyn Vo
 * CS 302
 * Date:
 * Assignment: Lab 4, Networks
 */
package networkexample;

/**
 *
 * @author allynvo
 */
import java.util.*;

import java.io.*;

public class DijkstraAlgorithm {
    
////////////////////////////////////////////////////////////////////////////////
// main method
////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        new DijkstraAlgorithm().run();
    } // main

    public void run() {

        UndirectedNetwork<String> network = new UndirectedNetwork<String>();

        UndirectedNetwork<String> network2 = new UndirectedNetwork<String>();
        
////////////////////////////////////////////////////////////////////////////////
// Creates network with given netwrok for lab
////////////////////////////////////////////////////////////////////////////////
//------------------------------------------------------------------------------
        // fields
        String start,
                finish,
                vertex1,
                vertex2;
        double weight;

        // initialize start and ending vertex's
        start = "0";
        finish = "4";
        
    /* Dash "-" just means connected vvvv
    "network" is for use by short path
    "network2" is for use by long path
    */
        // vertex 0-1
        vertex1 = "0";
        vertex2 = "1";
        weight = 4;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

        // vertex 0-7
        vertex1 = "0";
        vertex2 = "7";
        weight = 8;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

        // vertex 1-7
        vertex1 = "1";
        vertex2 = "7";
        weight = 11;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

        // vertex 1-2
        vertex1 = "1";
        vertex2 = "2";
        weight = 8;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

        // vertex 2-3
        vertex1 = "2";
        vertex2 = "3";
        weight = 7;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

        // vertex 2-5
        vertex1 = "2";
        vertex2 = "5";
        weight = 4;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

        // vertex 2-8
        vertex1 = "2";
        vertex2 = "8";
        weight = 2;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

        // vertex 3-4
        vertex1 = "3";
        vertex2 = "4";
        weight = 9;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

        // vertex 3-5
        vertex1 = "3";
        vertex2 = "5";
        weight = 14;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

        // vertex 4-5
        vertex1 = "4";
        vertex2 = "5";
        weight = 10;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

        // vertex 5-6
        vertex1 = "5";
        vertex2 = "6";
        weight = 2;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

        // vertex 6-7
        vertex1 = "6";
        vertex2 = "7";
        weight = 1;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

        // vertex 6-8
        vertex1 = "6";
        vertex2 = "8";
        weight = 6;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

        // vertex 7-8
        vertex1 = "7";
        vertex2 = "8";
        weight = 7;
        network.addEdge(vertex1, vertex2, weight);
        network2.addEdge(vertex1, vertex2, weight);

//------------------------------------------------------------------------------

////////////////////////////////////////////////////////////////////////////////
// Get user input to choose to find longest or shortest
////////////////////////////////////////////////////////////////////////////////
        // new scanner for users input/choice
        int choice;
        Scanner input = new Scanner(System.in);
        
        // infinit loop to keep program going unless choice is "0" to exit
        while (true) {
            // print default message on screen
            System.out.println("----------------------------------------------");
            System.out.println("\nEnter 1 for shortest path, 2 for longest path "
                + "\nby using Dijstras algorithm.");
            
            // get users choice now
            choice = input.nextInt();
            
            //switch for user choice on what to do
            switch (choice) {
                // choice "1" for shortest path
                case 1:
                    LinkedList<Object> shortPathList = network.getShortestPath(start, finish);
                    System.out.println("The shortest path found from " + start + " to "
                            + finish + " and its total weight are " + shortPathList);
                    break;
                // choice "2" for longest path
                case 2:
                    LinkedList<Object> longPathList = network.getLongestPath(start, finish);
                    System.out.println("The longest path found from " + start + " to "
                            + finish + " and its total weight are " + longPathList);
                    break;
                // choice "0" to exit
                case 0:
                    System.exit(0);
                // default to try again
                default:
                    System.out.println("Incorrect number, try again.");
            }
        }

    } // method run
} // class NetworkExample

