public class WordSearch extends HTMLFilteredReader
{
   public WordSearch( String link )
   {
      super( link );
   }
   public void search( String word )
   {
      if( this.getPageContents().contains( word.subSequence( 0 , word.length() ) ) )
         System.out.println( word + " is founded in the index of " + this.getPageContents().indexOf( word ) );
      else
         System.out.println( word + "cannot be founded in the text!" );
   }
}