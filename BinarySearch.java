apublic class BinarySearch {
    
    // Iterative implementation of binary search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoids overflow
            
            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in right half
            } else {
                right = mid - 1; // Search in left half
            }
        }
        
        return -1; // Target not found
    }
    
    // Recursive implementation of binary search
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Target not found
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid; // Target found
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right); // Search right half
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1); // Search left half
        }
    }
    
    // Helper method for recursive binary search
    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }
    
    // Main method to test the implementation
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;
        
        System.out.println("Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        // Test iterative binary search
        int result1 = binarySearch(arr, target);
        if (result1 != -1) {
            System.out.println("Iterative Binary Search: Target " + target + " found at index " + result1);
        } else {
            System.out.println("Iterative Binary Search: Target " + target + " not found");
        }
        
        // Test recursive binary search
        int result2 = binarySearchRecursive(arr, target);
        if (result2 != -1) {
            System.out.println("Recursive Binary Search: Target " + target + " found at index " + result2);
        } else {
            System.out.println("Recursive Binary Search: Target " + target + " not found");
        }
        
        // Test with target not in array
        int notFound = binarySearch(arr, 20);
        if (notFound == -1) {
            System.out.println("Target 20 not found in the array");
        }
        
        // Test with different targets
        System.out.println("\nTesting with different targets:");
        int[] targets = {1, 9, 15, 20, -1};
        for (int t : targets) {
            int index = binarySearch(arr, t);
            System.out.println("Target " + t + ": " + (index != -1 ? "Found at index " + index : "Not found"));
        }
    }
}
