public abstract class Shape implements Locatable , Selectable
{
   private int x;
   private int y;
   private boolean selected;
   
   public abstract double getArea();
   public abstract double getPerimeter();
   public abstract String toString();
   public Shape( int x , int y)
   {
      this.x = x;
      this.y = y;
      this.selected = false;
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public void setLocation( int x , int y )
   {
      x = x;
      y = y;
   }
   public boolean getSelected()
   {
      return selected;
   }
   public void setSelected( boolean a )
   {
      selected = a;
   }
   public Shape contains( int desiredX , int desiredY )
   {
      if( x == desiredX && y == desiredY )
      {
         this.selected = true;
         return this;
      }
      return null;
   }
}