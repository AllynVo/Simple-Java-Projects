/*
 * Allyn Vo
 * CS 302
 * Date:
 * Assignment:
 */
package pj3;
import java.util.*;
class Customer implements Comparable<Customer>
{
    protected int priority;
    Random r = new Random();
    
    private int customerID;
    private int transactionTime;
    private int arrivalTime;
    
    Customer()
    {
        this(1,1,1);
    }
    
    Customer(int customerid, int transactionduration, int arrivaltime)
    {
        priority = r.nextInt(10 - 1 + 1) + 1;
        
        customerID = customerid;
        transactionTime = transactionduration;
        arrivalTime = arrivaltime;
    }
    
    @Override
    public int compareTo(Customer otherCustomer)
    {
        if(priority < otherCustomer.priority)
            return -1;
        if(priority > otherCustomer.priority)
            return 1;
                return 0;
    }
    
    int getTransactionTime()
    {
        return transactionTime;
    }
    
    int getArrivalTime()
    {
        return arrivalTime;
    }
    
    int getCustomerID()
    {
        return customerID;
    }
    
    public String toString()
    {
        return ""+customerID+":"+transactionTime+":"+arrivalTime;
    }

}