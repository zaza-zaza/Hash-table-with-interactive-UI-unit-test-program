import java.util.*;
/**
 * @author Zachary Garson
 * zgarson@u.rochester.edu
 * 10/22/23
 * Lab 5
 */
public class HashTableUnitTesting {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean terminate = true;
	// creating menu for UI
	System.out.println("The typing parameters for the unit test take integers ");
    	System.out.println("as keys and strings as values");
    	System.out.println("Here is a list of commands you to choose from.");
    	System.out.println("Be sure to replace 'key' and 'value' with desired input.");
    	System.out.println("put key value");
    	System.out.println("get key");
    	System.out.println("delete key");
    	System.out.println("isEmpty");
    	System.out.println("size");
    	System.out.println("contains key");
    	System.out.println("sample input: put 1 apple");
    	System.out.println("Type 'quit' to exit.");

    	HashTable<Integer, String> ht = new HashTable<>();
        while (terminate) {
                           	
            String[] command = s.nextLine().split(" "); 
            switch (command[0].toLowerCase()) {

                case "put":
                	// checks if the value entered is parsable to an integer
                	try {
                		ht.put(Integer.parseInt(command[1]), command[2]);
                		System.out.println("assigning " + command[1] + " to " + command[2]);
                	} catch (NumberFormatException e) {
                		System.out.println("The key you entered is not the of correct type.");
                	}
                	
                    break;
                    
                case "get":
                	// catches input error
                	try {
                		System.out.println("getting " + ht.get(Integer.parseInt(command[1])));
                	} catch (NumberFormatException e) {
                		System.out.println("Incorrect type.");
                	}
                	
                    break;
                    
                case "delete":
                	
                	if(ht.isEmpty()) {
                    	try {
                    		ht.delete(Integer.parseInt(command[1]));
                        	System.out.println("deleted value associated with key " + command[1]);
                    	} catch (IllegalArgumentException e) {
                    		System.out.println("Incorrect type.");
                    	}
                	}
                            
                    break;
                case "size":
                	System.out.println("The current size of the hash table is " + ht.size());
                	break;
                case "isempty":
                	
                	if(ht.isEmpty()) {
                		System.out.println("The current hash table is empty.");
                	} else {
                		System.out.println("The current hash table is not empty.");
                	}
                	break;
                case "contains":
                	try {
                    	if(ht.contains(Integer.parseInt(command[1]))) {
                    		System.out.println("index " + command[1] + 
                    				" contains " + ht.get(Integer.parseInt(command[1])));
                    	} else {
                    		System.out.println("index " + command[1] + " is empty");
                    	}
                	} catch(NumberFormatException e) {
                		System.out.println("Incorrect type.");
                	}
                	break;
                case "quit":
                    terminate = false; //this will terminate inner menu
                    System.out.println("quiting");
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
        s.close();
    }	
}
