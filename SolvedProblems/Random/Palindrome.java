class Palindrome {

    public static boolean isPalindrome(int x) {

        // All negative numbers will always be false
        if (x < 0)
            return false;

        // All single digit number will always be true
        else if (x >= 0 && x <= 9)
            return true;

        // For number from 10
        else {
            String strX = "" + x;

            // Incrementing strCount string size with respect to true conditions
            String strCount = "";

            for (int i = 0; i < strX.length(); i++)
                if (i == strCount.length() - 1 - i)
                    strCount += "a";
                else if (strX.charAt(i) == strX.charAt(strX.length() - 1 - i))
                    strCount = strCount + "a";

            // Checking if original value's (strX) length with value obtained strCount
            if (strX.length() == strCount.length())
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {
        int x = 101;
        System.out.println(isPalindrome(x));
    }
}