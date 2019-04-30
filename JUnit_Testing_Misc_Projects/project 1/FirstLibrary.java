/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstlibrary;

/**
 *
 * @author cs301001_17
 */
public class FirstLibrary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        run();
    }

    //run method
    public static void run() {
        System.out.println("main called run. Now in run.");
        //Class1 is an object of OutputLibrary
        OutputLibrary class1 = new OutputLibrary();
        class1.out();
        System.out.println("out returned. Now in run.");
    }

}
