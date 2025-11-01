public class MergeSort {
    
    // Main merge sort function
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;
            
            // Recursively sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    
    // Function to merge two sorted subarrays
    private static void merge(int[] arr, int left, int mid, int right) {
        // Calculate sizes of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }
        
        // Merge the temporary arrays back into arr[left..right]
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of leftArr[], if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of rightArr[], if any
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    // Main method to test the implementation
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 88, 76, 50, 42};
        
        System.out.println("Original array:");
        printArray(arr);
        
        mergeSort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted array:");
        printArray(arr);
    }
}