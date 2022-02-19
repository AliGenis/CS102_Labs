import cs1.*;
public class SimpleURLTest
{
   public static void main( String[] args )
   {
      SimpleURLReader housman = new SimpleURLReader( "https://scrapethissite.com/pages/simple" );
      
      System.out.println( housman.getPageContents() );
      System.out.println( housman.getLineCount() );
   }
}