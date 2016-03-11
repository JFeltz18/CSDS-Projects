import java.util.ArrayList;
/**
 * This Sorts object represents a class that perform
 * Bubble, Selection, Insertion, Merge, Quick, and Heap sorts
 * 
 * @author  Tom Bredemeier
 * @version April 10, 2013
 */
public class Sorts extends SortUtilities
{

    public Sorts(String[] array)
    {
        super(array);
    }

    // The array to be sorted is a String array called 'array'

    // Whenever you need to swap two elements in 'array', call the 'swap(int a, int b)' method 
    // where a and b are the indices of the elements in 'array' that need to be swapped.  Every
    // time 'swap' is called, a snapshot of the array is taken, which is later used to 
    // compare against an exemplar (test example) to see if all of the swaps are correct.

    // All of your sorting methods should utilize 'in-place' sorting, meaning that elements
    // are always swapped, rather than being copied out to a temporary variable, and then copied 
    // back later.

    // Feel free to write any private helper methods you wish to use

    public void bubbleSort()    // ascending, bubbling up from beginning to end
    {
        boolean notFound = true;
        int temp;

        while (notFound)
        {
            notFound = false;
            for(int i = 0; i < array.length - 1; i++)
            {
                if (array[i].compareTo(array[i + 1]) > 0)
                {
                    swap(i, i + 1);
                    notFound = true; 
                } 
            } 
        } 
    }

    public void selectionSort() // ascending, selecting the maximum values
    {
        for (int end = array.length;end > 0; end--)
        {
            int index = 0;
            String max = array[index];
            for (int i = 1; i < end; i++)
            {
                if (array[i].compareTo(array[index]) > 0)
                {
                    index = i;
                    max = array[i];
                }
            }
            if (index != end - 1)
            {
                swap(index, end - 1);
            }
        }
    }

    public void insertionSort() // ascending, inserting values on the front end
    {
        for (int i = 1; i < array.length; i++)
        {
            int index = i;
            while (index > 0 && array[index].compareTo(array[index - 1]) < 0)
            {
                swap(index - 1, index);
                index--;
            }
        }
    }

    public void mergeSort() // ascending, working from front to back
    {
        mergeSort(0, array.length - 1);
    }

    public void mergeSort(int first, int last) 
    {
        if (first < last)
        {
            int middle = (first + last) / 2;
            mergeSort(first, middle);
            mergeSort(middle + 1, last);
            merge(first, middle, middle + 1, last);
        }

    }

    public void merge(int leftFirst, int leftLast, int rightFirst, int rightLast)
    {
        if (array[rightFirst].compareTo(array[leftLast]) > 0)
        {
            return;
        }
        while (leftFirst <= leftLast && rightFirst <= rightLast)
        {
            if (array[rightFirst].compareTo(array[leftFirst]) > 0)
            {
                leftFirst++;
            }
            else
            {
                for (int i = rightFirst; i > leftFirst; i--)
                {
                    swap(i, i - 1);
                }
                leftFirst++; leftLast++; rightFirst++;
            }
        }
    }

    public void quickSort() // ascending, working from front to back
    {
        quickSort(0, array.length - 1);
    }
    
    public void quickSort(int first, int last)
    {
        if (first < last)
        {
            int splitValue = split(first, last);
            quickSort(0, splitValue);
            quickSort(splitValue + 1, last);
        }
    }

    public int split(int first, int last)
    {
        String splitVal = array[first];
        int saveFirst = first;
        first++;
        while (first <= last)
        {
            boolean onCorrectSide = true;
            while (onCorrectSide)
            {
                if (array[first].compareTo(splitVal) > 0)
                {
                    onCorrectSide = false;
                }
                else
                {
                    first++;
                    onCorrectSide = (first <= last);
                }
            }
            onCorrectSide = (first <= last);
            while (onCorrectSide)
            {
                if (array[last].compareTo(splitVal) <= 0)
                {
                    onCorrectSide = false;
                }
                else
                {
                    last--;
                    onCorrectSide = (first <= last);
                }
            }
            if (first < last)
            {
                swap(first, last);
                first++; last--;
            }            
        }
        if (saveFirst != last)
        {
            swap(saveFirst, last);
        }
        return last;
    }
    
    public void heapSort()  // ascending
    {
        // Note that the 'reheapDown' and 'newHole' methods are already provided
        // in the abstract parent class (SortUtilities) for your use.
        for (int index = (array.length / 2) - 1; index >= 0; index--)
        {
            reheapDown(array[index], index, array.length - 1);
        }
        for (int index = array.length - 1; index >= 0; index--)
        {
            swap(0, index);
            System.out.println(index);
            if (index < 5)
            {
                boolean sorted = true;
                int previous = 0;
                for (int i = 1; i <= index; i++)
                {
                    if (array[i].compareTo(array[previous]) < 0)
                    {
                        sorted = false;
                    }
                    previous++;
                }
                if (sorted)
                {
                    return;
                }
            }
            reheapDown(array[0], 0, index - 1);
        }
    }
}
