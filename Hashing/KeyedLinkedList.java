
/**
 * This KeyedLinkedList object represents a Keyed List ADT implemented as
 * a LinkedList.
 * 
 * @author 
 * @version 
 */
public class KeyedLinkedList<K,V> implements KeyedLinkedListInterface<K,V>
{
    private KeyNode first;
    private int size;

    // a private inner class that represents a doubly 
    // linked-list node that contains both a key and a value
    private class KeyNode
    {
        K key;
        V value;
        KeyNode previous;
        KeyNode next;

        public KeyNode(K key, V value, KeyNode previous, KeyNode next)
        {
            this.key = key;
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    // returns the logical size of this list
    public int size()
    {
        return -1;      // complete this method
    }

    // if key found, update value and return false (nothing added), 
    // otherwise grow list and return true
    public boolean put(K key, V value)
    {
        return false;    // complete this method
    }

    // search for key, return associated value
    // if key not found, return null
    public V get(K key)
    {
        return null;    // complete this method
    }

    // removes the element at the specified key location in this list
    // return true if remove was successful, false if key not found
    public boolean remove(K key)
    {
        return false;   // complete this method
    }
}
