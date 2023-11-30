package CPfor100Days.Strings;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'M':
                    result += 1000;
                    break;

                case 'D':
                    result += 500;
                    break;

                case 'C':
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'D') {
                            result += 400;
                            i++;
                            break;
                        } else if (s.charAt(i + 1) == 'M') {
                            result += 900;
                            i++;
                            break;
                        }
                    }
                    result += 100;
                    break;

                case 'L':
                    result += 50;
                    break;

                case 'X':
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'L') {
                            result += 40;
                            i++;
                            break;
                        } else if (s.charAt(i + 1) == 'C') {
                            result += 90;
                            i++;
                            break;
                        }
                    }
                    result += 10;
                    break;

                case 'V':
                    result += 5;
                    break;

                case 'I':
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'V') {
                            result += 4;
                            i++;
                            break;
                        } else if (s.charAt(i + 1) == 'X') {
                            result += 9;
                            i++;
                            break;
                        }
                    }
                    result += 1;
                    break;

                default:
                    break;
            }
        }

        return result;
    }
}
