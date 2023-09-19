package Recursion;
public class SortedArrayOrNot {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        if(isSorted(arr)){
            System.out.println("Array is sorted");
        } else {
            System.out.println("Not sorted");
        }
    }

    private static boolean isSorted(int[] arr) {
        return helper(arr, 0);
    }

    private static boolean helper(int[] arr, int i) {
        if(i == arr.length - 1){
            return true;
        }

        if(arr[i] > arr[i + 1]){
            return false;
        }

        return helper(arr, i + 1);
    }
}
