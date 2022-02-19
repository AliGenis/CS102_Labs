import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JPanel
{
   private JLabel trackLabel;
   private JPanel gamePanel = new JPanel();
   private Container gameContainer = new Container();
   private JPanel counterPanel = new JPanel();
   protected int counter = 0;
   private int[] pots;
   protected String theText = "Number of clicks: " + counter;
   
   public GameFrame( int n )
   {
      add( new CounterPanel() );
      this.addGamePanel( n );
      setBomb( n );
   }
   class CounterPanel extends JPanel{
      public CounterPanel()
      {
         setBackground( Color.yellow );
         setPreferredSize( new Dimension( 400 , 50 ) );
      }
      public void paintComponent(Graphics g)
      {
         super.paintComponent( g ); 
         g.drawString( getTheText(), 100,25);
      }
   }
   public void addGamePanel( int n )
   {
      gamePanel.setBackground( Color.green );
      gamePanel.setLayout( new GridLayout( n , n ) );
      //gamePanel.setPreferredSize( new Dimension( 70 * (n + 1) , 20 * (n + 1) ) );
      for( int i = 0; i < n * n; i++ )
      {
         JButton button = new JButton( "Pot " + (i + 1) );
         button.setPreferredSize( new Dimension( 70 , 20 ) );
         button.addActionListener( new ButtonListen() );
         gamePanel.add( button );
      }
      add( gamePanel );
   }
   public void setBomb( int n )
   {
      pots = new int[ n * n ];
      choosePrize();
      chooseBomb();
      chooseBomb();
      for( int i =0; i < pots.length; i++ )
         System.out.println( pots[i] );
   }
   public void choosePrize()
   {
      int choosen = (int)(Math.random() * pots.length );
      if( pots[choosen] == 0 )
         pots[choosen] = 1;
      else
         choosePrize();
   }
   public void chooseBomb()
   {
      int choosen = (int)(Math.random() * pots.length );
      if( pots[choosen] == 0 )
         pots[choosen] = -1;
      else
         chooseBomb();
   }
   
   public String getTheText()
   {
      return theText;
   }
   class ButtonListen implements ActionListener
   {
      public void actionPerformed( ActionEvent event )
      {
         counter++;
         ((JButton)(event.getSource())).setEnabled( false );
         if( pots[Integer.parseInt(((JButton)(event.getSource())).getText().substring( 4 )) - 1] == 1 )
            theText = "You lucky! You found prize on attempt:" + counter;
         else if( pots[Integer.parseInt(((JButton)(event.getSource())).getText().substring( 4 )) - 1] == -1 )
            theText = "NOOO!You have blown up on attempt:" + counter;
         else
            theText = "Number of clicks: " + counter;
         System.out.println( ((JButton)(event.getSource())).getText().substring( 4 ) );
         repaint();
      }
   }
   
}