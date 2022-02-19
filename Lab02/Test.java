public class Test
{
   public static void main ( String[] args )
   {
      MySimpleURLReader urlReader;
      HTMLFilteredReader filteredReader;
      WordSearch searcher;
      
      //Part B Testing MySimpleURLReader
      urlReader = new MySimpleURLReader( "http://www.cs.bilkent.edu.tr/~ozturk/cs102/scrapethissite.html" );
      System.out.println( urlReader.getURL() );
      
      //Part C Testing CSS Counter
      System.out.println( urlReader.getNumberOfCSSLinks() );
      urlReader = new MySimpleURLReader( "http://www.cs.bilkent.edu.tr/~ozturk/cs102/housman.txt" );
      System.out.println( urlReader.getNumberOfCSSLinks() );
      
      //Part D Testing HTMLFilteredReader
      filteredReader = new HTMLFilteredReader( "http://www.cs.bilkent.edu.tr/~ozturk/cs102/scrapethissite.html" );
      System.out.println( filteredReader.getPageContents() );
      
      //Part E Testing WordSearch
      searcher = new WordSearch( "http://www.cs.bilkent.edu.tr/~ozturk/cs102/scrapethissite.html" );
      searcher.search( "Turkey" );
      searcher.search( "Ankara" );
   }
}