//Allyn Vo
//Project 2, part 1, normal compute grades and statistics
//2-21-2017
//CS 111
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class ComputeGradesP2 extends GradedActivity{
   public static void main(String[] args) throws IOException, WrongFormatException{
      
      Scanner keyboard = new Scanner(System.in);
      
      try{ //Try 1
         System.out.print("Please enter the file name consisting the names and scores\nex.\"projA.txt\" : ");
         String filename = keyboard.nextLine(); 
         //String filename = "projA.txt";
   
         //counts number of row in file
         BufferedReader reader = new BufferedReader(new FileReader(filename));
         int row = 0;
         while (reader.readLine() != null) row++;
         reader.close();
         
         
         
         //open file
         File file = new File(filename);
         Scanner inputFile = new Scanner(file);
      
      
         int studentCount = 0;
         String[] student = new String[row];
         //loop to put each student and their scores into string arrays
         while (inputFile.hasNextLine()) {
         String theString = "";
         theString = inputFile.nextLine();
             student[studentCount] = theString;
             studentCount++;
         //System.out.println(student[studentCount-1]);
         }
         
         
         //close read file
         inputFile.close();
         
         //Counts number of columns
         String[] columnCount = student[0].split(" ");
         int column = columnCount.length;
         //System.out.println(columnCount.length);
         
         //put everything into 2D array
         String[][] stuArr = new String[row][column];
         for (int i=0; i<row; i++){
            String[] stuArray = student[i].split(" ");
            for (int j=0; j<column; j++){
               stuArr[i][j] = stuArray[j];           
            }
         } 
         //System.out.println(Arrays.deepToString(stuArr));       

     
///////////////////////////////////////////////////////////////////////////////////////////////////// 
         System.out.print("Please enter the file name consisting rubrics\nex.\"projA-rub.txt\" : ");
         String filename2 = keyboard.nextLine(); 
         //String filename2 = "projA-rub.txt";
         //open second read file
         File file2 = new File(filename2);
         Scanner inputFile2 = new Scanner(file2);
         
         //counts number of row in file
         BufferedReader reader2 = new BufferedReader(new FileReader(filename2));
         int row2 = 0;
         while (reader2.readLine() != null) row2++;
         reader2.close();
         
         
         //keep track of the number of rows in the file
         int count2 = 0;
         //loop to put each rubric and their scores weight into string arrays
         String[] rub = new String[row2];
         while (inputFile2.hasNextLine()) {
         String theString = "";
         theString = inputFile2.nextLine();
             rub[count2] = theString;
             count2++;   
            //System.out.println(rub[count2-1]);
         }
               
         //Counts number of columns
         String[] columnCount2 = rub[0].split(" ");
         int column2 = columnCount2.length;
      //System.out.println(columnCount2.length);    
/////////////////////////////////////////////////////////////////////////////////////////////////////      
         //put everything into 2D array
         String[][] rubArr = new String[row2][column2];
         for (int i=0; i<row2; i++){
            String[] rubArray = rub[i].split(" ");
            for (int j=0; j<column2; j++){
               rubArr[i][j] = rubArray[j];           
            }
         }
         //System.out.println(Arrays.deepToString(rubArr)); 
   
         //close second read file
         inputFile2.close();
/////////////////////////////////////////////////////////////////////////////////////////////////////
         //Extra token on line exception
         extraToken(stuArr, student);
         extraToken(rubArr, rub);
/////////////////////////////////////////////////////////////////////////////////////////////////////         
         //Non letter character for student names exception
         for(int j=0; j<stuArr.length; j++){
            for(int i=0; i<2; i++){
               try{
                  String str = stuArr[j][i];
                  if(str.matches("[a-zA-Z]+")){
                  }
                  else {
                  throw new IOException();
                  }  
               }
               catch(IOException e){
                  System.out.println("Error: non letter character in students/score file, at line: " + (j+1));
                  System.exit(0);
               }
            }
         }
/////////////////////////////////////////////////////////////////////////////////////////////////////         
         //Non letter character for rubric names exception
         for(int j=0; j<rubArr.length; j++){
               try{
                  String str = rubArr[j][0];
                  if(str.matches("[a-zA-Z]+")){
                  }
                  else {
                  throw new IOException();
                  }  
               }
               catch(IOException e){
                  System.out.println("Error: non letter character in rubric file, at line: " + (j+1));
                  System.exit(0);
               }
         }
/////////////////////////////////////////////////////////////////////////////////////////////////////         
         //Character when expecting a number (indicate line) for rubric exception
         for (int i=0; i<stuArr.length; i++){
             for(int j=2; j<stuArr[i].length; j++){
                 try{ //Try 2
                  
                    Double.parseDouble(rubArr[j-2][1]);
                 } //End of try 2
                 catch(NumberFormatException e){
                    System.out.println("Non number found in rubric at line: " + (j-1));
                    System.exit(0);
                 }           
             }
         }
/////////////////////////////////////////////////////////////////////////////////////////////////////         
         //Character when expecting a number (indicate line) for students file exception
         for (int i=0; i<stuArr.length; i++){
             for (int j=2; j<stuArr[i].length; j++){
                 try{ //Try 3
                  
                    Double.parseDouble(stuArr[i][j]);
                 } //End of try 3
                 catch(NumberFormatException e){
                    System.out.println("Non number found in file containing students and their scores at line: " + (i+1));
                    System.exit(0);
                 }           
             }
         } 
/////////////////////////////////////////////////////////////////////////////////////////////////////
         //Weights of rubrics adding different from 100 exception
         double rubTotal = 0;
         try{
            for (int i=0; i<rubArr.length; i++){
               rubTotal += Double.parseDouble(rubArr[i][1]);  
            }
            if(rubTotal != 100.0)
                  throw new IOException();
         }
         catch(IOException e){
            System.out.println("Error: the weights of the rubrics do not add up to 100, instead, it adds up to: " + rubTotal);
            System.exit(0);
         }    
/////////////////////////////////////////////////////////////////////////////////////////////////////             
         //calculate the averages for each student
         double[] avg = new double[stuArr.length];
         for (int i=0; i<stuArr.length; i++){
            for(int j=2; j<stuArr[i].length; j++){
               //try{
                  double sum = ( Double.parseDouble(stuArr[i][j]) / 100 * Double.parseDouble(rubArr[j-2][1]) );
                  avg[i] += sum;  
            }//System.out.println(avg[i]);
         }

/////////////////////////////////////////////////////////////////////////////////////////////////////
         //calculate the letter grade for each student
         char[] letterGr = new char[stuArr.length];
         for (int i=0; i<avg.length; i++){
            letterGr[i] = getGrade(avg[i]);
            //System.out.println(letterGr[i]);
         }
/////////////////////////////////////////////////////////////////////////////////////////////////////
         //finds the best rubric or rubric's for each student
         String[] bestRub = new String[stuArr.length]; 
         for (int i=0; i<stuArr.length; i++){
            double x = 0;
            for (int j=2; j<stuArr[0].length; j++){
               if( Double.parseDouble(stuArr[i][j]) > x){
                  x = Double.parseDouble(stuArr[i][j]);
                  bestRub[i] = rubArr[j-2][0];
               }
               if(j>2){
                  if( Double.parseDouble(stuArr[i][j]) == Double.parseDouble(stuArr[i][j-1])){
                     bestRub[i] = rubArr[j-3][0] + " " + rubArr[j-2][0];
                  }
               }
               
            }//System.out.println(bestRub[i]);
         }
/////////////////////////////////////////////////////////////////////////////////////////////////////
         //append output to string builder 
         StringBuilder output = new StringBuilder();
         output.append(filename+ "\n");
         for(int i=0; i<stuArr.length; i++){
            output.append(String.format("\t%-10s%-15s%.2f    %-5s%-5s\n", stuArr[i][0],stuArr[i][1],avg[i] ,letterGr[i],bestRub[i]));
         }
         System.out.println(output);
         
         //new file
         FileWriter writer = new FileWriter("output.txt");
         writer.write(output.toString());
         writer.flush();
         writer.close();
      
      }//end of try 1
      catch (FileNotFoundException e){
         System.out.println("An expected file not found.");
      }
      catch (ArrayIndexOutOfBoundsException e){
         System.out.println("Error: There is an extra token in the input.");
      }
      
   }//end of main method
/////////////////////////////////////////////////////////////////////////////////////////////////////
   //Extra token on line exception method
   public static void extraToken(String [][] arr, String [] stu){
   
      int columnE1;
      int columnE2;
      try{ //Try 4
         for (int i=0; i<arr.length-1; i++){
               String[] columnCountE1 = stu[i].split(" ");
               columnE1 = columnCountE1.length;
               String[] columnCountE2 = stu[i+1].split(" ");
               columnE2 = columnCountE2.length;
               
               if(columnE1 != columnE2){
                  throw new WrongFormatException ("Error: There is an extra token in the input.");
               }   
         }
      } //End of try 4
      catch(WrongFormatException e){
      }
   }
   
}//end of program

