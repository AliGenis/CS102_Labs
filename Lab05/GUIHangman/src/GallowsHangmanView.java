import cs102.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class GallowsHangmanView extends JPanel implements IHangmanView
{
  //Variables
  private Rectangle2D.Double[] rec;
  private Line2D.Double[] manLines;
  private Ellipse2D.Double manHead;
  private Hangman hangman;
  private Shape[] man;
  private String secret;
  private String tries;
  private String used;
  
  //Constants
  private static final int PANEL_HEIGHT = 300;
  private static final int  WIDTH = 300;
  private static final int  X = 0;
  private static final int  Y = 50;
  private static final Font FONT = new Font("Times New Roman", Font.BOLD, 50);
  
  public GallowsHangmanView(Hangman hangman)
  {
    this.hangman = hangman;
    this.setBackground(Color.red);
    
    //intializing
    rec = new Rectangle2D.Double[4];
    manLines = new Line2D.Double[5];
    man = new Shape[6];
    
    secret = "";
    tries = "";
    used = "";
    
    //gallow
    rec[0] = (new Rectangle2D.Double(20 + X, 400 + Y, 300, 50));//bottom rectangle
    rec[1] = (new Rectangle2D.Double(60 + X, 40 + Y, 20, 360));//from bottom vertical
    rec[2] = (new Rectangle2D.Double(80 + X, 40 + Y, 120, 20));//top horizontal
    rec[3] = (new Rectangle2D.Double(194 + X, 60 + Y, 6, 30));//top vertical
    
    //stick human
    manHead = new Ellipse2D.Double(167 + X, 90 + Y, 60, 60);
    
    //body
    manLines[0] = new Line2D.Double(manHead.getX() + (manHead.getWidth() / 2), 
                                    manHead.getY() + manHead.getHeight(), 
                                    manHead.getX() + (manHead.getWidth() / 2)
                                      ,manHead.getY() + manHead.getHeight() + 70);
    //leftLeg
    manLines[1] = new Line2D.Double(manLines[0].getX2(), manLines[0].getY2(), manLines[0].getX2() - 30, 
                                    manLines[0].getY2() + 60);
    //right leg
    manLines[2] = new Line2D.Double(manLines[0].getX2(), manLines[0].getY2(), manLines[0].getX2() + 30, 
                                    manLines[1].getY2()); 
    //left arm
    manLines[3] = new Line2D.Double(manLines[0].getX2(), 
                                    ((manLines[0].getY2() - manLines[0].getY1()) / 5) + manLines[0].getY1()
                                      , manLines[0].getX1() - 28, 
                                    ((manLines[0].getY2() - manLines[0].getY1()) / 4) + manLines[0].getY1() + 40);
    //right arm
    manLines[4] = new Line2D.Double(manLines[0].getX2(), manLines[3].getY1(), manLines[0].getX1() + 28, 
                                    manLines[3].getY2());
    
    man[0] = manHead;
    for (int i = 1; i < man.length; i++)
    {
      man[i] = manLines[i - 1];
    }
  }
  
  public void updateView(Hangman hangman)
  {
    if ( !hangman.isGameOver() ) 
    {
       secret = hangman.getKnownSoFar();
       tries = "Tries: " + hangman.getNumOfIncorrectTries() + "/" + hangman.getMaxAllowedIncorrectTries();
       used = "Used letters: " + hangman.getUsedLetters();
    }
    
    else if( hangman.hasLost() )
    {
       secret = "HAHAHA";
       tries = "You lost the game!";
       used = "Used letters: " + hangman.getUsedLetters();
    }
    else
    {
       secret = "Congratulations!";
       tries = "You won!";
       used = "Used letters: " + hangman.getUsedLetters();
    }
    repaint();
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    
    //draw the gallow
    g2.setPaint(Color.black);
    for(int i = 0; i < rec.length; i++)
      g2.fill(rec[i]);
    
    //drawing the man based on the game state
    for(int i = 0; i < hangman.getNumOfIncorrectTries(); i++)
      g2.draw(man[i]);
    
    //changing the style to draw the text
    g2.setFont(FONT);
    g2.setPaint(Color.black);
    
    //drawing the strings
    g2.drawString(secret, (int)rec[0].getX() + 20, (int)(rec[0].getY() + rec[0].getHeight()) + 60);
    g2.drawString(used, (int)rec[0].getX() + 20, (int)(rec[0].getY() + rec[0].getHeight()) + 120);
    g2.drawString(tries, (int)(rec[1].getX() + rec[1].getWidth()) + 15, (int)rec[0].getY() - 50);

  }
  
}