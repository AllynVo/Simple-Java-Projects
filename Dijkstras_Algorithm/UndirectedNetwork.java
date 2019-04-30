/*
 * Allyn Vo
 * CS 302
 * Date:
 * Assignment: Lab 4, Networks
 * Source code provided by teacher in canvas****
 */
package networkexample;

import java.util.*;

public class UndirectedNetwork<Vertex> extends Network<Vertex>
{

    // Constructor: default
    public UndirectedNetwork()
    {        
        super(); 
    } // default constructor

       
    // Constructor: Copies / takes in another UndirectedNetwork object
    public UndirectedNetwork (UndirectedNetwork<Vertex> network)
    {
        super (network); 
    } // copy constructor

    /**
     *  Determines if this UndirectedNetwork object is equal to a given object. 
     */
    public boolean equals (Object obj)
    {
        if (!(obj instanceof UndirectedNetwork))
            return false;
        UndirectedNetwork<Vertex> other = (UndirectedNetwork<Vertex>)obj;
        
        return adjacencyMap.equals (other.adjacencyMap);
    } // method equals
                
    /**
     *  Ensures that a given edge with a given weight is in this UndirectedNetwork 
     *  object.  
     */ 
    public boolean addEdge (Vertex v1, Vertex v2, double weight) 
    {
        return super.addEdge (v1, v2, weight) && super.addEdge (v2, v1, weight);
    } // method addEdge 

} // class UndirectedNetwork
