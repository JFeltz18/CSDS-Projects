import java.util.ArrayList;
/**
 * Write a description of class Heap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Heap<T extends Comparable<T>> implements PriorityQueue<T>
{
    ArrayList<T> heap;

    public Heap()
    {
        heap = new ArrayList<T>();
    }

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

    private void reheapUp(T element)
    {
        int hole = size() - 1;
        if (size() == 0)
        {
            return;
        }
        while (!heap.get(hole).equals(heap.get(0)) && element.compareTo(heap.get((hole - 1) / 2)) > 0)
        {
            heap.set(hole, heap.get((hole - 1) / 2));
            hole = (hole - 1) / 2;
        }
        heap.set(hole, element);
    }

    // looks at the object at the front of this priority queue
    // without removing it from the priority queue
    public T peek() throws PQUnderflowException
    {
        if (empty())
        {
            return null;
        }
        else
        {
            return heap.get(0);
        }
    }

    // removes the object at the front of this priority queue 
    // and returns that object as the value of this function
    public T remove() throws PQUnderflowException
    {
        if (empty())
        {
            throw new PQUnderflowException();
        }
        T temp = heap.get(0);
        T temp2 = heap.remove(size() - 1);
        if (!empty())
        {
            reheapDown(temp2);
        }
        return temp;
    }

    private void reheapDown(T element)
    {
        int hole = 0;
        int newHole = newHole(hole, element);        
        while (hole != newHole)
        {
            heap.set(hole, heap.get(newHole));
            hole = newHole;
            newHole = newHole(hole, element);
        }
        heap.set(hole, element);
    }

    // removes all of the elements from this priority queue
    public void clear()
    {
        heap = new ArrayList<T>();
    }

    private int newHole(int hole, T element)
    {
        if (!(((hole * 2) + 1) >= size()) && !(((hole * 2) + 2) >= size()))
        {
            T childLeft = heap.get((hole * 2) + 1);
            T childRight = heap.get((hole * 2) + 2);
            if (element.compareTo(childLeft) < 0 || element.compareTo(childRight) < 0)
            {
                if (childLeft.compareTo(childRight) > 0)
                {
                    return (hole * 2) + 1;
                }
                else
                {
                    return (hole * 2) + 2;
                }
            }
            else
            {
                return hole;
            }
        }
        else
        {
            return hole;
        }
    }
}
