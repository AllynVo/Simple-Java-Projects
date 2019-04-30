//Allyn Vo
//CS 301
//Project 5
package project5;

/**
 *
 * @author Allyn Vo
 */
public class ChangePiCompute {

    //wrapper method
    public String changePi(String str2) {
        //call changePiRecurse
        return changePiRecurse(str2);
    }

    //recursive method
    public String changePiRecurse(String str) {
        //str is the String to check for "pi"

        //When the string is zero or one char
        if (str.length() == 0 || str.length() == 1) {
            return str;
        }

        //When next to char is p and i, add 3.14 to the returned string
        if (str.charAt(0) == 'p' && str.charAt(1) == 'i') {
            return "3.14" + changePiRecurse(str.substring(2));
        } //When there is not pi next, add next char to the returned string
        else {
            return str.charAt(0) + changePiRecurse(str.substring(1));
        }
    }
}
