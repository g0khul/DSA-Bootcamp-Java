public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }

        if (s.length() == 0) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int maxLength = 0;

        String result = "";
        while (end < s.length()) {
            result = s.substring(start, end + 1);
            end = end + 1;

            if (!isUnique(result)) {
                start = start + 1;
            } else if (maxLength < result.length()) {
                System.out.println(result);
                maxLength = result.length();
            }
        }

        return maxLength;
    }

    private static boolean isUnique(String processed) {
        if (processed.length() > 128) {
            return false;
        }

        boolean[] marker = new boolean[128];
        for (int i = 0; i < processed.length(); i++) {
            int val = processed.charAt(i);
            if (marker[val]) {
                return false;
            }
            marker[val] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "abcbacbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
