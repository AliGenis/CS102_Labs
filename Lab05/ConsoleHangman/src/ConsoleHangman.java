import java.util.Scanner;
import cs102.*;

/**
 * ConsoleHangman
 *
 * @author Ali Genis
 * @version 1.00 2020/12/3
 */

public class ConsoleHangman
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      System.out.println( "Start of ConsoleHangman\n");
      
      // VARIABLES
      Hangman  hangman;
      
      // PROGRAM CODE
      hangman = new Hangman( new BasicSetup() );
      
      System.out.println( hangman.getKnownSoFar() );
      
      // ToDo - allow user to repeatedly enter a letter and tryThis letter
      //    then show game status, until gameover. Finally report win/lose.
      while( !hangman.isGameOver() )
      {
         System.out.print("Enter a letter: ");
         hangman.tryThis( scan.next().charAt(0) );
         System.out.println( hangman.getKnownSoFar() );
      }  
      if( hangman.hasLost() )
         System.out.println( "YOU LOSER!" );
      else
         System.out.println( "Congratulations! You won!" );
      System.out.println( "\nEnd of ConsoleHangman\n" );
   }
   
} // end of class ConsoleHangman
