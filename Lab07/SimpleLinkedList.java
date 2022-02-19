public class SimpleLinkedList
{
   private Node head;
   private Node tail;
   public SimpleLinkedList()
   {
      head = null;
   }
   public void addToTail(String data)
   {
      if( head == null )
      {
         head = new Node(data);
         tail = head;
      }
      else
      {
         Node node = new Node(data);
         tail.setNext( node );
         tail = node;
      }
   }
   public String removeFromHead()
   {
      if( head == null )
         return "";
      
      String removedValue = head.getData();
      head = head.getNext();
      
      return removedValue;
   }
   public boolean isEmpty()
   {
      if( head == null )
         return true;
      return false;
   }
   public Node get(String data)
   {
      Node temp = head;
      while( temp != null && !temp.getData().equals(data) )
         temp = temp.getNext();
      return temp;
   }
   public String toString()
   {
      if( !isEmpty() )
      {
         Node temp = head;
         String string = "";
         while( temp == null || temp.getNext() != null )
         {
            string += temp.getData() + "\n";
            temp = temp.getNext();
         }
         string += temp.getData() + "\n";
         return string;
      }
      return "Empty!";
   }
}