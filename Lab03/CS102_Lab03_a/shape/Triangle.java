public class Triangle extends Shape
{
   private int sideA;
   private int sideB;
   private int sideC;
   
   public Triangle( int a , int b , int c , int x , int y)
   {
      super( x , y );
      this.sideA = a;
      this.sideB = b;
      this.sideC = c;
   }
   public int getSideA()
   {
      return sideA;
   }
   public int getSideB()
   {
      return sideB;
   }
   public int getSideC()
   {
      return sideC;
   }
   
   public double getArea()
   {
      double semiPerimeter = getPerimeter() / 2;
      
      return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC) );
   }
   public double getPerimeter()
   {
      return sideA + sideB + sideC;
   }
   public String toString()
   {
      return "Triangle with sides " + sideA + sideB + sideC + " in the ( " + super.getX() + " , " + super.getY() + " )";
   }
}