public class HTMLFilteredReader extends MySimpleURLReader
{
   public HTMLFilteredReader( String link )
   {
      super( link );
   }
   public String getPageContents()
   {
      String filteredContent = "";
      
      for( int i = 0; i < getUnfilteredPageContents().length(); i++)
      {
         if( getUnfilteredPageContents().charAt( i ) == '<' )
         {
            boolean check = true;
            for( int j = 0; check; j++ )
            {
               if( getUnfilteredPageContents().charAt( i + j ) == '>' )
               {
                  check = false;
                  i += j;
               }  
            }
         }
         else
            filteredContent += Character.toString( getUnfilteredPageContents().charAt( i ) );
      }
      return filteredContent;
   }
   public String getUnfilteredPageContents()
   {
      String unfiltered = super.getPageContents();
      return unfiltered;
   }
}