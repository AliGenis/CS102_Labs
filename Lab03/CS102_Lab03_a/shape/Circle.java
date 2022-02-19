public class Circle extends Shape
{
   private int radius;
   public Circle( int radius , int x , int y )
   {
      super( x , y );
      this.radius = radius;
      
   }
   public int getRadius()
   {
      return radius;
   }
   public double getArea()
   {
      return Math.PI * ( radius * radius );
   }
   public double getPerimeter()
   {
      return 2 * Math.PI * radius;
   }
   public String toString()
   {
      return "Circle with radius " + this.radius + " in the ( " + super.getX() + " , " + super.getY() + " )";
   }
}