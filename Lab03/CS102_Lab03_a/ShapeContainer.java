import java.util.ArrayList;
public class ShapeContainer
{
   public ArrayList<Shape> container;
   public ShapeContainer()
   {
      container = new ArrayList<Shape>();
   }
   public void add( Shape s )
   {
      container.add( s );
   }
   public double getArea()
   {
      double totalArea = 0;
      
      for( int i = 0; i < container.size(); i++ )
         totalArea += container.get( i ).getArea();
      return totalArea;
   }
   public double getPerimeter()
   {
      double totalPerimeter = 0;
      
      for( int i = 0; i < container.size(); i++ )
         totalPerimeter += container.get( i ).getPerimeter();
      return totalPerimeter;
   }
   public Shape select( int x , int y )
   {
      Shape object = null;
      for(int i = 0; i < container.size() && object == null; i++ )
         object = container.get(i).contains( x , y );
      return object; 
   }
   public void removeSelected()
   {
      for(int i = 0; i < container.size(); i++ )
      {
         if( container.get(i).getSelected() == true )
            container.remove(i);
      }
   }
   public String toString()
   {
      String s = "";
      
      for(int i = 0; i < container.size(); i++ )
         s = s + container.get(i).toString() + "\n";
      
      return s;
   }
}