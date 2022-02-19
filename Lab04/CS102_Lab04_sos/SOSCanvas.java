import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cs101.sosgame.SOS;

public class SOSCanvas extends JPanel
{
   //JPanel seperator = new JPanel();
   JButton buton = new JButton();
   private int size;
   private int column = 1;
   private int row = 1;
   SOS game;
   JFrame popup = new JFrame();
   JLabel[][] text;
   String p1 = "P1";
   String p2 = "P2";
   boolean s = true;
   
   public SOSCanvas( int n , String first , String second )
   {
      game = new SOS( n );
      text = new JLabel[n][n];
      setPreferredSize( new Dimension( ( 50 * n )  , ( 50 * n ) ) );
      setBackground( Color.green );
      size = n;
      p1 = first;
      p2 = second;
      for( int i = 0; i < n; i++ )
      {
         for( int j = 0; j < n; j++ )
         {
            text[i][j] = new JLabel( "", SwingConstants.CENTER );
            text[i][j].setPreferredSize( new Dimension(45 , 45) );
            add( text[i][j] );
         }
      }
      addMouseListener( new Click() );
   }
   public int getRow()
   {
      return row;
   }
   public int getColumn()
   {
      return column;
   }
   public void goPlay( boolean s )
   {
      if( s )
      {
         game.play( 's' , getRow() + 1 , getColumn() + 1);
         text[getRow()][getColumn()].setText( "S" );         
      }
      else
      {
         game.play( 'o' , getRow() + 1 , getColumn() + 1);
         text[getRow()][getColumn()].setText( "O" );
      }
   }
   public void paintComponent( Graphics g )
   {
      super.paintComponent(g);
      //Dik
      for( int i = 0; i <= size; i++ )
         g.drawLine( 0 + ( i * 50 ) , 0 , 0 + ( i * 50 ) , (0 + 50*size ) );
      //Paralel
      for( int i = 0; i <= size; i++ )
         g.drawLine( 0 , 0 + ( i * 50 ) , (0 + 50*size) , 0 + ( i * 50 ) );
   }
   class Click implements MouseListener{
      public void mouseClicked(MouseEvent e)
      {
         if( !game.isGameOver() )
         {
         column = findRC( e.getX() );
         row = findRC( e.getY() );
         text[row][column].setLocation( e.getX() , e.getY() );
         goPlay( s );
         game.printBoard();
         System.out.println( e.getX() );
         System.out.println( e.getY() );
         }
         else if ( game.getPlayerScore1() > game.getPlayerScore2() )
            JOptionPane.showMessageDialog(popup, "Winner is " + p1 );
         else if ( game.getPlayerScore1() < game.getPlayerScore2() )
            JOptionPane.showMessageDialog(popup, "Winner is " + p2 );
         else
            JOptionPane.showMessageDialog(popup, "HAHAHA It is a draw I won" );
      } 
      public int findRC( int i )
      {
         return (i-0)/50;
      }
      public void mouseEntered(MouseEvent e){} 
      public void mouseExited(MouseEvent e){}
      public void mousePressed(MouseEvent e){} 
      public void mouseReleased(MouseEvent e){}
   }
}