public class ScoreOfAString {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(scoreOfString(s));
    }

    public static int scoreOfString(String s) {
        int result = 0;
        int prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            int curr = (int) Math.abs(prev - s.charAt(i));
            result += curr;
            prev = s.charAt(i);
        }
        return result;
    }
}
