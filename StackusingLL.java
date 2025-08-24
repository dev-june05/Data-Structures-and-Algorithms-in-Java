class StackNode<T> {
    T data;
    StackNode<T> next;

    public StackNode(T data) {
        this.data = data;
        this.next = null;
    }
}

public class StackusingLL<T> {
    StackNode<T> head;
    StackNode<T> current;

    public StackusingLL() {
        head = null;
        current = head;
    }

    public void addFirst(T data) {
        StackNode<T> newNode = new StackNode<T>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new RuntimeException("Stack Underflow.");
        }
        head = head.next;
    }

    public void printStack() {
        if (head == null) {
            throw new RuntimeException("Stack Underflow.");
        }
        current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackusingLL<Integer> s1 = new StackusingLL<Integer>();
        s1.addFirst(10);
        s1.printStack();
        s1.addFirst(20);
        s1.printStack();
        s1.addFirst(30);
        s1.printStack();
        s1.addFirst(40);
        s1.printStack();
        s1.addFirst(50);
        s1.printStack();
        
        s1.deleteFirst();
        s1.printStack();
        s1.deleteFirst();
        s1.printStack();
        s1.deleteFirst();
        s1.printStack();
        s1.deleteFirst();
        s1.printStack();
        s1.deleteFirst();
        s1.printStack();
        s1.deleteFirst();
        s1.printStack();
    }
}