//Allyn Vo
//new wrong format exception
//2-21-2017
//CS 111
public class WrongFormatException extends Exception{

    // CONSTRUCTOR

    public WrongFormatException( String message )
    {
        System.out.println(message);
        System.exit(0);
    }

}