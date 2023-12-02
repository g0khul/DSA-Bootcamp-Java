package LLD.HuffmanCoding;

public class Main {
    public static void main(String[] args) throws Exception {
        String str = "abbccda";

        HuffmanCoding coding = new HuffmanCoding(str);

        String encode = coding.encode(str);
        System.out.println(encode);

        String decode = coding.decode(encode);
        System.out.println(decode);
    }
}
