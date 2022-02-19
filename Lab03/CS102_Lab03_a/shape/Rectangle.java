public class Rectangle extends Shape
{
   private int width;
   private int height;
   public Rectangle( int width , int height , int x , int y )
   {
      super( x , y );
      this.width = width;
      this.height = height;
   }
   public int getWidth()
   {
      return width;
   }
   public int getHeight()
   {
      return height;
   }
   public double getArea()
   {
      return width * height;
   }
   public double getPerimeter()
   {
      return 2 * ( width + height );
   }
   public String toString()
   {
      return "Rectangle with width " + width + "and height " + height + " in the ( " + super.getX() + " , " + super.getY() + " )";
   }
}