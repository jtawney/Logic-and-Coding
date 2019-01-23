
/**
 * Stack with a Linked Node implementation
 *
 * @author (Jake Tawney)
 * @version (January 7, 2019)
 */
public class Stack<E>{
    
    private Node<E> top;
    private int size;
    
    public Stack(){
        top = null;
        size = 0;
    }
    
    public void push(E x){
        Node<E> newTop = new Node<E>(x); // construct the new top Node
        newTop.setNext(top); //link the new top Node to the Stack
        top = newTop; //reassign the top reference
        //if the last two lines are switched, we orphan the entire Stack
        size++; //adjust size
        //Note that in the case of an empty Stack (pushing the first)
        //element, the code still works.
    }
    
    public E pop(){
        E retObj = top.getData(); //save object to return
        top = top.getNext(); //trickiest part, assign top to the next
        //this is how we delete – we let the old top Node get orphaned
        //(while saving the data to return)
        size--; //adjust size
        return retObj;
        //Note that in the case of an empty Stack, the first line
        //throws a null pointer exception, which is what we want.
        //Note also in the case of a one-element Stack, top is set
        //to null, which is what we want.
    }
    
    public E peek(){
        return top.getData();
    }
    
    public int size(){
        return size;
    }
}
