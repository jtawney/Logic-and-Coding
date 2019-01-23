
/**
 * Stack with an array implementation
 * A Stack is a collect of data that has a "top" element.
 * Only the top element can be accessed.
 * When an element is added to the stack ("pushed"), the
 * new element becomes the top element.
 * 
 * This implmementaiton uses an array to store the data.
 * A stack has no limit to the number of elements that can
 * be added, but an array does, so you will have to think
 * about how to deal with the structure when the underlying
 * array is full, but a push() is called.
 *
 * @author (Jake Tawney)
 * @version (January 7, 2019)
 */
public class Stack{
    
    private String[] data;
    //you might need some extra private instance variables
    
    public Stack(){
        //You must initialize the array to length 100
    }
    
    /**
     * This method pushes the String x onto the stack
     * After the method call, the "top" element is
     * the String x, and the size of the stack is one
     * more than the size before the push method was called.
     */ 
    public void push(String x){
        //When resizing, you must do so by adding 100 to the length of the array
    }
    
    /**
     * This method removes the top element from the stack and
     * returns it. After the method call, the size of the stack
     * is one less than it was prior to the method call.
     * 
     * In the even that the stack is empty when pop() is called,
     * System.out.prinln("Error - Empty Stack"), and return
     * the null String.
     */
    public String pop(){
        
    }
    
    /**
     * This method return the top element from the stack,
     * but does not remove it.
     * After the method call, the size of the stack
     * is the same as it was prior to the method call.
     * 
     * In the even that the stack is empty when peek() is called,
     * System.out.prinln("Error - Empty Stack"), and return
     * the null String.
     */
    public String peek(){
        
    }
    
    /**
     * This method returns the number of elements in the stack.
     * Note that this is different than the current capacity of
     * the underyling array.
     */
    public int size(){
        
    }
}
