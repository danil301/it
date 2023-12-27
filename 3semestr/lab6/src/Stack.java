import java.util.Arrays;

public class Stack<T> {
    private T[] data;
    private int size;

    public Stack()
    {
        data = (T[]) new Object[10];
        size = 0;
    }

    public Stack(int capacity)
    {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element)
    {
        ensureCapacity();
        data[size] = element;
        size++;
    }

    public T pop()
    {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T element = data[size - 1];
        size--;
        return element;
    }

    public T peek()
    {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return data[size - 1];
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    private void ensureCapacity()
    {
        if (size == data.length)
        {
            int newCapacity = data.length * 2;
            data = Arrays.copyOf(data, newCapacity);
        }
    }
}
