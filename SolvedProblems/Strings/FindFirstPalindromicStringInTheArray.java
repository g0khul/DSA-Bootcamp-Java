public class FindFirstPalindromicStringInTheArray {
    public static void main(String[] args) {
        String[] words = { "abc", "car", "ada", "racecar", "cool" };
        System.out.println(firstPalindrome(words));
    }

    public static String firstPalindrome(String[] words) {
        for (String string : words) {
            boolean isPalindrome = true;
            for (int start = 0, end = string.length() - 1; start < end; start++, end--) {
                if (string.charAt(start) != string.charAt(end)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                return string;
            }
        }

        return "";
    }
}
