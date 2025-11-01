public class BubbleSort {
    
    // Method to perform bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        System.out.println("Original array: " + arrayToString(arr));
        System.out.println();
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // Print the array after each pass
            System.out.println("Pass " + (i + 1) + ": " + arrayToString(arr));
            
            // If no swapping occurred, array is sorted
            if (!swapped) {
                System.out.println("Array is sorted! No more passes needed.");
                break;
            }
        }
    }
    
    // Method to convert array to string for display
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    // Main method to test the bubble sort
    public static void main(String[] args) {
        // Example array from the explanation
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("BUBBLE SORT IMPLEMENTATION");
        System.out.println("==========================");
        System.out.println();
        
        // Perform bubble sort
        bubbleSort(arr);
        
        System.out.println();
        System.out.println("Final sorted array: " + arrayToString(arr));
        
        // Additional test with different array
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TESTING WITH ANOTHER ARRAY");
        System.out.println("=".repeat(50));
        
        int[] arr2 = {5, 2, 8, 1, 9, 3};
        System.out.println();
        bubbleSort(arr2);
        System.out.println();
        System.out.println("Final sorted array: " + arrayToString(arr2));
    }
}
