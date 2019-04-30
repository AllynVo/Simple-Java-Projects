// Allyn Vo
// November 15, 2016
// Plays games of rock, paper, scissor with computer
// Final Project

import java.util.Scanner;
import java.util.Random;
import java.io.*;
public class NewRockPaperScissor {
   
	// Gets users move, Method
      // receives a single argument and returns void
   public static int userInput(){
     	Scanner keyboard = new Scanner(System.in);
     	int keyboardInput = keyboard.nextInt();
     	return keyboardInput;
	}
	   
	// Generate computers move, Method
   public static int randomMove(){
      //new object of AllynsClass
      AllynsClass random = new AllynsClass();
      return random.getRandomMove();
   }  
	   
	// Returns players move, Method
      // receives a single argument and returns a value
   public static String IntToMove(int playerMove){
      String move = "";
      switch(playerMove){
         case 1:
            move = "rock";
            break;
         case 2:
            move = "paper";
            break;
         case 3:
            move = "scissor";
            break;  
         default:
            System.out.println("Oops something went wrong");       
      }
      return move;
   }
   
   // Method to display who won using two arguements that return void
      // receive multiple arguments and return void
   public static void displayWinner(int playersMove, int computersMove){
      /* 1 is rock
         2 is paper
         3 is scissor */
	   if(playersMove == 1 && computersMove == 3 || playersMove == 2 && computersMove == 1 || playersMove == 3 && computersMove == 2){
		   System.out.print("You won game ");
	   }else if(playersMove == 3 && computersMove == 1 || playersMove == 1 && computersMove == 2 || playersMove == 2 && computersMove == 3){
		   System.out.print("I won game ");
	   }else{
		   System.out.print("Neither of us won game ");
	   }
	   
   }
	
   //First Instructions and Descriptions, Method
      // receives no arguments and returns void   
   public static void printInstructions1()throws IOException{
	   
	   // Read Description from File. File class
      String fileName = "Description.txt";
      File myFile = new File(fileName);
      Scanner inputFile = new Scanner(myFile);
	      while(inputFile.hasNext()){
	          String fileLine = inputFile.nextLine();
	             System.out.println(fileLine);
	      }
      inputFile.close();
      System.out.println("\nHow many games would you like to play?");
   }
         
	   
	//*** Main Method ***\\
   public static void main(String args[])throws IOException{
     //First Instructions and Description, Method
	  printInstructions1(); 
     
     //Gets number of games the user wants to play
	  int numOfGames = userInput(); 
	  
	  for(int i=0; i<numOfGames; i++){
         //Second Instructions  
	      System.out.println("Enter the integer '1' for rock, '2' for paper, or '3' for scissor"); 
         
	      int playerMove = userInput();
	      System.out.println("You picked " + IntToMove(playerMove)+".");
	      
	      int computersMove = randomMove();
	      System.out.println("I picked " + IntToMove(computersMove)+".");
	      
	      displayWinner(playerMove, computersMove); 
	      System.out.println(i+1 +"!\n");
	  }
     
     //new scanner class
     Scanner keyboard2 = new Scanner(System.in);
     System.out.println("What's your name? ");
     String playerName = keyboard2.nextLine();
     
     // new AllynsClass class
     AllynsClass player = new AllynsClass(playerName);
     player.setGamesPlayed(numOfGames);
     
     //Use my own class to leave last comments to player
     System.out.println("Thanks for playing " + player.getGamesPlayed() + " games with me, " + player.getPlayerName() + " ^.^");
   }
}