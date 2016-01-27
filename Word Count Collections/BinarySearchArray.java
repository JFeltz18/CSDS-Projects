import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class BinarySearchArray here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BinarySearchArray<T extends Comparable<T>> implements WordCountCollection<T>
{
    ArrayList<T> node = new ArrayList<T>();
    // Returns the number of elements in this collection.
    public int size(){
        return node.size();
    }

    // Returns true if this collection is empty; otherwise, returns false.
    public boolean isEmpty(){
        return node.size() == 0;
    }

    // Adds element to this collection.
    // Precondition: element is not already in the collection
    public void add(T element){
        int lower = 0;
        int mid = 0; 
        int upper = node.size() -1;
        while(lower <= upper)
        {
            mid = (lower+ upper) /2;
            if(node.get(mid).compareTo(element) < 0)
            {
                lower = mid +1;
            }
            else 
            {
                if(node.get(mid).compareTo(element) > 0)
                {
                    upper = mid -1;
                }
                else
                {
                    break;
                }
            }
        }
        if(node.size() > 0 && node.get(mid).compareTo(element) < 0)
        {
            mid++;
        }
        node.add(mid, element);
    }

    // Returns the element if this collection contains an element e such that
    // e.compareTo(element) == 0; otherwise, returns null.
    public T fetch(T element){
        int lower = 0;
        int upper = node.size() - 1;
        while(lower <= upper){
            int mid = (lower + upper) /2;
            if(node.get(mid).compareTo(element) == 0)
            {
                return node.get(mid);
            }
            else 
            {
                if(node.get(mid).compareTo(element) < 0)
                {
                    lower = mid +1;
                }
                else
                {
                    if(node.get(mid).compareTo(element) > 0)
                    {
                        upper = mid -1;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        return null;
    }

    // Removes all elements in this collection
    public void clear(){
        node = new ArrayList<T>();
    }

    // generates a list of the elements in the collection
    // Postcondion: list is independant (deep copy) of original collection
    public List<T> createList(){
        ArrayList<T> temp = new ArrayList<T>();        
        for(int i = 0; i < node.size(); i ++){
            temp.add(node.get(i));
        }
        return temp;
    }
}
