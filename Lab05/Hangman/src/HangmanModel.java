import cs102.*;
import java.util.ArrayList;

public class HangmanModel extends Hangman
{
   private ArrayList<IHangmanView> viewList = new ArrayList<IHangmanView>();
   
   public HangmanModel( IHangmanSetup setup )
   {
      super( setup );
   }
   public void addView( IHangmanView view )
   {
      viewList.add( view );
      view.updateView( this );
   }
   public void update()
   {
      for( int i = 0; i < viewList.size(); i++ )
         viewList.get(i).updateView( this );
   }
   
   public int tryThis( char c )
   {
      int tryThis;
      tryThis = super.tryThis( c );
      update();
      return tryThis;
   }
   public void initNewGame()
   {
      viewList = new ArrayList<IHangmanView>();
      super.initNewGame();
      update();
   }
}