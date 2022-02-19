import cs102.*;

public class ConsoleHangmanView implements IHangmanView
{
   public void updateView( Hangman game )
   {
      if( !game.isGameOver() )
      {
         System.out.println( game.getKnownSoFar() );
         System.out.println( "You used " + game.getNumOfIncorrectTries() + "/" + game.getMaxAllowedIncorrectTries() ); 
      }
      else if( game.hasLost() )
         System.out.println( "YOU LOSER!" );
      else
         System.out.println( "Congratulations! You won!" );
   }
}