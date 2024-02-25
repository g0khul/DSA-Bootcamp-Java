import java.util.Arrays;

public class QuickSortDuplicate {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 7, 1, 9, 6, 8, 4 };
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            while (arr[start] < arr[mid]) {
                start++;
            }

            while (arr[end] > arr[mid]) {
                end--;
            }

            if(start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}
