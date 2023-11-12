
public class SortSentence {
    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        int[] index = new int[words.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = words[i].charAt(words[i].length() - 1) - 48;
            words[i] = words[i].substring(0, words[i].length() - 1);
        }
        
        String[] result = new String[index.length];
        for (int i = 0; i < result.length; i++) {
            result[index[i] - 1] = words[i];
        }

        return String.join(" ", result);
    }

    public static void main(String[] args) {
        String str = "is2 sentence4 This1 a3";
        str = sortSentence(str);    
        System.out.println(str);    
    }
}
