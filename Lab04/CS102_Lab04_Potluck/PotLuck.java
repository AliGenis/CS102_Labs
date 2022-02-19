import javax.swing.*;
import java.util.Scanner;

public class PotLuck
{
   private static int[] pots;
   public static void main ( String[] args )
   {
      JFrame frame = new JFrame( "Game" );
      JPanel panel = new JPanel();
      Scanner scan = new Scanner(System.in);
      int matrix;
      
      System.out.println( "Please insert the dimension of the pot luck game" );
      matrix = scan.nextInt();
      panel.setLayout (new BoxLayout(panel, BoxLayout.Y_AXIS));
      panel.add( new GameFrame( matrix ) );
      frame.setSize( 500 , 500 );
      frame.add( panel );
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pots = new int[ matrix * matrix ];
      choosePrize();
      chooseBomb();
      chooseBomb();
   }
   
   public static void choosePrize()
   {
      int choosen = (int)(Math.random() * pots.length );
      if( pots[choosen] == 0 )
         pots[choosen] = 1;
      else
         choosePrize();
   }
   public static void chooseBomb()
   {
      int choosen = (int)(Math.random() * pots.length );
      if( pots[choosen] == 0 )
         pots[choosen] = -1;
      else
         chooseBomb();
   }
   
   
}