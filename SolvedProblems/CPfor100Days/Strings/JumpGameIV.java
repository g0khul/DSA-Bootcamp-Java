
public class JumpGameIV {
    public static void main(String[] args) {
        String s = "011010";
        int minJump = 2;
        int maxJump = 3;
        System.out.println(canReach(s, minJump, maxJump));
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        return helper(s, minJump, maxJump, 0);
    }

    private static boolean helper(String s, int minJump, int maxJump, int index) {
        if (index == s.length() - 1) {
            return true;
        }

        if (index >= s.length()) {
            return false;
        }

        boolean result = false;
        for (int i = index + minJump; i <= Math.min(i + maxJump, s.length() - 1); i++) {
            if (s.charAt(i) == '0') {
                result = helper(s, minJump, maxJump, i);
                if (result) {
                    break;
                }
            }
        }

        return result;
    }
}
