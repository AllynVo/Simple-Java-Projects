//Allyn Vo & Cristian Villa
//Project 1, part 2
//1-25-2017
//CS 111
import java.util.Scanner;
import java.io.*;

public class RmvTexP1{
   public static void main(String[] args) throws IOException{
      Scanner keyboard = new Scanner(System.in);
      
      String filename = args[0];

      String theString = "";
      
      //open file
      File file = new File(filename+".tex");
      Scanner inputFile = new Scanner(file);
      theString = inputFile.nextLine();
      

      //read input file to string
      while(inputFile.hasNextLine()){
         theString = theString + "\n\n" + inputFile.nextLine();
      }
      //create new stringbuilder using string^^^
      StringBuilder theString2 = new StringBuilder(theString);
      
      
      //replaces formulas "$___$" with FORMULA 1,2,3...etc
      int x=1;
      while(theString2.indexOf("$") != -1){
         int index = theString2.indexOf("$");
         //replace(int start, int end, String str)
         theString2.replace(index, theString2.indexOf("$",index+1)+1, "FORMULA " + x);
         x++;
      }
      
      //repalces \item with number line
      int y = 1;
      while(theString2.indexOf("\\item") != -1){
         theString2.replace(theString2.indexOf("\\item"), theString2.indexOf(" ", theString2.indexOf("\\item")), "\n " + y + ".");
         y++;
      }
      
      //removes cammands
      while(theString2.indexOf("\\") != -1){
         //delete(int start, int end)
         theString2.delete(theString2.indexOf("\\"), theString2.indexOf(" ", theString2.indexOf("\\"))+1);
      }
      
      while(theString2.indexOf("{") != -1){
         theString2.deleteCharAt(theString2.indexOf("{"));
      }
      
      while(theString2.indexOf("}") != -1){
         theString2.deleteCharAt(theString2.indexOf("}"));
      }

//only to test output in menu vvvv   
//System.out.println(theString2.toString());

      //close read file
      inputFile.close();
      
      theString2.toString().trim();
      //new file
      FileWriter writer = new FileWriter(filename+".txt");
      writer.write(theString2.toString());
      writer.flush();
      writer.close();
      
   System.out.println("Conversion is complete");
   }//end of main method
}//end of program