package SolvedProblems.Random;

public class ReverseArray {

    public static void swap(int arr[], int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        for (int start = 0, end = arr.length - 1; start < end; start++, end--)
            swap(arr, start, end);

        for (int c : arr)
            System.out.print(c + " ");
    }
}
