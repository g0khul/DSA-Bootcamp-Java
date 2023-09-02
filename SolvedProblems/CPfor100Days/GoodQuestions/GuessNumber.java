package GoodQuestions;
public class GuessNumber {
    public static int guessNumber(int n) {
        int start = 1;
        int end = (int) Math.pow(2, 31) - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            int val = guess(mid);
            if(val == 0){
                return mid;
            } else if(val == -1){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 2147483647; 
    }

    // Specific to leetcode API So I can't write the logic for it
    private static int guess(int mid) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(5));
    }
}
