package GoodQuestions;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start <= end){
            int mid = start + (end - start) / 2;
            boolean isBad = isBadVersion(mid);
            
            if(mid != 1 && !isBadVersion(mid - 1) && isBad){
                return mid;
            } else if(isBad) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }

    public static void main(String[] args) {
        
    }
}
