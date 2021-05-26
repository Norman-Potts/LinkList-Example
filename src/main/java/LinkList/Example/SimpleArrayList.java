/**
 * 
 *
 */
package LinkList.Example;

import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author Norman
 */
public class SimpleArrayList {
    
   // Constants for the default capacity and the resizing factor.
   private final int DEFAULT_CAPACITY = 10;
   private final int RESIZE_FACTOR = 2;   
   
   private String[] list;  
   private int elements;   // Number of elements stored in list
   
   
   /** Constructor SimpleArrayList 
    *   Creates an empty list of the default capacity.
    * 
    */ 
   public SimpleArrayList()
   {
      list = new String[DEFAULT_CAPACITY];
      elements = 0;
   }

   
   

   /** Method add
    *   Determines placement of string in an alphabetically sorted list.
    *   Then runs the private add method which adds the element to that spot.
    *   
    * @param str 
    */
   public void add(String str)
   {
       int place = 0;     
       if ( list[0] != null  )
       {      
            int index = 0; // Count variable
            int spot = 0; //Chooosen spot
            boolean found = false; //found spot variable control variable
            
            // while loop finds choosen spot
            while(found == false && index < list.length ) 
            {              
                // if index is not null than compare elements. 
                if (list[index] != null) 
                {                 
                    if (str.compareTo(list[index]) < 0)
                    {
                        spot = index;
                        found = true; 
                    }
                }
                else
                {
                    spot=index;
                    found=true;
                }
                index++; // index increase
            }
            place = spot;/* put spot in its place*/    
       }
       else
       {
           place = 0; // The first element is empty the element must go into the first place.
       }
      add(place,str);  // Add str at index place
      
   }/// End of method add
   
   
   

   /** Method add
    *   Add a string at a specific index.
    * 
    * @param index The added string's position.
    * @param str The string to add.
    * @exception IndexOutOtBoundsException When index is out of bounds.
   */   
   private void add(int index, String str)
   {
        // First make sure the index is valid.
        if (index > elements || index < 0)
           throw new IndexOutOfBoundsException();

        // If the list is full, resize it.
        if (elements == list.length)
           resize();

        // Shift the elements starting at index
        // to the right one position.
        for (int index2 = elements; index2 > index; index2--)
           list[index2] = list[index2 - 1];

        // Add the new element at index.
        list[index] = str;

        // Adjust the number of elements.
        elements++;
      
   }/// End of method add
   
   
   
   
   /** Method contains 
    *   Search the list for a specified string.
    * 
    * @param str The string to search for.
    * @return true if the list contains the string. 
    */
   public int contains(String str)
   {
        int index = 0;          // Index counter
        boolean found = false;  // Search flag
        int place= -1;
        // Step through the list. When the string
        // is found, set found to true and stop.
        while (found != true && index < elements)
        {
            if (str.equals(list[index]))
            {
                place = index;
                found = true;    
            }
            index++;                
        }     
        // Return the status of the search.
        return place;
   }/// End of method contains
   
   
   
   
   
   /** Method get
    *       Get an element at a specific position.
    * 
    * @param index The specified index.
    * @return The element at index.
    * @exception IndexOutOtBoundsException When index is out of bounds.
    */
   public String get(int index)
   {
      if (index >= elements || index < 0)
         throw new IndexOutOfBoundsException();
      return list[index];
   }/// End of method get
   
   
   
  
   /** Method isEmpty 
    *   Determines whether the list is empty.
    *   @return true if the list is empty; false otherwise.
    */
   public boolean isEmpty()
   {
      return (elements == 0);
   }/// End of method isEmpty
   
   
   
   
   /** Method remove
    *   Remove a specific string from the list.
    * 
    *  @param str The string to remove.
    *  @return true if the string was found; false otherwise.
    * 
    *  MODIFY : Complete the remove - find the string and then adust contents of ArrayList
    */
   public boolean remove(String str) 
   {
        // Uint place = contains(str);se contains method to find if an item is in the list        
        // Element Placement of str in this SimpleArrayList as an int
        int place = this.contains(str);      
        // if (str is in list )
        if (place != -1)
        {  
            if( place >= elements || place <0)
            {
                System.out.println("Index out of boundsException");
                throw new IndexOutOfBoundsException();
            }   
            // Save the string, but remove it from the list.
            while(place < elements-1)
            {    
                list[place] = list[place+1];
                place++;
            }          
            // Shift all subsequent elements toward.
            // The front of the list.          

            elements--;// Adjust the number of elements
            // Return the string that was removed/
            return true;       
        }
        else
        {
            return false;         
        }
      
    }/// End of method remove       

   
   
   
   /** Method size
    *   Get the number of elements in the list.
    *
    * @return The number of elements in the list.
    */
   public int size() { return elements; }

   
   
   /** Method resize
    *   Resizes the list to twice its current length. 
    */
   private void resize()
   {
        // Calculate the new length, which is the current
        // length multiplied by the resizing factor.
        int newLength = list.length * RESIZE_FACTOR;

        // Create a new list.
        String[] tempList = new String[newLength];

        // Copy the existing elements to the new list.
        for (int index = 0; index < elements; index++)
           tempList[index] = list[index];

        // Replace the existing list with the new one.
        list = tempList;
   }// End of method resize
  
   
   
   
    /** Method toString 
     *   Convert the list to a String
     * 
     * @return A String with the same elements as the list.
     */
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();
        // Use p to walk down the linked list
        // Store the elements in the array.
        for (int index = 0; index < elements; index++)
            strBuilder.append("[" + list[index] + "]");
      
        // Return the String.
        return strBuilder.toString();
    }/// End of method toString
   
   
}/// End of class SimpleArrayList
