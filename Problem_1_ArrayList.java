import java.util.ArrayList;
import java.util.Scanner;

public class Problem_1_ArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
        System.out.print("Enter the number of elements in ArrayList: ");
        int initialSize = scanner.nextInt();
        
        if (initialSize > 0) {
            System.out.println("Enter " + initialSize + " elements:");
            for (int i = 0; i < initialSize; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                list.add(scanner.nextInt());
            }
            System.out.print("Current list: ");
            printList(list);
        } else {
            System.out.println("Starting with empty ArrayList.");
        }
        
        String[] menuOptions = {
            "Add element at end", "Add element at beginning", "Add at position",
            "Remove first", "Remove last", "Remove at position", "Search element",
            "Update at position", "Reverse list", "Display list", "Get size",
            "Check if empty", "Clear list", "Exit"
        };
        
        while (true) {
            System.out.println("\n=== ArrayList Operations ===");
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
                    list.add(0, scanner.nextInt());
                    System.out.println("Added successfully!");
                    break;
                    
                case 3:
                    System.out.print("Enter element and position: ");
                    int element = scanner.nextInt();
                    int position = scanner.nextInt();
                    if (position >= 0 && position <= list.size()) {
                        list.add(position, element);
                        System.out.println("Added successfully!");
                    } else {
                        System.out.println("Invalid position!");
                    }
                    break;
                    
                case 4:
                    if (!list.isEmpty()) {
                        int removed = list.remove(0);
                        System.out.println("Removed: " + removed);
                    } else {
                        System.out.println("List is empty!");
                    }
                    break;
                    
                case 5:
                    if (!list.isEmpty()) {
                        int removed = list.remove(list.size() - 1);
                        System.out.println("Removed: " + removed);
                    } else {
                        System.out.println("List is empty!");
                    }
                    break;
                    
                case 6:
                    System.out.print("Enter position: ");
                    int pos = scanner.nextInt();
                    if (pos >= 0 && pos < list.size()) {
                        int removed = list.remove(pos);
                        System.out.println("Removed: " + removed);
                    } else {
                        System.out.println("Invalid position!");
                    }
                    break;
                    
                case 7:
                    System.out.print("Enter element to search: ");
                    int searchElement = scanner.nextInt();
                    int searchPos = list.indexOf(searchElement);
                    System.out.println(searchPos != -1 ? "Found at position: " + searchPos : "Not found!");
                    break;
                    
                case 8:
                    System.out.print("Enter new value and position: ");
                    int newValue = scanner.nextInt();
                    int updatePos = scanner.nextInt();
                    if (updatePos >= 0 && updatePos < list.size()) {
                        list.set(updatePos, newValue);
                        System.out.println("Updated successfully!");
                    } else {
                        System.out.println("Invalid position!");
                    }
                    break;
                    
                case 9:
                    reverseList(list);
                    System.out.println("List reversed!");
                    break;
                    
                case 10:
                    System.out.print("Current list: ");
                    printList(list);
                    break;
                    
                case 11:
                    System.out.println("Size: " + list.size());
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
    
    private static void printList(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
    
    private static void reverseList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(list.size() - 1 - i));
            list.set(list.size() - 1 - i, temp);
        }
    }
} 