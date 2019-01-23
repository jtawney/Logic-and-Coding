
/**
 * Basic Node class with generics
 *
 * @author (Jake Tawney)
 * @version (January 7, 2019)
 */
public class Node<E>{
    
    private E data;
    private Node<E> next;

    public Node(){
        this(null, null);
    }
    
    public Node(E d){
        this(d, null);
    }
    
    public Node(E d, Node<E> n){
        data = d;
        next = n;
    }

    public void setData(E d){
        data = d;
    }
    
    public void setNext(Node<E> n){
        next = n;
    }
    
    public E getData(){
        return data;
    }
    
    public Node<E> getNext(){
        return next;
    }
     
}
