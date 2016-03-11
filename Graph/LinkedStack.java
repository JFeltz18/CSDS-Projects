
/**
 * Write a description of class LinkStack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
@SuppressWarnings("unchecked")
public class LinkedStack<T> implements StackInterface<T>
{

    LLNode<T> meh;
    int size;
    public LinkedStack(){
        size = 0;
    }
    // returns the logical size of the stack
    public int size(){
        return size;
    }

    // tests if this stack is empty
    public boolean empty(){
        return meh == null;
    }

    // looks at the object at the top of this stack
    // without removing it from the stack
    public T peek() throws StackUnderflowException{
        if(size == 0)
            throw new StackUnderflowException();
        LLNode<T> newLog = meh;
        while(newLog.getLink() != null)
            newLog = newLog.getLink();
        return newLog.getInfo();
    }

    // removes the object at the top of this stack 
    // and returns that object as the value of this function
    public T pop() throws StackUnderflowException{
        if(size == 0)

            throw new StackUnderflowException();
        if(size == 1)
        {
            T holdMeh = meh.getInfo();
            meh = null;
            size--;
            return holdMeh;
        }
        LLNode<T> newLog = meh;
        while(newLog.getLink().getLink() != null)
            newLog = newLog.getLink();
        T holdMe = newLog.getLink().getInfo();
        newLog.setLink(null);
        size--;
        return holdMe;
    }

    // pushes an item onto the top of this stack
    public  T push(T item){
        if(size == 0)
        {
            meh = new LLNode<T>(item);
            size++;
            return item;
        }
        LLNode<T> newLog = meh;
        while(newLog.getLink() != null)
            newLog = newLog.getLink();
        newLog.setLink(new LLNode<T>(item));
        size++;
        return item;
    }
    
    // removes all of the elements from this stack
    public void clear(){
        meh = null;
        size = 0;
    }

    // returns the 1 based position where an object is on this stack
    // note: when the method ends, the stack is the same as it was at the start
    public int search(Object o){
        LinkedStack doesThisWork = new LinkedStack();
        int saveMeh= -1;
        int dontForgetMe = size;
        for(int i = 0; i < dontForgetMe; i ++){
            doesThisWork.push(pop());
        }
        for(int z = 0; z < dontForgetMe; z++){
            if(doesThisWork.peek().equals(o))
            saveMeh = z;
            push((T)doesThisWork.pop());
        }
        if(saveMeh == -1)
        return -1;
        return size - saveMeh;
    }

}
