
/**
 * Write a description of class ArrayQueue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayQueue<T> implements QueueInterface<T>
{
    T[] meh;
    int size= 0;
    int stupid = 0;
    int assignment = 0;
    int hemmeh;
    public ArrayQueue(){
        meh = (T[])new Object[4];
        hemmeh = 4;
        assignment = meh.length -1;
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        return size == 0;
    }

    public void resize(){
        if(size == meh.length)
        {
            T[] mehh = (T[])new Object[meh.length *2];
            for(int i = 0; i < size; i ++){
                mehh[i] = meh[stupid];
                stupid = (stupid +1)% meh.length;
            }
            meh = mehh;
            stupid = 0;
            assignment = size -1;
        }
    }

    public T add(T hem){
        resize();
        size++;
        assignment = (assignment +1)% meh.length;
        meh[assignment] = hem;
        return hem;
    }

    public T peek() throws QueueUnderflowException{
        if(size == 0)
            throw new QueueUnderflowException("Nope");
        return meh[stupid];
    }

    public T remove() throws QueueUnderflowException{
        if(size == 0)
            throw new QueueUnderflowException("Nope");
        T mehhhhh = meh[stupid];
        meh[stupid] = null;
        size--;
        stupid = (stupid +1) % meh.length;
        return mehhhhh;
    }

    public void clear(){
        while(size > 0)
        remove();
    }
}
