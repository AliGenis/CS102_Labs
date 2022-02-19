import java.awt.event.*;
import cs102.*;
import javax.swing.*;

public class HangmanLetterButtonsController implements ActionListener
{
   private Hangman hangman;
   
   public HangmanLetterButtonsController(Hangman hangman)
   {
      this.hangman = hangman;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      JButton b = (JButton) e.getSource();
      char c = b.getText().charAt(0);
      hangman.tryThis(c);
   }
   
}