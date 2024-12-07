public class LLQueue<T>
{
    private Node<T> head;
    private Node<T> tail;

    class Node<T> 
    {
        T data;
        Node<T> next;

        Node(T data) 
        {
            this.data = data;
            this.next = null;
        }
    }

    public LLQueue() 
    {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(T data) 
    {
        Node<T> newNode = new Node<>(data);
        if (tail != null) 
        {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) 
        {
            head = newNode;
        }
    }

    public T dequeue() 
    {
        if (head == null) 
        {
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head == null) 
        {
            tail = null;
        }
        return data;
    }

    public T peek() 
    {
        if (head == null) 
        {
            return null;
        }
        return head.data; // Return the process of the head node if it isn't null
    }

    public void print() 
    {
        Node<T> current = head;
        while (current != null) 
        {
            System.out.print(current.data + "\n");
            current = current.next; // Loop through each node and print all the processs
        }
        System.out.println();
    }
}