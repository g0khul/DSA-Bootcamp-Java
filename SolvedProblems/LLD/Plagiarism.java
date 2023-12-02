package LLD;

import java.util.*;

public class Plagiarism {

    public static int plagiarismCount(String[] para1Arr, String[] para2Arr) {
        int count = 0;
        for (int i = 0; i < para1Arr.length; i++) {
            // Just ignoring some words that no matter any paragraph will have
            if (para1Arr[i] != "the" && para1Arr[i] != "The" && para1Arr[i] != "is" && para1Arr[i] != "a"
                    && para1Arr[i] != "and")
                for (int j = 0; j < para2Arr.length; j++) {
                    if (para1Arr[i] == para2Arr[j])
                        count++;
                }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first paragraph:\n");
        String para1 = sc.nextLine();
        System.out.println("Enter the second paragraph:\n");
        String para2 = sc.nextLine();

        String[] para1Arr = para1.trim().split("\\s+");
        String[] para2Arr = para2.trim().split("\\s+");

        // The condition becomes true only if minimum of 40% of the words in the
        // paragraph 1 is repeated in the paragraph 2
        if (plagiarismCount(para1Arr, para2Arr) / para1Arr.length * 100 >= 40)
            System.out.println("The second paragraph contains plagiarism");
        else
            System.out.println("The second paragraph does not contain plagarism");
    }
}
