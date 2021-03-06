import cs1.*;
public class MySimpleURLReader extends SimpleURLReader
{
   private String url;
   private int numberOfCSS;
   public MySimpleURLReader( String link )
   {
      super( link );
      url = link;
      numberOfCSS = getNumberOfCSSLinks();
   }
   public String getURL()
   {
      return url;
   }
   public String getName()
   {
      String name = "";
      String url = getURL();
      
      for( int i = 0; i < url.length(); i++ )
      {
         if( url.charAt( i ) == '/' )
            name = new String();
         else
            name += url.charAt( i );
      }
      return name;
   }
   public int getNumberOfCSSLinks()
   {
      String splitter[] = getPageContents().split( "\\.css" );
      
      return splitter.length - 1;
   }
}
   