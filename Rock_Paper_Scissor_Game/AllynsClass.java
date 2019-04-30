import java.util.Random;
public class AllynsClass{
   //fields
   private String playerName;
   private int gamesPlayed;
   //methods
   public String getPlayerName(){//get players name (accessor)
      return playerName;
   }
   public int getGamesPlayed(){
      return gamesPlayed;
   }
   public void setGamesPlayed(int numOfGames){//set games played (mutator)
      gamesPlayed = numOfGames;
   }
   public int getRandomMove(){
      Random randomNumbers = new Random();
      int randomNum = randomNumbers.nextInt(3)+1;
      return randomNum;
   }
   //contructors
   public AllynsClass(){}
   public AllynsClass(String name){
      playerName = name;
      gamesPlayed = 0;
   }
}