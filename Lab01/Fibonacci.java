/**
 * Class to find first 40 term of fibonnaci sequance
 * 
 * @author Ali Genis
 * @date 07.10.2020
 */
public class Fibonacci
{
   public static void main (String[] args )
   {
      IntBag fibonacci = new IntBag();
      
      fibonacci.add( 0 );
      fibonacci.add( 1 );
      
      for(int i = 0; i < 38; i++)
         fibonacci.add(fibonacci.getValue(i) + fibonacci.getValue(i + 1));
      System.out.println( fibonacci );
   }
}