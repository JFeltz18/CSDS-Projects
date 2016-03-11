import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class LinkedList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LinkedList<T extends Comparable<T>> implements WordCountCollection<T>
{
    LLNode<T> node = null;
    int size = 0;

    // Returns the number of elements in this collection.
    public int size()
    {
        return size;
    }

    // Returns true if this collection is empty; otherwise, returns false.
    public boolean isEmpty()
    {
        return size == 0;
    }

    // Adds element to this collection.
    // Precondition: element is not already in the collection
    public void add(T element)
    {
        if (node == null)
        {
            node = new LLNode<T>(element);
            size++;
        }
        else
        {
            LLNode<T> temp = node;
            while (temp.getLink() != null)
            {
                temp = temp.getLink();
            }
            temp.setLink(new LLNode<T>(element));
            size++;
        }
    }

    // Returns the element if this collection contains an element e such that
    // e.compareTo(element) == 0; otherwise, returns null.
    public T fetch(T element)
    {
        if (size == 0)
        {
            return null;
        }
        else
        {
            LLNode<T> temp = node;
            while (temp.getLink() != null)
            {
                if (element.compareTo(temp.getInfo()) == 0)
                {
                    return temp.getInfo();
                }
                temp = temp.getLink();
            }
            if (temp.getInfo().compareTo(element) == 0)
            {
                return temp.getInfo();
            }
        }
        return null;
    }

    // Removes all elements in this collection
    public void clear()
    {
        node = null;
        size = 0;
    }

    // generates a list of the elements in the collection
    // Postcondion: list is independant (deep copy) of original collection
    public List<T> createList()
    {
        List<T> list = new ArrayList<T>();
        LLNode<T> temp = node;
        while (temp.getLink() != null)
        {
            list.add(temp.getInfo());
            temp = temp.getLink();
        }
        list.add(temp.getInfo());
        return list;
    }
}
