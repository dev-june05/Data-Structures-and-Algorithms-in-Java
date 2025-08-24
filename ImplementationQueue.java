import java.util.*;

class Queue<T> {

    private final T[] arr;
    private int F;
    private int R;
    private final int capacity;

    public Queue(int size) {
        arr = (T[]) new Object[size];
        capacity = size;
        F = -1;
        R = -1;
    }

    public void enqueue(T data) {
        if (R == capacity - 1) throw new RuntimeException("Queue Overflow.");
        if (R == -1) { 
            F = 0;
        }
        arr[++R] = data;
    }

    public T dequeue() {
        if (F == -1 || F > R) throw new RuntimeException("Queue Underflow.");
        T value = arr[F];
        F++;
        return value;
    }
}

public class ImplementationQueue {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of queue: ");
        int size = sc.nextInt();
        Queue<Integer> queue = new Queue<>(size);

        System.out.println("How many elements to enqueue?");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int element = sc.nextInt();
            queue.enqueue(element);
        }

        System.out.println("Dequeuing element: " + queue.dequeue());
        System.out.println("Dequeuing element: " + queue.dequeue());
        sc.close();
    }
}
