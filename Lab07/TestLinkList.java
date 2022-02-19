public class TestLinkList
{
   public static void main (String[] args)
   {
      SimpleLinkedList testList = new SimpleLinkedList();
      
      System.out.println( testList );
      
      testList.addToTail( "Ali" );
      System.out.println( testList );
      
      testList.addToTail( "ozcan" );
      testList.addToTail( "cs102" );
      testList.addToTail( "sirin" );
      System.out.println( testList );
      
      System.out.println( testList.get( "Ali" ) );
      System.out.println( testList.get( "ayse" ) );
      
      testList.removeFromHead();
      System.out.println( testList );
      System.out.println( testList.get( "Ali" ) );
   }
}