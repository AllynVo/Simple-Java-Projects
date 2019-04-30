/*
 * Allyn Vo
 * CS 302
 * Date:
 * Assignment:
 */
package pj3;

import java.util.*;

//--------------------------------------------------------------------------
//
// Define simulation queues in a service area. Queues hold references to Customer
// and Teller objects
//
// Customer (FIFO) queue is used to hold waiting customers. If the queue is too long
// (i.e. >  customerQLimit), customer goes away without entering customer queue
//
// There are several tellers in a service area. Use PriorityQueue to
// hold BUSY tellers and FIFO queue to hold FREE tellers,
// i.e. a teller that is FREE for the longest time should start be used first.
//
// To handle teller in PriorityQueue, we need to define comparator
// for comparing 2 teller objects. Here is a constructor from Java API:
//
// 	PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
//
// For priority queue, the default compare function is "natural ordering"
// i.e. for numbers, minimum value is returned first
//
// User can define own comparator class for PriorityQueue.
// For teller objects, we like to have smallest end busy interval time first.
//
// The following class define compare() for two tellers :

class CompareTeller implements Comparator<Teller>
{
    // override compare() method
    @Override
    public int compare(Teller o1, Teller o2)
    {
        return o1.getEndBusyIntervalTime() - o2.getEndBusyIntervalTime();
    }
}

class ServiceArea
{
    // Private data fields:
    
    // define one priority queue
    private PriorityQueue<Teller> busyTellerQ;
    
    // define two FIFO queues
    //private Queue<Customer> customerQ;
    private PriorityQueue<Customer> pq;
    private Queue<Teller> freeTellerQ;
    
    // define customer queue limit
    private int customerQLimit = 10;
    
    // Constructor 
    public ServiceArea() 
    {
        this(1,10,1);
    }
    
    // Constructor 
    public ServiceArea(int numTellers, int customerQlimit, int startTellerID)
    {
        // use ArrayDeque to construct FIFO queue objects
        //customerQ = new ArrayDeque<Customer>(customerQlimit);
        pq = new PriorityQueue<Customer>(customerQlimit);
        freeTellerQ = new ArrayDeque<Teller>(numTellers);
        
        // construct PriorityQueue object
        // overide compare() in Comparator to compare Teller objects
        busyTellerQ = new PriorityQueue<Teller>( numTellers, new CompareTeller()); 
        
        // initialize customerQlimit
        customerQLimit = customerQlimit;
        
        // Construct Teller objects and insert into FreeTellerQ
        for (int i = 0; i < numTellers; i++) {
            insertFreeTellerQ( new Teller(startTellerID++) );
        }
    }
    
    public Teller removeFreeTellerQ()
    {
        // remove and return a free teller
        return freeTellerQ.poll();
    }
    
    public Teller removeBusyTellerQ() 
    {
        // remove and return a busy teller
        return busyTellerQ.poll();
    }
    
    public Customer removeCustomerQ()
    {
        // remove and return a customer 
        //return customerQ.poll();
        return pq.remove();
    }
    
    public void insertFreeTellerQ(Teller teller)
    {
        // insert a free teller
        freeTellerQ.add(teller);
    }
    
    public void insertBusyTellerQ(Teller teller)
    {
        // insert a busy teller
        busyTellerQ.add(teller);
    }
    
    public void insertCustomerQ(Customer customer)
    {
        // insert a customer
        //customerQ.add(customer);
        pq.add(customer);
    }
    
    public boolean emptyFreeTellerQ()
    {
        // is freeTellerQ empty?
        return freeTellerQ.isEmpty();
    }
    
    public boolean emptyBusyTellerQ()
    {
        // is busyTellerQ empty?
        return busyTellerQ.isEmpty();
    }
    
    public boolean emptyCustomerQ()
    {
        // is customerQ empty?
        //return customerQ.isEmpty();
        return pq.isEmpty();
    }
    
    public int numFreeTellers()
    {
        // get number of free tellers
        return freeTellerQ.size();
    }
    
    public int numBusyTellers()
    {
        // get number of busy tellers
        return busyTellerQ.size();
    }
    
    public int numWaitingCustomers()
    {
        // get number of customers 
        //return customerQ.size();
        return pq.size();
    }
    
    public Teller getFrontBusyTellerQ() 
    {
        // get front of busy tellers
        // "retrieve" but not "remove"
        return busyTellerQ.peek();
    }
    
    public boolean isCustomerQTooLong()
    {
        // is customerQ too long?
        //return customerQ.size() == customerQLimit;
        return pq.size() == customerQLimit;
    }
    
    public void printStatistics()
    {
        System.out.println("\t\t# waiting customers : "+numWaitingCustomers());
        System.out.println("\t\t# busy tellers      : "+numBusyTellers());
        System.out.println("\t\t# free tellers      : "+numFreeTellers());
    }

}