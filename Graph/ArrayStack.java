
/**
* Write a description of class ArrayStack here.
* 
* @author Brandon 
* @version (a version number or a date)
*/
@SuppressWarnings("unchecked")
public class ArrayStack<T> implements StackInterface<T>
{
    int size;
    T[] meh;
    public ArrayStack(){
        size = 0;
        meh = (T[]) new Object[4];
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        return size == 0;
    }

    public T peek() throws StackUnderflowException{
        if(size == 0)
            throw new StackUnderflowException();
        else 
            return meh[size -1];
    }

    public T pop() throws StackUnderflowException{
        if(size == 0)
            throw new StackUnderflowException();
        else
        {
            T temp = meh[size -1];
            meh[size -1] = null;
            size--;
            return temp;
        }
    }

    public void doTheThing(){
        if(size == meh.length){
            T[] newLog = (T[])new Object[meh.length * 2];
            for(int i = 0; i < meh.length; i++)
                newLog[i] = meh[i];
            meh = newLog;
        }
    }

    public T push(T item){
        doTheThing();
        if(size == 0)
        {
            meh[0] = item;
            size++;
            return meh[0];
        }
        T oho = meh[size - 1];	
        meh[size] = item;
        size++;
        return oho;
    }

    public void clear(){
        int seze = size;
        for(int i = 0; i < seze; i++){
            pop();
        }
        size = 0;
    }

    public int search(Object o){
        ArrayStack meh2 = new ArrayStack();
        int saveMeh = -1;
        int dontLieToMe = size;
        for(int i = 0; i < dontLieToMe; i ++){
            meh2.push(pop());
            if(o.equals(meh2.peek()))
                saveMeh = i;
        }
        for(int z = dontLieToMe -1; z >= 0; z--)
            push((T)meh2.pop());
        if(saveMeh == -1)
            return -1;
        return saveMeh + 1;
    }
}
