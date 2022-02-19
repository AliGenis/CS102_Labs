import java.util.Scanner;
import java.io.*;
/*
 * Class to learn recursion
 * 
 * @author Ali Genis
 * @date 9.12.2020
 */
public class Lab06
{
   public static void main (String[] args)
   {
      Scanner scan = new Scanner(System.in);
      int menu;
      do
      {
         //Menu
         System.out.println( "1-String length" );
         System.out.println( "2-Non-vowel" );
         System.out.println( "3-Binary" );
         System.out.println( "4-Find files" );
         System.out.println( "0-Exit" );
         menu = scan.nextInt();
         scan.nextLine();
         
         //Length
         if(menu == 1)
         {
            System.out.println( "Enter the string to find its length: " );
            System.out.println( "" + stringLength( scan.nextLine() ) );
         }
         //Non-vowel
         if(menu == 2)
         {
            System.out.println( "Enter for counting non-vowels: " );
            System.out.println( "" + nonVowel( scan.nextLine() ) );
         }
         //Binary
         if(menu == 3)
         {
            System.out.println( "Enter n to compute binary: " );
            int n = scan.nextInt();
            findBinary( n , new int[n] , 0 );
         }
         //File counter
         if(menu == 4)
         {
            System.out.println( "Enter directory: " );
            System.out.println( "" + fileCounter( scan.nextLine() ) );
         }
      }while( menu != 0 );
   }
   
   /*Method to find length of string
    * 
    * @param string to find its length
    * @return length of string with using recursion
    */
   public static int stringLength( String s )
   {
      //Base case
      if( s.equals( "" ) )
         return 0;
      //General case
      else
         return 1 + stringLength( s.substring(1) );
   }
   /*Method to find non-vowels
    * 
    * @param string to find its non-vowel letters
    * @return non-vowel letters of string with using recursion
    */
   public static int nonVowel( String string )
   {
      String s = string.toUpperCase();
      //Base case
      if( s.equals( "" ) )
         return 0;
      //Non-vowel letters
      else if( s.charAt(0) > 65 && s.charAt(0) < 69 )
         return 1 + nonVowel( s.substring(1) );
      else if( s.charAt(0) > 69 && s.charAt(0) < 73 )
         return 1 + nonVowel( s.substring(1) );
      else if( s.charAt(0) > 73 && s.charAt(0) < 79 )
         return 1 + nonVowel( s.substring(1) );
      else if( s.charAt(0) > 79 && s.charAt(0) < 85 )
         return 1 + nonVowel( s.substring(1) );
      else if( s.charAt(0) > 85 && s.charAt(0) < 91 )
         return 1 + nonVowel( s.substring(1) );
      //Anything else
      else
         return 0 + nonVowel( s.substring(1) );
   }
   /**Method for findind binary numbers(not multiple 1's consequently)
     * 
     * @param length of binary
     * @param numbers of binary number
     * @param helper i for starting 0 and increases until length of array
     */
   public static void findBinary( int a, int[] array, int i ){
      if (i == a)
      { 
         printTheArray(array, a);
         if( a <= 1 )
            System.out.println( "1" );
         else if( array[array.length-2] == 0 )
         {
            array[array.length-1]++;
            printTheArray(array, a);
         }
         return; 
      } 
      array[i] = 0; 
      findBinary(a, array, i + 1); 
      array[i] = 1;
      if( (i + 1) < array.length )
      {
         array[ i + 1 ] = 0;
         findBinary(a, array, i + 2); 
      }
   }
   /**Helper method for printing arrays in findBinary method
     * 
     * @param binary array
     * @param length of binary
     */
   public static void printTheArray(int array[], int n) 
   { 
      for (int i = 0; i < n; i++)
         System.out.print( array[i] ); 
      System.out.println();
   }
   /*Method for counting files in a directory
    * 
    * @param directory
    * @return number of files
    */
   public static int fileCounter( String s )
   {
      File file = new File( s );
      File[] list = file.listFiles();
      int counter = 0;
      
      for( int i = 0; i < list.length; i++ )
      {
         if( list[i].isDirectory() )
            counter += fileCounter( list[i].getPath() );
         if( list[i].isFile() )
            counter++;
      }
      return counter;
   }
   
}