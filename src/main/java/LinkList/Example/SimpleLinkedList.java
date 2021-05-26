/**
 * 
 * 
 */
package LinkList.Example;

/**
 *
 * @author Norman
 */
public class SimpleLinkedList
{

    /** Class Node
     * 
     *  Modified as specified in lab instructions and reorganized by Norman 
     *  Potts.
     * The Node class stores a list element and a reference to the next node.
     */
    private class Node
    {
        String value;
        Node next;

        /** Constructor Node
         *
         * @param val The element to store in the node.
         * @param n The reference to the successor node.
         */
        Node(String val, Node n)
        {
            value = val;
            next = n;
        }

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         */
        Node(String val)
        {
          // Call the other (sister) constructor.
          this(val, null);
        }
    }/// End of class node
    
    
    
    
    private Node first;  // list head
    private Node last; //last element in list
    
    /** Constructor SimpleLinkedList
     *      
     */
    public SimpleLinkedList()
    {
      first = null;
      last = null;
    }/// End of constructor SimpleLinkedList

    
    
    
    /** Method isEmpty
     * The isEmpty method checks to see if the list is empty.
     *
     * @return true if list is empty, false otherwise.
     */
    public boolean isEmpty()
    {
      return first == null;
    }/// End of method isEmpty

    
    
    
    /** Method size
     * The size method returns the length of the list.
     *
     * @return The number of elements in the list.
     */
    public int size()
    {
      int count = 0;
      Node p = first;
      while (p != null) 
      {
        // There is an element at p
        count++;
        p = p.next;
      }
      return count;
    }/// End of method size
    
    
    

    /** Method add
     * The add method adds currently adds an item to the end of the list
     * 
     * MODIFY : Modify the code to place the item into the correct position based on alphabetical order
     * 
     * @param element The element to add to the list.
     */
    public void add(String element)
    {
        Node newNode = new Node(element); //*** Create a new node for element

        if (first == null)
        {
            first = newNode;
        }
        else
        {
            Node current = first;
            Node prev = null;
            while ( current != null && current.value.compareTo(element) < 0)
            {                                                                 
                prev = current;
                current = current.next;
            }    
            
            if (current == null )        //*** New last element
            {
              prev.next = newNode;
            }
            else if (prev == null)    //** new first element
            {
                newNode.next = first;
                first = newNode;
            }
            else 
            {
              prev.next = newNode;
              newNode.next = current;  
            }
        }
    }/// End of method add
    
    
    

    /** Method toString
     * The toString method computes the string representation of the list.
     *
     * @return The string form of the list.
     */
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();
        // Use p to walk down the linked list
        Node p = first;
        while (p != null)
        {
            strBuilder.append("[" + p.value + "]");
            p = p.next;
        }
        return strBuilder.toString();      
    }/// End of method toString

    
    
    
    /** Method remove
     * The remove method removes an element.
     * 
     * MODIFY : You need to remove and shift elements here 
     * 
     * @param element The element to remove.
     * @return true if the remove succeeded, false otherwise.
     */
    public boolean remove(String element)
    {
        // See Lecture Notes to complete 
        if(isEmpty()) 
        {   return false; }

        if (element.equals(first.value))
        {
            //Removal of first item in the list
            first = first.next;
            if(first == null)
            {
                last = null;
            }
            return true;
        }

        // Find the predecessor of the element to remove 
        Node pred = first;
        while(pred.next != null && !pred.next.value.equals(element))
        {
           pred = pred.next;
        }

        // pred.next == null OR pred.next.value is element
        if (pred.next == null)
        {
            return false;
        }

        //pred.next.value is element
        pred.next = pred.next.next;

        // Check if pred is now last
        if(pred.next == null)
        {
            last = pred;
        }
        return true;
        
    }/// End of method remove
    
}//End of SimpleLinkedList