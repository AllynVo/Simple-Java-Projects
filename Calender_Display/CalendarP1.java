//Allyn Vo & Cristian Villa
//Project 1, part 1, calender
//1-25-2017
//CS 111
import java.util.Scanner;

public class CalendarP1{

    private static int numDays = 0;
    private static int x = 0;
    
    //determines of it is a leap year
    public static boolean ifLeap(int year)
    {
        if(((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //determines the first day of the year
    public static void firstDayOfYear(int year)
    {
        int month = 13;
        year--;
        x = (1 + (int)(((month + 1) * 26) / 10.0) + year + (int)(year / 4.0) + 6 * (int)(year / 100.0) + (int)(year / 400.0)) % 7;
        String dayName = "";
        switch(x)
        {
            case 0: dayName = "Saturday"; break;
            case 1: dayName = "Sunday"; break;
            case 2: dayName = "Monday"; break;
            case 3: dayName = "Tuesday"; break;
            case 4: dayName = "Wednesday"; break;
            case 5: dayName = "Thursday"; break;
            default: dayName = "Friday"; break;
        }
    }
    
    //Determines the first day of the month
    public static void firstDayOfMonth(int month, int year)
    {
        if(month == 1 || month == 2)
        {
            month += 12;
            year--;
        }
        
        //Formula to determine first day
        x = (1 + (int)(((month + 1) * 26) / 10.0) + year + (int)(year / 4.0) + 6 * (int)(year / 100.0) + (int)(year / 400.0)) % 7;
        
        String dayName = "";
        
        switch(x)
        {
            case 0: dayName = "Saturday"; break;
            case 1: dayName = "Sunday"; break;
            case 2: dayName = "Monday"; break;
            case 3: dayName = "Tuesday"; break;
            case 4: dayName = "Wednesday"; break;
            case 5: dayName = "Thursday"; break;
            default: dayName = "Friday"; break;
        }
    }
    
    //Determines the number of days in each month
    public static void numDaysInMonth(int month, int year)
    {
        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (month == 2 && ifLeap(year)) days[month] = 29;
        numDays = days[month];
    }
    
    //Display top calendar of that month
    public static void setTheMonth(int month, int year)
    {
        String[] monthNames = {"","January","February","March","April","May","June","July","August","September","October","November","December"};

        System.out.println("    " + monthNames[month] + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        
        if(x == 0){
         x = 7;
        }  
         
        for (int i = 0; i < x - 1; i++){
            System.out.print("   ");
        }
           
        for (int i = 1; i <= numDays; i++){
            System.out.printf("%2d ", i);
            if (((i + x - 1) % 7 == 0) || (i == numDays)) System.out.println();
        }
    }
    
    //display the day of the week
    public static void dayOfWeek(int year, int month, int day){
         //Calculates the day of the week
         if (month < 3){  
            month += 12;  
            year -= 1;  
         }  
         
         int i = year % 100;  
         int j = year / 100;  
         int date = ((day + (((month + 1) * 26) / 10) + i + (i / 4) + (j / 4))  + (5 * j)) % 7;  
   
         String Name = "";  
         if (date == 0) {  
             Name = "Saturday.";  
         }else if(date == 1){  
             Name = "Sunday.";  
         }else if(date == 2){  
             Name = "Monday.";  
         }else if(date == 3){  
             Name = "Tuesday.";  
         }else if(date == 4){  
             Name = "Wednesday.";  
         }else if(date == 5){  
             Name = "Thursday.";  
         }else if(date == 6){  
             Name = "Friday.";  
         }  
         //print out day of week
         System.out.println("That date is a " + Name);    
    }
    
    //displayMonth method
    public static void displayMonth(int month, int year){
         firstDayOfMonth(month, year);
         numDaysInMonth(month, year);
         setTheMonth(month, year);
    }
    
    //whichWeek method
    public static void whichWeek(int year, int month, int day){
         firstDayOfYear(year);
         firstDayOfMonth(month, year);
         numDaysInMonth(month, year);
         setTheMonth(month, year);
         dayOfWeek(year, month, day);
    }
    
    //dateFRom method
    public static void dateFrom(int year, int month, int day){
    
       System.out.println("Enter a number of days after your current date");
       Scanner input = new Scanner(System.in);
               
            day += input.nextInt();
            while(day >30){
               day -= 30;
               month++;
            }
            while(month>12){
               month -=12;
               year ++;
            }
            
            firstDayOfYear(year);
            firstDayOfMonth(month, year);
            numDaysInMonth(month, year);
            setTheMonth(month, year) ; 
            System.out.println("The date is: "+month+"/"+day+"/"+year);
    }
    
    //Main Method\\
    public static void main(String[] args){
    
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();
        
        System.out.print("Enter Day of the month: ");
        int day = input.nextInt();
        
        if(month < 1 || month > 12){
            System.out.println("Invalid month. Valids inputs are 1-12.");
            System.exit(0);
        }
        
        if(day < 1 || day > 31){
            System.out.println("Invalid day. Valids inputs are 1-31 (depending on which month).");
            System.exit(0);
        }
        
        System.out.print("Enter year (year > 1753): ");
        int year = input.nextInt();
        if(year < 1753){
            System.out.println("Invalid year. Only inputs that are over 1753 work.");
            System.exit(0);
        }
        
        //Prompt the user for integer for what they want to display
        System.out.println("To display month, enter 1."
                           +"\nTo display day of the week, enter 2."
                           +"\nTo display date from, enter 3");
        int option = input.nextInt();
        //Case for what to display.              
        switch(option){
           case 1:  
               displayMonth(month,year);    
               break;
            
           case 2:
               whichWeek(year, month, day);
               break;

           case 3:
              dateFrom(year, month, day);
              break;

           default:
            System.out.println("You did not type an number from 1-3");
        }       
    }    
}