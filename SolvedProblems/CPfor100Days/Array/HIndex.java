import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = { 3, 0, 6, 1, 5 };
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        countSort(citations);

        int start = 0;
        int end = citations.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (citations[mid] >= citations.length - mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return citations.length - start;
    }

    private static void countSort(int[] citations) {
        int max = Arrays.stream(citations).max().getAsInt();

        int[] frequency = new int[max + 1];

        for (int i = 0; i < citations.length; i++) {
            frequency[citations[i]]++;
        }

        for (int f = 0, r = 0; f < max + 1;) {
            if (frequency[f] != 0) {
                citations[r++] = f;
                frequency[f]--;
            } else {
                f++;
            }
        }
    }
}