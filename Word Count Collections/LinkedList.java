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
    // Returns the number of elements in this collection.
    LLNode<T> meh = null;
    int size = 0;
    public int size(){
        return size;
    }

    // Returns true if this collection is empty; otherwise, returns false.
    public boolean isEmpty(){
        return meh == null;
    }

    // Adds element to this collection.
    // Precondition: element is not already in the collection
    public void add (T element){
        if(meh == null)
            meh = new LLNode<T>(element);
        else{
            LLNode<T> mehh = meh;
            while(mehh.getLink() != null){
                mehh = mehh.getLink();
            }
            mehh.setLink(new LLNode<T>(element));
        }
        size++;
    }

    // Returns the element if this collection contains an element e such that
    // e.compareTo(element) == 0; otherwise, returns null.
    public T fetch(T element){
        LLNode<T> mehh = meh;
        if(meh == null)
            return null;
        while(mehh.getLink() != null){
            if(mehh.getInfo().compareTo(element) == 0)
                return mehh.getInfo();
            mehh = mehh.getLink();
        }
        return null;
    }

    // Removes all elements in this collection
    public void clear(){
        meh = null;
        size = 0;
    }

    // generates a list of the elements in the collection
    // Postcondion: list is independant (deep copy) of original collection
    public List<T> createList(){
        LLNode<T> hem = meh;
        ArrayList<T> plz = new ArrayList<T>(null);
        while(hem.getLink() != null){
            plz.add(hem.getInfo());
            hem = hem.getLink();
        }
        return plz;
    }
}
