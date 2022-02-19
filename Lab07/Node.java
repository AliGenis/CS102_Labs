public class Node
{
   private String data;
   private Node next;
   
   public Node(String data)
   {
      this.data = data;
      this.next = null;
   }
   public String getData()
   {
      return data;
   }
   public Node getNext()
   {
      return next;
   }
   public void setNext(Node node)
   {
      next = node;
   }
   public String toString()
   {
      return "Node value is " + data +", next is " + next;
   }
      
}