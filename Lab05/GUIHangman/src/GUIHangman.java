import java.awt.*;
import cs102.*;

/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
 public GUIHangman()
 {
     System.out.println( "Start of GUIHangman\n");

  HangmanModel  hangman;
  IHangmanSetup  basicSetup;
  ConsoleHangmanView consoleView;
  TextFieldControlPanel textField;
  NewGameButtonControl newGameButton;
  LabelsHangmanView labelsHangmanView;
  LetterButtonControls buttonControls;
  GallowsHangmanView gallowView;

  basicSetup = new BasicSetup();
  hangman = new HangmanModel( basicSetup);
  textField = new TextFieldControlPanel( hangman );
  newGameButton = new NewGameButtonControl( hangman );
  labelsHangmanView = new LabelsHangmanView();
  buttonControls = new LetterButtonControls(hangman.getAllLetters(),13,2);
  buttonControls.addActionListener(new HangmanLetterButtonsController(hangman));
  gallowView = new GallowsHangmanView(hangman);

  consoleView = new ConsoleHangmanView();
  hangman.addView( consoleView );
  hangman.addView( labelsHangmanView );
  hangman.addView( buttonControls );
  hangman.addView( gallowView );
  hangman.addView( newGameButton );

  new SimpleJFrame( "GUIHangman",  // title
       gallowView,   // center
       textField, newGameButton,  // north, south
       buttonControls, labelsHangmanView ); // east, west

  // this is an infinite loop reading from the console... not clever!
  ConsoleControl.controlFor( hangman);
 }

 public static void main( String[] args)
 {
  new GUIHangman();

//  // This is the approved way to initialise GUIs
//  // but won't work with the ConsoleControl as is!
//  // --------------------------------------------
//  SwingUtilities.invokeLater(
//   new Runnable() {
//       public void run() {
//           new GUIHangman();
//           new GUIHangman();
//       }
//   });
 }

} // end of class GUIHangman
