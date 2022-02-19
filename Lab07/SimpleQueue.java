public class SimpleQueue
{
   private SimpleLinkedList list;
   
   public SimpleQueue()
   {
      list = new SimpleLinkedList();
   }
   
   public void enqueue( String data )
   {
      list.addToTail( data );
   }
   public String dequeue()
   {
      return list.removeFromHead();
   }
   public boolean isEmpty()
   {
      return list.isEmpty();
   }
   public String toString()
   {
      return list.toString();
   }
}