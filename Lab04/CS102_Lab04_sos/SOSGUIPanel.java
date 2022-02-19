import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SOSGUIPanel extends JPanel
{
   SOSCanvas canvas;
   JRadioButton sButton;
   JRadioButton oButton;
   String p1 = "P1";
   JLabel p1Label;
   String p2 = "P2";
   JLabel p2Label;
   JFrame popup = new JFrame();
   
   public SOSGUIPanel( int n , String first , String second )
   {
      canvas =  new SOSCanvas( n , first , second );
      setPreferredSize( new Dimension( ( 51 * n ) , ( 80 * n ) ) );
      setBackground( Color.yellow );
      setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
      add( canvas );
      addSOButtons();
      p1 = first;
      p2 = second;
      p1Label = new JLabel( p1 + " : " + canvas.game.getPlayerScore1() );
      p2Label = new JLabel( p2 + " : " + canvas.game.getPlayerScore2() );
      add( p1Label );
      add( p2Label );
      add( new JLabel( "Click yellow place to learn whose turn" ) );
      addMouseListener( new Click() );
   }
   public void letsPlay()
   {
         
         if( sButton.isSelected() )
            canvas.s = true;
         if( oButton.isSelected() )
            canvas.s = false;
         
         canvas.game.printBoard();
   }
   public void addSOButtons()
   {  
      sButton = new JRadioButton( "S" );
      oButton = new JRadioButton( "O" );
      ButtonGroup group = new ButtonGroup();
      sButton.setSelected( true );
      group.add( sButton );
      group.add( oButton );
      add( sButton );
      add( oButton );
   }
   class Click implements MouseListener{
      public void mouseClicked(MouseEvent e)
      {
         if( canvas.game.getTurn() == 1 )
            JOptionPane.showMessageDialog(popup, "Turn of " + p1);
         else
            JOptionPane.showMessageDialog(popup, "Turn of " + p2);
      } 
      
      public void mouseEntered(MouseEvent e){
      } 
      public void mouseExited(MouseEvent e)
      {
         letsPlay();
         p1Label.setText( p1 + " : " + canvas.game.getPlayerScore1() );
         p2Label.setText( p2 + " : " + canvas.game.getPlayerScore2() );
      }
      public void mousePressed(MouseEvent e){} 
      public void mouseReleased(MouseEvent e){}
   }
}