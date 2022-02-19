public class Square extends Rectangle
{
   public Square ( int side , int x , int y )
   {
      super( side , side , x , y );
   }
   public String toString()
   {
      return "Square with side " + super.getHeight() + " in the ( " + super.getX() + " , " + super.getY() + " )";
   }
}