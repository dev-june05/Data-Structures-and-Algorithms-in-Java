public class LinearSearch {

    /**
     * Performs a linear search on an array to find a target element.
     *
     * @param arr The array to search within.
     * @param target The element to search for.
     * @return The index of the target element if found, otherwise -1.
     */
    public static int linearSearch(int[] arr, int target) {
        int i = 0;
        while(arr[i]!=target){
            if (i == arr.length-1) {
                return -1; // Element not found in the array
            }
            i++;
        }
        return i; // Element found at index i 
    }

    public static void main(String[] args) {
        int[] numbers = {30,20,1,7,45};
        int searchTarget2 = 60;

        // int index1 = linearSearch(numbers, searchTarget1);
        // if (index1 != -1) {
        //     System.out.println(searchTarget1 + " found at index: " + index1);
        // } else {
        //     System.out.println(searchTarget1 + " not found in the array.");
        // }

        int index2 = linearSearch(numbers, searchTarget2);
        if (index2 != -1) {
            System.out.println(searchTarget2 + " found at index: " + index2);
        } else {
            System.out.println(searchTarget2 + " not found in the array.");
        }
    }
}