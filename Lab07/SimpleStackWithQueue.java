public class SimpleStackWithQueue
{
   private SimpleQueue q1;
   private SimpleQueue q2;
   
   public SimpleStackWithQueue()
   {
      q1 = new SimpleQueue();
      q2 = new SimpleQueue();
   }
   public void push( String data )
   {
      q2.enqueue( data );
      while( !q1.isEmpty() )
         q2.enqueue( q1.dequeue() );
      q1 = q2;
      q2 = new SimpleQueue();
   }

   public void pop()
   {
      q1.dequeue();
   }

   public String toString()
   {
      return q1.toString();
   }
}