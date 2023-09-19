
import java.util.Arrays;

public class ReverseCapitalize {
    public static void main(String[] args) {
        String str = "Hello World Abcd";
        // Expected output: Olleh Dlrow Dcba
        // If returned with toString() [O, l, l, e, h,  , D, l, r, o, w,  , D, c, b, a]
        System.out.println(reverseCapitalize(str));
    }

    private static String reverseCapitalize(String str) {
        if(str.length() == 0){
            return "";
        }

        char[] arr = str.toCharArray();
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            if(arr[end] == ' '){
                arr = rotate(arr, start, end - 1);
                start = end + 1;
            }
            if(end == arr.length - 1){
                arr = rotate(arr,start, end);
            }
        }

        // String result = "";
        // for(char c : arr){
        //     result += c;
        // }
        // return result;
        return Arrays.toString(arr);
    }

    private static char[] rotate(char[] arr, int start, int end) {
        arr[start] = (char) (arr[start] + 32);
        arr[end] = (char) (arr[end] - 32);
        for (int i = start, j = 0; i <= (start + end) / 2; i++, j++) {
            char temp = arr[i];
            arr[i] = arr[end - j];
            arr[end - j] = temp;
        }
        return arr;
    }
}
