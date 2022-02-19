import java.util.Scanner;
public class ShapeTester
{
   public static void main ( String[] args )
   {
      Scanner scan = new Scanner(System.in);
      ShapeContainer shapes = new ShapeContainer();
      Shape newShape;
      int menu;
      int subMenu;
      
      //Menu
      do   
      {
         System.out.println( "1-Create an empty set of shapes" );
         System.out.println( "2-Add shape" );
         System.out.println( "3-Total area" );
         System.out.println( "4-Total perimeter" );
         System.out.println( "5-Print list" );
         System.out.println( "6-Search coordinates" );
         System.out.println( "7-Remove all selected" );
         System.out.println( "Use 0 to exit" );
         System.out.print( "Select an option: " );
         menu = scan.nextInt();
         
         if( menu == 1 )
            shapes = new ShapeContainer();
         if( menu == 2 )
         {
            System.out.println( "1-Circle" );
            System.out.println( "2-Rectangle" );
            System.out.println( "3-Square" );
            System.out.println( "4-Triangle" );
            System.out.println( "Any other number for main menu" );
            System.out.print( "Select a shape:" );
            subMenu = scan.nextInt();
            
            if( subMenu == 1 )
            {
               System.out.print( "Enter radius than x and y coordinates: " );
               shapes.add( new Circle( scan.nextInt() , scan.nextInt() , scan.nextInt() ) );
            }
            if( subMenu == 2 )
            {
               System.out.print( "Enter width and height than x and y coordinates: " );
               shapes.add( new Rectangle( scan.nextInt() , scan.nextInt() , scan.nextInt() , scan.nextInt() ) );
            }
            if( subMenu == 3 )
            {
               System.out.print( "Enter line length than x and y coordinates: " );
               shapes.add( new Square( scan.nextInt() , scan.nextInt() , scan.nextInt()) );
            }
            if( subMenu == 4 )
            {
               System.out.print( "Enter lines a, b, c than x and y coordinates: " );
               shapes.add( new Triangle( scan.nextInt() , scan.nextInt() , scan.nextInt() , scan.nextInt() , scan.nextInt()) );
            }
         }
         if( menu == 3 )
            System.out.println( "Total area is " + shapes.getArea() );
         if( menu == 4 )
            System.out.println( "Total perimeter is " + shapes.getPerimeter() );
         if( menu == 5 )
            System.out.println( shapes.toString() );
         if( menu == 6 )
         {
            System.out.print( "Enter the coordinates to select shape: " );
            System.out.println( shapes.select( scan.nextInt() , scan.nextInt() ) );
         }
         if( menu == 7 )
            shapes.removeSelected();
         
      }while( menu != 0 );
   }
}