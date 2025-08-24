
import java.util.Scanner;

class Stack<T> {

    private final T[] arr;
    private int top;
    private final int capacity;

    public Stack(int size) {
        arr = (T[]) new Object[size];
        capacity = size;
        top = -1;
    }

    public void push(T data) {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack Overflow.");
        }
        arr[++top] = data;
    }

    public T pop() {
        if (top == -1) {
            throw new RuntimeException("Stack Underflow.");
        }
        return arr[top--];
    }

    public T peek() {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack Overflow.");
        }
        return arr[top];
    }
}

public class ImplementationStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of stack: ");
        int size = sc.nextInt();
        Stack<Integer> stack = new Stack<>(size);
        System.out.println("How many elements to push?");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int element = sc.nextInt();
            stack.push(element);
        }
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popping top: " + stack.pop());
        System.out.println("Top element: " + stack.peek());
        sc.close();
    }
}
