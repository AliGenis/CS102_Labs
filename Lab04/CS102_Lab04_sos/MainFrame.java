import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
   public static void main( String[] args ){
      JFrame frame = new JFrame( "Test" );
      JPanel panel = new JPanel();
      
      SOSGUIPanel guiPanel = new SOSGUIPanel( Integer.parseInt( JOptionPane.showInputDialog(frame, "Enter row and column number" ) )
                                                , JOptionPane.showInputDialog(frame, "Enter first player's name" )
                                                , JOptionPane.showInputDialog(frame, "Enter second player's name" ) );
      panel.add(guiPanel);
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.setSize( 700 , 700 );
      frame.getContentPane().add(panel);
      frame.setFocusable(true);
      frame.setVisible(true);
   }
}