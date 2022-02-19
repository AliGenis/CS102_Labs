import java.util.Scanner;
/** Class to use IntBag
 * 
 * @author Ali Genis
 * @date 07.10.2020
 */
public class RemoveAllTest
{
   public static void main (String[] args)
   {
      Scanner scan = new Scanner(System.in);
      //Variables
      int menu;
      int value;
      int location;
      IntBag collection = new IntBag();;
      do
      {
         //Menu
         System.out.println("1.Create a new empty collection(any previous values are lost!)");
         System.out.println("2.Read a set of positive values into the collection (use 0 to indicate all the values have been entered.)");
         System.out.println("3.Print the collection of values.");
         System.out.println("4.Add a value to the collection of values at a specified location");
         System.out.println("5.Remove the value at a specified location from the collection of values");
         System.out.println("6.Remove all instances of a value within the collection.");
         System.out.println("7.Quit the program.");
         System.out.print("Enter selection: ");
         menu = scan.nextInt();
         
         //Create
         if( menu == 1 )
         {
            collection = new IntBag();
         }
         //Add values
         else if( menu == 2 )
         {
            System.out.print("Enter values: ");
            value = scan.nextInt();
            while( value != 0 )
            {
               collection.add(value);
               value = scan.nextInt();
            }
         }
         else if( menu == 3 )
         {
            System.out.println( collection.toString() );
         }
         //Add location
         else if( menu == 4 )
         {
            System.out.print( "Enter value and location: ");
            value = scan.nextInt();
            location = scan.nextInt();
            collection.add( value , location );
         }
         //Remove (location)
         else if( menu == 5 )
         {
            System.out.print( "Enter location: ");
            location = scan.nextInt();
            collection.remove( location );
         }
         //Remove (value)
         else if( menu == 6 )
         {
            System.out.print( "Enter value: ");
            value = scan.nextInt();
            collection.removeAll( value );
         }
         else if( menu == 7 )
         {
            System.out.println("Goodbye!");
         }
      }while(menu != 7);
   }
}