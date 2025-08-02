// Implementation of LinkedList in Java

// Node class to represent a single node in the list
class Node {
    int data;     // Value stored in the node
    Node next;    // Reference to the next node

    // Constructor to initialize a new node with given data
    public Node(int data) {
        this.data = data;
        this.next = null;  // Next pointer is initially null
    }
}

// LinkedList class to manage the list operations
class LinkedList {
    Node head;  // Pointer to the first node in the list

    // Constructor initializes an empty list
    public LinkedList() {
        head = null;
    }

    // Adds a node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);  // Create a new node

        // If list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Otherwise, traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Link the last node to the new node
        current.next = newNode;
    }

    // Adds a node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);  // Create a new node
        newNode.next = head;            // Point it to current head
        head = newNode;                 // Update head to this new node
    }

    // Removes the first node from the list and returns its data
    public int removeFirst() {
        if (head == null) {
            return -1;  // Return -1 if list is empty
        }

        int data = head.data;  // Store the value of the head node
        head = head.next;      // Move head to the next node
        return data;           // Return removed node's data
    }

    // Prints the size (number of nodes) in the list
    public void size() {
        // Special case: empty list
        if (head == null) {
            System.out.println("Size of the list is: 0");
            return;
        }

        int count = 1;               // Start counting from head
        Node current = head;
        while (current.next != null) {
            current = current.next;
            count++;                 // Increment count for each node
        }

        System.out.println("Size of the list is: " + count);
    }

    // Prints the entire list in a readable format
    public void print() {
        Node current = head;         // Start from the head
        while (current != null) {
            System.out.print(current.data + " -> ");  // Print current node
            current = current.next;                   // Move to next node
        }
        System.out.println("null");  // End of the list
    }
}

// Main class to test the LinkedList functionality
public class Problem_1 {
    public static void main(String[] args) {
        LinkedList obj = new LinkedList();  // Create a LinkedList object

        // Add elements to the end of the list
        obj.add(10);
        obj.add(20);
        obj.add(30);
        obj.print();     // Output: 10 -> 20 -> 30 -> null
        obj.size();      // Output: Size of the list is: 3

        // Add element to the beginning
        obj.addFirst(1);
        obj.print();     // Output: 1 -> 10 -> 20 -> 30 -> null
        obj.size();      // Output: Size of the list is: 4

        // Remove the first element
        obj.removeFirst();
        obj.print();     // Output: 10 -> 20 -> 30 -> null
        obj.size();      // Output: Size of the list is: 3
    }
}
