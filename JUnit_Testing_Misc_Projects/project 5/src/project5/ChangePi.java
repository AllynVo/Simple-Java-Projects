//Allyn Vo
//CS 301
//Project 5
package project5;

import java.util.*;

/**
 *
 * @author Allyn Vo
 */
public class ChangePi {

    //run method
    public void run(String str1) {
        //use wrapper method "changePi
        try {
            ChangePiCompute printInstance = new ChangePiCompute();
            System.out.println(printInstance.changePi(str1));
        } catch (StackOverflowError e) {
            System.out.println(e);
        }
    }

}
