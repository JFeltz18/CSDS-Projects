import java.util.ArrayList;
/**
 * Write a description of class Heap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Heap<T extends Comparable<T>> implements PriorityQueue<T>
{
    ArrayList<T> heap = new ArrayList<T>();
    
    // returns the logical size of the priority queue
    public int size()    
    {
        return heap.size();
    }
    // tests if this priority queue is empty
    public boolean empty()
    {
        return size() == 0;
    }
    
    // adds an item to the priority queue
    public T add(T element)
    {
        heap.add(element);
        reheapUp(element);
        return element;
    }
    
    private void reheapUp(element)
    {
        
    }
        
    // looks at the object at the front of this priority queue
    // without removing it from the priority queue
    public T peek() throws PQUnderflowException
    {
    }
    
    // removes the object at the front of this priority queue 
    // and returns that object as the value of this function
    public T remove() throws PQUnderflowException
    {
    }
    
    // removes all of the elements from this priority queue
    public void clear()
    {
    }
}
