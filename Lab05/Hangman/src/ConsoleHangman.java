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
      HangmanModel  game;
      
      // PROGRAM CODE
      game = new HangmanModel( new BasicSetup() );
      game.addView( new ConsoleHangmanView() );
      game.addView( new ConsoleHangmanView() );
      
      do
      {
         game.tryThis( scan.next().charAt(0) );
      }while( !game.isGameOver() );
      
      System.out.println( "\nEnd of ConsoleHangman\n" );
   }
   
} // end of class ConsoleHangman
