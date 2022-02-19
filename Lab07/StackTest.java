public class StackTest
{
   public static void main (String[] args)
   {
      SimpleStackWithQueue stack = new SimpleStackWithQueue();
      
      System.out.println( stack );
      
      stack.push( "Ali" );
      System.out.println( stack );
      
      stack.push( "ozcan" );
      stack.push( "cs102" );
      stack.push( "sirin" );
      System.out.println( stack );
      
      
      stack.pop();
      System.out.println( stack );
   }
}