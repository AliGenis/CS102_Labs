import java.util.Iterator;
/**
 * Class to create and manipulate array of int
 * 
 * @author Ali Genis
 * @date 04.11.2020
 */
public class IntBag
{
   //Properties
   private int[] bag;
   
   //Consturactor
   public IntBag()
   {
      bag = new int[5];
      for(int i = 0; i < bag.length; i++)
         bag[i] = -1;
   }
   //Get method
   public int getValue( int index )
   {
      return bag[index];
   }
   /** Method to add new value to end of the array
     * 
     * @param new value
     */
   public void add( int newNumber )
   {
      if( bag[bag.length - 2] == -1 )
      {
         for(int i = 0; i < bag.length - 1; i++)
         {
            if( bag[i] == -1 )
            {
               bag[i] = newNumber;
               i = bag.length;
            }
         }
      }
      else
      {
         int[] newBag = new int[((bag.length - 1) * 2) + 1];
         System.arraycopy(bag, 0, newBag, 0, bag.length);
         for(int i = bag.length; i < newBag.length; i++)
         {
            newBag[i] = -1;
         }
         bag = new int[newBag.length];
         System.arraycopy(newBag, 0, bag, 0, newBag.length);
         add( newNumber );
      }
   }
   /** Method to add new value at desired location in arrays length
     * 
     * @param new value
     * @param desired location
     */
   public void add( int newNumber , int location ) 
   {
      if( bag.length - 2 < size() )
      {
         int[] newBag = new int[((bag.length - 1) * 2) + 1];
         System.arraycopy(bag, 0, newBag, 0, bag.length);
         for(int i = bag.length; i < newBag.length; i++)
         {
            newBag[i] = -1;
         }
         bag = new int[newBag.length];
         System.arraycopy(newBag, 0, bag, 0, newBag.length);
      }
      if( location > -1 && location < bag.length - 1 )
      {
         int temp = bag[location];
         bag[location] = newNumber;
         for(int i = location + 1; i < bag.length; i++)
         {
            int temp2 = bag[i];
            bag[i] = temp;
            temp = temp2;
         }
      }
      else
         System.out.println( "Invalid location!" );
   }
   /** Method to remove number in desired index
     * 
     * @param desired index
     */
   public void remove( int index )
   {
      int findLast = 0;
      while( bag[findLast] != -1 )
         findLast++;
      bag[index] = bag[findLast - 1];
      bag[findLast - 1] = -1;
   }
   /** Method to remove all int which has desired value
     * 
     * @param desired value
     */
   public void removeAll( int value )
   {
      for(int i = 0; i < size(); i++)
      {
         if( value == getValue( i ) )
         {
            remove( i );
            i--;
         }
      }
   }
   /** Method to check the IntBag has the value or not
     * 
     * @param desired value
     * @return status of containing desired value
     */
   public boolean contains( int value )
   {
      for(int i = 0; i < bag.length; i++)
      {
         if( bag[i] == value )
            return true;
      }
      return false;
   }
   /** Method to check size of the IntBag
     * 
     * @return size of the IntBag
     */
   public int size()
   {
      int findLast = 0;
      while( bag[findLast] != -1 )
         findLast++;
      return findLast;
   }
   public Iterator iterator()
   {
      IntBag newBag = new IntBag();
      Iterator iterBag;
      
      newBag.bag = bag;
      
      iterBag = new IntBagIterator( newBag );
      return iterBag;
   }
   /** Method to show IntBag properily
     * 
     * @return String representetion of IntBag
     */
   public String toString()
   {
      if(size() != 0)
      {
         String s = "{";
         for(int i = 0; i < bag.length && bag[i] != -1; i++)
            s += " " + bag[i] + " ,";
         s = s.substring( 0 , s.length() - 1);
         s += "}";
         return s;
      }
      return "Empty!";
   }
   class IntBagIterator implements Iterator
   {
      private IntBag aBag;
      private int index;
      
      public IntBagIterator( IntBag newBag )
      {
         this.aBag = newBag;
         this.index = 0;
      }
      public boolean hasNext()
      {
         if( index < aBag.size() )
            return true;
         return false;
      }
      public Object next()
      {
         Integer a;
         
         a = new Integer( aBag.getValue( index ) );
         index++;
         
         return a;
      }
   }
}