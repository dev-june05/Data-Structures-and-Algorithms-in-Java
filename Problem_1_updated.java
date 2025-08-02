import java.util.Scanner;

class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    
    public LinkedList() {
        head = null;
    }
    
    private Node getNodeAt(int position) {
        if (position < 0) return null;
        Node current = head;
        for (int i = 0; i < position && current != null; i++) {
            current = current.next;
        }
        return current;
    }
    
    private Node getLastNode() {
        if (head == null) {
        return null;
    }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
    
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        getLastNode().next = newNode;
    }
    
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void addAtPosition(int data, int position) {
        if (position < 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 0) {
            addFirst(data);
            return;
        }
        
        Node prev = getNodeAt(position - 1);
        if (prev == null) {
            System.out.println("Position out of bounds! Adding at the end.");
            add(data);
            return;
        }
        
        Node newNode = new Node(data);
        newNode.next = prev.next;
        prev.next = newNode;
    }
    
    public int removeFirst() {
        if (head == null) return -1;
        int data = head.data;
        head = head.next;
        return data;
    }
    
    public int removeLast() {
        if (head == null) return -1;
        if (head.next == null) {
            int data = head.data;
            head = null;
            return data;
        }
        
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int data = current.next.data;
        current.next = null;
        return data;
    }
    
    public int removeAtPosition(int position) {
        if (head == null || position < 0) return -1;
        if (position == 0) return removeFirst();
        
        Node prev = getNodeAt(position - 1);
        if (prev == null || prev.next == null) return -1;
        
        int data = prev.next.data;
        prev.next = prev.next.next;
        return data;
    }
    
    public int search(int data) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == data) return position;
            current = current.next;
            position++;
        }
        return -1;
    }
    
    public boolean updateAtPosition(int newData, int position) {
        Node node = getNodeAt(position);
        if (node == null) return false;
        node.data = newData;
        return true;
    }
    
    public void reverse() {
        Node prev = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public int getSize() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public void print() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public void clear() {
        head = null;
    }
}

public class Problem_1_updated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();
        
        System.out.print("Enter the number of elements in LinkedList: ");
        int initialSize = scanner.nextInt();
        
        if (initialSize > 0) {
            System.out.println("Enter " + initialSize + " elements:");
            for (int i = 0; i < initialSize; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                list.add(scanner.nextInt());
            }
            System.out.print("Current list: ");
            list.print();
        } else {
            System.out.println("Starting with empty LinkedList.");
        }
        
        String[] menuOptions = {
            "Add element at end", "Add element at beginning", "Add at position",
            "Remove first", "Remove last", "Remove at position", "Search element",
            "Update at position", "Reverse list", "Display list", "Get size",
            "Check if empty", "Clear list", "Exit"
        };
        
        while (true) {
            System.out.println("\n=== LinkedList Operations ===");
            for (int i = 0; i < menuOptions.length; i++) {
                System.out.println((i + 1) + ". " + menuOptions[i]);
            }
            System.out.print("Enter choice (1-" + menuOptions.length + "): ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    list.add(scanner.nextInt());
                    System.out.println("Added successfully!");
                    break;
                    
                case 2:
                    System.out.print("Enter element: ");
                    list.addFirst(scanner.nextInt());
                    System.out.println("Added successfully!");
                    break;
                    
                case 3:
                    System.out.print("Enter element and position: ");
                    list.addAtPosition(scanner.nextInt(), scanner.nextInt());
                    System.out.println("Added successfully!");
                    break;
                    
                case 4:
                    int removed = list.removeFirst();
                    System.out.println(removed != -1 ? "Removed: " + removed : "List is empty!");
                    break;
                    
                case 5:
                    removed = list.removeLast();
                    System.out.println(removed != -1 ? "Removed: " + removed : "List is empty!");
                    break;
                    
                case 6:
                    System.out.print("Enter position: ");
                    removed = list.removeAtPosition(scanner.nextInt());
                    System.out.println(removed != -1 ? "Removed: " + removed : "Invalid position!");
                    break;
                    
                case 7:
                    System.out.print("Enter element to search: ");
                    int pos = list.search(scanner.nextInt());
                    System.out.println(pos != -1 ? "Found at position: " + pos : "Not found!");
                    break;
                    
                case 8:
                    System.out.print("Enter new value and position: ");
                    System.out.println(list.updateAtPosition(scanner.nextInt(), scanner.nextInt()) ? 
                        "Updated successfully!" : "Invalid position!");
                    break;
                    
                case 9:
                    list.reverse();
                    System.out.println("List reversed!");
                    break;
                    
                case 10:
                    System.out.print("Current list: ");
                    list.print();
                    break;
                    
                case 11:
                    System.out.println("Size: " + list.getSize());
                    break;
                    
                case 12:
                    System.out.println(list.isEmpty() ? "List is empty!" : "List is not empty!");
                    break;
                    
                case 13:
                    list.clear();
                    System.out.println("List cleared!");
                    break;
                    
                case 14:
                    System.out.println("Thank you!");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice!");
            }
            
            System.out.print("Continue? (y/n): ");
            if (scanner.next().startsWith("n")) {
                System.out.println("Thank you!");
                scanner.close();
                System.exit(0);
            }
        }
    }
}
