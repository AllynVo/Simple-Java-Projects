/*
 * Allyn Vo
 * CS 302
 */

package callsim;

import java.util.*;
import java.util.Random;
import java.util.PriorityQueue;
import java.lang.Math;
import java.lang.Object;


/**
 *
 * @author allynvo
 */
//CallSim class interface: run a simulation
//void runSim() --> Run a simulation
public class CallSim {

    /**
     * Constructor
     *
     * @param operator number of operators
     * @param avgLen average length of call
     * @param callIntrvl the average time between calls
     */
    public CallSim(int operators, double avgLen, int callIntrvl) {
        eventSet = new PriorityQueue<Event>();
        availableOperators = operators;
        avgCallLen = avgLen;
        freqOfCalls = callIntrvl;
        r = new Random();
        nextCall(freqOfCalls); //Schedule first call
    }

//Run the simulation
    /**
     * Run the simulation until stoppingTime occurs. Print output
     *
     * @param stoppingTime
     */
    public void runSim(long stoppingTime) {
        Event e = null;
        int howLong;

        while (!eventSet.isEmpty()) {
            e = eventSet.remove();

            if (e.time > stoppingTime) {
                break;
            }

            if (e.what == Event.HANG_UP) { //HANG_UP
                availableOperators++;
                System.out.println("User " + e.who + " hangs up at time " + e.time);
            } else { //DIAL_IN
                System.out.print("User " + e.who + " dials in at time " + e.time + " ");

                if (availableOperators > 0) {
                    availableOperators--;
                    howLong = r.nextInt((int) avgCallLen);
                    System.out.println("and connects for " + howLong + " minutes");
                    e.time += howLong;
                    e.what = Event.HANG_UP;
                    eventSet.add(e);
                } else {
                    System.out.println("but gets busy signal");
                }
                nextCall(freqOfCalls);
            }
        }
    }

//Add a call to eventSet at the current time,
//and schedule one for delta in the future
    private int userNum = 0;
    private int nextCallTime = 0;

    /**
     * Place a new DIAL_IN event into the event queue Then advance the time when
     * the next DIAL_IN event will occur IN practice, we would use a random
     * number to set the time
     *
     * @param delta
     */
    private void nextCall(int delta) {
        Event ev = new Event(userNum++, nextCallTime, Event.DIAL_IN);
        eventSet.add(ev);
        nextCallTime += delta;
    }

    private Random r; // A random source
    private PriorityQueue<Event> eventSet; // Pending events

//Basic parameters of the simulation
    private int availableOperators; // Number of available operators
    private double avgCallLen; // Length of a call
    private int freqOfCalls; // Interval between calls

    /**
     * The event class Implements the Comparable interface to arrange events by
     * time of occurrence (nested in CallSim)
     */
    private static class Event implements Comparable<Event> {

        static final int DIAL_IN = 1;
        static final int HANG_UP = 2;

        public Event() {
            this(0, 0, DIAL_IN);
        }

        public Event(int name, int tm, int type) {
            who = name;
            time = tm;
            what = type;
        }

        public int compareTo(Event rhs) {
            return time - rhs.time;
        }
        int who;        // the number of the user
        int time;       // when the event will occur
        int what;       // DIAL_IN or HANG_UP

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Constructor CallSim(int operators, double avgLen, int callIntrvl)
        CallSim cs = new CallSim(2, 5.0, 1);
        cs.runSim(10);
    }

}
