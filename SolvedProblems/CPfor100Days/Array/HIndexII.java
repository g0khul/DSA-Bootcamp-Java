

public class HIndexII {
    public int hIndex(int[] citations) {
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
}
