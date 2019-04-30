package project3;

import project3.DemoBigO;

public class OutputWIThDeliberateThrowOfAnException {
    //Project 3 code, Output WITH deliberate throw of an exception

        // demo throwing exception 
        // comment out when not using – it throws an exception and stops
    public static void main(String []args){
        DemoBigO objThrow = new DemoBigO();
        objThrow.throwAnException();
    }

//run:
//Exception in thread "main" java.lang.ArithmeticException: This is an exception test
//	at project3.DemoBigO.throwAnException(DemoBigO.java:26)
//	at project3.Project3.run(Project3.java:27)
//	at project3.Project3.main(Project3.java:14)
//Java Result: 1
//BUILD SUCCESSFUL (total time: 0 seconds)

}
