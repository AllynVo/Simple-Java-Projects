//Allyn Vo
//April 25, 2017
//CS 301
//Driver class
package package4;

import java.util.*;

/**
 *
 * @author Allyn Vo
 */
public class Project4 {

    public static void main(String[] args) {
        new Project4().run();
    }

    public void run() {
        //new demo class
        DemoClass myScores = new DemoClass();

        //set and add scores
        myScores.setNextScore(80);
        myScores.setNextScore(85);
        myScores.setScoreAt(0, 95);

        //normal iterator method to print out data
        System.out.println("Normal Iterator data: ");
        myScores.printAllScores();

        //enhance for loop method to print out data
        System.out.println("Enhanced for loop data: ");
        myScores.printScoresUsingEnhanceedForLoop();

        //get score at certain index
        System.out.println("Score at index 0: " + myScores.getScoreAt(0));

        //Get size of list or number of scores
        System.out.println("Number of scores: " + myScores.getSizeOfList());

    }

}
