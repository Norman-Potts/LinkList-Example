/**
 * 
 *  LinkListExample
 * 
 * The goal of this program is to compare a simple array list, a simple linked list, and the java built-in array list. 
 * The program reads 2000 names into a sting array then uses that array to test the add and remove methods
 * of the lists. The simple array list and the simple linked list are created by Me, and the built-in array list is 
 * maintained by the Java Developers. The built in array list should be the fastest since it is optimized by the 
 * Java Developers. 
 * 
 * 
 */
package LinkList.Example;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author storm
 */
public class Main {

     
    public static void main(String[] args) {
        
        final int NUMBER_OF_NAMES = 2000; 
        final String filename = "resources/names.txt";
        final String[] names = new String[NUMBER_OF_NAMES];    
        
        
        //// Read in all of the names - There are 2000 different names
        try {
            Scanner fin = new Scanner(new File(filename));
            for (int i=0; i<NUMBER_OF_NAMES; i++)
            {    names[i] = fin.next();     }
            fin.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage());
            System.exit(-1);
        }
        
        
        
        
        System.out.printf("Comp10152 - Lab#4 - ArrayList vs LinkedList\n\n");
        Random random = new Random();
        SimpleArrayList al = new SimpleArrayList();
        SimpleLinkedList ll = new SimpleLinkedList();
        ArrayList<String> builtInArrayList = new ArrayList<String>();
        
        
        //// Begin timing the lists and print out the results. 
   
        
        // Time the SimpleArrayList add method.      
        long start = System.nanoTime();
        for (int i=0; i<NUMBER_OF_NAMES;i++)
        {   
            al.add(names[i]);    
        } 
        System.out.printf("The time required to add %d elements to an Array List = %d us\n", NUMBER_OF_NAMES, (System.nanoTime() - start) / 1000);
  
        
        
  
        // Time the SimpleArrayList remove method.                 
        start = System.nanoTime();
        for (int i=0; i<NUMBER_OF_NAMES/2;i++)
        {    
            al.remove(names[random.nextInt(names.length)]); // Removes half of the items in the list by selecting randomly from names   
        }      
        System.out.printf("The time required to remove %d elements from an Array List = %d us\n", NUMBER_OF_NAMES/2, (System.nanoTime() - start) / 1000);

        
        
        
        // Time the SimpleLinkedList add method.                  
        start = System.nanoTime();
        for (int i=0; i<NUMBER_OF_NAMES;i++)
        {
            ll.add(names[i]);  // MODIFY add method in LinkedList
        }    
        System.out.printf("The time required to add %d elements to a Linked List = %d us\n", NUMBER_OF_NAMES, (System.nanoTime() - start) / 1000);
    
        
        
    
        
        // Time the SimpleLinkedList remove method.
        start = System.nanoTime();
        for (int i=0; i<NUMBER_OF_NAMES/2;i++)
        {
            ll.remove(names[random.nextInt(names.length)]);  // Remove half of the items in the list by selecting randomly from names
        }
        System.out.printf("The time required to remove %d elements from a Linked List = %d us\n", NUMBER_OF_NAMES/2, (System.nanoTime() - start) / 1000);

        
        
        
        
        // Time the builtInArrayList add method. 
        start = System.nanoTime();
        for (int i=0; i<NUMBER_OF_NAMES;i++)
        {
            builtInArrayList.add(names[i]);    // MODIFY add method in ArrayList
            Collections.sort(builtInArrayList); // Note that a Sort is required after each insert  To acheive the alwasy sorted case 
        }   
        System.out.printf("The time required to add %d elements to an (built-in) Java Array List = %d us\n", NUMBER_OF_NAMES, (System.nanoTime() - start) / 1000);   
        
        
       
        
        // Time the builtInArrayList remove method.
        start = System.nanoTime();
        for (int i=0; i<NUMBER_OF_NAMES/2;i++)
        {
            builtInArrayList.remove(names[random.nextInt(names.length)]); // Remove half of the items in the list by selecting randomly from names
        }
        System.out.printf("The time required to remove %d elements from an (built-in) Java Array List = %d us\n", NUMBER_OF_NAMES/2, (System.nanoTime() - start) / 1000);
  
        
    }/// End of method main   
    
    
}/// End of public class Main