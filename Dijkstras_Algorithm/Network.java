/*
 * Allyn Vo
 * CS 302
 * Date:
 * Assignment: Lab 4, Networks
 * Source code provided by teacher in canvas****
 */


package networkexample;

import java.util.*;

public class Network<Vertex> implements Iterable<Vertex>, java.io.Serializable
{    
    protected TreeMap<Vertex, TreeMap<Vertex, Double>> adjacencyMap;        
   
    // Constructor: default
    public Network()
    {        
        adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();        
    }

    // Constrcutor: Copies / takes in another Network object
    public Network (Network<Vertex> network)
    {
        adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>(network.adjacencyMap);
    }
    
////////////////////////////////////////////////////////////////////////////////
    /**
     *  Determines the weight of an edge in this Network object.
     *  v1 - the beginning Vertex object of the edge whose weight is sought.
     *  v2 - the ending Vertex object of the edge whose weight is sought.
     *
     *  returns the weight of edge <v1, v2>, if <v1, v2> forms an edge; return -1.0 if
     *  <v1, v2> does not form an edge in this Network object.
     */
    public double getEdgeWeight (Vertex v1, Vertex v2)
    {
        if (v1 == null || v2 == null)
            throw new NullPointerException();
        if (! (adjacencyMap.containsKey (v1) && adjacencyMap.containsKey (v2)))
            return -1.0;

        TreeMap<Vertex, Double> neighborMap = adjacencyMap.get (v1);
        Double weight = neighborMap.get (v2);
        if (weight != null)
           return weight;
        return -1.0;  // there is no edge <v1, v2>
    } // method getEdgeWeight
    
////////////////////////////////////////////////////////////////////////////////
    /**
     *  Determines if this Network object contains an edge specified by two vertices.
     *  v1 - the beginning Vertex object of the edge sought.
     *  v2 - the ending Vertex object of the edge sought.
     *
     *  return true if this Network object contains the edge <v1, v2>.
     */
    public boolean containsEdge (Vertex v1, Vertex v2)
    {
        return getEdgeWeight (v1, v2) > 0.0;
    } // method containsEdge
    
////////////////////////////////////////////////////////////////////////////////
    /**
     *  Ensures that a specified Vertex object is an element of this Network object.
     *  vertex - the Vertex object whose presence is ensured.
     *
     *  return true if vertex was added to this Network object by this call; 
     *  returns false if vertex was already an element of this Network object 
     *  when this call was made.
     */
    public boolean addVertex (Vertex vertex)
    {     
        if (adjacencyMap.containsKey (vertex))
            return false;
        adjacencyMap.put (vertex, new TreeMap<Vertex, Double>());
        return true;
    } // method addVertex
    
////////////////////////////////////////////////////////////////////////////////
    /**
     *  Ensures that an edge is in this Network object.
     *  v1 - the beginning Vertex object of the edge whose presence
     *  is ensured.
     *  v2 - the ending Vertex object of the edge whose presence is
     *  ensured.
     *  weight - the weight of the edge whose presence is ensured.
     *
     *  return true if the given edge (and weight) were added to this Network
     *  object by this call; return false, if the given edge (and weight)
     *  were already in this Network object when this call was made.
     */
    public boolean addEdge (Vertex v1, Vertex v2, double weight)
    {
        if (containsEdge (v1, v2))
            return false;
        addVertex (v1);
        addVertex (v2);      
        TreeMap<Vertex, Double> neighborMap = adjacencyMap.get (v1);       
        neighborMap.put (v2, weight);
        adjacencyMap.put (v1, neighborMap);      
        return true;
    } // method addEdge
    
////////////////////////////////////////////////////////////////////////////////
    /**
     *  Returns an Iterator object over the vertices in this Network object.
     */
    public Iterator<Vertex> iterator()
    {
        return new NetworkIterator();
    } // method iterator

////////////////////////////////////////////////////////////////////////////////
    /**
     *  Returns a breadth-first Iterator object over all vertices reachable from
     *  a specified Vertex object.
     */
    public Iterator<Vertex> breadthFirstIterator (Vertex v)
    {
        if (!adjacencyMap.containsKey (v))
            throw new IllegalArgumentException();
        return new BreadthFirstIterator(v);
    } // method breadthFirstIterator
    
////////////////////////////////////////////////////////////////////////////////
    /**
     *  Finds a shortest path between two specified vertices in this Network
     *  object.
     *  v1 - the beginning Vertex object.
     *  v2 - the ending Vertex object.
     *
     *  return a LinkedList object containing the vertices in a shortest path
     *  from Vertex v1 to Vertex v2.  The last element is the
     *  weight of the path, or -1.0 if there is no path.
     */
    public LinkedList<Object> getShortestPath (Vertex v1, Vertex v2)
    {
        // "infinity" 
        final double MAX_PATH_WEIGHT = Double.MAX_VALUE;

        TreeMap<Vertex,Double> weightSum = new TreeMap<Vertex,Double>();

        TreeMap<Vertex,Vertex> predecessor = new TreeMap<Vertex,Vertex>();

        PriorityQueue<VertexWeightPair> pq = new PriorityQueue<VertexWeightPair>();
    
        // Vertex types
        Vertex vertex,
               to = null,
               from;

        VertexWeightPair vertexWeightPair;

        double weight;
 
        if (v1 == null || v2 == null)
            throw new NullPointerException();
        if (! (adjacencyMap.containsKey (v1) && adjacencyMap.containsKey (v2)))
            return new LinkedList<Object>();
        Iterator<Vertex> netItr = breadthFirstIterator(v1);
        while (netItr.hasNext()) 
        {
            vertex = netItr.next();
            //System.out.println(vertex);
            weightSum.put (vertex, MAX_PATH_WEIGHT);
            predecessor.put (vertex, null);
        } // initializing weightSum and predecessor
        weightSum.put (v1, 0.0);
        predecessor.put (v1, v1);
        pq.add (new VertexWeightPair (v1, 0.0));

        boolean pathFound = false;
        while (!pathFound && !pq.isEmpty()) 
        {
            vertexWeightPair = pq.remove();
            from = vertexWeightPair.vertex;
            
            // prints each step
            System.out.println(vertexWeightPair);
            
            if (from.equals (v2))
                pathFound = true;
            else if (vertexWeightPair.weight <= weightSum.get(from)) 
            {                  
                for (Map.Entry<Vertex, Double> entry : adjacencyMap.get (from).entrySet())
                {
                     to = entry.getKey();
                     weight = entry.getValue();
                     if (weightSum.get (from) + weight < weightSum.get (to)) 
                     {
                         weightSum.put (to, weightSum.get (from) + weight);
                         predecessor.put (to, from);
                         pq.add (new VertexWeightPair (to,weightSum.get (to)));
                     } // if
                 } // while from's neighbors have not been processed
            } // else path not yet found
        } // while not done and priority queue not empty

        LinkedList<Object> path = new LinkedList<Object>();
        if (pathFound) 
        {
            Vertex current = v2;
            while (!(current.equals (v1))) 
            {
                path.addFirst (current);
                current = predecessor.get (current);
            } // while not back to v1
            path.addFirst (v1);
            path.addLast (weightSum.get (v2));
        } // if path found
        else
            path.addLast (-1.0);
        return path;
    } // method findShortestPath
    
////////////////////////////////////////////////////////////////////////////////
// NetworkIterator Class
////////////////////////////////////////////////////////////////////////////////
    protected class NetworkIterator implements Iterator<Vertex>
    {
        protected Iterator<Vertex> itr;
    
        protected Vertex current;

        /**
         * Initializes this NetworkIterator object to iterate over the
         * vertices in this Network object.
         */
        public NetworkIterator()
        {
            itr = adjacencyMap.keySet().iterator();
        } // default constructor


        /**
         * Returns true if this NetworkIterator object has not yet finished
         * iterating over the vertices in this Network object.  
         * Otherwise, returns false.
         */
        public boolean hasNext()
        {
            return itr.hasNext();
        } // method hasNext


        /**
         * Returns the next vertex in this NetworkIterator object.
         */    
        public Vertex next()
        {
            current = itr.next();
            return current;
        } // method next

    } // class NetworkIterator
    
////////////////////////////////////////////////////////////////////////////////
// BreadthFirstIterator Class
////////////////////////////////////////////////////////////////////////////////
    protected class BreadthFirstIterator implements Iterator<Vertex>
    {
        protected Queue<Vertex> queue;

        protected TreeMap<Vertex, Boolean> reached;

        protected Vertex current;

        /**
         * Initializes this BreadthFirstIterator at start.
         */
        public BreadthFirstIterator (Vertex start)
        {
            queue = new LinkedList<Vertex>();

            reached = new TreeMap<Vertex, Boolean>();

            for (Vertex v: adjacencyMap.keySet())                            
                reached.put (v, false);

            queue.add (start);
            reached.put (start, true);
        } // one-parameter constructor


        /**
         * Returns true if this BreadthFirstIterator has not reached all of its 
         * reachable vertices.  
         * Otherwise, returns false.
         */
        public boolean hasNext()
        {
            return !(queue.isEmpty());
        } // method hasNext

        /**
         * Returns the next reachable vertex in this BreadthFirstIterator object.
         */    
        public Vertex next()
        {            
            Vertex to;

            current = queue.remove();

            TreeMap<Vertex, Double> neighborMap = adjacencyMap.get (current);            

            for (Map.Entry<Vertex, Double> entry: neighborMap.entrySet())
            {
                to = entry.getKey();
                if (!reached.get (to))
                {
                   reached.put (to, true);
                   queue.add (to);
                } // if
            } // for
            return current;
        } // method next

    } // class BreadthFirstIterator
    
////////////////////////////////////////////////////////////////////////////////
// VertexWeightPair Class
////////////////////////////////////////////////////////////////////////////////
    protected class VertexWeightPair implements Comparable<VertexWeightPair>, 
                                                java.io.Serializable
    {
        Vertex vertex; 

        double weight;


        /**
         * Initializes this VertexWeightPair from vertex and weight.
         */
        public VertexWeightPair (Vertex vertex, double weight)
        {
            this.vertex = vertex;
            this.weight = weight;
        } // default constructor

        /**
         *  Returns an int <, = or > 0 , depending on whether this VertexWeightPair's 
         *  weight is <, = or > other's weight.
         */
        public int compareTo (VertexWeightPair other)
        {
            return (int)(weight - other.weight);
        } // method compareTo

        /**
         *  Returns a String representation of this VertexWeightPair.
         */
        public String toString()
        {
            return vertex.toString() + "  " + String.valueOf (weight);
        } // method toString

    } // class VertexWeightPair

////////////////////////////////////////////////////////////////////////////////
// Get longest path method using Dijkstra
////////////////////////////////////////////////////////////////////////////////
    public LinkedList<Object> getLongestPath (Vertex v1, Vertex v2)
    {
        // "infinity" 
        final double MAX_PATH_WEIGHT = Double.MAX_VALUE;

        // holds weight sum in tree map
        TreeMap<Vertex,Double> weightSum = new TreeMap<Vertex,Double>();

        
        // holds predecessors in tree map
        TreeMap<Vertex,Vertex> predecessor = new TreeMap<Vertex,Vertex>();

        // PQ
        PriorityQueue<VertexWeightPair2> pq = new PriorityQueue<VertexWeightPair2>();
    
        // Vertex types
        Vertex vertex,
               to = null,
               from;

        VertexWeightPair2 vertexWeightPair;

        double weight;
 
        if (v1 == null || v2 == null)
            throw new NullPointerException();
        if (! (adjacencyMap.containsKey (v1) && adjacencyMap.containsKey (v2)))
            return new LinkedList<Object>();
        Iterator<Vertex> netItr = breadthFirstIterator(v1);
        while (netItr.hasNext()) 
        {
            vertex = netItr.next();
            //System.out.println(vertex);
            weightSum.put (vertex, MAX_PATH_WEIGHT);
            predecessor.put (vertex, null);
        } // initializing weightSum and predecessor
        weightSum.put (v1, 0.0);
        predecessor.put (v1, v1);
        pq.add (new VertexWeightPair2 (v1, 0.0));

        boolean pathFound = false;
        while (!pathFound && !pq.isEmpty()) 
        {
            vertexWeightPair = pq.remove();
            from = vertexWeightPair.vertex;
            
            // prints each step
            System.out.println(vertexWeightPair);
            
            //System.out.println(from);
            if (from.equals (v2))
                pathFound = true;
            else if (vertexWeightPair.weight <= weightSum.get(from)) 
            {                  
                for (Map.Entry<Vertex, Double> entry : adjacencyMap.get (from).entrySet())
                {
                     to = entry.getKey();
                     weight = entry.getValue();
                     if (weightSum.get (to) + weight > weightSum.get (from)) 
                     {
                         weightSum.put (to, weightSum.get (from) + weight);
                         predecessor.put (to, from);
                         pq.add (new VertexWeightPair2 (to,weightSum.get (to)));
                     } // if
                 } // while from's neighbors have not been processed
            } // else path not yet found
        } // while not done and priority queue not empty

        LinkedList<Object> path = new LinkedList<Object>();
        if (pathFound) 
        {
            Vertex current = v2;
            while (!(current.equals (v1))) 
            {
                path.addFirst (current);
                current = predecessor.get (current);
            } // while not back to v1
            path.addFirst (v1);
            path.addLast (weightSum.get (v2));
        } // if path found
        else
            path.addLast (-1.0);
        return path;
    } // method findShortestPath
    
    protected class VertexWeightPair2 implements Comparable<VertexWeightPair2>, 
                                                java.io.Serializable
    {
        Vertex vertex; 

        double weight;


        /**
         * Initializes this VertexWeightPair from vertex and weight.
         */
        public VertexWeightPair2 (Vertex vertex, double weight)
        {
            this.vertex = vertex;
            this.weight = weight;
        } // default constructor

        /**
         *  Returns an int <, = or > 0 , depending on whether this VertexWeightPair's 
         *  weight is <, = or > other's weight.
         */
        public int compareTo (VertexWeightPair2 other)
        {
            return (int)(other.weight - weight);
        } // method compareTo

        /**
         *  Returns a String representation of this VertexWeightPair.
         */
        public String toString()
        {
            return vertex.toString() + "  " + String.valueOf (weight);
        } // method toString

    } // class VertexWeightPair

} // class Network

