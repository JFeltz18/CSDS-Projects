
/**
 * Write a description of class LinkedQueue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LinkedQueue<T> implements QueueInterface<T>
{
    LLNode<T> meh;
    int size;
    public LinkedQueue(){
        meh = null;
        size = 0;    
    }

    public LinkedQueue(T plz){
        meh = new LLNode<T>(plz);
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        return meh == null;
    }

    public T add(T item){
        if(meh == null){
            meh = new LLNode<T>(item);
        }
        else{
            LLNode<T> mehh = meh;
            for(int i = 0; i < size -1; i++){
                mehh = mehh.getLink();
            }
            mehh.setLink(new LLNode<T>(item));
        }
        size++;
        return item;
    }

    public T peek() throws QueueUnderflowException{
        if(meh == null)
            throw new QueueUnderflowException("Nope");
        return meh.getInfo();
    }

    public T remove() throws QueueUnderflowException{
        if(meh == null)
            throw new QueueUnderflowException("Nope");
        LLNode<T> hem = meh;
        meh = meh.getLink();
        size--;
        return hem.getInfo();
    }

    public void clear(){
        meh = null;
        size = 0;
    }
}
