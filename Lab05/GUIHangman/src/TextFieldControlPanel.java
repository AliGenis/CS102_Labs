import cs102.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldControlPanel extends JPanel
{
   private JTextField textField;
   private Hangman hangman;
   
   public TextFieldControlPanel(Hangman hangman)
   {
      this.hangman = hangman;
      textField = new JTextField(50);
      
      this.add(textField);
      textField.addActionListener( new TextListener() );
   }
   
   class TextListener implements ActionListener
   {
      public void actionPerformed( ActionEvent event )
      {
         String text = textField.getText();
         
         for( int i = 0; i < text.length(); i++ )
            hangman.tryThis( text.charAt( i ) );
         textField.setText( "" );
      }
   }
}