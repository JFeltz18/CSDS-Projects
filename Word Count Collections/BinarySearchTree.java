import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class BinarySearchTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BinarySearchTree<T extends Comparable<T>> implements WordCountCollection<T>
{
    // Returns the number of elements in this collection.
    // test
    BinaryNode<T> node = null;
    public BinarySearchTree(){
        node = null;
    }

    public int size()
    {
        return findSize(node);
    }

    private int findSize(BinaryNode<T> tree){
        if (tree == null)
        {
            return 0;
        }
        else
        {
            return 1+ findSize(tree.getLeft()) + findSize(tree.getRight());
        }
    }

    // Returns true if this collection is empty; otherwise, returns false.
    public boolean isEmpty(){
        return node == null;
    }

    // Adds element to this collection.
    // Precondition: element is not already in the collection
    public void add (T element){
        node = add(element, node);
    }

    private BinaryNode<T> add(T element, BinaryNode<T> tree){
        if (tree == null)
        {
            tree = new BinaryNode<T>(element);
        }
        else 
        {
            if (element.compareTo(tree.getInfo()) > 0)
            {
                tree.setRight(add(element, tree.getRight()));
            }
            else 
            {
                tree.setLeft(add(element, tree.getLeft()));
            }
        }
        return tree;
    }
    // Returns the element if this collection contains an element e such that
    // e.compareTo(element) == 0; otherwise, returns null.
    public T fetch(T element){
        return fetch(element, node);
    }

    private T fetch(T element, BinaryNode<T> tree){
        if (tree == null)
        {
            return null;
        }
        if (element.compareTo(tree.getInfo()) == 0)
        {
            return tree.getInfo();
        }
        else 
        {
            if (element.compareTo(tree.getInfo()) < 0)
            {
                return fetch(element, tree.getLeft());
            }
            else 
            {
                return fetch(element, tree.getRight());
            }            
        }
    }
    // Removes all elements in this collection
    public void clear(){
        node = null;
    }

    // generates a list of the elements in the collection
    // Postcondion: list is independant (deep copy) of original collection   
    public List<T> createList()
    {
        List<T> m = new ArrayList<T>();
        IDontCare1(node, m);
        return m;
    }

    private List<T> IDontCare1(BinaryNode<T> tree, List<T> plz){
        if (tree!= null){
            IDontCare1(tree.getLeft(), plz);
            plz.add(tree.getInfo());
            IDontCare1(tree.getRight(), plz);
        }
        return plz;
    }
}
