public class MinHeap<T extends Comparable<T>> 
{
    private T[] heap;
    private int lastIndex;

    public MinHeap(int size) 
	{
        heap = (T[]) new Comparable[size];
        lastIndex = 0;
    }

    public void add(T data)
	{
        if (lastIndex >= heap.length) 
	    {
            return;
        }
        heap[lastIndex] = data;
        bubbleUp();
        lastIndex++;
    }

    public T remove() 
	{
        if (lastIndex == 0) 
	    {
            return null;
        }

        T data = heap[0];
        heap[0] = heap[lastIndex - 1];
        heap[lastIndex - 1] = null;
        lastIndex--;
        bubbleDown();
        return data;
    }

    private void bubbleUp() 
	{
        int index = lastIndex;
        while (index > 0 && heap[(index - 1) / 2].compareTo(heap[index]) > 0)
	    {
            swap((index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    private void bubbleDown() 
	{
        int index = 0;
        while (index * 2 + 1 < lastIndex) 
	    {
            int smallerIndex = index * 2 + 1;
            if (index * 2 + 2 < lastIndex && heap[index * 2 + 1].compareTo(heap[index * 2 + 2]) > 0)
	        {
                smallerIndex = index * 2 + 2;
            }
            if (heap[index].compareTo(heap[smallerIndex]) > 0) 
	        {
                swap(index, smallerIndex);
            } 
            else 
	        {
                break;
            }
            index = smallerIndex;
        }
    }

    private void swap(int indexOne, int indexTwo) 
	{
        T temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    public boolean isEmpty() 
	{
        return lastIndex == 0;
    }
}