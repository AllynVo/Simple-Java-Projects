//Allyn Vo
//April 25, 2017
//CS 301
//Demo class
package package4;

import java.util.*;

/**
 *
 * @author Allyn Vo
 */
public class DemoClass {

    //Field
    //new arrray list for test scores
    List<Integer> testScoreList = new ArrayList<Integer>();

    //method that uses an iterator to print out the data
    public void printAllScores() {
        System.out.println("Test Scores:");
        Iterator<Integer> itr = testScoreList.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    //method that uses an enhanced for loop to print out the data
    public void printScoresUsingEnhanceedForLoop() {
        System.out.println("Test Scores:");
        for (int current : testScoreList) {
            System.out.println(current);
        }
    }

    //adds a new score
    public void setNextScore(int score) {
        testScoreList.add(score);
    }

    //adds a new score at the certain index
    public void setScoreAt(int index, int score) {
        testScoreList.add(index, score);
    }

    //return a score at a certain index
    public int getScoreAt(int index) {
        return testScoreList.get(index);
    }

    //return the size of the list
    public int getSizeOfList() {
        return testScoreList.size();
    }
}
