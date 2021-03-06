import cs102.*;
import java.awt.*;
import javax.swing.*;

public class LabelsHangmanView extends JPanel implements IHangmanView
{
   private JLabel tries;
   private JLabel used;
   private JLabel secret;
   private JPanel panel;
   
   private static final Font FONT = new Font("Times New Roman", Font.BOLD, 20 );
   
   public LabelsHangmanView()
   {
      this.setPreferredSize( new Dimension(400,200) );
      
      tries = new JLabel( "" );
      used = new JLabel( "" );
      secret = new JLabel( "" );
      panel = new JPanel();
      
      tries.setFont( FONT );
      used.setFont( FONT );
      secret.setFont( FONT );
      
      setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );
      
      add( secret );
      add( tries );
      add( used );
      
      setBackground( Color.yellow );
   }
   
   public void updateView( Hangman hangman )
   {
      if( !hangman.isGameOver() )
      {
         secret.setText( hangman.getKnownSoFar() );
         tries.setText( "Tries: " + hangman.getNumOfIncorrectTries() + "/" + hangman.getMaxAllowedIncorrectTries() );
         used.setText( "Used letters: " + hangman.getUsedLetters() );
      }
      else if( hangman.hasLost() )
      {
         secret.setText( "HAHAHA" );
         tries.setText( "You lost the game!" );
         used.setText( "Used letters: " + hangman.getUsedLetters() );
      }
      else
      {
         secret.setText( "Congratulations!" );
         tries.setText( "You won!" );
         used.setText( "Used letters: " + hangman.getUsedLetters() );
      }
   }
}