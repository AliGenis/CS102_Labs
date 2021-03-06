import java.util.Iterator;
public class TestIterators
{
   public static void main( String[] args )
   {
      IntBag bag = new IntBag();
      
      for( int i = 0; i < 5; i++)
         bag.add( (int)(Math.random() * 10) );
      
      Iterator i, j;
      i = bag.iterator();
      while ( i.hasNext() )
      {
         System.out.println( i.next() );
         j = bag.iterator();
         while ( j.hasNext() )
         {
            System.out.println( "--" + j.next() );
         }
      }
   }
}