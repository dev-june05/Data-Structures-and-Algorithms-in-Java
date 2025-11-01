public class SelectionSort {
    
    // Method to perform selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        System.out.println("Original array: " + arrayToString(arr));
        System.out.println();
        
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the remaining unsorted array
            int current = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[current]) {
                    current = j;
                }
            }
            
            // Swap the found minimum element with the first element
            if (current != i) {
                int temp = arr[i];
                arr[i] = arr[current];
                arr[current] = temp;
                
                System.out.println("Pass " + (i + 1) + ": Swapped " + arr[current] + 
                                 " and " + arr[i] + " → " + arrayToString(arr));
            } else {
                System.out.println("Pass " + (i + 1) + ": No swap needed → " + arrayToString(arr));
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
    
    // Method to demonstrate the algorithm step by step
    public static void selectionSortDetailed(int[] arr) {
        int n = arr.length;
        
        System.out.println("DETAILED SELECTION SORT DEMONSTRATION");
        System.out.println("=====================================");
        System.out.println("Original array: " + arrayToString(arr));
        System.out.println();
        
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Pass " + (i + 1) + ":");
            System.out.println("  Looking for minimum in: " + arrayToString(arr, i, n - 1));
            
            int current = i;
            for (int j = i + 1; j < n; j++) {
                System.out.println("    Comparing " + arr[j] + " with current minimum " + arr[current]);
                if (arr[j] < arr[current]) {
                    current = j;
                    System.out.println("    New minimum found: " + arr[current] + " at index " + current);
                }
            }
            
            if (current != i) {
                System.out.println("  Swapping " + arr[i] + " and " + arr[current]);
                int temp = arr[i];
                arr[i] = arr[current];
                arr[current] = temp;
            } else {
                System.out.println("  No swap needed - element already in correct position");
            }
            
            System.out.println("  Result: " + arrayToString(arr));
            System.out.println();
        }
    }
    
    // Helper method to show a portion of array
    public static String arrayToString(int[] arr, int start, int end) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i <= end; i++) {
            sb.append(arr[i]);
            if (i < end) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    // Method to analyze performance
    public static void analyzePerformance(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;
        
        System.out.println("PERFORMANCE ANALYSIS");
        System.out.println("===================");
        System.out.println("Array size: " + n);
        System.out.println("Expected comparisons: " + (n * (n - 1) / 2));
        System.out.println("Maximum possible swaps: " + (n - 1));
        System.out.println();
        
        for (int i = 0; i < n - 1; i++) {
            int current = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[current]) {
                    current = j;
                }
            }
            
            if (current != i) {
                int temp = arr[i];
                arr[i] = arr[current];
                arr[current] = temp;
                swaps++;
            }
        }
        
        System.out.println("Actual comparisons made: " + comparisons);
        System.out.println("Actual swaps made: " + swaps);
        System.out.println();
    }
    
    // Main method to test the selection sort
    public static void main(String[] args) {
        // Example array from the explanation
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("SELECTION SORT IMPLEMENTATION");
        System.out.println("=============================");
        System.out.println();
        
        // Make a copy for detailed demonstration
        int[] arrCopy = arr.clone();
        
        // Basic selection sort
        selectionSort(arr);
        
        System.out.println();
        System.out.println("Final sorted array: " + arrayToString(arr));
        
        // Detailed demonstration
        System.out.println("\n" + "=".repeat(50));
        selectionSortDetailed(arrCopy);
        
        // Performance analysis
        System.out.println("=".repeat(50));
        int[] arrForAnalysis = {64, 34, 25, 12, 22, 11, 90};
        analyzePerformance(arrForAnalysis);
        
        // Test with different array
        System.out.println("=".repeat(50));
        System.out.println("TESTING WITH ANOTHER ARRAY");
        System.out.println("=".repeat(50));
        
        int[] arr2 = {5, 2, 8, 1, 9, 3};
        System.out.println();
        selectionSort(arr2);
        System.out.println();
        System.out.println("Final sorted array: " + arrayToString(arr2));
    }
}
